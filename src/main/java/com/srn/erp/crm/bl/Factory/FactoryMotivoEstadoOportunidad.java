package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.MotivoEstadoOportunidad;
import com.srn.erp.crm.da.DBMotivoEstadoOportunidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoEstadoOportunidad extends FactoryObjetoLogico { 

  public FactoryMotivoEstadoOportunidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoEstadoOportunidad motivoestadooportunidad = (MotivoEstadoOportunidad) objLog;
    motivoestadooportunidad.setOID(db.getInteger(DBMotivoEstadoOportunidad.OID_EST_MOT_OPOR));
    motivoestadooportunidad.setCodigo(db.getString(DBMotivoEstadoOportunidad.CODIGO));
    motivoestadooportunidad.setDescripcion(db.getString(DBMotivoEstadoOportunidad.DESCRIPCION));
    motivoestadooportunidad.setActivo(db.getBoolean(DBMotivoEstadoOportunidad.ACTIVO));

  }
}
