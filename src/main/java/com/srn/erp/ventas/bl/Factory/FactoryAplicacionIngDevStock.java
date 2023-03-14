package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AplicacionIngDevStock;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.IngStockDevVtasDet;
import com.srn.erp.ventas.da.DBAplicacionIngDevStock;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicacionIngDevStock extends FactoryObjetoLogico { 

  public FactoryAplicacionIngDevStock() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicacionIngDevStock aplicacioningdevstock = (AplicacionIngDevStock) objLog;
    aplicacioningdevstock.setOID(db.getInteger(DBAplicacionIngDevStock.OID_APL_DEV_STK));
    aplicacioningdevstock.setDevolucion_vtas_det(DevolucionVtasDet.findByOidProxy(db.getInteger(DBAplicacionIngDevStock.OID_DEV_DET),getSesion()));
    aplicacioningdevstock.setDevolucion_stk_det(IngStockDevVtasDet.findByOidProxy(db.getInteger(DBAplicacionIngDevStock.OID_ING_STK_DET),getSesion()));
    aplicacioningdevstock.setCantidad(db.getDouble(DBAplicacionIngDevStock.CANTIDAD));
    aplicacioningdevstock.setActivo(db.getBoolean(DBAplicacionIngDevStock.ACTIVO));

  }
}
