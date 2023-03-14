package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.RetCabIB;
import com.srn.erp.pagos.bm.RetCabIBDet;
import com.srn.erp.pagos.da.DBRetCabIBDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetCabIBDet extends FactoryObjetoLogico {

  public FactoryRetCabIBDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetCabIBDet retcabibdet = (RetCabIBDet) objLog;
    retcabibdet.setOID(db.getInteger(DBRetCabIBDet.OID_RET_DET_IB));
    retcabibdet.setRetcabib(RetCabIB.findByOidProxy(db.getInteger(DBRetCabIBDet.OID_RET_CAB_IB),getSesion()));
    retcabibdet.setMontodesde(db.getMoney(DBRetCabIBDet.MONTO_DESDE));
    retcabibdet.setMontohasta(db.getMoney(DBRetCabIBDet.MONTO_HASTA));
    retcabibdet.setPorc(db.getMoney(DBRetCabIBDet.PORC));
    retcabibdet.setMontofijo(db.getMoney(DBRetCabIBDet.MONTO_FIJO));

  }
}
