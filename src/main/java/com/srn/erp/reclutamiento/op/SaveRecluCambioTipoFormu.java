package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;

import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.Util;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SaveRecluCambioTipoFormu extends Operation {

	public SaveRecluCambioTipoFormu() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		RecluProcesoCandidato recluProcesoCandi = RecluProcesoCandidato.findByOid(mapaDatos.getInteger("oid_proceso_candi"), this.getSesion());
		RecluTipoFormuProceso recluTipoFormuProceso = RecluTipoFormuProceso.findByOidProxy(mapaDatos.getInteger("oid_tipo_formulario"), this.getSesion());
		
		IDataSet ds = this.getDataSetConsulta();
		
		if (recluTipoFormuProceso==null) {
			recluProcesoCandi.setTipoFormulario(null);
			recluProcesoCandi.setCompletoTipoFormulario(false);
			recluProcesoCandi.setFecCompletoTipoFormulario(null);
		} else {
			recluProcesoCandi.setTipoFormulario(recluTipoFormuProceso);
			recluProcesoCandi.setCompletoTipoFormulario(true);
			recluProcesoCandi.setFecCompletoTipoFormulario(Util.getFechaActual(this.getSesion()));			
		}
		
		recluProcesoCandi.save();
		recluProcesoCandi.supportRefresh();
		cargarRegistro(ds, recluProcesoCandi);
		writeCliente(ds);
		
		
	}

	private IDataSet getDataSetConsulta() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTempConsultaRecepcion");
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
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, RecluProcesoCandidato aRecluProcesoCandidato) throws BaseException {
		dataset.append();

		dataset.fieldValue("oid_proceso_candi", aRecluProcesoCandidato.getOIDInteger());

		if (aRecluProcesoCandidato.getCandidato_busq() != null)
			dataset.fieldValue("empresa", aRecluProcesoCandidato.getCandidato_busq().getBusqueda().getOperacion().getDescripcion());
		else if (aRecluProcesoCandidato.getOperacion() != null)
			dataset.fieldValue("empresa", aRecluProcesoCandidato.getOperacion().getDescripcion());
		else
			dataset.fieldValue("empresa", "");

		dataset.fieldValue("fecha", aRecluProcesoCandidato.getFecha_planif());
		if (aRecluProcesoCandidato.getCandidato_busq() != null)
			dataset.fieldValue("ape_y_nom", aRecluProcesoCandidato.getCandidato_busq().getOid_postulante().getApe_y_nom());
		else if (aRecluProcesoCandidato.getRecluPostulante() != null)
			dataset.fieldValue("ape_y_nom", aRecluProcesoCandidato.getRecluPostulante().getApe_y_nom());
		else
			dataset.fieldValue("ape_y_nom", "");

		if (aRecluProcesoCandidato.getCandidato_busq() != null)
			dataset.fieldValue("nro_docu", aRecluProcesoCandidato.getCandidato_busq().getOid_postulante().getNro_docu());
		else if (aRecluProcesoCandidato.getRecluPostulante() != null)
			dataset.fieldValue("nro_docu", aRecluProcesoCandidato.getRecluPostulante().getNro_docu());
		else
			dataset.fieldValue("nro_docu", "");

		dataset.fieldValue("hora", aRecluProcesoCandidato.getHora_planif());
		if (aRecluProcesoCandidato.getSelector() != null)
			dataset.fieldValue("selector", aRecluProcesoCandidato.getSelector().getDescripcion());
		else
			dataset.fieldValue("selector", "");
		dataset.fieldValue("contactar", aRecluProcesoCandidato.getPersona());

		if (aRecluProcesoCandidato.isSeAnuncio())
			dataset.fieldValue("llego", "SI");
		else
			dataset.fieldValue("llego", "NO");

		if (aRecluProcesoCandidato.getFecHorSeAnuncio() != null)
			dataset.fieldValue("hora_llegada", Fecha.getFormatoHoraMin(aRecluProcesoCandidato.getFecHorSeAnuncio()));
		else
			dataset.fieldValue("hora_llegada", "");

		if (aRecluProcesoCandidato.getTipoFormulario() != null)
			dataset.fieldValue("oid_tipo_formulario", aRecluProcesoCandidato.getTipoFormulario().getOIDInteger());
		else
			dataset.fieldValue("oid_tipo_formulario", "");
	}

}
