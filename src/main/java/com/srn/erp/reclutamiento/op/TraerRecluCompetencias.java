package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluCompetencias;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRecluCompetencias extends Operation { 

  public TraerRecluCompetencias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    RecluCompetencias reclucompetencias = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       reclucompetencias = RecluCompetencias.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       reclucompetencias = RecluCompetencias.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetRecluCompetencias = getDataSetRecluCompetencias();
    if (reclucompetencias != null) { 
        cargarRegistroRecluCompetencias(datasetRecluCompetencias, reclucompetencias);
    }
    writeCliente(datasetRecluCompetencias);
  }

  private IDataSet getDataSetRecluCompetencias() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecluCompetencias");
    dataset.fieldDef(new Field("oid_competencia", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_grupo_compe", Field.STRING, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecluCompetencias(IDataSet dataset, RecluCompetencias aRecluCompenetencia) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_competencia", aRecluCompenetencia.getOIDInteger());
    dataset.fieldValue("codigo", aRecluCompenetencia.getCodigo());
    dataset.fieldValue("descripcion", aRecluCompenetencia.getDescripcion());
    dataset.fieldValue("oid_grupo_compe", aRecluCompenetencia.getOid_grupo_compe().getOIDInteger());
    dataset.fieldValue("activo", aRecluCompenetencia.isActivo());
  }
}
