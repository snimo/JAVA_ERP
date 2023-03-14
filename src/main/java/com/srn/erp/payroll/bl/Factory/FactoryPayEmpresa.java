package com.srn.erp.payroll.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.payroll.bm.PayEmpresa;
import com.srn.erp.payroll.da.DBPayEmpresa;

public class FactoryPayEmpresa extends FactoryObjetoLogico { 

  public FactoryPayEmpresa() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PayEmpresa empresa = (PayEmpresa) objLog;
    empresa.setNombre(db.getString(DBPayEmpresa.NOMBRE));
    empresa.setEmpresa(db.getString(DBPayEmpresa.EMPRESA));

  }
}
