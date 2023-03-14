package com.srn.erp.produccion.op;

import java.util.Iterator;

import com.srn.erp.produccion.bm.OrdenFabricacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposOrdenesProduccion extends Operation {

	public TraerTiposOrdenesProduccion() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDSTiposOrdenesProd();
		Iterator iter = OrdenFabricacion.getTiposOrdenes().keySet().iterator();
		while (iter.hasNext()) {
			String codigo = (String) iter.next();
			String descripcion = (String) OrdenFabricacion.getTiposOrdenes().get(codigo);
			cargarOrdenProduccion(ds, codigo, descripcion);
		}

		writeCliente(ds);
	}

	private IDataSet getDSTiposOrdenesProd() {
		IDataSet dataset = new TDataSet();
		dataset.create("TTipoOrden");
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
		return dataset;
	}

	private void cargarOrdenProduccion(IDataSet dataset, String codigo, String descripcion) throws BaseException {

		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);

	}

}
