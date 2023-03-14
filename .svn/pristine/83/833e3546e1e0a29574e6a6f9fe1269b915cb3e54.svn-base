package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoEstructuraPlan;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.EstructuraPlan;
import com.srn.erp.presupuesto.da.DBCompoEstructuraPlan;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCompoEstructuraPlan extends FactoryObjetoLogico { 

  public FactoryCompoEstructuraPlan() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CompoEstructuraPlan compoestructuraplan = (CompoEstructuraPlan) objLog;
    compoestructuraplan.setOID(db.getInteger(DBCompoEstructuraPlan.OID_ESTRUC_COMPO));
    compoestructuraplan.setEstructura_plan(EstructuraPlan.findByOidProxy(db.getInteger(DBCompoEstructuraPlan.OID_ESTRUC_PLAN),getSesion()));
    compoestructuraplan.setCompo_presu(CompoPresupuestario.findByOidProxy(db.getInteger(DBCompoEstructuraPlan.OID_COMPO_PRESU),getSesion()));
    compoestructuraplan.setActivo(db.getBoolean(DBCompoEstructuraPlan.ACTIVO));

  }
}
