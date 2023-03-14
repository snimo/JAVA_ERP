package com.srn.erp.general.op;

import com.srn.erp.general.bm.*;
import framework.request.bl.Operaciones.*;
import framework.request.bl.Tablas.*;
import framework.request.bl.Utils.*;
import framework.request.bl.XML.*;

public class TraerLogsArchivo extends Operation { 

  public TraerLogsArchivo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    LogsArchivo logsarchivo = null;
    if (mapaDatos.containsKey("oid")) { 
       Integer oid = mapaDatos.getInteger("oid"); 
       logsarchivo = LogsArchivo.findByOid(oid, getSesion()); 
    } 
    else { 
       String codigo = mapaDatos.getString("codigo"); 
       logsarchivo = LogsArchivo.findByCodigo(codigo, getSesion()); 
    } 

    IDataSet datasetLogsArchivo = getDataSetLogsArchivo();
    if (logsarchivo != null) { 
        cargarRegistroLogsArchivo(datasetLogsArchivo, 
                         logsarchivo.getOIDInteger(),
                         logsarchivo.getCodigo(),
                         logsarchivo.getDescripcion(),
                         logsarchivo.isActivo());
    }
    writeCliente(datasetLogsArchivo);
  }

  private IDataSet getDataSetLogsArchivo() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TLogsArchivo");
    dataset.fieldDef(new Field("oid_log", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroLogsArchivo(IDataSet dataset, 
                         Integer oid_log,
                         String codigo,
                         String descripcion,
                         Boolean activo) {
    dataset.append(); 
    dataset.fieldValue("oid_log", oid_log);
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
    dataset.fieldValue("activo", activo);
  }
}
