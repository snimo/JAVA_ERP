package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluEstadoPostulante;
import com.srn.erp.reclutamiento.da.DBRecluEstadoPostulante;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluEstadoPostulante extends FactoryObjetoLogico { 

  public FactoryRecluEstadoPostulante() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluEstadoPostulante recluestadopostulante = (RecluEstadoPostulante) objLog;
    recluestadopostulante.setOID(db.getInteger(DBRecluEstadoPostulante.OID_ESTADO_POSTU));
    recluestadopostulante.setCodigo(db.getString(DBRecluEstadoPostulante.CODIGO));
    recluestadopostulante.setDescripcion(db.getString(DBRecluEstadoPostulante.DESCRIPCION));
    recluestadopostulante.setActivo(db.getBoolean(DBRecluEstadoPostulante.ACTIVO));
    recluestadopostulante.setColor(db.getInteger(DBRecluEstadoPostulante.COLOR));
    recluestadopostulante.setSeleccionado(db.getBoolean(DBRecluEstadoPostulante.SELECCIONADO));
  }
}
