package com.srn.erp.cip.bl.Factory;


import com.srn.erp.cip.bm.EquivalenciaEstadoCIP;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.da.DBEquivalenciaEstadoCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEquivalenciaEstadoCIP extends FactoryObjetoLogico { 

  public FactoryEquivalenciaEstadoCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EquivalenciaEstadoCIP equivalenciaestadocip = (EquivalenciaEstadoCIP) objLog;
    equivalenciaestadocip.setOID(db.getInteger(DBEquivalenciaEstadoCIP.OID_EQUIV_ESTADO));
    equivalenciaestadocip.setEstado(EstadoCIP.findByOidProxy(db.getInteger(DBEquivalenciaEstadoCIP.OID_ESTADO),getSesion()));
    equivalenciaestadocip.setCodigo_externo(db.getString(DBEquivalenciaEstadoCIP.CODIGO_EXTERNO));
    equivalenciaestadocip.setActivo(db.getBoolean(DBEquivalenciaEstadoCIP.ACTIVO));

  }
}
