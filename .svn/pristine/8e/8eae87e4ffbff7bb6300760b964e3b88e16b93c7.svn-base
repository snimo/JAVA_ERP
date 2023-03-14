package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.LugarEntregaVenta;
import com.srn.erp.ventas.da.DBLugarEntregaVenta;

public class FactoryLugarEntregaVenta extends FactoryObjetoLogico { 

  public FactoryLugarEntregaVenta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LugarEntregaVenta lugarentregaventa = (LugarEntregaVenta) objLog;
    lugarentregaventa.setOID(db.getInteger(DBLugarEntregaVenta.OID_LUGAR_ENT_VTA));
    lugarentregaventa.setCodigo(db.getString(DBLugarEntregaVenta.CODIGO));
    lugarentregaventa.setDescripcion(db.getString(DBLugarEntregaVenta.DESCRIPCION));
    lugarentregaventa.setActivo(db.getBoolean(DBLugarEntregaVenta.ACTIVO));

  }
}
