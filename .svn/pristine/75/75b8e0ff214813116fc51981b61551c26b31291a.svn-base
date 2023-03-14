package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.AtriCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposAtriCompoPresu extends Operation { 

  public TraerTiposAtriCompoPresu() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 

    IDataSet datasetTiposAtri = this.getDataSetTiposAtri();
    
    int secu = 0;
    HashTableDatos htTiposAtri = AtriCompoPresu.getTiposAtributos();
    Iterator iterTiposAtri = htTiposAtri.keySet().iterator();
    while (iterTiposAtri.hasNext()) {
    	++secu;
    	String codigo = (String) iterTiposAtri.next();
    	String descripcion = htTiposAtri.getString(codigo);
    	cargarRegistroTiposAtri(datasetTiposAtri,new Integer(secu),codigo,descripcion,new Boolean(true));
    }
    
    writeCliente(datasetTiposAtri);
  }

  private IDataSet getDataSetTiposAtri() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposAtri");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 30)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroTiposAtri(IDataSet dataset, 
                         Integer oid,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid", oid);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
