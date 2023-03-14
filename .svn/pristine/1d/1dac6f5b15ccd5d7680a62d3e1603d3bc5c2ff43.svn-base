package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.EstrucTableroTurnosCab;
import com.srn.erp.turnos.bm.EstrucTableroTurnosDet;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.da.DBEstrucTableroTurnosDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstrucTableroTurnosDet extends FactoryObjetoLogico { 

  public FactoryEstrucTableroTurnosDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstrucTableroTurnosDet estructableroturnosdet = (EstrucTableroTurnosDet) objLog;
    estructableroturnosdet.setOID(db.getInteger(DBEstrucTableroTurnosDet.OID_ESTRUC_DET));
    estructableroturnosdet.setEstruc_tab_cab(EstrucTableroTurnosCab.findByOidProxy(db.getInteger(DBEstrucTableroTurnosDet.OID_ESTRUC_TAB_TUR),getSesion()));
    estructableroturnosdet.setParte_tablero(ParteTablero.findByOidProxy(db.getInteger(DBEstrucTableroTurnosDet.OID_PARTE_TABLERO),getSesion()));
    estructableroturnosdet.setActivo(db.getBoolean(DBEstrucTableroTurnosDet.ACTIVO));
    estructableroturnosdet.setSecu(db.getInteger(DBEstrucTableroTurnosDet.SECU));

  }
}
