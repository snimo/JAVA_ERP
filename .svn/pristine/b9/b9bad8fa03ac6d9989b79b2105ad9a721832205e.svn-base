package com.srn.erp.general.op;

import java.util.Iterator;

import com.srn.erp.general.bm.TiposComprobantesEtiquetas;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTiposComproParaEtiquetas extends Operation { 

  public TraerTiposComproParaEtiquetas() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = this.getDataSet();
   
    int secu = 1;
    Iterator iterTiposComproEtiquetas = 
    	TiposComprobantesEtiquetas.getTipos().keySet().iterator();
    while (iterTiposComproEtiquetas.hasNext()) {
    	String codigo = (String) iterTiposComproEtiquetas.next();
    	String descripcion = (String)TiposComprobantesEtiquetas.getTipos().getString(codigo);
    	cargarRegistro(dataset,new Integer(secu),codigo,descripcion);
    	++secu;
    }
        
    writeCliente(dataset);
  }

  private IDataSet getDataSet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTiposComproEtiquetas");
    dataset.fieldDef(new Field("oid", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         Integer secu,
                         String codigo,
                         String descripcion) {
    dataset.append(); 
    dataset.fieldValue("oid", secu);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
    
}
