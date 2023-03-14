package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.NovedadPayroll;
import com.srn.erp.cip.da.DBNovedadPayroll;

public class FactoryNovedadPayroll extends FactoryObjetoLogico { 

  public FactoryNovedadPayroll() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NovedadPayroll novedadpayroll = (NovedadPayroll) objLog;
    novedadpayroll.setOID(db.getInteger(DBNovedadPayroll.OID_TBCAS_NMO));
    novedadpayroll.setNmonovedad(db.getInteger(DBNovedadPayroll.NMONOVEDAD));
    novedadpayroll.setNmoordenpr(db.getInteger(DBNovedadPayroll.NMOORDENPR));
    novedadpayroll.setNmofecha(db.getDate(DBNovedadPayroll.NMOFECHA));
    novedadpayroll.setNmolegajo(db.getString(DBNovedadPayroll.NMOLEGAJO));
    novedadpayroll.setActivo(db.getBoolean(DBNovedadPayroll.ACTIVO));
    novedadpayroll.setNmoCex(db.getString(DBNovedadPayroll.NMOCEX));
  }
}
