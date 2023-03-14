package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OrdenDeCompraCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerFiltrosOC extends Operation {

	public TraerFiltrosOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		int oid = 0;
		IDataSet datasetFiltrosOC = getDataSetFiltrosOC();
		HashTableDatos filtros = OrdenDeCompraCab.getFiltros();
		Iterator iterFiltros = filtros.keySet().iterator();
		while (iterFiltros.hasNext()) {
			String codigo = (String) iterFiltros.next();
			String descripcion = (String) filtros.get(codigo);
			cargarRegistroFiltrosOC(datasetFiltrosOC, new Integer(++oid), codigo, descripcion);
		}
		writeCliente(datasetFiltrosOC);
	}

	private IDataSet getDataSetFiltrosOC() {
		IDataSet dataset = new TDataSet();
		dataset.create("TFiltrosOC");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 15));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 30));
		return dataset;
	}

	private void cargarRegistroFiltrosOC(IDataSet dataset, Integer oid, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("oid", oid);
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}

}
