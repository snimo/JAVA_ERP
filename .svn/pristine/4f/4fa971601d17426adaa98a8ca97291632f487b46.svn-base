package com.srn.erp.legales.op;

import java.util.Iterator;

import com.srn.erp.legales.bm.ResulProbJuicio;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerResulProbJuicio extends Operation {

	public TraerResulProbJuicio() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetResulJuicio();
		Iterator iterResulProb = ResulProbJuicio.getResultadosProbales().keySet().iterator();
		while (iterResulProb.hasNext()) {
			String codigo = (String) iterResulProb.next();
			String descripcion = (String) ResulProbJuicio.getResultadosProbales().get(codigo);
			cargarRegistroResulJuicio(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetResulJuicio() {
		IDataSet dataset = new TDataSet();
		dataset.create("TResulProbJuicio");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroResulJuicio(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
