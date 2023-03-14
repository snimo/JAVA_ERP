package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.UPC;
import com.srn.erp.presupuesto.da.DBUPC;

public class FactoryUPC extends FactoryObjetoLogico { 

  public FactoryUPC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UPC upc = (UPC) objLog;
    upc.setOID(db.getInteger(DBUPC.OID_UPC));
    upc.setCodigo(db.getString(DBUPC.CODIGO));
    upc.setDescripcion(db.getString(DBUPC.DESCRIPCION));
    upc.setActivo(db.getBoolean(DBUPC.ACTIVO));

  }
}
