package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.da.DBRecluEstCandidatoBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluEstCandidatoBusq extends FactoryObjetoLogico { 

  public FactoryRecluEstCandidatoBusq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluEstCandidatoBusq recluestcandidatobusq = (RecluEstCandidatoBusq) objLog;
    recluestcandidatobusq.setOID(db.getInteger(DBRecluEstCandidatoBusq.OID_EST_CAND_BUSQ));
    recluestcandidatobusq.setCodigo(db.getString(DBRecluEstCandidatoBusq.CODIGO));
    recluestcandidatobusq.setDescripcion(db.getString(DBRecluEstCandidatoBusq.DESCRIPCION));
    recluestcandidatobusq.setActivo(db.getBoolean(DBRecluEstCandidatoBusq.ACTIVO));
    recluestcandidatobusq.setColor(db.getInteger(DBRecluEstCandidatoBusq.COLOR));
    recluestcandidatobusq.setPuedeCerrarBusqueda(db.getBoolean(DBRecluEstCandidatoBusq.PUEDE_CERRAR_BUSQ));
    recluestcandidatobusq.setEstadoPostulante(RecluEstadoPostulante.findByOidProxy(db.getInteger(DBRecluEstCandidatoBusq.OID_ESTADO_POSTU), this.getSesion()));
    recluestcandidatobusq.setSugerirCierre(db.getBoolean(DBRecluEstCandidatoBusq.SUGERIR_CIERRE));
    recluestcandidatobusq.setAlCierreEstado(RecluEstCandidatoBusq.findByOidProxy(db.getInteger(DBRecluEstCandidatoBusq.AL_CIERRE_EST_BUSQ), this.getSesion()));
    
    
  }
}
