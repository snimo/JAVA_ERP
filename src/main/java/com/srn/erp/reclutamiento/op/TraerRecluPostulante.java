package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluCompePostu;
import com.srn.erp.reclutamiento.bm.RecluCurriPostu;
import com.srn.erp.reclutamiento.bm.RecluNovedadPostu;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluPuestoAplica;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluPostulante extends Operation { 

  public TraerRecluPostulante() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluPostulante reclupostulante = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclupostulante = RecluPostulante.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclupostulante = RecluPostulante.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluPostulante = getDataSetRecluPostulante();
    IDataSet datasetRecluCompetencias = getDataSetRecluCompetencias();
    IDataSet datasetRecluCurri = getDataSetRecluCurriculumns();
    IDataSet datasetNovedades = this.getDataSetRecluNovedadPostu();
    IDataSet datasetPuestoAplica = this.getDataSetRecluPostuAplica();
    IDataSet datasetProcesosPostu = this.getDataSetProcesoCandidato();
    
    
    if (reclupostulante != null) {
    	
        cargarRegistroRecluPostulante(datasetRecluPostulante, reclupostulante);
        
        Iterator iterCompetenciasPostu = reclupostulante.getCompetenciasPostu().iterator();
        while (iterCompetenciasPostu.hasNext()) {
        	RecluCompePostu recluCompetencias = (RecluCompePostu) iterCompetenciasPostu.next();
        	cargarRegistroRecluCompetencia(datasetRecluCompetencias, recluCompetencias);
        }
        
        Iterator iterCurriPostu = reclupostulante.getCurriculums().iterator();
        while (iterCurriPostu.hasNext()) {
        	RecluCurriPostu recluCurriPostu = (RecluCurriPostu) iterCurriPostu.next();
        	cargarRegistroRecluCurriculum(datasetRecluCurri, recluCurriPostu);
        }        
        
        Iterator iterNovedades = reclupostulante.getNovedades().iterator();
        while (iterNovedades.hasNext()) {
        	RecluNovedadPostu novedad = (RecluNovedadPostu) iterNovedades.next();
        	cargarRegistroRecluNovedadPostu(datasetNovedades, novedad);
        }        
        
        Iterator iterPuestosAplic = reclupostulante.getPuestosAplica().iterator();
        while (iterPuestosAplic.hasNext()) {
        	RecluPuestoAplica puestoAplica = (RecluPuestoAplica) iterPuestosAplic.next();
        	cargarRegistroPuestoAplica(datasetPuestoAplica, puestoAplica);
        }      
        
        Iterator iterProcesosPostu = reclupostulante.getProcesosPostulante().iterator();
        while (iterProcesosPostu.hasNext()) {
        	RecluProcesoCandidato recluProceso = (RecluProcesoCandidato) iterProcesosPostu.next();
        	if (!recluProceso.getProceso().isVisuSolapaPostulante()) continue;
        	cargarProcesoCandidato(datasetProcesosPostu, recluProceso);
        }        
        
        
        
        
    }
    
    writeCliente(datasetRecluPostulante);
    writeCliente(datasetRecluCompetencias);
    writeCliente(datasetRecluCurri);
    writeCliente(datasetNovedades);
    writeCliente(datasetPuestoAplica);
    writeCliente(datasetProcesosPostu);
    
  }

  private IDataSet getDataSetRecluPostulante() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluPostulante");
    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_tipo_docu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_docu", Field.STRING, 30)); 
    dataset.fieldDef(new Field("fec_nacimiento", Field.DATE, 0)); 
    dataset.fieldDef(new Field("direccion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("localidad", Field.STRING, 100)); 
    dataset.fieldDef(new Field("cod_postal", Field.STRING, 50)); 
    dataset.fieldDef(new Field("telefono_fijo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("telefono_celular", Field.STRING, 50)); 
    dataset.fieldDef(new Field("referido_por", Field.STRING, 100)); 
    dataset.fieldDef(new Field("sexo", Field.STRING, 1)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("es_referido", Field.BOOLEAN, 0));
    dataset.fieldDef(new Field("nro_referido", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_fuente", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_estado_postu", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("fec_est_postu", Field.DATE, 0));
    return dataset;
  }
  
  
  private IDataSet getDataSetRecluCompetencias() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluCompetencia");
	    dataset.fieldDef(new Field("oid_compe_postu", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("grupo_competencia", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
  }
  
  
  private IDataSet getDataSetRecluCurriculumns() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluCurriculum");
	    dataset.fieldDef(new Field("oid_curriculum", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fecha_recepcion", Field.DATE, 0));
	    dataset.fieldDef(new Field("entregado_por", Field.STRING, 100));
	    dataset.fieldDef(new Field("observacion", Field.STRING, 1000));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("nro_archivo_cv", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nombre_archivo", Field.STRING, 255));
	    return dataset;
  }
  
  private void cargarRegistroRecluCurriculum(
		  IDataSet dataset, 
          RecluCurriPostu aRecluCurriPostu) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_curriculum", aRecluCurriPostu.getOIDInteger());
	  dataset.fieldValue("oid_postulante", aRecluCurriPostu.getPostulante().getOIDInteger());
	  dataset.fieldValue("fecha_recepcion", aRecluCurriPostu.getFecha_recepcion());
	  dataset.fieldValue("entregado_por", aRecluCurriPostu.getEntregado_por());
	  dataset.fieldValue("observacion", aRecluCurriPostu.getObservacion());
	  dataset.fieldValue("activo", aRecluCurriPostu.isActivo());
	  dataset.fieldValue("nro_archivo_cv", aRecluCurriPostu.getNroArchivoCV());
	  dataset.fieldValue("nombre_archivo", aRecluCurriPostu.getNombreArchivo());
  }  
  
  
  
  private void cargarRegistroRecluCompetencia(
		  IDataSet dataset, 
          RecluCompePostu aRecluCompePostu) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_compe_postu", aRecluCompePostu.getOIDInteger());
	  dataset.fieldValue("oid_postulante", aRecluCompePostu.getPostulante().getOIDInteger());
	  dataset.fieldValue("oid_competencia", aRecluCompePostu.getCompetencia().getOIDInteger());
	  dataset.fieldValue("grupo_competencia", aRecluCompePostu.getCompetencia().getOid_grupo_compe().getDescripcion());
	  dataset.fieldValue("activo", aRecluCompePostu.isActivo());
  }
  
  private void cargarRegistroPuestoAplica(IDataSet dataset, 
          RecluPuestoAplica aRecluPuestoAplica) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_puesto_aplica", aRecluPuestoAplica.getOIDInteger());
	    dataset.fieldValue("oid_postulante", aRecluPuestoAplica.getPostulante().getOIDInteger());
	    dataset.fieldValue("oid_puesto_busqueda", aRecluPuestoAplica.getPuesto().getOIDInteger());
	    dataset.fieldValue("nombre_puesto", aRecluPuestoAplica.getPuesto().getDescripcion());
	    dataset.fieldValue("activo", aRecluPuestoAplica.isActivo());	    
  }
  
  private void cargarRegistroRecluPostulante(IDataSet dataset, 
                         RecluPostulante postulante) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_postulante", postulante.getOIDInteger());
    dataset.fieldValue("ape_y_nom", postulante.getApe_y_nom());
    if (postulante.getTipo_documento()!=null)
    	dataset.fieldValue("oid_tipo_docu", postulante.getTipo_documento().getOIDInteger());
    else
    	dataset.fieldValue("oid_tipo_docu", "");
    dataset.fieldValue("nro_docu", postulante.getNro_docu());
    dataset.fieldValue("fec_nacimiento", postulante.getFec_nacimiento());
    dataset.fieldValue("direccion", postulante.getDireccion());
    dataset.fieldValue("localidad", postulante.getLocalidad());
    dataset.fieldValue("cod_postal", postulante.getCod_postal());
    dataset.fieldValue("telefono_fijo", postulante.getTelefono_fijo());
    dataset.fieldValue("telefono_celular", postulante.getTelefono_celular());
    dataset.fieldValue("referido_por", postulante.getReferido_por());
    dataset.fieldValue("sexo", postulante.getSexo());
    dataset.fieldValue("activo", postulante.isActivo());
    dataset.fieldValue("es_referido", postulante.isReferido());
    dataset.fieldValue("nro_referido", postulante.getNroReferido());
    if (postulante.getFuente()!=null)
    	dataset.fieldValue("oid_fuente", postulante.getFuente().getOIDInteger());
    else
    	dataset.fieldValue("oid_fuente", "");
    if (postulante.getEstadoPostulante()!=null)
    	dataset.fieldValue("oid_estado_postu", postulante.getEstadoPostulante().getOIDInteger());
    else
    	dataset.fieldValue("oid_estado_postu", "");
    dataset.fieldValue("fec_est_postu", postulante.getFecEstadoPostulante());    
  }
  
  
  private IDataSet getDataSetProcesoCandidato() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TProcesosCandidato");
	    dataset.fieldDef(new Field("titulo", Field.STRING, 255));
	    dataset.fieldDef(new Field("oid_proceso_sel", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_candidato_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_proceso",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("proceso", Field.STRING, 255));
	    dataset.fieldDef(new Field("oid_conc_proceso",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("concepto", Field.STRING, 255));
	    dataset.fieldDef(new Field("costo", Field.CURRENCY, 255));
	    dataset.fieldDef(new Field("oid_est_proc_sel",Field.INTEGER, 0));
	    dataset.fieldDef(new Field("estado", Field.STRING, 50));
	    dataset.fieldDef(new Field("fecha_planif", Field.DATE, 0));
	    dataset.fieldDef(new Field("hora_planif", Field.STRING, 10));
	    dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
	    dataset.fieldDef(new Field("puede_iniciar", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("persona", Field.STRING, 255));
	    dataset.fieldDef(new Field("nro_archivo", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nombre_archivo", Field.STRING, 255));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
	  }
  
  private void cargarProcesoCandidato(IDataSet ds , RecluProcesoCandidato recluProcesoCandidato) throws BaseException {
	  ds.append(); 
	  if (recluProcesoCandidato.getCandidato_busq()!=null) {
		  String fecAlta = "";
		  String estadoBusqueda = "";
		  
		  if (recluProcesoCandidato.getCandidato_busq()!=null) {
			  fecAlta = "Fec. Alta "+ Fecha.getddmmyyyy(recluProcesoCandidato.getCandidato_busq().getBusqueda().getFec_alta());
			  if (recluProcesoCandidato.getCandidato_busq().getBusqueda()!=null)
				  estadoBusqueda = recluProcesoCandidato.getCandidato_busq().getBusqueda().getEstado_busqueda();
			  
		  }
		  
		  ds.fieldValue("titulo" ,  fecAlta+ " "+ 
				  				    " Búsqueda "+
				  					recluProcesoCandidato.getCandidato_busq().getBusqueda().getPuesto().getDescripcion()+
				  					" en "+
				  					recluProcesoCandidato.getCandidato_busq().getBusqueda().getOperacion().getDescripcion()+" ("+
				  					recluProcesoCandidato.getCandidato_busq().getBusqueda().getSector().getDescripcion()+") "+" Est. Búsqueda "+estadoBusqueda
				  					);
	  }
	  else {
		  String titulo = "";
		  if (recluProcesoCandidato.getOperacion()!=null)
			  titulo = titulo + recluProcesoCandidato.getOperacion().getDescripcion();

		  if (recluProcesoCandidato.getSector()!=null)
			  titulo = titulo + " ("+recluProcesoCandidato.getSector().getDescripcion()+") ";		  
		  
		  ds.fieldValue("titulo" , titulo);
	  }
	  ds.fieldValue("oid_proceso_sel" , recluProcesoCandidato.getOIDInteger());
	  if (recluProcesoCandidato.getCandidato_busq()!=null)
		  ds.fieldValue("oid_candidato_busq", recluProcesoCandidato.getCandidato_busq().getOIDInteger());
	  else
		  ds.fieldValue("oid_candidato_busq", "");
	  ds.fieldValue("orden", recluProcesoCandidato.getOrden());
	  ds.fieldValue("oid_proceso", recluProcesoCandidato.getProceso().getOIDInteger());
	  ds.fieldValue("proceso", recluProcesoCandidato.getProceso().getDescripcion());
	  ds.fieldValue("oid_conc_proceso", recluProcesoCandidato.getConcepto_proceso().getOIDInteger());
	  ds.fieldValue("concepto", recluProcesoCandidato.getConcepto_proceso().getDescripcion());
	  ds.fieldValue("costo", recluProcesoCandidato.getCosto());
	  if (recluProcesoCandidato.getEstado()!=null) {
		  ds.fieldValue("oid_est_proc_sel", recluProcesoCandidato.getEstado().getOIDInteger());
		  ds.fieldValue("estado", recluProcesoCandidato.getEstado().getDescripcion());
	  }
	  else {
		  ds.fieldValue("oid_est_proc_sel", "");
		  ds.fieldValue("estado", "");
	  }
	  
	  ds.fieldValue("fecha_planif", recluProcesoCandidato.getFecha_planif());
	  ds.fieldValue("hora_planif", recluProcesoCandidato.getHora_planif());
	  
	  ds.fieldValue("observaciones", recluProcesoCandidato.getObservaciones());
	  ds.fieldValue("puede_iniciar", recluProcesoCandidato.isPuede_iniciar());
	  if (recluProcesoCandidato.getRecluPostulante()!=null) {
		  ds.fieldValue("oid_postulante", recluProcesoCandidato.getRecluPostulante().getOIDInteger());
	  } else {
		  if ((recluProcesoCandidato.getCandidato_busq()!=null) && (recluProcesoCandidato.getCandidato_busq().getOid_postulante()!=null)) {
			  ds.fieldValue("oid_postulante", recluProcesoCandidato.getCandidato_busq().getOid_postulante().getOIDInteger());
		  } else {
			  ds.fieldValue("oid_postulante", "");
		  }
	  }
	  ds.fieldValue("persona", recluProcesoCandidato.getPersona());
	  ds.fieldValue("nro_archivo", recluProcesoCandidato.getNroArchivo());
	  if ((recluProcesoCandidato.getCandidato_busq()!=null) && (recluProcesoCandidato.getCandidato_busq().getBusqueda()!=null))
		  ds.fieldValue("oid_busqueda_act" , recluProcesoCandidato.getCandidato_busq().getBusqueda().getOIDInteger());
	  else
		  ds.fieldValue("oid_busqueda_act" , "");
	  ds.fieldValue("nombre_archivo", recluProcesoCandidato.getNombreArchivo());
	  ds.fieldValue("activo", recluProcesoCandidato.isActivo());	  
  }
  
  
  private IDataSet getDataSetRecluNovedadPostu() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluNovedadPostu");
	    dataset.fieldDef(new Field("oid_nov_postu", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0)); 
	    dataset.fieldDef(new Field("fecha", Field.DATE, 0)); 
	    dataset.fieldDef(new Field("novedad", Field.STRING, 4000)); 
	    dataset.fieldDef(new Field("exc_fut_postu", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("oid_usuario", Field.BOOLEAN, 0)); 
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_vigencia", Field.DATE, 0));
	    
	    return dataset;
	  }
  
  private IDataSet getDataSetRecluPostuAplica() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TRecluPuestoAplica");
	    dataset.fieldDef(new Field("oid_puesto_aplica", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_puesto_busqueda", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nombre_puesto", Field.STRING, 255));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
	  }  

	  private void cargarRegistroRecluNovedadPostu(IDataSet dataset, 
	                         RecluNovedadPostu novedad) throws BaseException {
	    dataset.append(); 
	    dataset.fieldValue("oid_nov_postu", novedad.getOIDInteger());
	    dataset.fieldValue("oid_postulante", novedad.getPostulante().getOIDInteger());
	    dataset.fieldValue("fecha", novedad.getFecha());
	    dataset.fieldValue("novedad", novedad.getNovedad());
	    dataset.fieldValue("exc_fut_postu", novedad.isExc_fut_postu());
	    dataset.fieldValue("oid_usuario", novedad.getUsuario().getOIDInteger());
	    dataset.fieldValue("activo", novedad.isActivo());
	    dataset.fieldValue("fec_vigencia", novedad.getFecVigencia());
	  }  
  
}
