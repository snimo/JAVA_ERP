package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.ObsCodifVtas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerObsDefPresu extends Operation {

	public TraerObsDefPresu() {
	}


	public void execute(MapDatos mapaDatos) throws BaseException {

		IDataSet ds = this.getDataSet();
		Iterator iterObsCodifVtas = 
			ObsCodifVtas.getObsDefaultPresupuesto(this.getSesion()).iterator();
		while (iterObsCodifVtas.hasNext()) {
			ObsCodifVtas obsCodifVtas  = (ObsCodifVtas) iterObsCodifVtas.next();
			cargarRegistro(ds, obsCodifVtas);
		}
		writeCliente(ds);

	}

	private IDataSet getDataSet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TObsDefaultPresu");
		dataset.fieldDef(new Field("oid_obs_cod", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 500));
		dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, ObsCodifVtas obsCodifVtas) throws BaseException {

		dataset.append();
		dataset.fieldValue("oid_obs_cod", obsCodifVtas.getOIDInteger());
		dataset.fieldValue("codigo", obsCodifVtas.getCodigo());
		dataset.fieldValue("descripcion", obsCodifVtas.getDescripcion());
		dataset.fieldValue("orden", obsCodifVtas.getOrden());
		
	}
}
