package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.EsquemaHabilitacionProducto;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValidarProdHabRequi extends Operation {

	public ValidarProdHabRequi() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {

		String codProducto = mapaDatos.getString("cod_producto");
		Producto producto = (Producto) Producto.findByCodigo(codProducto, getSesion());
		
		if (producto == null)
			throw new ExceptionValidation(null,"Códgo de Producto inexistente "+codProducto);
		
		IDataSet ds = getDataSetProducto();

		EsquemaHabilitacionProducto esqHabProd = RequisicionCab.getEsqHabProd(getSesion());
		if (esqHabProd == null)
			throw new ExceptionValidation(null,
					"No se encuentra definido un esquema de Habilitación de productos para la requisición");

		if (esqHabProd.isProductoHabilitado(producto))
			cargarRegistroProducto(ds, producto);

		writeCliente(ds);

	}

	private IDataSet getDataSetProducto() {
		IDataSet dataset = new TDataSet();
		dataset.create("TProdHabRequi");
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("codigo", Field.STRING, 50));
		dataset.fieldDef(new Field("descripcion", Field.INTEGER, 0));
		dataset.fieldDef(new Field("activo", Field.STRING, 1));
		return dataset;
	}

	private void cargarRegistroProducto(IDataSet dataset, Producto producto) throws BaseException {
		dataset.append();
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("codigo", producto.getCodigo());
		dataset.fieldValue("descripcion", producto.getDescripcion());
		dataset.fieldValue("activo", producto.isActivo());
	}
}
