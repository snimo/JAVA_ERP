package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.EstadoPresupuestoCliente;
import com.srn.erp.ventas.da.DBEstadoPresupuestoCliente;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstadoPresupuestoCliente extends FactoryObjetoLogico { 

  public FactoryEstadoPresupuestoCliente() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoPresupuestoCliente estadopresupuestocliente = (EstadoPresupuestoCliente) objLog;
    estadopresupuestocliente.setOID(db.getInteger(DBEstadoPresupuestoCliente.OID_ESTADO));
    estadopresupuestocliente.setCodigo(db.getString(DBEstadoPresupuestoCliente.CODIGO));
    estadopresupuestocliente.setDescripcion(db.getString(DBEstadoPresupuestoCliente.DESCRIPCION));
    estadopresupuestocliente.setActivo(db.getBoolean(DBEstadoPresupuestoCliente.ACTIVO));

  }
}
