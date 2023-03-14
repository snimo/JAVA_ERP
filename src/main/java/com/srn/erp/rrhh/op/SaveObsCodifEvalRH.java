package com.srn.erp.rrhh.op;

import com.srn.erp.rrhh.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveObsCodifEvalRH extends Operation { 

  public SaveObsCodifEvalRH() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TObsCodifEvalRH"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        ObsCodifEvalRH obscodifevalrh = ObsCodifEvalRH.findByOid(dataset.getInteger("oid_obs_codif"),getSesion());
        obscodifevalrh.setOID(dataset.getInteger("oid_obs_codif"));
        obscodifevalrh.setCodigo(dataset.getString("codigo"));
        obscodifevalrh.setDescripcion(dataset.getString("descripcion"));
        obscodifevalrh.setActivo(dataset.getBoolean("activo"));
        addTransaccion(obscodifevalrh);
        dataset.next();
    }
  }
  
}
