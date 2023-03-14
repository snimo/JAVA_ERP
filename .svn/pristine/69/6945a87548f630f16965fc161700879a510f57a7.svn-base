package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.IngStockDevVtasDet;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;
import com.srn.erp.ventas.da.DBIngStockDevVtasDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryIngStockDevVtasDet extends FactoryObjetoLogico { 

  public FactoryIngStockDevVtasDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    IngStockDevVtasDet ingstockdevvtasdet = (IngStockDevVtasDet) objLog;
    ingstockdevvtasdet.setOID(db.getInteger(DBIngStockDevVtasDet.OID_ING_STK_DET));
    ingstockdevvtasdet.setIngresodevolucionstockcab(IngresoDevolucionStockCab.findByOidProxy(db.getInteger(DBIngStockDevVtasDet.OID_ING_DEV_STK),getSesion()));
    ingstockdevvtasdet.setDevolucion_det(DevolucionVtasDet.findByOidProxy(db.getInteger(DBIngStockDevVtasDet.OID_DEV_DET),getSesion()));
    ingstockdevvtasdet.setCantidad(db.getDouble(DBIngStockDevVtasDet.CANTIDAD));
    ingstockdevvtasdet.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBIngStockDevVtasDet.OID_UM),getSesion()));
    ingstockdevvtasdet.setMovimiento_stock(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBIngStockDevVtasDet.OID_MOV_STOCK),getSesion()));

  }
}
