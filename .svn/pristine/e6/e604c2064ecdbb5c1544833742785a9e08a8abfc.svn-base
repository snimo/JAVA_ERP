package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConsultaAplicCtaCteProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.ctasAPagar.da.DBConsultaAplicCtaCteProv;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConsultaAplicCtaCteProv extends FactoryObjetoLogico { 

  public FactoryConsultaAplicCtaCteProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConsultaAplicCtaCteProv consultaaplicctacteprov = (ConsultaAplicCtaCteProv) objLog;
    consultaaplicctacteprov.setOID(db.getInteger(DBConsultaAplicCtaCteProv.OID_APL_PROV));
    consultaaplicctacteprov.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteProv.OID_PROVEEDOR),getSesion()));
    consultaaplicctacteprov.setOid_cco_apl(db.getInteger(DBConsultaAplicCtaCteProv.OID_CCO_APL));
    consultaaplicctacteprov.setTc_ext_apl(db.getString(DBConsultaAplicCtaCteProv.TC_EXT_APL));
    consultaaplicctacteprov.setLetra_apl(db.getString(DBConsultaAplicCtaCteProv.LETRA_APL));
    consultaaplicctacteprov.setLug_emi_apl(db.getInteger(DBConsultaAplicCtaCteProv.LUG_EMI_APL));
    consultaaplicctacteprov.setNro_ext_apl(db.getInteger(DBConsultaAplicCtaCteProv.NRO_EXT_APL));
    consultaaplicctacteprov.setEmision(db.getDate(DBConsultaAplicCtaCteProv.EMISION));
    consultaaplicctacteprov.setImputac(db.getDate(DBConsultaAplicCtaCteProv.IMPUTAC));
    consultaaplicctacteprov.setOid_cco_apl_aux(db.getInteger(DBConsultaAplicCtaCteProv.OID_CCO_APL_AUX));
    consultaaplicctacteprov.setTc_ext_apl_aux(db.getString(DBConsultaAplicCtaCteProv.TC_EXT_APL_AUX));
    consultaaplicctacteprov.setLetra_apl_aux(db.getString(DBConsultaAplicCtaCteProv.LETRA_APL_AUX));
    consultaaplicctacteprov.setLug_emi_apl_aux(db.getInteger(DBConsultaAplicCtaCteProv.LUG_EMI_APL_AUX));
    consultaaplicctacteprov.setNro_ext_apl_aux(db.getInteger(DBConsultaAplicCtaCteProv.NRO_EXT_APL_AUX));
    consultaaplicctacteprov.setTran_vto(TranProvVto.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteProv.OID_TRAN_VTO),getSesion()));
    consultaaplicctacteprov.setTipo_cta_prov(TipoCtaCteProv.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteProv.OID_TIPO_CTA_PROV),getSesion()));
    consultaaplicctacteprov.setImporte(db.getDouble(DBConsultaAplicCtaCteProv.IMPORTE));
    consultaaplicctacteprov.setMoneda(Moneda.findByOidProxy(db.getInteger(DBConsultaAplicCtaCteProv.OID_MONEDA),getSesion()));
    consultaaplicctacteprov.setAllowDesaplicar(db.getBoolean(DBConsultaAplicCtaCteProv.ALLOW_DESAPLICAR));
  }
}
