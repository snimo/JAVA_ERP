package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.AnuladorAsientoManual;
import com.srn.erp.contabilidad.bm.AnuladorAsientoManualDet;
import com.srn.erp.contabilidad.bm.AsientoManualDet;
import com.srn.erp.contabilidad.da.DBAnuladorAsientoManualDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuladorAsientoManualDet extends FactoryObjetoLogico { 

  public FactoryAnuladorAsientoManualDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuladorAsientoManualDet anuladorasientomanualdet = (AnuladorAsientoManualDet) objLog;
    anuladorasientomanualdet.setOID(db.getInteger(DBAnuladorAsientoManualDet.OID_ASI_MAN_DET));
    anuladorasientomanualdet.setAnulador_asiento_manual(AnuladorAsientoManual.findByOidProxy(db.getInteger(DBAnuladorAsientoManualDet.OID_CAB_ASI_MAN),getSesion()));
    anuladorasientomanualdet.setDet_asiento_manual(AsientoManualDet.findByOidProxy(db.getInteger(DBAnuladorAsientoManualDet.OID_DCO),getSesion()));

  }
}
