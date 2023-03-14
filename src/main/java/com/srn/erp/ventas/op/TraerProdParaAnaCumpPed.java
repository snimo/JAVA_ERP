package com.srn.erp.ventas.op;

import java.util.Iterator;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.IValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bm.Varios.CalculadorMoney;
import framework.applicarionServer.bm.Varios.Decimal;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerProdParaAnaCumpPed extends Operation {

  HashTableDatos productos = new HashTableDatos();
  ClasificadorEntidad clasificador = null;
	
  public TraerProdParaAnaCumpPed() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
    
	if (mapaDatos.containsKey("oid_clasificador")) {
		clasificador = ClasificadorEntidad.findByOid(mapaDatos.getInteger("oid_clasificador"), this.getSesion());
	}
	  
	List detallesPedidos = PedidoDet.getDetallesPendDesp(null, null, null,
				null, null, null, null, null, null, null, this.getSesion());
	
	Iterator iterDetallesPedidos =
		detallesPedidos.iterator();
	while (iterDetallesPedidos.hasNext()) {
		PedidoDet pedidoDet = (PedidoDet) iterDetallesPedidos.next();
		Decimal cantSinResNiSep = pedidoDet.getCantSinReserNiSepa();
		if (cantSinResNiSep.doubleValue() <= 0) continue;
		agregarProducto(pedidoDet);
	}
	
	IDataSet ds = this.getDataSetProdPedPendReserSep();
	
	Iterator iterProductos = 
		productos.keySet().iterator();
	while (iterProductos.hasNext()) {
		Integer oidProducto = (Integer) iterProductos.next();
		CalculadorMoney calcSaldo = (CalculadorMoney) productos.get(oidProducto);
		Producto producto = Producto.findByOid(oidProducto, this.getSesion());
		cargarRegistro(ds, producto , calcSaldo.getResultMoney());
	}
	
	writeCliente(ds);
	
  }
  
  private void agregarProducto(PedidoDet pedidoDet) throws BaseException {
	  CalculadorMoney calcSaldo = (CalculadorMoney)
	  		productos.get(pedidoDet.getProducto().getOIDInteger());
	  if (calcSaldo == null) { 
		  calcSaldo = new CalculadorMoney(new Money(0));
		  productos.put(pedidoDet.getProducto().getOIDInteger(), calcSaldo);
	  }
	  calcSaldo.sumar(pedidoDet.getCantSinReserNiSepa());
  }

  private IDataSet getDataSetProdPedPendReserSep() {
    IDataSet dataset = new TDataSet();
    dataset.create("TProdPedPendReserSep");
    dataset.fieldDef(new Field("agrupador", Field.STRING, 255));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("pend_res_o_sep", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         Producto producto,
                         Money cantPendResSep) throws BaseException {
	String agrupador = "";
    dataset.append();
    if (clasificador!=null) {
    	IValorClasificadorEntidad valorClasif = producto.getValorClasifEnt(clasificador);
    	if (valorClasif!=null)
    		agrupador = valorClasif.getDescripcion(); 
    	
    }
    dataset.fieldValue("agrupador", agrupador);
    dataset.fieldValue("oid_producto", producto.getOIDInteger());
    dataset.fieldValue("cod_producto", producto.getCodigo());
    dataset.fieldValue("desc_producto", producto.getDescripcion());
    dataset.fieldValue("pend_res_o_sep", cantPendResSep);
  }
}
