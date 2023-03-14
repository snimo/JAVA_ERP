package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluEstadoProceso;
import com.srn.erp.reclutamiento.bm.RecluOperacion;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.bm.RecluProcesoCandidato;
import com.srn.erp.reclutamiento.bm.RecluSectores;
import com.srn.erp.reclutamiento.bm.RecluSelector;
import com.srn.erp.reclutamiento.bm.RecluTipoFormuProceso;
import com.srn.erp.reclutamiento.da.DBRecluProcesoCandidato;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluProcesoCandidato extends FactoryObjetoLogico { 

  public FactoryRecluProcesoCandidato() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluProcesoCandidato recluprocesocandidato = (RecluProcesoCandidato) objLog;
    recluprocesocandidato.setOID(db.getInteger(DBRecluProcesoCandidato.OID_PROCESO_SELEC));
    recluprocesocandidato.setCandidato_busq(RecluCandidatoBusq.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_CANDIDATO_BUSQ),getSesion()));
    recluprocesocandidato.setOrden(db.getInteger(DBRecluProcesoCandidato.ORDEN));
    recluprocesocandidato.setProceso(RecluProceso.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_PROCESO),getSesion()));
    recluprocesocandidato.setConcepto_proceso(RecluConceptoProceso.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_CONC_PROCESO),getSesion()));
    recluprocesocandidato.setCosto(db.getDouble(DBRecluProcesoCandidato.COSTO));
    recluprocesocandidato.setEstado(RecluEstadoProceso.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_EST_PROC_SEL),getSesion()));
    recluprocesocandidato.setFecha_planif(db.getDate(DBRecluProcesoCandidato.FECHA_PLANIF));
    recluprocesocandidato.setHora_planif(db.getString(DBRecluProcesoCandidato.HORA_PLANIF));
    recluprocesocandidato.setPersona(db.getString(DBRecluProcesoCandidato.PERSONA));
    recluprocesocandidato.setObservaciones(db.getString(DBRecluProcesoCandidato.OBSERVACIONES));
    recluprocesocandidato.setPuede_iniciar(db.getBoolean(DBRecluProcesoCandidato.PUEDE_INICIAR));
    recluprocesocandidato.setActivo(db.getBoolean(DBRecluProcesoCandidato.ACTIVO));
    recluprocesocandidato.setNroArchivo(db.getInteger(DBRecluProcesoCandidato.NRO_ARCHIVO));
    recluprocesocandidato.setNombreArchivo(db.getString(DBRecluProcesoCandidato.NOMBRE_ARCHIVO));
    recluprocesocandidato.setPostulante(RecluPostulante.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_POSTULANTE),getSesion()));
    recluprocesocandidato.setTipoFormulario(RecluTipoFormuProceso.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_TIPO_FORMU),getSesion()));
    recluprocesocandidato.setCompletoTipoFormulario(db.getBoolean(DBRecluProcesoCandidato.COMPLETO_TIPO_FORMU));
    recluprocesocandidato.setFecCompletoTipoFormulario(db.getDate(DBRecluProcesoCandidato.FEC_COMPLETO_TF));
    recluprocesocandidato.setSeAnuncio(db.getBoolean(DBRecluProcesoCandidato.SE_ANUNCIO));
    recluprocesocandidato.setFecHorSeAnuncio(db.getDateTime(DBRecluProcesoCandidato.FEC_HOR_SE_ANUNCIO));
    recluprocesocandidato.setOperacion(RecluOperacion.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_OPERACION),getSesion()));
    recluprocesocandidato.setSector(RecluSectores.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_SECTOR),getSesion()));
    recluprocesocandidato.setSelector(RecluSelector.findByOidProxy(db.getInteger(DBRecluProcesoCandidato.OID_SELECTOR),getSesion()));
    
  }
}
