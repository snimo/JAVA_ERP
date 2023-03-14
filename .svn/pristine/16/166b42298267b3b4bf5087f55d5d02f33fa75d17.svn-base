package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.RelaConcSujTur;
import com.srn.erp.turnos.da.DBRelaConcSujTur;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRelaConcSujTur extends FactoryObjetoLogico { 

  public FactoryRelaConcSujTur() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RelaConcSujTur relaconcsujtur = (RelaConcSujTur) objLog;
    relaconcsujtur.setOID(db.getInteger(DBRelaConcSujTur.OID_CONC_SUJ));
    relaconcsujtur.setConcepto(db.getString(DBRelaConcSujTur.CONCEPTO));
    relaconcsujtur.setNro_socio(db.getInteger(DBRelaConcSujTur.NRO_SOCIO));
    relaconcsujtur.setCantidad(db.getInteger(DBRelaConcSujTur.CANTIDAD));
    relaconcsujtur.setNumero(db.getInteger(DBRelaConcSujTur.NUMERO));
    relaconcsujtur.setDesde(db.getDate(DBRelaConcSujTur.DESDE));
    relaconcsujtur.setHasta(db.getDate(DBRelaConcSujTur.HASTA));

  }
}
