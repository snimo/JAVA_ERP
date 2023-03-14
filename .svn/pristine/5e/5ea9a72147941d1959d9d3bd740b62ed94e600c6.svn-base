package com.srn.erp.reclutamiento.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCompePostu;
import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluCurriPostu;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluNovedadPostu;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
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

public class TraerRecluBasePostulantes extends Operation { 

  public TraerRecluBasePostulantes() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
		
		if (mapaDatos.containsKey("PREPARAR_CONSULTA"))
			prepararConsulta(mapaDatos);
		else if (mapaDatos.containsKey("EJECUTAR_CONSULTA"))
			ejecutarConsulta(mapaDatos);
			
		
  }
  
  private void ejecutarConsulta(MapDatos mapaDatos) throws BaseException {
	  
	  	IDataSet dsPreparacion = this.getDataSetPreparacion();
	  	IDataSet dsConsulta = this.getDataSetResulBusqueda();
	  	
	  	
	  	Integer nroLote = mapaDatos.getInteger("NRO_LOTE");
	  	Integer nroDesde = mapaDatos.getInteger("NRO_DESDE");
	  	Integer nroHasta = mapaDatos.getInteger("NRO_HASTA");
	  	Integer cantRegistros = mapaDatos.getInteger("CANT_REGISTROS");
	  	Integer proxCantRegistros = mapaDatos.getInteger("PROX_CANT_REGISTROS");
	  	
	  	Iterator iterPostulantes = 
	  			RecluPostulante.getPostulantesByNroLote(nroLote,nroDesde,nroHasta,this.getSesion()).iterator();
	  	while (iterPostulantes.hasNext()) {
	  		RecluPostulante recluPostulante = (RecluPostulante) iterPostulantes.next();
	  		cargarResulBusqueda(dsConsulta,recluPostulante);
	  	}
	  	
	  	cargarDataSetPreparacion(dsPreparacion, nroLote, cantRegistros , nroDesde+RecluPostulante.getPostulantesActivos(this.getSesion()).size()-1, proxCantRegistros);
	  	
	  	writeCliente(dsPreparacion);
	  	writeCliente(dsConsulta);
	  	
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
				
				
				// Filtrar por Estado Postulante
				Integer oidEstadoPostulante = dsInput.getInteger("oid_estado_postulante");
				if ((oidEstadoPostulante!=null) && (oidEstadoPostulante.intValue()>0)) {
					RecluEstadoPostulante recluEstadoPostulante = RecluEstadoPostulante.findByOidProxy(oidEstadoPostulante, this.getSesion());
					parametros.put(RecluEstadoPostulante.NICKNAME, recluEstadoPostulante);
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
		
		Iterator iterPostulantes = RecluPostulante.getPostulantesByCondiciones(parametros,this.getSesion()).iterator();
		while (iterPostulantes.hasNext()) {
			RecluPostulante postulante = (RecluPostulante) iterPostulantes.next();
			RecluResultBusqCandi recluResultBusqCandidatos = 
					(RecluResultBusqCandi) RecluResultBusqCandi.getNew(RecluResultBusqCandi.NICKNAME, this.getSesion());
			recluResultBusqCandidatos.setNro_lote(nroLote);
			recluResultBusqCandidatos.setOid_obj_neg(postulante.getOIDInteger());
			recluResultBusqCandidatos.setFec_alta(fecAlta);
			recluResultBusqCandidatos.setNro_Orden(nroOrden);
			recluResultBusqCandidatos.setActivo(true);
			recluResultBusqCandidatos.save();
			
			++nroOrden;
			
		}
		
		cargarDataSetPreparacion(dsPreparacion, nroLote, --nroOrden, 0, ValorParametro.findByCodigoParametro("CANT_REG_DESC_CONS_POSTU", this.getSesion()).getValorEntero());
		writeCliente(dsPreparacion);
		
  }
  
  
  private IDataSet getDataSetResulBusqueda() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TResulttadoBusq");
	    dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));	    
	    dataset.fieldDef(new Field("nro_docu", Field.STRING, 30));
	    dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("tipo_docu", Field.STRING, 100));
	    dataset.fieldDef(new Field("estado", Field.STRING, 100));
	    dataset.fieldDef(new Field("fec_nacimiento", Field.DATE, 0));
	    dataset.fieldDef(new Field("direccion", Field.STRING, 100));
	    dataset.fieldDef(new Field("localidad", Field.STRING, 100));
	    dataset.fieldDef(new Field("cp", Field.STRING, 100));
	    dataset.fieldDef(new Field("telefono_fijo", Field.STRING, 100));
	    dataset.fieldDef(new Field("telefono_celular", Field.STRING, 100));
	    dataset.fieldDef(new Field("es_referido", Field.STRING, 2));
	    dataset.fieldDef(new Field("nro_referido", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("referido_por", Field.STRING, 100));
	    dataset.fieldDef(new Field("fuente", Field.STRING, 100));
	    dataset.fieldDef(new Field("competencias", Field.STRING, 100));
	    dataset.fieldDef(new Field("bajar_cv" , Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_cv" ,  Field.INTEGER, 0));
	    dataset.fieldDef(new Field("nombre_archivo_cv", Field.STRING, 100));
	    dataset.fieldDef(new Field("novedades", Field.MEMO, 0));
	    dataset.fieldDef(new Field("puestos_aplica", Field.MEMO, 0));
	    
	    
	    return dataset;
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
		  								
  
  private void cargarResulBusqueda(IDataSet dsResultado, RecluPostulante postulante ) throws BaseException {
	  
	  	dsResultado.append();
	  	dsResultado.fieldValue("oid_postulante", postulante.getOIDInteger());	    
	  	dsResultado.fieldValue("nro_docu", postulante.getNro_docu());
	  	dsResultado.fieldValue("ape_y_nom", postulante.getApe_y_nom());
	  	dsResultado.fieldValue("activo", postulante.isActivo());
	  	dsResultado.fieldValue("tipo_docu", postulante.getTipo_documento()!=null ? postulante.getTipo_documento().getDescripcion():"");
	  	dsResultado.fieldValue("estado", postulante.getEstadoPostulante()!=null ? postulante.getEstadoPostulante().getDescripcion() : "");
	  	dsResultado.fieldValue("fec_nacimiento", postulante.getFec_nacimiento());
	  	dsResultado.fieldValue("direccion", postulante.getDireccion());
	  	dsResultado.fieldValue("localidad", postulante.getLocalidad());
	  	dsResultado.fieldValue("cp", postulante.getCod_postal());
	  	if (postulante.getTelefono_fijo()!=null)
	  		dsResultado.fieldValue("telefono_fijo", "Fijo "+postulante.getTelefono_fijo());
	  	else
	  		dsResultado.fieldValue("telefono_fijo", "");
	  	if (postulante.getTelefono_celular()!=null)
	  		dsResultado.fieldValue("telefono_celular", "Cel. "+postulante.getTelefono_celular());
	  	else
	  		dsResultado.fieldValue("telefono_celular", "");
	  	dsResultado.fieldValue("es_referido", (postulante.isReferido()!=null) && (postulante.isReferido().booleanValue())?"SI":"NO");
	  	dsResultado.fieldValue("nro_referido", postulante.getNroReferido());
	  	dsResultado.fieldValue("referido_por", postulante.getReferido_por());	  	
	  	dsResultado.fieldValue("fuente", postulante.getFuente()!=null?postulante.getFuente().getDescripcion():"");
	  	
	  	String competencias = "";
	  	Iterator iterCompetencias = postulante.getCompetenciasPostu().iterator();
	  	while (iterCompetencias.hasNext()) {
	  		RecluCompePostu recluCompePostu = (RecluCompePostu) iterCompetencias.next();
	  		competencias = competencias + recluCompePostu.getCompetencia().getDescripcion()+Util.ENTER(); 
	  	}	  	
	  	
	  	dsResultado.fieldValue("competencias", competencias);
	  	
	  	if (postulante.getCurriculums().size()>0) {
	  		dsResultado.fieldValue("bajar_cv" , "Tiene CV");
	  		dsResultado.fieldValue("oid_cv" , ((RecluCurriPostu)(postulante.getCurriculums().get(0))).getNroArchivoCV());
	  		dsResultado.fieldValue("nombre_archivo_cv", ((RecluCurriPostu)(postulante.getCurriculums().get(0))).getNombreArchivo());
	  	}
	  	else {
	  		dsResultado.fieldValue("bajar_cv" , "");
	  		dsResultado.fieldValue("oid_cv" , "");
	  		dsResultado.fieldValue("nombre_archivo_cv", "");
	  	}	    
	  	
	  	String novedades = "";
	  	Iterator iterNovedades = postulante.getNovedades().iterator();
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
	  	
	  	dsResultado.fieldValue("novedades", novedades);
	  	
	  	
		String postuAplica = "";
	  	Iterator iterPuestosAplica =
	  			postulante.getPuestosAplica().iterator();
	  	while (iterPuestosAplica.hasNext()) {
	  		RecluPuestoAplica recluPuestoAplica = (RecluPuestoAplica) iterPuestosAplica.next();
	  		if (postuAplica.length()>0)
	  			postuAplica = postuAplica + Util.ENTER();
	  		postuAplica = postuAplica + recluPuestoAplica.getPuesto().getDescripcion(); 
	  	}
	  	
	  	dsResultado.fieldValue("puestos_aplica", postuAplica);
	  	
	  		  	
 	  
  }


}
