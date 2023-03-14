package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.GrupoDetalleVenta;
import com.srn.erp.ventas.da.DBGrupoDetalleVenta;

public class FactoryGrupoDetalleVenta extends FactoryObjetoLogico { 

  public FactoryGrupoDetalleVenta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoDetalleVenta grupodetalleventa = (GrupoDetalleVenta) objLog;
    grupodetalleventa.setOID(db.getInteger(DBGrupoDetalleVenta.OID));
    grupodetalleventa.setCodigo(db.getString(DBGrupoDetalleVenta.CODIGO));
    grupodetalleventa.setDescripcion(db.getString(DBGrupoDetalleVenta.DESCRIPCION));
    grupodetalleventa.setActivo(db.getBoolean(DBGrupoDetalleVenta.ACTIVO));

  }
}
