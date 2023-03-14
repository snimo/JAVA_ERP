package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.general.bm.UniOrgTalonario;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBUniOrgTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUniOrgTalonario extends FactoryObjetoLogico { 

  public FactoryUniOrgTalonario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UniOrgTalonario uniorgtalonario = (UniOrgTalonario) objLog;
    uniorgtalonario.setOID(db.getInteger(DBUniOrgTalonario.OID_UNI_ORG_TAL));
    uniorgtalonario.setTalonario(Talonario.findByOidProxy(db.getInteger(DBUniOrgTalonario.OID_TALONARIO),getSesion()));
    uniorgtalonario.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBUniOrgTalonario.OID_UNI_ORG),getSesion()));
    uniorgtalonario.setActivo(db.getBoolean(DBUniOrgTalonario.ACTIVO));

  }
}
