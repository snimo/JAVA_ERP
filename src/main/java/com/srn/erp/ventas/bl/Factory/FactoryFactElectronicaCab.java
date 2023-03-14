package com.srn.erp.ventas.bl.Factory;


import com.srn.erp.ventas.bm.FactElectronicaCab;
import com.srn.erp.ventas.da.DBFactElectronicaCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFactElectronicaCab extends FactoryObjetoLogico { 

  public FactoryFactElectronicaCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FactElectronicaCab factelectronicacab = (FactElectronicaCab) objLog;
    factelectronicacab.setOID(db.getInteger(DBFactElectronicaCab.OID_CCO));
    factelectronicacab.setOid_tc(db.getInteger(DBFactElectronicaCab.OID_TC));
    factelectronicacab.setTc_ext(db.getString(DBFactElectronicaCab.TC_EXT));
    factelectronicacab.setLetra(db.getString(DBFactElectronicaCab.LETRA));
    factelectronicacab.setNro_ext(db.getInteger(DBFactElectronicaCab.NRO_EXT));
    factelectronicacab.setLug_emi(db.getInteger(DBFactElectronicaCab.LUG_EMI));
    factelectronicacab.setFec_homologada(db.getDate(DBFactElectronicaCab.FEC_HOMOLOGADA));
    factelectronicacab.setUsu_homologo(db.getString(DBFactElectronicaCab.USU_HOMOLOGO));
    factelectronicacab.setHomologado_ok(db.getBoolean(DBFactElectronicaCab.HOMOLOGADO_OK));
    factelectronicacab.setOid_cco_asignado_a(db.getInteger(DBFactElectronicaCab.OID_CCO_ASIGNADO_A));
    factelectronicacab.setCae(db.getString(DBFactElectronicaCab.CAE));
    factelectronicacab.setVto_cae(db.getDate(DBFactElectronicaCab.VTO_CAE));
    factelectronicacab.setRespuesta_ws_homo(db.getString(DBFactElectronicaCab.RESPUESTA_WS_HOMO));
    factelectronicacab.setCuit_empresa(db.getString(DBFactElectronicaCab.CUIT_EMPRESA));
    factelectronicacab.setTc_fe(db.getInteger(DBFactElectronicaCab.TC_FE));
    factelectronicacab.setTipo_docu_fe(db.getInteger(DBFactElectronicaCab.TIPO_DOCU_FE));
    factelectronicacab.setNro_docu_fe(db.getString(DBFactElectronicaCab.NRO_DOCU_FE));
    factelectronicacab.setFec_fe(db.getDate(DBFactElectronicaCab.FEC_FE));
    factelectronicacab.setImp_total_fe(db.getMoney(DBFactElectronicaCab.IMP_TOTAL_FE));
    factelectronicacab.setImp_neto_fe(db.getMoney(DBFactElectronicaCab.IMP_NETO_FE));
    factelectronicacab.setImp_iva_fe(db.getMoney(DBFactElectronicaCab.IMP_IVA_FE));

  }
}
