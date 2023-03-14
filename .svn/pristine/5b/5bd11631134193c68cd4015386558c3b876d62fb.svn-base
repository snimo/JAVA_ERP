package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.pagos.bm.CatRetIVA;
import com.srn.erp.pagos.bm.RetCabIVA;
import com.srn.erp.pagos.da.DBRetCabIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRetCabIVA extends FactoryObjetoLogico {

  public FactoryRetCabIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RetCabIVA retcabiva = (RetCabIVA) objLog;
    retcabiva.setOID(db.getInteger(DBRetCabIVA.OID_RET_CAB_IVA));
    retcabiva.setCatretiva(CatRetIVA.findByOidProxy(db.getInteger(DBRetCabIVA.OID_CAT_RET_IVA),getSesion()));
    retcabiva.setConcimpu(ConceptoImpuesto.findByOidProxy(db.getInteger(DBRetCabIVA.OID_CONC_IMPU),getSesion()));
    retcabiva.setMontonoimpo(db.getMoney(DBRetCabIVA.MONTO_NO_IMPO));
    retcabiva.setMontoretmin(db.getMoney(DBRetCabIVA.MONTO_RET_MIN));
    retcabiva.setFecvigdesde(db.getDate(DBRetCabIVA.FEC_VIG_DESDE));
    retcabiva.setActivo(db.getBoolean(DBRetCabIVA.ACTIVO));

  }
}
