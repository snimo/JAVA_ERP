package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoPuerta;
import com.srn.erp.cip.bm.PlanifDiaCacheo;
import com.srn.erp.cip.da.DBPlanifDiaCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPlanifDiaCacheo extends FactoryObjetoLogico { 

  public FactoryPlanifDiaCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PlanifDiaCacheo planifdiacacheo = (PlanifDiaCacheo) objLog;
   planifdiacacheo.setOID(db.getInteger(DBPlanifDiaCacheo.OID_PLANIF_DIA));
    planifdiacacheo.setLunes_entrada(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_LUN_ENT),getSesion()));
    planifdiacacheo.setLunes_salida(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_LUN_SAL),getSesion()));
    planifdiacacheo.setMartes_entrada(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_MAR_ENT),getSesion()));
    planifdiacacheo.setMartes_salida(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_MAR_SAL),getSesion()));
    planifdiacacheo.setMiercoles_entrada(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_MIE_ENT),getSesion()));
    planifdiacacheo.setMiercoles_salida(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_MIE_SAL),getSesion()));
    planifdiacacheo.setJueves_entrada(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_JUE_ENT),getSesion()));
    planifdiacacheo.setJueves_salida(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_JUE_SAL),getSesion()));
    planifdiacacheo.setViernes_entrada(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_VIE_ENT),getSesion()));
    planifdiacacheo.setViermes_salida(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_VIE_SAL),getSesion()));
    planifdiacacheo.setSabado_entrada(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_SAB_ENT),getSesion()));
    planifdiacacheo.setSabado_salida(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_SAB_SAL),getSesion()));
    planifdiacacheo.setDomingo_entrada(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_DOM_ENT),getSesion()));
    planifdiacacheo.setDomingo_salida(GrupoPuerta.findByOidProxy(db.getInteger(DBPlanifDiaCacheo.OID_DOM_SAL),getSesion()));

  }
}
