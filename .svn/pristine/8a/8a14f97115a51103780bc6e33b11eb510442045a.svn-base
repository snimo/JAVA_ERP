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

public class VerEvaluacionCelda extends Operation {

	public VerEvaluacionCelda() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidLegajo = mapaDatos.getInteger("oid_legajo");
		String columnaGrilla = mapaDatos.getString("columna");
		
		EvaluacionLegajoCab evaluacion = null;
		if (columnaGrilla.startsWith("pu_")) {
			String oidModelo = columnaGrilla.substring(3,columnaGrilla.length());
			ModeloEvalCab modelo = ModeloEvalCab.findByOidProxy(new Integer(oidModelo), this.getSesion());
			Legajo legajo = Legajo.findByOidProxy(oidLegajo, this.getSesion());
			evaluacion = EvaluacionLegajoCab.getEvaluacionLegajoCab(modelo, legajo, this.getSesion());
		}
		
		IDataSet dsEvalCelda = getDataSetEvalCelda();
		if (evaluacion!=null)
			cargarEvaluacion(dsEvalCelda, evaluacion);
		writeCliente(dsEvalCelda);
		

	}

	private IDataSet getDataSetEvalCelda() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEvalCelda");
		dataset.fieldDef(new Field("oid_evaluacion", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarEvaluacion(IDataSet dataset, EvaluacionLegajoCab evaluacion) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_evaluacion", evaluacion.getOIDInteger());
	}

}
