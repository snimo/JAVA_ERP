package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStkProdPorEstado;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEstadosStockDepoProd extends Operation {

  public TraerEstadosStockDepoProd() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
   
	  
	Deposito deposito = Deposito.findByOidProxy(mapaDatos.getInteger("oid_deposito"), this.getSesion());
	Producto producto = Producto.findByOidProxy(mapaDatos.getInteger("oid_producto"), this.getSesion());

	IDataSet ds = getDataSet();
	
	Iterator iterEstadosDepo =
		SaldoStkProdPorEstado.getSaldosPorEstados(producto, deposito, this.getSesion()).iterator();
	  
	while (iterEstadosDepo.hasNext()) {
		SaldoStkProdPorEstado saldo = (SaldoStkProdPorEstado) iterEstadosDepo.next();
		cargarRegistro(ds, saldo.getEstado_stock().getOIDInteger(), saldo.getSaldo());
	}
	
    writeCliente(ds);
  }

  private IDataSet getDataSet() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEstStkProdDepo");
    dataset.fieldDef(new Field("oid_estado", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
                         Integer oidEstado,
                         Double cantidad) {
    dataset.append();
    dataset.fieldValue("oid_estado", oidEstado);
    dataset.fieldValue("cantidad", cantidad);
  }
}
