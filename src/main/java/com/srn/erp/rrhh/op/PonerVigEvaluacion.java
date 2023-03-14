package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class PonerVigEvaluacion extends Operation {

	public PonerVigEvaluacion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		Integer oidEval = mapaDatos.getInteger("oid_eval_leg");
		EvaluacionLegajoCab evaluacionLegajoCab = EvaluacionLegajoCab.findByOid(oidEval, this.getSesion());

		if (!evaluacionLegajoCab.isActivo())
			throw new ExceptionValidation(null,"No se puede poner como vigente una evaluación anulada"); 
		
		if (evaluacionLegajoCab.isVigente())
			throw new ExceptionValidation(null, "La evaluación ya se encuentra vigente");

		EvaluacionLegajoCab.marcarOtrasEvalComoNoVigentes(evaluacionLegajoCab.getModelo_eval_cab(), evaluacionLegajoCab.getLegajo(), evaluacionLegajoCab, this.getSesion());
		evaluacionLegajoCab.setVigente(true);
		addTransaccion(evaluacionLegajoCab);

	}

}
