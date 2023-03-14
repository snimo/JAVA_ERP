package com.srn.erp.legales.bl.Factory;


import com.srn.erp.legales.bm.DocEnvSeclo;
import com.srn.erp.legales.bm.Seclo;
import com.srn.erp.legales.da.DBDocEnvSeclo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDocEnvSeclo extends FactoryObjetoLogico { 

  public FactoryDocEnvSeclo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DocEnvSeclo docenvseclo = (DocEnvSeclo) objLog;
    docenvseclo.setOID(db.getInteger(DBDocEnvSeclo.OID_DOC_ENV_SEC));
    docenvseclo.setSeclo(Seclo.findByOidProxy(db.getInteger(DBDocEnvSeclo.OID_SECLO),getSesion()));
    docenvseclo.setFecha_envio(db.getDate(DBDocEnvSeclo.FECHA_ENVIO));
    docenvseclo.setDocumentacion(db.getString(DBDocEnvSeclo.DOCUMENTACION));
    docenvseclo.setActivo(db.getBoolean(DBDocEnvSeclo.ACTIVO));

  }
}
