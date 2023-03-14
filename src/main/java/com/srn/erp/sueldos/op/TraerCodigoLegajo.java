package com.srn.erp.sueldos.op;

import com.srn.erp.sueldos.bm.Legajo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCodigoLegajo extends Operation {

	public TraerCodigoLegajo() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetLegParaCacheo();
		Legajo legajo = null;
		if (mapaDatos.containsKey("oid_legajo"))
			legajo = Legajo.findByOidProxy(mapaDatos.getInteger("oid_legajo"), this.getSesion());
		else if (mapaDatos.containsKey("cod_legajo"))
			legajo = Legajo.findByCodigo(mapaDatos.getString("cod_legajo"), this.getSesion());
		if (legajo!=null)
			cargarRegistro(ds, legajo);
		writeCliente(ds);
	}

	private IDataSet getDataSetLegParaCacheo() {
		IDataSet dataset = new TDataSet();
		dataset.create("TCodigoLegajo");
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
