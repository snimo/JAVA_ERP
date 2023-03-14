package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.GradoLegajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveCantJuegosGrado extends Operation {

	public SaveCantJuegosGrado() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsGrados = mapaDatos.getDataSet("TGrados");
		dsGrados.first();
		while (!dsGrados.EOF()) {
			GradoLegajo gradoLegajo = GradoLegajo.findByOid(dsGrados.getInteger("oid_grado_leg"), this.getSesion());
			gradoLegajo.setCodigo(dsGrados.getString("codigo"));
			gradoLegajo.setDescripcion(dsGrados.getString("descripcion"));
			gradoLegajo.setCantJuegosA(dsGrados.getInteger("cant_juegos_a"));
			gradoLegajo.setCantJuegosB(dsGrados.getInteger("cant_juegos_b"));
			gradoLegajo.setActivo(dsGrados.getBoolean("activo"));
			dsGrados.next();

			this.addTransaccion(gradoLegajo);
		}

	}

}
