package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluPuesto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluPuesto extends Operation { 

  public TraerRecluPuesto() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluPuesto reclupuesto = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclupuesto = RecluPuesto.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclupuesto = RecluPuesto.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluPuesto = getDataSetRecluPuesto();
    if (reclupuesto != null)  
        cargarRegistroRecluPuesto(datasetRecluPuesto, reclupuesto);
    writeCliente(datasetRecluPuesto);
  }

  private IDataSet getDataSetRecluPuesto() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluPuesto");
    dataset.fieldDef(new Field("oid_puesto_busqueda", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluPuesto(IDataSet dataset,RecluPuesto recluPuesto) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_puesto_busqueda", recluPuesto.getOIDInteger());
    dataset.fieldValue("codigo", recluPuesto.getCodigo());
    dataset.fieldValue("descripcion", recluPuesto.getDescripcion());
    dataset.fieldValue("activo", recluPuesto.isActivo());
  }
}
