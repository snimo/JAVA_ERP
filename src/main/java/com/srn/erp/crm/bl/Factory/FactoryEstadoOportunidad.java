package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.EstadoOportunidad;
import com.srn.erp.crm.da.DBEstadoOportunidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoOportunidad extends FactoryObjetoLogico { 

  public FactoryEstadoOportunidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoOportunidad estadooportunidad = (EstadoOportunidad) objLog;
    estadooportunidad.setOID(db.getInteger(DBEstadoOportunidad.OID_ESTADO_OPOR));
    estadooportunidad.setCodigo(db.getString(DBEstadoOportunidad.CODIGO));
    estadooportunidad.setDescripcion(db.getString(DBEstadoOportunidad.DESCRIPCION));
    estadooportunidad.setComportamiento(db.getString(DBEstadoOportunidad.COMPO_COMPORTUNIDAD));
    estadooportunidad.setActivo(db.getBoolean(DBEstadoOportunidad.ACTIVO));

  }
}
