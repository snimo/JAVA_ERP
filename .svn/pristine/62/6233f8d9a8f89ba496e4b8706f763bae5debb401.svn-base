package com.srn.erp.cip.op;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.DocumentacionVisitaCIP;
import com.srn.erp.cip.bm.EmpresaCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.MotEntIntVis;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.bm.RotaVisita;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.sueldos.bm.Legajo;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveVisitas extends Operation { 

  public SaveVisitas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TVisitas"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
    	  
        Visita visita = Visita.findByOid(dataset.getInteger("oid_visita"),getSesion());
        visita.setApeyNom(dataset.getString("ape_y_nom"));
        visita.setActivo(dataset.getBoolean("activo"));
        visita.setTipoDocumento(TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_documento"), this.getSesion()));
        visita.setNroDocumento(dataset.getString("nro_documento"));
        visita.setGrupoPuertaEgreso(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta_egreso"), this.getSesion()));
        visita.setGrupoPuertaIngreso(GrupoPuerta.findByOidProxy(dataset.getInteger("oid_grupo_puerta_ingreso"), this.getSesion()));
        visita.setEmpresaCIP(EmpresaCIP.findByOidProxy(dataset.getInteger("oid_empresa"), this.getSesion()));
        visita.setVisitaA(Legajo.findByOidProxy(dataset.getInteger("oid_visita_a"), this.getSesion()));
        visita.setAutoriza(Legajo.findByOidProxy(dataset.getInteger("oid_autoriza"), this.getSesion()));
        visita.setControlAntiPassBack(dataset.getBoolean("antipass_vis"));
        visita.setIgnorarProxAntiPassBack(dataset.getBoolean("ignorar_prox_anti"));
        visita.setPermisoSemanal(PermisoSemanalCIP.findByOidProxy(dataset.getInteger("oid_planif_sem"), this.getSesion()));
        visita.setGrupoVisita(GrupoVisita.findByOidProxy(dataset.getInteger("oid_grupo_visita"), this.getSesion()));
        visita.setAplicVigencia(dataset.getBoolean("aplic_vig"));
        visita.setFecVigenciaDesde(dataset.getDate("fec_desde_vig"));
        visita.setFecVigenciaHasta(dataset.getDate("fec_hasta_vig"));
        visita.setCategAcceso(CategAccesoCIP.findByOidProxy(dataset.getInteger("oid_categ_acc_int"), this.getSesion()));
        visita.setMotivoVisita(MotivoVisita.findByOidProxy(dataset.getInteger("oid_mot_visita"), this.getSesion()));
        visita.setLibAccesoAlPredio(dataset.getBoolean("lib_acc_al_predio"));
        
        
        
        TarjetaCIP tarjeta = TarjetaCIP.findByOid(dataset.getInteger("oid_tarjeta"),this.getSesion());
        if (tarjeta!=null) {
        	
        	TarjetaCIP tarjetaYaAsig = TarjetaCIP.getTarjetaCIP(visita, this.getSesion());
        	if (tarjetaYaAsig!=null) {
        		tarjetaYaAsig.supportRefresh();
        		visita.addTarjetaCIP(tarjetaYaAsig);
        		tarjetaYaAsig.setVisita(null);
        		tarjetaYaAsig.setLegajo(null);
        		tarjetaYaAsig.setCliente(null);
        	}
        	
        	tarjeta.supportRefresh();
        	visita.addTarjetaCIP(tarjeta);
        	tarjeta.setVisita(visita);
        	tarjeta.setLegajo(null);
        	tarjeta.setCliente(null);
        	
        } else {
        	tarjeta = TarjetaCIP.getTarjetaCIP(visita, this.getSesion());
        	if (tarjeta!=null) {
        		tarjeta.supportRefresh();
        		visita.addTarjetaCIP(tarjeta);
        		tarjeta.setVisita(null);
        		tarjeta.setLegajo(null);
        		tarjeta.setCliente(null);
        		
        	}
        }
        
        grabarValoresClasif(visita,dataset);
        grabarDocumentacion(visita,dataset);
        grabarPlanifRotas(visita,dataset);
        grabarEntIntermedias(visita,dataset);
        addTransaccion(visita);
        dataset.next();
    }
  }
  
  private void grabarEntIntermedias(Visita visita,IDataSet dataset) throws BaseException {
      IDataSet dsMotivos = dataset.getDataSet("TMotAccesosIntermedios");
      dsMotivos.first();
      while (!dsMotivos.EOF()) {
      	MotivoEntIntermedias motivo   = MotivoEntIntermedias.findByOidProxy(dsMotivos.getInteger("oid_motivo"), this.getSesion());
      	if (dsMotivos.getBoolean("habilitado")) {
      		MotEntIntVis motEntIntVis = MotEntIntVis.getMotEntIntVis(visita, motivo, this.getSesion());
      		if (motEntIntVis==null) {
      			MotEntIntVis motEntInterVisNew = (MotEntIntVis) MotEntIntVis.getNew(MotEntIntVis.NICKNAME, this.getSesion());
      			motEntInterVisNew.setVisita(visita);
      			motEntInterVisNew.setMotivo(motivo);
      			motEntInterVisNew.setActivo(true);
      			visita.addMotEntInter(motEntInterVisNew);
      		}
      			
      	} else {
      		// Deshabilitado
      		MotEntIntVis motEntInterVis = MotEntIntVis.getMotEntIntVis(visita, motivo, this.getSesion());
      		if (motEntInterVis!=null) {
      			motEntInterVis.delete();
      			visita.addMotEntInter(motEntInterVis);
      		}
      		
      	}
      	
      	dsMotivos.next();
      }
	  
  }
  
  private void grabarPlanifRotas(Visita visita,IDataSet dataset) throws BaseException {
	IDataSet dsPlanifRota = dataset.getDataSet("TFechaRota");
	dsPlanifRota.first();
	while (!dsPlanifRota.EOF()) {
		Rota rota = Rota.findByOidProxy(dsPlanifRota.getInteger("oid_rota"), this.getSesion());
    	java.util.Date fecha = dsPlanifRota.getDate("fecha");
    	
    	if (dsPlanifRota.getBoolean("activo").booleanValue()==false) {
    		RotaVisita rotaVisita = RotaVisita.getRotaVisita(visita, rota, fecha, this.getSesion());
    		if (rotaVisita!=null) {
    			rotaVisita.delete();
    			visita.addRota(rotaVisita);
    		} 
    	} else {
    		RotaVisita rotaVisita = RotaVisita.getRotaVisita(visita, rota, fecha, this.getSesion());
    		if (rotaVisita == null) {
    			rotaVisita = (RotaVisita) RotaVisita.getNew(RotaVisita.NICKNAME, this.getSesion());
    			rotaVisita.setVisita(visita);
    			rotaVisita.setRota(rota);
    			rotaVisita.setFecha(fecha);
    			rotaVisita.setActivo(true);
    			visita.addRota(rotaVisita);
    		}
    		
    		Integer oidFechaRota = dsPlanifRota.getInteger("oid_rota_visita");
    		if ((oidFechaRota!=null) && (oidFechaRota>0)) {
    			RotaVisita rotaVisitaABorrar = RotaVisita.findByOid(oidFechaRota, this.getSesion());
    			if ((rotaVisitaABorrar.getFecha().equals(rotaVisita.getFecha())) && 
    					(rotaVisitaABorrar.getRota().getOID()==rotaVisita.getRota().getOID())) {
    				// Si es igual no hacer nada
    			} else {
    				rotaVisitaABorrar.delete();
    				visita.addRota(rotaVisitaABorrar);
    			}
    		}
    		
    		
    	}		
		dsPlanifRota.next();
	}
  }
  
  private void grabarDocumentacion(Visita visita,IDataSet dataset) throws BaseException {
	  IDataSet dsDocumentacion = dataset.getDataSet("TDocumentacionVisita");
	  dsDocumentacion.first();
	  while (!dsDocumentacion.EOF()) {
		  DocumentacionVisitaCIP docuVisitaCIP =
			  DocumentacionVisitaCIP.findByOid(dsDocumentacion.getInteger("oid_docu_visita"), this.getSesion());
		  docuVisitaCIP.setVistat(visita);
		  docuVisitaCIP.setTipo_documentacion(TipoDocumentacionCIP.findByOidProxy(dsDocumentacion.getInteger("oid_tipo_docu"), this.getSesion()));
		  docuVisitaCIP.setControla_fecha(dsDocumentacion.getBoolean("controla_fecha"));
		  docuVisitaCIP.setFec_vto(dsDocumentacion.getDate("fec_vto"));
		  docuVisitaCIP.setObservacion(dsDocumentacion.getString("observacion"));
		  docuVisitaCIP.setActivo(dsDocumentacion.getBoolean("activo"));
		  docuVisitaCIP.setPresentado(dsDocumentacion.getBoolean("presentado"));
		  docuVisitaCIP.setFecPresentacion(dsDocumentacion.getDate("fec_present"));
		  docuVisitaCIP.setFecEmision(dsDocumentacion.getDate("fec_emision"));
		  
		  visita.addDocumentacion(docuVisitaCIP);
		  
		  dsDocumentacion.next();
	  }
	  
	  
  }
  
  private void grabarValoresClasif(Visita visita,IDataSet dsSujeto) throws BaseException {
	    IDataSet dsValClasif = dsSujeto.getDataSet("TValoresClasificadores");
	    dsValClasif.first();
	    while (!dsValClasif.EOF()) {
	      visita.addOidValorClasif(dsValClasif.getInteger("nro_clasif"),
	                               dsValClasif.getInteger("oid_val_clasif_ent"));
	      dsValClasif.next();
	    }
  }
  
}
