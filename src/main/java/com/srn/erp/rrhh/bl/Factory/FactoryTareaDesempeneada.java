package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.TareaDesempeneada;
import com.srn.erp.rrhh.da.DBTareaDesempeneada;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTareaDesempeneada extends FactoryObjetoLogico { 

  public FactoryTareaDesempeneada() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TareaDesempeneada tareadesempeneada = (TareaDesempeneada) objLog;
    tareadesempeneada.setOID(db.getInteger(DBTareaDesempeneada.OID_TAREA_DESEMP));
    tareadesempeneada.setCodigo(db.getString(DBTareaDesempeneada.CODIGO));
    tareadesempeneada.setDescripcion(db.getString(DBTareaDesempeneada.DESCRIPCION));
    tareadesempeneada.setActivo(db.getBoolean(DBTareaDesempeneada.ACTIVO));

  }
}
