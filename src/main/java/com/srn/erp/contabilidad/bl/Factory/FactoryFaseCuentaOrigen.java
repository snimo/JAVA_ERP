package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.contabilidad.bm.FaseCuentaOrigen;
import com.srn.erp.contabilidad.bm.FaseSubReparto;
import com.srn.erp.contabilidad.da.DBFaseCuentaOrigen;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFaseCuentaOrigen extends FactoryObjetoLogico { 

  public FactoryFaseCuentaOrigen() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FaseCuentaOrigen fasecuentaorigen = (FaseCuentaOrigen) objLog;
    fasecuentaorigen.setOID(db.getInteger(DBFaseCuentaOrigen.OID_FASE_CTA_ORI));
    fasecuentaorigen.setFase(FaseSubReparto.findByOidProxy(db.getInteger(DBFaseCuentaOrigen.OID_FASE),getSesion()));
    fasecuentaorigen.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBFaseCuentaOrigen.OID_ANA_CON),getSesion()));
    fasecuentaorigen.setActivo(db.getBoolean(DBFaseCuentaOrigen.ACTIVO));
  }
}
