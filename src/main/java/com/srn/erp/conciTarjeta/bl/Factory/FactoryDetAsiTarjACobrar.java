package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabAsiTarjACobrar;
import com.srn.erp.conciTarjeta.bm.DetAsiTarjACobrar;
import com.srn.erp.conciTarjeta.da.DBDetAsiTarjACobrar;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDetAsiTarjACobrar extends FactoryObjetoLogico { 

  public FactoryDetAsiTarjACobrar() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DetAsiTarjACobrar detasitarjacobrar = (DetAsiTarjACobrar) objLog;
    detasitarjacobrar.setOID(db.getInteger(DBDetAsiTarjACobrar.OID_DET_ASI_ACOB));
    detasitarjacobrar.setOrden(db.getInteger(DBDetAsiTarjACobrar.ORDEN));
    detasitarjacobrar.setCab_asi_acob(CabAsiTarjACobrar.findByOidProxy(db.getInteger(DBDetAsiTarjACobrar.OID_CAB_ASI_ACOB),getSesion()));
    detasitarjacobrar.setCuenta(db.getString(DBDetAsiTarjACobrar.CUENTA));
    detasitarjacobrar.setCompo1(db.getString(DBDetAsiTarjACobrar.COMPO1));
    detasitarjacobrar.setCompo2(db.getString(DBDetAsiTarjACobrar.COMPO2));
    detasitarjacobrar.setDebe(db.getDouble(DBDetAsiTarjACobrar.DEBE));
    detasitarjacobrar.setHaber(db.getDouble(DBDetAsiTarjACobrar.HABER));
    detasitarjacobrar.setActivo(db.getBoolean(DBDetAsiTarjACobrar.ACTIVO));

  }
}
