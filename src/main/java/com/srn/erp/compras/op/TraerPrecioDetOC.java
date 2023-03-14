package com.srn.erp.compras.op;

import java.util.Date;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.general.bm.Precio;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPrecioDetOC extends Operation {

	public TraerPrecioDetOC() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		
		IDataSet ds = getDataSetPrecioOCDet();
		java.util.Date fecha = mapaDatos.getDate("fecha");
		Producto producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), getSesion());
		Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), getSesion());
		Precio precio = producto.getPrecioCompra(proveedor,fecha);
		if (precio!=null)
			enviar(ds, producto, proveedor, fecha, precio);
		writeCliente(ds);
	}

	private IDataSet getDataSetPrecioOCDet() {
		IDataSet dataset = new TDataSet();
		dataset.create("TPrecioDetOC");
		dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_moneda", Field.INTEGER, 0));
		dataset.fieldDef(new Field("precio", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_dto_1", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_dto_2", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("porc_dto_3", Field.CURRENCY, 0));
		dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
		dataset.fieldDef(new Field("fuente_origen", Field.STRING, 50));
		return dataset;
	}


	private void enviar(
			IDataSet ds, 
			Producto producto,
			Proveedor proveedor,
			Date fecha,
			Precio precio) throws BaseException {

		ds.append();
		ds.fieldValue("oid", new Integer(1));
		ds.fieldValue("oid_producto", producto.getOIDInteger());
		ds.fieldValue("oid_proveedor", proveedor.getOIDInteger());
		ds.fieldValue("oid_moneda", precio.getMoneda().getOIDInteger());
		ds.fieldValue("precio", precio.getImporte());
		ds.fieldValue("porc_dto_1", precio.getPorcDto1());
		ds.fieldValue("porc_dto_2", precio.getPorcDto2());
		ds.fieldValue("porc_dto_3", precio.getPorcDto3());
		ds.fieldValue("en_cascada", precio.isEnCascada());
		ds.fieldValue("fuente_origen", precio.getFuente());

	
	}	

}
