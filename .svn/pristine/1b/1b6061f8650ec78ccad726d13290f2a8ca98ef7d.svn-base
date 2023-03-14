package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveRecluEiminarCandidato extends Operation { 

  public SaveRecluEiminarCandidato() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	RecluCandidatoBusq candidatoBusqueda = RecluCandidatoBusq.findByOid(mapaDatos.getInteger("oid_candidato"), this.getSesion());
	candidatoBusqueda.setActivo(false);
	this.addTransaccion(candidatoBusqueda);
  } 

  
}
