package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposModEval extends Operation {

	public TraerTiposModEval() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSetTipos();
		Iterator iterModEvalCab = ModeloEvalCab.getTipoMoedelosEval().keySet().iterator();
		while (iterModEvalCab.hasNext()) {
			String codigo = (String) iterModEvalCab.next();
			String descripcion = (String) ModeloEvalCab.getTipoMoedelosEval().get(codigo);
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSetTipos() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTiposModEval");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo, String descripcion) throws BaseException {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
