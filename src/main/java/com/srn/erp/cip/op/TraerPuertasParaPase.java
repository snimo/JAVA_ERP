package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.Puerta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPuertasParaPase extends Operation { 

  public TraerPuertasParaPase() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetPuertasParaPase();
	  Iterator iterPuertasActivas =
		  Puerta.getPuertasActivas(this.getSesion()).iterator();
	  while (iterPuertasActivas.hasNext()) {
		  Puerta puerta = (Puerta) iterPuertasActivas.next();
		  cargarPuerta(ds, puerta);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDataSetPuertasParaPase() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPuertasPase");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarPuerta(IDataSet dataset, 
                         Puerta puerta) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid", puerta.getOIDInteger());
    dataset.fieldValue("codigo", puerta.getCodigo());
    dataset.fieldValue("descripcion", puerta.getDescripcion());
  }
}
