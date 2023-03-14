package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.ValorOrigenSubBien;
import com.srn.erp.bienUso.da.DBValorOrigenSubBien;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorOrigenSubBien extends FactoryObjetoLogico { 

  public FactoryValorOrigenSubBien() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValorOrigenSubBien valororigensubbien = (ValorOrigenSubBien) objLog;
    valororigensubbien.setOID(db.getInteger(DBValorOrigenSubBien.OID_BIEN_ALTA));
    valororigensubbien.setSistema_valuacion(SistemaValuacion.findByOidProxy(db.getInteger(DBValorOrigenSubBien.OID_SIST_VAL),getSesion()));
    valororigensubbien.setValor_origen(db.getMoney(DBValorOrigenSubBien.VALOR_ORIGEN));
  }
}
