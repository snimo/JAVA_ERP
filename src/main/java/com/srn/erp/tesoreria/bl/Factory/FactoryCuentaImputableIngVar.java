package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.tesoreria.bm.CuentaImputableIngVar;
import com.srn.erp.tesoreria.bm.MotivoHabIngVar;
import com.srn.erp.tesoreria.da.DBCuentaImputableIngVar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCuentaImputableIngVar extends FactoryObjetoLogico { 

  public FactoryCuentaImputableIngVar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CuentaImputableIngVar cuentaimputableingvar = (CuentaImputableIngVar) objLog;
    cuentaimputableingvar.setOID(db.getInteger(DBCuentaImputableIngVar.OID_CTA_INT_IV));
    cuentaimputableingvar.setMotivo_hab_ing_var(MotivoHabIngVar.findByOidProxy(db.getInteger(DBCuentaImputableIngVar.OID_MOT_HAB_IV),getSesion()));
    cuentaimputableingvar.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBCuentaImputableIngVar.OID_AI),getSesion()));
    cuentaimputableingvar.setActivo(db.getBoolean(DBCuentaImputableIngVar.ACTIVO));

  }
}
