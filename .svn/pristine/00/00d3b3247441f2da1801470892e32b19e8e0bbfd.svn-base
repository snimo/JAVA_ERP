package com.srn.erp.conciTarjeta.bl.Factory;

import com.srn.erp.conciTarjeta.bm.CabModeloLiq;
import com.srn.erp.conciTarjeta.bm.DetModeloLiq;
import com.srn.erp.conciTarjeta.da.DBDetModeloLiq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDetModeloLiq extends FactoryObjetoLogico { 

  public FactoryDetModeloLiq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DetModeloLiq detmodeloliq = (DetModeloLiq) objLog;
    detmodeloliq.setOID(db.getInteger(DBDetModeloLiq.OID_MODELO_DET));
    detmodeloliq.setModelo(CabModeloLiq.findByOidProxy(db.getInteger(DBDetModeloLiq.OID_MODELO_LIQ),getSesion()));
    detmodeloliq.setOrden(db.getInteger(DBDetModeloLiq.ORDEN));
    detmodeloliq.setCuenta(db.getString(DBDetModeloLiq.CUENTA));
    detmodeloliq.setDesc_cuenta(db.getString(DBDetModeloLiq.DESC_CUENTA));
    detmodeloliq.setCompo1(db.getString(DBDetModeloLiq.COMPO1));
    detmodeloliq.setCompo2(db.getString(DBDetModeloLiq.COMPO2));
    detmodeloliq.setDebe(db.getDouble(DBDetModeloLiq.DEBE));
    detmodeloliq.setHaber(db.getDouble(DBDetModeloLiq.HABER));
    detmodeloliq.setActivo(db.getBoolean(DBDetModeloLiq.ACTIVO));
    detmodeloliq.setCodImpuesto(db.getString(DBDetModeloLiq.COD_IMPUESTO));
    detmodeloliq.setPorcImp(db.getMoney(DBDetModeloLiq.PORC_IMP));
  }
}
