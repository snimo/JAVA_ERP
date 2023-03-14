package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.RetCabGan;
import com.srn.erp.pagos.bm.RetCabGanDet;
import com.srn.erp.pagos.da.DBRetCabGanDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetCabGanDet extends FactoryObjetoLogico {

  public FactoryRetCabGanDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetCabGanDet retcabgandet = (RetCabGanDet) objLog;
    retcabgandet.setOID(db.getInteger(DBRetCabGanDet.OID_RET_DET_GAN));
    retcabgandet.setRetcabgan(RetCabGan.findByOidProxy(db.getInteger(DBRetCabGanDet.OID_RET_CAB_GAN),getSesion()));
    retcabgandet.setMontodesde(db.getMoney(DBRetCabGanDet.MONTO_DESDE));
    retcabgandet.setMontohasta(db.getMoney(DBRetCabGanDet.MONTO_HASTA));
    retcabgandet.setPorc(db.getMoney(DBRetCabGanDet.PORC));
    retcabgandet.setMontofijo(db.getMoney(DBRetCabGanDet.MONTO_FIJO));
  }
}
