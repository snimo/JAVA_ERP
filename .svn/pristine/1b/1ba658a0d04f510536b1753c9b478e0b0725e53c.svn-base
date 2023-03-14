package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AnuladorInfRec;
import com.srn.erp.compras.bm.AnuladorInfRecDet;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.da.DBAnuladorInfRecDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorInfRecDet extends FactoryObjetoLogico { 

  public FactoryAnuladorInfRecDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorInfRecDet anuladorinfrecdet = (AnuladorInfRecDet) objLog;
    anuladorinfrecdet.setOID(db.getInteger(DBAnuladorInfRecDet.OID_ANU_DET_REC));
    anuladorinfrecdet.setAnulador_inf_rec(AnuladorInfRec.findByOidProxy(db.getInteger(DBAnuladorInfRecDet.OID_ANU_INF_REC),getSesion()));
    anuladorinfrecdet.setInf_rec_det(InformeRecepcionDet.findByOidProxy(db.getInteger(DBAnuladorInfRecDet.OID_INF_REC_DET),getSesion()));

  }
}
