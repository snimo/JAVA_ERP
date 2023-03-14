package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.GradoLegajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCantJuegosGrado extends Operation {

	public TraerCantJuegosGrado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet dsGrados = this.getDataSetGradosLeg();
		Iterator iterGradosLegajo = GradoLegajo.getAll(this.getSesion()).iterator();
		while (iterGradosLegajo.hasNext()) {
			GradoLegajo gradoLegajo = (GradoLegajo) iterGradosLegajo.next();
			cargarRegistro(dsGrados, gradoLegajo);
		}
		writeCliente(dsGrados);
	}

	private IDataSet getDataSetGradosLeg() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGrados");
		dataset.fieldDef(new Field("oid_grado_leg", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		dataset.fieldDef(new Field("cant_juegos_a", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cant_juegos_b", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, GradoLegajo gradoLegajo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_grado_leg", gradoLegajo.getOIDInteger());
		dataset.fieldValue("codigo", gradoLegajo.getCodigo());
		dataset.fieldValue("descripcion", gradoLegajo.getDescripcion());
		dataset.fieldValue("cant_juegos_a", gradoLegajo.getCantJuegosA());
		dataset.fieldValue("cant_juegos_b", gradoLegajo.getCantJuegosB());
		dataset.fieldValue("activo", gradoLegajo.isActivo());
	}

}
