package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.MayorPeri;
import com.srn.erp.contabilidad.da.DBMayorPeri;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMayorPeri extends FactoryObjetoLogico {

  public FactoryMayorPeri() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MayorPeri mayorperi = (MayorPeri) objLog;
    mayorperi.setOID(db.getInteger(DBMayorPeri.OID_MAY_PERI));
    mayorperi.setCuentaImputable(
      CuentaImputable.findByOid(db.getInteger(DBMayorPeri.OID_ANA_IMP),getSesion()));
    mayorperi.setPeriodo(Periodo.findByOid(db.getInteger(DBMayorPeri.OID_PERI),getSesion()));
    mayorperi.setSigno(db.getInteger(DBMayorPeri.SIGNO));
    mayorperi.setCantidad(db.getInteger(DBMayorPeri.CANTIDAD));
    mayorperi.setImpoLocHist(db.getMoney(DBMayorPeri.IMPO_LOC_HIS));
    mayorperi.setImpoLocAju(db.getMoney(DBMayorPeri.IMPO_LOC_AJU));
    mayorperi.setImpoMonExt1(db.getMoney(DBMayorPeri.IMPO_MON_EXT_1));
    mayorperi.setImpoMonExt2(db.getMoney(DBMayorPeri.IMPO_MON_EXT_2));
  }
}
