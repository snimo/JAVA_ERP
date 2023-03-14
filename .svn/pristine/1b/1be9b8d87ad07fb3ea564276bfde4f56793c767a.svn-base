package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.ConsultaAplicCtaCteClie;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasACobrar.da.DBConsultaAplicCtaCteClie;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConsultaAplicCtaCteClie extends FactoryObjetoLogico { 

  public FactoryConsultaAplicCtaCteClie() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConsultaAplicCtaCteClie consultaaplicctacteclie = (ConsultaAplicCtaCteClie) objLog;
    consultaaplicctacteclie.setOID(db.getInteger(DBConsultaAplicCtaCteClie.OID_APL_CLIE));
    consultaaplicctacteclie.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteClie.OID_SUJETO),getSesion()));
    consultaaplicctacteclie.setOid_cco_apl(db.getInteger(DBConsultaAplicCtaCteClie.OID_CCO_APL));
    consultaaplicctacteclie.setTc_ext_apl(db.getString(DBConsultaAplicCtaCteClie.TC_EXT_APL));
    consultaaplicctacteclie.setLetra_apl(db.getString(DBConsultaAplicCtaCteClie.LETRA_APL));
    consultaaplicctacteclie.setLug_emi_apl(db.getInteger(DBConsultaAplicCtaCteClie.LUG_EMI_APL));
    consultaaplicctacteclie.setNro_ext_apl(db.getInteger(DBConsultaAplicCtaCteClie.NRO_EXT_APL));
    consultaaplicctacteclie.setEmision(db.getDate(DBConsultaAplicCtaCteClie.EMISION));
    consultaaplicctacteclie.setImputac(db.getDate(DBConsultaAplicCtaCteClie.IMPUTAC));
    consultaaplicctacteclie.setOid_cco_apl_aux(db.getInteger(DBConsultaAplicCtaCteClie.OID_CCO_APL_AUX));
    consultaaplicctacteclie.setTc_ext_apl_aux(db.getString(DBConsultaAplicCtaCteClie.TC_EXT_APL_AUX));
    consultaaplicctacteclie.setLetra_apl_aux(db.getString(DBConsultaAplicCtaCteClie.LETRA_APL_AUX));
    consultaaplicctacteclie.setLug_emi_apl_aux(db.getInteger(DBConsultaAplicCtaCteClie.LUG_EMI_APL_AUX));
    consultaaplicctacteclie.setNro_ext_apl_aux(db.getInteger(DBConsultaAplicCtaCteClie.NRO_EXT_APL_AUX));
    consultaaplicctacteclie.setTran_vto(TranClieVto.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteClie.OID_TRAN_VTO),getSesion()));
    consultaaplicctacteclie.setTipo_cta_clie(TipoCtaCteClie.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteClie.OID_TIPO_CTA_CLIE),getSesion()));
    consultaaplicctacteclie.setImporte(db.getDouble(DBConsultaAplicCtaCteClie.IMPORTE));
    consultaaplicctacteclie.setMoneda(Moneda.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteClie.OID_MONEDA),getSesion()));
    consultaaplicctacteclie.setAllowDesaplicar(db.getBoolean(DBConsultaAplicCtaCteClie.ALLOW_DESAPLICAR));
  }
}
