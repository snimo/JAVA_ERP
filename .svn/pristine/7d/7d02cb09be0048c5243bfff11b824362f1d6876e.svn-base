package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AgrupadorPlano;
import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.da.DBPlanoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPlanoCIP extends FactoryObjetoLogico { 

  public FactoryPlanoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PlanoCIP planocip = (PlanoCIP) objLog;
    planocip.setOID(db.getInteger(DBPlanoCIP.OID_PLANO));
    planocip.setCodigo(db.getString(DBPlanoCIP.CODIGO));
    planocip.setDescripcion(db.getString(DBPlanoCIP.DESCRIPCION));
    planocip.setGrupo_plano(AgrupadorPlano.findByOidProxy(db.getInteger(DBPlanoCIP.OID_AGRUP_PLANO),getSesion()));
    planocip.setOrden(db.getInteger(DBPlanoCIP.ORDEN));
    planocip.setActivo(db.getBoolean(DBPlanoCIP.ACTIVO));

  }
}
