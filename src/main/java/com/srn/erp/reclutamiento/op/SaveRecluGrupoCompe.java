package com.srn.erp.reclutamiento.op;

import com.srn.erp.reclutamiento.bm.RecluGrupoCompe;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveRecluGrupoCompe extends Operation { 

  public SaveRecluGrupoCompe() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TRecluGrupoCompe"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        RecluGrupoCompe reclugrupocompe = RecluGrupoCompe.findByOid(dataset.getInteger("oid_grupo_compe"),getSesion());
        reclugrupocompe.setOID(dataset.getInteger("oid_grupo_compe"));
        reclugrupocompe.setCodigo(dataset.getString("codigo"));
        reclugrupocompe.setDescripcion(dataset.getString("descripcion"));
        reclugrupocompe.setActivo(dataset.getBoolean("activo"));
        addTransaccion(reclugrupocompe);
        dataset.next();
    }
  }
  
}
