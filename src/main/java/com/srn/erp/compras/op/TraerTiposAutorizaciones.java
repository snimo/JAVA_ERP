package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.AutorizadorRequisicion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAutorizaciones extends Operation { 

  public TraerTiposAutorizaciones() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	int oid = 0;
	IDataSet dsTipoAutoriz = getDataSetTipoAutoriz();
    Iterator iterCodigos = AutorizadorRequisicion.getTiposAutorizaciones().keySet().iterator();
    while (iterCodigos.hasNext()) {
      String codigo = (String) iterCodigos.next();
      String descripcion = (String) AutorizadorRequisicion.getTiposAutorizaciones().get(codigo);
      ++oid;
      cargarRegistroTipoAutoriz(dsTipoAutoriz, new Integer(oid),codigo,descripcion);
    }
    writeCliente(dsTipoAutoriz);
  }

  private IDataSet getDataSetTipoAutoriz() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoAutorizacion");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    return dataset;
  }

  private void cargarRegistroTipoAutoriz(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid",oid);
    dataset.fieldValue("codigo",codigo);
    dataset.fieldValue("descripcion",descripcion);
  }  
  
  
}
