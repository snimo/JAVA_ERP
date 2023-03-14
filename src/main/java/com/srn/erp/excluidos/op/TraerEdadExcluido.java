package com.srn.erp.excluidos.op;

import com.srn.erp.excluidos.bm.EdadExcluido;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEdadExcluido extends Operation {

	public TraerEdadExcluido() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		EdadExcluido edadexcluido = null;
		if (mapaDatos.containsKey("oid")) {
			Integer oid = mapaDatos.getInteger("oid");
			edadexcluido = EdadExcluido.findByOid(oid, getSesion());
		} else {
			String codigo = mapaDatos.getString("codigo");
			edadexcluido = EdadExcluido.findByCodigo(codigo, getSesion());
		}

		IDataSet datasetEdadExcluido = getDataSetEdadExcluido();
		if (edadexcluido != null) {
			cargarRegistroEdadExcluido(datasetEdadExcluido, edadexcluido);
		}
		writeCliente(datasetEdadExcluido);
	}

	private IDataSet getDataSetEdadExcluido() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEdadExcluido");
		dataset.fieldDef(new Field("oid_edad", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
		return dataset;
	}

	private void cargarRegistroEdadExcluido(IDataSet dataset, EdadExcluido edad) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_edad", edad.getOIDInteger());
		dataset.fieldValue("codigo", edad.getCodigo());
		dataset.fieldValue("descripcion", edad.getDescripcion());
		dataset.fieldValue("activo", edad.isActivo());
	}
}
