package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluGrupoCompe;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluCompetencias extends Operation { 

  public SaveRecluCompetencias() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluCompetencias"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluCompetencias reclucompetencias = RecluCompetencias.findByOid(dataset.getInteger("oid_competencia"),getSesion());
        reclucompetencias.setOID(dataset.getInteger("oid_competencia"));
        reclucompetencias.setCodigo(dataset.getString("codigo"));
        reclucompetencias.setDescripcion(dataset.getString("descripcion"));
        reclucompetencias.setOid_grupo_compe(RecluGrupoCompe.findByOidProxy(dataset.getInteger("oid_grupo_compe"),this.getSesion()));
        reclucompetencias.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclucompetencias);
        dataset.next();
    }
  }
  
}
