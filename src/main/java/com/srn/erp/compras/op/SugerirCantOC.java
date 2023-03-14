package com.srn.erp.compras.op;

import com.srn.erp.compras.bm.CotizacionProveedorDet;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class SugerirCantOC extends Operation {

  public SugerirCantOC() {
  }
  
  public void execute(MapDatos mapaDatos) throws BaseException {
	  
		if (mapaDatos.containsKey("oid_req_det"))
			procesarRequisicionDet(mapaDatos);
		else if (mapaDatos.containsKey("oid_ped_det"))
			procesarPedidoDet(mapaDatos);
		  
	  }
	  
	  private void procesarRequisicionDet(MapDatos mapaDatos) throws BaseException {
			RequisicionDet requisicionDet = RequisicionDet.findByOid(mapaDatos.getInteger("oid_req_det"), this.getSesion());  		  
		    IDataSet ds = getDS();
		    cargarRegistroRequisicionDet(ds, requisicionDet);
		    writeCliente(ds);
	  }
	  
	  private void procesarPedidoDet(MapDatos mapaDatos) throws BaseException {
			PedidoDet pedidoDet = PedidoDet.findByOid(mapaDatos.getInteger("oid_ped_det"), this.getSesion());  		  
		    IDataSet ds = getDS();
		    cargarRegistroPedidoDet(ds, pedidoDet);
		    writeCliente(ds);
	}
	  

	  private IDataSet getDS() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TSugerirOC");
	    dataset.fieldDef(new Field("oid_req_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_cco_req", Field.INTEGER, 0));
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

	  private void cargarRegistroRequisicionDet(IDataSet dataset,
	                         RequisicionDet requisicionDet) throws BaseException {
	    dataset.append();
	    dataset.fieldValue("oid_req_det", requisicionDet.getOIDInteger());
	    dataset.fieldValue("oid_cco_req", requisicionDet.getRequisicion().getOIDInteger());
	    dataset.fieldValue("oid_ped_det", "");
	    dataset.fieldValue("oid_cco_ped", "");    
	    dataset.fieldValue("oid_producto", requisicionDet.getProducto().getOIDInteger());
	    dataset.fieldValue("cod_producto", requisicionDet.getProducto().getCodigo());
	    dataset.fieldValue("desc_producto", requisicionDet.getProducto().getDescripcion());
	    dataset.fieldValue("cantidad", requisicionDet.getcantPendCompra());
	    if (requisicionDet.getProducto().getUm_cpra()!=null)
	    	dataset.fieldValue("oid_um", requisicionDet.getProducto().getUm_cpra().getOIDInteger());
	    else
	    	dataset.fieldValue("oid_um", "");
	    dataset.fieldValue("fec_requerida", requisicionDet.getFec_requerida());
	    
	    Proveedor proveedor = requisicionDet.getProveedor();
	    
	    if (proveedor == null) {
	    	ProductoProveedor productoProveedor = 
	    		requisicionDet.getProducto().getProveedorMenorPrioridad();
	    	if (productoProveedor!=null)
	    		proveedor = productoProveedor.getProveedor();
	    }
	    	
	    
	    if (proveedor!=null) {
	    	dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
	    	dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
	    	dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
	    } else {
	    	dataset.fieldValue("oid_proveedor", "");
	    	dataset.fieldValue("cod_proveedor", "");
	    	dataset.fieldValue("rs_proveedor", "");
	    }
	    dataset.fieldValue("referencia", requisicionDet.getRequisicion().getCodigo()+"/"+requisicionDet.getRenglon());
	    	
	  }
	  
	  private void cargarRegistroPedidoDet(IDataSet dataset,
	          PedidoDet pedidoDet) throws BaseException {
		  dataset.append();
		  dataset.fieldValue("oid_req_det", "");
		  dataset.fieldValue("oid_cco_req", "");
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
		  
		  Proveedor proveedor = null;
		  
		  if (proveedor!=null) {
			  dataset.fieldValue("oid_proveedor", proveedor.getOIDInteger());
			  dataset.fieldValue("cod_proveedor", proveedor.getCodigo());
			  dataset.fieldValue("rs_proveedor", proveedor.getRazonsocial());
		  } else {
			  dataset.fieldValue("oid_proveedor", "");
			  dataset.fieldValue("cod_proveedor", "");
			  dataset.fieldValue("rs_proveedor", "");
		  }
		  dataset.fieldValue("referencia", pedidoDet.getPedido().getCodigo()+"/"+pedidoDet.getNroRenglon());
		  
	  }
	  
  

  
}
