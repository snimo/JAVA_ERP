package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.PuntoFichadaCIP;
import com.srn.erp.cip.da.DBPuntoFichadaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPuntoFichadaCIP extends FactoryObjetoLogico { 

  public FactoryPuntoFichadaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PuntoFichadaCIP puntofichadacip = (PuntoFichadaCIP) objLog;
    puntofichadacip.setOID(db.getInteger(DBPuntoFichadaCIP.OID_PTO_FICHADA));
    puntofichadacip.setCodigo(db.getString(DBPuntoFichadaCIP.CODIGO));
    puntofichadacip.setDescripcion(db.getString(DBPuntoFichadaCIP.DESCRIPCION));
    puntofichadacip.setActivo(db.getBoolean(DBPuntoFichadaCIP.ACTIVO));
    puntofichadacip.setAntiPassbackEnt(db.getBoolean(DBPuntoFichadaCIP.ANTIPASSBACK_ENT));
    puntofichadacip.setAntiPassbackSal(db.getBoolean(DBPuntoFichadaCIP.ANTIPASSBACK_SAL));
  }
}
