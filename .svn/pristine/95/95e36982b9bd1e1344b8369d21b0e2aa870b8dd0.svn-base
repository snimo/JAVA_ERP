package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;
import com.srn.erp.presupuesto.bm.VarEscenarioDet;
import com.srn.erp.presupuesto.da.DBVarEscenarioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVarEscenarioDet extends FactoryObjetoLogico { 

  public FactoryVarEscenarioDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    VarEscenarioDet varescenariodet = (VarEscenarioDet) objLog;
    varescenariodet.setOID(db.getInteger(DBVarEscenarioDet.OID_VAR_ESC_DET));
    varescenariodet.setVar_escenario_cab(VarEscenarioCab.findByOidProxy(db.getInteger(DBVarEscenarioDet.OID_VAR_ESC_CAB),getSesion()));
    varescenariodet.setSecu(db.getInteger(DBVarEscenarioDet.SECU));
    varescenariodet.setCompo_presu(CompoPresupuestario.findByOidProxy(db.getInteger(DBVarEscenarioDet.OID_COMPO_PRESU),getSesion()));
    varescenariodet.setActivo(db.getBoolean(DBVarEscenarioDet.ACTIVO));
    varescenariodet.setNroInternoValCompo(db.getInteger(DBVarEscenarioDet.NRO_INT_VAL_COMPO));
  }
}
