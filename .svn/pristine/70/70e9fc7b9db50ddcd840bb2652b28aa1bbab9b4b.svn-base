package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UniOrgHabUsu;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBUniOrgHabUsu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUniOrgHabUsu extends FactoryObjetoLogico {

  public FactoryUniOrgHabUsu() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UniOrgHabUsu uniorghabusu = (UniOrgHabUsu) objLog;
    uniorghabusu.setOID(db.getInteger(DBUniOrgHabUsu.OID_UNI_ORG_HAB));
    uniorghabusu.setUnidad_organizacion(UnidadOrganizativa.findByOidProxy(db.getInteger(DBUniOrgHabUsu.OID_UNI_ORG),getSesion()));
    uniorghabusu.setEmpresa(Empresa.findByOidProxy(db.getInteger(DBUniOrgHabUsu.OID_EMPRESA),getSesion()));
    uniorghabusu.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBUniOrgHabUsu.OID_SUCURSAL),getSesion()));
  }
}
