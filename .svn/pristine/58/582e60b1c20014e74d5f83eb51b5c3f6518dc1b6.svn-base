package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.ModeloEvalCompe;
import com.srn.erp.rrhh.bm.ModeloEvalGrados;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class ValidarGradoCompe extends Operation {

	public ValidarGradoCompe() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		Integer oidModEvalCompe = mapaDatos.getInteger("oid_mod_eval_compe");
		Integer grado 			= mapaDatos.getInteger("nro_grado");
		
		ModeloEvalCompe modeloEvalCompe = ModeloEvalCompe.findByOid(oidModEvalCompe, this.getSesion());
		ModeloEvalGrados modeloEvalGrados = modeloEvalCompe.getModeloEvalGrados(grado, this.getSesion());
		if (modeloEvalGrados == null)
			throw new ExceptionValidation(null,"Nro. de Grado INEXISTENTE");
		
	}

}
