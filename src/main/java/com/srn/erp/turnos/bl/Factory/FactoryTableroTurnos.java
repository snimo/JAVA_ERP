package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.TableroTurnos;
import com.srn.erp.turnos.da.DBTableroTurnos;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTableroTurnos extends FactoryObjetoLogico { 

  public FactoryTableroTurnos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TableroTurnos tableroturnos = (TableroTurnos) objLog;
    tableroturnos.setOID(db.getInteger(DBTableroTurnos.OID_TABLERO_CAB));
    tableroturnos.setDescripcion(db.getString(DBTableroTurnos.DESCRIPCION));
    tableroturnos.setFecha(db.getDate(DBTableroTurnos.FECHA));
    tableroturnos.setComportamiento(db.getString(DBTableroTurnos.COMPORTAMIENTO));
    tableroturnos.setReglamentoActivo(db.getBoolean(DBTableroTurnos.REGLA_ACTIVO));
    tableroturnos.setLectorActivo(db.getBoolean(DBTableroTurnos.LECTOR_ACTIVO));
  }
}
