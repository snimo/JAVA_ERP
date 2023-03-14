package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.AccesoInternoPuerta;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerAccionAccIntPue extends Operation { 

  public TraerAccionAccIntPue() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetAcciones();
	  
	  Iterator iterCodigosAcciones = 
		  AccesoInternoPuerta.getAcciones().keySet().iterator();
	  while (iterCodigosAcciones.hasNext()) {
		  String codigo = (String)iterCodigosAcciones.next();
		  String descripcion = (String) AccesoInternoPuerta.getAcciones().get(codigo);
		  cargarAccion(ds, codigo, descripcion);
	  }
	  
	  writeCliente(ds);	  
    
  }

  private IDataSet getDataSetAcciones() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAcciones");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }
  
  private void cargarAccion(
		  IDataSet ds,
		  String codigo,
		  String descripcion
		  ) throws BaseException {
	ds.append();
	ds.fieldValue("codigo", codigo);
	ds.fieldValue("descripcion", descripcion);
  }
  
}
