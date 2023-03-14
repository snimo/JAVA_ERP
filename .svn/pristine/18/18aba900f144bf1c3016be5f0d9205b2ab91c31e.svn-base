package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AnuladorInfCC;
import com.srn.erp.compras.bm.InformeControlCalidad;
import com.srn.erp.compras.da.DBAnuladorInfCC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorInfCC extends FactoryObjetoLogico { 

  public FactoryAnuladorInfCC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorInfCC anuladorinfcc = (AnuladorInfCC) objLog;
    anuladorinfcc.setOID(db.getInteger(DBAnuladorInfCC.OID_ANU_CC));
    anuladorinfcc.setControl_calidad(InformeControlCalidad.findByOidProxy(db.getInteger(DBAnuladorInfCC.OID_CC),getSesion()));

  }
}
