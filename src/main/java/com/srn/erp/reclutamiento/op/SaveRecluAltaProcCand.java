package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;

import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluAltaProcCand extends Operation { 

  public SaveRecluAltaProcCand() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	RecluCandidatoBusq recluCandidatoBusq = null;
	if ((mapaDatos.getInteger("oid_candidato_busq")!=null) && (mapaDatos.getInteger("oid_candidato_busq").intValue()>0))
		recluCandidatoBusq = RecluCandidatoBusq.findByOidProxy(mapaDatos.getInteger("oid_candidato_busq"), this.getSesion());
	
    IDataSet dataset = mapaDatos.getDataSet("TAltaProcesoCandidato"); 
    procesarRegistros(recluCandidatoBusq,dataset); 
  } 

  private void procesarRegistros(RecluCandidatoBusq recluCandidatoBusq,IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
    	RecluProcesoCandidato recluProcesoCandidato = RecluProcesoCandidato.findByOid(dataset.getInteger("oid_proceso_selec"), this.getSesion());
    	
    	
    	// Si ya tiene asignada una operacion verificar que el usuario tiene permiso de modificación sobre la misma.
    	if (recluProcesoCandidato.getOperacion()!=null) {
    		boolean estaHabilitado = false;
    		Iterator iterRecluOperacion = RecluOperacion.getOperacionesParaAccesoTotalDelUsuario(this.getSesion()).iterator();
    		while (iterRecluOperacion.hasNext()) {
    			RecluOperacion recluOperacion = (RecluOperacion) iterRecluOperacion.next();
    			if (recluOperacion.getOID() == recluProcesoCandidato.getOperacion().getOID()) {
    				estaHabilitado = true;
    				break;
    			}
    		}
    		if (!estaHabilitado)
    			throw new ExceptionValidation(null,"No se encuentra habilitado para modificar búsqueda de "+ recluProcesoCandidato.getOperacion().getDescripcion());
    	}
    	
    	recluProcesoCandidato.setCandidato_busq(recluCandidatoBusq);
    	recluProcesoCandidato.setOrden(dataset.getInteger("orden"));
    	recluProcesoCandidato.setProceso(RecluProceso.findByOidProxy(dataset.getInteger("oid_proceso"), this.getSesion()));
    	recluProcesoCandidato.setConcepto_proceso(RecluConceptoProceso.findByOidProxy(dataset.getInteger("oid_conc_proceso"), this.getSesion()));
    	recluProcesoCandidato.setCosto(dataset.getDouble("costo"));
    	recluProcesoCandidato.setEstado(RecluEstadoProceso.findByOidProxy(dataset.getInteger("oid_est_proc_sel"), this.getSesion()));
    	recluProcesoCandidato.setFecha_planif(dataset.getDate("fecha_planif"));
    	recluProcesoCandidato.setHora_planif(dataset.getString("hora_planif"));
    	recluProcesoCandidato.setPersona(dataset.getString("persona"));
    	recluProcesoCandidato.setObservaciones(dataset.getString("observaciones"));
    	recluProcesoCandidato.setPuede_iniciar(dataset.getBoolean("puede_iniciar"));
    	if (dataset.getInteger("oid_postulante")!=null)
    		recluProcesoCandidato.setPostulante(RecluPostulante.findByOidProxy(dataset.getInteger("oid_postulante"), this.getSesion()));
    	recluProcesoCandidato.setNroArchivo(dataset.getInteger("nro_archivo"));
    	recluProcesoCandidato.setNombreArchivo(dataset.getString("nombre_archivo"));
    	recluProcesoCandidato.setTipoFormulario(RecluTipoFormuProceso.findByOidProxy(dataset.getInteger("oid_tipo_formu"), this.getSesion()));
    	recluProcesoCandidato.setCompletoTipoFormulario(dataset.getBoolean("completo_tipo_formu"));
    	recluProcesoCandidato.setFecCompletoTipoFormulario(dataset.getDate("fec_completo_tf"));
    	
    	if ((dataset.getBoolean("completo_tipo_formu")!=null) && (dataset.getBoolean("completo_tipo_formu"))) 
    		if (dataset.getDate("fec_completo_tf")==null)
    			recluProcesoCandidato.setFecCompletoTipoFormulario(Util.getFechaActual(this.getSesion()));
    	
    		
    	recluProcesoCandidato.setOperacion(RecluOperacion.findByOidProxy(dataset.getInteger("oid_operacion"), this.getSesion()));
    	
    	// Si ya tiene asignada una operacion verificar que el usuario tiene permiso de modificación sobre la misma.
    	if (recluProcesoCandidato.getOperacion()!=null) {
    		boolean estaHabilitado = false;
    		Iterator iterRecluOperacion = RecluOperacion.getOperacionesParaAccesoTotalDelUsuario(this.getSesion()).iterator();
    		while (iterRecluOperacion.hasNext()) {
    			RecluOperacion recluOperacion = (RecluOperacion) iterRecluOperacion.next();
    			if (recluOperacion.getOID() == recluProcesoCandidato.getOperacion().getOID()) {
    				estaHabilitado = true;
    				break;
    			}
    		}
    		if (!estaHabilitado)
    			throw new ExceptionValidation(null,"No se encuentra habilitado para modificar búsqueda de "+ recluProcesoCandidato.getOperacion().getDescripcion());
    	}    	
    	
    	
    	recluProcesoCandidato.setSector(RecluSectores.findByOidProxy(dataset.getInteger("oid_sector"), this.getSesion()));
    	recluProcesoCandidato.setSelector(RecluSelector.findByOidProxy(dataset.getInteger("oid_selector"), this.getSesion()));
    	
    	
    	if (recluProcesoCandidato.isNew())
    		recluProcesoCandidato.setActivo(true);
    	else
    		recluProcesoCandidato.setActivo(dataset.getBoolean("activo"));
    	
    	this.addTransaccion(recluProcesoCandidato);
        dataset.next();
    }
  }
  
}
