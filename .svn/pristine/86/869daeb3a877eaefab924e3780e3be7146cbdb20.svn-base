package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluModifProcesoCand extends Operation { 

  public TraerRecluModifProcesoCand() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	RecluProcesoCandidato recluProcesoCandidato = RecluProcesoCandidato.findByOid(mapaDatos.getInteger("oid_proceso_sel"), this.getSesion());
	IDataSet ds = this.getDataSetProceso();
	cargarRegistroProceso(ds, recluProcesoCandidato);
	writeCliente(ds);
  } 

  
  
  private void cargarRegistroProceso(IDataSet dataset, RecluProcesoCandidato aRecluProcesoCandidato) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_proceso_selec", aRecluProcesoCandidato.getOIDInteger());
		if (aRecluProcesoCandidato.getCandidato_busq()!=null)
			dataset.fieldValue("oid_candidato_busq", aRecluProcesoCandidato.getCandidato_busq().getOIDInteger());
		else
			dataset.fieldValue("oid_candidato_busq", "");
		dataset.fieldValue("orden", aRecluProcesoCandidato.getOrden());
		dataset.fieldValue("oid_proceso", aRecluProcesoCandidato.getProceso().getOIDInteger());
		dataset.fieldValue("oid_conc_proceso", aRecluProcesoCandidato.getConcepto_proceso().getOIDInteger());
		dataset.fieldValue("costo", aRecluProcesoCandidato.getCosto());
		dataset.fieldValue("oid_est_proc_sel", aRecluProcesoCandidato.getEstado().getOIDInteger());
		dataset.fieldValue("fecha_planif", aRecluProcesoCandidato.getFecha_planif());
		dataset.fieldValue("hora_planif", aRecluProcesoCandidato.getHora_planif());
		dataset.fieldValue("persona", aRecluProcesoCandidato.getPersona());
		dataset.fieldValue("observaciones", aRecluProcesoCandidato.getObservaciones());
		dataset.fieldValue("puede_iniciar", aRecluProcesoCandidato.isPuede_iniciar());
		dataset.fieldValue("activo", aRecluProcesoCandidato.isActivo());
		dataset.fieldValue("nro_archivo", aRecluProcesoCandidato.getNroArchivo());
		dataset.fieldValue("nombre_archivo", aRecluProcesoCandidato.getNombreArchivo());
		  if (aRecluProcesoCandidato.getTipoFormulario()!=null)
			  dataset.fieldValue("oid_tipo_formu", aRecluProcesoCandidato.getTipoFormulario().getOID());
		  else
			  dataset.fieldValue("oid_tipo_formu", "");
		  dataset.fieldValue("completo_tipo_formu", aRecluProcesoCandidato.isCompletoTipoFormulario());
		  dataset.fieldValue("fec_completo_tf", aRecluProcesoCandidato.getCompletoTipoFormulario());		
		  
		  if (aRecluProcesoCandidato.getOperacion()!=null)
			  dataset.fieldValue("oid_operacion", aRecluProcesoCandidato.getOperacion().getOID());
		  else
			  dataset.fieldValue("oid_operacion", "");
		  if (aRecluProcesoCandidato.getSector()!=null)
			  dataset.fieldValue("oid_sector", aRecluProcesoCandidato.getSector().getOIDInteger());
		  else
			  dataset.fieldValue("oid_sector", "");
		  if (aRecluProcesoCandidato.getSelector()!=null)
			  dataset.fieldValue("oid_selector", aRecluProcesoCandidato.getSelector().getOIDInteger());
		  else
			  dataset.fieldValue("oid_selector", "");
		
  }
	
  private IDataSet getDataSetProceso() { 
		    IDataSet dataset = new TDataSet(); 
		    dataset.create("TAltaProcesoCandidato");
		    dataset.fieldDef(new Field("oid_proceso_selec", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_candidato_busq", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("oid_conc_proceso", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("costo", Field.CURRENCY, 0));
		    dataset.fieldDef(new Field("oid_est_proc_sel", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("fecha_planif", Field.DATE, 0));
		    dataset.fieldDef(new Field("hora_planif", Field.STRING, 5));
		    dataset.fieldDef(new Field("persona", Field.STRING, 100));
		    dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
		    dataset.fieldDef(new Field("puede_iniciar", Field.BOOLEAN, 0)); 
		    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		    dataset.fieldDef(new Field("nro_archivo", Field.INTEGER, 0));
		    dataset.fieldDef(new Field("nombre_archivo", Field.STRING, 255));
		    dataset.fieldDef(new Field("oid_tipo_formu", Field.INTEGER,0));
		    dataset.fieldDef(new Field("completo_tipo_formu", Field.BOOLEAN,0));
		    dataset.fieldDef(new Field("fec_completo_tf", Field.DATE,0));		
		    dataset.fieldDef(new Field("oid_operacion", Field.INTEGER,0));
		    dataset.fieldDef(new Field("oid_sector", Field.INTEGER,0));
		    dataset.fieldDef(new Field("oid_selector", Field.INTEGER,0));
		    return dataset;
  }	
  
  
}
