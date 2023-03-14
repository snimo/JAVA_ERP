package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OrdenDeCompraCab;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposOC extends Operation { 

  public TraerTiposOC() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
  	IDataSet ds = this.getDSTiposOC();
  	HashTableDatos tipos = OrdenDeCompraCab.getTiposOC();
  	Iterator iterTipos = tipos.keySet().iterator();
  	while (iterTipos.hasNext()) {
  		String codigo = (String) iterTipos.next();
  		String descripcion = tipos.getString(codigo);
  		cargarRegistro(ds,codigo,descripcion);
  	}
  	writeCliente(ds);
  }

  private IDataSet getDSTiposOC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposOC");
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
