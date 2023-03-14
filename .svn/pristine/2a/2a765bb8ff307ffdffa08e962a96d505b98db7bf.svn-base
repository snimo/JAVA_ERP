package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.ObsLegajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPosNegObs extends Operation {

	public TraerPosNegObs() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetPosNegNeu();
		Iterator iterPosNegNeu = ObsLegajo.getListaPosNegNeu().keySet().iterator();
		while (iterPosNegNeu.hasNext()) {
			String codigo = (String) iterPosNegNeu.next();
			String descripcion = (String) ObsLegajo.getListaPosNegNeu().get(codigo);
			cargarRegistroPosNegNeu(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetPosNegNeu() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPosNegNeu");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroPosNegNeu(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
