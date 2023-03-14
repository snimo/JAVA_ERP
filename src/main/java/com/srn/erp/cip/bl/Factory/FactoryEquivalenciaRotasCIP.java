package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.EquivalenciaRotasCIP;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.da.DBEquivalenciaRotasCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEquivalenciaRotasCIP extends FactoryObjetoLogico { 

  public FactoryEquivalenciaRotasCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EquivalenciaRotasCIP equivalenciarotascip = (EquivalenciaRotasCIP) objLog;
    equivalenciarotascip.setOID(db.getInteger(DBEquivalenciaRotasCIP.OID_ROTA_EQUIV));
    equivalenciarotascip.setRota(Rota.findByOidProxy(db.getInteger(DBEquivalenciaRotasCIP.OID_ROTA),getSesion()));
    equivalenciarotascip.setCodigo_externo(db.getString(DBEquivalenciaRotasCIP.CODIGO_EXTERNO));
    equivalenciarotascip.setActivo(db.getBoolean(DBEquivalenciaRotasCIP.ACTIVO));

  }
}
