package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.DriverCuentaSubreparto;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.da.DBDriverCuentaSubreparto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDriverCuentaSubreparto extends FactoryObjetoLogico { 

  public FactoryDriverCuentaSubreparto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DriverCuentaSubreparto drivercuentasubreparto = (DriverCuentaSubreparto) objLog;
    drivercuentasubreparto.setOID(db.getInteger(DBDriverCuentaSubreparto.OID_DRIVER_CTA));
    drivercuentasubreparto.setDriver(DriverSubreparto.findByOidProxy(db.getInteger(DBDriverCuentaSubreparto.OID_DRIVER),getSesion()));
    drivercuentasubreparto.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBDriverCuentaSubreparto.OID_ANA_CON),getSesion()));
    drivercuentasubreparto.setActivo(db.getBoolean(DBDriverCuentaSubreparto.ACTIVO));

  }
}
