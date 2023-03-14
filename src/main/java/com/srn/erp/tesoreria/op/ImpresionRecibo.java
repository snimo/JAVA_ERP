package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LabelTranslator;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.tesoreria.bm.FacturasRecibo;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.bm.ValoresRecibo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionRecibo extends Operation {

	private LabelTranslator lt= null;
	
	public ImpresionRecibo() {
	}
	
	

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsReciboCab = getDataSetReciboCab();
		IDataSet dsLabels    = getDataSetLabels();
		IDataSet dsValores   = getDataSetValores();
		IDataSet dsComproCob = getDataSetComproCobrados(); 
		
		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(Recibo.NICKNAME);
		lt.setIdioma(Idioma.getIdiomaLocal(this.getSesion()));
		

		Recibo recibo = Recibo.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());

		cargarRegistroReciboCab(dsReciboCab, recibo);
		cargarValoresRecibo(dsValores, recibo);
		cargarComproCobrados(dsComproCob,recibo);
		cargarLabels(dsLabels);
		
		writeCliente(dsReciboCab);
		writeCliente(dsLabels);
		writeCliente(dsValores);
		writeCliente(dsComproCob);
		
	}
	
	private void cargarComproCobrados(IDataSet dsComproCobrados, Recibo recibo) throws BaseException {
		Iterator iterComprobantesCobrados = recibo.getFacturasRecibo().iterator();
		while (iterComprobantesCobrados.hasNext()) {
			FacturasRecibo facturaRecibo = (FacturasRecibo) iterComprobantesCobrados.next();
			cargarRegistroComprobanteCobrado(dsComproCobrados,facturaRecibo);
		}
	}
	
	private void cargarRegistroComprobanteCobrado(IDataSet dsComproCobrados,FacturasRecibo facturaRecibo) throws BaseException {
		
		dsComproCobrados.append();
		dsComproCobrados.fieldValue("oid_recibo_comprobante", facturaRecibo.getOIDInteger());
		ComproCab comproCab = facturaRecibo.getTranClieVto().getTran_clie().getComprobante();
		dsComproCobrados.fieldValue("oid_cco_recibo", comproCab.getOIDInteger());
		dsComproCobrados.fieldValue("fecha_emision", comproCab.getEmision());
		dsComproCobrados.fieldValue("oid_cco", comproCab.getOIDInteger());
		dsComproCobrados.fieldValue("comprobante", comproCab.getCodigo());
		dsComproCobrados.fieldValue("moneda", facturaRecibo.getTranClieVto().getMoneda().getDescripcion());
		dsComproCobrados.fieldValue("importe", facturaRecibo.getImpo_mon_ori());
		dsComproCobrados.fieldValue("saldo", facturaRecibo.getSaldo_mon_ori());
		dsComproCobrados.fieldValue("impo_aplic_mon_compro", facturaRecibo.getImpo_cob_mon_ori());
		dsComproCobrados.fieldValue("impo_aplic_mon_recibo", facturaRecibo.getImpoCobMonRec());
		
	}
	
	
	private void cargarValoresRecibo(IDataSet dsValores, Recibo recibo) throws BaseException {
		Iterator iterValoresRecibo = recibo.getValoresRecibo().iterator();
		while (iterValoresRecibo.hasNext()) {
			ValoresRecibo valorRecibo = (ValoresRecibo) iterValoresRecibo.next();
			cargarRegistroValorRecibo(dsValores,valorRecibo);
		}
	}
	
	private void cargarRegistroValorRecibo(IDataSet dsValores,ValoresRecibo valorRecibo) throws BaseException {
		dsValores.append();
		dsValores.fieldValue("oid_recibo_valor", valorRecibo.getOIDInteger());
		dsValores.fieldValue("oid_cco_recibo", valorRecibo.getRecibo().getOIDInteger());
		dsValores.fieldValue("oid_tipo_valor", valorRecibo.getTipo_valor().getOIDInteger());
		dsValores.fieldValue("cod_tipo_valor", valorRecibo.getTipo_valor().getCodigo());
		dsValores.fieldValue("desc_tipo_valor", valorRecibo.getTipo_valor().getDescripcion());
		dsValores.fieldValue("desc_valor", valorRecibo.getDescripcion());
		dsValores.fieldValue("moneda_tipo_valor", valorRecibo.getTipo_valor().getMoneda().getDescripcion());
		dsValores.fieldValue("importe_mon_valor", valorRecibo.getImpo_mon_ori());
	}

	private void cargarRegistroReciboCab(IDataSet dataset, Recibo recibo) throws BaseException {
		dataset.append();
		
		enviarDatosEmpresa(dataset);
		enviarDatosSucursal(dataset);
		
		
		dataset.fieldValue("oid_cco_recibo", recibo.getOIDInteger());
		dataset.fieldValue("comprobante", recibo.getCodigo());
		dataset.fieldValue("observaciones", recibo.getComentario());
		dataset.fieldValue("tipo_comprobante", recibo.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", recibo.getLetra());
		dataset.fieldValue("codigo_letra", recibo.getTalonario().getCodigoLetra());
		dataset.fieldValue("lug_emi", recibo.getNroLugEmision());
		dataset.fieldValue("nro_ext", recibo.getNroExt());
		
		dataset.fieldValue("nro_ext_formateado", recibo.getNroExtFormat8Digitos());
		dataset.fieldValue("lug_emi_formateado", recibo.getLugEmiFormato4Digitos());
		
		
		dataset.fieldValue("fecha", recibo.getEmision());
		if (recibo.getSujeto() != null) {
			
			dataset.fieldValue("codigo_sujeto", recibo.getSujeto().getCodigo());
			dataset.fieldValue("rs_sujeto", recibo.getSujeto().getRazon_social());
			dataset.fieldValue("telefono_sujeto", recibo.getSujeto().getTelefonos());
			
			dataset.fieldValue("direccion_sujeto", recibo.getSujeto().getCalle_y_nro());
			dataset.fieldValue("localidad_sujeto", recibo.getSujeto().getLocalidad());
			dataset.fieldValue("localidad_cp_sujeto", recibo.getSujeto().getLocalidadyCP());
			
			if (recibo.getSujeto().getProvincia()!=null)
				dataset.fieldValue("provincia_sujeto", recibo.getSujeto().getProvincia().getDescripcion());
			else
				dataset.fieldValue("provincia_sujeto", "");
			
			if (recibo.getSujeto().getPais()!=null)
				dataset.fieldValue("pais_sujeto", recibo.getSujeto().getPais().getDescripcion());
			else
				dataset.fieldValue("pais_sujeto", "");
			
			dataset.fieldValue("provincia_pais_sujeto", recibo.getSujeto().getProvinciayPais());
						
			if (recibo.getSujeto().getSujeto_impositivo() != null) {
				dataset.fieldValue("cat_iva_sujeto", recibo.getSujeto().getSujeto_impositivo().getCategiva().getDescripcion());
				dataset.fieldValue("cuit_sujeto", recibo.getSujeto().getSujeto_impositivo().getCuit());
				dataset.fieldValue("nro_ing_brutos_sujeto", recibo.getSujeto().getSujeto_impositivo().getIngbrutos());
			}
			else {
				dataset.fieldValue("cat_iva_sujeto", "");
				dataset.fieldValue("cuit_sujeto", "");
				dataset.fieldValue("nro_ing_brutos_sujeto", "");
			}
			
		} else {
			
			dataset.fieldValue("codigo_sujeto", "");
			dataset.fieldValue("rs_sujeto", "");
			dataset.fieldValue("telefono_sujeto", "");
			dataset.fieldValue("cat_iva_sujeto", "");
			dataset.fieldValue("cuit_sujeto", "");
			dataset.fieldValue("nro_ing_brutos_sujeto", "");
			dataset.fieldValue("direccion_sujeto", "");
			dataset.fieldValue("localidad_sujeto", "");
			dataset.fieldValue("localidad_cp_sujeto", "");
			dataset.fieldValue("provincia_sujeto", "");
			dataset.fieldValue("pais_sujeto", "");
			dataset.fieldValue("provincia_pais_sujeto","");
			
		}
		
		dataset.fieldValue("cai", recibo.getTalonario().getCai());
		dataset.fieldValue("vto_cai", recibo.getTalonario().getFec_vto());
		
		dataset.fieldValue("motivo_cobranza" , recibo.getMotivoComprobante().getDescripcion());
		dataset.fieldValue("moneda_recibo" , recibo.getMoneda().getDescripcion());
		dataset.fieldValue("cotiz_moneda_recibo" , recibo.getCotizacion());
		dataset.fieldValue("caja",recibo.getCaja().getDescripcion());
		if (recibo.getCobrador()!=null)
			dataset.fieldValue("nom_y_ape_cobrador", recibo.getCobrador().getNombreyApellido());
		else
			dataset.fieldValue("nom_y_ape_cobrador", "");
		dataset.fieldValue("fecha_imputacion", recibo.getImputac());
		dataset.fieldValue("impo_tot_mom_recibo", recibo.getTot_mon_ori());
		
		
	}
	
	private IDataSet getDataSetValores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValores");
		
		// Datos de la empresa
		dataset.fieldDef(new Field("oid_recibo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_recibo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 255));
		dataset.fieldDef(new Field("moneda_tipo_valor", Field.STRING, 255));
		dataset.fieldDef(new Field("importe_mon_valor", Field.CURRENCY, 0));
				
		return dataset;
	}
	
	private IDataSet getDataSetComproCobrados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComprobantesCobrados");
		
		dataset.fieldDef(new Field("oid_recibo_comprobante", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_recibo", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha_emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 100));
		dataset.fieldDef(new Field("moneda", Field.STRING, 100));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_aplic_mon_compro", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_aplic_mon_recibo", Field.CURRENCY, 0));
		
		return dataset;
	}	
	

	private IDataSet getDataSetReciboCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TReciboCab");
		
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
		
		
		dataset.fieldDef(new Field("oid_cco_recibo", Field.INTEGER, 0));
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
		
		dataset.fieldDef(new Field("codigo_sujeto", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("telefono_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("cat_iva_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("cuit_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_ing_brutos_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("direccion_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("localidad_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("localidad_cp_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("provincia_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("pais_sujeto", Field.STRING, 100));
		dataset.fieldDef(new Field("provincia_pais_sujeto", Field.STRING, 255));
		
		dataset.fieldDef(new Field("cai", Field.STRING, 50));
		dataset.fieldDef(new Field("vto_cai", Field.DATE, 100));
		
		dataset.fieldDef(new Field("motivo_cobranza" , Field.STRING, 100));
		dataset.fieldDef(new Field("moneda_recibo" , Field.STRING, 100));
		dataset.fieldDef(new Field("cotiz_moneda_recibo" , Field.CURRENCY, 0));
		dataset.fieldDef(new Field("caja",Field.STRING, 100));
		dataset.fieldDef(new Field("nom_y_ape_cobrador", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha_imputacion", Field.DATE, 0));
		dataset.fieldDef(new Field("impo_tot_mom_recibo",Field.CURRENCY, 0));
		
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
		dataset.fieldDef(new Field("RECIBO_NRO", Field.STRING, 255));
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
		dataset.fieldDef(new Field("CLIENTE", Field.STRING, 255));
		dataset.fieldDef(new Field("CAT_IVA_CLIENTE", Field.STRING, 255));
		dataset.fieldDef(new Field("CUIT_CLIENTE", Field.STRING, 255));
		dataset.fieldDef(new Field("NRO_IB_CLIENTE", Field.STRING, 255));
		dataset.fieldDef(new Field("CODIGO_CLIENTE", Field.STRING, 255));
		dataset.fieldDef(new Field("CAI", Field.STRING, 255));
		dataset.fieldDef(new Field("VTO_CAI", Field.STRING, 255));

		dataset.fieldDef(new Field("MOTIVO_COBRANZA", Field.STRING, 255));
		dataset.fieldDef(new Field("MONEDA_RECIBO", Field.STRING, 255));
		dataset.fieldDef(new Field("COTIZ_MONEDA_RECIBO", Field.STRING, 255));
		dataset.fieldDef(new Field("CAJA", Field.STRING, 255));
		dataset.fieldDef(new Field("NOM_Y_APE_COBRADOR", Field.STRING, 255));
		dataset.fieldDef(new Field("FECHA_IMPUTACION", Field.STRING, 255));
		
		dataset.fieldDef(new Field("TIPO_VALOR", Field.STRING, 255));
		dataset.fieldDef(new Field("DESC_VALOR", Field.STRING, 255));
		dataset.fieldDef(new Field("MONEDA_VALOR", Field.STRING, 255));
		dataset.fieldDef(new Field("IMPORTE_VALOR", Field.STRING, 255));
		
		dataset.fieldDef(new Field("TITU_DET_VAL_REC", Field.STRING, 255));
		
		dataset.fieldDef(new Field("TITU_FAC_ND_COB", Field.STRING, 255));
		dataset.fieldDef(new Field("FEC_EMI_FACT_COB", Field.STRING, 255));
		dataset.fieldDef(new Field("COMPROBANTE_FACT_COB", Field.STRING, 255));
		dataset.fieldDef(new Field("MONEDA_FACT_COB", Field.STRING, 255));
		dataset.fieldDef(new Field("IMPORTE_FACT_COB", Field.STRING, 255));
		dataset.fieldDef(new Field("SALDO_FACT_COB", Field.STRING, 255));
		dataset.fieldDef(new Field("IMPO_APLIC_MON_FACTURA", Field.STRING, 255));
		dataset.fieldDef(new Field("IMPO_APLIC_MON_RECIBO", Field.STRING, 255));
		dataset.fieldDef(new Field("TOTAL_MONEDA_RECIBO", Field.STRING, 255));
		return dataset;
	}
	
	private void cargarLabels(IDataSet ds) throws BaseException {
		ds.append();
		ds.fieldValue("RECIBO_NRO",lt.getEtiqueta("RECIBO_NRO"));
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
		ds.fieldValue("CLIENTE", lt.getEtiqueta("CLIENTE"));
		ds.fieldValue("CAT_IVA_CLIENTE", lt.getEtiqueta("CAT_IVA_CLIENTE"));
		ds.fieldValue("CUIT_CLIENTE", lt.getEtiqueta("CUIT_CLIENTE"));
		ds.fieldValue("NRO_IB_CLIENTE", lt.getEtiqueta("NRO_IB_CLIENTE"));
		ds.fieldValue("CODIGO_CLIENTE", lt.getEtiqueta("CODIGO_CLIENTE"));
		ds.fieldValue("CAI", lt.getEtiqueta("CAI"));
		ds.fieldValue("VTO_CAI", lt.getEtiqueta("VTO_CAI"));
		ds.fieldValue("MOTIVO_COBRANZA", lt.getEtiqueta("MOTIVO_COBRANZA"));
		ds.fieldValue("MONEDA_RECIBO", lt.getEtiqueta("MONEDA_RECIBO"));
		ds.fieldValue("COTIZ_MONEDA_RECIBO", lt.getEtiqueta("COTIZ_MONEDA_RECIBO"));
		ds.fieldValue("CAJA", lt.getEtiqueta("CAJA"));
		ds.fieldValue("NOM_Y_APE_COBRADOR", lt.getEtiqueta("NOM_Y_APE_COBRADOR"));
		ds.fieldValue("FECHA_IMPUTACION", lt.getEtiqueta("FECHA_IMPUTACION"));
		ds.fieldValue("TIPO_VALOR", lt.getEtiqueta("TIPO_VALOR"));
		ds.fieldValue("DESC_VALOR", lt.getEtiqueta("DESC_VALOR"));
		ds.fieldValue("MONEDA_VALOR", lt.getEtiqueta("MONEDA_VALOR"));
		ds.fieldValue("IMPORTE_VALOR", lt.getEtiqueta("IMPORTE_VALOR"));
		ds.fieldValue("TITU_DET_VAL_REC", lt.getEtiqueta("TITU_DET_VAL_REC"));
		
		ds.fieldValue("TITU_FAC_ND_COB", lt.getEtiqueta("TITU_FAC_ND_COB"));
		ds.fieldValue("FEC_EMI_FACT_COB", lt.getEtiqueta("FEC_EMI_FACT_COB"));
		ds.fieldValue("COMPROBANTE_FACT_COB", lt.getEtiqueta("COMPROBANTE_FACT_COB"));
		ds.fieldValue("MONEDA_FACT_COB", lt.getEtiqueta("MONEDA_FACT_COB"));
		ds.fieldValue("IMPORTE_FACT_COB", lt.getEtiqueta("IMPORTE_FACT_COB"));
		ds.fieldValue("SALDO_FACT_COB", lt.getEtiqueta("SALDO_FACT_COB"));
		ds.fieldValue("IMPO_APLIC_MON_FACTURA", lt.getEtiqueta("IMPO_APLIC_MON_FACTURA"));
		ds.fieldValue("IMPO_APLIC_MON_RECIBO", lt.getEtiqueta("IMPO_APLIC_MON_RECIBO"));
		ds.fieldValue("TOTAL_MONEDA_RECIBO", lt.getEtiqueta("TOTAL_MONEDA_RECIBO"));
		
		
				
		
	}
	
	

}
