package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Componente;
import com.srn.erp.contabilidad.bm.DriverCuentaComponente;
import com.srn.erp.contabilidad.bm.DriverCuentaSubreparto;
import com.srn.erp.contabilidad.da.DBDriverCuentaComponente;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDriverCuentaComponente extends FactoryObjetoLogico { 

  public FactoryDriverCuentaComponente() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
	  
    DriverCuentaComponente drivercuentacomponente = (DriverCuentaComponente) objLog;
    drivercuentacomponente.setOID(db.getInteger(DBDriverCuentaComponente.OID_DRIVER_COMPO));
    drivercuentacomponente.setDriver_cta(DriverCuentaSubreparto.findByOidProxy(db.getInteger(DBDriverCuentaComponente.OID_DRIVER_CTA),getSesion()));
    drivercuentacomponente.setComponente(Componente.findByOidProxy(db.getInteger(DBDriverCuentaComponente.OID_COMPO),getSesion()));
    IObjetoLogico valorCompo =
    	drivercuentacomponente.getComponente().getValorCompo(db.getInteger(DBDriverCuentaComponente.OID_VAL_COMPO));
    drivercuentacomponente.setValor_componente(valorCompo);
    drivercuentacomponente.setActivo(db.getBoolean(DBDriverCuentaComponente.ACTIVO));

  }
}
