package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PlanoCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.bm.PuertaPlanoCIP;
import com.srn.erp.cip.da.DBPuertaPlanoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPuertaPlanoCIP extends FactoryObjetoLogico { 

  public FactoryPuertaPlanoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PuertaPlanoCIP puertaplanocip = (PuertaPlanoCIP) objLog;
    puertaplanocip.setOID(db.getInteger(DBPuertaPlanoCIP.OID_PUERTA_PLANO));
    puertaplanocip.setOrden(db.getInteger(DBPuertaPlanoCIP.ORDEN));
    puertaplanocip.setPlano(PlanoCIP.findByOidProxy(db.getInteger(DBPuertaPlanoCIP.OID_PLANO),getSesion()));
    puertaplanocip.setPuerta(Puerta.findByOidProxy(db.getInteger(DBPuertaPlanoCIP.OID_PUERTA),getSesion()));
    puertaplanocip.setHab_entrada(db.getBoolean(DBPuertaPlanoCIP.HAB_ENTRADA));
    puertaplanocip.setHab_salida(db.getBoolean(DBPuertaPlanoCIP.HAB_SALIDA));
    puertaplanocip.setActivo(db.getBoolean(DBPuertaPlanoCIP.ACTIVO));

  }
}
