package com.srn.erp.cip.op;

import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerLegParaCacheo extends Operation {

	public TraerLegParaCacheo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetLegParaCacheo();
		Legajo legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());
		cargarRegistro(ds, legajo);
		writeCliente(ds);
	}

	private IDataSet getDataSetLegParaCacheo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TLegParaCacheo");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, Legajo legajo) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid", legajo.getOID());
		dataset.fieldValue("codigo", legajo.getCodigo());
		dataset.fieldValue("descripcion", legajo.getApellidoyNombre());
	}

}
