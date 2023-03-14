package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.Diario;
import com.srn.erp.contabilidad.bm.MayorDia;
import com.srn.erp.contabilidad.bm.MayorPeri;
import com.srn.erp.contabilidad.da.DBMayorDia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMayorDia extends FactoryObjetoLogico {

  public FactoryMayorDia() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MayorDia mayordia = (MayorDia) objLog;
    mayordia.setOID(db.getInteger(DBMayorDia.OID_MAY_DIA));
    mayordia.setDiario(Diario.findByOidProxy(db.getInteger(DBMayorDia.OID_DIARIO),getSesion()));
    mayordia.setCuentaimputable(CuentaImputable.findByOidProxy(db.getInteger(DBMayorDia.OID_AI),getSesion()));
    mayordia.setImputac(db.getDate(DBMayorDia.IMPUTAC));
    mayordia.setSigno(db.getInteger(DBMayorDia.SIGNO));
    mayordia.setCantidad(db.getInteger(DBMayorDia.CANTIDAD));
    mayordia.setImpoLocHist(db.getMoney(DBMayorDia.IMPO_LOC_HIST));
    mayordia.setImpoLocAju(db.getMoney(DBMayorDia.IMPO_LOC_AJU));
    mayordia.setImpoMonExt1(db.getMoney(DBMayorDia.IMPO_MON_EXT_1));
    mayordia.setImpoMonExt2(db.getMoney(DBMayorDia.IMPO_MON_EXT_2));
    mayordia.setMayorPeri(MayorPeri.findByOidProxy(db.getInteger(DBMayorDia.OID_MAYOR_PERI),getSesion()));

  }
}
