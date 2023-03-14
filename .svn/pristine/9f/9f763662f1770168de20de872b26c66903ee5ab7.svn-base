package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.EstadoSituacion;
import com.srn.erp.ventas.da.DBEstadoSituacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoSituacion extends FactoryObjetoLogico {

  public FactoryEstadoSituacion() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoSituacion estadosituacion = (EstadoSituacion) objLog;
    estadosituacion.setOID(db.getInteger(DBEstadoSituacion.OID_EST_SITUACION));
    estadosituacion.setCodigo(db.getString(DBEstadoSituacion.CODIGO));
    estadosituacion.setDescripcion(db.getString(DBEstadoSituacion.DESCRIPCION));
    estadosituacion.setComportamiento(db.getString(DBEstadoSituacion.COMPO));
    estadosituacion.setActivo(db.getBoolean(DBEstadoSituacion.ACTIVO));
  }
}
