package com.srn.erp.costos.op;

import com.srn.erp.costos.bm.ValorizarMovStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class GeneracionAsientoCostos extends Operation { 

  public GeneracionAsientoCostos() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds = mapaDatos.getDataSet("TAsientoCosto");
	procesar(ds);
  }
  
  private void procesar(IDataSet ds) throws BaseException {
	  
	  ds.first();
	  while (!ds.EOF()) {
		  
		  java.util.Date fecDesde = ds.getDate("fec_desde");
		  java.util.Date fecHasta = ds.getDate("fec_hasta");
		  java.util.Date fecCosto = ds.getDate("fec_costo");
		  
		
		  // Valorizar los Movimientos de Stock
		  ValorizarMovStock valorizarMovStock = new ValorizarMovStock(this.getSesion());
		  valorizarMovStock.setFecDesde(fecDesde);
		  valorizarMovStock.setFecHasta(fecHasta);
		  valorizarMovStock.valorizar();
		  
		  
		  
		  ds.next();  
	  }
	  
	   
	  
  }

  
  
}
