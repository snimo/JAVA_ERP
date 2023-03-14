package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluCompeBusqAct;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class SaveRecluEliCompeBusq extends Operation { 

  public SaveRecluEliCompeBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	RecluCompeBusqAct recluCompeBusqAct = RecluCompeBusqAct.findByOid(mapaDatos.getInteger("oid_reclu_compe_busq"), this.getSesion());
	recluCompeBusqAct.setActivo(false);
	this.addTransaccion(recluCompeBusqAct);
  } 

  
}
