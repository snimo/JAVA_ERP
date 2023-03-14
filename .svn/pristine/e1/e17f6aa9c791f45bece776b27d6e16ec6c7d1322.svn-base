package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.RetCabIVA;
import com.srn.erp.pagos.bm.RetCabIVADet;
import com.srn.erp.pagos.da.DBRetCabIVADet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetCabIVADet extends FactoryObjetoLogico {

  public FactoryRetCabIVADet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetCabIVADet retcabivadet = (RetCabIVADet) objLog;
    retcabivadet.setOID(db.getInteger(DBRetCabIVADet.OID_RET_DET_IVA));
    retcabivadet.setRetcabiva(RetCabIVA.findByOidProxy(db.getInteger(DBRetCabIVADet.OID_RET_CAB_IVA),getSesion()));
    retcabivadet.setMontodesde(db.getMoney(DBRetCabIVADet.MONTO_DESDE));
    retcabivadet.setMontohasta(db.getMoney(DBRetCabIVADet.MONTO_HASTA));
    retcabivadet.setPorc(db.getMoney(DBRetCabIVADet.PORC));
    retcabivadet.setMontofijo(db.getMoney(DBRetCabIVADet.MONTO_FIJO));
  }
}
