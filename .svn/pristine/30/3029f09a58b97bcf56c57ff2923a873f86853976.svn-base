package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluMotiEstCandBusq;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluProcDefEnBusq;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluWarnEstBusqCandi;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveRecluAltaCandBusq extends Operation { 

  public SaveRecluAltaCandBusq() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	RecluBusqueda busqueda = RecluBusqueda.findByOidProxy(mapaDatos.getInteger("oid_busqueda"), this.getSesion());   
	  
    IDataSet dataset = mapaDatos.getDataSet("TCandidato"); 
    
    procesarRegistros(busqueda,dataset); 
  } 

  private void procesarRegistros(RecluBusqueda busqueda,IDataSet dataset) throws BaseException {
	  
	IDataSet dsAdvertencia = getDataSetAdvertencia();
	IDataSet dsConsCerrarBusq = getDataConsultaCerrarBusq();
	
    dataset.first(); 
      while (!dataset.EOF()) { 
    	RecluCandidatoBusq recluCandidatoBusq = RecluCandidatoBusq.findByOid(dataset.getInteger("oid_candidato_busq"), this.getSesion());
    	recluCandidatoBusq.setBusqueda(busqueda);
    	recluCandidatoBusq.setOid_postulante(RecluPostulante.findByOidProxy(dataset.getInteger("oid_postulante"), this.getSesion()));
    	recluCandidatoBusq.setFec_asigno(Util.getFechaActual(this.getSesion()));
    	recluCandidatoBusq.setHora_asigno(Fecha.getFormatoHoraMin(Util.getFechaActual(this.getSesion())));
    	recluCandidatoBusq.setUsuario_asigno(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOID(), this.getSesion()));
    	recluCandidatoBusq.setMotivo(RecluMotiEstCandBusq.findByOidProxy(dataset.getInteger("oid_mot_est_cand"), this.getSesion()));
    	recluCandidatoBusq.setEstado_busqueda(RecluEstCandidatoBusq.findByOidProxy(dataset.getInteger("oid_est_cand_busq"), this.getSesion()));
    	recluCandidatoBusq.setComentario(dataset.getString("comentario"));
    	recluCandidatoBusq.setFechaIngreso(dataset.getDate("fec_ingreso"));
    	
    	if (recluCandidatoBusq.isNew())
    		recluCandidatoBusq.setActivo(true);
    	else
    		recluCandidatoBusq.setActivo(dataset.getBoolean("activo"));
    	recluCandidatoBusq.save();
    	    	
    	
    	// Ver si corresponde cambiar el estado del postulante
    	if (recluCandidatoBusq.getEstado_busqueda()!=null) {
    		if (recluCandidatoBusq.getEstado_busqueda().getEstadoPostulante()!=null) {
    			RecluPostulante postulante = 
    					RecluPostulante.findByOid(recluCandidatoBusq.getOid_postulante().getOIDInteger(), 
    											  this.getSesion());
    			if ((postulante.getEstadoPostulante()==null)
    				||
    				((postulante.getEstadoPostulante()!=null) && 
    				 (postulante.getEstadoPostulante().getOID()!=recluCandidatoBusq.getEstado_busqueda().getEstadoPostulante().getOID()))) {
    				postulante.setEstadoPostulante(recluCandidatoBusq.getEstado_busqueda().getEstadoPostulante());
    				postulante.setFecEstadoPostulante(recluCandidatoBusq.getFechaIngreso());
    				postulante.save();
    			}
    		}
    	}
    	
    	// Enviar consulta para que el usuario decida si se cierra o no la busqueda
    	if ((recluCandidatoBusq.getEstado_busqueda()!=null) && (recluCandidatoBusq.getEstado_busqueda().isSugerirCierre())) {
    		
    		if (recluCandidatoBusq.getBusqueda().getEstado_busqueda().equals(RecluBusqueda.getEstadoBusqAbierta())) {
    			
    			// Si la cantidad de candidatos seleccionados es igual o mayor a la cantidad de vacantes entonces proponer cerrar las busqueda    			
    			if (recluCandidatoBusq.getBusqueda().isSugerirCierreDeBusqueda())
    				cargarConsultaCerrarBusq(dsConsCerrarBusq,
    										 recluCandidatoBusq.getBusqueda(),    										 
    										 "Desea cerrar la Búsqueda de "+recluCandidatoBusq.getBusqueda().getPuesto().getDescripcion()+"?"+Util.ENTER()+" Vacantes "+recluCandidatoBusq.getBusqueda().getCant_vacantes()+" Seleccionados "+recluCandidatoBusq.getBusqueda().getCantDeCandidatosSeleccionados());
    			
    		}
    		
    	}    	
    	
    	
    	
    	// Dar de alta para el candidato todos los procesos definidos en la Busqueda
    	String procesosWarning = "";
    	Iterator iterDefinicionProcesos = busqueda.getDefinicionProcesos().iterator();
    	while (iterDefinicionProcesos.hasNext()) {
    		
    		
    		
    		RecluProcDefEnBusq recluProcDefEnBusq = (RecluProcDefEnBusq) iterDefinicionProcesos.next();
    		RecluProcesoCandidato recluProcesoCandidato = 
    				RecluProcesoCandidato.getProcesoCandidato(recluCandidatoBusq,recluProcDefEnBusq.getProceso(),this.getSesion());
    		
    		if (recluProcesoCandidato!=null) {
    			Iterator iterWarning = recluCandidatoBusq.getEstado_busqueda().getWarning().iterator();
        		while (iterWarning.hasNext()) {
        			RecluWarnEstBusqCandi warn = (RecluWarnEstBusqCandi) iterWarning.next();
        			if (warn.getEstado_proceso().getOID() == recluProcesoCandidato.getEstado().getOID()) {
        				if (!procesosWarning.contains(recluProcesoCandidato.getEstado().getDescripcion()))
        					procesosWarning = procesosWarning +" '"+ recluProcesoCandidato.getEstado().getDescripcion()+"' ";
        			}
        		}    			
    			continue;
    		}
    		
    		// Dar de alta el proceso asociado al candidato
    		RecluProcesoCandidato nuevoProcesoCandidato = (RecluProcesoCandidato)RecluProcesoCandidato.getNew(RecluProcesoCandidato.NICKNAME, this.getSesion());
    		nuevoProcesoCandidato.setCandidato_busq(recluCandidatoBusq);
    		nuevoProcesoCandidato.setOrden(recluProcDefEnBusq.getOrden());
    		nuevoProcesoCandidato.setProceso(recluProcDefEnBusq.getProceso());
    		nuevoProcesoCandidato.setConcepto_proceso(recluProcDefEnBusq.getConceptoProceso());
    		nuevoProcesoCandidato.setTipoFormulario(recluProcDefEnBusq.getTipoFormulario());
    		nuevoProcesoCandidato.setEstado(RecluEstadoProceso.getEstadoProcesoDefaultAltaCandidato(this.getSesion()));
    		nuevoProcesoCandidato.setCosto(recluProcDefEnBusq.getConceptoProceso().getCosto());
    		nuevoProcesoCandidato.setActivo(true);
    		nuevoProcesoCandidato.save();
    		
    		Iterator iterWarning = recluCandidatoBusq.getEstado_busqueda().getWarning().iterator();
    		while (iterWarning.hasNext()) {
    			RecluWarnEstBusqCandi warn = (RecluWarnEstBusqCandi) iterWarning.next();
    			if (warn.getEstado_proceso().getOID() == nuevoProcesoCandidato.getEstado().getOID()) {
    				if (!procesosWarning.contains(nuevoProcesoCandidato.getEstado().getDescripcion()))
    					procesosWarning = procesosWarning +" '"+ nuevoProcesoCandidato.getEstado().getDescripcion()+"' ";
    			}
    		}
    		
    	
    	}
    	
    	if (procesosWarning.length()>0)
			cargarAdvertencia(dsAdvertencia, "ADVERTENCIA: El candidato se encuentra en estado '"+recluCandidatoBusq.getEstado_busqueda().getDescripcion().toUpperCase()+
					"' y algunos procesos se encuentran en estado "+procesosWarning.toUpperCase());
    	
    	
        dataset.next();
    }
      
    writeCliente(dsAdvertencia);
    writeCliente(dsConsCerrarBusq);
    
  }
  
  private IDataSet getDataSetAdvertencia() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAdvertencia");
	    dataset.fieldDef(new Field("mensaje", Field.STRING, 500)); 
	    return dataset;
	  }
  
  private IDataSet getDataConsultaCerrarBusq() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TConsCerrarBusq");
	    dataset.fieldDef(new Field("oid_busqueda", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("mensaje", Field.STRING, 500)); 
	    return dataset;
	  }  
  
  private void cargarAdvertencia(IDataSet ds, String advertencia) throws BaseException {
	  ds.append();
	  ds.fieldValue("mensaje", advertencia);
  }
  
  private void cargarConsultaCerrarBusq(IDataSet ds, RecluBusqueda busqueda, String advertencia) throws BaseException {
	  ds.append();
	  ds.fieldValue("oid_busqueda", busqueda.getOIDInteger());
	  ds.fieldValue("mensaje", advertencia);
  }  
  
}
