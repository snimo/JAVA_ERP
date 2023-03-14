package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.IDataSet;

public class SaveLogsArchivo extends Operation { 

  public SaveLogsArchivo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TLogsArchivo"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        LogsArchivo logsarchivo = LogsArchivo.findByOid(dataset.getInteger("oid_log"),getSesion());
        logsarchivo.setOID(dataset.getInteger("oid_log"));
        logsarchivo.setCodigo(dataset.getString("codigo"));
        logsarchivo.setDescripcion(dataset.getString("descripcion"));
        logsarchivo.setActivo(dataset.getBoolean("activo"));
        addTransaccion(logsarchivo);
        dataset.next();
    }
  }
  
}
