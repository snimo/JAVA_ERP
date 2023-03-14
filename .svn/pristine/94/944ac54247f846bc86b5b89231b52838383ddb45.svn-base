package com.srn.erp.cip.op;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.cip.bm.PaseRechazado;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPasesNoValidos extends Operation {

	public TraerPasesNoValidos() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		java.util.Date fecDesde = mapaDatos.getDate("fec_desde");
		java.util.Date fecHasta = mapaDatos.getDate("fec_hasta");

		if (fecDesde == null)
			throw new ExceptionValidation(null, "Debe ingresar la fecha desde");
		if (fecHasta == null)
			throw new ExceptionValidation(null, "Debe ingresar la fecha hasta");

		List listaLegajos = new ArrayList();
		IDataSet dsLegajos = mapaDatos.getDataSet("TLegajosAPlanif");
		dsLegajos.first();
		while (!dsLegajos.EOF()) {
			listaLegajos.add(dsLegajos.getInteger("oid_legajo"));
			dsLegajos.next();
		}

		IDataSet ds = this.getDataSetMovimientos();

		Iterator iterPasesRechazados = PaseRechazado.getPasesRechazados(fecDesde, fecHasta, listaLegajos, this.getSesion()).iterator();
		while (iterPasesRechazados.hasNext()) {
			PaseRechazado paseRechazado = (PaseRechazado) iterPasesRechazados.next();
			cargarRegistroMovimiento(ds, paseRechazado);
		}

		writeCliente(ds);

	}

	private IDataSet getDataSetMovimientos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TMovimientos");
		dataset.fieldDef(new Field("oid_mov", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_legajo", Field.INTEGER, 0));
		dataset.fieldDef(new Field("legajo", Field.STRING, 50));
		dataset.fieldDef(new Field("ape_y_nom", Field.STRING, 255));
		dataset.fieldDef(new Field("tipo", Field.STRING, 20));
		dataset.fieldDef(new Field("oid_puerta", Field.INTEGER, 0));
		dataset.fieldDef(new Field("puerta", Field.STRING, 50));
		dataset.fieldDef(new Field("fecha", Field.DATE, 0));
		dataset.fieldDef(new Field("hora", Field.STRING, 8));
		dataset.fieldDef(new Field("sentido", Field.STRING, 1));
		dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		dataset.fieldDef(new Field("motivo", Field.STRING, 100));
		dataset.fieldDef(new Field("media", Field.INTEGER, 0));
		
		return dataset;
	}

	private void cargarRegistroMovimiento(IDataSet dataset, PaseRechazado paseRechazado) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_mov", paseRechazado.getOIDInteger());
		if (paseRechazado.getLegajo() != null) {
			dataset.fieldValue("oid_legajo", paseRechazado.getLegajo().getOIDInteger());
			dataset.fieldValue("legajo", paseRechazado.getLegajo().getCodigo());
			dataset.fieldValue("ape_y_nom", paseRechazado.getLegajo().getApellidoyNombre());
			dataset.fieldValue("tipo", "Empleados");
		} else if (paseRechazado.getVisita() != null) {
			dataset.fieldValue("oid_legajo", paseRechazado.getVisita().getOIDInteger());
			dataset.fieldValue("legajo", paseRechazado.getVisita().getNroDocumento());
			dataset.fieldValue("ape_y_nom", paseRechazado.getVisita().getApeyNom());
			dataset.fieldValue("tipo", "Visitas");
		} else
		{
			dataset.fieldValue("oid_legajo", "");
			dataset.fieldValue("legajo", "");
			dataset.fieldValue("ape_y_nom", "*** PERSONA DESCONOCIDA ***");
			dataset.fieldValue("tipo", "Desconocidos");
		}
		dataset.fieldValue("oid_puerta", paseRechazado.getPuerta().getOIDInteger());
		dataset.fieldValue("puerta", paseRechazado.getPuerta().getCodigo());
		dataset.fieldValue("fecha", paseRechazado.getFecha());
		dataset.fieldValue("hora", paseRechazado.getHora());
		dataset.fieldValue("sentido", paseRechazado.getEntradaSalida());
		dataset.fieldValue("titulo", "");
		dataset.fieldValue("motivo", paseRechazado.getMotivo());
		
		Integer media = paseRechazado.getMedia(); 
		
		dataset.fieldValue("media", media);

	}

}
