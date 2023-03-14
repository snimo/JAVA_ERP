package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.DocumentacionVisitaCIP;
import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.MotEntIntVis;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.PermisoSemanalCIP;
import com.srn.erp.cip.bm.RotaVisita;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerGrupoVisita extends Operation { 

  public TraerGrupoVisita() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    GrupoVisita grupovisita = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       grupovisita = GrupoVisita.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       grupovisita = GrupoVisita.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetGrupoVisita = getDataSetGrupoVisita();
    IDataSet datasetDocumentacion = this.getDataSetDocumentacion();
    IDataSet datasetFechasRota = getDataSetRotas();
    IDataSet datasetEntInter = getDataSetEntInter();
    
    if (grupovisita != null) { 
    	
        cargarRegistroGrupoVisita(datasetGrupoVisita, 
                         grupovisita.getOIDInteger(),
                         grupovisita.getCodigo(),
                         grupovisita.getDescripcion(),
                         grupovisita.isActivo(),
                         grupovisita.isAntipassback(),
                         grupovisita.getGrupoPuertaIngreso(),
                         grupovisita.getGrupoPuertaEgreso(),
                         grupovisita.getPermisoSemanal(),
                         grupovisita.getVisitaA(),
                         grupovisita.getAutoriza(),
                         grupovisita.isAplicVigencia(),
                         grupovisita.getFecDesdeVig(),
                         grupovisita.getFecHastaVig(),
                         grupovisita.getCategoriaAcceso()
                         );
        
        Iterator iterDocu = 
        	grupovisita.getDocumentaciones().iterator();
        while (iterDocu.hasNext()) {
        	DocumentacionVisitaCIP docu = (DocumentacionVisitaCIP) iterDocu.next();
        	cargarRegistroDocu(datasetDocumentacion, docu);
        }
        
		java.util.Date fecha = Fecha.getFechaTruncada(UtilCIP.getFechaHoraActual(this.getSesion()));
		java.util.Date fecha1 = Fecha.getFechaDiaAnterior(fecha);
		
		Iterator iterRotas = grupovisita.getRotasVisita(fecha1).iterator();
		while (iterRotas.hasNext()) {
			RotaVisita rotaVisita = (RotaVisita) iterRotas.next();
			cargarRota(datasetFechasRota, rotaVisita);
		}
		
		traerMotivosAccesosIntermedios(datasetEntInter,grupovisita);
        
        
        
    }
    
    writeCliente(datasetGrupoVisita);
    writeCliente(datasetDocumentacion);
    writeCliente(datasetFechasRota);
    writeCliente(datasetEntInter);
    
  }

  private IDataSet getDataSetGrupoVisita() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TGrupoVisita");
    dataset.fieldDef(new Field("oid_grupo_visita", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("antipassback", Field.BOOLEAN, 0));
    
    dataset.fieldDef(new Field("oid_grupo_puerta_ingreso", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_grupo_puerta_ingreso", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_puerta_ingreso", Field.STRING, 100));
    
    dataset.fieldDef(new Field("oid_grupo_puerta_egreso", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_grupo_puerta_egreso", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_grupo_puerta_egreso", Field.STRING, 100));
    
    dataset.fieldDef(new Field("oid_permiso_sem", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_permiso_sem", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_permiso_sem", Field.STRING, 100));
    
    dataset.fieldDef(new Field("oid_visita_a", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_visita_a", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_visita_a", Field.STRING, 100));
    
    dataset.fieldDef(new Field("oid_autoriza", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_autoriza", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_autoriza", Field.INTEGER, 0));
    
    dataset.fieldDef(new Field("aplic_vig", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("fec_desde_vig", Field.DATE, 0));
    dataset.fieldDef(new Field("fec_hasta_vig", Field.DATE, 0));
    
	dataset.fieldDef(new Field("oid_categ_acc_int", Field.INTEGER, 0));
	dataset.fieldDef(new Field("cod_categ_acc_int", Field.STRING, 50));
	dataset.fieldDef(new Field("desc_categ_acc_int", Field.STRING, 100));
    
    
    
    
    return dataset;
  }
  
  private IDataSet getDataSetDocumentacion() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TDocumentacionVisita");
	    dataset.fieldDef(new Field("oid_docu_visita", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("controla_fecha", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_vto", Field.DATE, 0));
	    dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("presentado", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_present", Field.DATE, 0));
	    dataset.fieldDef(new Field("fec_emision", Field.DATE, 0));
	    dataset.fieldDef(new Field("oid_grupo_visita", Field.INTEGER, 0));
	    return dataset;
  }
  
  private void cargarRegistroDocu(
		  IDataSet dataset, 
          DocumentacionVisitaCIP docu) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_docu_visita", docu.getOIDInteger());
	  dataset.fieldValue("oid_visita", "");
	  dataset.fieldValue("oid_tipo_docu", docu.getTipo_documentacion().getOID());
	  dataset.fieldValue("controla_fecha", docu.isControla_fecha());
	  dataset.fieldValue("fec_vto", docu.getFec_vto());
	  dataset.fieldValue("observacion", docu.getObservacion());
	  dataset.fieldValue("activo", docu.isActivo());
	  dataset.fieldValue("presentado", docu.isPresentado());
	  dataset.fieldValue("fec_present", docu.getFecPresentacion());
	  dataset.fieldValue("fec_emision", docu.getFecEmision());
	  dataset.fieldValue("oid_grupo_visita", docu.getGrupoVisita().getOIDInteger());
  }  
  

  private void cargarRegistroGrupoVisita(IDataSet dataset, 
                         Integer oid_grupo_visita,
                         String codigo,
                         String descripcion,
                         Boolean activo,
                         boolean antipassback,
                         GrupoPuerta grupoPuertaIng,
                         GrupoPuerta grupoPuertaEgr,
                         PermisoSemanalCIP permisoSemanal,
                         Legajo visitaA,
                         Legajo autoriza,
                         boolean aplicVig,
                         java.util.Date fecVigDesde,
                         java.util.Date fecVigHasta,
                         CategAccesoCIP categAccesoInterno) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_grupo_visita", oid_grupo_visita);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
    dataset.fieldValue("antipassback", antipassback);
    
    if (grupoPuertaIng!=null) {
    	dataset.fieldValue("oid_grupo_puerta_ingreso", grupoPuertaIng.getOIDInteger());
    	dataset.fieldValue("cod_grupo_puerta_ingreso", grupoPuertaIng.getCodigo());
    	dataset.fieldValue("desc_grupo_puerta_ingreso", grupoPuertaIng.getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_grupo_puerta_ingreso", "");
    	dataset.fieldValue("cod_grupo_puerta_ingreso", "");
    	dataset.fieldValue("desc_grupo_puerta_ingreso", "");
    }
    
    if (grupoPuertaEgr!=null) {
    	dataset.fieldValue("oid_grupo_puerta_egreso", grupoPuertaEgr.getOIDInteger());
    	dataset.fieldValue("cod_grupo_puerta_egreso", grupoPuertaEgr.getCodigo());
    	dataset.fieldValue("desc_grupo_puerta_egreso", grupoPuertaEgr.getDescripcion());
    } else {
    	dataset.fieldValue("oid_grupo_puerta_egreso", "");
    	dataset.fieldValue("cod_grupo_puerta_egreso", "");
    	dataset.fieldValue("desc_grupo_puerta_egreso", "");
    }
    
    if (permisoSemanal!=null) {
    	dataset.fieldValue("oid_permiso_sem", permisoSemanal.getOIDInteger());
    	dataset.fieldValue("cod_permiso_sem", permisoSemanal.getCodigo());
    	dataset.fieldValue("desc_permiso_sem", permisoSemanal.getDescripcion());
    } else {
    	dataset.fieldValue("oid_permiso_sem", "");
    	dataset.fieldValue("cod_permiso_sem", "");
    	dataset.fieldValue("desc_permiso_sem", "");
    }
   
    if (visitaA!=null) {
    	dataset.fieldValue("oid_visita_a", visitaA.getOIDInteger());
    	dataset.fieldValue("cod_visita_a", visitaA.getNro_legajo());
    	dataset.fieldValue("desc_visita_a", visitaA.getApellidoyNombre());
    } else {
    	dataset.fieldValue("oid_visita_a", "");
    	dataset.fieldValue("cod_visita_a", "");
    	dataset.fieldValue("desc_visita_a", "");
    }
    
    if (autoriza!=null) {
    	dataset.fieldValue("oid_autoriza", autoriza.getOIDInteger());
    	dataset.fieldValue("cod_autoriza", autoriza.getNro_legajo());
    	dataset.fieldValue("desc_autoriza", autoriza.getApellidoyNombre());
    } else {
    	dataset.fieldValue("oid_autoriza", "");
    	dataset.fieldValue("cod_autoriza", "");
    	dataset.fieldValue("desc_autoriza", "");
    }
    
    dataset.fieldValue("aplic_vig", aplicVig);
    dataset.fieldValue("fec_desde_vig", fecVigDesde);
    dataset.fieldValue("fec_hasta_vig", fecVigHasta);
    
	if (categAccesoInterno!=null) {
		dataset.fieldValue("oid_categ_acc_int", categAccesoInterno.getOIDInteger());
		dataset.fieldValue("cod_categ_acc_int", categAccesoInterno.getCodigo());
		dataset.fieldValue("desc_categ_acc_int", categAccesoInterno.getDescripcion());
	} else {
		dataset.fieldValue("oid_categ_acc_int", "");
		dataset.fieldValue("cod_categ_acc_int", "");
		dataset.fieldValue("desc_categ_acc_int", "");
	}
    

    
  }
  
	private IDataSet getDataSetRotas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFechaRota");
		dataset.fieldDef(new Field("oid_rota_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("oid_rota",Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_rota",Field.STRING, 50));
		dataset.fieldDef(new Field("desc_rota",Field.STRING, 100));
		dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_grupo_visita",Field.INTEGER, 0));
		return dataset;
	}
	
	private IDataSet getDataSetEntInter() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMotAccesosIntermedios");
		dataset.fieldDef(new Field("secu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_visita", Field.INTEGER, 0));
		dataset.fieldDef(new Field("habilitado", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_motivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("oid_grupo_visita", Field.INTEGER, 0));
		return dataset;
	}
	
	
	private void cargarRota(
			IDataSet dataset, 
			RotaVisita rotaVisita) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_rota_visita", rotaVisita.getOIDInteger());
		dataset.fieldValue("oid_visita", "");
		dataset.fieldValue("fecha", rotaVisita.getFecha());
		dataset.fieldValue("oid_rota",rotaVisita.getRota().getOIDInteger());
		dataset.fieldValue("cod_rota",rotaVisita.getRota().getCodigo());
		dataset.fieldValue("desc_rota",rotaVisita.getRota().getDescripcion());
		dataset.fieldValue("activo",rotaVisita.isActivo());
		dataset.fieldValue("oid_grupo_visita",rotaVisita.getGrupoVisita().getOIDInteger());
	}
	
	  private void traerMotivosAccesosIntermedios(
			  IDataSet datasetMotivosLeg,
			  GrupoVisita grupo) throws BaseException {
		  int secu = 1;
		  
		  Iterator iterMotivoEntIntermedias = 
			  MotivoEntIntermedias.getMotivoEntIntermedias(this.getSesion()).iterator();
		  while (iterMotivoEntIntermedias.hasNext()) {
			  MotivoEntIntermedias motivoEntIntermedias = (MotivoEntIntermedias) iterMotivoEntIntermedias.next();
			  ++secu;
			  datasetMotivosLeg.append();
			  datasetMotivosLeg.fieldValue("secu", secu);
			  datasetMotivosLeg.fieldValue("oid_visita", "");
			  MotEntIntVis motEntInterVis =
				  MotEntIntVis.getMotEntIntVis(grupo, motivoEntIntermedias, this.getSesion());
			  
			  if (motEntInterVis!=null) 		  
				  datasetMotivosLeg.fieldValue("habilitado", true);
			  else
				  datasetMotivosLeg.fieldValue("habilitado", false);
			  
			  datasetMotivosLeg.fieldValue("oid_motivo", motivoEntIntermedias.getOIDInteger());
			  datasetMotivosLeg.fieldValue("desc_motivo", motivoEntIntermedias.getDescripcion());
			  datasetMotivosLeg.fieldValue("oid_grupo_visita", grupo.getOIDInteger());
		  }
	  }
	
	
  
  
}
