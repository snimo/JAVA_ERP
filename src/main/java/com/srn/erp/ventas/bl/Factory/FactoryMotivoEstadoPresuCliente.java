package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.MotivoEstadoPresuCliente;
import com.srn.erp.ventas.da.DBMotivoEstadoPresuCliente;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoEstadoPresuCliente extends FactoryObjetoLogico { 

  public FactoryMotivoEstadoPresuCliente() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoEstadoPresuCliente motivoestadopresucliente = (MotivoEstadoPresuCliente) objLog;
    motivoestadopresucliente.setOID(db.getInteger(DBMotivoEstadoPresuCliente.OID_MOTIVO));
    motivoestadopresucliente.setCodigo(db.getString(DBMotivoEstadoPresuCliente.CODIGO));
    motivoestadopresucliente.setDescripcion(db.getString(DBMotivoEstadoPresuCliente.DESCRIPCION));
    motivoestadopresucliente.setActivo(db.getBoolean(DBMotivoEstadoPresuCliente.ACTIVO));

  }
}
