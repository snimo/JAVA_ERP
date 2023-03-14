package com.srn.erp.payroll.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.payroll.bm.PayTipoAusencias;
import com.srn.erp.payroll.da.DBPayTipoAusencias;

public class FactoryPayTipoAusencias extends FactoryObjetoLogico { 

  public FactoryPayTipoAusencias() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PayTipoAusencias paytipoausencias = (PayTipoAusencias) objLog;
    paytipoausencias.setCodigo(db.getInteger(DBPayTipoAusencias.CODIGO));
    paytipoausencias.setCotab(db.getInteger(DBPayTipoAusencias.COTAB));
    paytipoausencias.setDescrip(db.getString(DBPayTipoAusencias.DESCRIP));

  }
}
