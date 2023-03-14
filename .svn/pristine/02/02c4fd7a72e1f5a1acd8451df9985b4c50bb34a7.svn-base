package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PrepararLB;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.da.DBPrepararLB;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPrepararLB extends FactoryObjetoLogico { 

  public FactoryPrepararLB() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PrepararLB prepararlb = (PrepararLB) objLog;
    prepararlb.setOID(db.getInteger(DBPrepararLB.OID_PREP_LB));
    prepararlb.setPuerta(Puerta.findByOidProxy(db.getInteger(DBPrepararLB.OID_PUERTA),getSesion()));
    prepararlb.setFecha_preparacion(db.getDate(DBPrepararLB.FECHA_PREP));
    prepararlb.setHora_prep(db.getString(DBPrepararLB.HORA_PREP));
    prepararlb.setActivo(db.getBoolean(DBPrepararLB.ACTIVO));

  }
}
