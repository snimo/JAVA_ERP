package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TiposEntradasRotas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposEntradasRotas extends Operation { 

  public TraerTiposEntradasRotas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetTiposEntradas();
	  Iterator iterCodTiposEnt = 
		  TiposEntradasRotas.getTiposEntradas().keySet().iterator();
	  while (iterCodTiposEnt.hasNext()) {
		  String codigo = (String) iterCodTiposEnt.next();
		  String descripcion = (String) TiposEntradasRotas.getTiposEntradas().get(codigo);
		  cargarRegistroRotas(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDataSetTiposEntradas() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposEntradas");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistroRotas(IDataSet dataset, 
		  						   String codigo,
		  						   String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
