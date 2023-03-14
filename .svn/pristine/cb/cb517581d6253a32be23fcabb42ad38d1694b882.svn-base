package com.srn.erp.pagos.op;

import java.util.Iterator;

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

public class TraerOP extends Operation {

	public TraerOP() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oid = mapaDatos.getInteger("oid");
		ComproOrdenPagoCab comproOPCab = ComproOrdenPagoCab.findByOid(oid, getSesion());
		
		IDataSet dsOPCab = getDataSetOPCab();
		IDataSet dsVtosPagados = getDataSetVtosPagados();
		IDataSet dsMediosPago = getDataSetMediosPago();
		IDataSet dsCalcTotPagos = getDataSetCalcMontosOP();
		IDataSet dsImpuPagVarios = getDataSetImputacionPagosVarios();
		
		cargarRegistroOP(dsOPCab,comproOPCab);
		cargarRegistroCalcTotOP(dsCalcTotPagos,comproOPCab);
		
		Iterator iterVtosPagados = 
			comproOPCab.getVencimientosPagados().iterator();
		while (iterVtosPagados.hasNext()) {
			ComproOrdenPagoDet comproOPDet = (ComproOrdenPagoDet) iterVtosPagados.next();
			cargarRegistroOPDet(dsVtosPagados,comproOPDet);
		}
		
		Iterator iterMediosPago = 
			comproOPCab.getMediosPagos().iterator();
		while (iterMediosPago.hasNext()) {
			ComproOrdenPagoMediosPago medioPago = (ComproOrdenPagoMediosPago) iterMediosPago.next();
			cargarRegistroMedioPago(dsMediosPago,medioPago);
		}
		
		Iterator iterImpuOPVarias =
			comproOPCab.getImputacionesOPVarias().iterator();
		while (iterImpuOPVarias.hasNext()) {
			ImputacionPagosVarios impuPagVarias = 
				(ImputacionPagosVarios) iterImpuOPVarias.next();
			cargarRegistroImputacionPagosVarios(dsImpuPagVarios, impuPagVarias);
		}
		
		
		writeCliente(dsOPCab);
		writeCliente(dsVtosPagados);
		writeCliente(dsMediosPago);
		writeCliente(dsCalcTotPagos);
		writeCliente(dsImpuPagVarios);
		
		
	}
	
	private void cargarRegistroMedioPago(IDataSet ds,ComproOrdenPagoMediosPago medioPago) throws BaseException {
		ds.append();
		ds.fieldValue("oid_op_medio_pago", medioPago.getOIDInteger());
		ds.fieldValue("oid_cco", medioPago.getComprobante().getOIDInteger());
		ds.fieldValue("codigo_valor", medioPago.getTipovalor().getCodigo());
		ds.fieldValue("desc_valor", medioPago.getTipovalor().getDescripcion());
		if (medioPago.getValor()!=null)
			ds.fieldValue("oid_valor", medioPago.getValor().getOIDInteger());
		else
			ds.fieldValue("oid_valor", new Integer(0));
		ds.fieldValue("oid_tipo_valor", medioPago.getTipovalor().getOIDInteger());
		ds.fieldValue("cotizacion", medioPago.getCotizacion());
		ds.fieldValue("impo_mon_pago", medioPago.getImpomonpago());
		ds.fieldValue("impo_mon_valor", medioPago.getImpomonvalor());
		ds.fieldValue("oid_moneda_valor", medioPago.getTipovalor().getMoneda().getOIDInteger());
		ds.fieldValue("compo_valor",medioPago.getTipovalor().getCompo());
		ds.fieldValue("oid_entidad",new Integer(0));
		
		
		if (medioPago.getValor()!=null) {
			ds.fieldValue("codigo_entidad",medioPago.getValor().getCodEntidad());
			ds.fieldValue("desc_entidad",medioPago.getValor().getDescEntidad());
			ds.fieldValue("nro_valor",medioPago.getValor().getNroValorGenerico());
			ds.fieldValue("fec_emision",medioPago.getValor().getFechaemision());
			ds.fieldValue("fec_vto",medioPago.getValor().getFechavto());
		} else if (medioPago.getTipovalor().isEfectivo()) {
			if (medioPago.getCaja()!=null) {
				ds.fieldValue("codigo_entidad",medioPago.getCaja().getCodigo());
				ds.fieldValue("desc_entidad",medioPago.getCaja().getDescripcion());
			} else {
				ds.fieldValue("codigo_entidad","");
				ds.fieldValue("desc_entidad","");
			}
			ds.fieldValue("nro_valor","");
			ds.fieldValue("fec_emision",Fecha.FECHA_NULA());
			ds.fieldValue("fec_vto",Fecha.FECHA_NULA());
		} else
		{
			ds.fieldValue("codigo_entidad","");
			ds.fieldValue("desc_entidad","");
			ds.fieldValue("nro_valor","");
			ds.fieldValue("fec_emision",Fecha.FECHA_NULA());
			ds.fieldValue("fec_vto",Fecha.FECHA_NULA());
		}
		ds.fieldValue("orden",new Integer(0));
		
	}
	
	private void cargarRegistroCalcTotOP(IDataSet ds,ComproOrdenPagoCab op) throws BaseException {
		ds.append();
		ds.fieldValue("oid", op.getOIDInteger());
		ds.fieldValue("bruto", op.getBruto()); 
		ds.fieldValue("descuento", op.getDescuento());
		ds.fieldValue("neto_descuento", op.getNeto());
		ds.fieldValue("ret_iva", op.getRetIVA());
		ds.fieldValue("ret_gan", op.getRetGan());
		ds.fieldValue("ret_ib", op.getRetIB());
		ds.fieldValue("ret_sus", op.getRetSUS());
		ds.fieldValue("a_pagar", op.getTotalPago());
		ds.fieldValue("a_pagar_sin_anticipos", op.getTotalPago());
	}
	
	private void cargarRegistroOP(IDataSet ds,ComproOrdenPagoCab op) throws BaseException {
		ds.append();
		ds.fieldValue("oid", op.getOID());
		ds.fieldValue("oid_motivo_pago", op.getMotivopago().getOIDInteger());
		ds.fieldValue("fecha", op.getEmision());
		ds.fieldValue("oid_moneda", op.getMoneda().getOIDInteger());
		if (op.getProveedor()!=null) {
			ds.fieldValue("oid_proveedor", op.getProveedor().getOIDInteger());
			ds.fieldValue("codigo_proveedor", op.getProveedor().getCodigo());
			ds.fieldValue("razon_social_proveedor", op.getProveedor().getRazonsocial());
		} else {
			ds.fieldValue("oid_proveedor", 0);
			ds.fieldValue("codigo_proveedor", "");
			ds.fieldValue("razon_social_proveedor", "");
		}
		ds.fieldValue("oid_forma_pago", new Integer(0));
		ds.fieldValue("dias", new Integer(0));
		ds.fieldValue("cotizacion", op.getCotizacion());
		ds.fieldValue("ret_gan_mon_pago", op.getRetGanMonPago());
		ds.fieldValue("pago_cta_mon_pago", op.getPagoACuenta());
		ds.fieldValue("oid_talonario", op.getTalonario().getOIDInteger());
		
		if (op.getFormaPago()!=null)
			ds.fieldValue("oid_forma_pago", op.getFormaPago().getOIDInteger());
		else
			ds.fieldValue("oid_forma_pago", new Integer(0));
		
		ds.fieldValue("activo", op.isActivo());
		ds.fieldValue("nro_ext", op.getNroExt());
		
	}
	
	private void cargarRegistroOPDet(IDataSet ds,ComproOrdenPagoDet opDet) throws BaseException {
		ds.append();
		
		ds.fieldValue("oid",opDet.getOIDInteger());
		ds.fieldValue("orden",new Integer(0));
		if (opDet.getTranprovvto()!=null)
			ds.fieldValue("oid_tran_vto",opDet.getTranprovvto().getOIDInteger());
		else
			ds.fieldValue("oid_tran_vto","");
		ds.fieldValue("oid_cco",opDet.getComprobante().getOIDInteger());
		if (opDet.getTranprovvto()!=null)
			ds.fieldValue("oid_tran_prov",opDet.getTranprovvto().getTranprov().getOIDInteger());
		else
			ds.fieldValue("oid_tran_prov","");
		ds.fieldValue("saldo_cuota",opDet.getSaldoCuota());
		ds.fieldValue("impo_cuota", opDet.getImporteCuota());
		if (opDet.getTranprovvto()!=null)
			ds.fieldValue("oid_moneda", opDet.getTranprovvto().getMoneda().getOIDInteger());
		else
			ds.fieldValue("oid_moneda", "");
		
		if (opDet.getTranprovvto()!=null) {
			ds.fieldValue("moneda", opDet.getTranprovvto().getMoneda().getCodigo());
			ds.fieldValue("oid_tipo_cta_prov", opDet.getTranprovvto().getTranprov().getTipocuenta().getOIDInteger());
			ds.fieldValue("tipo_cta_prov", opDet.getTranprovvto().getTranprov().getTipocuenta().getDescripcion());
			ds.fieldValue("oid_proveedor", opDet.getTranprovvto().getTranprov().getProveedor().getOIDInteger());
			ds.fieldValue("rs_proveedor", opDet.getTranprovvto().getTranprov().getProveedor().getRazonsocial());
			ds.fieldValue("comprobante",opDet.getTranprovvto().getTranprov().getComprobante().getCodigo());
			ds.fieldValue("fec_emision", opDet.getTranprovvto().getTranprov().getComprobante().getEmision());
		} else if (opDet.getComproAntProv()!=null) {
			ds.fieldValue("moneda", opDet.getComproAntProv().getMoneda().getCodigo());
			ds.fieldValue("oid_tipo_cta_prov", opDet.getComproAntProv().getTipoCtaCteProv().getOIDInteger());
			ds.fieldValue("tipo_cta_prov", opDet.getComproAntProv().getTipoCtaCteProv().getDescripcion());
			ds.fieldValue("oid_proveedor", opDet.getComproAntProv().getProveedor().getOIDInteger());
			ds.fieldValue("rs_proveedor", opDet.getComproAntProv().getProveedor().getRazonsocial());
			ds.fieldValue("comprobante", opDet.getComproAntProv().getCodigo());
			ds.fieldValue("fec_emision", opDet.getComproAntProv().getEmision());
		} else {
			ds.fieldValue("moneda", "");
			ds.fieldValue("oid_tipo_cta_prov", "");
			ds.fieldValue("tipo_cta_prov", "");
			ds.fieldValue("oid_proveedor", "");
			ds.fieldValue("rs_proveedor", "");
			ds.fieldValue("comprobante", "");
			ds.fieldValue("fec_emision", "");
		}
		ds.fieldValue("tot_mon_ori",opDet.getImpofactmonori());
		ds.fieldValue("saldo_mon_ori", new Money(0));
		ds.fieldValue("monto_autorizado",opDet.getImpoautorizmonori());
		ds.fieldValue("importe_aplicado", new Money(0));
		ds.fieldValue("saldo_con_aplic",new Money(0));
		ds.fieldValue("cotiz_mon_ori",new Money(0));
		ds.fieldValue("cotiz_mon_ext1",new Money(0));
		ds.fieldValue("cotiz_mon_ext2",new Money(0));
		ds.fieldValue("cotiz_mon_ext1_co",new Money(0));
		ds.fieldValue("cotiz_mon_ext2_co",new Money(0));
		ds.fieldValue("cotiz_mon_ori_co",new Money(0));
		if (opDet.getTranprovvto()!=null)
			ds.fieldValue("vto",opDet.getTranprovvto().getVencimiento());
		else
			ds.fieldValue("vto","");
		ds.fieldValue("seleccionar",new Boolean(false));
		ds.fieldValue("descuento",opDet.getDtomonori());
		ds.fieldValue("porc_descuento",new Money(0));
		ds.fieldValue("autorizado", opDet.getAutorizado());
		ds.fieldValue("max_autoriz_pago", opDet.getImpomaxautorizori());
		ds.fieldValue("a_pagar", opDet.getPagar());
		ds.fieldValue("oid_cco_ant_prov", new Integer(0));
		ds.fieldValue("primer_cuota", new Integer(0));
		
		
	}
	

	private IDataSet getDataSetOPCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TOrdPagoCab");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_proveedor", Field.STRING, 50));
		dataset.fieldDef(new Field("razon_social_proveedor", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_forma_pago",Field.INTEGER, 0));
		dataset.fieldDef(new Field("dias",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ret_gan_mon_pago", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pago_cta_mon_pago", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_forma_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetVtosPagados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TVistaCtaCteProv");
		dataset.fieldDef(new Field("oid",Field.INTEGER, 0));
		dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tran_vto",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tran_prov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("saldo_cuota",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_cuota",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
		dataset.fieldDef(new Field("moneda",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_tipo_cta_prov",Field.INTEGER, 50));
		dataset.fieldDef(new Field("tipo_cta_prov",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_proveedor",Field.INTEGER, 0));
		dataset.fieldDef(new Field("rs_proveedor",Field.STRING, 100));
		dataset.fieldDef(new Field("comprobante",Field.STRING, 100));
		dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
		dataset.fieldDef(new Field("tot_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("monto_autorizado",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe_aplicado",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo_con_aplic",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext1",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext2",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext1_co",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ext2_co",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotiz_mon_ori_co",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("vto",Field.DATE, 0));
		dataset.fieldDef(new Field("seleccionar",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("descuento",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_descuento",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("autorizado",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("max_autoriz_pago",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("a_pagar",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_cco_ant_prov",Field.INTEGER, 0));
		dataset.fieldDef(new Field("primer_cuota",Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetMediosPago() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMediosPago");
		dataset.fieldDef(new Field("oid_op_medio_pago",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco",Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_valor",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_valor",Field.STRING, 200));
		dataset.fieldDef(new Field("oid_valor",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_valor",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_mon_pago",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_mon_valor",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("oid_moneda_valor",Field.INTEGER, 0));
		dataset.fieldDef(new Field("compo_valor",Field.STRING, 50));
		dataset.fieldDef(new Field("oid_entidad",Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_entidad",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_entidad",Field.STRING, 255));
		dataset.fieldDef(new Field("nro_valor",Field.INTEGER, 0));
		dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
		dataset.fieldDef(new Field("fec_vto",Field.DATE, 0));
		dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetCalcMontosOP() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCalculoMontosOP");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("bruto", Field.CURRENCY, 0)); 
		dataset.fieldDef(new Field("descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("neto_descuento", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ret_iva", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ret_gan", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ret_ib", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("ret_sus", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("a_pagar", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("a_pagar_sin_anticipos", Field.CURRENCY, 0));
		return dataset;
	}
	
	private IDataSet getDataSetImputacionPagosVarios() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TImputacionPagosVarios");
		    dataset.fieldDef(new Field("oid_impu_op_varias", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("oid_ana_imp", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("cod_ana_imp", Field.STRING, 255));
		    dataset.fieldDef(new Field("desc_ana_imp", Field.INTEGER, 1000));
		    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("debe_mon_pago", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("haber_mon_pago", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("debe_mon_loc", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("haber_mon_loc", Field.INTEGER, 0)); 
		    dataset.fieldDef(new Field("comentario", Field.STRING, 255)); 
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
		    return dataset;
	}

	private void cargarRegistroImputacionPagosVarios(
			IDataSet dataset,
			ImputacionPagosVarios impuPagosVarios) throws BaseException {
		dataset.append(); 
		dataset.fieldValue("oid_impu_op_varias", impuPagosVarios.getOIDInteger());
		dataset.fieldValue("oid_ana_imp", impuPagosVarios.getCuenta_imputable().getOIDInteger());
		dataset.fieldValue("cod_ana_imp", impuPagosVarios.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ana_imp", impuPagosVarios.getCuenta_imputable().getDescCuentaMasDescValCompo());
		dataset.fieldValue("oid_cco", impuPagosVarios.getComprobante().getOIDInteger());
		dataset.fieldValue("debe_mon_pago", impuPagosVarios.getDebe_mon_pago());
		dataset.fieldValue("haber_mon_pago", impuPagosVarios.getHaber_mon_pago());
		dataset.fieldValue("debe_mon_loc", impuPagosVarios.getDebe_mon_loc());
		dataset.fieldValue("haber_mon_loc", impuPagosVarios.getHaber_mon_loc());
		dataset.fieldValue("comentario", impuPagosVarios.getComentario());
		dataset.fieldValue("activo", impuPagosVarios.isActivo());
	}
	
	
	
		
	
	

}
