package com.srn.erp.pagos.op;

import java.util.Iterator;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EtiquetaIdioma;
import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.bm.LabelTranslator;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.pagos.bm.CertificadoRetGanCab;
import com.srn.erp.pagos.bm.CertificadoRetGanDet;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoDet;
import com.srn.erp.pagos.bm.ComproOrdenPagoMediosPago;
import com.srn.erp.pagos.bm.ImputacionPagosVarios;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionOP extends Operation {
	
	private LabelTranslator lt = null;


	public ImpresionOP() {
	}  

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsOPCab = getDataSetOPCab();
		IDataSet dsOPDet = getDataSetOPDet();
		IDataSet dsLabels = getDataSetLabels();
		IDataSet dsMediosPago = getDataSetMediosPago();
		IDataSet dsCtasOpDet = getDataSetCtasOPDet();
		IDataSet dsCertRetGanCab = getDataSetCertRetGanCab();
		IDataSet dsCertRegGanDet = getDataSetCertRetGanDet();

		lt = new LabelTranslator(this.getSesion());
		lt.setNickName(ComproOrdenPagoCab.NICKNAME);
		lt.setIdioma(Idioma.getIdiomaLocal(this.getSesion()));		
		
		ComproOrdenPagoCab op = ComproOrdenPagoCab.findByOid(mapaDatos.getInteger("oid_cco"), getSesion());
		
		if ((op.getProveedor()!=null) && (op.getProveedor().getIdioma()!=null))
			lt.setIdioma(op.getProveedor().getIdioma());
		
		cargarRegistroOPCab(dsOPCab,op);
		
		
		if (op.getVencimientosPagados().size()!=0) {
		
			Iterator iterVencimientosPag = 
				op.getVencimientosPagados().iterator();
			while (iterVencimientosPag.hasNext()) {
				ComproOrdenPagoDet comproOrdenPagoDet = (ComproOrdenPagoDet) iterVencimientosPag.next();
				cargarRegistroOPDet(dsOPDet, op , comproOrdenPagoDet);
			}
			
		} else {
			cargarRegistroOPACuenta(dsOPDet, op );
		}
		
		Iterator iterPagosVarios =
			op.getImputacionesOPVarias().iterator();
		while (iterPagosVarios.hasNext()) {
			ImputacionPagosVarios imputacionPagosVarios = (ImputacionPagosVarios) iterPagosVarios.next();
			cargarRegistroPagosVarios(dsCtasOpDet, imputacionPagosVarios);
		}
		
		Iterator iterMediosPagos =
			op.getMediosPagos().iterator();
		while (iterMediosPagos.hasNext()) {
			ComproOrdenPagoMediosPago comproOrdenPagoMediosPago = (ComproOrdenPagoMediosPago) iterMediosPagos.next();
			cargarRegistroMedioPago(dsMediosPago,comproOrdenPagoMediosPago);
		}
		
		CertificadoRetGanCab certRetGan = op.getCertificadoRetGan();
		if (certRetGan!=null)
			cargarCertRetGan(dsCertRetGanCab,dsCertRegGanDet,certRetGan);
		
		cargarEtiquetas(dsLabels);
		
		writeCliente(dsOPCab);
		writeCliente(dsOPDet);
		writeCliente(dsLabels);
		writeCliente(dsMediosPago);
		writeCliente(dsCtasOpDet);
		writeCliente(dsCertRetGanCab);
		writeCliente(dsCertRegGanDet);
		
	}


	private IDataSet getDataSetOPCab() {
	  IDataSet dataset = new TDataSet();
	  dataset.create("TOPCab");
			
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
	  dataset.fieldDef(new Field("empresa_cuit", Field.STRING, 100));
	  dataset.fieldDef(new Field("empresa_cat_iva", Field.STRING, 100));
	  dataset.fieldDef(new Field("empresa_nro_ib", Field.STRING, 100));
	  dataset.fieldDef(new Field("empresa_cat_ib", Field.STRING, 100));
	  dataset.fieldDef(new Field("empresa_incio_act", Field.DATE, 0));
	  
	  
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
								
	  // Datos generales del comprobantes
	  dataset.fieldDef(new Field("oid_cco_op", Field.INTEGER, 0));
	  dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
	  dataset.fieldDef(new Field("cod_tc",Field.STRING, 50));
	  dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
	  dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 30));
	  dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
	  dataset.fieldDef(new Field("cat_iva_proveedor", Field.STRING, 100));
	  dataset.fieldDef(new Field("cuit_proveedor", Field.STRING, 100));
	  
	  
	  dataset.fieldDef(new Field("letra", Field.STRING, 0));
	  dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
	  dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
	  dataset.fieldDef(new Field("lug_emi_y_nro_ext", Field.STRING, 100));
	  dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
	  dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
	  dataset.fieldDef(new Field("desc_moneda", Field.STRING, 50));
	  dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
	  dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
	  
	  // Datos adicionales
	  dataset.fieldDef(new Field("oid_motivo_pago", Field.INTEGER, 0));
	  dataset.fieldDef(new Field("desc_motivo_pago", Field.STRING, 100));
	  dataset.fieldDef(new Field("comportamiento_op", Field.STRING, 100));
	  dataset.fieldDef(new Field("ret_iva", Field.CURRENCY, 0));
	  dataset.fieldDef(new Field("ret_gan", Field.CURRENCY, 0));
	  dataset.fieldDef(new Field("ret_ib", Field.CURRENCY, 0));
	  dataset.fieldDef(new Field("ret_ib_cf", Field.CURRENCY, 0));
	  dataset.fieldDef(new Field("ret_sus", Field.CURRENCY, 0));
	  dataset.fieldDef(new Field("total_neto", Field.CURRENCY, 0));
	  dataset.fieldDef(new Field("total_bruto", Field.CURRENCY, 0));
	  
  	  return dataset;
	}

	private IDataSet getDataSetOPDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOPDet");
		dataset.fieldDef(new Field("oid_op_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_op", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("vto", Field.DATE, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("moneda", Field.STRING, 50));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("imp_a_pagar_mon_op", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_cuota", Field.INTEGER, 0));
		
		return dataset;
	}
	
	private IDataSet getDataSetCertRetGanCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCerRetGanCab");
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_cert_ret_gan", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_op", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("cat_ret_gan", Field.STRING, 100));
		dataset.fieldDef(new Field("porc_lib", Field.CURRENCY, 100));
		dataset.fieldDef(new Field("decreto", Field.STRING, 100));
		dataset.fieldDef(new Field("lug_emi_y_nro_ext", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_certificado", Field.INTEGER, 0));
		dataset.fieldDef(new Field("direccion", Field.STRING, 1000));
		dataset.fieldDef(new Field("categoria_iva", Field.STRING, 100));
		dataset.fieldDef(new Field("cuit", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_orden_de_pago", Field.INTEGER, 0));
		
		
		return dataset;
	}
	
	private IDataSet getDataSetCtasOPDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCtasOPDet");
		dataset.fieldDef(new Field("oid_cta_op_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_op", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_ai", Field.MEMO, 0));
		dataset.fieldDef(new Field("desc_ai", Field.MEMO, 0));
		dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
		dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
		return dataset;
	}
	
	private void cargarRegistroPagosVarios(
			IDataSet ds, 
			ImputacionPagosVarios imputacionPagosVarios) throws BaseException {

		ds.append();
		ds.fieldValue("oid_cta_op_det", imputacionPagosVarios.getOIDInteger());
		ds.fieldValue("oid_op", imputacionPagosVarios.getComprobante().getOIDInteger());
		ds.fieldValue("oid_ai", imputacionPagosVarios.getCuenta_imputable().getOIDInteger());
		ds.fieldValue("codigo_ai", imputacionPagosVarios.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
		ds.fieldValue("desc_ai", imputacionPagosVarios.getCuenta_imputable().getDescCuentaMasDescValCompo());
		ds.fieldValue("observacion", imputacionPagosVarios.getComentario());
		ds.fieldValue("debe", imputacionPagosVarios.getDebe_mon_pago());
		ds.fieldValue("haber", imputacionPagosVarios.getHaber_mon_pago());
		
		
	}
	

	private IDataSet getDataSetCertRetGanDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCerRetGanDet");
		dataset.fieldDef(new Field("oid_cco_cert_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cert_ret_gan", Field.INTEGER, 0));
		dataset.fieldDef(new Field("conc_ret_gan", Field.STRING, 100));
		dataset.fieldDef(new Field("pagos_acum", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ret_acum", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pago_neto", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impu_retenido", Field.CURRENCY, 0));
		return dataset;
	}
	
	
	
	
	
	private IDataSet getDataSetMediosPago() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMediosPago");
		dataset.fieldDef(new Field("oid_op_medio_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_op", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("nro_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_entidad", Field.STRING, 100));
		dataset.fieldDef(new Field("emision", Field.DATE, 0));
		dataset.fieldDef(new Field("vto", Field.DATE, 0));
		dataset.fieldDef(new Field("desc_mon_ori", Field.STRING, 100));
		dataset.fieldDef(new Field("impo_mon_valor", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_mon_pago", Field.CURRENCY, 0));		
		dataset.fieldDef(new Field("desc_valor", Field.STRING, 500));
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
		
		dataset.fieldValue("empresa_cuit", empresa.getCuit());
		if (empresa.getCategoria_iva()!=null)
			dataset.fieldValue("empresa_cat_iva", empresa.getCategoria_iva().getDescripcion());
		else
			dataset.fieldValue("empresa_cat_iva", "");
			
	    
		dataset.fieldValue("empresa_nro_ib", empresa.getNro_ing_brutos());
		if (empresa.getCategoria_ib()!=null)
			dataset.fieldValue("empresa_cat_ib", empresa.getCategoria_ib().getDescripcion());
		else
			dataset.fieldValue("empresa_cat_ib", "");
			
		dataset.fieldValue("empresa_incio_act", empresa.getInicioActividad());
		
		
		
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
	
	
	private void cargarRegistroOPCab(
			IDataSet dataset,
			ComproOrdenPagoCab op) throws BaseException {
		
		dataset.append();
		
		enviarDatosEmpresa(dataset);
		enviarDatosSucursal(dataset);
		
		dataset.fieldValue("oid_cco_op", op.getOIDInteger());
		dataset.fieldValue("oid_talonario", op.getTalonario().getOIDInteger());
		dataset.fieldValue("cod_tc", op.getTipoCompro().getCodigo());
		dataset.fieldValue("oid_tc", op.getTipoCompro().getOIDInteger());
		if (op.getProveedor()!=null) {
			dataset.fieldValue("cod_proveedor", op.getProveedor().getCodigo());
			dataset.fieldValue("rs_proveedor", op.getProveedor().getRazonsocial());
		} else {
			dataset.fieldValue("cod_proveedor", "");
			dataset.fieldValue("rs_proveedor", "");
		}
		
		if ((op.getProveedor()!=null) && (op.getProveedor().getSujetoimpositivo()!=null) && (op.getProveedor().getSujetoimpositivo().getCategiva()!=null))
			dataset.fieldValue("cat_iva_proveedor", op.getProveedor().getSujetoimpositivo().getCategiva().getDescripcion());
		else
			dataset.fieldValue("cat_iva_proveedor", "");
		if ((op.getProveedor()!=null) && (op.getProveedor().getSujetoimpositivo()!=null))
			dataset.fieldValue("cuit_proveedor", op.getProveedor().getSujetoimpositivo().getCUITFormateado());
		else
			dataset.fieldValue("cuit_proveedor", "");
		
		
		dataset.fieldValue("letra", op.getLetra());
		dataset.fieldValue("lug_emi", op.getLugarEmision().getLugemi());
		dataset.fieldValue("nro_ext", op.getNroExt());
		dataset.fieldValue("lug_emi_y_nro_ext", op.getLugEmiNroExt(op.getLugarEmision().getLugemi(), op.getNroExt()));
		if (op.getProveedor()!=null)
			dataset.fieldValue("oid_proveedor", op.getProveedor().getOIDInteger());
		else
			dataset.fieldValue("oid_proveedor", "");
		dataset.fieldValue("oid_moneda", op.getMoneda().getOIDInteger());
		dataset.fieldValue("desc_moneda", op.getMoneda().getDescripcion());
		dataset.fieldValue("cotizacion", op.getCotizacion());
		dataset.fieldValue("fec_emision", op.getEmision());
		  
		// Datos adicionales
		dataset.fieldValue("oid_motivo_pago", op.getMotivopago().getOIDInteger());
		dataset.fieldValue("desc_motivo_pago", op.getMotivopago().getDescripcion());
		dataset.fieldValue("comportamiento_op", op.getMotivopago().getCompo());
		
		dataset.fieldValue("ret_iva", op.getRetIVA());
		dataset.fieldValue("ret_gan", op.getRetGan());
		dataset.fieldValue("ret_ib", op.getRetIB());
		dataset.fieldValue("ret_ib_cf", new Money(0));
		dataset.fieldValue("ret_sus", op.getRetSUS());
		
		if (op.getMotivopago().isPagosVarios()) {
			dataset.fieldValue("total_neto", op.getTotalPago());
			dataset.fieldValue("total_bruto", op.getBruto());
		}
		else
			if (op.getVencimientosPagados().size()!=0) { 
				dataset.fieldValue("total_neto", op.getTotalPago());
				dataset.fieldValue("total_bruto", op.getBruto());
			}
			else {
				dataset.fieldValue("total_neto", op.getPagoACuenta());
				dataset.fieldValue("total_bruto", op.getPagoACuenta());
			}
		
		
		
	}
	
	private void cargarRegistroOPDet(IDataSet dataset, 
									 ComproOrdenPagoCab opCab,
									 ComproOrdenPagoDet opDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_op_det", opDet.getOIDInteger());
		dataset.fieldValue("oid_cco_op", opCab.getOIDInteger());
		dataset.fieldValue("oid_cco_fact", opDet.getComprobantePagado().getOIDInteger());
		dataset.fieldValue("comprobante", opDet.getComprobantePagado().getCodigo());
		dataset.fieldValue("fecha", opDet.getComprobantePagado().getEmision());
		if (opDet.getTranprovvto()!=null)
			dataset.fieldValue("vto", opDet.getTranprovvto().getVencimiento());
		else
			dataset.fieldValue("vto", "");
		dataset.fieldValue("importe", opDet.getNetopagomonori());
		dataset.fieldValue("moneda", opDet.getMoneda().getDescripcion());
		dataset.fieldValue("cotizacion", opDet.getCotizacion());
		dataset.fieldValue("imp_a_pagar_mon_op", opDet.getNetopagomonpago());
		if (opDet.getTranprovvto()!=null)
			dataset.fieldValue("nro_cuota", opDet.getTranprovvto().getNroCuota());
		else
			dataset.fieldValue("nro_cuota", "");
		
		
	}
	
	private void cargarRegistroOPACuenta(IDataSet dataset, 
			 ComproOrdenPagoCab opCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_op_det", new Integer(1));
		dataset.fieldValue("oid_cco_op", opCab.getOIDInteger());
		dataset.fieldValue("oid_cco_fact", "");
		dataset.fieldValue("comprobante", "Pago a Cuenta");
		dataset.fieldValue("fecha", "");
		dataset.fieldValue("vto", "");
		dataset.fieldValue("importe", opCab.getPagoACuenta());
		dataset.fieldValue("moneda", opCab.getMoneda().getDescripcion());
		dataset.fieldValue("cotizacion", opCab.getCotizacion());
		dataset.fieldValue("imp_a_pagar_mon_op", opCab.getPagoACuenta());
		dataset.fieldValue("nro_cuota", "");


	}
	
	private void cargarRegistroMedioPago(IDataSet dataset, 
			ComproOrdenPagoMediosPago comproOrdenPagoMediosPago) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_op_medio_pago", comproOrdenPagoMediosPago.getOIDInteger());
		dataset.fieldValue("oid_cco_op", comproOrdenPagoMediosPago.getComprobante().getOIDInteger());
		if (comproOrdenPagoMediosPago.getValor()!=null)
			dataset.fieldValue("oid_valor", comproOrdenPagoMediosPago.getValor().getOIDInteger());
		else
			dataset.fieldValue("oid_valor", new Integer(0));
		dataset.fieldValue("oid_tipo_valor", comproOrdenPagoMediosPago.getTipovalor().getOIDInteger());
		dataset.fieldValue("desc_tipo_valor", comproOrdenPagoMediosPago.getTipovalor().getDescripcion());
		if (comproOrdenPagoMediosPago.getValor()!=null) {
			dataset.fieldValue("nro_valor", comproOrdenPagoMediosPago.getValor().getNroValorGenerico());
			dataset.fieldValue("desc_entidad", comproOrdenPagoMediosPago.getValor().getDescEntidad());
			dataset.fieldValue("emision", comproOrdenPagoMediosPago.getValor().getFechaemision());
			dataset.fieldValue("vto", comproOrdenPagoMediosPago.getValor().getFechavto());
			dataset.fieldValue("desc_mon_ori", comproOrdenPagoMediosPago.getTipovalor().getMoneda().getDescripcion());
		}
		else { 
			dataset.fieldValue("nro_valor", "");
			dataset.fieldValue("desc_entidad", "");
			dataset.fieldValue("emision", Fecha.FECHA_NULA());
			dataset.fieldValue("vto", Fecha.FECHA_NULA());
			dataset.fieldValue("desc_mon_ori", comproOrdenPagoMediosPago.getTipovalor().getMoneda().getDescripcion());
		}
		
		dataset.fieldValue("impo_mon_valor", comproOrdenPagoMediosPago.getImpomonvalor());
		dataset.fieldValue("cotizacion", comproOrdenPagoMediosPago.getCotizacion());
		dataset.fieldValue("impo_mon_pago", comproOrdenPagoMediosPago.getImpomonpago());
		if (comproOrdenPagoMediosPago.getValor()!=null)
			dataset.fieldValue("desc_valor", comproOrdenPagoMediosPago.getValor().getDescripcion());
		else
			dataset.fieldValue("desc_valor", "");
		

	}
	
	private void cargarCertRetGan(IDataSet ds,IDataSet dsDet,CertificadoRetGanCab certRetGan) throws BaseException {
		ds.append();
		ds.fieldValue("fecha", certRetGan.getEmision());
		ds.fieldValue("oid_cert_ret_gan", certRetGan.getOIDInteger());
		ds.fieldValue("oid_cco_op", certRetGan.getOrdendepago().getOIDInteger());
		ds.fieldValue("oid_proveedor", certRetGan.getProveedor().getOIDInteger());
		ds.fieldValue("cod_proveedor", certRetGan.getProveedor().getCodigo());
		ds.fieldValue("rs_proveedor", certRetGan.getProveedor().getRazonsocial());
		if ((certRetGan.getProveedor().getSujetoimpositivo()!=null) && (certRetGan.getProveedor().getSujetoimpositivo().getCateggan()!=null))
			ds.fieldValue("cat_ret_gan", certRetGan.getProveedor().getSujetoimpositivo().getCateggan().getDescripcion());
		else
			ds.fieldValue("cat_ret_gan", "");
		ds.fieldValue("porc_lib", certRetGan.getPorclib());
		ds.fieldValue("decreto", certRetGan.getDecreto());
		ds.fieldValue("lug_emi_y_nro_ext", certRetGan.getLugEmiNroExt(certRetGan.getLugarEmision().getLugemi(), certRetGan.getNroExt()));
		ds.fieldValue("nro_certificado", certRetGan.getNroExt());
		ds.fieldValue("direccion", certRetGan.getProveedor().getDireccionCompleta());
		if ((certRetGan.getProveedor().getSujetoimpositivo()!=null) && (certRetGan.getProveedor().getSujetoimpositivo().getCategiva()!=null)) 
			ds.fieldValue("categoria_iva", certRetGan.getProveedor().getSujetoimpositivo().getCategiva().getDescripcion());
		else
			ds.fieldValue("categoria_iva", "");
		if (certRetGan.getProveedor().getSujetoimpositivo()!=null)
			ds.fieldValue("cuit", certRetGan.getProveedor().getSujetoimpositivo().getCuit());
		else
			ds.fieldValue("cuit", "");
		ds.fieldValue("nro_orden_de_pago", certRetGan.getOrdendepago().getNroExt());
		
		Iterator iterDetalles = certRetGan.getDetallesCertificado().iterator();
		while (iterDetalles.hasNext()) {
			CertificadoRetGanDet certRetGanDet = (CertificadoRetGanDet) iterDetalles.next();
			dsDet.append();
			dsDet.fieldValue("oid_cco_cert_det", certRetGanDet.getOIDInteger());
			dsDet.fieldValue("oid_cert_ret_gan", certRetGanDet.getCertificado().getOIDInteger());
			dsDet.fieldValue("conc_ret_gan", certRetGanDet.getConceptoimpuesto().getDescripcion());
			dsDet.fieldValue("pagos_acum", certRetGanDet.getPagoacum());
			dsDet.fieldValue("ret_acum", certRetGanDet.getRetacum());
			dsDet.fieldValue("pago_neto", certRetGanDet.getPagoneto());
			dsDet.fieldValue("impu_retenido", certRetGanDet.getImpuestoretenido());
		}
		
		
		
	}
	
	
	private void cargarEtiquetas(IDataSet ds) throws BaseException {
		Iterator iterEtiquetas = 
			EtiquetaIdioma.getEtiquetasComprobante(
					ComproOrdenPagoCab.NICKNAME,this.getSesion()).iterator();
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
	
	

}
	