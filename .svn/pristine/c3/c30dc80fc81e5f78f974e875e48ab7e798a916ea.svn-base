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

public class SugerirEtiquetasImpresionOC extends Operation {

	public SugerirEtiquetasImpresionOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetEtiquetas();
		HashTableDatos etiquetas = OrdenDeCompraCab.getEtiquetasImpresion();
		Iterator iterEtiquetas = etiquetas.keySet().iterator();
		while (iterEtiquetas.hasNext()) {
			String codigo = (String) iterEtiquetas.next();
			String desc = (String) etiquetas.get(codigo);
			cargarEtiqueta(ds,codigo,desc);
		}
		
		
		writeCliente(ds);
	}

	private IDataSet getDataSetEtiquetas() {
		IDataSet dataset = new TDataSet();
		dataset.create("TEtiquetas");
		dataset.fieldDef(new Field("label", Field.STRING, 100));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarEtiqueta(
			IDataSet ds,
			String codigo,
			String descripcion) {
		ds.append();
		ds.fieldValue("codigo", codigo);
		ds.fieldValue("descripcion", descripcion);
	}

}
