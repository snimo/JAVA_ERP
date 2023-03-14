package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.LogImpSujTurno;
import com.srn.erp.turnos.da.DBLogImpSujTurno;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLogImpSujTurno extends FactoryObjetoLogico { 

  public FactoryLogImpSujTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LogImpSujTurno logimpsujturno = (LogImpSujTurno) objLog;
    logimpsujturno.setOID(db.getInteger(DBLogImpSujTurno.OID));
    logimpsujturno.setDescripcion(db.getString(DBLogImpSujTurno.DESCRIPCION));
    logimpsujturno.setFecha(db.getDate(DBLogImpSujTurno.FECHA));

  }
}
