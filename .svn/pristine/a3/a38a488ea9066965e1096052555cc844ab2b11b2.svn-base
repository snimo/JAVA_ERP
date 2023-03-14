package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.TipoDocumentacionCIP;
import com.srn.erp.cip.da.DBTipoDocumentacionCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoDocumentacionCIP extends FactoryObjetoLogico { 

  public FactoryTipoDocumentacionCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoDocumentacionCIP tipodocumentacioncip = (TipoDocumentacionCIP) objLog;
    tipodocumentacioncip.setOID(db.getInteger(DBTipoDocumentacionCIP.OID_TIPO_DOCU));
    tipodocumentacioncip.setCodigo(db.getString(DBTipoDocumentacionCIP.CODIGO));
    tipodocumentacioncip.setDescripcion(db.getString(DBTipoDocumentacionCIP.DESCRIPCION));
    tipodocumentacioncip.setActivo(db.getBoolean(DBTipoDocumentacionCIP.ACTIVO));
  }
}
