package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.EmpresaPayroll;
import com.srn.erp.cip.da.DBEmpresaPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEmpresaPayroll extends FactoryObjetoLogico { 

  public FactoryEmpresaPayroll() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EmpresaPayroll empresapayroll = (EmpresaPayroll) objLog;
    empresapayroll.setOID(db.getInteger(DBEmpresaPayroll.OID_EMPRESA));
    empresapayroll.setEmpresa(db.getString(DBEmpresaPayroll.EMPRESA));
    empresapayroll.setNombre(db.getString(DBEmpresaPayroll.NOMBRE));
    empresapayroll.setActivo(db.getBoolean(DBEmpresaPayroll.ACTIVO));

  }
}
