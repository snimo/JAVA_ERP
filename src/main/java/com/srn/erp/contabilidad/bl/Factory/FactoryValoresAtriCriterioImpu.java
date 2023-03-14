package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.CriterioSelCuenta;
import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.ValoresAtriCriterioImpu;
import com.srn.erp.contabilidad.da.DBValoresAtriCriterioImpu;
import com.srn.erp.general.bm.DefinicionAtributoEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValoresAtriCriterioImpu extends FactoryObjetoLogico { 

  public FactoryValoresAtriCriterioImpu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValoresAtriCriterioImpu valoresatricriterioimpu = (ValoresAtriCriterioImpu) objLog;
    valoresatricriterioimpu.setOID(db.getInteger(DBValoresAtriCriterioImpu.OID_VAL_ATRI_ENT));
    valoresatricriterioimpu.setCriterio_sel_cta(CriterioSelCuenta.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_CRI_SEL_CTA),getSesion()));
    valoresatricriterioimpu.setAtri_ent_1(DefinicionAtributoEntidad.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_ATRI_ENT_1),getSesion()));
    valoresatricriterioimpu.setAtri_ent_2(DefinicionAtributoEntidad.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_ATRI_ENT_2),getSesion()));
    valoresatricriterioimpu.setAtri_ent_3(DefinicionAtributoEntidad.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_ATRI_ENT_3),getSesion()));
    valoresatricriterioimpu.setAtri_ent_4(DefinicionAtributoEntidad.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_ATRI_ENT_4),getSesion()));
    valoresatricriterioimpu.setAtri_ent_5(DefinicionAtributoEntidad.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_ATRI_ENT_5),getSesion()));
    if (valoresatricriterioimpu.getAtri_ent_1()!=null)
      valoresatricriterioimpu.setVal_atri_1((ObjetoLogico)ObjetoLogico.getObjectByOid(valoresatricriterioimpu.getAtri_ent_1().getNombeNickName(),db.getInteger(DBValoresAtriCriterioImpu.OID_VAL_ATRI_1),getSesion()));
    if (valoresatricriterioimpu.getAtri_ent_2()!=null)
      valoresatricriterioimpu.setVal_atri_2((ObjetoLogico)ObjetoLogico.getObjectByOid(valoresatricriterioimpu.getAtri_ent_2().getNombeNickName(),db.getInteger(DBValoresAtriCriterioImpu.OID_VAL_ATRI_2),getSesion()));
    if (valoresatricriterioimpu.getAtri_ent_3()!=null)
      valoresatricriterioimpu.setVal_atri_3((ObjetoLogico)ObjetoLogico.getObjectByOid(valoresatricriterioimpu.getAtri_ent_3().getNombeNickName(),db.getInteger(DBValoresAtriCriterioImpu.OID_VAL_ATRI_3),getSesion()));
    if (valoresatricriterioimpu.getAtri_ent_4()!=null)
      valoresatricriterioimpu.setVal_atri_4((ObjetoLogico)ObjetoLogico.getObjectByOid(valoresatricriterioimpu.getAtri_ent_4().getNombeNickName(),db.getInteger(DBValoresAtriCriterioImpu.OID_VAL_ATRI_4),getSesion()));
    if (valoresatricriterioimpu.getAtri_ent_5()!=null)    
      valoresatricriterioimpu.setVal_atri_5((ObjetoLogico)ObjetoLogico.getObjectByOid(valoresatricriterioimpu.getAtri_ent_5().getNombeNickName(),db.getInteger(DBValoresAtriCriterioImpu.OID_VAL_ATRI_5),getSesion()));
    valoresatricriterioimpu.setTomar_cuenta(db.getString(DBValoresAtriCriterioImpu.TOMAR_CUENTA));
    valoresatricriterioimpu.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_AI),getSesion()));
    valoresatricriterioimpu.setCuenta_contable(Cuenta.findByOidProxy(db.getInteger(DBValoresAtriCriterioImpu.OID_ANA_CON),getSesion()));

  }
}
