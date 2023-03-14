package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.DocumentacionVisitaCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.MotEntIntVis;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.RotaVisita;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveGrupoVisita extends Operation { 

  public SaveGrupoVisita() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TGrupoVisita"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        GrupoVisita grupovisita = GrupoVisita.findByOid(dataset.getInteger("oid_grupo_visita"),getSesion());
        grupovisita.setOID(dataset.getInteger("oid_grupo_visita"));
        grupovisita.setCodigo(dataset.getString("codigo"));
        grupovisita.setDescripcion(dataset.getString("descripcion"));
        grupovisita.setActivo(dataset.getBoolean("activo"));
        grupovisita.setAntiPassBack(dataset.getBoolean("antipassback"));
        grupovisita.setGrupoPuertaIngreso(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta_ingreso"), this.getSesion()));
        grupovisita.setGrupoPuertaEgreso(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta_egreso"), this.getSesion()));
        grupovisita.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(dataset.getInteger("oid_permiso_sem"), this.getSesion()));
        grupovisita.setVisitaA(Legajo.findByOidProxy(dataset.getInteger("oid_visita_a"), this.getSesion()));
        grupovisita.setAutoriza(Legajo.findByOidProxy(dataset.getInteger("oid_autoriza"), this.getSesion()));
        grupovisita.setAplicVigencia(dataset.getBoolean("aplic_vig"));
        grupovisita.setFecDesdeVig(dataset.getDate("fec_desde_vig"));
        grupovisita.setFecHastaVig(dataset.getDate("fec_hasta_vig"));
        grupovisita.setCategAcceso(CategAccesoCIP.findByOidProxy(dataset.getInteger("oid_categ_acc_int"), this.getSesion()));
        
        IDataSet dsDocu = dataset.getDataSet("TDocumentacionVisita");
        dsDocu.first();
        while (!dsDocu.EOF()) {
        	DocumentacionVisitaCIP documentacion = DocumentacionVisitaCIP.findByOid(dsDocu.getInteger("oid_docu_visita"), this.getSesion());
        	documentacion.setVistat(null);
        	documentacion.setTipo_documentacion(TipoDocumentacionCIP.findByOidProxy(dsDocu.getInteger("oid_tipo_docu"), this.getSesion()));
        	documentacion.setControla_fecha(dsDocu.getBoolean("controla_fecha"));
        	documentacion.setFec_vto(dsDocu.getDate("fec_vto"));
        	documentacion.setObservacion(dsDocu.getString("observacion"));
        	documentacion.setActivo(dsDocu.getBoolean("activo"));
        	documentacion.setPresentado(dsDocu.getBoolean("presentado"));
        	documentacion.setFecPresentacion(dsDocu.getDate("fec_present"));
        	documentacion.setFecEmision(dsDocu.getDate("fec_emision"));
        	documentacion.setGrupoVisita(GrupoVisita.findByOidProxy(dsDocu.getInteger("oid_grupo_visita"), this.getSesion()));
        	if (!documentacion.isActivo()) documentacion.delete();
        	grupovisita.addDocumentacion(documentacion);
        	dsDocu.next();
        }
        
        grabarPlanifRotas(grupovisita,dataset);
        grabarEntIntermedias(grupovisita,dataset);
        
        addTransaccion(grupovisita);
        dataset.next();
    }
  }
  
  private void grabarPlanifRotas(GrupoVisita grupo,IDataSet dataset) throws BaseException {
		IDataSet dsPlanifRota = dataset.getDataSet("TFechaRota");
		dsPlanifRota.first();
		while (!dsPlanifRota.EOF()) {
			Rota rota = Rota.findByOidProxy(dsPlanifRota.getInteger("oid_rota"), this.getSesion());
	    	java.util.Date fecha = dsPlanifRota.getDate("fecha");
	    	
	    	if (dsPlanifRota.getBoolean("activo").booleanValue()==false) {
	    		RotaVisita rotaVisita = RotaVisita.getRotaVisita(grupo, rota, fecha, this.getSesion());
	    		if (rotaVisita!=null) {
	    			rotaVisita.delete();
	    			grupo.addRotas(rotaVisita);
	    		} 
	    	} else {
	    		RotaVisita rotaVisita = RotaVisita.getRotaVisita(grupo, rota, fecha, this.getSesion());
	    		if (rotaVisita == null) {
	    			rotaVisita = (RotaVisita) RotaVisita.getNew(RotaVisita.NICKNAME, this.getSesion());
	    			rotaVisita.setVisita(null);
	    			rotaVisita.setGrupoVisita(grupo);
	    			rotaVisita.setRota(rota);
	    			rotaVisita.setFecha(fecha);
	    			rotaVisita.setActivo(true);
	    			grupo.addRotas(rotaVisita);
	    		}
	    		
	    		Integer oidFechaRota = dsPlanifRota.getInteger("oid_rota_visita");
	    		if ((oidFechaRota!=null) && (oidFechaRota>0)) {
	    			RotaVisita rotaVisitaABorrar = RotaVisita.findByOid(oidFechaRota, this.getSesion());
	    			if ((rotaVisitaABorrar.getFecha().equals(rotaVisita.getFecha())) && 
	    					(rotaVisitaABorrar.getRota().getOID()==rotaVisita.getRota().getOID())) {
	    				// Si es igual no hacer nada
	    			} else {
	    				rotaVisitaABorrar.delete();
	    				grupo.addRotas(rotaVisitaABorrar);
	    			}
	    		}
	    		
	    		
	    	}		
			dsPlanifRota.next();
		}
	  }
  
  
  private void grabarEntIntermedias(GrupoVisita grupo,IDataSet dataset) throws BaseException {
      IDataSet dsMotivos = dataset.getDataSet("TMotAccesosIntermedios");
      dsMotivos.first();
      while (!dsMotivos.EOF()) {
      	MotivoEntIntermedias motivo   = MotivoEntIntermedias.findByOidProxy(dsMotivos.getInteger("oid_motivo"), this.getSesion());
      	if (dsMotivos.getBoolean("habilitado")) {
      		MotEntIntVis motEntIntVis = MotEntIntVis.getMotEntIntVis(grupo, motivo, this.getSesion());
      		if (motEntIntVis==null) {
      			MotEntIntVis motEntInterVisNew = (MotEntIntVis) MotEntIntVis.getNew(MotEntIntVis.NICKNAME, this.getSesion());
      			motEntInterVisNew.setVisita(null);
      			motEntInterVisNew.setMotivo(motivo);
      			motEntInterVisNew.setActivo(true);
      			motEntInterVisNew.setGrupoVisita(grupo);
      			grupo.addEntradaIntermedia(motEntInterVisNew);
      		}
      			
      	} else {
      		// Deshabilitado
      		MotEntIntVis motEntInterVis = MotEntIntVis.getMotEntIntVis(grupo, motivo, this.getSesion());
      		if (motEntInterVis!=null) {
      			motEntInterVis.delete();
      			grupo.addEntradaIntermedia(motEntInterVis);
      		}
      		
      	}
      	
      	dsMotivos.next();
      }
	  
  }

  
  
}
