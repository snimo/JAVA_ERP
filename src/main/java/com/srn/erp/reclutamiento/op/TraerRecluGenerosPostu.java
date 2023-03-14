package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluPostulante;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluGenerosPostu extends Operation {

	public TraerRecluGenerosPostu() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetGenerosPostulante();
		Iterator iterGeneros = RecluPostulante.getGeneros().keySet().iterator();
		while (iterGeneros.hasNext()) {
			String codigo = (String) iterGeneros.next();
			String descripcion = (String) RecluPostulante.getGeneros().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetGenerosPostulante() {
		IDataSet dataset = new TDataSet();
		dataset.create("TGenerosPostulantes");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
