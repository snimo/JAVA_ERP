package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaImputableIngVar;
import com.srn.erp.tesoreria.bm.UniOrgCtasIngVar;
import com.srn.erp.tesoreria.da.DBUniOrgCtasIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUniOrgCtasIngVar extends FactoryObjetoLogico { 

  public FactoryUniOrgCtasIngVar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UniOrgCtasIngVar uniorgctasingvar = (UniOrgCtasIngVar) objLog;
    uniorgctasingvar.setOID(db.getInteger(DBUniOrgCtasIngVar.OID_UNI_ORG_IV));
    uniorgctasingvar.setCuenta_iv(CuentaImputableIngVar.findByOidProxy(db.getInteger(DBUniOrgCtasIngVar.OID_CTA_INT_IV),getSesion()));
    uniorgctasingvar.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBUniOrgCtasIngVar.OID_UNI_ORG),getSesion()));

  }
}
