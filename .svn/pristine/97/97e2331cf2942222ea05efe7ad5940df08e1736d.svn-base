package com.srn.erp.reclutamiento.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluCompeBusqAct;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluProcDefEnBusq;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluBusqActivas extends Operation { 

  public TraerRecluBusqActivas() { 
  }

  String prefijo = "";
  
  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  	HashTableDatos parametros = new HashTableDatos();
	  	List listaCompetencias = new ArrayList();
	  	
	  	if (mapaDatos.containsKey("PREFIJO"))
	  		prefijo = mapaDatos.getString("PREFIJO"); 
	  	
	  	if (mapaDatos.containsKey("oid_busqueda_act")) {
	  		if (mapaDatos.getInteger("oid_busqueda_act")>0) {
	  			RecluBusqueda recluBusqueda = RecluBusqueda.findByOidProxy(mapaDatos.getInteger("oid_busqueda_act"), this.getSesion());
	  			parametros.put(RecluBusqueda.NICKNAME, recluBusqueda);
	  		}
	  	}
	  	
	  	IDataSet dsInput = null;
	  	IDataSet dsImputCompetencias = null;
	  	
	  	IDataSet dsCompetenciasPostulantes = null;
	  	IDataSet dsCandidatosEnEstado = null;
	  	IDataSet dsPostulacionesAplica = null;
	  	IDataSet dsProcesosEnEstado = null;
	  	
	  	
	  	if (mapaDatos.containsKey("TInput"))
	  		dsInput = mapaDatos.getDataSet("TInput");
	  	
		if (mapaDatos.containsKey("TInputCompetencias"))
			dsImputCompetencias = mapaDatos.getDataSet("TInputCompetencias");
		
		if (mapaDatos.containsKey("TCompetenciasPostulantes"))
			dsCompetenciasPostulantes = mapaDatos.getDataSet("TCompetenciasPostulantes");
		
		if (mapaDatos.containsKey("TCandidatosEnEstado"))
			dsCandidatosEnEstado = mapaDatos.getDataSet("TCandidatosEnEstado");		
		
		if (mapaDatos.containsKey("TPostulacionesAplica"))
			dsPostulacionesAplica = mapaDatos.getDataSet("TPostulacionesAplica");
		
		if (mapaDatos.containsKey("TProcesosEnEstado"))
			dsProcesosEnEstado = mapaDatos.getDataSet("TProcesosEnEstado");		
		
		if (dsImputCompetencias!=null) {
			dsImputCompetencias.first();
			while (!dsImputCompetencias.EOF()) {			
				if (dsImputCompetencias.getInteger("oid_competencia")!=null)
					listaCompetencias.add(RecluCompetencias.findByOidProxy(dsImputCompetencias.getInteger("oid_competencia"), this.getSesion()));
				dsImputCompetencias.next();
			}
			
			if (listaCompetencias.size()>0)
				parametros.put("LISTA_COMPETENCIAS", listaCompetencias);
		}
		
		
		// Filtrar por las competencias del postulante
		if (dsCompetenciasPostulantes!=null) {
			List listaCompePostu = new ArrayList();
			dsCompetenciasPostulantes.first();
			while (!dsCompetenciasPostulantes.EOF()) {
				listaCompePostu.add(RecluCompetencias.findByOidProxy(dsCompetenciasPostulantes.getInteger("oid"), this.getSesion()));
				dsCompetenciasPostulantes.next();
			}
			if (listaCompePostu.size()>0)
				parametros.put("LISTA_COMPE_POSTU", listaCompePostu);
		}
		
		
		// Filtrar por las postulaciones que aplica
		if (dsPostulacionesAplica!=null) {
			List listaPostulacionesAplica = new ArrayList();
			dsPostulacionesAplica.first();
			while (!dsPostulacionesAplica.EOF()) {
				listaPostulacionesAplica.add(RecluPuesto.findByOidProxy(dsPostulacionesAplica.getInteger("oid"), this.getSesion()));
				dsPostulacionesAplica.next();
			}
			if (listaPostulacionesAplica.size()>0)
				parametros.put("LISTA_POSTU_APLICA", listaPostulacionesAplica);
		}
		
		// Filtrar los Candidatos en Estado
		if (dsCandidatosEnEstado!=null) {
			List listaEstadosCandidato = new ArrayList();
			dsCandidatosEnEstado.first();
			while (!dsCandidatosEnEstado.EOF()) {
				listaEstadosCandidato.add(RecluEstCandidatoBusq.findByOidProxy(dsCandidatosEnEstado.getInteger("oid"), this.getSesion()));
				dsCandidatosEnEstado.next();
			}
			if (listaEstadosCandidato.size()>0)
				parametros.put("LISTA_ESTADO_CAND", listaEstadosCandidato);
		}		
		
		// Filtrar los estados de los procesos
		if (dsProcesosEnEstado!=null) {
			List listaEstadosProcesos = new ArrayList();
			dsProcesosEnEstado.first();
			while (!dsProcesosEnEstado.EOF()) {
				listaEstadosProcesos.add(RecluEstadoProceso.findByOidProxy(dsProcesosEnEstado.getInteger("oid"), this.getSesion()));
				dsProcesosEnEstado.next();
			}
			if (listaEstadosProcesos.size()>0)
				parametros.put("LISTA_ESTADO_PROCESO", listaEstadosProcesos);
		}		
		
		
		
		
		if (dsInput!=null) {
		
			dsInput.first();
			while (!dsInput.EOF()) {
				
				
				// 	Buscar
				String buscar = dsInput.getString("buscar");
				if ((buscar!=null) && (buscar.length()>0)) {
					parametros.put("BUSCAR", buscar.toUpperCase());
				}
			
				// Buscar
				String codigoSexo = dsInput.getString("codigo_sexo");
				if ((codigoSexo!=null) && (codigoSexo.length()>0)) {
					parametros.put("CODIGO_SEXO", codigoSexo);
				}			
			
				
				// Filtrar por Estado Postulante
				Integer oidEstadoPostulante = dsInput.getInteger("oid_estado_postulante");
				if ((oidEstadoPostulante!=null) && (oidEstadoPostulante.intValue()>0)) {
					RecluEstadoPostulante recluEstadoPostulante = RecluEstadoPostulante.findByOidProxy(oidEstadoPostulante, this.getSesion());
					parametros.put(RecluEstadoPostulante.NICKNAME, recluEstadoPostulante);
				}				
			
				String esReferido = dsInput.getString("es_referido");
				if ((esReferido!=null) && (esReferido.length()>0)) {
					parametros.put("ES_REFERIDO", esReferido);
				}
				
				String generoPostulante = dsInput.getString("genero_postulante");
				if ((generoPostulante!=null) && (generoPostulante.length()>0)) {
					parametros.put("GENERO_POSTULANTE", generoPostulante);
				}
				
				
				
				// Filtrar por operacion
				Integer oidOperacion = dsInput.getInteger("oid_operacion");
				if ((oidOperacion!=null) && (oidOperacion.intValue()>0)) {
					RecluOperacion recluOperacion = RecluOperacion.findByOidProxy(oidOperacion, this.getSesion());
					parametros.put(RecluOperacion.NICKNAME, recluOperacion);
				}
			
				// Filtrar por Sector
				Integer oidSector = dsInput.getInteger("oid_sector");
				if ((oidSector!=null) && (oidSector.intValue()>0)) {
					RecluSectores recluSectores = RecluSectores.findByOidProxy(oidSector, this.getSesion());
					parametros.put(RecluSectores.NICKNAME, recluSectores);
				}		
			
				// Filtrar por Selector
				Integer oidSelector = dsInput.getInteger("oid_selector");
				if ((oidSelector!=null) && (oidSelector.intValue()>0)) {
					RecluSelector recluSelector = RecluSelector.findByOidProxy(oidSelector, this.getSesion());
					parametros.put(RecluSelector.NICKNAME, recluSelector);
				}		
			
				// 	Filtrar por Puesto
				Integer oidPuesto = dsInput.getInteger("oid_puesto");
				if ((oidPuesto!=null) && (oidPuesto.intValue()>0)) {
					RecluPuesto recluPuesto = RecluPuesto.findByOidProxy(oidPuesto, this.getSesion());
					parametros.put(RecluPuesto.NICKNAME, recluPuesto);
				}		
			
				// Filtrar por Busqueda Activa
				Integer oidBusqueda = dsInput.getInteger("oid_busqueda_act");
				if ((oidBusqueda!=null) && (oidBusqueda.intValue()>0)) {
					RecluBusqueda recluBusqueda = RecluBusqueda.findByOidProxy(oidBusqueda, this.getSesion());
					parametros.put(RecluBusqueda.NICKNAME, recluBusqueda);
				}			
			
			
				if (dsInput.getBoolean("abiertas")) {
					parametros.put(RecluBusqueda.getEstadoBusqAbierta(), "");
				}
				
				if (dsInput.getBoolean("cerradas")) {
					parametros.put(RecluBusqueda.getEstadoBusqCerrada(), "");
				
					java.util.Date fecDesde = dsInput.getDate("fec_desde");
					java.util.Date fecHasta = dsInput.getDate("fec_hasta");
				
					if (fecDesde==null)
					throw new ExceptionValidation(null,"Debe ingresar la fecha Desde");
				
					if (fecHasta==null)
						throw new ExceptionValidation(null,"Debe ingresar la fecha Hasta");			
				
					parametros.put("FEC_DESDE", fecDesde);
					parametros.put("FEC_HASTA", fecHasta);
				
				}		
			
			dsInput.next();
			}
		}	  
	  
	IDataSet dsBusqueda 		 = this.getDataSetBusqueda();
	IDataSet dsProcesosDefinidos = this.getDataSetProcesoDefBusq();
	IDataSet dsCandidatos        = this.getDataSetCandidatos();
	IDataSet dsProcesosCandi     = this.getDataSetProcesoCandidato();
	IDataSet dsCompetencias      = this.getDataSetCompetenciaBusq();
	  
	Iterator iterRecluBusqueda = 
			RecluBusqueda.getCondicionesBusquedas(parametros, this.getSesion()).iterator();
	while (iterRecluBusqueda.hasNext()) {
		RecluBusqueda recluBusqueda = (RecluBusqueda) iterRecluBusqueda.next();
		cargarRegistroRecluBusqueda(dsBusqueda, recluBusqueda);
		
		Iterator iterDefinicionesProcesos = recluBusqueda.getDefinicionProcesos().iterator();
		while (iterDefinicionesProcesos.hasNext()) {
			RecluProcDefEnBusq recluProcDefEnBusq = (RecluProcDefEnBusq) iterDefinicionesProcesos.next();
			cargarRegistroRecluProceso(dsProcesosDefinidos, recluProcDefEnBusq);
		}
		
		Iterator iterCompetenciasBusq = recluBusqueda.getCompetencias().iterator();
		while (iterCompetenciasBusq.hasNext()) {
			RecluCompeBusqAct recluCompeBusqAct = (RecluCompeBusqAct) iterCompetenciasBusq.next();
			cargarRegistroCompetencia(dsCompetencias, recluCompeBusqAct);
		}		
		
		
		Iterator iterCandidatos = recluBusqueda.getCandidatos().iterator();
		while (iterCandidatos.hasNext()) {
			RecluCandidatoBusq recluCandidatoBusq = (RecluCandidatoBusq) iterCandidatos.next();
			cargarRegistroCandidato(dsCandidatos, recluCandidatoBusq);
			
			Iterator iterRecluProcesos = 
					recluCandidatoBusq.getProcesosCandidato().iterator();
			while (iterRecluProcesos.hasNext()) {
				RecluProcesoCandidato recluProcesoCandidato = (RecluProcesoCandidato) iterRecluProcesos.next();
				cargarRegistroProcesoCandidato(dsProcesosCandi, recluProcesoCandidato);
			}
			
		}
		
	}
	  
    writeCliente(dsBusqueda);
    writeCliente(dsProcesosDefinidos);
    writeCliente(dsCandidatos);
    writeCliente(dsProcesosCandi);
    writeCliente(dsCompetencias);
    
  }
  
  private void cargarRegistroRecluProceso(IDataSet dataset, 
		   								  RecluProcDefEnBusq aRecluProcDefEnBusq) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_proc_def_busq", aRecluProcDefEnBusq.getOIDInteger());
	  dataset.fieldValue("oid_busqueda_act", aRecluProcDefEnBusq.getBusqueda().getOIDInteger());
	  dataset.fieldValue("orden", aRecluProcDefEnBusq.getOrden());
	  if (aRecluProcDefEnBusq.getProceso()!=null)
		  dataset.fieldValue("oid_proceso",  aRecluProcDefEnBusq.getProceso().getOIDInteger());
	  else
		  dataset.fieldValue("oid_proceso",  "");
	  dataset.fieldValue("fecha_asigno", aRecluProcDefEnBusq.getFecha_asigno());
	  if (aRecluProcDefEnBusq.getConceptoProceso()!=null)
		  dataset.fieldValue("oid_conc_proceso",  aRecluProcDefEnBusq.getConceptoProceso().getOIDInteger());
	  else
		  dataset.fieldValue("oid_conc_proceso",  "");
	  dataset.fieldValue("activo",  aRecluProcDefEnBusq.isActivo());;
	  if (aRecluProcDefEnBusq.getProceso()!=null)
		  dataset.fieldValue("proceso",  aRecluProcDefEnBusq.getProceso().getDescripcion());
	  else
		  dataset.fieldValue("proceso",  "");
	  if (aRecluProcDefEnBusq.getConceptoProceso()!=null)
		  dataset.fieldValue("tipo_examen",  aRecluProcDefEnBusq.getConceptoProceso().getDescripcion());
	  else
		  dataset.fieldValue("tipo_examen",  "");
	  if (aRecluProcDefEnBusq.getTipoFormulario()!=null)
		  dataset.fieldValue("oid_tipo_formu",  aRecluProcDefEnBusq.getTipoFormulario().getOIDInteger());
	  else
		  dataset.fieldValue("oid_tipo_formu",  "");
	  
  }
  
  private IDataSet getDataSetProcesoDefBusq() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create(prefijo+"TProcDefBusq");
	    dataset.fieldDef(new Field("oid_proc_def_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("fecha_asigno", Field.DATE, 0));
	    dataset.fieldDef(new Field("oid_conc_proceso", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso", Field.STRING, 100)); 
	    dataset.fieldDef(new Field("tipo_examen", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_tipo_formu", Field.INTEGER, 0));
	    return dataset;
	  }  
  
  
  private void cargarRegistroCompetencia(IDataSet dataset, 
			  RecluCompeBusqAct aRecluCompeBusqAct) throws BaseException {  
	  dataset.append();
	  dataset.fieldValue("oid_comp_busq_act", aRecluCompeBusqAct.getOIDInteger());
	  dataset.fieldValue("oid_competencia", aRecluCompeBusqAct.getCompetencia().getOIDInteger());
	  dataset.fieldValue("oid_busqueda_act", aRecluCompeBusqAct.getBusqueda().getOIDInteger());
	  dataset.fieldValue("activo", aRecluCompeBusqAct.isActivo());
	  
  }
  
  private IDataSet getDataSetCompetenciaBusq() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create(prefijo+"TCompetenciasBusq");
	    dataset.fieldDef(new Field("oid_comp_busq_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    return dataset;
	  }  
  
  
  
  
  private IDataSet getDataSetProcesoCandidato() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create(prefijo+"TProcesosCandidato");
	    dataset.fieldDef(new Field("oid_proceso_sel", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_candidato_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_proceso", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("proceso", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_conc_proceso", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("concepto", Field.STRING, 100));
	    dataset.fieldDef(new Field("costo", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("oid_est_proc_sel", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("estado", Field.STRING, 100));
	    dataset.fieldDef(new Field("fecha_planif", Field.DATE, 0));
	    dataset.fieldDef(new Field("hora_planif", Field.STRING,5));
	    dataset.fieldDef(new Field("persona", Field.STRING,100));
	    dataset.fieldDef(new Field("observaciones", Field.STRING,4000));
	    dataset.fieldDef(new Field("puede_iniciar",  Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("oid_tipo_formu", Field.INTEGER,0));
	    dataset.fieldDef(new Field("completo_tipo_formu", Field.BOOLEAN,0));
	    dataset.fieldDef(new Field("fec_completo_tf", Field.DATE,0));	    
	    dataset.fieldDef(new Field("nombre_archivo", Field.STRING,255));
	    dataset.fieldDef(new Field("nro_archivo", Field.INTEGER,0));
	    return dataset;
  }  

  private IDataSet getDataSetBusqueda() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create(prefijo+"TBusquedas");
    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_puesto_busqueda", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_inicio_busq", Field.DATE, 0));
    dataset.fieldDef(new Field("cant_vacantes", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_motivo_busq", Field.INTEGER, 0));
    dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
    dataset.fieldDef(new Field("oid_operacion", Field.INTEGER, 0));
    dataset.fieldDef(new Field("sueldo_bruto", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("estado_busqueda", Field.STRING, 10));
    dataset.fieldDef(new Field("sexo", Field.STRING, 10));
    dataset.fieldDef(new Field("oid_tipo_contrato", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_selector", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_est_aprob_busq", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_sector", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_est_aprob", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_convenio", Field.INTEGER, 0));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("oid_mot_est_busq",Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_cierre",Field.DATE, 0));
    
    
    return dataset;
  }

  private void cargarRegistroProcesoCandidato(IDataSet dataset,
		   									  RecluProcesoCandidato recluProcesoCandidato) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_proceso_sel", recluProcesoCandidato.getOIDInteger());
	  dataset.fieldValue("oid_candidato_busq", recluProcesoCandidato.getCandidato_busq().getOIDInteger());
	  dataset.fieldValue("orden", recluProcesoCandidato.getOrden());
	  if (recluProcesoCandidato.getProceso()!=null) {
		  dataset.fieldValue("oid_proceso", recluProcesoCandidato.getProceso().getOIDInteger());
		  dataset.fieldValue("proceso", recluProcesoCandidato.getProceso().getDescripcion());
	  } else {
		  dataset.fieldValue("oid_proceso", "");
		  dataset.fieldValue("proceso", "");		  
	  }
	  if (recluProcesoCandidato.getConcepto_proceso()!=null) {
		  dataset.fieldValue("oid_conc_proceso", recluProcesoCandidato.getConcepto_proceso().getOIDInteger());
		  dataset.fieldValue("concepto", recluProcesoCandidato.getConcepto_proceso().getDescripcion());
	  } else {
		  dataset.fieldValue("oid_conc_proceso", "");
		  dataset.fieldValue("concepto", "");		  
	  }
	  dataset.fieldValue("costo", recluProcesoCandidato.getCosto());
	  if (recluProcesoCandidato.getEstado()!=null) {
		  dataset.fieldValue("oid_est_proc_sel", recluProcesoCandidato.getEstado().getOIDInteger());
		  dataset.fieldValue("estado", recluProcesoCandidato.getEstado().getDescripcion());
	  }
	  else {
		  dataset.fieldValue("oid_est_proc_sel", "");
		  dataset.fieldValue("estado", "");
	  }
	  dataset.fieldValue("fecha_planif", recluProcesoCandidato.getFecha_planif());
	  dataset.fieldValue("hora_planif", recluProcesoCandidato.getHora_planif());
	  dataset.fieldValue("persona", recluProcesoCandidato.getPersona());
	  dataset.fieldValue("observaciones", recluProcesoCandidato.getObservaciones());
	  dataset.fieldValue("puede_iniciar",  recluProcesoCandidato.isPuede_iniciar());
	  if (recluProcesoCandidato.getTipoFormulario()!=null)
		  dataset.fieldValue("oid_tipo_formu", recluProcesoCandidato.getTipoFormulario().getOID());
	  else
		  dataset.fieldValue("oid_tipo_formu", "");
	  dataset.fieldValue("completo_tipo_formu", recluProcesoCandidato.isCompletoTipoFormulario());
	  dataset.fieldValue("fec_completo_tf", recluProcesoCandidato.getCompletoTipoFormulario());
	  dataset.fieldValue("nombre_archivo", recluProcesoCandidato.getNombreArchivo());
	  dataset.fieldValue("nro_archivo", recluProcesoCandidato.getNroArchivo());
  }
	  
  
  private void cargarRegistroRecluBusqueda(IDataSet dataset, 
                         				   RecluBusqueda recluBusqueda) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_busqueda_act", recluBusqueda.getOIDInteger());
    if (recluBusqueda.getPuesto()!=null)
    	dataset.fieldValue("oid_puesto_busqueda", recluBusqueda.getPuesto().getOIDInteger());
    else
    	dataset.fieldValue("oid_puesto_busqueda", "");
    dataset.fieldValue("fec_inicio_busq", recluBusqueda.getFec_inicio_busq());
    dataset.fieldValue("cant_vacantes", recluBusqueda.getCant_vacantes());
    if (recluBusqueda.getMotivo_busq()!=null)
    	dataset.fieldValue("oid_motivo_busq", recluBusqueda.getMotivo_busq().getOIDInteger());
    else
    	dataset.fieldValue("oid_motivo_busq", "");
    dataset.fieldValue("observaciones", recluBusqueda.getObservaciones() );
    if (recluBusqueda.getOperacion()!=null)
    	dataset.fieldValue("oid_operacion", recluBusqueda.getOperacion().getOIDInteger());
    else
    	dataset.fieldValue("oid_operacion", "");
    dataset.fieldValue("sueldo_bruto", recluBusqueda.getSueldo_buto());
    dataset.fieldValue("estado_busqueda", recluBusqueda.getEstado_busqueda());
    dataset.fieldValue("sexo", recluBusqueda.getSexo());
    if (recluBusqueda.getTipo_contrato()!=null)
    	dataset.fieldValue("oid_tipo_contrato", recluBusqueda.getTipo_contrato().getOIDInteger());
    else
    	dataset.fieldValue("oid_tipo_contrato", "");
    if (recluBusqueda.getSelector()!=null)
    	dataset.fieldValue("oid_selector", recluBusqueda.getSelector().getOIDInteger());
    else
    	dataset.fieldValue("oid_selector", "");
    if (recluBusqueda.getEst_aprob_busq()!=null)
    	dataset.fieldValue("oid_est_aprob_busq", recluBusqueda.getEst_aprob_busq().getOIDInteger());
    else
    	dataset.fieldValue("oid_est_aprob_busq", "");
    if (recluBusqueda.getSector()!=null)
    	dataset.fieldValue("oid_sector", recluBusqueda.getSector().getOIDInteger());
    else
    	dataset.fieldValue("oid_sector", "");
    dataset.fieldValue("fec_est_aprob", recluBusqueda.getFec_est_aprob());
    if (recluBusqueda.getConvenio()!=null)
    	dataset.fieldValue("oid_convenio", recluBusqueda.getConvenio().getOIDInteger());
    else
    	dataset.fieldValue("oid_convenio", "");
    dataset.fieldValue("activo", recluBusqueda.isActivo());
    if (recluBusqueda.getMotivoEstado()!=null)
    	dataset.fieldValue("oid_mot_est_busq", recluBusqueda.getMotivoEstado().getOIDInteger());
    else
    	dataset.fieldValue("oid_mot_est_busq", "");
    dataset.fieldValue("fec_cierre", recluBusqueda.getFechaCierre());
  }
  
  
  private IDataSet getDataSetCandidatos() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create(prefijo+"TCandidatosBusq");
	    dataset.fieldDef(new Field("oid_candidato_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nro_cuit", Field.STRING, 30));
	    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
	    dataset.fieldDef(new Field("fec_asigno", Field.DATE, 0));
	    dataset.fieldDef(new Field("hora_asigno", Field.STRING, 5));
	    dataset.fieldDef(new Field("oid_usu_asigno", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("usuario_asigno", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_est_cand_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("estado_cand_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("comentario", Field.STRING, 4000));
	    dataset.fieldDef(new Field("oid_mot_est_cand", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("fec_ingreso", Field.DATE, 0));
	    return dataset;
  }
  
  private void cargarRegistroCandidato(
		   IDataSet dataset, 
		   RecluCandidatoBusq aRecluCandidatoBusq) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("oid_candidato_busq", aRecluCandidatoBusq.getOIDInteger());
	  dataset.fieldValue("oid_busqueda_act", aRecluCandidatoBusq.getBusqueda().getOIDInteger());
	  dataset.fieldValue("oid_postulante", aRecluCandidatoBusq.getOid_postulante().getOIDInteger());
	  dataset.fieldValue("nro_cuit", aRecluCandidatoBusq.getOid_postulante().getNro_docu());
	  dataset.fieldValue("ape_y_nom", aRecluCandidatoBusq.getOid_postulante().getApe_y_nom());
	  dataset.fieldValue("fec_asigno",  aRecluCandidatoBusq.getFec_asigno());
	  dataset.fieldValue("hora_asigno", aRecluCandidatoBusq.getHora_asigno());
	  dataset.fieldValue("oid_usu_asigno", aRecluCandidatoBusq.getUsuario_asigno().getOIDInteger());
	  dataset.fieldValue("usuario_asigno", aRecluCandidatoBusq.getUsuario_asigno().getApellidoyNombre());
	  dataset.fieldValue("oid_est_cand_busq", aRecluCandidatoBusq.getEstado_busqueda().getOIDInteger());
	  dataset.fieldValue("estado_cand_busq", aRecluCandidatoBusq.getEstado_busqueda().getDescripcion());
	  dataset.fieldValue("comentario", aRecluCandidatoBusq.getComentario());
	  if (aRecluCandidatoBusq.getMotivo()!=null)
		  dataset.fieldValue("oid_mot_est_cand", aRecluCandidatoBusq.getMotivo().getOIDInteger());
	  else
		  dataset.fieldValue("oid_mot_est_cand", "");
	  dataset.fieldValue("activo",aRecluCandidatoBusq.isActivo());
	  dataset.fieldValue("fec_ingreso",aRecluCandidatoBusq.getFechaIngreso());
  }
  
  
  
}



