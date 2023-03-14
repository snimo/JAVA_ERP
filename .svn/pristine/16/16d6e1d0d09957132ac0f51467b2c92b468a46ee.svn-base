package com.srn.erp.reclutamiento.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluConsRecepcion extends Operation {

	public TraerRecluConsRecepcion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = mapaDatos.getDataSet("Tinput");
		java.util.Date fecDesde = null;
		java.util.Date fecHasta = null;
		String buscar = null;
		IDataSet dsConsulta = getDataSetConsulta();

		ds.first();
		while (!ds.EOF()) {

			fecDesde = ds.getDate("fec_desde");
			fecHasta = ds.getDate("fec_hasta");
			buscar = ds.getString("buscar");

			ds.next();
		}

		if (fecDesde == null)
			throw new ExceptionValidation(null, "Debe ingresar la fecha desde");

		if (fecHasta == null)
			throw new ExceptionValidation(null, "Debe ingresar la fecha hasta");

		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put("FEC_DESDE", fecDesde);
		condiciones.put("FEC_HASTA", fecHasta);
		if (buscar != null)
			condiciones.put("BUSCAR", buscar);
		
		List listaOperHab = RecluOperacion.getOperacionesParaVisualizarDelUsuario(this.getSesion());

		Iterator iterProcesosCandidato = RecluProcesoCandidato.getRecluProcesosRecepcion(condiciones, this.getSesion()).iterator();
		while (iterProcesosCandidato.hasNext()) {
			
			RecluProcesoCandidato recluProcesoCandidato = (RecluProcesoCandidato) iterProcesosCandidato.next();
			if (isOperacionHabilitada(listaOperHab,recluProcesoCandidato))
				cargarRegistro(dsConsulta, recluProcesoCandidato);
			
		}
		
		writeCliente(dsConsulta);
	}
	
	private boolean isOperacionHabilitada(List listaOperacion, RecluProcesoCandidato recluProcesoCandidato) throws BaseException {
		
		for (int i=0; i<listaOperacion.size() ; ++i) {
			RecluOperacion recluOperacion = (RecluOperacion)listaOperacion.get(i);
			
			if ((recluProcesoCandidato.getOperacion()!=null) && (recluProcesoCandidato.getOperacion().getOID()==recluOperacion.getOID()))
				return true;
			else
				if ((recluProcesoCandidato.getCandidato_busq()!=null) && (recluProcesoCandidato.getCandidato_busq().getBusqueda().getOperacion().getOID()==recluOperacion.getOID()))
					return true;
			
		}
				
		return false;
	}

	private IDataSet getDataSetConsulta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TConsultaRecepcion");
		dataset.fieldDef(new Field("oid_proceso_candi", Field.INTEGER, 100));
		dataset.fieldDef(new Field("empresa", Field.STRING, 100));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 100));
		dataset.fieldDef(new Field("nro_docu", Field.STRING, 50));
		dataset.fieldDef(new Field("hora", Field.STRING, 50));
		dataset.fieldDef(new Field("selector", Field.STRING, 100));
		dataset.fieldDef(new Field("contactar", Field.STRING, 100));
		dataset.fieldDef(new Field("llego", Field.STRING, 2));
		dataset.fieldDef(new Field("hora_llegada", Field.STRING, 5));
		dataset.fieldDef(new Field("oid_tipo_formulario", Field.INTEGER, 0));
		dataset.fieldDef(new Field("completo_formu", Field.STRING, 2));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, RecluProcesoCandidato aRecluProcesoCandidato) throws BaseException {
		dataset.append();
		
		dataset.fieldValue("oid_proceso_candi", aRecluProcesoCandidato.getOIDInteger());
		
		if (aRecluProcesoCandidato.getCandidato_busq()!=null)  
			dataset.fieldValue("empresa", aRecluProcesoCandidato.getCandidato_busq().getBusqueda().getOperacion().getDescripcion());
		else if (aRecluProcesoCandidato.getOperacion()!=null)
			dataset.fieldValue("empresa", aRecluProcesoCandidato.getOperacion().getDescripcion());
		else
			dataset.fieldValue("empresa", "");
		
		dataset.fieldValue("fecha", aRecluProcesoCandidato.getFecha_planif());
		if (aRecluProcesoCandidato.getCandidato_busq()!=null)
			dataset.fieldValue("ape_y_nom", aRecluProcesoCandidato.getCandidato_busq().getOid_postulante().getApe_y_nom());
		else if (aRecluProcesoCandidato.getRecluPostulante()!=null)
			dataset.fieldValue("ape_y_nom", aRecluProcesoCandidato.getRecluPostulante().getApe_y_nom());
		else
			dataset.fieldValue("ape_y_nom", "");
		
		if (aRecluProcesoCandidato.getCandidato_busq()!=null)
			dataset.fieldValue("nro_docu", aRecluProcesoCandidato.getCandidato_busq().getOid_postulante().getNro_docu());
		else if (aRecluProcesoCandidato.getRecluPostulante()!=null)
			dataset.fieldValue("nro_docu", aRecluProcesoCandidato.getRecluPostulante().getNro_docu());
		else
			dataset.fieldValue("nro_docu", "");		
		
		dataset.fieldValue("hora", aRecluProcesoCandidato.getHora_planif());
		if (aRecluProcesoCandidato.getSelector()!=null)
			dataset.fieldValue("selector", aRecluProcesoCandidato.getSelector().getDescripcion());
		else
			dataset.fieldValue("selector", "");
		dataset.fieldValue("contactar", aRecluProcesoCandidato.getPersona());
		
		if (aRecluProcesoCandidato.isSeAnuncio())
			dataset.fieldValue("llego", "SI");
		else
			dataset.fieldValue("llego", "NO");
		
		if (aRecluProcesoCandidato.getFecHorSeAnuncio()!=null)
			dataset.fieldValue("hora_llegada", Fecha.getFormatoHoraMin(aRecluProcesoCandidato.getFecHorSeAnuncio()));
		else
			dataset.fieldValue("hora_llegada", "");
		
		if (aRecluProcesoCandidato.getTipoFormulario()!=null)
			dataset.fieldValue("oid_tipo_formulario", aRecluProcesoCandidato.getTipoFormulario().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_formulario", "");
		
		if (aRecluProcesoCandidato.isCompletoTipoFormulario())
			dataset.fieldValue("completo_formu", "SI");
		else
			dataset.fieldValue("completo_formu", "NO");
		
	}

}
