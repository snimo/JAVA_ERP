package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.MotivoDevolucionCliente;
import com.srn.erp.ventas.da.DBMotivoDevolucionCliente;

public class FactoryMotivoDevolucionCliente extends FactoryObjetoLogico { 

  public FactoryMotivoDevolucionCliente() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoDevolucionCliente motivodevolucioncliente = (MotivoDevolucionCliente) objLog;
    motivodevolucioncliente.setOID(db.getInteger(DBMotivoDevolucionCliente.OID));
    motivodevolucioncliente.setCodigo(db.getString(DBMotivoDevolucionCliente.CODIGO));
    motivodevolucioncliente.setDescripcion(db.getString(DBMotivoDevolucionCliente.DESCRIPCION));
    motivodevolucioncliente.setActivo(db.getBoolean(DBMotivoDevolucionCliente.ACTIVO));

  }
}
