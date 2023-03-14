package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AnuladorRequisicionCab;
import com.srn.erp.compras.bm.AnuladorRequisicionDet;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.da.DBAnuladorRequisicionDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorRequisicionDet extends FactoryObjetoLogico { 

  public FactoryAnuladorRequisicionDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorRequisicionDet anuladorrequisiciondet = (AnuladorRequisicionDet) objLog;
    anuladorrequisiciondet.setOID(db.getInteger(DBAnuladorRequisicionDet.OID_ANU_REQ_DET));
    anuladorrequisiciondet.setAnulador_req_cab(AnuladorRequisicionCab.findByOidProxy(db.getInteger(DBAnuladorRequisicionDet.OID_ANU_REQ_CAB),getSesion()));
    anuladorrequisiciondet.setRequisicion_det(RequisicionDet.findByOidProxy(db.getInteger(DBAnuladorRequisicionDet.OID_REQ_DET),getSesion()));

  }
}
