package com.srn.erp.produccion.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.produccion.bm.UMTiempoProduccion;
import com.srn.erp.produccion.da.DBUMTiempoProduccion;

public class FactoryUMTiempoProduccion extends FactoryObjetoLogico { 

  public FactoryUMTiempoProduccion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UMTiempoProduccion umtiempoproduccion = (UMTiempoProduccion) objLog;
    umtiempoproduccion.setOID(db.getInteger(DBUMTiempoProduccion.OID_UM_TIEMPO));
    umtiempoproduccion.setCodigo(db.getString(DBUMTiempoProduccion.CODIGO));
    umtiempoproduccion.setDescripcion(db.getString(DBUMTiempoProduccion.DESCRIPCION));
    umtiempoproduccion.setActivo(db.getBoolean(DBUMTiempoProduccion.ACTIVO));
    umtiempoproduccion.setComportamiento(db.getString(DBUMTiempoProduccion.COMPORTAMIENTO));

  }
}
