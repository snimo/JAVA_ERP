package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluCandidatoBusq extends Operation { 

  public TraerRecluCandidatoBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	IDataSet ds = this.getDataSetCandidato();
	RecluCandidatoBusq recluCandidatoBusq = 
			RecluCandidatoBusq.findByOid(mapaDatos.getInteger("oid_candidato_busq"), this.getSesion());
	cargarRegistroCandidato(ds, recluCandidatoBusq);
	writeCliente(ds);
	
    
  }
  
  private void cargarRegistroCandidato(IDataSet dataset, 
		   							   RecluCandidatoBusq aRecluCandidatoBusq) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_candidato_busq", aRecluCandidatoBusq.getOIDInteger());
	  dataset.fieldValue("oid_busqueda_act", aRecluCandidatoBusq.getBusqueda().getOIDInteger());
	  dataset.fieldValue("oid_postulante", aRecluCandidatoBusq.getOid_postulante().getOIDInteger());
	  dataset.fieldValue("nro_docu", aRecluCandidatoBusq.getOid_postulante().getNro_docu());
	  dataset.fieldValue("ape_y_nom", aRecluCandidatoBusq.getOid_postulante().getApe_y_nom());
	  if (aRecluCandidatoBusq.getEstado_busqueda()!=null)
		  dataset.fieldValue("oid_est_cand_busq", aRecluCandidatoBusq.getEstado_busqueda().getOIDInteger());
	  else
		  dataset.fieldValue("oid_est_cand_busq", "");
	  dataset.fieldValue("comentario", aRecluCandidatoBusq.getComentario());
	  if (aRecluCandidatoBusq.getMotivo()!=null)
		  dataset.fieldValue("oid_mot_est_cand", aRecluCandidatoBusq.getMotivo().getOIDInteger());
	  else
		  dataset.fieldValue("oid_mot_est_cand", "");
	  dataset.fieldValue("activo", aRecluCandidatoBusq.isActivo());
	  dataset.fieldValue("fec_ingreso", aRecluCandidatoBusq.getFechaIngreso()); 
	  
  }
  
  private IDataSet getDataSetCandidato() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TCandidato");
	    dataset.fieldDef(new Field("oid_candidato_busq", Field.INTEGER, 0));	    
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nro_docu", Field.STRING, 50));
	    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_est_cand_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("comentario", Field.STRING, 4000));
	    dataset.fieldDef(new Field("oid_mot_est_cand", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_ingreso", Field.DATE, 0));
	    return dataset;
  }  
  
  
  
}



