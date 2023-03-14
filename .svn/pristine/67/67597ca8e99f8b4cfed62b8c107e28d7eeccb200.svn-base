package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.bm.InformeControlCalidadDet;
import com.srn.erp.compras.bm.MotivoRechazoInfCC;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ImpresionControlCalidad extends Operation {

	public ImpresionControlCalidad() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsInfCC = this.getDataSetInfCC();
		IDataSet dsInfCCDet = this.getDataSetInfCCDet();
		IDataSet dsInfCCMotRech = this.getDataSetMotRechazo();

		InformeControlCalidad infCC = InformeControlCalidad.findByOidProxy(mapaDatos.getInteger("oid_cco"), getSesion());
		Iterator iterInfCCDet = infCC.getDetallesInfCC().iterator();
		cargarRegistroInfCC(dsInfCC, infCC);
		while (iterInfCCDet.hasNext()) {
			InformeControlCalidadDet infCCDet = (InformeControlCalidadDet) (iterInfCCDet.next());
			cargarRegistroInfCCDet(dsInfCCDet, infCCDet);
			Iterator iterMotivosRechazoCC = infCCDet.getMotivosRechazos().iterator();
			while (iterMotivosRechazoCC.hasNext()) {
				MotivoRechazoInfCC motivoRechazoCC = (MotivoRechazoInfCC) iterMotivosRechazoCC.next();
				cargarRegistroMotivoRechazo(dsInfCCMotRech, motivoRechazoCC);
			}
		}

		writeCliente(dsInfCC);
		writeCliente(dsInfCCDet);
		writeCliente(dsInfCCMotRech);
	}

	private void cargarRegistroInfCC(IDataSet dataset, InformeControlCalidad infCC) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", infCC.getOIDInteger());
		dataset.fieldValue("comprobante", infCC.getCodigo());
		dataset.fieldValue("tc", infCC.getTipoCompro().getCodigo());
		dataset.fieldValue("letra", infCC.getLetra());
		dataset.fieldValue("lug_emi", infCC.getNroLugEmision());
		dataset.fieldValue("nro_ext", infCC.getNroExt());
		dataset.fieldValue("fecha", infCC.getEmision());
		dataset.fieldValue("comentario", infCC.getComentario());
	}

	private void cargarRegistroInfCCDet(IDataSet dataset, InformeControlCalidadDet infCCDet) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_inf_cc_det", infCCDet.getOIDInteger());
		dataset.fieldValue("oid_cco_inf_cc", infCCDet.getInforme_cc().getOIDInteger());
		dataset.fieldValue("oid_producto", infCCDet.getInforme_recepcion_det().getProducto().getOIDInteger());
		dataset.fieldValue("cod_producto", infCCDet.getInforme_recepcion_det().getProducto().getCodigo());
		dataset.fieldValue("desc_producto", infCCDet.getInforme_recepcion_det().getProducto().getDesc_abrev());
		dataset.fieldValue("um_stock", infCCDet.getInforme_recepcion_det().getUnidadMedidaStock().getCodigo());
		dataset.fieldValue("cant_rec_um_stock", infCCDet.getInforme_recepcion_det().getCant_rec_en_us());
		dataset.fieldValue("cant_ok_um_stock", infCCDet.getCant_ok_us());
		dataset.fieldValue("cant_mal_um_stock", infCCDet.getCant_mal_us());
		dataset.fieldValue("comentario", infCCDet.getObservaciones());
		dataset.fieldValue("inf_rec", infCCDet.getInforme_recepcion_det().getInforme_recepcion().getCodigo());
		dataset.fieldValue("proveedor", infCCDet.getInforme_recepcion_det().getInforme_recepcion().getProveedor()
				.getCodigo()
				+ " - " + infCCDet.getInforme_recepcion_det().getInforme_recepcion().getProveedor().getRazonsocial());
		dataset.fieldValue("oid_inf_rec_det", infCCDet.getInforme_recepcion_det().getOIDInteger());
		dataset.fieldValue("oid_inf_rec", infCCDet.getInforme_recepcion_det().getInforme_recepcion().getOIDInteger());
	}

	private void cargarRegistroMotivoRechazo(IDataSet dataset, MotivoRechazoInfCC motivoRechazo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_motivo_rechazo", motivoRechazo.getOIDInteger());
		dataset.fieldValue("oid_inf_cc_det", motivoRechazo.getInf_cc_det().getOIDInteger());
		dataset.fieldValue("descripcion", motivoRechazo.getDescripcion());
		dataset.fieldValue("cantidad", motivoRechazo.getCant_mal_us());
	}

	private IDataSet getDataSetInfCC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfCC");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 50));
		dataset.fieldDef(new Field("tc", Field.STRING, 10));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 5000));
		return dataset;
	}

	private IDataSet getDataSetInfCCDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TInfCCDet");
		dataset.fieldDef(new Field("oid_inf_cc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_cco_inf_cc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("um_stock", Field.STRING, 20));
		dataset.fieldDef(new Field("cant_rec_um_stock", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_ok_um_stock", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("cant_mal_um_stock", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("inf_rec", Field.STRING, 50));
		dataset.fieldDef(new Field("proveedor", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0));
		return dataset;
	}

	private IDataSet getDataSetMotRechazo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotivosRechazo");
		dataset.fieldDef(new Field("oid_motivo_rechazo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_inf_cc_det", Field.INTEGER, 0));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 0));
		dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
		return dataset;
	}

}
