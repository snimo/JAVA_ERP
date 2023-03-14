package com.srn.erp.produccion.bl.Factory;

import com.srn.erp.produccion.bm.NecMatOperAltFab;
import com.srn.erp.produccion.bm.OperAlterFab;
import com.srn.erp.produccion.bm.RecetaDet;
import com.srn.erp.produccion.da.DBNecMatOperAltFab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNecMatOperAltFab extends FactoryObjetoLogico { 

  public FactoryNecMatOperAltFab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NecMatOperAltFab necmatoperaltfab = (NecMatOperAltFab) objLog;
    necmatoperaltfab.setOID(db.getInteger(DBNecMatOperAltFab.OID_NECE_MAT_OPER));
    necmatoperaltfab.setOper_alt_fab(OperAlterFab.findByOidProxy(db.getInteger(DBNecMatOperAltFab.OID_OPER_FABRI),getSesion()));
    necmatoperaltfab.setReceta_det(RecetaDet.findByOidProxy(db.getInteger(DBNecMatOperAltFab.OID_REC_DET),getSesion()));
    necmatoperaltfab.setActivo(db.getBoolean(DBNecMatOperAltFab.ACTIVO));

  }
}
