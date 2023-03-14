package com.srn.erp.ventas.op;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LabelTranslator;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionPedido extends Operation {
	
	private LabelTranslator lt = null;
	ClasificadorEntidad clasifEnt1 = null;
	ClasificadorEntidad clasifEnt2 = null;
	int secu = 0;
	CalculadorMoney totAcumItems = new CalculadorMoney(new Money(0));
	private Idioma idioma = null;
	private boolean soloPendEnt = false;
	
	
	private CalculadorMoney calcAcumcBruto = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumDto = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumRec = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumNeto = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumIVA = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumIVA2 = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumPercIVA = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumImpInt = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumPercIB = new CalculadorMoney(new Money(0));
	private CalculadorMoney calcAcumTotal = new CalculadorMoney(new Money(0));
	

	public ImpresionPedido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		idioma = Idioma.getIdiomaLocal(this.getSesion());
		if (mapaDatos.containsKey("solo_pend_ent"))
			soloPendEnt = true; 
		
		if (mapaDatos.containsKey("tipo_formato_pedido")) {
			if (mapaDatos.getInteger("tipo_formato_pedido").intValue()==2)
				impresionMatricial(mapaDatos);
			else
				impresionEstandar(mapaDatos);			
		} else impresionEstandar(mapaDatos);

	}
	
	public void impresionEstandar(MapDatos mapaDatos) throws BaseException {

		IDataSet dsPedidoCab = getDataSetPedidoCab();
		IDataSet dsPedidoDet = getDataSetPedidoDet();
		IDataSet dsLabels = getDataSetLabels();

		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(PedidoCab.NICKNAME);
		lt.setIdioma(idioma);				
		
		PedidoCab pedidoCab = PedidoCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		
		if ((pedidoCab.getSujeto()!=null) && (pedidoCab.getSujeto().getIdioma()!=null))
			lt.setIdioma(pedidoCab.getSujeto().getIdioma());

		cargarRegistroPedidoCab(dsPedidoCab,pedidoCab);
		Iterator iterDetallesPedidos = pedidoCab.getDetallesActivos().iterator();
		while (iterDetallesPedidos.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterDetallesPedidos.next();
			
			if (pedidoDet.isAnulado()) continue;
			
			if (soloPendEnt) 
				if (!pedidoDet.isPendDesp()) continue;
			
			cargarRegistroPedidoDet(dsPedidoDet, pedidoCab, pedidoDet, !iterDetallesPedidos.hasNext());
		}
		
		cargarEtiquetas(dsLabels);

		writeCliente(dsPedidoCab);
		writeCliente(dsPedidoDet);
		writeCliente(dsLabels);
	}
	
	public void impresionMatricial(MapDatos mapaDatos) throws BaseException {

		clasifEnt1 = ClasificadorEntidad.getClasif1ImpOCMatriz(this.getSesion());
		clasifEnt2 = ClasificadorEntidad.getClasif2ImpOCMatriz(this.getSesion());
		
		
		IDataSet dsPedidoCab = getDataSetPedidoCab();
		IDataSet dsProductosGrales = getDataSetProductosGral();
		IDataSet dsLabels = getDataSetLabels();
		IDataSet dsProdMatriz = getDataSetProductosMatricial();
		IDataSet dsTotResu = this.getDataSetTolalesResumen();
		
		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(PedidoCab.NICKNAME);
		lt.setIdioma(idioma);
		
		PedidoCab pedidoCab = PedidoCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		
		if ((pedidoCab.getSujeto()!=null) && (pedidoCab.getSujeto().getIdioma()!=null))
			lt.setIdioma(pedidoCab.getSujeto().getIdioma());

		cargarRegistroPedidoCab(dsPedidoCab,pedidoCab);
		
		impresionItemsProdGral(dsProductosGrales, dsProdMatriz , pedidoCab);
		cargarTotResu(dsTotResu, pedidoCab, totAcumItems.getResultMoney());
		
		cargarEtiquetas(dsLabels);

		writeCliente(dsPedidoCab);
		writeCliente(dsProductosGrales);
		writeCliente(dsLabels);
		writeCliente(dsProdMatriz);
		writeCliente(dsTotResu);
		
	}


	private IDataSet getDataSetPedidoCab() {
			IDataSet dataset = new TDataSet();
			dataset.create("TPedidoCab");
			
			// Datos de la empresa
			dataset.fieldDef(new Field("empresa_oid", Field.INTEGER, 0));
			dataset.fieldDef(new Field("empresa_codigo", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_razon_social", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_direccion", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_localidad", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_cp", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_oid_provincia", Field.INTEGER, 0));
			dataset.fieldDef(new Field("empresa_cod_provincia", Field.STRING, 50));
			dataset.fieldDef(new Field("empresa_desc_provincia", Field.STRING, 100));
			dataset.fieldDef(new Field("empresa_oid_pais", Field.INTEGER, 0));
			dataset.fieldDef(new Field("empresa_cod_pais", Field.STRING, 50));
			dataset.fieldDef(new Field("empresa_desc_pais", Field.STRING, 100));
			
			// Datos de la Sucursal
			dataset.fieldDef(new Field("sucursal_oid", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_codigo", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_razon_social", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_direccion", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_localidad", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_cp", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_oid_provincia", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_cod_provincia", Field.STRING, 50));
			dataset.fieldDef(new Field("sucursal_desc_provincia", Field.STRING, 100));
			dataset.fieldDef(new Field("sucursal_oid_pais", Field.INTEGER, 0));
			dataset.fieldDef(new Field("sucursal_cod_pais", Field.STRING, 50));
			dataset.fieldDef(new Field("sucursal_desc_pais", Field.STRING, 100));
								
			// Datos de la Sucursal
			
			dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_tc",Field.STRING, 50));
			dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_cliente", Field.STRING, 30));
			dataset.fieldDef(new Field("rz_cliente", Field.STRING, 100));
			dataset.fieldDef(new Field("letra", Field.STRING, 0));
			dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
			dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_cliente", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
			dataset.fieldDef(new Field("desc_moneda", Field.STRING, 50));
			dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("mercado", Field.STRING, 1));
			dataset.fieldDef(new Field("porc_bonif_cli", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("porc_reca_cli", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("bonif_cli_cascada", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("reca_cli_cascada", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("oid_precio_cab", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_lp", Field.STRING, 30));
			dataset.fieldDef(new Field("desc_lp", Field.STRING, 100));
			dataset.fieldDef(new Field("path_logo_sucursal", Field.STRING, 255));
			dataset.fieldDef(new Field("oid_cond_pago", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_cond_pago", Field.STRING, 30));
			dataset.fieldDef(new Field("desc_cond_pago", Field.STRING, 100));
			dataset.fieldDef(new Field("oid_vendedor", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_vendedor", Field.STRING, 30));
			dataset.fieldDef(new Field("desc_vendedor", Field.STRING, 100));
			dataset.fieldDef(new Field("vendedor_mail", Field.STRING, 100));
			dataset.fieldDef(new Field("vendedor_telefono", Field.STRING, 100));
			dataset.fieldDef(new Field("oid_uni_edi", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_uni_edi", Field.STRING, 30));
			dataset.fieldDef(new Field("desc_uni_edi", Field.STRING, 50));
			dataset.fieldDef(new Field("dom_ent_dir_completa", Field.STRING, 255));
			dataset.fieldDef(new Field("porc_bonif_cp", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("porc_reca_cp", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("bonif_cp_cascada", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("reca_cp_cascada", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("observado", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("comentario", Field.STRING, 255));
			dataset.fieldDef(new Field("fec_emision", Field.STRING, 10));
			dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
			dataset.fieldDef(new Field("oid_transporte", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_transporte", Field.STRING, 50));
			dataset.fieldDef(new Field("desc_transporte", Field.STRING, 100));
			dataset.fieldDef(new Field("oid_moneda_fact", Field.INTEGER, 0));
			dataset.fieldDef(new Field("oid_forma_entrega", Field.INTEGER, 0));
			dataset.fieldDef(new Field("cod_forma_entrega", Field.STRING, 50));
			dataset.fieldDef(new Field("desc_forma_entrega", Field.STRING, 100));
			dataset.fieldDef(new Field("orden_compra", Field.STRING, 50));
			
			dataset.fieldDef(new Field("impre_bruto", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_porc_dto", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_descuento", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_porc_recar", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_recargo", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_neto", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_iva", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_perc_iva", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_imp_internos", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_perc_ib", Field.CURRENCY, 0));
			dataset.fieldDef(new Field("impre_total", Field.CURRENCY, 0));
			
			dataset.fieldDef(new Field("label_porc_iva", Field.STRING, 20));
			dataset.fieldDef(new Field("label_porc_iva_2", Field.STRING, 20));
			dataset.fieldDef(new Field("label_porc_perc_iva", Field.STRING, 20));
			
			dataset.fieldDef(new Field("contacto", Field.STRING, 100));
			dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
			dataset.fieldDef(new Field("leyenda_anulado", Field.STRING, 50));
			
			dataset.fieldDef(new Field("nro_ver_ext", Field.INTEGER, 0));
			dataset.fieldDef(new Field("nota_adic_iva", Field.STRING, 255));
			
			dataset.fieldDef(new Field("label_total", Field.STRING, 255));
			dataset.fieldDef(new Field("label_pend_entrega", Field.STRING, 255));
			
			return dataset;
	}
	
	private IDataSet getDataSetTolalesResumen() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTotResumen");
		
		// Datos de la empresa
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		
		return dataset;
	}
	
	private void cargarTotResu(IDataSet ds,
			PedidoCab pedido,
			Money totResumen) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cco", pedido.getOIDInteger());
		if (soloPendEnt)
			ds.fieldValue("total", "");
		else
			ds.fieldValue("total", totResumen);
		
	}
	

	private IDataSet getDataSetPedidoDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPedidoDet");
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_art", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));;
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_um_ori", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_um_ori", Field.STRING, 20));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_lista", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_sugerido", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("precio_bonif", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("bonif1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("bonif3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_entrega", Field.DATE,0));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN,0));
		dataset.fieldDef(new Field("oid_conc_imp_iva", Field.INTEGER, 0));; 
		dataset.fieldDef(new Field("oid_conc_imp_perc_iva", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("oid_conc_imp_int", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));
		
	  	dataset.fieldDef(new Field("acum_bruto", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_descuento", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_recargo", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_neto", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_iva", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_iva_2", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_perc_iva", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_imp_int", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_perc_ib", Field.CURRENCY, 0));
	  	dataset.fieldDef(new Field("acum_total", Field.CURRENCY, 0));
		
		
		return dataset;
	}
	
	private void enviarDatosEmpresa(IDataSet dataset) throws BaseException {
	
		
		Empresa empresa = Empresa.findByOidProxy(this.getSesion().getLogin().getOidEmpresa(),this.getSesion());
		
		
		dataset.fieldValue("empresa_oid", empresa.getOIDInteger());
		dataset.fieldValue("empresa_codigo", empresa.getCodigo());
		dataset.fieldValue("empresa_razon_social", empresa.getRazon_social());
		dataset.fieldValue("empresa_direccion", empresa.getCalle_y_nro());
		dataset.fieldValue("empresa_localidad", empresa.getLocalidad());
		dataset.fieldValue("empresa_cp", empresa.getCodigo_postal());
		
		if (empresa.getProvincia()!=null) {
			dataset.fieldValue("empresa_oid_provincia", empresa.getProvincia().getOIDInteger());
			dataset.fieldValue("empresa_cod_provincia", empresa.getProvincia().getCodigo());
			dataset.fieldValue("empresa_desc_provincia", empresa.getProvincia().getDescripcion());
		} else {
			dataset.fieldValue("empresa_oid_provincia", 0);
			dataset.fieldValue("empresa_cod_provincia", "");
			dataset.fieldValue("empresa_desc_provincia", "");
		}
		
		if (empresa.getPais()!=null) {
			dataset.fieldValue("empresa_oid_pais", empresa.getPais().getOIDInteger());
			dataset.fieldValue("empresa_cod_pais", empresa.getPais().getCodigo());
			dataset.fieldValue("empresa_desc_pais", empresa.getPais().getDescripcion());
		} else {
			dataset.fieldValue("empresa_oid_pais", 0);
			dataset.fieldValue("empresa_cod_pais", "");
			dataset.fieldValue("empresa_desc_pais", "");
		}
		
	}
	
	private void enviarDatosSucursal(IDataSet dataset) throws BaseException {

		Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(),this.getSesion());
		
		
		dataset.fieldValue("sucursal_oid", sucursal.getOIDInteger());
		dataset.fieldValue("sucursal_codigo", sucursal.getCodigo());
		dataset.fieldValue("sucursal_razon_social", sucursal.getDescripcion());
		dataset.fieldValue("sucursal_direccion", sucursal.getCalle_y_nro());
		dataset.fieldValue("sucursal_localidad", sucursal.getLocalidad());
		dataset.fieldValue("sucursal_cp", sucursal.getCodigo_postal());
		
		if (sucursal.getProvincia()!=null) {
			dataset.fieldValue("sucursal_oid_provincia", sucursal.getProvincia().getOIDInteger());
			dataset.fieldValue("sucursal_cod_provincia", sucursal.getProvincia().getCodigo());
			dataset.fieldValue("sucursal_desc_provincia", sucursal.getProvincia().getDescripcion());
		} else {
			dataset.fieldValue("sucursal_oid_provincia", 0);
			dataset.fieldValue("sucursal_cod_provincia", "");
			dataset.fieldValue("sucursal_desc_provincia", "");
		}
		
		if (sucursal.getPais()!=null) {
			dataset.fieldValue("sucursal_oid_pais", sucursal.getPais().getOIDInteger());
			dataset.fieldValue("sucursal_cod_pais", sucursal.getPais().getCodigo());
			dataset.fieldValue("sucursal_desc_pais", sucursal.getPais().getDescripcion());
		} else {
			dataset.fieldValue("sucursal_oid_pais", 0);
			dataset.fieldValue("sucursal_cod_pais", "");
			dataset.fieldValue("sucursal_desc_pais", "");
		}

	}
	
	
	private void cargarRegistroPedidoCab(IDataSet dataset,PedidoCab pedidoCab) throws BaseException {
		dataset.append();
		
		enviarDatosEmpresa(dataset);
		enviarDatosSucursal(dataset);
		
		dataset.fieldValue("oid_cco_ped", pedidoCab.getOIDInteger());
		dataset.fieldValue("oid_talonario",pedidoCab.getTalonario().getOIDInteger());
		dataset.fieldValue("cod_tc",pedidoCab.getTcExt());
		dataset.fieldValue("oid_tc", pedidoCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_cliente", pedidoCab.getSujeto().getCodigo());
		dataset.fieldValue("rz_cliente", pedidoCab.getSujeto().getRazon_social());
		dataset.fieldValue("letra", pedidoCab.getLetra());
		dataset.fieldValue("lug_emi", pedidoCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", pedidoCab.getNroExt());
		dataset.fieldValue("oid_cliente", pedidoCab.getSujeto().getOIDInteger());
		dataset.fieldValue("oid_moneda", pedidoCab.getMoneda().getOIDInteger());
		dataset.fieldValue("desc_moneda", pedidoCab.getMoneda().getDescripcion());
		dataset.fieldValue("cotizacion", pedidoCab.getCotizacion().doubleValue());
		dataset.fieldValue("mercado", pedidoCab.getMercado());
		dataset.fieldValue("porc_bonif_cli", pedidoCab.getPorc_bonif_cli());
		dataset.fieldValue("porc_reca_cli", pedidoCab.getPorc_reca_cli());
		dataset.fieldValue("bonif_cli_cascada", pedidoCab.isBonif_cli_cascada());
		dataset.fieldValue("reca_cli_cascada", pedidoCab.isReca_cli_cascada());
		dataset.fieldValue("oid_precio_cab", pedidoCab.getLista_precios().getOIDInteger());
		dataset.fieldValue("cod_lp", pedidoCab.getLista_precios().getCodigo());
		dataset.fieldValue("desc_lp", pedidoCab.getLista_precios().getDescripcion());
		dataset.fieldValue("path_logo_sucursal", pedidoCab.getSucursal().getPathLogo());
		
		if (pedidoCab.getCondicionPago()!=null) {
		  dataset.fieldValue("oid_cond_pago", pedidoCab.getCondicionPago().getOIDInteger());
		  dataset.fieldValue("cod_cond_pago", pedidoCab.getCondicionPago().getCodigo());
		  dataset.fieldValue("desc_cond_pago", pedidoCab.getCondicionPago().getDescripcion());
		} else {
		  dataset.fieldValue("oid_cond_pago", 0);
		  dataset.fieldValue("cod_cond_pago", "");
		  dataset.fieldValue("desc_cond_pago", "");
		}
		
		// Datos del Vendedor
		
		dataset.fieldValue("oid_vendedor", pedidoCab.getVendedor().getOIDInteger());
		dataset.fieldValue("cod_vendedor", pedidoCab.getVendedor().getCodigo());
		dataset.fieldValue("desc_vendedor", pedidoCab.getVendedor().getNombre()+ " " + pedidoCab.getVendedor().getApellido());		
		dataset.fieldValue("vendedor_mail", pedidoCab.getVendedor().getMail());
		dataset.fieldValue("vendedor_telefono", pedidoCab.getVendedor().getTelefono());		
		
		if (pedidoCab.getDomicilio_entrega()!=null) {
		  dataset.fieldValue("oid_uni_edi", pedidoCab.getDomicilio_entrega().getOID());
		  dataset.fieldValue("cod_uni_edi", pedidoCab.getDomicilio_entrega().getCodigo());
		  dataset.fieldValue("desc_uni_edi", pedidoCab.getDomicilio_entrega().getDescripcion());
		  dataset.fieldValue("dom_ent_dir_completa", pedidoCab.getDomicilio_entrega().getDireccionCompleta());
		} else {
		  dataset.fieldValue("oid_uni_edi", 0);
		  dataset.fieldValue("cod_uni_edi", "");
		  dataset.fieldValue("desc_uni_edi", "");
		  dataset.fieldValue("dom_ent_dir_completa", "");
		}
		
		dataset.fieldValue("porc_bonif_cp", pedidoCab.getPorc_bonif_cp());
		dataset.fieldValue("porc_reca_cp", pedidoCab.getPorc_reca_cp());
		dataset.fieldValue("bonif_cp_cascada", pedidoCab.isBonif_cp_cascada());
		dataset.fieldValue("reca_cp_cascada", pedidoCab.isReca_cp_cascada());
		dataset.fieldValue("observado", pedidoCab.isObservado());
		dataset.fieldValue("comentario",  pedidoCab.getComentarioMasObsCodif(idioma));
		dataset.fieldValue("fec_emision", pedidoCab.getEmision());
		dataset.fieldValue("activo", pedidoCab.isActivo());
		if (pedidoCab.getTransporte()!=null) {
		  dataset.fieldValue("oid_transporte", pedidoCab.getTransporte().getOIDInteger());
		  dataset.fieldValue("cod_transporte", pedidoCab.getTransporte().getCodigo());
		  dataset.fieldValue("desc_transporte", pedidoCab.getTransporte().getDescripcion());
		} else {
		  dataset.fieldValue("oid_transporte", 0);
		  dataset.fieldValue("cod_transporte", "");
		  dataset.fieldValue("desc_transporte", "");			
		}
		dataset.fieldValue("oid_moneda_fact", pedidoCab.getMonedaFact().getOIDInteger());
		
		if (pedidoCab.getFormaEntrega()!=null) {
		  dataset.fieldValue("oid_forma_entrega", pedidoCab.getFormaEntrega().getOIDInteger());
		  dataset.fieldValue("cod_forma_entrega", pedidoCab.getFormaEntrega().getCodigo());
		  dataset.fieldValue("desc_forma_entrega", pedidoCab.getFormaEntrega().getDescripcion());
		} else {
		  dataset.fieldValue("oid_forma_entrega", 0);
		  dataset.fieldValue("cod_forma_entrega", "");
		  dataset.fieldValue("desc_forma_entrega", "");
		}
		dataset.fieldValue("orden_compra", pedidoCab.getOrdenDeCompra());
		
		dataset.fieldValue("impre_bruto", pedidoCab.getImpre_bruto());
		dataset.fieldValue("impre_porc_dto", pedidoCab.getImprePorcBonif());
		dataset.fieldValue("impre_descuento", pedidoCab.getImpre_bonif());
		dataset.fieldValue("impre_porc_recar", pedidoCab.getImprePorcRecar());
		dataset.fieldValue("impre_recargo", pedidoCab.getImpre_recar());
		dataset.fieldValue("impre_neto", pedidoCab.getImpre_neto());
		dataset.fieldValue("impre_iva", pedidoCab.getImpre_iva());
		dataset.fieldValue("impre_perc_iva", pedidoCab.getImpre_perc_iva());
		dataset.fieldValue("impre_imp_internos", pedidoCab.getImpre_imp_int());
		dataset.fieldValue("impre_perc_ib", pedidoCab.getImpre_perc_ib());
		dataset.fieldValue("impre_total", pedidoCab.getImpre_total());
		
		if ((pedidoCab.getConcImpuIVA()!=null) && (pedidoCab.getConcImpuIVA().getColumnalibroiva()!=null))
		   dataset.fieldValue("label_porc_iva", pedidoCab.getConcImpuIVA().getColumnalibroiva().getDescripcion());
		else
			 dataset.fieldValue("label_porc_iva", "");
		
		if ((pedidoCab.getConcImpuIVA2()!=null) && (pedidoCab.getConcImpuIVA2().getColumnalibroiva()!=null))
			   dataset.fieldValue("label_porc_iva_2", pedidoCab.getConcImpuIVA2().getColumnalibroiva().getDescripcion());
			else
			   dataset.fieldValue("label_porc_iva_2", "");
		
		
		if ((pedidoCab.getConcImpuPercIVA()!=null) && (pedidoCab.getConcImpuPercIVA().getColumnalibroiva()!=null))
			dataset.fieldValue("label_porc_perc_iva", pedidoCab.getConcImpuPercIVA().getColumnalibroiva().getDescripcion());
		else
			dataset.fieldValue("label_porc_perc_iva", "");
		
		if (pedidoCab.getContactoSujeto()!=null)
			dataset.fieldValue("contacto", pedidoCab.getContactoSujeto().getNombreYApellido());
		else
			dataset.fieldValue("contacto", "");
		
		dataset.fieldValue("observacion", pedidoCab.getComentario());
		if (pedidoCab.isActivo().booleanValue() == false)
		  dataset.fieldValue("leyenda_anulado" , "ANULADO");
		else
			dataset.fieldValue("leyenda_anulado" , "");
		
		dataset.fieldValue("nro_ver_ext", pedidoCab.getComprobanteImpreso().getVersion_externa());
	
		if (soloPendEnt)
			dataset.fieldValue("nota_adic_iva", "");
		else
			if (pedidoCab.getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA())
				dataset.fieldValue("nota_adic_iva", lt.getEtiqueta("SYS_LABEL_NOTA_ADIC_IVA"));
			else
				dataset.fieldValue("nota_adic_iva", lt.getEtiqueta("SYS_LABEL_NOTA_IVA_INCLU")); 

		if (soloPendEnt) {
			dataset.fieldValue("label_total", "");
			dataset.fieldValue("label_pend_entrega", lt.getEtiqueta("SYS_LABEL_PEND_ENT"));
		}
		else {
			dataset.fieldValue("label_total", lt.getEtiqueta("SYS_LABEL_TOTAL"));
			dataset.fieldValue("label_pend_entrega", "");
		}
		
		
		
	}
	
	private void cargarRegistroPedidoDet(IDataSet dataset, 
										 PedidoCab pedidoCab, 
										 PedidoDet pedidoDet,
										 boolean esUltimoItem) throws BaseException {
		
		if (pedidoDet.isAnulado().booleanValue()) return ;
		
		dataset.append();
		dataset.fieldValue("nro_renglon", pedidoDet.getNroRenglon());
		dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
		dataset.fieldValue("oid_cco_ped", pedidoCab.getOIDInteger());
		dataset.fieldValue("oid_art", pedidoDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
		dataset.fieldValue("oid_um_ori", pedidoDet.getUni_med_ori().getOIDInteger());
		dataset.fieldValue("desc_um_ori", pedidoDet.getUni_med_ori().getLabelImpresion());
		if (soloPendEnt) 
			dataset.fieldValue("cantidad", pedidoDet.getCantPendDespUniOri());
		else
			dataset.fieldValue("cantidad", pedidoDet.getCant_um_ori());
		dataset.fieldValue("precio", pedidoDet.getPrecio());
		dataset.fieldValue("precio_lista", pedidoDet.getPrecio_lista());
		dataset.fieldValue("precio_sugerido", new Money(0));
		if (soloPendEnt) {
			dataset.fieldValue("precio_bonif", "");
			dataset.fieldValue("importe", "");
		} else {
			dataset.fieldValue("precio_bonif", pedidoDet.getPrecio_bonif());
			dataset.fieldValue("importe", pedidoDet.getImporte());
		}
		dataset.fieldValue("oid_moneda", pedidoDet.getMoneda().getOIDInteger());
		dataset.fieldValue("activo", pedidoDet.isActivo());
		dataset.fieldValue("bonif1", pedidoDet.getBonif1());
		dataset.fieldValue("bonif2", pedidoDet.getBonif2());
		dataset.fieldValue("bonif3", pedidoDet.getBonif3());
		dataset.fieldValue("comentario", pedidoDet.getComentario());
		dataset.fieldValue("fec_entrega", pedidoDet.getFechaEntrega());
		dataset.fieldValue("activo", new Boolean(true));
		
		if (pedidoDet.getConcImpuIVA()!=null)
			dataset.fieldValue("oid_conc_imp_iva", pedidoDet.getConcImpuIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_iva", new Integer(0));
		if (pedidoDet.getConcImpuPercIVA()!=null)
			dataset.fieldValue("oid_conc_imp_perc_iva", pedidoDet.getConcImpuPercIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
		if (pedidoDet.getConcImpuInt()!=null)
			dataset.fieldValue("oid_conc_imp_int", pedidoDet.getConcImpuInt().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_int", new Integer(0));
		if (pedidoDet.getConcImpuPercIB()!=null)
			dataset.fieldValue("oid_conc_imp_perc_ib", pedidoDet.getConcImpuPercIB().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
		
		calcAcumTotal.sumar(pedidoDet.getImporte());
		
		if (esUltimoItem) {
			if (soloPendEnt) {
				dataset.fieldValue("acum_bruto", "");
				dataset.fieldValue("acum_descuento", "");
				dataset.fieldValue("acum_recargo", "");
				dataset.fieldValue("acum_neto", "");
				dataset.fieldValue("acum_iva", "");
				dataset.fieldValue("acum_iva_2", "");
				dataset.fieldValue("acum_perc_iva", "");
				dataset.fieldValue("acum_imp_int", "");
				dataset.fieldValue("acum_perc_ib", "");
				dataset.fieldValue("acum_total", "");
			} else { 
				dataset.fieldValue("acum_bruto", pedidoCab.getImpre_bruto());
				dataset.fieldValue("acum_descuento", pedidoCab.getImpre_bonif());
				dataset.fieldValue("acum_recargo", pedidoCab.getImpre_recar());
				dataset.fieldValue("acum_neto", pedidoCab.getImpre_neto());
				dataset.fieldValue("acum_iva", pedidoCab.getImpre_iva());
				dataset.fieldValue("acum_iva_2", pedidoCab.getImpre_iva2());
				dataset.fieldValue("acum_perc_iva", pedidoCab.getImpre_perc_iva());
				dataset.fieldValue("acum_imp_int", pedidoCab.getImpre_imp_int());
				dataset.fieldValue("acum_perc_ib", pedidoCab.getImpre_perc_ib());
				dataset.fieldValue("acum_total", pedidoCab.getImpre_total());
			}
			
		} else {
			if (soloPendEnt) {
				dataset.fieldValue("acum_bruto", "");
				dataset.fieldValue("acum_descuento", "");
				dataset.fieldValue("acum_recargo", "");
				dataset.fieldValue("acum_neto", "");
				dataset.fieldValue("acum_iva", "");
				dataset.fieldValue("acum_iva_2", "");
				dataset.fieldValue("acum_perc_iva", "");
				dataset.fieldValue("acum_imp_int", "");
				dataset.fieldValue("acum_perc_ib", "");
				dataset.fieldValue("acum_total", "");
			} else {
				dataset.fieldValue("acum_bruto", calcAcumNeto.getResultMoney());
				dataset.fieldValue("acum_descuento", calcAcumDto.getResultMoney());
				dataset.fieldValue("acum_recargo", calcAcumRec.getResultMoney());
				dataset.fieldValue("acum_neto", calcAcumNeto.getResultMoney());
				dataset.fieldValue("acum_iva", calcAcumIVA.getResultMoney());
				dataset.fieldValue("acum_iva_2", calcAcumIVA2.getResultMoney());
				dataset.fieldValue("acum_perc_iva", calcAcumIVA.getResultMoney());
				dataset.fieldValue("acum_imp_int", calcAcumImpInt.getResultMoney());
				dataset.fieldValue("acum_perc_ib", calcAcumPercIB.getResultMoney());
				dataset.fieldValue("acum_total", calcAcumTotal.getResultMoney());
			}
		}
		
		
	}
	
	private void cargarEtiquetas(IDataSet ds) throws BaseException {
		Iterator iterEtiquetas = 
			EtiquetaIdioma.getEtiquetasComprobante(
					PedidoCab.NICKNAME,this.getSesion()).iterator();
		while (iterEtiquetas.hasNext()) {
			EtiquetaIdioma etiquetaIdioma = (EtiquetaIdioma) iterEtiquetas.next();
			String descripcion = lt.getEtiqueta(etiquetaIdioma.getEtiqueta());
			cargarEtiqueta(ds,etiquetaIdioma.getEtiqueta(),descripcion);
		}
	}
	
	
	private void cargarEtiqueta(IDataSet ds,String etiqueta,String descripcion) throws BaseException {
		ds.append();
		ds.fieldValue("etiqueta",etiqueta);
		ds.fieldValue("descripcion",descripcion);
	}
	
	private IDataSet getDataSetLabels() throws BaseException {
		IDataSet dataset = new TDataSet();
		dataset.create("TLabels");
		dataset.fieldDef(new Field("etiqueta", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.MEMO, 0));		
		return dataset;
	}
	
	private void impresionItemsProdGral(
			IDataSet dsProdGral,
			IDataSet dsProdMatriz,
			PedidoCab pedidoCab) throws BaseException {

		List renglones = new ArrayList();

		Iterator iterDetPedido = pedidoCab.getDetallesActivos().iterator();
		while (iterDetPedido.hasNext()) {
			PedidoDet pedidoDet = (PedidoDet) iterDetPedido.next();
			if (pedidoDet.isAnulado())
				continue;
			
			if (soloPendEnt)
				if (!pedidoDet.isPendDesp()) continue;

			
			RenglonProdGral renglonProdGral = findRenglonProdGral(pedidoDet,renglones);
			renglonProdGral.agregarCantidades(pedidoDet);

		}
		
		// Devolver los Productos Generales
		
		Iterator iterRenglones = renglones.iterator();
		while (iterRenglones.hasNext()) {
			RenglonProdGral renglonProdgral = (RenglonProdGral) iterRenglones.next();
			Collections.sort(renglonProdgral.listaLabels);
			Integer oidClave = ++secu;
			cargarRegistroProdGral(
					dsProdGral,
					oidClave,
					renglonProdgral,
					pedidoCab.getOIDInteger());
			
			
			// Devolver
			Iterator iterRenglonesProdGralClasifArt1 =
				renglonProdgral.renglonesProdGralClasifArt1.iterator();
			while (iterRenglonesProdGralClasifArt1.hasNext()) {
				RenglonProdGralClasifArt1  renglonProdGralClasifArt1 = (RenglonProdGralClasifArt1) iterRenglonesProdGralClasifArt1.next();
				cargarRenglonProdGralClasifArt1(pedidoCab,dsProdMatriz, renglonProdgral, renglonProdGralClasifArt1, oidClave);
			}
			
		}
		
	}
	
	private IDataSet getDataSetProductosMatricial() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProductoMatricial");
		dataset.fieldDef(new Field("oid_secu_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_val_clasif_art_2", Field.STRING, 50));
		dataset.fieldDef(new Field("label_col_1", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_2", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_3", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_4", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_5", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_6", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_7", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_8", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_9", Field.STRING, 20));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("um", Field.STRING, 20));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("acum_total", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		return dataset;
	}
	
	
	class RenglonProdGral {

		IValorClasificadorEntidad producto = null;
		String descAdicSKU = null;
		java.util.Date fechaEntrega;
		List listaLabels = new ArrayList();
		List renglonesProdGralClasifArt1 = new ArrayList();
		boolean isFullLabels = false;
		
		private CodValClasifArt2 findLabel(String label) throws BaseException {
			Iterator iterLabels = 
				listaLabels.iterator();
			while (iterLabels.hasNext()) {
				CodValClasifArt2 codValClasif = (CodValClasifArt2) iterLabels.next();
				if (codValClasif.valor.equals(label)) return codValClasif; 
			}
			return null;
		}

		public void agregarCantidades(PedidoDet pedidoDet)
				throws BaseException {
			
			
			// Agregar la Etiqueta
			IValorClasificadorEntidad valorClasifArt2 = pedidoDet.getProducto().getValorClasifEnt(clasifEnt2);
			String codigoLabel = "";
			if (valorClasifArt2 != null)
				codigoLabel = valorClasifArt2.getCodigo();
			
			CodValClasifArt2 codValClasifArt2 = findLabel(codigoLabel);
			if (codValClasifArt2 == null) {
				codValClasifArt2 = new CodValClasifArt2();
				codValClasifArt2.valor = codigoLabel;
				listaLabels.add(codValClasifArt2);
			}
			
			if (listaLabels.size() == 9)
				isFullLabels = true;
			
				
			boolean encontro = false;
			RenglonProdGralClasifArt1 renglonProdGralClasifArt1 = null;
			Iterator iterRenglonesProdGralClasifArt1 = renglonesProdGralClasifArt1.iterator();
			while (iterRenglonesProdGralClasifArt1.hasNext()) {
				renglonProdGralClasifArt1 = (RenglonProdGralClasifArt1) iterRenglonesProdGralClasifArt1.next();
				if (renglonProdGralClasifArt1.esIgualA(pedidoDet)) {
					renglonProdGralClasifArt1.agregarCantidades(pedidoDet);
					encontro = true;
					break;
				}
			}

			if (!encontro) {
				renglonProdGralClasifArt1 = new RenglonProdGralClasifArt1();
				renglonProdGralClasifArt1.valorClasifArt1 = pedidoDet.getProducto().getValorClasifEnt(clasifEnt1);
				renglonProdGralClasifArt1.cantidad = new Double(0);
				renglonProdGralClasifArt1.precio = pedidoDet.getPrecio_bonif().doubleValue();
				renglonProdGralClasifArt1.total = pedidoDet.getImporte().doubleValue();
				renglonProdGralClasifArt1.um = pedidoDet.getUni_med_ori();
				renglonProdGralClasifArt1.agregarCantidades(pedidoDet);
				renglonesProdGralClasifArt1.add(renglonProdGralClasifArt1);
			}
			
			// Acumular las cantidades en el renglon
			
			

		}
		
		public boolean isLabelEnRenglon(String labelValClasif2) throws BaseException {
			if (findLabel(labelValClasif2)!=null)
				return true;
			else
				return false;
		}

	}
	
	class RenglonProdGralClasifArt1 {

		IValorClasificadorEntidad valorClasifArt1 = null;
		Double cantidad = null;
		Double precio = null;
		Double total = null;
		UnidadMedida um;
		HashTableDatos listaCantidades = new HashTableDatos();

		private boolean esIgualA(PedidoDet pedidoDet) throws BaseException {

			boolean condValClasifArt1 = false;
			if ((pedidoDet.getProducto().getValorClasifEnt(clasifEnt1) == null)
					&& (this.valorClasifArt1 == null))
				condValClasifArt1 = true;
			else if ((pedidoDet.getProducto().getValorClasifEnt(clasifEnt1) != null)
					&& (this.valorClasifArt1 != null)
					&& (pedidoDet.getProducto().getValorClasifEnt(clasifEnt1).getOID() == this.valorClasifArt1.getOID())) {
				condValClasifArt1 = true;
			}

			boolean condPrecio = false;
			if ((pedidoDet.getPrecio_bonif() == null) && (this.precio == null))
				condPrecio = true;
			else if ((pedidoDet.getPrecio_bonif() != null)
					&& (this.precio != null)
					&& (pedidoDet.getPrecio_bonif().doubleValue() == this.precio.doubleValue())) {
				condPrecio = true;
			}
			
			boolean condUM = false;
			if ((pedidoDet.getUni_med_ori() == null) && (this.um == null))
				condUM = true;
			else if ((pedidoDet.getUni_med_ori() != null)
					&& (this.um != null)
					&& (pedidoDet.getUni_med_ori().getOID() == this.um.getOID())) {
				condUM = true;
			}
			
			if (condValClasifArt1 && condPrecio && condUM)
				return true;
			else
				return false;
		}
		
		private void agregarCantidades(PedidoDet pedidoDet) throws BaseException {

			// Acummlar las cantidades y cambiar el Total
			if (cantidad == null)
				cantidad = new Double(0);
			
			
			CalculadorMoney acumCant = new CalculadorMoney(new Money(0));
			if (soloPendEnt) 
				acumCant.sumar(pedidoDet.getCantPendDespUniOri());
			else
				acumCant.sumar(pedidoDet.getCant_um_ori());
									
			acumCant.sumar(new Money(cantidad));
			cantidad = acumCant.getResultMoney().doubleValue(); 
			
			if (precio == 0)
				precio = new Double(0);
			CalculadorMoney impTotal = new CalculadorMoney(new Money(precio));
			impTotal.multiplicarPor(acumCant.getResultMoney());
			total = impTotal.getResult();
			
			// Agregar las cantidades en el valor de clasificador 2 que corresponda
			String codValClasif2 = "";
			IValorClasificadorEntidad valClasif2 = pedidoDet.getProducto().getValorClasifEnt(clasifEnt2);
			if (valClasif2!= null)
				codValClasif2 = valClasif2.getCodigo(); 
			if (listaCantidades.get(codValClasif2)==null)
				listaCantidades.put(codValClasif2, new Double(pedidoDet.getCant_um_ori().doubleValue()));
			else {
				Double cant = (Double) listaCantidades.get(codValClasif2);
				CalculadorMoney acumCant1 = new CalculadorMoney(new Money(cant));
				acumCant1.sumar(new Money(pedidoDet.getCant_um_ori().doubleValue()));
				listaCantidades.put(codValClasif2, new Double(acumCant1.getResultMoney().doubleValue()));
			}
				
		}

	}
	
	private RenglonProdGral findRenglonProdGral(PedidoDet pedidoDet,
			List renglones) throws BaseException {

		Iterator iterRenglones = renglones.iterator();
		while (iterRenglones.hasNext()) {
			RenglonProdGral renglonProdGral = (RenglonProdGral) iterRenglones.next();

			if (pedidoDet.getProducto().getValorClasifProdGen() == null)
				throw new ExceptionValidation(null,"Falta definir el producto general para el producto de stock "+pedidoDet.getProducto().getCodigo()+" - "+pedidoDet.getProducto().getDescripcion());
			
			boolean condProducto = false;
			if ((renglonProdGral.producto.getOID() == pedidoDet.getProducto().getValorClasifProdGen().getOID()))
				condProducto = true;

			boolean condComentario = false;
			if ((pedidoDet.getComentario() == null)
					&& (renglonProdGral.descAdicSKU == null))
				condComentario = true;
			else if ((pedidoDet.getComentario() != null)
					&& (renglonProdGral.descAdicSKU != null)
					&& (pedidoDet.getComentario().equals(renglonProdGral.descAdicSKU)))
				condComentario = true;

			boolean condFecEntrega = false;
			if ((pedidoDet.getFechaEntrega() == null)
					&& (renglonProdGral.fechaEntrega == null))
				condFecEntrega = true;
			else if ((pedidoDet.getFechaEntrega() != null)
					&& (renglonProdGral.fechaEntrega != null)
					&& (pedidoDet.getFechaEntrega().equals(renglonProdGral.fechaEntrega)))
				condFecEntrega = true;

			if ((condProducto) && (condComentario) && (condFecEntrega)) {
				// clave existente
				String codValClasif2 = "";
				if (pedidoDet.getProducto().getValorClasifEnt(clasifEnt2)!=null)
					codValClasif2  = pedidoDet.getProducto().getValorClasifEnt(clasifEnt2).getCodigo();
				if (!((renglonProdGral.isFullLabels && (!renglonProdGral.isLabelEnRenglon(codValClasif2)))))
					return renglonProdGral;
			}

		}

		RenglonProdGral renglon = new RenglonProdGral();
		renglon.producto = pedidoDet.getProducto().getValorClasifProdGen();
		renglon.descAdicSKU = pedidoDet.getComentario();
		renglon.fechaEntrega = pedidoDet.getFechaEntrega();
		renglones.add(renglon);

		return renglon;

	}
	
	class CodValClasifArt2 implements Comparable {
		String valor;
		
		public int compareTo(Object arg0) {

			return valor.compareTo(((CodValClasifArt2)arg0).valor);

		}
		
	}
	
	private void cargarRegistroProdGral(IDataSet dsProdGral,
		     Integer secu,
		     RenglonProdGral renglonProdGral,
		     Integer oidCCO) throws BaseException {

	
	dsProdGral.append();
	dsProdGral.fieldValue("secu", new Integer(secu));
	dsProdGral.fieldValue("oid_prod_gral", renglonProdGral.producto.getOID());
	dsProdGral.fieldValue("cod_prod_gral", renglonProdGral.producto.getCodigo());
	dsProdGral.fieldValue("desc_prod_gral", renglonProdGral.producto.getDescripcion());
	dsProdGral.fieldValue("desc_prod_adic", renglonProdGral.descAdicSKU);
	for (int i=1;i<=9;++i) {
		
		if (renglonProdGral.listaLabels.size()<i)			
			dsProdGral.fieldValue("label_col_"+i, "");
		else
			dsProdGral.fieldValue("label_col_"+i, ((CodValClasifArt2)renglonProdGral.listaLabels.get(i-1)).valor);
	}
	dsProdGral.fieldValue("oid_cco", oidCCO);
	dsProdGral.fieldValue("fec_entrega", renglonProdGral.fechaEntrega);
	
   }
	
	private void cargarRenglonProdGralClasifArt1(
			PedidoCab pedido,
			IDataSet ds,
			RenglonProdGral renglonProdGral,
			RenglonProdGralClasifArt1 renglonProdGralClasifArt1,
			Integer clave) throws BaseException {
		
		ds.append();
		ds.fieldValue("oid_secu_det", new Integer(++secu));
		ds.fieldValue("oid_secu", clave);
		ds.fieldValue("desc_val_clasif_art_2", renglonProdGralClasifArt1.valorClasifArt1.getDescripcion());
		
		for (int i=1;i<=9;++i) {
			
			if (renglonProdGral.listaLabels.size()<i)			
				ds.fieldValue("label_col_"+i, "");
			else {
				String codValClasif2 = ((CodValClasifArt2)renglonProdGral.listaLabels.get(i-1)).valor;
				Double cant = (Double)renglonProdGralClasifArt1.listaCantidades.get(codValClasif2);
				if (cant!=null)
					ds.fieldValue("label_col_"+i, cant);
				else
					ds.fieldValue("label_col_"+i, "");
			}
		}
		
		totAcumItems.sumar(new Money(renglonProdGralClasifArt1.total));
		
		ds.fieldValue("cantidad", renglonProdGralClasifArt1.cantidad);
		ds.fieldValue("um", renglonProdGralClasifArt1.um.getLabelImpresion());
		
		if (soloPendEnt) {
			ds.fieldValue("precio", "");
			ds.fieldValue("total", "");
			ds.fieldValue("acum_total" , "");
		} else {
			ds.fieldValue("precio", renglonProdGralClasifArt1.precio);
			ds.fieldValue("total", renglonProdGralClasifArt1.total);
			ds.fieldValue("acum_total" ,  totAcumItems.getResult());
		}
		
		ds.fieldValue("oid_cco", pedido.getOIDInteger());

		
		
	}
	
	private IDataSet getDataSetProductosGral() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProductoGral");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_prod_gral", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_prod_gral", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_prod_gral", Field.STRING, 255));
		dataset.fieldDef(new Field("desc_prod_adic", Field.MEMO, 0));
		dataset.fieldDef(new Field("label_col_1", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_2", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_3", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_4", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_5", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_6", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_7", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_8", Field.STRING, 20));
		dataset.fieldDef(new Field("label_col_9", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_entrega", Field.DATE, 0));
		return dataset;
	}
		
	
	
	
	
	

}
	