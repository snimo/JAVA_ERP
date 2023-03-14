package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.SistemaValuacion;
import com.srn.erp.bienUso.bm.SubBien;
import com.srn.erp.bienUso.bm.SubBienVidaUtil;
import com.srn.erp.bienUso.da.DBSubBienVidaUtil;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySubBienVidaUtil extends FactoryObjetoLogico { 

  public FactorySubBienVidaUtil() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SubBienVidaUtil subbienvidautil = (SubBienVidaUtil) objLog;
   subbienvidautil.setOID(db.getInteger(DBSubBienVidaUtil.OID_BIEN_VU));
    subbienvidautil.setSubbien(SubBien.findByOidProxy(db.getInteger(DBSubBienVidaUtil.OID_BIEN_ALTA),getSesion()));
    subbienvidautil.setSistema_valuacion(SistemaValuacion.findByOidProxy(db.getInteger(DBSubBienVidaUtil.OID_SIST_VAL),getSesion()));
    subbienvidautil.setVidal_util(db.getInteger(DBSubBienVidaUtil.VIDAL_UTIL));
    subbienvidautil.setMeses_amort(db.getInteger(DBSubBienVidaUtil.MESES_AMORT));
    subbienvidautil.setUlt_peri_amort(Periodo.findByOidProxy(db.getInteger(DBSubBienVidaUtil.OID_ULT_PERI_AMORT),getSesion()));
    subbienvidautil.setFec_ult_amort(db.getDate(DBSubBienVidaUtil.FEC_ULT_AMORT));
    subbienvidautil.setTasa_acu(db.getDouble(DBSubBienVidaUtil.TASA_ACU));
    subbienvidautil.setTasa_acu_ejer_ant(db.getDouble(DBSubBienVidaUtil.TASA_ACU_EJER_ANT));
    subbienvidautil.setAnt_meses_amort(db.getInteger(DBSubBienVidaUtil.ANT_MESES_AMORT));
    subbienvidautil.setAnt_ult_peri(Periodo.findByOidProxy(db.getInteger(DBSubBienVidaUtil.ANT_OID_ULT_PERI_A),getSesion()));
    subbienvidautil.setAnt_tasa_acu(db.getDouble(DBSubBienVidaUtil.ANT_TASA_ACU));
    subbienvidautil.setAnt_tasa_acu_eje_a(db.getDouble(DBSubBienVidaUtil.ANT_TASA_ACU_EJE_A));
    subbienvidautil.setUltTasaAplic(db.getDouble(DBSubBienVidaUtil.ULT_TASA_APLIC));
    subbienvidautil.setTasaAcuEjerActual(db.getDouble(DBSubBienVidaUtil.TASA_ACUM_EJER_ACT));
  }
}
