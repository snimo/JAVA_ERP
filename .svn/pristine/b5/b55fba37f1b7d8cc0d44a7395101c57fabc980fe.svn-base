package com.srn.erp.reclutamiento.op;

import java.util.Iterator;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluSexoBusq extends Operation {

	public TraerRecluSexoBusq() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetRecluSexo();
		Iterator iterEstSexo = RecluBusqueda.getSexoPostulantes().keySet().iterator();
		while (iterEstSexo.hasNext()) {
			String codigo = (String) iterEstSexo.next();
			String descripcion = (String) RecluBusqueda.getSexoPostulantes().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetRecluSexo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSexoBusqueda");
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
