package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AnuladorRequisicionCab;
import com.srn.erp.compras.bm.RequisicionCab;
import com.srn.erp.compras.da.DBAnuladorRequisicionCab;
import com.srn.erp.compras.da.DBRequisicionCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorRequisicionCab extends FactoryObjetoLogico { 

  public FactoryAnuladorRequisicionCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorRequisicionCab anuladorRequisicionCab = (AnuladorRequisicionCab) objLog;
    anuladorRequisicionCab.setOID(db.getInteger(DBAnuladorRequisicionCab.OID_ANU_REQ_CAB));
    anuladorRequisicionCab.setRequisicionCab(RequisicionCab.findByOidProxy(db.getInteger(DBRequisicionCab.OID_CCO_REQUI),getSesion()));
  }
}
