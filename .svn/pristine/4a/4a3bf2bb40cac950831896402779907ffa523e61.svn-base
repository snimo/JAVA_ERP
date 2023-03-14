package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.FechaPlanifCacheo;
import com.srn.erp.cip.bm.ProcPlanifCacheo;
import com.srn.erp.cip.da.DBFechaPlanifCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFechaPlanifCacheo extends FactoryObjetoLogico { 

  public FactoryFechaPlanifCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FechaPlanifCacheo fechaplanifcacheo = (FechaPlanifCacheo) objLog;
    fechaplanifcacheo.setOID(db.getInteger(DBFechaPlanifCacheo.OID_FEC_PLANIF));
    fechaplanifcacheo.setProceso(ProcPlanifCacheo.findByOidProxy(db.getInteger(DBFechaPlanifCacheo.OID_PROC_PLANIF),getSesion()));
    fechaplanifcacheo.setFecha(db.getDate(DBFechaPlanifCacheo.FECHA));
    fechaplanifcacheo.setActivo(db.getBoolean(DBFechaPlanifCacheo.ACTIVO));
  }
  
}
