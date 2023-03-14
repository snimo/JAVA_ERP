package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.Ring;
import com.srn.erp.mensajero.da.DBRing;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRing extends FactoryObjetoLogico { 

  public FactoryRing() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Ring ring = (Ring) objLog;
    ring.setOID(db.getInteger(DBRing.OID_RING));
    ring.setCodigo(db.getString(DBRing.CODIGO));
    ring.setDescripcion(db.getString(DBRing.DESCRIPCION));
    ring.setActivo(db.getBoolean(DBRing.ACTIVO));

  }
}
