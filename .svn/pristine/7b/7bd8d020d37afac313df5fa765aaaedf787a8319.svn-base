package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.RevaluoValorOrigenSubBien;
import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.da.DBRevaluoValorOrigenSubBien;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRevaluoValorOrigenSubBien extends FactoryObjetoLogico { 

  public FactoryRevaluoValorOrigenSubBien() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RevaluoValorOrigenSubBien revaluoValororigensubbien = (RevaluoValorOrigenSubBien) objLog;
    revaluoValororigensubbien.setOID(db.getInteger(DBRevaluoValorOrigenSubBien.OID_BIEN_ALTA));
    revaluoValororigensubbien.setSistema_valuacion(SistemaValuacion.findByOidProxy(db.getInteger(DBRevaluoValorOrigenSubBien.OID_SIST_VAL),getSesion()));
    revaluoValororigensubbien.setRevaluo_Valor_origen(db.getMoney(DBRevaluoValorOrigenSubBien.REVALUO_VALOR_ORIGEN));
  }
}
