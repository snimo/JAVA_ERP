package com.srn.erp.payroll.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.payroll.bm.PayEstado;
import com.srn.erp.payroll.da.DBPayEstado;

public class FactoryPayEstado extends FactoryObjetoLogico { 

  public FactoryPayEstado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PayEstado payestado = (PayEstado) objLog;
    payestado.setEstado(db.getString(DBPayEstado.ESTADO));

  }
}
