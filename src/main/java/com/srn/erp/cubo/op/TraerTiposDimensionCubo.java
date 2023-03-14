package com.srn.erp.cubo.op;

import java.util.Iterator;

import com.srn.erp.cubo.bm.DimensionCubo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposDimensionCubo extends Operation { 

  public TraerTiposDimensionCubo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet datasetTipos = getDataSetTipos();
    HashTableDatos tipos = DimensionCubo.getTipos();
    int secu = 0;
    Iterator iterTipos = tipos.keySet().iterator();
    while (iterTipos.hasNext()) {
    	String codigo = (String) iterTipos.next();
    	String descripcion = (String) tipos.get(codigo);
    	cargarRegistroTipo(datasetTipos,new Integer(++secu),codigo,descripcion);
    }
    writeCliente(datasetTipos);
  }

  private IDataSet getDataSetTipos() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposDimension");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    return dataset;
  }

  private void cargarRegistroTipo(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
}
