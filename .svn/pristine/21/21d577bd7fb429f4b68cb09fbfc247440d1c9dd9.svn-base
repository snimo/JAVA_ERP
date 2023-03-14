package com.srn.erp.payroll.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.payroll.bm.PayPuesto;
import com.srn.erp.payroll.da.DBPayPuesto;

public class FactoryPayPuesto extends FactoryObjetoLogico { 

  public FactoryPayPuesto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PayPuesto paypuesto = (PayPuesto) objLog;
    paypuesto.setCodigo(db.getInteger(DBPayPuesto.CODIGO));
    paypuesto.setDescripcion(db.getString(DBPayPuesto.DESCRIP));

  }
}
