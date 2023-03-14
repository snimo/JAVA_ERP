package com.srn.erp.ventas.op;

import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SugerirCantRequi extends Operation {

  public SugerirCantRequi() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	PedidoDet pedidoDet = PedidoDet.findByOid(mapaDatos.getInteger("oid_ped_det"), this.getSesion());  
	  
    IDataSet ds = getDS();
    cargarRegistroPedidoDet(ds, pedidoDet);
    writeCliente(ds);
  }

  private IDataSet getDS() {
    IDataSet dataset = new TDataSet();
    dataset.create("TSugerirRequisicion");
    dataset.fieldDef(new Field("oid_ped_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_cco_ped", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_requerida", Field.DATE, 0));
    dataset.fieldDef(new Field("oid_proveedor", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_proveedor", Field.STRING, 50));
    dataset.fieldDef(new Field("rs_proveedor", Field.STRING, 100));
    dataset.fieldDef(new Field("referencia", Field.STRING, 100));
    
    return dataset;
  }

  private void cargarRegistroPedidoDet(IDataSet dataset,
                         PedidoDet pedidoDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_ped_det", pedidoDet.getOIDInteger());
    dataset.fieldValue("oid_cco_ped", pedidoDet.getPedido().getOIDInteger());
    dataset.fieldValue("oid_producto", pedidoDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", pedidoDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", pedidoDet.getProducto().getDescripcion());
    dataset.fieldValue("cantidad", pedidoDet.getCantSinReserNiSepa());
    if (pedidoDet.getProducto().getUm_cpra()!=null)
    	dataset.fieldValue("oid_um", pedidoDet.getProducto().getUm_cpra().getOIDInteger());
    else
    	dataset.fieldValue("oid_um", "");
    dataset.fieldValue("fec_requerida", pedidoDet.getFechaEntrega());
    
    ProductoProveedor productoProveedor = pedidoDet.getProducto().getProveedorMenorPrioridad();
    if ((productoProveedor!=null) && (productoProveedor.getProveedor()!=null)) {
    	dataset.fieldValue("oid_proveedor", productoProveedor.getProveedor().getOIDInteger());
    	dataset.fieldValue("cod_proveedor", productoProveedor.getProveedor().getCodigo());
    	dataset.fieldValue("rs_proveedor", productoProveedor.getProveedor().getRazonsocial());
    } else {
    	dataset.fieldValue("oid_proveedor", "");
    	dataset.fieldValue("cod_proveedor", "");
    	dataset.fieldValue("rs_proveedor", "");
    }
    dataset.fieldValue("referencia", pedidoDet.getPedido().getCodigo()+"/"+pedidoDet.getNroRenglon());
    	
  }
}
