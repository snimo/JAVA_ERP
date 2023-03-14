package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.UniOrgCtaSistBanco;
import com.srn.erp.bancos.da.DBUniOrgCtaSistBanco;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUniOrgCtaSistBanco extends FactoryObjetoLogico { 

  public FactoryUniOrgCtaSistBanco() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UniOrgCtaSistBanco uniorgctasistbanco = (UniOrgCtaSistBanco) objLog;
    uniorgctasistbanco.setOID(db.getInteger(DBUniOrgCtaSistBanco.OID_CTA_HAB_UO));
    uniorgctasistbanco.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBUniOrgCtaSistBanco.OID_UNI_ORG),getSesion()));
    uniorgctasistbanco.setCuenta_hab_banco(CuentaSistemaBanco.findByOidProxy(db.getInteger(DBUniOrgCtaSistBanco.OID_CTA_HAB_BCO),getSesion()));
    uniorgctasistbanco.setActivo(db.getBoolean(DBUniOrgCtaSistBanco.ACTIVO));

  }
}
