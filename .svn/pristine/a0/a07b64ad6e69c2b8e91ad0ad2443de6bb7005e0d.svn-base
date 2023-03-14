package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.ResultadoCacheo;
import com.srn.erp.cip.da.DBResultadoCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryResultadoCacheo extends FactoryObjetoLogico { 

  public FactoryResultadoCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ResultadoCacheo resultadocacheo = (ResultadoCacheo) objLog;
    resultadocacheo.setOID(db.getInteger(DBResultadoCacheo.OID_EST_RES_CACHEO));
    resultadocacheo.setCodigo(db.getString(DBResultadoCacheo.CODIGO));
    resultadocacheo.setDescripcion(db.getString(DBResultadoCacheo.DESCRIPCION));
    resultadocacheo.setActivo(db.getBoolean(DBResultadoCacheo.ACTIVO));

  }
}
