package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveRecluEiminarProcCandi extends Operation { 

  public SaveRecluEiminarProcCandi() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	RecluProcesoCandidato recluProcesoCandidato = RecluProcesoCandidato.findByOid(mapaDatos.getInteger("oid_proceso_candidato"), this.getSesion());
	recluProcesoCandidato.setActivo(false);
	this.addTransaccion(recluProcesoCandidato);
  } 

  
}
