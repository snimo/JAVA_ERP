package com.srn.erp.ventas.op;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.GrabarStock;
import com.srn.erp.stock.bm.ManejadorReservasPedido;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ReservarProdDetPedido extends Operation {

  public ReservarProdDetPedido() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
	Deposito deposito   = Deposito.findByOidProxy(mapaDatos.getInteger("oid_deposito"), this.getSesion());
	Producto producto   = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), this.getSesion());
	PedidoDet pedidoDet = PedidoDet.findByOid(mapaDatos.getInteger("oid_ped_det"), this.getSesion());
	Double cantidad     = mapaDatos.getDouble("cantidad");
	  
	ManejadorReservasPedido manejadorReserva = new ManejadorReservasPedido();
	manejadorReserva.setSesion(this.getSesion());
	manejadorReserva.setComproCab(pedidoDet.getPedido());
	manejadorReserva.setDeposito(deposito);
	manejadorReserva.setProducto(producto);
	manejadorReserva.setPedidoDet(pedidoDet);
	manejadorReserva.setCantidad(cantidad);
	
	GrabarStock grabarStock = new GrabarStock(getSesion());
	grabarStock.setStockeable(manejadorReserva);
	grabarStock.save();
	
  }

}
