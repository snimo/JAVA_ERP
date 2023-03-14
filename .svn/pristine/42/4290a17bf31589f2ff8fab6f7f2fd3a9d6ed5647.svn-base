package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.TiposTarjetas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposTarjetas extends Operation { 

  public TraerTiposTarjetas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = getDataSetTiposTarjetas();
	  Iterator iterTiposTarjetas = 
		  TiposTarjetas.getTiposTarjetas().keySet().iterator();
	  while (iterTiposTarjetas.hasNext()) {
		  String codigo = (String) iterTiposTarjetas.next();
		  String descripcion = (String) TiposTarjetas.getTiposTarjetas().get(codigo);
		  cargarRegistro(ds, codigo, descripcion);
	  }
	  writeCliente(ds);
	  
  }

  private IDataSet getDataSetTiposTarjetas() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposTarjetas");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
		  					  String codigo,
		  					  String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
