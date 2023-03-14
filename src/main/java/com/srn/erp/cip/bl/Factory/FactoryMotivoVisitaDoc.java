package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.bm.MotivoVisitaDoc;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;
import com.srn.erp.cip.da.DBMotivoVisitaDoc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoVisitaDoc extends FactoryObjetoLogico { 

  public FactoryMotivoVisitaDoc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoVisitaDoc motivovisitadoc = (MotivoVisitaDoc) objLog;
    motivovisitadoc.setOID(db.getInteger(DBMotivoVisitaDoc.OID_MOT_VIS_DOC));
    motivovisitadoc.setMotivo(MotivoVisita.findByOidProxy(db.getInteger(DBMotivoVisitaDoc.OID_MOT_VISITA),getSesion()));
    motivovisitadoc.setTipo_docu(TipoDocumentacionCIP.findByOidProxy(db.getInteger(DBMotivoVisitaDoc.OID_TIPO_DOCU),getSesion()));
    motivovisitadoc.setDias_aviso_venc(db.getInteger(DBMotivoVisitaDoc.DIAS_AVISO_VENC));
    motivovisitadoc.setActivo(db.getBoolean(DBMotivoVisitaDoc.ACTIVO));

  }
}
