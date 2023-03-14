package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.EstructuraPlan;
import com.srn.erp.presupuesto.bm.PlanPresupuestario;
import com.srn.erp.presupuesto.da.DBPlanPresupuestario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPlanPresupuestario extends FactoryObjetoLogico { 

  public FactoryPlanPresupuestario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
  	
    PlanPresupuestario planpresupuestario = (PlanPresupuestario) objLog;
    planpresupuestario.setOID(db.getInteger(DBPlanPresupuestario.OID_PLAN_PRESU ));
    planpresupuestario.setCodigo(db.getString(DBPlanPresupuestario.CODIGO));
    planpresupuestario.setDescripcion(db.getString(DBPlanPresupuestario.DESCRIPCION));
    planpresupuestario.setEstructura_plan(EstructuraPlan.findByOidProxy(db.getInteger(DBPlanPresupuestario.OID_ESTRUC_PLAN),getSesion()));
    planpresupuestario.setActivo(db.getBoolean(DBPlanPresupuestario.ACTIVO));

  }
}
