package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.CategAccesoCIP;
import com.srn.erp.cip.bm.CategAccesoPuertaCIP;
import com.srn.erp.cip.bm.Puerta;
import com.srn.erp.cip.da.DBCategAccesoPuertaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategAccesoPuertaCIP extends FactoryObjetoLogico { 

  public FactoryCategAccesoPuertaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategAccesoPuertaCIP categaccesopuertacip = (CategAccesoPuertaCIP) objLog;
    categaccesopuertacip.setOID(db.getInteger(DBCategAccesoPuertaCIP.OID_CATEG_ACC_PUE));
    categaccesopuertacip.setCategoria(CategAccesoCIP.findByOidProxy(db.getInteger(DBCategAccesoPuertaCIP.OID_CATEG_ACCESO),getSesion()));
    categaccesopuertacip.setPuerta(Puerta.findByOidProxy(db.getInteger(DBCategAccesoPuertaCIP.OID_PUERTA),getSesion()));
    categaccesopuertacip.setHab_entrada(db.getBoolean(DBCategAccesoPuertaCIP.HAB_ENTRADA));
    categaccesopuertacip.setHab_salida(db.getBoolean(DBCategAccesoPuertaCIP.HAB_SALIDA));
    categaccesopuertacip.setActivo(db.getBoolean(DBCategAccesoPuertaCIP.ACTIVO));

  }
}
