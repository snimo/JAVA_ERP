package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluOperacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class PuedeModifRecluOper extends Operation { 

  public PuedeModifRecluOper() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    
	  RecluOperacion operacion = RecluOperacion.findByOid(mapaDatos.getInteger("oid_operacion"), this.getSesion());
	  
	  boolean coincideOperacion = false;
	  
	  Iterator iterOper = 
			 RecluOperacion.getOperacionesParaAccesoTotalDelUsuario(this.getSesion()).iterator();
	  while (iterOper.hasNext()) {
		  RecluOperacion recluOperacion = (RecluOperacion) iterOper.next();
		  if (recluOperacion.getOID() == operacion.getOID()) {
			  coincideOperacion = true;
			  break;
		  }
	  }
	  
	  if (coincideOperacion==false)
		  throw new ExceptionValidation(null,"No tiene autorización para realizar la modificación solicitada.");
	  
	  
  } 

  
}
