package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.DireccionesPtoAccesoCIP;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDireccionesPtoAccesoCIP extends Operation { 

  public TraerDireccionesPtoAccesoCIP() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetDirecciones();
	  Iterator iterDirecciones = 
		  DireccionesPtoAccesoCIP.getDirecciones().keySet().iterator();
	  while (iterDirecciones.hasNext()) {
		  Integer codigo = (Integer) iterDirecciones.next();
		  String descripcion = (String) DireccionesPtoAccesoCIP.getDirecciones().get(codigo);
		  cargarRegistro(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDataSetDirecciones() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDirecciones");
    dataset.fieldDef(new Field("codigo", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         Integer codigo,
                         String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
