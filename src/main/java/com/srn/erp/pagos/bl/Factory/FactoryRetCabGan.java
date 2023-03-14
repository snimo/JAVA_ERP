package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.bm.RetCabGan;
import com.srn.erp.pagos.da.DBRetCabGan;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetCabGan extends FactoryObjetoLogico {

  public FactoryRetCabGan() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetCabGan retcabgan = (RetCabGan) objLog;
    retcabgan.setOID(db.getInteger(DBRetCabGan.OID_RET_CAB_GAN));
    retcabgan.setCatretgan(CatRetGan.findByOidProxy(db.getInteger(DBRetCabGan.OID_CAT_RET_GAN),getSesion()));
    retcabgan.setConcimpu(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRetCabGan.OID_CONC_IMPU),getSesion()));
    retcabgan.setMontonoimpo(db.getMoney(DBRetCabGan.MONTO_NO_IMPO));
    retcabgan.setMontoretmin(db.getMoney(DBRetCabGan.MONTO_RET_MIN));
    retcabgan.setFecvigdesde(db.getDate(DBRetCabGan.FEC_VIG_DESDE));
    retcabgan.setActivo(db.getBoolean(DBRetCabGan.ACTIVO));

  }
}
