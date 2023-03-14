package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluBusqueda;
import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluMotiEstCandBusq;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.da.DBRecluCandidatoBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluCandidatoBusq extends FactoryObjetoLogico { 

  public FactoryRecluCandidatoBusq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluCandidatoBusq reclucandidatobusq = (RecluCandidatoBusq) objLog;
    reclucandidatobusq.setOID(db.getInteger(DBRecluCandidatoBusq.OID_CANDIDATO_BUSQ));
    reclucandidatobusq.setBusqueda(RecluBusqueda.findByOidProxy(db.getInteger(DBRecluCandidatoBusq.OID_BUSQUEDA_ACT),getSesion()));
    reclucandidatobusq.setOid_postulante(RecluPostulante.findByOidProxy(db.getInteger(DBRecluCandidatoBusq.OID_POSTULANTE),getSesion()));
    reclucandidatobusq.setFec_asigno(db.getDate(DBRecluCandidatoBusq.FEC_ASIGNO));
    reclucandidatobusq.setHora_asigno(db.getString(DBRecluCandidatoBusq.HORA_ASIGNO));
    reclucandidatobusq.setUsuario_asigno(Usuario.findByOidProxy(db.getInteger(DBRecluCandidatoBusq.OID_USU_ASIGNO),getSesion()));
    reclucandidatobusq.setEstado_busqueda(RecluEstCandidatoBusq.findByOidProxy(db.getInteger(DBRecluCandidatoBusq.OID_EST_CAND_BUSQ),getSesion()));
    reclucandidatobusq.setComentario(db.getString(DBRecluCandidatoBusq.COMENTARIO));
    reclucandidatobusq.setActivo(db.getBoolean(DBRecluCandidatoBusq.ACTIVO));
    reclucandidatobusq.setMotivo(RecluMotiEstCandBusq.findByOidProxy(db.getInteger(DBRecluCandidatoBusq.OID_MOT_EST_CAND),getSesion()));
    reclucandidatobusq.setFechaIngreso(db.getDate(DBRecluCandidatoBusq.FEC_INGRESO));
  }
}
