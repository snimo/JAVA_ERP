package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluCurriPostu;
import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.da.DBRecluCurriPostu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluCurriPostu extends FactoryObjetoLogico { 

  public FactoryRecluCurriPostu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluCurriPostu reclucurripostu = (RecluCurriPostu) objLog;
    reclucurripostu.setOID(db.getInteger(DBRecluCurriPostu.OID_CURRICULUM));
    reclucurripostu.setPostulante(RecluPostulante.findByOidProxy(db.getInteger(DBRecluCurriPostu.OID_POSTULANTE),getSesion()));
    reclucurripostu.setFecha_recepcion(db.getDate(DBRecluCurriPostu.FECHA_RECEPCION));
    reclucurripostu.setEntregado_por(db.getString(DBRecluCurriPostu.ENTREGADO_POR));
    reclucurripostu.setObservacion(db.getString(DBRecluCurriPostu.OBSERVACION));
    reclucurripostu.setActivo(db.getBoolean(DBRecluCurriPostu.ACTIVO));
    reclucurripostu.setNroArchivoCV(db.getInteger(DBRecluCurriPostu.NRO_ARCHIVO_CV));
    reclucurripostu.setNombreArchivo(db.getString(DBRecluCurriPostu.NOMBRE_ARCHIVO));
  }
  
}
