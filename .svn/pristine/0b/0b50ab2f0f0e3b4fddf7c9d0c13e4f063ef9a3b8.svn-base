package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ValCargaProdInfRec extends Operation {

	public ValCargaProdInfRec() {
	}

	public void execute(MapDatos mapaDatos) throws BaseException {
		IDataSet ds = getDSValCargaProdInfRec();
		String codProducto = mapaDatos.getString("cod_producto");
		Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), this.getSesion());
		
		Producto producto = Producto.findByCodigo(codProducto, this.getSesion());
		
		if (producto == null)
			throw new ExceptionValidation(null,"Código de Producto "+codProducto+" inexistente");
		
		if (proveedor == null)
			throw new ExceptionValidation(null,"Debe ingresar el Proveedor");
		
		if (producto.isActivo().booleanValue()==false)
			throw new ExceptionValidation(null,"El producto "+codProducto+" se encuentra deshabilitado.");
		
		cargarRegistro(ds, producto, proveedor);
		
		writeCliente(ds);
	}

	private IDataSet getDSValCargaProdInfRec() {
		IDataSet dataset = new TDataSet();
		dataset.create("TValCargaProdInfRec");
		dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
		dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
		dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
		dataset.fieldDef(new Field("cod_art_prov", Field.STRING, 255));
		dataset.fieldDef(new Field("oid_um_stock", Field.INTEGER, 0));
		dataset.fieldDef(new Field("oid_um_compra", Field.INTEGER, 0));
		return dataset;
	}

	private void cargarRegistro(IDataSet dataset, 
			Producto producto, 
			Proveedor proveedor) throws BaseException {
		
		dataset.append();
		dataset.fieldValue("oid_producto", producto.getOIDInteger());
		dataset.fieldValue("cod_producto", producto.getCodigo());
		dataset.fieldValue("desc_producto", producto.getDescripcion());
		ProductoProveedor productoProveedor = 
			producto.getProductoProveedor(proveedor);
		if (productoProveedor!=null)
			dataset.fieldValue("cod_art_prov", productoProveedor.getCod_prod_prov());
		else
			dataset.fieldValue("cod_art_prov", "");
		if (producto.getUm_stk()!=null)
			dataset.fieldValue("oid_um_stock", producto.getUm_stk().getOIDInteger());
		else
			dataset.fieldValue("oid_um_stock", 0);
		if (producto.getUm_cpra()!=null)
			dataset.fieldValue("oid_um_compra", producto.getUm_cpra().getOIDInteger());
		else
			dataset.fieldValue("oid_um_compra", 0);
		
	}

}
