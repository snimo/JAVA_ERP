package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LabelTranslator;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionRemito extends Operation {

	private LabelTranslator lt = null;
	
	public ImpresionRemito() {
	}
	
	

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsRemitoCab = getDataSetRemitoCab();
		IDataSet dsRemitoDet = getDataSetRemitoDet();
		IDataSet dsLabels    = getDataSetLabels();
		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(RemitoCab.NICKNAME);
		lt.setIdioma(Idioma.getIdiomaLocal(this.getSesion()));
		

		RemitoCab remitoCab = RemitoCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());

		cargarRegistroRemitoCab(dsRemitoCab, remitoCab);
		Iterator iterDetallesRemitos = remitoCab.getDetalles().iterator();
		while (iterDetallesRemitos.hasNext()) {
			RemitoDet remitoDet = (RemitoDet) iterDetallesRemitos.next();
			cargarRegistroRemitoDet(dsRemitoDet, remitoCab, remitoDet);
		}

		cargarLabels(dsLabels);
		
		writeCliente(dsRemitoCab);
		writeCliente(dsRemitoDet);
		writeCliente(dsLabels);
	}

	private void cargarRegistroRemitoCab(IDataSet dataset, RemitoCab remitoCab) throws BaseException {
		dataset.append();
		
		enviarDatosEmpresa(dataset);
		enviarDatosSucursal(dataset);
		
		
		dataset.fieldValue("oid_cco_rto", remitoCab.getOIDInteger());
		dataset.fieldValue("comprobante", remitoCab.getCodigo());
		dataset.fieldValue("observaciones", remitoCab.getComentario());
		dataset.fieldValue("tipo_comprobante", remitoCab.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", remitoCab.getLetra());
		dataset.fieldValue("codigo_letra", remitoCab.getTalonario().getCodigoLetra());
		dataset.fieldValue("lug_emi", remitoCab.getNroLugEmision());
		dataset.fieldValue("nro_ext", remitoCab.getNroExt());
		
		dataset.fieldValue("nro_ext_formateado", remitoCab.getNroExtFormat8Digitos());
		dataset.fieldValue("lug_emi_formateado", remitoCab.getLugEmiFormato4Digitos());
		
		
		dataset.fieldValue("fecha", remitoCab.getEmision());
		if (remitoCab.getSujeto() != null) {
			dataset.fieldValue("codigo_destinatario", remitoCab.getSujeto().getCodigo());
			dataset.fieldValue("destinatario", remitoCab.getSujeto().getRazon_social());
			dataset.fieldValue("telefono_destinatario", remitoCab.getSujeto().getTelefonos());
			if (remitoCab.getSujeto().getSujeto_impositivo() != null) {
				dataset.fieldValue("cat_iva_destinatario", remitoCab.getSujeto().getSujeto_impositivo().getCategiva()
						.getDescripcion());
				dataset.fieldValue("cuit_destinatario", remitoCab.getSujeto().getSujeto_impositivo().getCuit());
				dataset.fieldValue("nro_ing_brutos_destinatario", remitoCab.getSujeto().getSujeto_impositivo().getIngbrutos());
			}
			else {
				dataset.fieldValue("cat_iva_destinatario", "");
				dataset.fieldValue("cuit_destinatario", "");
				dataset.fieldValue("nro_ing_brutos_destinatario", "");
			}
		}
		else if (remitoCab.getProveedor() != null) {
			dataset.fieldValue("codigo_destinatario", remitoCab.getProveedor().getCodigo());
			dataset.fieldValue("destinatario", remitoCab.getProveedor().getRazonsocial());
			dataset.fieldValue("telefono_destinatario", "");
			if (remitoCab.getProveedor().getSujetoimpositivo() != null) {
				dataset.fieldValue("cat_iva_destinatario", remitoCab.getProveedor().getSujetoimpositivo().getCategiva()
						.getDescripcion());
				dataset.fieldValue("cuit_destinatario", remitoCab.getProveedor().getSujetoimpositivo().getCuit());
				dataset.fieldValue("nro_ing_brutos_destinatario",  remitoCab.getProveedor().getSujetoimpositivo().getIngbrutos());
			}
			else {
				dataset.fieldValue("cat_iva_destinatario", "");
				dataset.fieldValue("cuit_destinatario", "");
				dataset.fieldValue("nro_ing_brutos_destinatario", "");
			}
		}
		else if (remitoCab.getDepo_destino() != null) {
			dataset.fieldValue("codigo_destinatario", remitoCab.getDepo_destino().getCodigo());
			dataset.fieldValue("destinatario", remitoCab.getDepo_destino().getDescripcion());
			dataset.fieldValue("telefono_destinatario", "");
			
			Empresa empresa = Empresa.findByOid(this.getSesion().getLogin().getOidEmpresa(), this.getSesion());
			
			dataset.fieldValue("cat_iva_destinatario", empresa.getCategoria_iva().getDescripcion());
			dataset.fieldValue("cuit_destinatario", empresa.getCuit());
			dataset.fieldValue("nro_ing_brutos_destinatario",  empresa.getNro_ing_brutos());
			
		}
		
		else {
			dataset.fieldValue("codigo_destinatario", "");
			dataset.fieldValue("destinatario", "");
			dataset.fieldValue("telefono_destinatario", "");
			dataset.fieldValue("cat_iva_destinatario", "");
			dataset.fieldValue("cuit_destinatario", "");
			dataset.fieldValue("nro_ing_brutos_destinatario", "");
		}

		dataset.fieldValue("direccion_destinatario", remitoCab.getCalle_y_nro());
		dataset.fieldValue("localidad_destinatario", remitoCab.getLocalidad());
		if (remitoCab.getProvincia() != null)
			dataset.fieldValue("provincia_destinatario", remitoCab.getProvincia().getDescripcion());
		else
			dataset.fieldValue("provincia_destinatario", "");
		if (remitoCab.getPais() != null)
			dataset.fieldValue("pais_destinatario", remitoCab.getPais().getDescripcion());
		else
			dataset.fieldValue("pais_destinatario", "");

		dataset.fieldValue("pedido", remitoCab.getReferencia2());
		PedidoCab pedido = remitoCab.getFirsPedido();
		
		if (pedido!=null) {
		  if (pedido.getVendedor()!=null)	
			  dataset.fieldValue("vendedor", pedido.getVendedor().getNombreyApellido());
		  else
			  dataset.fieldValue("vendedor", "");
		}
		else
			dataset.fieldValue("vendedor", "");
		
		dataset.fieldValue("factura", "");
		dataset.fieldValue("oc", remitoCab.getReferencia1());
		if ((pedido!=null) && (pedido.getCondicionPago()!=null))
			dataset.fieldValue("forma_de_pago", pedido.getCondicionPago().getDescripcion());
		else
			dataset.fieldValue("forma_de_pago", "");
		if ((pedido!=null) && (pedido.getTransporte()!=null))
			dataset.fieldValue("transporte", pedido.getTransporte().getDescripcion());
		else
			dataset.fieldValue("transporte", "");
		
		dataset.fieldValue("cai", remitoCab.getTalonario().getCai());
		dataset.fieldValue("vto_cai", remitoCab.getTalonario().getFec_vto());
		if (remitoCab.isActivo().booleanValue()==false)
			dataset.fieldValue("leyenda_anulado", "ANULADO");
		else
			dataset.fieldValue("leyenda_anulado", "");
		dataset.fieldValue("comentario", remitoCab.getComentario());
	}

	private void cargarRegistroRemitoDet(IDataSet dataset, RemitoCab remitoCab, RemitoDet remitoDet) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_cco_rto_det", remitoDet.getOIDInteger());
		dataset.fieldValue("oid_cco_rto", remitoCab.getOIDInteger());
		dataset.fieldValue("oid_producto", remitoDet.getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", remitoDet.getProducto().getCodigo());
		dataset.fieldValue("desc_producto", remitoDet.getProducto().getDescripcion());
		dataset.fieldValue("cantidad", remitoDet.getCant_desp());
		dataset.fieldValue("oid_um", remitoDet.getUnidad_desp().getOIDInteger());
		dataset.fieldValue("etiqueta_um", remitoDet.getUnidad_desp().getLabelImpresion());
		dataset.fieldValue("comentario", remitoDet.getComentario());
	}

	private IDataSet getDataSetRemitoCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRemitoCab");
		
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
		
		dataset.fieldDef(new Field("empresa_cat_iva", Field.STRING, 100));
		dataset.fieldDef(new Field("empresa_cuit", Field.STRING, 100));
		dataset.fieldDef(new Field("empresa_cat_ib", Field.STRING, 100));
		dataset.fieldDef(new Field("empresa_nro_ib", Field.STRING, 100));
		
		dataset.fieldDef(new Field("empresa_inicio_actividad", Field.DATE, 0));
		
		
		// Datos de la Sucursal
		dataset.fieldDef(new Field("sucursal_oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sucursal_codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("sucursal_razon_social", Field.STRING, 100));
		dataset.fieldDef(new Field("sucursal_direccion", Field.STRING, 100));
		dataset.fieldDef(new Field("sucursal_localidad", Field.STRING, 100));
		dataset.fieldDef(new Field("sucursal_cp", Field.STRING, 100));
		
		dataset.fieldDef(new Field("sucursal_cp_localidad", Field.STRING, 100));
		
		dataset.fieldDef(new Field("sucursal_oid_provincia", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sucursal_cod_provincia", Field.STRING, 50));
		dataset.fieldDef(new Field("sucursal_desc_provincia", Field.STRING, 100));
		dataset.fieldDef(new Field("sucursal_oid_pais", Field.INTEGER, 0));
		dataset.fieldDef(new Field("sucursal_cod_pais", Field.STRING, 50));
		dataset.fieldDef(new Field("sucursal_desc_pais", Field.STRING, 100));
		
		dataset.fieldDef(new Field("sucursal_telefono", Field.STRING, 100));
		dataset.fieldDef(new Field("sucursal_fax", Field.STRING, 100));
		
		dataset.fieldDef(new Field("path_logo_sucursal", Field.STRING, 255));
		
		
		dataset.fieldDef(new Field("oid_cco_rto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("observaciones", Field.STRING, 255));
		dataset.fieldDef(new Field("tipo_comprobante", Field.STRING, 20));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("codigo_letra", Field.STRING, 20));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		
		dataset.fieldDef(new Field("nro_ext_formateado", Field.STRING, 20));
		dataset.fieldDef(new Field("lug_emi_formateado", Field.STRING, 20));
		
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("codigo_destinatario", Field.STRING, 50));
		dataset.fieldDef(new Field("destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("telefono_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("cat_iva_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("cuit_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_ing_brutos_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("localidad_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("provincia_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("pais_destinatario", Field.STRING, 100));
		dataset.fieldDef(new Field("pedido", Field.STRING, 100));
		dataset.fieldDef(new Field("vendedor", Field.STRING, 100));
		dataset.fieldDef(new Field("factura", Field.STRING, 100));
		dataset.fieldDef(new Field("oc", Field.STRING, 100));
		dataset.fieldDef(new Field("forma_de_pago", Field.STRING, 100));
		dataset.fieldDef(new Field("transporte", Field.STRING, 100));
		dataset.fieldDef(new Field("cai", Field.STRING, 50));
		dataset.fieldDef(new Field("vto_cai", Field.DATE, 100));
		dataset.fieldDef(new Field("leyenda_anulado", Field.STRING, 50));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
		
		return dataset;
	}

	private IDataSet getDataSetRemitoDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRemitoDet");
		dataset.fieldDef(new Field("oid_cco_rto_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_rto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
		dataset.fieldDef(new Field("etiqueta_um", Field.STRING, 20));
		dataset.fieldDef(new Field("comentario", Field.MEMO, 0));
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
		
		
		if (empresa.getCategoria_iva()!=null)
			dataset.fieldValue("empresa_cat_iva", empresa.getCategoria_iva().getDescripcion());
		else
			dataset.fieldValue("empresa_cat_iva", "");
		dataset.fieldValue("empresa_cuit", empresa.getCuit());
		if (empresa.getCategoria_ib()!=null)
			dataset.fieldValue("empresa_cat_ib", empresa.getCategoria_ib().getDescripcion());
		else
			dataset.fieldValue("empresa_cat_ib", "");
		dataset.fieldValue("empresa_nro_ib", empresa.getNro_ing_brutos());
		dataset.fieldValue("empresa_inicio_actividad", empresa.getInicioActividad());
		
		
		
	}
	
	private void enviarDatosSucursal(IDataSet dataset) throws BaseException {

		Sucursal sucursal = Sucursal.findByOidProxy(this.getSesion().getLogin().getOidSucursal(),this.getSesion());
		
		
		dataset.fieldValue("sucursal_oid", sucursal.getOIDInteger());
		dataset.fieldValue("sucursal_codigo", sucursal.getCodigo());
		dataset.fieldValue("sucursal_razon_social", sucursal.getDescripcion());
		dataset.fieldValue("sucursal_direccion", sucursal.getCalle_y_nro());
		dataset.fieldValue("sucursal_localidad", sucursal.getLocalidad());
		dataset.fieldValue("sucursal_cp", sucursal.getCodigo_postal());
		
		dataset.fieldValue("sucursal_cp_localidad", sucursal.getCodigoPostalYLocalidad());
		
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
		
		dataset.fieldValue("sucursal_telefono", sucursal.getTelefonos());
		dataset.fieldValue("sucursal_fax", sucursal.getFax());
		
		dataset.fieldValue("path_logo_sucursal", sucursal.getPathLogo());

	}
	
	private IDataSet getDataSetLabels() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLabels");	
		dataset.fieldDef(new Field("REMITO_NRO", Field.STRING, 255));
		dataset.fieldDef(new Field("FECHA", Field.STRING, 255));
		dataset.fieldDef(new Field("CUIT", Field.STRING, 255));
		dataset.fieldDef(new Field("CATEGORIA_IVA", Field.STRING, 255));
		dataset.fieldDef(new Field("CATEGORIA_IB", Field.STRING, 255));
		dataset.fieldDef(new Field("NRO_IB", Field.STRING, 255));
		dataset.fieldDef(new Field("TELEFONO", Field.STRING, 255));
		dataset.fieldDef(new Field("FAX", Field.STRING, 255));
		dataset.fieldDef(new Field("DOC_NO_VAL_FACT", Field.STRING, 255));
		dataset.fieldDef(new Field("PAGINA", Field.STRING, 255));
		dataset.fieldDef(new Field("PAGINA_DE", Field.STRING, 255));
		dataset.fieldDef(new Field("INICIO_ACTIVIDAD", Field.STRING, 255));
		dataset.fieldDef(new Field("CODIGO_LETRA", Field.STRING, 255));
		dataset.fieldDef(new Field("DESTINO", Field.STRING, 255));
		dataset.fieldDef(new Field("CAT_IVA_DESTINATARIO", Field.STRING, 255));
		dataset.fieldDef(new Field("CUIT_DESTINATARIO", Field.STRING, 255));
		dataset.fieldDef(new Field("NRO_IB_DESTINATARIO", Field.STRING, 255));
		dataset.fieldDef(new Field("CODIGO_DESTINATARIO", Field.STRING, 255));
		dataset.fieldDef(new Field("PEDIDO", Field.STRING, 255));
		dataset.fieldDef(new Field("VENDEDOR", Field.STRING, 255));
		dataset.fieldDef(new Field("FACTURA", Field.STRING, 255));
		dataset.fieldDef(new Field("ORDEN_DE_COMPRA", Field.STRING, 255));
		dataset.fieldDef(new Field("CONDICION_DE_PAGO", Field.STRING, 255));
		dataset.fieldDef(new Field("TRANSPORTE", Field.STRING, 255));
		dataset.fieldDef(new Field("CANTIDAD_PRODUCTO", Field.STRING, 255));
		dataset.fieldDef(new Field("CODIGO_PRODUCTO", Field.STRING, 255));
		dataset.fieldDef(new Field("DESCRIPCION_PRODUCTO", Field.STRING, 255));
		dataset.fieldDef(new Field("CAI", Field.STRING, 255));
		dataset.fieldDef(new Field("VTO_CAI", Field.STRING, 255));
		
		
		return dataset;
	}
	
	private void cargarLabels(IDataSet ds) throws BaseException {
		ds.append();
		ds.fieldValue("REMITO_NRO",lt.getEtiqueta("REMITO_NRO"));
		ds.fieldValue("FECHA",lt.getEtiqueta("FECHA"));
		ds.fieldValue("CUIT",lt.getEtiqueta("CUIT"));
		ds.fieldValue("CATEGORIA_IVA" , lt.getEtiqueta("CATEGORIA_IVA"));
		ds.fieldValue("CATEGORIA_IB", lt.getEtiqueta("CATEGORIA_IB"));
		ds.fieldValue("NRO_IB", lt.getEtiqueta("NRO_IB"));
		ds.fieldValue("TELEFONO", lt.getEtiqueta("TELEFONO"));
		ds.fieldValue("FAX", lt.getEtiqueta("FAX"));
		ds.fieldValue("DOC_NO_VAL_FACT", lt.getEtiqueta("DOC_NO_VAL_FACT"));
		ds.fieldValue("PAGINA", lt.getEtiqueta("PAGINA"));
		ds.fieldValue("PAGINA_DE", lt.getEtiqueta("PAGINA_DE"));
		ds.fieldValue("INICIO_ACTIVIDAD", lt.getEtiqueta("INICIO_ACTIVIDAD"));
		ds.fieldValue("CODIGO_LETRA", lt.getEtiqueta("CODIGO_LETRA"));
		ds.fieldValue("DESTINO", lt.getEtiqueta("DESTINO"));
		ds.fieldValue("CAT_IVA_DESTINATARIO", lt.getEtiqueta("CAT_IVA_DESTINATARIO"));
		ds.fieldValue("CUIT_DESTINATARIO", lt.getEtiqueta("CUIT_DESTINATARIO"));
		ds.fieldValue("NRO_IB_DESTINATARIO", lt.getEtiqueta("NRO_IB_DESTINATARIO"));
		ds.fieldValue("CODIGO_DESTINATARIO", lt.getEtiqueta("CODIGO_DESTINATARIO"));
		ds.fieldValue("PEDIDO", lt.getEtiqueta("PEDIDO"));
		ds.fieldValue("VENDEDOR", lt.getEtiqueta("VENDEDOR"));
		ds.fieldValue("FACTURA", lt.getEtiqueta("FACTURA"));
		ds.fieldValue("ORDEN_DE_COMPRA", lt.getEtiqueta("ORDEN_DE_COMPRA"));
		ds.fieldValue("CONDICION_DE_PAGO", lt.getEtiqueta("CONDICION_DE_PAGO"));
		ds.fieldValue("TRANSPORTE", lt.getEtiqueta("TRANSPORTE"));
		ds.fieldValue("CANTIDAD_PRODUCTO", lt.getEtiqueta("CANTIDAD_PRODUCTO"));
		ds.fieldValue("CODIGO_PRODUCTO", lt.getEtiqueta("CODIGO_PRODUCTO"));
		ds.fieldValue("DESCRIPCION_PRODUCTO", lt.getEtiqueta("DESCRIPCION_PRODUCTO"));
		ds.fieldValue("CAI", lt.getEtiqueta("CAI"));
		ds.fieldValue("VTO_CAI", lt.getEtiqueta("VTO_CAI"));
	}
	
	

}
