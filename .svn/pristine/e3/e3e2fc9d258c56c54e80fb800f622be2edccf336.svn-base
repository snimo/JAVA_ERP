package com.srn.erp.general.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.general.bm.LogsArchivo;
import com.srn.erp.general.da.DBLogsArchivo;

public class FactoryLogsArchivo extends FactoryObjetoLogico { 

  public FactoryLogsArchivo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LogsArchivo logsarchivo = (LogsArchivo) objLog;
   logsarchivo.setOID(db.getInteger(DBLogsArchivo.OID_LOG));
    logsarchivo.setCodigo(db.getString(DBLogsArchivo.CODIGO));
    logsarchivo.setDescripcion(db.getString(DBLogsArchivo.DESCRIPCION));
    logsarchivo.setActivo(db.getBoolean(DBLogsArchivo.ACTIVO));

  }
}
