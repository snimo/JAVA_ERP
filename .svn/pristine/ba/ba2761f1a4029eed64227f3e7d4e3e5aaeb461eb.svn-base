package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.DriverComponente;
import com.srn.erp.contabilidad.bm.DriverSubreparto;
import com.srn.erp.contabilidad.da.DBDriverComponente;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDriverComponente extends FactoryObjetoLogico { 

  public FactoryDriverComponente() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DriverComponente drivercomponente = (DriverComponente) objLog;
    drivercomponente.setOID(db.getInteger(DBDriverComponente.OID_COMPO_DRIVER));
    drivercomponente.setDriver(DriverSubreparto.findByOidProxy(db.getInteger(DBDriverComponente.OID_DRIVER),getSesion()));
    
    if (drivercomponente.getDriver().getComponente()!=null) {
    	if (db.getInteger(DBDriverComponente.OID_VALOR_COMPO)!=null) {
    		IObjetoLogico valorCompo =
    			drivercomponente.getDriver().getComponente().getValorCompo(db.getInteger(DBDriverComponente.OID_VALOR_COMPO));    	
    		drivercomponente.setValor_compo(valorCompo);
    	}
    }
    drivercomponente.setActivo(db.getBoolean(DBDriverComponente.ACTIVO));
  }
}
