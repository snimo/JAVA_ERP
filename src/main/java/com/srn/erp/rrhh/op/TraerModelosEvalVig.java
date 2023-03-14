package com.srn.erp.rrhh.op;

import java.util.Iterator;

import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerModelosEvalVig extends Operation {

	public TraerModelosEvalVig() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet dsModelosVig = this.getDataSetModelosVig();
		Iterator iterModelosVig = null;
		
		if (mapaDatos.containsKey("DESEM"))
			iterModelosVig = ModeloEvalCab.getModelosVigentesDesempenio(this.getSesion()).iterator();
		else if (mapaDatos.containsKey("POTEN")) 
			iterModelosVig = ModeloEvalCab.getModelosVigentesPotencial(this.getSesion()).iterator();
		else
			iterModelosVig = ModeloEvalCab.getModelosVigentes(this.getSesion()).iterator();

		while (iterModelosVig.hasNext()) {
			ModeloEvalCab modeloEvalCab = (ModeloEvalCab) iterModelosVig.next();
			cargarRegistro(dsModelosVig, modeloEvalCab);
		}

		writeCliente(dsModelosVig);
	}

	private IDataSet getDataSetModelosVig() {
		IDataSet dataset = new TDataSet();
		dataset.create("TModelosVigentes");
		dataset.fieldDef(new Field("oid_mod_eval_cab", Field.INTEGER, 0));
		dataset.fieldDef(new Field("titulo", Field.STRING, 100));
		dataset.fieldDef(new Field("desc_abraviada", Field.STRING, 100));
		dataset.fieldDef(new Field("fec_desde", Field.DATE, 0));
		dataset.fieldDef(new Field("fec_hasta", Field.DATE, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, ModeloEvalCab aModeloEvalCab) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_mod_eval_cab", aModeloEvalCab.getOIDInteger());
		dataset.fieldValue("titulo", aModeloEvalCab.getTitulo());
		dataset.fieldValue("desc_abraviada", aModeloEvalCab.getDesc_abreviada());
		dataset.fieldValue("fec_desde", aModeloEvalCab.getFec_desde());
		dataset.fieldValue("fec_hasta", aModeloEvalCab.getFec_hasta());
	}

}
