package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.bm.RetCabIB;
import com.srn.erp.pagos.da.DBRetCabIB;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetCabIB extends FactoryObjetoLogico {

  public FactoryRetCabIB() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetCabIB retcabib = (RetCabIB) objLog;
    retcabib.setOID(db.getInteger(DBRetCabIB.OID_RET_CAB_IB));
    retcabib.setCatretIB(CatRetIB.findByOidProxy(db.getInteger(DBRetCabIB.OID_CAT_RET_IB),getSesion()));
    retcabib.setConcimpu(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRetCabIB.OID_CONC_IMPU),getSesion()));
    retcabib.setMontonoimpo(db.getMoney(DBRetCabIB.MONTO_NO_IMPO));
    retcabib.setMontoretmin(db.getMoney(DBRetCabIB.MONTO_RET_MIN));
    retcabib.setFecvigdesde(db.getDate(DBRetCabIB.FEC_VIG_DESDE));
    retcabib.setActivo(db.getBoolean(DBRetCabIB.ACTIVO));
  }
}
