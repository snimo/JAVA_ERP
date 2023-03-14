package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class BuscarEvaluacion extends Operation {

	public BuscarEvaluacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EvaluacionLegajoCab evaluacion = null;
		Integer oid = mapaDatos.getInteger("oid_cco");
		evaluacion = EvaluacionLegajoCab.findByOid(oid, getSesion());
		
		
		IDataSet ds = this.getDataSetCompro();
		if (evaluacion != null) {
			cargarRegistroEvaluacion(ds, evaluacion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetCompro() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComproCab");
		dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_tc", Field.INTEGER, 0));
		dataset.fieldDef(new Field("tc_ext", Field.STRING, 20));
		dataset.fieldDef(new Field("letra", Field.STRING, 1));
		dataset.fieldDef(new Field("nro_ext", Field.INTEGER, 0));
		dataset.fieldDef(new Field("lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("emision", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_lug_emi", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comentario", Field.STRING, 255));
		dataset.fieldDef(new Field("fec_alta", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("estado", Field.STRING, 10));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_talonario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_sucursal", Field.INTEGER, 0));
		dataset.fieldDef(new Field("imputac", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_motivo_compro", Field.INTEGER, 0));
		dataset.fieldDef(new Field("comprobante", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroEvaluacion(IDataSet dataset, EvaluacionLegajoCab aEvaluacion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_cco", aEvaluacion.getOIDInteger());
		dataset.fieldValue("oid_tc", "");
		dataset.fieldValue("tc_ext", "");
		dataset.fieldValue("letra", "");
		dataset.fieldValue("nro_ext", "");
		dataset.fieldValue("lug_emi", "");
		dataset.fieldValue("emision", aEvaluacion.getFec_eval());
		dataset.fieldValue("oid_lug_emi", "");
		dataset.fieldValue("comentario", aEvaluacion.getCodigo());
		dataset.fieldValue("fec_alta", aEvaluacion.getFec_alta_carga());
		dataset.fieldValue("oid_usuario", "");
		dataset.fieldValue("estado", "");
		dataset.fieldValue("activo", aEvaluacion.isActivo());
		dataset.fieldValue("oid_talonario", "");
		dataset.fieldValue("oid_sucursal", "");
		dataset.fieldValue("imputac", aEvaluacion.getFec_eval());
		dataset.fieldValue("oid_motivo_compro", "");
		dataset.fieldValue("comprobante", aEvaluacion.getCodigo()+"-"+aEvaluacion.getLegajo().getNro_legajo());
	}

}