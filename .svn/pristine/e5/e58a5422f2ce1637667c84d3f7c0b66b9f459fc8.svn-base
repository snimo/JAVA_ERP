package com.srn.erp.tesoreria.op;

import java.util.Iterator;

import com.srn.erp.tesoreria.bm.FacturasRecibo;
import com.srn.erp.tesoreria.bm.MotivoIngresoVarios;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.bm.ValoresRecibo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecibo extends Operation {

	public TraerRecibo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oid = mapaDatos.getInteger("oid");
		Recibo recibo = Recibo.findByOid(oid, getSesion());
		
		IDataSet datasetReciboCab = getDataSetReciboCab();
		IDataSet datasetValores = getDataSetValores();
		IDataSet datasetComproCobrados = getComprobantesCobrados();
		IDataSet datasetCuentas = getCuentasIngVarios();
		
		cargarRegistroReciboCab(datasetReciboCab,recibo);
		cargarValores(datasetValores,recibo);
		cargarComproCobrados(datasetComproCobrados,recibo);
		cargarCuentas(datasetCuentas , recibo);
		
		
		writeCliente(datasetReciboCab);
		writeCliente(datasetValores);
		writeCliente(datasetComproCobrados);
		writeCliente(datasetCuentas);
		
	}

	private IDataSet getDataSetReciboCab() {
		IDataSet dataset = new TDataSet();
		dataset.create("TRecibo");
		dataset.fieldDef(new Field("oid_cco_recibo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_motivo_recibo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tipo_oper",Field.STRING, 20));
		dataset.fieldDef(new Field("fec_imputacion", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_caja", Field.INTEGER, 0));
		dataset.fieldDef(new Field("recibo_provisorio", Field.STRING, 20));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
		dataset.fieldDef(new Field("oid_moneda",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sujeto",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_suj",Field.STRING, 50));
		dataset.fieldDef(new Field("rs_sujeto",Field.STRING, 100));
		dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
		dataset.fieldDef(new Field("comentario",Field.STRING, 8000));
		dataset.fieldDef(new Field("oid_tc",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tc",Field.STRING, 20));
		dataset.fieldDef(new Field("letra",Field.STRING, 1));
		dataset.fieldDef(new Field("oid_lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi",Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_talonario",Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cobrador",Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_cobrador",Field.STRING, 50));
		dataset.fieldDef(new Field("nombre_cobrador",Field.STRING, 100));
		dataset.fieldDef(new Field("tot_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("pago_a_cuenta",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_pago_a_cuenta",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("en_concepto",Field.STRING, 100));
		
		
		return dataset;
	}

	private IDataSet getDataSetValores() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMediosPago");
		dataset.fieldDef(new Field("oid_rec_medio_pago", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tipo_valor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_tipo_valor", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_tipo_valor", Field.STRING, 255));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
		dataset.fieldDef(new Field("cotizacion", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("importe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_mon_fact", Field.CURRENCY, 0));
		return dataset;
	}
	
	private IDataSet getCuentasIngVarios() {
		
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosIngresos");
		dataset.fieldDef(new Field("oid_mot_ing_rec", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_recibo", Field.INTEGER, 50));
		dataset.fieldDef(new Field("oid_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo_ai", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_ai", Field.STRING, 5000));
		dataset.fieldDef(new Field("debe", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("haber", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 5000));
		
		
		return dataset;
	}
	
	private IDataSet getComprobantesCobrados() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFacturasCobradas");
		dataset.fieldDef(new Field("oid_fact_en_recibo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("oid_cco_recibo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_fact", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_mon_ori",Field.INTEGER, 0));
		dataset.fieldDef(new Field("impo_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_dto_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_cob_mon_ori",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cotizacion",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("fec_emision",Field.DATE, 0));
		dataset.fieldDef(new Field("oid_tran_vto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("impo_cob_mon_rec",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_mon_loc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("saldo_mon_loc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_dto_mon_loc",Field.CURRENCY, 0));
		dataset.fieldDef(new Field("impo_cob_mon_loc",Field.CURRENCY, 0));
		return dataset;
	}
	
	private void cargarRegistroIngVar(IDataSet dataset,MotivoIngresoVarios motIngVar) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mot_ing_rec", motIngVar.getOIDInteger());
		dataset.fieldValue("oid_cco_recibo", motIngVar.getRecibo().getOIDInteger());
		dataset.fieldValue("oid_ai", motIngVar.getCuenta_imputable().getOIDInteger());
		dataset.fieldValue("codigo_ai", motIngVar.getCuenta_imputable().getCodigoCuentaMasCodigosValCompo());
		dataset.fieldValue("desc_ai", motIngVar.getCuenta_imputable().getDescCuentaMasDescValCompo());
		dataset.fieldValue("debe", motIngVar.getDebe());
		dataset.fieldValue("haber", motIngVar.getHaber());
		dataset.fieldValue("comentario", motIngVar.getComentario());
		
	}
	
	
	private void cargarValores(IDataSet dataset,Recibo recibo) throws BaseException {
		Iterator iterValoresRecibo = recibo.getValoresRecibo().iterator();
		while (iterValoresRecibo.hasNext()) {
			ValoresRecibo valorRecibo = (ValoresRecibo) iterValoresRecibo.next();
			dataset.append();
			dataset.fieldValue("oid_rec_medio_pago", valorRecibo.getOIDInteger());
			dataset.fieldValue("oid_cco", recibo.getOIDInteger());
			if (valorRecibo.getValor()!=null) 
				dataset.fieldValue("oid_valor", valorRecibo.getValor().getOIDInteger());
			else
				dataset.fieldValue("oid_valor", 0);	
			dataset.fieldValue("oid_tipo_valor", valorRecibo.getTipo_valor().getOIDInteger());
			dataset.fieldValue("cod_tipo_valor", valorRecibo.getTipo_valor().getCodigo());
			dataset.fieldValue("desc_tipo_valor", valorRecibo.getTipo_valor().getDescripcion());
			if (valorRecibo.getValor()!=null)
				dataset.fieldValue("descripcion", valorRecibo.getValor().getDescripcion());
			else
				dataset.fieldValue("descripcion", "");
			dataset.fieldValue("cotizacion", valorRecibo.getCotizacion());
			dataset.fieldValue("importe", valorRecibo.getImpo_mon_ori());
			dataset.fieldValue("impo_mon_fact", valorRecibo.getImpoMonRec());			
			
		}
		
	}
	
	private void cargarCuentas(IDataSet datasetCuentas ,Recibo recibo) throws BaseException {
		Iterator iterMotivosIngVar = recibo.getMotivosIngVarios().iterator();
		while (iterMotivosIngVar.hasNext()) {
			MotivoIngresoVarios motIngVarios = (MotivoIngresoVarios) iterMotivosIngVar.next();
			cargarRegistroIngVar(datasetCuentas,motIngVarios);
			
		}
	}
	
	private void cargarComproCobrados(IDataSet dataset,Recibo recibo) throws BaseException {
		Iterator iterFacturasRecibo = recibo.getFacturasRecibo().iterator();
		while (iterFacturasRecibo.hasNext()) {
			FacturasRecibo facturaRecibo = (FacturasRecibo) iterFacturasRecibo.next();
			dataset.append();
			dataset.fieldValue("oid_fact_en_recibo", facturaRecibo.getOIDInteger());
			dataset.fieldValue("comprobante", facturaRecibo.getTranClieVto().getTran_clie().getComprobante().getCodigo());
			dataset.fieldValue("oid_cco_recibo", recibo.getOIDInteger());
			dataset.fieldValue("oid_cco_fact", facturaRecibo.getTranClieVto().getTran_clie().getComprobante().getOIDInteger());
			dataset.fieldValue("oid_mon_ori", facturaRecibo.getTranClieVto().getTran_clie().getMoneda().getOIDInteger());
			dataset.fieldValue("impo_mon_ori", facturaRecibo.getImpo_mon_ori());
			dataset.fieldValue("saldo_mon_ori",facturaRecibo.getSaldo_mon_ori());
			dataset.fieldValue("impo_dto_mon_ori",facturaRecibo.getImpo_dto_mon_ori());
			dataset.fieldValue("impo_cob_mon_ori",facturaRecibo.getImpo_cob_mon_ori());
			dataset.fieldValue("cotizacion",facturaRecibo.getCotizacion());
			dataset.fieldValue("fec_emision",facturaRecibo.getTranClieVto().getTran_clie().getComprobante().getEmision());
			dataset.fieldValue("oid_tran_vto", facturaRecibo.getTranClieVto().getOIDInteger());
			dataset.fieldValue("impo_cob_mon_rec",facturaRecibo.getImpoCobMonRec());
			dataset.fieldValue("impo_mon_loc",facturaRecibo.getImpo_mon_loc());
			dataset.fieldValue("saldo_mon_loc",facturaRecibo.getSaldo_mon_loc());
			dataset.fieldValue("impo_dto_mon_loc",facturaRecibo.getImpo_dto_mon_loc());
			dataset.fieldValue("impo_cob_mon_loc",facturaRecibo.getImpo_cob_mon_loc());			
		}
	}

	private void cargarRegistroReciboCab(IDataSet dataset,Recibo recibo) throws BaseException {
		dataset.append();
		
		dataset.fieldValue("oid_cco_recibo", recibo.getOIDInteger());
		if (recibo.getMotivoComprobante()!=null)
			dataset.fieldValue("oid_motivo_recibo", recibo.getMotivoComprobante().getOIDInteger());
		else
			dataset.fieldValue("oid_motivo_recibo", 0);
		dataset.fieldValue("tipo_oper", recibo.getTipoOper());
		dataset.fieldValue("fec_imputacion", recibo.getImputac());
		dataset.fieldValue("oid_caja", recibo.getCaja().getOIDInteger());
		dataset.fieldValue("recibo_provisorio", recibo.getNro_rec_ori());
		dataset.fieldValue("activo", recibo.isActivo());
		dataset.fieldValue("oid_moneda", recibo.getMoneda().getOIDInteger());
		if (recibo.getSujeto()!=null) {
			dataset.fieldValue("oid_sujeto", recibo.getSujeto().getOIDInteger());
			dataset.fieldValue("cod_suj",recibo.getSujeto().getCodigo());
			dataset.fieldValue("rs_sujeto", recibo.getSujeto().getRazon_social());
		} else {
			dataset.fieldValue("oid_sujeto", 0);
			dataset.fieldValue("cod_suj","");
			dataset.fieldValue("rs_sujeto", "");
		}
		dataset.fieldValue("cotizacion", recibo.getCotizacion());
		dataset.fieldValue("fec_emision", recibo.getEmision());
		dataset.fieldValue("comentario", recibo.getComentario());
		dataset.fieldValue("oid_tc", recibo.getTipoCompro().getOIDInteger());
		dataset.fieldValue("cod_tc", recibo.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", recibo.getLetra());
		dataset.fieldValue("oid_lug_emi", recibo.getLugarEmision().getOIDInteger());
		dataset.fieldValue("lug_emi", recibo.getNroLugEmision());
		dataset.fieldValue("nro_ext", recibo.getNroExt());
		dataset.fieldValue("oid_talonario", recibo.getTalonario().getOIDInteger());
		if (recibo.getCobrador()!=null) {
			dataset.fieldValue("oid_cobrador", recibo.getCobrador().getOIDInteger());
			dataset.fieldValue("codigo_cobrador", recibo.getCobrador().getCodigo());
			dataset.fieldValue("nombre_cobrador", recibo.getCobrador().getNombreyApellido());
		} else {
			dataset.fieldValue("oid_cobrador", 0);
			dataset.fieldValue("codigo_cobrador", "");
			dataset.fieldValue("nombre_cobrador", "");
		}
		dataset.fieldValue("tot_mon_ori", recibo.getTot_mon_ori());
		dataset.fieldValue("pago_a_cuenta", new Boolean(recibo.isPagoACuenta()));
		dataset.fieldValue("impo_pago_a_cuenta", recibo.getPagoACuenta());
		dataset.fieldValue("en_concepto", recibo.getEnConcepto());
		
		
		
	}

}
