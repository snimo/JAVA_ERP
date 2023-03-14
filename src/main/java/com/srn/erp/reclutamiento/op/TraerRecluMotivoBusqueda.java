package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluMotivoBusqueda;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluMotivoBusqueda extends Operation { 

  public TraerRecluMotivoBusqueda() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluMotivoBusqueda reclumotivobusqueda = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclumotivobusqueda = RecluMotivoBusqueda.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclumotivobusqueda = RecluMotivoBusqueda.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluMotivoBusqueda = getDataSetRecluMotivoBusqueda();
    if (reclumotivobusqueda != null) { 
        cargarRegistroRecluMotivoBusqueda(datasetRecluMotivoBusqueda,reclumotivobusqueda);
    }
    writeCliente(datasetRecluMotivoBusqueda);
  }

  private IDataSet getDataSetRecluMotivoBusqueda() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluMotivoBusqueda");
    dataset.fieldDef(new Field("oid_motivo_busq", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluMotivoBusqueda(IDataSet dataset, 
		  				 RecluMotivoBusqueda aRecluMotivoBusqueda) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_motivo_busq", aRecluMotivoBusqueda.getOIDInteger());
    dataset.fieldValue("codigo", aRecluMotivoBusqueda.getCodigo());
    dataset.fieldValue("descripcion", aRecluMotivoBusqueda.getDescripcion());
    dataset.fieldValue("activo", aRecluMotivoBusqueda.isActivo());
  }
}
