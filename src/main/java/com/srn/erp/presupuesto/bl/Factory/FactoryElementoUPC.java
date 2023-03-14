package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.ElementoUPC;
import com.srn.erp.presupuesto.da.DBElementoUPC;

public class FactoryElementoUPC extends FactoryObjetoLogico { 

  public FactoryElementoUPC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ElementoUPC elementoupc = (ElementoUPC) objLog;
    elementoupc.setOID(db.getInteger(DBElementoUPC.OID_ELEMENTO_UPC));
    elementoupc.setCodigo(db.getString(DBElementoUPC.CODIGO));
    elementoupc.setDescripcion(db.getString(DBElementoUPC.DESCRIPCION));
    elementoupc.setTipo(db.getString(DBElementoUPC.TIPO));
    elementoupc.setNro_interno(db.getInteger(DBElementoUPC.NRO_INTERNO));
    elementoupc.setActivo(db.getBoolean(DBElementoUPC.ACTIVO));
  }
}
