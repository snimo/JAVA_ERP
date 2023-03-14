package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.CostoProductoGral;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerComoObtenerCostoProductoGral extends Operation {

	public TraerComoObtenerCostoProductoGral() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = this.getDataSetComoObtCostoUltProd();
		Iterator iterCostoProdGral = 
			CostoProductoGral.getListaComoObtenerCostos().keySet().iterator();
		while (iterCostoProdGral.hasNext()) {
			String codigo = (String) iterCostoProdGral.next();
			String descripcion = (String) CostoProductoGral.getListaComoObtenerCostos().get(codigo); 
			cargarRegistro(ds, codigo, descripcion);
		}
		writeCliente(ds);
	}

	private IDataSet getDataSetComoObtCostoUltProd() {
		IDataSet dataset = new TDataSet();
		dataset.create("TComoObtCostoProd");
		dataset.fieldDef(new Field("codigo", Field.STRING, 20));
		dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, String codigo, String descripcion) {
		dataset.append();
		dataset.fieldValue("codigo", codigo);
		dataset.fieldValue("descripcion", descripcion);
	}
}
