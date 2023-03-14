package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategEvenAccLegDet;
import com.srn.erp.cip.bm.CategEvenAccesoLeg;
import com.srn.erp.cip.da.DBCategEvenAccLegDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategEvenAccLegDet extends FactoryObjetoLogico { 

  public FactoryCategEvenAccLegDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategEvenAccLegDet categevenacclegdet = (CategEvenAccLegDet) objLog;
    categevenacclegdet.setOID(db.getInteger(DBCategEvenAccLegDet.OID_ACC_EVE_DET));
    categevenacclegdet.setCateg_eventual_leg(CategEvenAccesoLeg.findByOidProxy(db.getInteger(DBCategEvenAccLegDet.OID_CATEG_EVE_LEG),getSesion()));
    categevenacclegdet.setCategoria(CategAccesoCIP.findByOidProxy(db.getInteger(DBCategEvenAccLegDet.OID_CATEG_ACCESO),getSesion()));
    categevenacclegdet.setActivo(db.getBoolean(DBCategEvenAccLegDet.ACTIVO));

  }
}
