package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluSelector;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluSelector extends Operation { 

  public TraerRecluSelector() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluSelector recluselector = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       recluselector = RecluSelector.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       recluselector = RecluSelector.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluSelector = getDataSetRecluSelector();
    if (recluselector != null)  
        cargarRegistroRecluSelector(datasetRecluSelector, recluselector);
    
    writeCliente(datasetRecluSelector);
  }

  private IDataSet getDataSetRecluSelector() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluSelector");
    dataset.fieldDef(new Field("oid_selector", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_usuario", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluSelector(IDataSet dataset, 
                         RecluSelector selector) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_selector", selector.getOIDInteger());
    dataset.fieldValue("codigo", selector.getCodigo());
    dataset.fieldValue("descripcion", selector.getDescripcion());
    if (selector.getUsuario()!=null)
    	dataset.fieldValue("oid_usuario", selector.getUsuario().getOIDInteger());
    else
    	dataset.fieldValue("oid_usuario", "");
    dataset.fieldValue("activo", selector.isActivo());
  }
}
