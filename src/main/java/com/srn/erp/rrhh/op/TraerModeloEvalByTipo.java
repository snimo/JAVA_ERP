package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerModeloEvalByTipo extends Operation {

	public TraerModeloEvalByTipo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		String tipo = mapaDatos.getString("tipo");
		if (tipo==null) tipo = "";
		IDataSet ds = this.getDataSetSelModEval();
		Iterator iterModelos = ModeloEvalCab.getModelosActivosOrderByFecDesdeTipo(tipo, this.getSesion()).iterator();
		while (iterModelos.hasNext()) {
			ModeloEvalCab modelo = (ModeloEvalCab) iterModelos.next();
			cargarRegistroSelEval(ds, modelo);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetSelModEval() {
		IDataSet dataset = new TDataSet();
		dataset.create("TSelEvaluaciones");
		dataset.fieldDef(new Field("sel", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("oid_mod_eval", Field.INTEGER, 0));
		dataset.fieldDef(new Field("desc_mod_eval", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistroSelEval(IDataSet dataset, ModeloEvalCab aModeloEvalCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("sel", false);
		dataset.fieldValue("oid_mod_eval", aModeloEvalCab.getOIDInteger());
		dataset.fieldValue("desc_mod_eval", aModeloEvalCab.getTitulo());
	}

}
