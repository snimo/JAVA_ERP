package com.srn.erp.stock.op;

import java.util.Iterator;

import com.srn.erp.stock.bm.ConfConsGenStock;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerConsConfStock extends Operation {

  public TraerConsConfStock() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {

    IDataSet ds = this.getDataSet();
	  
	Iterator iterAllActivos = 
		ConfConsGenStock.getAllActivos(this.getSesion()).iterator();
	while (iterAllActivos.hasNext()) {
		ConfConsGenStock confConsGenStock = (ConfConsGenStock) iterAllActivos.next();
		cargarRegistro(ds, confConsGenStock);
	}
	
	writeCliente(ds);
	  
  }


  private IDataSet getDataSet() {
	    IDataSet dataset = new TDataSet();
	    dataset.create("TConsConsStock");
	    dataset.fieldDef(new Field("oid", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("codigo", Field.STRING, 50));
	    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
	    return dataset;
	  }
  
  private void cargarRegistro(IDataSet dataset,
          					  ConfConsGenStock confCondGenStock) throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid", confCondGenStock.getOIDInteger());
	  dataset.fieldValue("codigo", confCondGenStock.getCodigo());
	  dataset.fieldValue("descripcion", confCondGenStock.getDescripcion());
  }
  


}
