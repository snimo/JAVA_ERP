package com.srn.erp.reclutamiento.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
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

public class TraerRecluConsDetProcesos extends Operation {

	public TraerRecluConsDetProcesos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsInput = mapaDatos.getDataSet("TInput");
		IDataSet dsProcEnEstado = mapaDatos.getDataSet("TProcesosEnEstado");
		IDataSet dsProcesos = mapaDatos.getDataSet("TProcesos");

		List listaEstadosProcesos = new ArrayList();
		List listaProcesos = new ArrayList();
		HashTableDatos condiciones = new HashTableDatos();

		dsInput.first();
		while (!dsInput.EOF()) {

			java.util.Date fecDesde = dsInput.getDate("fec_desde");
			java.util.Date fecHasta = dsInput.getDate("fec_hasta");
			
			if ((dsInput.getBoolean("abiertas")!=null) && (dsInput.getBoolean("abiertas").booleanValue()))
				condiciones.put("ABIERTAS","");
			
			if ((dsInput.getBoolean("cerradas")!=null) && (dsInput.getBoolean("cerradas").booleanValue()))  
				condiciones.put("CERRADAS","");			
			
			if ((dsInput.getBoolean("incluir_busq_sin_planif")!=null) && (dsInput.getBoolean("incluir_busq_sin_planif").booleanValue()))  
				condiciones.put("INCLUIR_PROC_SIN_FEC_PLANIF","");			
			

			
			
			if (fecDesde==null)
				throw new ExceptionValidation(null,"Debe ingresar la fecha Desde");
			
			if (fecHasta==null)
				throw new ExceptionValidation(null,"Debe ingresar la fecha Hasta");			
			
			condiciones.put("FEC_DESDE", fecDesde);
			condiciones.put("FEC_HASTA", fecHasta);

			Integer oidOperacion = dsInput.getInteger("oid_operacion");
			Integer oidSector = dsInput.getInteger("oid_sector");
			Integer oidSelector = dsInput.getInteger("oid_selector");

			RecluOperacion operacion = null;
			if (oidOperacion != null) {
				operacion = RecluOperacion.findByOid(oidOperacion, this.getSesion());
				
				boolean estaLaOperacionHab = false;
				Iterator iterOperacion = RecluOperacion.getOperacionesParaVisualizarDelUsuario(this.getSesion()).iterator();
				while (iterOperacion.hasNext()) {
			    	RecluOperacion operHabilitada = (RecluOperacion) iterOperacion.next();
			    	if (operHabilitada.getOID() == operacion.getOID())
			    		estaLaOperacionHab = true;
			    }				
				if (estaLaOperacionHab==false)
					throw new ExceptionValidation(null,"No se encuentra habilitado para seleccionar la empresa "+operacion.getDescripcion());
				
				condiciones.put(RecluOperacion.NICKNAME, operacion);
			}

			RecluSectores sector = null;
			if (oidSector != null) {
				sector = RecluSectores.findByOid(oidSector, this.getSesion());
				condiciones.put(RecluSectores.NICKNAME, sector);
			}

			RecluSelector selector = null;
			if (oidSelector != null) {
				selector = RecluSelector.findByOid(oidSelector, this.getSesion());
				condiciones.put(RecluSelector.NICKNAME, selector);
			}

			dsInput.next();

		}

		dsProcEnEstado.first();
		while (!dsProcEnEstado.EOF()) {

			RecluEstadoProceso recluEstadoProceso = RecluEstadoProceso.findByOidProxy(dsProcEnEstado.getInteger("oid"), this.getSesion());

			listaEstadosProcesos.add(recluEstadoProceso);

			dsProcEnEstado.next();

		}

		if (listaEstadosProcesos.size() > 0)
			condiciones.put("LISTA_ESTADOS_PROCESOS", listaEstadosProcesos);

		dsProcesos.first();
		while (!dsProcesos.EOF()) {

			RecluProceso recluProceso = RecluProceso.findByOidProxy(dsProcesos.getInteger("oid"), this.getSesion());
			listaProcesos.add(recluProceso);

			dsProcesos.next();
		}

		if (listaProcesos.size() > 0)
			condiciones.put("LISTA_PROCESOS", listaProcesos);

		IDataSet dsProcesoCandidato = getDataSetProcesoCandidato();

		Iterator iterRecluProcCandidato = RecluProcesoCandidato.getRecluProcesoCandidatoByCondiciones(condiciones, this.getSesion()).iterator();
		while (iterRecluProcCandidato.hasNext()) {
			RecluProcesoCandidato recluProcesoCandidato = (RecluProcesoCandidato) iterRecluProcCandidato.next();
			cargarRegistroProcesoCandidato(dsProcesoCandidato,recluProcesoCandidato);
		}

		writeCliente(dsProcesoCandidato);

	}

	private void cargarRegistroProcesoCandidato(IDataSet dataset, RecluProcesoCandidato recluProcesoCandidato) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_proceso_sel", recluProcesoCandidato.getOIDInteger());
		if (recluProcesoCandidato.getCandidato_busq()!=null)
			dataset.fieldValue("oid_candidato_busq", recluProcesoCandidato.getCandidato_busq().getOIDInteger());
		else
			dataset.fieldValue("oid_candidato_busq", "");
		dataset.fieldValue("orden", recluProcesoCandidato.getOrden());
		if (recluProcesoCandidato.getProceso() != null) {
			dataset.fieldValue("oid_proceso", recluProcesoCandidato.getProceso().getOIDInteger());
			dataset.fieldValue("proceso", recluProcesoCandidato.getProceso().getDescripcion());
		} else {
			dataset.fieldValue("oid_proceso", "");
			dataset.fieldValue("proceso", "");
		}
		if (recluProcesoCandidato.getConcepto_proceso() != null) {
			dataset.fieldValue("oid_conc_proceso", recluProcesoCandidato.getConcepto_proceso().getOIDInteger());
			dataset.fieldValue("concepto", recluProcesoCandidato.getConcepto_proceso().getDescripcion());
		} else {
			dataset.fieldValue("oid_conc_proceso", "");
			dataset.fieldValue("concepto", "");
		}
		dataset.fieldValue("costo", recluProcesoCandidato.getCosto());
		if (recluProcesoCandidato.getEstado() != null) {
			dataset.fieldValue("oid_est_proc_sel", recluProcesoCandidato.getEstado().getOIDInteger());
			dataset.fieldValue("estado", recluProcesoCandidato.getEstado().getDescripcion());
		} else {
			dataset.fieldValue("oid_est_proc_sel", "");
			dataset.fieldValue("estado", "");
		}
		dataset.fieldValue("fecha_planif", recluProcesoCandidato.getFecha_planif());
		dataset.fieldValue("hora_planif", recluProcesoCandidato.getHora_planif());
		dataset.fieldValue("persona", recluProcesoCandidato.getPersona());
		dataset.fieldValue("observaciones", recluProcesoCandidato.getObservaciones());
		dataset.fieldValue("puede_iniciar", recluProcesoCandidato.isPuede_iniciar());
		if (recluProcesoCandidato.getTipoFormulario() != null)
			dataset.fieldValue("oid_tipo_formu", recluProcesoCandidato.getTipoFormulario().getOID());
		else
			dataset.fieldValue("oid_tipo_formu", "");
		dataset.fieldValue("completo_tipo_formu", recluProcesoCandidato.isCompletoTipoFormulario());
		dataset.fieldValue("fec_completo_tf", recluProcesoCandidato.getCompletoTipoFormulario());
		dataset.fieldValue("nombre_archivo", recluProcesoCandidato.getNombreArchivo());
		dataset.fieldValue("nro_archivo", recluProcesoCandidato.getNroArchivo());
		if (recluProcesoCandidato.getCandidato_busq()!=null) {
			dataset.fieldValue("oid_postulante", recluProcesoCandidato.getCandidato_busq().getOid_postulante().getOID());
			dataset.fieldValue("nom_y_ape", recluProcesoCandidato.getCandidato_busq().getOid_postulante().getApe_y_nom());
		} else if (recluProcesoCandidato.getRecluPostulante()!=null) {
					dataset.fieldValue("oid_postulante", recluProcesoCandidato.getRecluPostulante().getOIDInteger());
					dataset.fieldValue("nom_y_ape", recluProcesoCandidato.getRecluPostulante().getApe_y_nom());					
				} else {
					dataset.fieldValue("oid_postulante", "");
					dataset.fieldValue("nom_y_ape", "");			
				}
	
		if ((recluProcesoCandidato.getCandidato_busq()!=null) && (recluProcesoCandidato.getCandidato_busq().getBusqueda()!=null)) {
			dataset.fieldValue("empresa", recluProcesoCandidato.getCandidato_busq().getBusqueda().getOperacion().getDescripcion());
			dataset.fieldValue("sector", recluProcesoCandidato.getCandidato_busq().getBusqueda().getSector().getDescripcion());
			dataset.fieldValue("selector", recluProcesoCandidato.getCandidato_busq().getBusqueda().getSelector().getDescripcion());
			dataset.fieldValue("busqueda", recluProcesoCandidato.getCandidato_busq().getBusqueda().getPuesto().getDescripcion()+" ("+recluProcesoCandidato.getCandidato_busq().getBusqueda().getEstado_busqueda()+") ");
			dataset.fieldValue("oid_busqueda_act", recluProcesoCandidato.getCandidato_busq().getBusqueda().getOIDInteger()); 
		} else {
			
			String empresa = "";
			String sector = "";
			String selector = "";
			
			if (recluProcesoCandidato.getOperacion()!=null)
				empresa = recluProcesoCandidato.getOperacion().getDescripcion();
			
			if (recluProcesoCandidato.getSector()!=null)
				sector = recluProcesoCandidato.getSector().getDescripcion();
			
			if (recluProcesoCandidato.getSelector()!=null)
				selector = recluProcesoCandidato.getSelector().getDescripcion();			
			
			dataset.fieldValue("empresa", empresa);
			dataset.fieldValue("sector", sector);
			dataset.fieldValue("selector", selector);
			dataset.fieldValue("busqueda", "");			
			dataset.fieldValue("oid_busqueda_act", "");
		}
	}

	private IDataSet getDataSetProcesoCandidato() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProcesosCandidato");
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
		dataset.fieldDef(new Field("hora_planif", Field.STRING, 5));
		dataset.fieldDef(new Field("persona", Field.STRING, 100));
		dataset.fieldDef(new Field("observaciones", Field.STRING, 4000));
		dataset.fieldDef(new Field("puede_iniciar", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_tipo_formu", Field.INTEGER, 0));
		dataset.fieldDef(new Field("completo_tipo_formu", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fec_completo_tf", Field.DATE, 0));
		dataset.fieldDef(new Field("nombre_archivo", Field.STRING, 255));
		dataset.fieldDef(new Field("nro_archivo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_postulante", Field.INTEGER, 0));
		dataset.fieldDef(new Field("nom_y_ape", Field.STRING, 255));
		dataset.fieldDef(new Field("empresa", Field.STRING, 255));
		dataset.fieldDef(new Field("sector", Field.STRING, 255));
		dataset.fieldDef(new Field("selector", Field.STRING, 255));
		dataset.fieldDef(new Field("busqueda", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_busqueda_act", Field.INTEGER, 0));
		
		return dataset;
	}

}
