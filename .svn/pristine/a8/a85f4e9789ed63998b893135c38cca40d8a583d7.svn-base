package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.DriverComponente;
import com.srn.erp.contabilidad.bm.DriverComponenteCta;
import com.srn.erp.contabilidad.da.DBDriverComponenteCta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDriverComponenteCta extends FactoryObjetoLogico { 

  public FactoryDriverComponenteCta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DriverComponenteCta drivercomponentecta = (DriverComponenteCta) objLog;
    drivercomponentecta.setOID(db.getInteger(DBDriverComponenteCta.OID_COMPO_D_CTA));
    drivercomponentecta.setComponente_driver(DriverComponente.findByOidProxy(db.getInteger(DBDriverComponenteCta.OID_COMPO_DRIVER),getSesion()));
    drivercomponentecta.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBDriverComponenteCta.OID_ANA_CON),getSesion()));
    drivercomponentecta.setActivo(db.getBoolean(DBDriverComponenteCta.ACTIVO));
  }
}
