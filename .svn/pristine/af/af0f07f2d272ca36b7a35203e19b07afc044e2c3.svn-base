package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.CondicionVentaExpoImpo;
import com.srn.erp.ventas.da.DBCondicionVentaExpoImpo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondicionVentaExpoImpo extends FactoryObjetoLogico { 

  public FactoryCondicionVentaExpoImpo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondicionVentaExpoImpo condicionventaexpoimpo = (CondicionVentaExpoImpo) objLog;
    condicionventaexpoimpo.setOID(db.getInteger(DBCondicionVentaExpoImpo.OID_COND_VTA_EI));
    condicionventaexpoimpo.setCodigo(db.getString(DBCondicionVentaExpoImpo.CODIGO));
    condicionventaexpoimpo.setDescripcion(db.getString(DBCondicionVentaExpoImpo.DESCRIPCION));
    condicionventaexpoimpo.setActivo(db.getBoolean(DBCondicionVentaExpoImpo.ACTIVO));

  }
}
