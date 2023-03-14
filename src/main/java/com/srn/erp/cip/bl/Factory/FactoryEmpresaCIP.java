package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.EmpresaCIP;
import com.srn.erp.cip.da.DBEmpresaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEmpresaCIP extends FactoryObjetoLogico { 

  public FactoryEmpresaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EmpresaCIP empresacip = (EmpresaCIP) objLog;
    empresacip.setOID(db.getInteger(DBEmpresaCIP.OID_EMPRESA));
    empresacip.setRazon_social(db.getString(DBEmpresaCIP.RAZON_SOCIAL));
    empresacip.setActivo(db.getBoolean(DBEmpresaCIP.ACTIVO));

  }
}
