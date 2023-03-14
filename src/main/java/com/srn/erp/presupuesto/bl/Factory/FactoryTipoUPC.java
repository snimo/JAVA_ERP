package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.TipoUPC;
import com.srn.erp.presupuesto.da.DBTipoUPC;

public class FactoryTipoUPC extends FactoryObjetoLogico { 

  public FactoryTipoUPC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoUPC tipoupc = (TipoUPC) objLog;
    tipoupc.setOID(db.getInteger(DBTipoUPC.OID_TIPO_UPC));
    tipoupc.setCodigo(db.getString(DBTipoUPC.CODIGO));
    tipoupc.setDescripcion(db.getString(DBTipoUPC.DESCRIPCION));
    tipoupc.setActivo(db.getBoolean(DBTipoUPC.ACTIVO));

  }
}
