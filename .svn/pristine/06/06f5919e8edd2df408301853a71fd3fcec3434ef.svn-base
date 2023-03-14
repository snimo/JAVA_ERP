package com.srn.erp.reclutamiento.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluCompePostu;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluCurriPostu;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluNovedadPostu;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.bm.RecluPuestoAplica;
import com.srn.erp.reclutamiento.bm.RecluResultBusqCandi;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.applicarionServer.bm.Parametros.ValorParametro;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluCandiEnProceso extends Operation { 

  public TraerRecluCandiEnProceso() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
		
		if (mapaDatos.containsKey("PREPARAR_CONSULTA"))
			prepararConsulta(mapaDatos);
		else if (mapaDatos.containsKey("EJECUTAR_CONSULTA"))
			ejecutarConsulta(mapaDatos);
			
		
		
  }
  
  private void ejecutarConsulta(MapDatos mapaDatos) throws BaseException {
	  
	  	IDataSet dsConsulta = this.getDataSetResulBusqueda();
	  	IDataSet dsVisuColProc = this.getDataSetVisuColProc();
	  	IDataSet dsPreparacion = this.getDataSetPreparacion();
	  	
	  	
	  	Integer nroLote = mapaDatos.getInteger("NRO_LOTE");
	  	Integer nroDesde = mapaDatos.getInteger("NRO_DESDE");
	  	Integer nroHasta = mapaDatos.getInteger("NRO_HASTA");
	  	Integer cantRegistros = mapaDatos.getInteger("CANT_REGISTROS");
	  	Integer proxCantRegistros = mapaDatos.getInteger("PROX_CANT_REGISTROS");
	  	
	  	HashTableDatos condiciones = new HashTableDatos();
	  	condiciones.put("NRO_LOTE", nroLote);
	  	condiciones.put("NRO_DESDE" , nroDesde);
	  	condiciones.put("NRO_HASTA", nroHasta);
	  	
	  	HashTableDatos numerarColumnas 	= new HashTableDatos();
	  	HashTableDatos visuColumnas 	= new HashTableDatos();
	  	HashTableDatos tituColumnas 	= new HashTableDatos();
	  	
	  	
	  	int nroColumna = 1;
	  	Iterator iterProcesosActivos = 
	  			RecluProceso.getProcesosActivos(this.getSesion()).iterator();
	  	while (iterProcesosActivos.hasNext()) {
	  		RecluProceso recluProceso = (RecluProceso) iterProcesosActivos.next();
	  		numerarColumnas.put(new Integer(nroColumna), recluProceso.getOIDInteger());
	  		tituColumnas.put(new Integer(nroColumna), recluProceso.getDescripcion());
	  		++nroColumna;
	  	}
	  	
	  	int contarReg = 0;
	  	Iterator iterCandiResultBusq = RecluCandidatoBusq.getCandidatosResultadoBusqueda(this.getSesion(), condiciones).iterator();
	  	while (iterCandiResultBusq.hasNext()) {
	  		RecluCandidatoBusq recluCandidatoBusq = (RecluCandidatoBusq) iterCandiResultBusq.next();
	  		cargarResulBusqueda(dsConsulta, recluCandidatoBusq , numerarColumnas);
	  		++contarReg;
	  	}
	  	
	  	cargarVisuColumnas(dsVisuColProc, visuColumnas , --nroColumna , tituColumnas);
	  	
		cargarDataSetPreparacion(dsPreparacion, nroLote, cantRegistros , nroDesde+contarReg-1, proxCantRegistros);
	  	
	  	writeCliente(dsConsulta);
	  	writeCliente(dsVisuColProc);
	  	writeCliente(dsPreparacion);
	  	
  }
  
  private void prepararConsulta(MapDatos mapaDatos) throws BaseException {
	  
	  	IDataSet dsInput = null;
	  	if (mapaDatos.containsKey("TInput"))
	  		dsInput = mapaDatos.getDataSet("TInput");
		IDataSet dsImputCompetencias = null;
		if (mapaDatos.containsKey("TInputCompetencias"))
			dsImputCompetencias = mapaDatos.getDataSet("TInputCompetencias");
	  
	  
		IDataSet dsCompetenciasPostulantes = null;
	  	IDataSet dsCandidatosEnEstado = null;
	  	IDataSet dsPostulacionesAplica = null;
	  	IDataSet dsProcesosEnEstado = null;
	  	
		if (mapaDatos.containsKey("TCompetenciasPostulantes"))
			dsCompetenciasPostulantes = mapaDatos.getDataSet("TCompetenciasPostulantes");
		
		if (mapaDatos.containsKey("TCandidatosEnEstado"))
			dsCandidatosEnEstado = mapaDatos.getDataSet("TCandidatosEnEstado");		
		
		if (mapaDatos.containsKey("TPostulacionesAplica"))
			dsPostulacionesAplica = mapaDatos.getDataSet("TPostulacionesAplica");
		
		if (mapaDatos.containsKey("TProcesosEnEstado"))
			dsProcesosEnEstado = mapaDatos.getDataSet("TProcesosEnEstado");		
		
	  	IDataSet dsPreparacion = getDataSetPreparacion();
	  
		int nroLote = this.getSesion().getNewOIDByKey("NRO_LOTE_CONS_CONDIDATOS");
		java.util.Date fecAlta = Util.getFechaActual(this.getSesion());
		int nroOrden = 1;
		
		HashTableDatos parametros = new HashTableDatos();
		
		List listaCompetencias = new ArrayList();
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
				
				Integer oidPostulante = dsInput.getInteger("oid_postulante");
				if ((oidPostulante!=null)) {
					RecluPostulante postulante = RecluPostulante.findByOidProxy(oidPostulante, this.getSesion()); 
					parametros.put(RecluPostulante.NICKNAME, postulante);
				}

				
				// Filtrar por Estado Postulante
				Integer oidEstadoPostulante = dsInput.getInteger("oid_estado_postulante");
				if ((oidEstadoPostulante!=null) && (oidEstadoPostulante.intValue()>0)) {
					RecluEstadoPostulante recluEstadoPostulante = RecluEstadoPostulante.findByOidProxy(oidEstadoPostulante, this.getSesion());
					parametros.put(RecluEstadoPostulante.NICKNAME, recluEstadoPostulante);
				}				
				
				String buscar = dsInput.getString("buscar");
				if ((buscar!=null) && (buscar.length()>0)) {
					parametros.put("BUSCAR", buscar.toUpperCase());
				}
			
				// Buscar
				String codigoSexo = dsInput.getString("codigo_sexo");
				if ((codigoSexo!=null) && (codigoSexo.length()>0)) {
					parametros.put("CODIGO_SEXO", codigoSexo);
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
		
		
		Iterator condidatosEnBusq = RecluCandidatoBusq.getCandidatosEnBusqueda(this.getSesion(), parametros).iterator();
		while (condidatosEnBusq.hasNext()) {
			RecluCandidatoBusq recluCandidatoBusq = (RecluCandidatoBusq) condidatosEnBusq.next();
			RecluResultBusqCandi recluResultBusqCandidatos = 
					(RecluResultBusqCandi) RecluResultBusqCandi.getNew(RecluResultBusqCandi.NICKNAME, this.getSesion());
			recluResultBusqCandidatos.setNro_lote(nroLote);
			recluResultBusqCandidatos.setOid_obj_neg(recluCandidatoBusq.getOIDInteger());
			recluResultBusqCandidatos.setFec_alta(fecAlta);
			recluResultBusqCandidatos.setNro_Orden(nroOrden);
			recluResultBusqCandidatos.setActivo(true);
			recluResultBusqCandidatos.save();
			
			++nroOrden;
			
		}
		
		cargarDataSetPreparacion(dsPreparacion, nroLote, --nroOrden, 0, ValorParametro.findByCodigoParametro("CANT_REG_DESC_CONS_BUSQ", this.getSesion()).getValorEntero());
		writeCliente(dsPreparacion);
		
  }
  
  
  private IDataSet getDataSetResulBusqueda() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TResulttadoBusq");
	    dataset.fieldDef(new Field("oid_candidato_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));	    
	    dataset.fieldDef(new Field("nro_docu", Field.STRING, 30));
	    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_est_cand_busq", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("estado_cand_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("comentario", Field.STRING, 4000));
	    dataset.fieldDef(new Field("oid_mot_est_cand", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso1", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso2", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso3", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso4", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso5", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso6", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso7", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso8", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso9", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso10", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso11", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso12", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso13", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso14", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso15", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso16", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso17", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso18", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso19", Field.STRING, 255));
	    dataset.fieldDef(new Field("proceso20", Field.STRING, 255));
	    dataset.fieldDef(new Field("empresa", Field.STRING, 100));
	    dataset.fieldDef(new Field("sector", Field.STRING, 100));
	    dataset.fieldDef(new Field("puesto", Field.STRING, 200));
	    dataset.fieldDef(new Field("color", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("tipo_documento", Field.STRING, 50));
	    dataset.fieldDef(new Field("referido", Field.STRING, 100));
	    dataset.fieldDef(new Field("estado_postulante", Field.STRING, 100));
	    dataset.fieldDef(new Field("fec_nacimiento", Field.STRING, 100));
	    dataset.fieldDef(new Field("direccion", Field.STRING, 100));
	    dataset.fieldDef(new Field("localidad", Field.STRING, 100));
	    dataset.fieldDef(new Field("codigo_postal", Field.STRING, 100));
	    dataset.fieldDef(new Field("telefono_fijo", Field.STRING, 100));
	    dataset.fieldDef(new Field("telefono_celular", Field.STRING, 100));
	    dataset.fieldDef(new Field("fuente", Field.STRING, 100));
	    dataset.fieldDef(new Field("competencias", Field.STRING, 5000));
	    dataset.fieldDef(new Field("anotaciones", Field.STRING, 5000));
	    dataset.fieldDef(new Field("postu_aplica", Field.STRING, 5000));
	    dataset.fieldDef(new Field("bajar_cv", Field.STRING, 20));
	    dataset.fieldDef(new Field("oid_cv", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nombre_archivo_cv", Field.STRING, 100));
	    dataset.fieldDef(new Field("empresa_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("sector_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("puesto_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("motivo_busqueda", Field.STRING, 100));
	    dataset.fieldDef(new Field("aprob_busqueda", Field.STRING, 100));
	    dataset.fieldDef(new Field("obs_busqueda", Field.MEMO, 0));
	    dataset.fieldDef(new Field("selector", Field.STRING, 100));
	    dataset.fieldDef(new Field("estado_busqueda", Field.STRING, 100));
	    dataset.fieldDef(new Field("motivo_est_busqueda", Field.STRING, 100));
	    dataset.fieldDef(new Field("fec_cierre", Field.STRING, 100));
	    dataset.fieldDef(new Field("inicio_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("convenio", Field.STRING, 100));
	    dataset.fieldDef(new Field("sueldo_bruto", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("vancantes", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("contrato", Field.STRING, 100));
	    dataset.fieldDef(new Field("fec_aprobo_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("empresa_sector_busq", Field.STRING, 100));
	    dataset.fieldDef(new Field("procesos", Field.MEMO, 0));
	    
	    return dataset;
  }
  
  private IDataSet getDataSetVisuColProc() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TVisuColProc");
	    dataset.fieldDef(new Field("proceso1", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso2", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso3", Field.BOOLEAN, 0));;
	    dataset.fieldDef(new Field("proceso4", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso5", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso6", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso7", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso8", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso9", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso10", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso11", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso12", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso13", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso14", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso15", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso16", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso17", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso18", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso19", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("proceso20", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("desc_proceso1", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso2", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso3", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso4", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso5", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso6", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso7", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso8", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso9", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso10", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso11", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso12", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso13", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso14", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso15", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso16", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso17", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso18", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso19", Field.STRING, 100));
	    dataset.fieldDef(new Field("desc_proceso20", Field.STRING, 100));
	    return dataset;
  }
  
  private void cargarVisuColumnas(IDataSet ds, HashTableDatos visuColumnas , int nroColumnas , HashTableDatos tituloColumnas) throws BaseException {
	  ds.append();
	  ds.fieldValue("proceso1", 1<=nroColumnas?true:false);
	  ds.fieldValue("proceso2", 2<=nroColumnas?true:false);
	  ds.fieldValue("proceso3", 3<=nroColumnas?true:false);
	  ds.fieldValue("proceso4", 4<=nroColumnas?true:false);
	  ds.fieldValue("proceso5", 5<=nroColumnas?true:false);
	  ds.fieldValue("proceso6", 6<=nroColumnas?true:false);
	  ds.fieldValue("proceso7", 7<=nroColumnas?true:false);
	  ds.fieldValue("proceso8", 8<=nroColumnas?true:false);
	  ds.fieldValue("proceso9", 9<=nroColumnas?true:false);
	  ds.fieldValue("proceso10", 10<=nroColumnas?true:false);
	  ds.fieldValue("proceso11", 11<=nroColumnas?true:false);
	  ds.fieldValue("proceso12", 12<=nroColumnas?true:false);
	  ds.fieldValue("proceso13", 13<=nroColumnas?true:false);
	  ds.fieldValue("proceso14", 14<=nroColumnas?true:false);
	  ds.fieldValue("proceso15", 15<=nroColumnas?true:false);
	  ds.fieldValue("proceso16", 16<=nroColumnas?true:false);
	  ds.fieldValue("proceso17", 17<=nroColumnas?true:false);
	  ds.fieldValue("proceso18", 18<=nroColumnas?true:false);
	  ds.fieldValue("proceso19", 19<=nroColumnas?true:false);
	  ds.fieldValue("proceso20", 20<=nroColumnas?true:false);
	  ds.fieldValue("desc_proceso1", tituloColumnas.get(1)!=null?(String)tituloColumnas.get(1):"");
	  ds.fieldValue("desc_proceso2", tituloColumnas.get(2)!=null?(String)tituloColumnas.get(2):"");
	  ds.fieldValue("desc_proceso3", tituloColumnas.get(3)!=null?(String)tituloColumnas.get(3):"");
	  ds.fieldValue("desc_proceso4", tituloColumnas.get(4)!=null?(String)tituloColumnas.get(4):"");
	  ds.fieldValue("desc_proceso5", tituloColumnas.get(5)!=null?(String)tituloColumnas.get(5):"");
	  ds.fieldValue("desc_proceso6", tituloColumnas.get(6)!=null?(String)tituloColumnas.get(6):"");
	  ds.fieldValue("desc_proceso7", tituloColumnas.get(7)!=null?(String)tituloColumnas.get(7):"");
	  ds.fieldValue("desc_proceso8", tituloColumnas.get(8)!=null?(String)tituloColumnas.get(8):"");
	  ds.fieldValue("desc_proceso9", tituloColumnas.get(9)!=null?(String)tituloColumnas.get(9):"");
	  ds.fieldValue("desc_proceso10", tituloColumnas.get(10)!=null?(String)tituloColumnas.get(10):"");
	  ds.fieldValue("desc_proceso11", tituloColumnas.get(11)!=null?(String)tituloColumnas.get(11):"");
	  ds.fieldValue("desc_proceso12", tituloColumnas.get(12)!=null?(String)tituloColumnas.get(12):"");
	  ds.fieldValue("desc_proceso13", tituloColumnas.get(13)!=null?(String)tituloColumnas.get(13):"");
	  ds.fieldValue("desc_proceso14", tituloColumnas.get(14)!=null?(String)tituloColumnas.get(14):"");
	  ds.fieldValue("desc_proceso15", tituloColumnas.get(15)!=null?(String)tituloColumnas.get(15):"");
	  ds.fieldValue("desc_proceso16", tituloColumnas.get(16)!=null?(String)tituloColumnas.get(16):"");
	  ds.fieldValue("desc_proceso17", tituloColumnas.get(17)!=null?(String)tituloColumnas.get(17):"");
	  ds.fieldValue("desc_proceso18", tituloColumnas.get(18)!=null?(String)tituloColumnas.get(18):"");
	  ds.fieldValue("desc_proceso19", tituloColumnas.get(19)!=null?(String)tituloColumnas.get(19):"");
	  ds.fieldValue("desc_proceso20", tituloColumnas.get(20)!=null?(String)tituloColumnas.get(20):"");
  }
  
  
  
  
  private IDataSet getDataSetPreparacion() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TPreparacion");
	    dataset.fieldDef(new Field("nro_lote", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cant_registros", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("utl_nro_registro", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("prox_cant_registros", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cant_recuperados", Field.INTEGER, 0));
	    return dataset;
  }  
  
  private void cargarDataSetPreparacion(IDataSet ds,
		  								Integer nroLote,
		  								Integer cantRegistros,
		  								Integer ultNroReg,
		  								Integer proxCantReg) throws BaseException {
	  ds.append();
	  ds.fieldValue("nro_lote", nroLote);
	  ds.fieldValue("cant_registros", cantRegistros);
	  ds.fieldValue("utl_nro_registro", ultNroReg);
	  ds.fieldValue("prox_cant_registros", proxCantReg);
	  ds.fieldValue("cant_recuperados", ultNroReg);
  }
		  								
  
  private void cargarResulBusqueda(IDataSet dsResultado, RecluCandidatoBusq candidatoBusq , HashTableDatos nroColumnas) throws BaseException {
	  	dsResultado.append();
	  	dsResultado.fieldValue("oid_candidato_busq", candidatoBusq.getOIDInteger());
	  	dsResultado.fieldValue("oid_busqueda_act", candidatoBusq.getBusqueda().getOIDInteger());
	  	dsResultado.fieldValue("oid_postulante", candidatoBusq.getOid_postulante().getOIDInteger());	    
	  	dsResultado.fieldValue("nro_docu", candidatoBusq.getOid_postulante().getNro_docu());
	  	dsResultado.fieldValue("ape_y_nom", candidatoBusq.getOid_postulante().getApe_y_nom());
	  	dsResultado.fieldValue("oid_est_cand_busq", candidatoBusq.getEstado_busqueda().getOIDInteger());
	  	String estCandBusq = "";
	  	if (candidatoBusq.getEstado_busqueda()!=null)
	  		estCandBusq = candidatoBusq.getEstado_busqueda().getDescripcion();
	  	if (candidatoBusq.getMotivo()!=null)
	  		estCandBusq = estCandBusq + " ("+candidatoBusq.getMotivo().getDescripcion()+")";
	  	
	  	dsResultado.fieldValue("estado_cand_busq", estCandBusq);
	  	dsResultado.fieldValue("comentario", candidatoBusq.getComentario());
	  	if (candidatoBusq.getMotivo()!=null)
	  		dsResultado.fieldValue("oid_mot_est_cand", candidatoBusq.getMotivo().getOIDInteger());
	  	else
	  		dsResultado.fieldValue("oid_mot_est_cand", "");
	  	dsResultado.fieldValue("activo", candidatoBusq.isActivo());	
	  	
	  	dsResultado.fieldValue("proceso1", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 1));
	  	dsResultado.fieldValue("proceso2", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 2));
	  	dsResultado.fieldValue("proceso3", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 3));
	  	dsResultado.fieldValue("proceso4", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 4));
	  	dsResultado.fieldValue("proceso5", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 5));
	  	dsResultado.fieldValue("proceso6", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 6));
	  	dsResultado.fieldValue("proceso7", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 7));
	  	dsResultado.fieldValue("proceso8", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 8));
	  	dsResultado.fieldValue("proceso9", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 9));
	  	dsResultado.fieldValue("proceso10", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 10));
	  	dsResultado.fieldValue("proceso11", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 11));
	  	dsResultado.fieldValue("proceso12", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 12));
	  	dsResultado.fieldValue("proceso13", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 13));
	  	dsResultado.fieldValue("proceso14", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 14));
	  	dsResultado.fieldValue("proceso15", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 15));
	  	dsResultado.fieldValue("proceso16", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 16));
	  	dsResultado.fieldValue("proceso17", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 17));
	  	dsResultado.fieldValue("proceso18", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 18));
	  	dsResultado.fieldValue("proceso19", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 19));
	  	dsResultado.fieldValue("proceso20", candidatoBusq.getDescEstProcByNroCol(nroColumnas, 20));	  	
	  	
	  	
	  	
	  	dsResultado.fieldValue("empresa", candidatoBusq.getBusqueda().getOperacion().getDescripcion());
	  	dsResultado.fieldValue("sector", candidatoBusq.getBusqueda().getSector().getDescripcion());
	  	
	  	dsResultado.fieldValue("puesto", candidatoBusq.getBusqueda().getPuesto().getDescripcion());
	  	dsResultado.fieldValue("color",  candidatoBusq.getEstado_busqueda().getColor());
	  	if (candidatoBusq.getOid_postulante().getTipo_documento()!=null)
	  		dsResultado.fieldValue("tipo_documento", candidatoBusq.getOid_postulante().getTipo_documento().getDescripcion());
	  	else
	  		dsResultado.fieldValue("tipo_documento", "");
	  	String referido = "";
	  	if (candidatoBusq.getOid_postulante().isReferido()) {
	  		referido = referido + "Ref. ";
	  		if (candidatoBusq.getOid_postulante().getReferido_por	()!=null)
	  			referido = referido + "por "+candidatoBusq.getOid_postulante().getReferido_por();
	  		
	  		if (candidatoBusq.getOid_postulante().getNroReferido()!=null)
	  			referido = referido + " ("+candidatoBusq.getOid_postulante().getNroReferido().toString()+") ";

	  	}
	  	dsResultado.fieldValue("referido", referido);
	  	if (candidatoBusq.getOid_postulante().getEstadoPostulante()!=null)
	  		dsResultado.fieldValue("estado_postulante", candidatoBusq.getOid_postulante().getEstadoPostulante().getDescripcion());
	  	else
	  		dsResultado.fieldValue("estado_postulante", "");
	  	if (candidatoBusq.getOid_postulante().getFec_nacimiento()!=null)
	  		dsResultado.fieldValue("fec_nacimiento" , "Fec.Nac. "+ Fecha.getddmmyyyy(candidatoBusq.getOid_postulante().getFec_nacimiento()));
	  	else
	  		dsResultado.fieldValue("fec_nacimiento" , "");
	  	
	  	dsResultado.fieldValue("direccion", candidatoBusq.getOid_postulante().getDireccion());
	  	dsResultado.fieldValue("localidad", candidatoBusq.getOid_postulante().getLocalidad());
	  	if (candidatoBusq.getOid_postulante().getCod_postal()!=null)
	  		dsResultado.fieldValue("codigo_postal", " CP ("+candidatoBusq.getOid_postulante().getCod_postal()+")");
	  	else
	  		dsResultado.fieldValue("codigo_postal", "");
	  		
	  	if (candidatoBusq.getOid_postulante().getTelefono_fijo()!=null)
	  		dsResultado.fieldValue("telefono_fijo", "Tel. "+ candidatoBusq.getOid_postulante().getTelefono_fijo());
	  	else
	  		dsResultado.fieldValue("telefono_fijo", "");
	  	if (candidatoBusq.getOid_postulante().getTelefono_celular()!=null)
	  		dsResultado.fieldValue("telefono_celular", "Cel. "+candidatoBusq.getOid_postulante().getTelefono_celular());
	  	else
	  		dsResultado.fieldValue("telefono_celular", "");
	  	if (candidatoBusq.getOid_postulante().getFuente()!=null)
	  		dsResultado.fieldValue("fuente", "Fuente "+candidatoBusq.getOid_postulante().getFuente().getDescripcion());
	  	else
	  		dsResultado.fieldValue("fuente", "");
	  	
	  	String competencias = "";
	  	Iterator iterCompetencias = candidatoBusq.getOid_postulante().getCompetenciasPostu().iterator();
	  	while (iterCompetencias.hasNext()) {
	  		RecluCompePostu recluCompePostu = (RecluCompePostu) iterCompetencias.next();
	  		competencias = competencias + recluCompePostu.getCompetencia().getDescripcion()+Util.ENTER(); 
	  	}
	  	
	  	String postuAplica = "";
	  	Iterator iterPuestosAplica =
	  			candidatoBusq.getOid_postulante().getPuestosAplica().iterator();
	  	while (iterPuestosAplica.hasNext()) {
	  		RecluPuestoAplica recluPuestoAplica = (RecluPuestoAplica) iterPuestosAplica.next();
	  		if (postuAplica.length()>0)
	  			postuAplica = postuAplica + Util.ENTER();
	  		postuAplica = postuAplica + recluPuestoAplica.getPuesto().getDescripcion(); 
	  	}
	  	
	  	
	  	String novedades = "";
	  	Iterator iterNovedades = candidatoBusq.getOid_postulante().getNovedades().iterator();
	  	while (iterNovedades.hasNext()) {
	  		RecluNovedadPostu recluNovedadPostu = (RecluNovedadPostu) iterNovedades.next();
	  		novedades = novedades + Fecha.getddmmyyyy(recluNovedadPostu.getFecha())+" "+ recluNovedadPostu.getNovedad();
	  		if (recluNovedadPostu.isExc_fut_postu())
	  			novedades = novedades + " (Excluir de postulaciones";
	  		if (recluNovedadPostu.getFecVigencia()!=null)
	  			novedades = novedades + " hasta el "+Fecha.getddmmyyyy(recluNovedadPostu.getFecVigencia())+")";
	  		else
	  			novedades = novedades + ") ";
	  		novedades = novedades + Util.ENTER();
	  	}
	  	
	  	dsResultado.fieldValue("competencias", competencias);
	  	dsResultado.fieldValue("anotaciones", novedades);
	  	dsResultado.fieldValue("postu_aplica", postuAplica);
	  	
	  	
	  	
	  	if (candidatoBusq.getOid_postulante().getCurriculums().size()>0) {
	  		dsResultado.fieldValue("bajar_cv" , "Tiene CV");
	  		dsResultado.fieldValue("oid_cv" , ((RecluCurriPostu)(candidatoBusq.getOid_postulante().getCurriculums().get(0))).getNroArchivoCV());
	  		dsResultado.fieldValue("nombre_archivo_cv", ((RecluCurriPostu)(candidatoBusq.getOid_postulante().getCurriculums().get(0))).getNombreArchivo());
	  	}
	  	else {
	  		dsResultado.fieldValue("bajar_cv" , "");
	  		dsResultado.fieldValue("oid_cv" , "");
	  		dsResultado.fieldValue("nombre_archivo_cv", "");
	  	}
	  	
	  	dsResultado.fieldValue("empresa_busq", candidatoBusq.getBusqueda().getOperacion().getDescripcion());
	  	dsResultado.fieldValue("sector_busq", candidatoBusq.getBusqueda().getSector().getDescripcion());
	  	dsResultado.fieldValue("puesto_busq", candidatoBusq.getBusqueda().getPuesto().getDescripcion()+" ("+candidatoBusq.getBusqueda().getEstado_busqueda()+")");
	  	if (candidatoBusq.getBusqueda().getMotivo_busq()!=null)
	  		dsResultado.fieldValue("motivo_busqueda", candidatoBusq.getBusqueda().getMotivo_busq().getDescripcion());
	  	else
	  		dsResultado.fieldValue("motivo_busqueda", "");
	  	if (candidatoBusq.getBusqueda().getEst_aprob_busq()!=null)
	  		dsResultado.fieldValue("aprob_busqueda", candidatoBusq.getBusqueda().getEst_aprob_busq().getDescripcion());
	  	else
	  		dsResultado.fieldValue("aprob_busqueda", "");
	  	dsResultado.fieldValue("obs_busqueda", "");
	  	dsResultado.fieldValue("selector", candidatoBusq.getBusqueda().getSelector().getDescripcion());
	  	dsResultado.fieldValue("estado_busqueda", candidatoBusq.getBusqueda().getEstado_busqueda());
	  	if (candidatoBusq.getBusqueda().getMotivo_busq()!=null)
	  		dsResultado.fieldValue("motivo_est_busqueda", candidatoBusq.getBusqueda().getMotivo_busq().getDescripcion());
	  	else
	  		dsResultado.fieldValue("motivo_est_busqueda", "");
	  	dsResultado.fieldValue("fec_cierre", candidatoBusq.getBusqueda().getFechaCierre());
	  	dsResultado.fieldValue("inicio_busq", candidatoBusq.getBusqueda().getFec_inicio_busq());
	  	if (candidatoBusq.getBusqueda().getConvenio()!=null)
	  		dsResultado.fieldValue("convenio", candidatoBusq.getBusqueda().getConvenio().getDescripcion());
	  	else
	  		dsResultado.fieldValue("convenio",""); 
	  	dsResultado.fieldValue("sueldo_bruto", candidatoBusq.getBusqueda().getSueldo_buto());
	  	dsResultado.fieldValue("vancantes", candidatoBusq.getBusqueda().getCant_vacantes());
	  	if (candidatoBusq.getBusqueda().getTipo_contrato()!=null)
	  		dsResultado.fieldValue("contrato", candidatoBusq.getBusqueda().getTipo_contrato().getDescripcion());
	  	else
	  		dsResultado.fieldValue("contrato", "");
	  	dsResultado.fieldValue("fec_aprobo_busq", candidatoBusq.getBusqueda().getFec_est_aprob());
	  	dsResultado.fieldValue("empresa_sector_busq", 
	  			candidatoBusq.getBusqueda().getOperacion().getDescripcion()+" - "+
	  			candidatoBusq.getBusqueda().getSector().getDescripcion());
	  	
	  	String procesos = "";
	  	Iterator iterProcCandi = candidatoBusq.getProcesosCandidato().iterator();
	  	while (iterProcCandi.hasNext()) {
	  		RecluProcesoCandidato recluProcesoCandidato = (RecluProcesoCandidato) iterProcCandi.next();
	  		if (procesos.length()>0)
	  			procesos = procesos + Util.ENTER();
	  			
	  		procesos = procesos + "(*) " +recluProcesoCandidato.getProceso().getDescripcion()+
	  				            "-"+
	  				            recluProcesoCandidato.getConcepto_proceso().getDescripcion()+" "+
	  				            "("+recluProcesoCandidato.getEstado().getDescripcion()+")";
	  				            
	  	}
	  	
	  	dsResultado.fieldValue("procesos" , procesos);
	  
  }


}
