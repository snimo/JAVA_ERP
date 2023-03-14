package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.GrabarStock;
import com.srn.erp.stock.bm.StockMovimiento;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class ReconstruirStockDesdeMov extends Operation {

  public ReconstruirStockDesdeMov() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	
	GrabarStock grabarStock = new GrabarStock(this.getSesion());
	grabarStock.borrarTablasStockParaReconsEnBaseAMovi(this.getSesion());
	Iterator iterMovStock = StockMovimiento.getAllMovimientosStock(this.getSesion()).iterator();
	while (iterMovStock.hasNext()) {
		StockMovimiento stockMov = (StockMovimiento) iterMovStock.next();
		grabarStock.actuSaldoProducto(stockMov);
	}
	
  }

}
