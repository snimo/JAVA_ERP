package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluCompePostu;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluCurriPostu;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluFuente;
import com.srn.erp.reclutamiento.bm.RecluNovedadPostu;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.bm.RecluPuestoAplica;
import com.srn.erp.ventas.bm.TipoDocumento;

import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluPostulante extends Operation { 

  public SaveRecluPostulante() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluPostulante"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluPostulante reclupostulante = RecluPostulante.findByOid(dataset.getInteger("oid_postulante"),getSesion());
        reclupostulante.setOID(dataset.getInteger("oid_postulante"));
        reclupostulante.setApe_y_nom(dataset.getString("ape_y_nom"));
        reclupostulante.setTipo_documento(TipoDocumento.findByOidProxy(dataset.getInteger("oid_tipo_docu"),this.getSesion()));
        reclupostulante.setNro_docu(dataset.getString("nro_docu"));
        reclupostulante.setFec_nacimiento(dataset.getDate("fec_nacimiento"));
        reclupostulante.setDireccion(dataset.getString("direccion"));
        reclupostulante.setLocalidad(dataset.getString("localidad"));
        reclupostulante.setCod_postal(dataset.getString("cod_postal"));
        reclupostulante.setTelefono_fijo(dataset.getString("telefono_fijo"));
        reclupostulante.setTelefono_celular(dataset.getString("telefono_celular"));
        reclupostulante.setReferido_por(dataset.getString("referido_por"));
        reclupostulante.setSexo(dataset.getString("sexo"));
        reclupostulante.setActivo(dataset.getBoolean("activo"));
        reclupostulante.setIsReferido(dataset.getBoolean("es_referido"));
        reclupostulante.setNroReferido(dataset.getInteger("nro_referido"));
        reclupostulante.setFuente(RecluFuente.findByOid(dataset.getInteger("oid_fuente"), this.getSesion()));
        reclupostulante.setEstadoPostulante(RecluEstadoPostulante.findByOidProxy(dataset.getInteger("oid_estado_postu"), this.getSesion()));
        reclupostulante.setFecEstadoPostulante(dataset.getDate("fec_est_postu"));
        
        if (reclupostulante.getFecEstadoPostulante()==null)
        	reclupostulante.setFecEstadoPostulante(Util.getFechaActual(this.getSesion()));
        
        
        IDataSet dsNovedad = dataset.getDataSet("TRecluNovedadPostu");
        dsNovedad.first();
        while (!dsNovedad.EOF()) {
        	RecluNovedadPostu recluNovedadPostu = RecluNovedadPostu.findByOid(dsNovedad.getInteger("oid_nov_postu"), this.getSesion());
        	recluNovedadPostu.setPostulante(reclupostulante);
        	recluNovedadPostu.setFecha(dsNovedad.getDate("fecha"));
        	recluNovedadPostu.setNovedad(dsNovedad.getString("novedad"));
        	recluNovedadPostu.setExc_fut_postu(dsNovedad.getBoolean("exc_fut_postu"));
        	recluNovedadPostu.setUsuario(Usuario.findByOidProxy(this.getSesion().getLogin().getUsuario().getOID(), this.getSesion()));
        	recluNovedadPostu.setActivo(dsNovedad.getBoolean("activo"));
        	recluNovedadPostu.setFecVigencia(dsNovedad.getDate("fec_vigencia"));
        	reclupostulante.addRecluNovedad(recluNovedadPostu);
        	dsNovedad.next();
        }
        
        
        IDataSet dsCompetencias = dataset.getDataSet("TRecluCompetencia");
        dsCompetencias.first();
        while (!dsCompetencias.EOF()) {
        	RecluCompePostu recluCompePostu = RecluCompePostu.findByOid(dsCompetencias.getInteger("oid_compe_postu"), this.getSesion());
        	recluCompePostu.setPostulante(reclupostulante);
        	recluCompePostu.setCompetencia(RecluCompetencias.findByOidProxy(dsCompetencias.getInteger("oid_competencia"), this.getSesion()));
        	recluCompePostu.setActivo(dsCompetencias.getBoolean("activo"));
        	reclupostulante.addRecluCompetencia(recluCompePostu);
        	dsCompetencias.next();
        }
        
        
        IDataSet dsCurri = dataset.getDataSet("TRecluCurriculum");
        dsCurri.first();
        while (!dsCurri.EOF()) {
        	RecluCurriPostu recluCurriPostu = RecluCurriPostu.findByOid(dsCurri.getInteger("oid_curriculum"), this.getSesion());
        	recluCurriPostu.setPostulante(reclupostulante);
        	recluCurriPostu.setFecha_recepcion(dsCurri.getDate("fecha_recepcion"));
        	recluCurriPostu.setEntregado_por(dsCurri.getString("entregado_por"));
        	recluCurriPostu.setObservacion(dsCurri.getString("observacion"));
        	recluCurriPostu.setActivo(dsCurri.getBoolean("activo"));
        	recluCurriPostu.setNroArchivoCV(dsCurri.getInteger("nro_archivo_cv"));
        	recluCurriPostu.setNombreArchivo(dsCurri.getString("nombre_archivo"));
        	reclupostulante.addRecluCurriculum(recluCurriPostu);
        	dsCurri.next();
        }        
        
        
        IDataSet dsPuestosAplica = dataset.getDataSet("TRecluPuestoAplica");
        dsPuestosAplica.first();
        while (!dsPuestosAplica.EOF()) {
        	RecluPuestoAplica recluPuestoAplica = RecluPuestoAplica.findByOid(dsPuestosAplica.getInteger("oid_puesto_aplica"), this.getSesion());
        	recluPuestoAplica.setPostulante(reclupostulante);
        	recluPuestoAplica.setPuesto(RecluPuesto.findByOidProxy(dsPuestosAplica.getInteger("oid_puesto_busqueda"), this.getSesion()));
        	recluPuestoAplica.setActivo(dsPuestosAplica.getBoolean("activo"));
        	reclupostulante.addRecluPuestoAplica(recluPuestoAplica);
        	dsPuestosAplica.next();
        }        
        
        IDataSet dsProcesosCandidato = dataset.getDataSet("TProcesosCandidato");
        dsProcesosCandidato.first();
        while (!dsProcesosCandidato.EOF()) {
        	
        	
        	RecluProcesoCandidato recluProcesoCandidato = RecluProcesoCandidato.findByOid(dsProcesosCandidato.getInteger("oid_proceso_sel"), this.getSesion());
        	
        	
        	
        	if (dsProcesosCandidato.getInteger("orden")!=null)
        		recluProcesoCandidato.setOrden(dsProcesosCandidato.getInteger("orden"));
        	else
        		recluProcesoCandidato.setOrden(0);
        	recluProcesoCandidato.setProceso(RecluProceso.findByOidProxy(dsProcesosCandidato.getInteger("oid_proceso"), this.getSesion()));
        	recluProcesoCandidato.setConcepto_proceso(RecluConceptoProceso.findByOidProxy(dsProcesosCandidato.getInteger("oid_conc_proceso"), this.getSesion()));
        	recluProcesoCandidato.setEstado(RecluEstadoProceso.findByOidProxy(dsProcesosCandidato.getInteger("oid_est_proc_sel"), this.getSesion()));
        	recluProcesoCandidato.setFecha_planif(dsProcesosCandidato.getDate("fecha_planif"));
        	recluProcesoCandidato.setHora_planif(dsProcesosCandidato.getString("hora_planif"));
        	recluProcesoCandidato.setPersona(dsProcesosCandidato.getString("persona"));
        	recluProcesoCandidato.setObservaciones(dsProcesosCandidato.getString("observaciones"));
        	recluProcesoCandidato.setActivo(dsProcesosCandidato.getBoolean("activo"));
        	
        	reclupostulante.addProcesoCandidato(recluProcesoCandidato);
        	
        	dsProcesosCandidato.next();
        }        
        
        
        
        addTransaccion(reclupostulante);
        dataset.next();
    }
  }
  
}
