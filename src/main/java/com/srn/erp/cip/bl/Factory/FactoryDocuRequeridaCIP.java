package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.DocuRequeridaCIP;
import com.srn.erp.cip.bm.TarjetaCIP;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;
import com.srn.erp.cip.da.DBDocuRequeridaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDocuRequeridaCIP extends FactoryObjetoLogico { 

  public FactoryDocuRequeridaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DocuRequeridaCIP docurequeridacip = (DocuRequeridaCIP) objLog;
    docurequeridacip.setOID(db.getInteger(DBDocuRequeridaCIP.OID_TIPO_DOCU_REQ));
    docurequeridacip.setTarjeta(TarjetaCIP.findByOidProxy(db.getInteger(DBDocuRequeridaCIP.OID_TARJETA),getSesion()));
    docurequeridacip.setTipo_docu(TipoDocumentacionCIP.findByOidProxy(db.getInteger(DBDocuRequeridaCIP.OID_TIPO_DOCU),getSesion()));
    docurequeridacip.setActivo(db.getBoolean(DBDocuRequeridaCIP.ACTIVO));

  }
}
