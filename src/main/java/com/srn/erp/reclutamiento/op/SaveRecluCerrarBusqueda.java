package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;

public class SaveRecluCerrarBusqueda extends Operation { 

  public SaveRecluCerrarBusqueda() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	RecluBusqueda busqueda = RecluBusqueda.findByOid(mapaDatos.getInteger("oid_busqueda"), this.getSesion());
	
	if (busqueda.getEstado_busqueda().equals(RecluBusqueda.getEstadoBusqCerrada()))
		throw new ExceptionValidation(null,"La Búsqueda ya se encuentra cerrada.");
	
	
	busqueda.cerrarBusqueda();
	busqueda.save();
	
	
     
  } 

  
}
