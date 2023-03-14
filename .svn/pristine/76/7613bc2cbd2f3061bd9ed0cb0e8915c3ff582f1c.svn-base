package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.CuentaSistemaBanco;
import com.srn.erp.tesoreria.da.DBCuentaSistemaBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCuentaSistemaBanco extends FactoryObjetoLogico { 

  public FactoryCuentaSistemaBanco() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CuentaSistemaBanco cuentasistemabanco = (CuentaSistemaBanco) objLog;
    cuentasistemabanco.setOID(db.getInteger(DBCuentaSistemaBanco.OID_CTA_HAB_BCO));
    cuentasistemabanco.setCuenta(CuentaImputable.findByOidProxy(db.getInteger(DBCuentaSistemaBanco.OID_AI),getSesion()));
    cuentasistemabanco.setActivo(db.getBoolean(DBCuentaSistemaBanco.ACTIVO));
    cuentasistemabanco.setUnidadOrganizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBCuentaSistemaBanco.UNI_ORG),getSesion()));
  }
}
