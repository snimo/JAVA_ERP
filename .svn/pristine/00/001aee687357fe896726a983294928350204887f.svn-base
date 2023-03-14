package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.bm.FechaExclusionCacheo;
import com.srn.erp.cip.da.DBFechaExclusionCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFechaExclusionCacheo extends FactoryObjetoLogico { 

  public FactoryFechaExclusionCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FechaExclusionCacheo fechaexclusioncacheo = (FechaExclusionCacheo) objLog;
    fechaexclusioncacheo.setOID(db.getInteger(DBFechaExclusionCacheo.OID_EXC_FEC));
    fechaexclusioncacheo.setAlgoritmo(AlgoritmoCacheo.findByOidProxy(db.getInteger(DBFechaExclusionCacheo.OID_ALGO_CACHEO),getSesion()));
    fechaexclusioncacheo.setFecha(db.getDate(DBFechaExclusionCacheo.FECHA));
    fechaexclusioncacheo.setActivo(db.getBoolean(DBFechaExclusionCacheo.ACTIVO));

  }
}
