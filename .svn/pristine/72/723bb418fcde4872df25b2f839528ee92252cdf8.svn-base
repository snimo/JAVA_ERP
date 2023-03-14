package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CajaCierreApertura;
import com.srn.erp.tesoreria.da.DBCajaCierreApertura;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCajaCierreApertura extends FactoryObjetoLogico {

  public FactoryCajaCierreApertura() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CajaCierreApertura cajacierreapertura = (CajaCierreApertura) objLog;
    cajacierreapertura.setOID(db.getInteger(DBCajaCierreApertura.OID_CAJA_APE_CIE));
    cajacierreapertura.setCaja(Caja.findByOidProxy(db.getInteger(DBCajaCierreApertura.OID_CAJA),getSesion()));
    cajacierreapertura.setFeccierreant(db.getDate(DBCajaCierreApertura.FEC_CIE_ANT));
    cajacierreapertura.setNuefecaper(db.getDate(DBCajaCierreApertura.NUE_FEC_APER));
    cajacierreapertura.setActivo(db.getBoolean(DBCajaCierreApertura.ACTIVO));
  }
}
