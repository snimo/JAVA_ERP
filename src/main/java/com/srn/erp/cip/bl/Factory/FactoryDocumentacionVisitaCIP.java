package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.DocumentacionVisitaCIP;
import com.srn.erp.cip.bm.GrupoVisita;
import com.srn.erp.cip.bm.TipoDocumentacionCIP;
import com.srn.erp.cip.bm.Visita;
import com.srn.erp.cip.da.DBDocumentacionVisitaCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryDocumentacionVisitaCIP extends FactoryObjetoLogico { 

  public FactoryDocumentacionVisitaCIP() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DocumentacionVisitaCIP documentacionvisitacip = (DocumentacionVisitaCIP) objLog;
    documentacionvisitacip.setOID(db.getInteger(DBDocumentacionVisitaCIP.OID_DOCU_VISITA));
    documentacionvisitacip.setVistat(Visita.findByOidProxy(db.getInteger(DBDocumentacionVisitaCIP.OID_VISITA),getSesion()));
    documentacionvisitacip.setTipo_documentacion(TipoDocumentacionCIP.findByOidProxy(db.getInteger(DBDocumentacionVisitaCIP.OID_TIPO_DOCU),getSesion()));
    documentacionvisitacip.setControla_fecha(db.getBoolean(DBDocumentacionVisitaCIP.CONTROLA_FECHA));
    documentacionvisitacip.setFec_vto(db.getDate(DBDocumentacionVisitaCIP.FEC_VTO));
    documentacionvisitacip.setObservacion(db.getString(DBDocumentacionVisitaCIP.OBSERVACION));
    documentacionvisitacip.setActivo(db.getBoolean(DBDocumentacionVisitaCIP.ACTIVO));
    documentacionvisitacip.setPresentado(db.getBoolean(DBDocumentacionVisitaCIP.PRESENTADO));
    documentacionvisitacip.setFecPresentacion(db.getDate(DBDocumentacionVisitaCIP.FEC_PRESENT));
    documentacionvisitacip.setFecEmision(db.getDate(DBDocumentacionVisitaCIP.FEC_EMISION));
    documentacionvisitacip.setGrupoVisita(GrupoVisita.findByOidProxy(db.getInteger(DBDocumentacionVisitaCIP.OID_GRUPO_VISITA),getSesion()));
  }
  
}
