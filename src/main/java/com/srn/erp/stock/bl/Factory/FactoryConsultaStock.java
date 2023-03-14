package com.srn.erp.stock.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.stock.bm.ConsultaStock;
import com.srn.erp.stock.da.DBConsultaStock;

public class FactoryConsultaStock extends FactoryObjetoLogico { 

  public FactoryConsultaStock() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
 
	ConsultaStock consultastock = (ConsultaStock) objLog;
    consultastock.setOid_producto(db.getInteger(DBConsultaStock.OID_PRODUCTO));
    consultastock.setCod_producto(db.getString(DBConsultaStock.COD_PRODUCTO));
    consultastock.setDesc_producto(db.getString(DBConsultaStock.DESC_PRODUCTO));
    consultastock.setCantidad(db.getDouble(DBConsultaStock.CANTIDAD));
    consultastock.setOid_um(db.getInteger(DBConsultaStock.OID_UM));
    consultastock.setOid_deposito(db.getInteger(DBConsultaStock.OID_DEPOSITO));

  }
}
