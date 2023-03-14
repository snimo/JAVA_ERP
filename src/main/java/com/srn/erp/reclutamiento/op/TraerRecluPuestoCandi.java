package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluPuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluPuestoCandi extends Operation { 

  public TraerRecluPuestoCandi() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	IDataSet ds = this.getDataSetPuestoCandidato();
	
	RecluCandidatoBusq recluCandidatoBusq = 
			RecluCandidatoBusq.findByOid(mapaDatos.getInteger("oid_candidato_busq"), this.getSesion());
	
	if (recluCandidatoBusq==null)
		throw new ExceptionValidation(null,"Se debe seleccionar un candidato");
	
	cargarRegistro(ds, recluCandidatoBusq.getBusqueda().getPuesto(), recluCandidatoBusq.getOid_postulante());
	writeCliente(ds);
	
    
  }
  
  private void cargarRegistro(IDataSet dataset, 
		   					  RecluPuesto aRecluPuesto,
		   					  RecluPostulante aRecluPostulante) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_puesto", aRecluPuesto.getOIDInteger());
	  dataset.fieldValue("nombre_puesto", aRecluPuesto.getDescripcion());
	  dataset.fieldValue("oid_postulante", aRecluPostulante.getOIDInteger());
	  dataset.fieldValue("nombre_postulante", aRecluPostulante.getDescripcion());	  
	  
  }
  
  private IDataSet getDataSetPuestoCandidato() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPuestoCandidato");
	    dataset.fieldDef(new Field("oid_puesto", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nombre_puesto", Field.STRING, 200));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nombre_postulante", Field.STRING, 200));
	    return dataset;
  }  
  
  
  
}



