package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class RecalcEvalRRHH extends Operation {

	public RecalcEvalRRHH() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		Integer oidModelo = mapaDatos.getInteger("oid_modelo_eval");
		ModeloEvalCab modeloEvalCab = ModeloEvalCab.findByOid(oidModelo, this.getSesion());

		Iterator iterEvaluaciones = modeloEvalCab.getEvaluacionesByModelo(this.getSesion()).iterator();
		while (iterEvaluaciones.hasNext()) {
			EvaluacionLegajoCab evaluacion = (EvaluacionLegajoCab) iterEvaluaciones.next();
			EvaluacionLegajoCab.calcularPuntaje(this.getSesion(), evaluacion.getOIDInteger());
		}

	}

}
