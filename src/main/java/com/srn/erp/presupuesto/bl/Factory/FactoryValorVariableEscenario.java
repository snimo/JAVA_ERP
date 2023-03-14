package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.PeriodoPresupuestario;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;
import com.srn.erp.presupuesto.bm.ValorVariableEscenario;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;
import com.srn.erp.presupuesto.da.DBValorVariableEscenario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValorVariableEscenario extends FactoryObjetoLogico { 

  public FactoryValorVariableEscenario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValorVariableEscenario valorvariableescenario = (ValorVariableEscenario) objLog;
    valorvariableescenario.setOID(db.getInteger(DBValorVariableEscenario.OID_VALOR_VAR_ESCE));
    valorvariableescenario.setPeriodo(PeriodoPresupuestario.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_PERI),getSesion()));
    valorvariableescenario.setValor_compo_1(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_1),getSesion()));
    valorvariableescenario.setValor_compo_2(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_2),getSesion()));
    valorvariableescenario.setValor_compo_3(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_3),getSesion()));
    valorvariableescenario.setValor_compo_4(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_4),getSesion()));
    valorvariableescenario.setValor_compo_5(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_5),getSesion()));
    valorvariableescenario.setValor_compo_6(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_6),getSesion()));
    valorvariableescenario.setValor_compo_7(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_7),getSesion()));
    valorvariableescenario.setValor_compo_8(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_8),getSesion()));
    valorvariableescenario.setValor_compo_9(ValorCompoPresu.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VALOR_COMPO_9),getSesion()));
    valorvariableescenario.setValor(db.getMoney(DBValorVariableEscenario.VALOR));
    valorvariableescenario.setVariableEscenario(VarEscenarioCab.findByOidProxy(db.getInteger(DBValorVariableEscenario.OID_VAR_ESC_CAB),getSesion()));
  }
}
