package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.MotivoComprobante;
import com.srn.erp.general.da.DBMotivoComprobante;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoComprobante extends FactoryObjetoLogico { 

  public FactoryMotivoComprobante() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoComprobante motivocomprobante = (MotivoComprobante) objLog;
    motivocomprobante.setOID(db.getInteger(DBMotivoComprobante.OID));
    motivocomprobante.setCodigo(db.getString(DBMotivoComprobante.CODIGO));
    motivocomprobante.setDescripcion(db.getString(DBMotivoComprobante.DESCRIPCION));
    motivocomprobante.setActivo(db.getBoolean(DBMotivoComprobante.ACTIVO));

  }
}
