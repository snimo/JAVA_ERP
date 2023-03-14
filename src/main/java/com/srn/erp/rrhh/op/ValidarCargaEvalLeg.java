package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarCargaEvalLeg extends Operation {

	public ValidarCargaEvalLeg() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String nroLegajo = null;
		if (mapaDatos.containsKey("nro_legajo"))
			nroLegajo = mapaDatos.getString("nro_legajo");
		
		Integer oidModelo = null;
		if (mapaDatos.containsKey("oid_mod_eval_cab"))
			oidModelo = mapaDatos.getInteger("oid_mod_eval_cab");
		
		ModeloEvalCab modeloEvalCab = (ModeloEvalCab) ModeloEvalCab.findByOid(oidModelo, this.getSesion());
		Legajo legajo = Legajo.findByCodigo(nroLegajo, this.getSesion());
		
		IDataSet ds = this.getDataSetEvalCarga();
		if ((modeloEvalCab!=null) && (legajo!=null)) {
			EvaluacionLegajoCab evaluacionLegajoCab = EvaluacionLegajoCab.getEvaluacionLegajoCab(modeloEvalCab, legajo, this.getSesion());
			if (evaluacionLegajoCab!=null) {
				cargarEvalCarga(ds,evaluacionLegajoCab);
			}
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetEvalCarga() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEvalCarga");
		dataset.fieldDef(new Field("oid_eval_leg_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		return dataset;
	}
	
	private void cargarEvalCarga(IDataSet ds,EvaluacionLegajoCab evaluacionLegajoCab) throws BaseException {
		ds.append();
		ds.fieldValue("oid_eval_leg_cab", evaluacionLegajoCab.getOIDInteger());
		ds.fieldValue("oid_legajo", evaluacionLegajoCab.getLegajo().getOIDInteger());
		ds.fieldValue("fecha", evaluacionLegajoCab.getFec_eval());
	}

}
