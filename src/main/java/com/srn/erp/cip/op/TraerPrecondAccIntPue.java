package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.AccesoInternoPuerta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerPrecondAccIntPue extends Operation { 

  public TraerPrecondAccIntPue() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetPrecondiciones();
	  
	  Iterator iterCodigosPrecond = 
		  AccesoInternoPuerta.getPrecondiciones().keySet().iterator();
	  while (iterCodigosPrecond.hasNext()) {
		  String codigo = (String)iterCodigosPrecond.next();
		  String descripcion = (String) AccesoInternoPuerta.getPrecondiciones().get(codigo);
		  cargarRegistro(ds, codigo, descripcion);
	  }
	  
	  writeCliente(ds);
		  
  }

  private IDataSet getDataSetPrecondiciones() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TPrecondiciones");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistro(
		  IDataSet dataset, 
          String codigo,
          String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
