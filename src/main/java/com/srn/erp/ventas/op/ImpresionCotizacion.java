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
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionDet;

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

public class ImpresionCotizacion extends Operation {
	
	CalculadorMoney totAcumItems = new CalculadorMoney(new Money(0));
	private boolean isFirstItem = true;
	
	private LabelTranslator lt = null;
	ClasificadorEntidad clasifEnt1 = null;
	ClasificadorEntidad clasifEnt2 = null;
	int secu = 0;
	private Idioma idioma = null;
	
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

	public ImpresionCotizacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		idioma = Idioma.getIdiomaLocal(this.getSesion());
		
		if (mapaDatos.containsKey("tipo_formato_cotizacion")) {
			if (mapaDatos.getInteger("tipo_formato_cotizacion").intValue()==2)
				impresionMatricial(mapaDatos);
			else
				impresionEstandar(mapaDatos);			
		} else impresionEstandar(mapaDatos);

	}
	
	private void impresionMatricial(MapDatos mapaDatos) throws BaseException {

		clasifEnt1 = ClasificadorEntidad.getClasif1ImpOCMatriz(this.getSesion());
		clasifEnt2 = ClasificadorEntidad.getClasif2ImpOCMatriz(this.getSesion());
		
		
		IDataSet dsCotizacionCab = getDataSetCotizacionCab();
		IDataSet dsProductosGrales = getDataSetProductosGral();
		IDataSet dsLabels = getDataSetLabels();
		IDataSet dsProdMatriz = getDataSetProductosMatricial();
		IDataSet dsTotResu = this.getDataSetTolalesResumen();

		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(CotizacionCab.NICKNAME);
		lt.setIdioma(idioma);				

		CotizacionCab cotizacionCab = CotizacionCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		
		if ((cotizacionCab.getSujeto()!=null) && (cotizacionCab.getSujeto().getIdioma()!=null))
			lt.setIdioma(cotizacionCab.getSujeto().getIdioma());

		cargarRegistroCotizacionCab(dsCotizacionCab,cotizacionCab);
		
		impresionItemsProdGral(dsProductosGrales, dsProdMatriz , cotizacionCab);
		cargarTotResu(dsTotResu, cotizacionCab, totAcumItems.getResultMoney());
		
		cargarEtiquetas(dsLabels);

		writeCliente(dsCotizacionCab);
		writeCliente(dsProductosGrales);
		writeCliente(dsLabels);
		writeCliente(dsProdMatriz);
		writeCliente(dsTotResu);
		
		
	}
	
	
	private void impresionEstandar(MapDatos mapaDatos) throws BaseException {

		IDataSet dsCotizacionCab = getDataSetCotizacionCab();
		IDataSet dsCotizacionDet = getDataSetCotizacionDet();
		IDataSet dsLabels = getDataSetLabels();
		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(CotizacionCab.NICKNAME);
		lt.setIdioma(idioma);				

		CotizacionCab cotizacionCab = CotizacionCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());

		if ((cotizacionCab.getSujeto()!=null) && (cotizacionCab.getSujeto().getIdioma()!=null))
			lt.setIdioma(cotizacionCab.getSujeto().getIdioma());
		
		cargarRegistroCotizacionCab(dsCotizacionCab,cotizacionCab);
		Iterator iterDetallesCotizaciones = cotizacionCab.getDetallesActivos().iterator();
		CotizacionDet cotizacionDetAnt = null;
		while (iterDetallesCotizaciones.hasNext()) {
			CotizacionDet cotizacionDet = (CotizacionDet) iterDetallesCotizaciones.next();
			if (cotizacionDet.isAnulado()) continue;
			cargarRegistroCotizacionDet(dsCotizacionDet, cotizacionCab, cotizacionDet , cotizacionDetAnt ,  !iterDetallesCotizaciones.hasNext());
			cotizacionDetAnt = cotizacionDet;
		}
		
		cargarEtiquetas(dsLabels);

		writeCliente(dsCotizacionCab);
		writeCliente(dsCotizacionDet);
		writeCliente(dsLabels);
		
		
	}


	private IDataSet getDataSetCotizacionCab() {
			IDataSet dataset = new TDataSet();
			dataset.create("TPresuCab");
			
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
			
			dataset.fieldDef(new Field("oid_cco_presu", Field.INTEGER, 0));
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
			dataset.fieldDef(new Field("impre_iva_2", Field.CURRENCY, 0));
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
			
			dataset.fieldDef(new Field("fec_validez", Field.DATE, 0));
			dataset.fieldDef(new Field("nro_ver_ext", Field.INTEGER, 0));
			
			dataset.fieldDef(new Field("nota_adic_iva", Field.STRING, 255));
			
			return dataset;
	}

	private IDataSet getDataSetCotizacionDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPresuDet");
		dataset.fieldDef(new Field("nro_renglon", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_presu_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_presu", Field.INTEGER, 0));
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
		dataset.fieldDef(new Field("oid_conc_imp_perc_ib", Field.INTEGER, 0));;
		dataset.fieldDef(new Field("dias_entrega", Field.INTEGER, 0));;
		
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
	
	
	private void cargarRegistroCotizacionCab(IDataSet dataset,CotizacionCab cotizacionCab) throws BaseException {
		dataset.append();
		
		enviarDatosEmpresa(dataset);
		enviarDatosSucursal(dataset);
		
		dataset.fieldValue("oid_cco_presu", cotizacionCab.getOIDInteger());
		dataset.fieldValue("oid_talonario",cotizacionCab.getTalonario().getOIDInteger());
		dataset.fieldValue("cod_tc",cotizacionCab.getTcExt());
		dataset.fieldValue("oid_tc", cotizacionCab.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_cliente", cotizacionCab.getSujeto().getCodigo());
		dataset.fieldValue("rz_cliente", cotizacionCab.getSujeto().getRazon_social());
		dataset.fieldValue("letra", cotizacionCab.getLetra());
		dataset.fieldValue("lug_emi", cotizacionCab.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", cotizacionCab.getNroExt());
		dataset.fieldValue("oid_cliente", cotizacionCab.getSujeto().getOIDInteger());
		dataset.fieldValue("oid_moneda", cotizacionCab.getMoneda().getOIDInteger());
		dataset.fieldValue("desc_moneda", cotizacionCab.getMoneda().getDescripcion());
		dataset.fieldValue("cotizacion", cotizacionCab.getCotizacion().doubleValue());
		dataset.fieldValue("mercado", cotizacionCab.getMercado());
		dataset.fieldValue("porc_bonif_cli", cotizacionCab.getPorc_bonif_cli());
		dataset.fieldValue("porc_reca_cli", cotizacionCab.getPorc_reca_cli());
		dataset.fieldValue("bonif_cli_cascada", cotizacionCab.isBonif_cli_cascada());
		dataset.fieldValue("reca_cli_cascada", cotizacionCab.isReca_cli_cascada());
		dataset.fieldValue("oid_precio_cab", cotizacionCab.getLista_precios().getOIDInteger());
		dataset.fieldValue("cod_lp", cotizacionCab.getLista_precios().getCodigo());
		dataset.fieldValue("desc_lp", cotizacionCab.getLista_precios().getDescripcion());
		dataset.fieldValue("path_logo_sucursal", cotizacionCab.getSucursal().getPathLogo());
		
		if (cotizacionCab.getCondicionPago()!=null) {
		  dataset.fieldValue("oid_cond_pago", cotizacionCab.getCondicionPago().getOIDInteger());
		  dataset.fieldValue("cod_cond_pago", cotizacionCab.getCondicionPago().getCodigo());
		  dataset.fieldValue("desc_cond_pago", cotizacionCab.getCondicionPago().getDescripcion());
		} else {
		  dataset.fieldValue("oid_cond_pago", 0);
		  dataset.fieldValue("cod_cond_pago", "");
		  dataset.fieldValue("desc_cond_pago", "");
		}
		
		// Datos del Vendedor
		
		dataset.fieldValue("oid_vendedor", cotizacionCab.getVendedor().getOIDInteger());
		dataset.fieldValue("cod_vendedor", cotizacionCab.getVendedor().getCodigo());
		dataset.fieldValue("desc_vendedor", cotizacionCab.getVendedor().getNombre()+ " " + cotizacionCab.getVendedor().getApellido());		
		dataset.fieldValue("vendedor_mail", cotizacionCab.getVendedor().getMail());
		dataset.fieldValue("vendedor_telefono", cotizacionCab.getVendedor().getTelefono());		
		
		if (cotizacionCab.getDomicilio_entrega()!=null) {
		  dataset.fieldValue("oid_uni_edi", cotizacionCab.getDomicilio_entrega().getOID());
		  dataset.fieldValue("cod_uni_edi", cotizacionCab.getDomicilio_entrega().getCodigo());
		  dataset.fieldValue("desc_uni_edi", cotizacionCab.getDomicilio_entrega().getDescripcion());
		  dataset.fieldValue("dom_ent_dir_completa", cotizacionCab.getDomicilio_entrega().getDireccionCompleta());
		} else {
		  dataset.fieldValue("oid_uni_edi", 0);
		  dataset.fieldValue("cod_uni_edi", "");
		  dataset.fieldValue("desc_uni_edi", "");
		  dataset.fieldValue("dom_ent_dir_completa", "");
		}
		
		dataset.fieldValue("porc_bonif_cp", cotizacionCab.getPorc_bonif_cp());
		dataset.fieldValue("porc_reca_cp", cotizacionCab.getPorc_reca_cp());
		dataset.fieldValue("bonif_cp_cascada", cotizacionCab.isBonif_cp_cascada());
		dataset.fieldValue("reca_cp_cascada", cotizacionCab.isReca_cp_cascada());
		dataset.fieldValue("observado", cotizacionCab.isObservado());
		dataset.fieldValue("comentario",  cotizacionCab.getComentarioMasObsCodif(idioma));
		dataset.fieldValue("fec_emision", cotizacionCab.getEmision());
		dataset.fieldValue("activo", cotizacionCab.isActivo());
		if (cotizacionCab.getTransporte()!=null) {
		  dataset.fieldValue("oid_transporte", cotizacionCab.getTransporte().getOIDInteger());
		  dataset.fieldValue("cod_transporte", cotizacionCab.getTransporte().getCodigo());
		  dataset.fieldValue("desc_transporte", cotizacionCab.getTransporte().getDescripcion());
		} else {
		  dataset.fieldValue("oid_transporte", 0);
		  dataset.fieldValue("cod_transporte", "");
		  dataset.fieldValue("desc_transporte", "");			
		}
		dataset.fieldValue("oid_moneda_fact", cotizacionCab.getMonedaFact().getOIDInteger());
		
		if (cotizacionCab.getFormaEntrega()!=null) {
		  dataset.fieldValue("oid_forma_entrega", cotizacionCab.getFormaEntrega().getOIDInteger());
		  dataset.fieldValue("cod_forma_entrega", cotizacionCab.getFormaEntrega().getCodigo());
		  dataset.fieldValue("desc_forma_entrega", cotizacionCab.getFormaEntrega().getDescripcion());
		} else {
		  dataset.fieldValue("oid_forma_entrega", 0);
		  dataset.fieldValue("cod_forma_entrega", "");
		  dataset.fieldValue("desc_forma_entrega", "");
		}
		dataset.fieldValue("orden_compra", cotizacionCab.getOrdenDeCompra());
		
		dataset.fieldValue("impre_bruto", cotizacionCab.getImpre_bruto());
		dataset.fieldValue("impre_porc_dto", cotizacionCab.getImprePorcBonif());
		dataset.fieldValue("impre_descuento", cotizacionCab.getImpre_bonif());
		dataset.fieldValue("impre_porc_recar", cotizacionCab.getImprePorcRecar());
		dataset.fieldValue("impre_recargo", cotizacionCab.getImpre_recar());
		dataset.fieldValue("impre_neto", cotizacionCab.getImpre_neto());
		dataset.fieldValue("impre_iva", cotizacionCab.getImpre_iva());
		dataset.fieldValue("impre_iva_2", cotizacionCab.getImpre_iva2());
		
		dataset.fieldValue("impre_perc_iva", cotizacionCab.getImpre_perc_iva());
		dataset.fieldValue("impre_imp_internos", cotizacionCab.getImpre_imp_int());
		dataset.fieldValue("impre_perc_ib", cotizacionCab.getImpre_perc_ib());
		dataset.fieldValue("impre_total", cotizacionCab.getImpre_total());
		
		if ((cotizacionCab.getConcImpuIVA()!=null) && (cotizacionCab.getConcImpuIVA().getColumnalibroiva()!=null))
		   dataset.fieldValue("label_porc_iva", cotizacionCab.getConcImpuIVA().getColumnalibroiva().getDescripcion());
		else
			 dataset.fieldValue("label_porc_iva", "");
		
		if ((cotizacionCab.getConcImpuIVA2()!=null) && (cotizacionCab.getConcImpuIVA2().getColumnalibroiva()!=null))
			   dataset.fieldValue("label_porc_iva_2", cotizacionCab.getConcImpuIVA2().getColumnalibroiva().getDescripcion());
			else
				 dataset.fieldValue("label_porc_iva_2", "");
		
		
		if ((cotizacionCab.getConcImpuPercIVA()!=null) && (cotizacionCab.getConcImpuPercIVA().getColumnalibroiva()!=null))
			dataset.fieldValue("label_porc_perc_iva", cotizacionCab.getConcImpuPercIVA().getColumnalibroiva().getDescripcion());
		else
			dataset.fieldValue("label_porc_perc_iva", "");
		
		if (cotizacionCab.getContactoSujeto()!=null)
			dataset.fieldValue("contacto", cotizacionCab.getContactoSujeto().getNombreYApellido());
		else
			dataset.fieldValue("contacto", "");
		
		dataset.fieldValue("observacion", cotizacionCab.getComentario());
		if (cotizacionCab.isActivo().booleanValue() == false)
		  dataset.fieldValue("leyenda_anulado" , "ANULADO");
		else
			dataset.fieldValue("leyenda_anulado" , "");
		dataset.fieldValue("fec_validez" , cotizacionCab.getFecValidez());
		dataset.fieldValue("nro_ver_ext", cotizacionCab.getComprobanteImpreso().getVersion_externa());
		if (cotizacionCab.getSujeto().getSujeto_impositivo().getCategiva().isDiscriminaIVA())
			dataset.fieldValue("nota_adic_iva", lt.getEtiqueta("SYS_LABEL_NOTA_ADIC_IVA"));
		else
			dataset.fieldValue("nota_adic_iva", lt.getEtiqueta("SYS_LABEL_NOTA_IVA_INCLU"));
		
	}
	
	private void cargarRegistroCotizacionDet(IDataSet dataset, 
											 CotizacionCab cotizacionCab, 
											 CotizacionDet cotizacionDet,
											 CotizacionDet cotizacionDetAnt,
											 boolean esUltimoItem) throws BaseException {
		
		if (cotizacionDet.isAnulado().booleanValue()) return ;
		
		dataset.append();
		dataset.fieldValue("nro_renglon", cotizacionDet.getNroRenglon());
		dataset.fieldValue("oid_presu_det", cotizacionDet.getOIDInteger());
		dataset.fieldValue("oid_cco_presu", cotizacionCab.getOIDInteger());
		dataset.fieldValue("oid_art", cotizacionDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", cotizacionDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", cotizacionDet.getProducto().getDescripcion());
		dataset.fieldValue("oid_um_ori", cotizacionDet.getUni_med_ori().getOIDInteger());
		dataset.fieldValue("desc_um_ori", cotizacionDet.getUni_med_ori().getLabelImpresion());
		dataset.fieldValue("cantidad", cotizacionDet.getCant_um_ori());
		dataset.fieldValue("precio", cotizacionDet.getPrecio());
		dataset.fieldValue("precio_lista", cotizacionDet.getPrecio_lista());
		dataset.fieldValue("precio_sugerido", new Money(0));
		dataset.fieldValue("precio_bonif", cotizacionDet.getPrecio_bonif());
		dataset.fieldValue("importe", cotizacionDet.getImporte());
		dataset.fieldValue("oid_moneda", cotizacionDet.getMoneda().getOIDInteger());
		dataset.fieldValue("activo", cotizacionDet.isActivo());
		dataset.fieldValue("bonif1", cotizacionDet.getBonif1());
		dataset.fieldValue("bonif2", cotizacionDet.getBonif2());
		dataset.fieldValue("bonif3", cotizacionDet.getBonif3());
		dataset.fieldValue("comentario", cotizacionDet.getComentario());
		dataset.fieldValue("fec_entrega", cotizacionDet.getFechaEntrega());
		dataset.fieldValue("activo", new Boolean(true));
		
		if (cotizacionDet.getConcImpuIVA()!=null)
			dataset.fieldValue("oid_conc_imp_iva", cotizacionDet.getConcImpuIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_iva", new Integer(0));
		if (cotizacionDet.getConcImpuPercIVA()!=null)
			dataset.fieldValue("oid_conc_imp_perc_iva", cotizacionDet.getConcImpuPercIVA().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_iva", new Integer(0));
		if (cotizacionDet.getConcImpuInt()!=null)
			dataset.fieldValue("oid_conc_imp_int", cotizacionDet.getConcImpuInt().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_int", new Integer(0));
		if (cotizacionDet.getConcImpuPercIB()!=null)
			dataset.fieldValue("oid_conc_imp_perc_ib", cotizacionDet.getConcImpuPercIB().getOIDInteger());
		else
			dataset.fieldValue("oid_conc_imp_perc_ib", new Integer(0));
		dataset.fieldValue("dias_entrega", cotizacionDet.getDiasEntrega());
		
		
		//if (cotizacionDetAnt!=null)
		//		calcAcumTotal.sumar(cotizacionDetAnt.getImporte());
		calcAcumTotal.sumar(cotizacionDet.getImporte());
		if (esUltimoItem) {
			dataset.fieldValue("acum_bruto", cotizacionCab.getImpre_bruto());
			dataset.fieldValue("acum_descuento", cotizacionCab.getImpre_bonif());
			dataset.fieldValue("acum_recargo", cotizacionCab.getImpre_recar());
			dataset.fieldValue("acum_neto", cotizacionCab.getImpre_neto());
			dataset.fieldValue("acum_iva", cotizacionCab.getImpre_iva());
			dataset.fieldValue("acum_iva_2", cotizacionCab.getImpre_iva2());
			dataset.fieldValue("acum_perc_iva", cotizacionCab.getImpre_perc_iva());
			dataset.fieldValue("acum_imp_int", cotizacionCab.getImpre_imp_int());
			dataset.fieldValue("acum_perc_ib", cotizacionCab.getImpre_perc_ib());
			dataset.fieldValue("acum_total", cotizacionCab.getImpre_total());
			
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
	
	private void cargarEtiquetas(IDataSet ds) throws BaseException {
		Iterator iterEtiquetas = 
			EtiquetaIdioma.getEtiquetasComprobante(
					CotizacionCab.NICKNAME,this.getSesion()).iterator();
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
		dataset.fieldDef(new Field("dias_entrega", Field.INTEGER, 0));
		return dataset;
	}
	
	private void impresionItemsProdGral(
			IDataSet dsProdGral,
			IDataSet dsProdMatriz,
			CotizacionCab cotizacionCab) throws BaseException {

		List renglones = new ArrayList();

		Iterator iterDetCotiz = cotizacionCab.getDetallesActivos().iterator();
		while (iterDetCotiz.hasNext()) {
			CotizacionDet cotizacionDet = (CotizacionDet) iterDetCotiz.next();
			if (cotizacionDet.isAnulado())
				continue;
			RenglonProdGral renglonProdGral = findRenglonProdGral(cotizacionDet,renglones);
			renglonProdGral.agregarCantidades(cotizacionDet);

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
					cotizacionCab.getOIDInteger());
			
			
			// Devolver
			Iterator iterRenglonesProdGralClasifArt1 =
				renglonProdgral.renglonesProdGralClasifArt1.iterator();
			while (iterRenglonesProdGralClasifArt1.hasNext()) {
				RenglonProdGralClasifArt1  renglonProdGralClasifArt1 = (RenglonProdGralClasifArt1) iterRenglonesProdGralClasifArt1.next();
				cargarRenglonProdGralClasifArt1(dsProdMatriz, renglonProdgral, renglonProdGralClasifArt1, oidClave);
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
		return dataset;
	}
	
	
	class RenglonProdGral {

		IValorClasificadorEntidad producto = null;
		String descAdicSKU = null;
		Integer diasEntrega;
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

		public void agregarCantidades(CotizacionDet cotizDet)
				throws BaseException {
			
			// Agregar la Etiqueta
			IValorClasificadorEntidad valorClasifArt2 = cotizDet.getProducto().getValorClasifEnt(clasifEnt2);
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
				if (renglonProdGralClasifArt1.esIgualA(cotizDet)) {
					renglonProdGralClasifArt1.agregarCantidades(cotizDet);
					encontro = true;
					break;
				}
			}

			if (!encontro) {
				renglonProdGralClasifArt1 = new RenglonProdGralClasifArt1();
				renglonProdGralClasifArt1.valorClasifArt1 = cotizDet.getProducto().getValorClasifEnt(clasifEnt1);
				renglonProdGralClasifArt1.cantidad = new Double(0);
				renglonProdGralClasifArt1.precio = cotizDet.getPrecio_bonif().doubleValue();
				renglonProdGralClasifArt1.total = cotizDet.getImporte().doubleValue();
				renglonProdGralClasifArt1.um = cotizDet.getUni_med_ori();
				renglonProdGralClasifArt1.agregarCantidades(cotizDet);
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

		private boolean esIgualA(CotizacionDet cotizDet) throws BaseException {

			boolean condValClasifArt1 = false;
			if ((cotizDet.getProducto().getValorClasifEnt(clasifEnt1) == null)
					&& (this.valorClasifArt1 == null))
				condValClasifArt1 = true;
			else if ((cotizDet.getProducto().getValorClasifEnt(clasifEnt1) != null)
					&& (this.valorClasifArt1 != null)
					&& (cotizDet.getProducto().getValorClasifEnt(clasifEnt1).getOID() == this.valorClasifArt1.getOID())) {
				condValClasifArt1 = true;
			}

			boolean condPrecio = false;
			if ((cotizDet.getPrecio_bonif() == null) && (this.precio == null))
				condPrecio = true;
			else if ((cotizDet.getPrecio_bonif() != null)
					&& (this.precio != null)
					&& (cotizDet.getPrecio_bonif().doubleValue() == this.precio.doubleValue())) {
				condPrecio = true;
			}
			
			boolean condUM = false;
			if ((cotizDet.getUni_med_ori() == null) && (this.um == null))
				condUM = true;
			else if ((cotizDet.getUni_med_ori() != null)
					&& (this.um != null)
					&& (cotizDet.getUni_med_ori().getOID() == this.um.getOID())) {
				condUM = true;
			}
			

			if (condValClasifArt1 && condPrecio && condUM)
				return true;
			else
				return false;
		}
		
		private void agregarCantidades(CotizacionDet cotizDet) throws BaseException {

			// Acummlar las cantidades y cambiar el Total
			if (cantidad == null)
				cantidad = new Double(0);
			
			CalculadorMoney acumCant = new CalculadorMoney(new Money(cotizDet.getCant_um_ori().doubleValue()));
			acumCant.sumar(new Money(cantidad));
			cantidad = acumCant.getResultMoney().doubleValue(); 
			
			if (precio == 0)
				precio = new Double(0);
			CalculadorMoney impTotal = new CalculadorMoney(new Money(precio));
			impTotal.multiplicarPor(acumCant.getResultMoney());
			total = impTotal.getResult();
			
			// Agregar las cantidades en el valor de clasificador 2 que corresponda
			String codValClasif2 = "";
			IValorClasificadorEntidad valClasif2 = cotizDet.getProducto().getValorClasifEnt(clasifEnt2);
			if (valClasif2!= null)
				codValClasif2 = valClasif2.getCodigo(); 
			if (listaCantidades.get(codValClasif2)==null)
				listaCantidades.put(codValClasif2, new Double(cotizDet.getCant_um_ori().doubleValue()));
			else {
				Double cant = (Double) listaCantidades.get(codValClasif2);
				CalculadorMoney acumCant1 = new CalculadorMoney(new Money(cant));
				acumCant1.sumar(new Money(cotizDet.getCant_um_ori().doubleValue()));
				listaCantidades.put(codValClasif2, new Double(acumCant1.getResultMoney().doubleValue()));
			}
				
		}

	}
	
	private RenglonProdGral findRenglonProdGral(CotizacionDet cotizDet,
			List renglones) throws BaseException {

		Iterator iterRenglones = renglones.iterator();
		while (iterRenglones.hasNext()) {
			RenglonProdGral renglonProdGral = (RenglonProdGral) iterRenglones.next();

			if (cotizDet.getProducto().getValorClasifProdGen() == null)
				throw new ExceptionValidation(null,"Falta definir el producto general para el producto de stock "+cotizDet.getProducto().getCodigo()+" - "+cotizDet.getProducto().getDescripcion());
			
			boolean condProducto = false;
			if ((renglonProdGral.producto.getOID() == cotizDet.getProducto().getValorClasifProdGen().getOID()))
				condProducto = true;

			boolean condComentario = false;
			if ((cotizDet.getComentario() == null)
					&& (renglonProdGral.descAdicSKU == null))
				condComentario = true;
			else if ((cotizDet.getComentario() != null)
					&& (renglonProdGral.descAdicSKU != null)
					&& (cotizDet.getComentario().equals(renglonProdGral.descAdicSKU)))
				condComentario = true;

			boolean condDiasEntrega = false;
			if ((cotizDet.getDiasEntrega() == null)
					&& (renglonProdGral.diasEntrega == null))
				condDiasEntrega = true;
			else if ((cotizDet.getDiasEntrega() != null)
					&& (renglonProdGral.diasEntrega != null)
					&& (cotizDet.getDiasEntrega().intValue()==renglonProdGral.diasEntrega))
				condDiasEntrega = true;

			if ((condProducto) && (condComentario) && (condDiasEntrega)) {
				// clave existente
				String codValClasif2 = "";
				if (cotizDet.getProducto().getValorClasifEnt(clasifEnt2)!=null)
					codValClasif2  = cotizDet.getProducto().getValorClasifEnt(clasifEnt2).getCodigo();
				if (!((renglonProdGral.isFullLabels && (!renglonProdGral.isLabelEnRenglon(codValClasif2)))))
					return renglonProdGral;
			}

		}

		RenglonProdGral renglon = new RenglonProdGral();
		renglon.producto = cotizDet.getProducto().getValorClasifProdGen();
		renglon.descAdicSKU = cotizDet.getComentario();
		renglon.diasEntrega = cotizDet.getDiasEntrega();
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
	dsProdGral.fieldValue("dias_entrega", renglonProdGral.diasEntrega);
	
   }
	
	private void cargarRenglonProdGralClasifArt1(IDataSet ds,
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
		ds.fieldValue("precio", renglonProdGralClasifArt1.precio);
		ds.fieldValue("total", renglonProdGralClasifArt1.total);
		ds.fieldValue("acum_total" ,  totAcumItems.getResult());
		
		
		
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
			CotizacionCab cotizacion,
			Money totResumen) throws BaseException {
		ds.append();
		ds.fieldValue("oid_cco", cotizacion.getOIDInteger());
		ds.fieldValue("total", totResumen);
		
	}
	
	
	

}
	