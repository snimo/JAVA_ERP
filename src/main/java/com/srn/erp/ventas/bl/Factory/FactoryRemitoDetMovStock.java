package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.RemitoDetMovStock;
import com.srn.erp.ventas.da.DBRemitoDetMovStock;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRemitoDetMovStock extends FactoryObjetoLogico {

  public FactoryRemitoDetMovStock() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RemitoDetMovStock remitodetmovstock = (RemitoDetMovStock) objLog;
    remitodetmovstock.setOID(db.getInteger(DBRemitoDetMovStock.OID_RTO_MOV_STK));
    remitodetmovstock.setRemito_detalle(RemitoDet.findByOidProxy(db.getInteger(DBRemitoDetMovStock.OID_REMITO_DET),getSesion()));
    remitodetmovstock.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBRemitoDetMovStock.OID_UBI_DEPO),getSesion()));
    remitodetmovstock.setProducto(Producto.findByOidProxy(db.getInteger(DBRemitoDetMovStock.OID_PRODUCTO),getSesion()));
    remitodetmovstock.setDeposito(Deposito.findByOidProxy(db.getInteger(DBRemitoDetMovStock.OID_DEPOSITO),getSesion()));
    remitodetmovstock.setTipo_mov(db.getString(DBRemitoDetMovStock.TIPO_MOV));
    remitodetmovstock.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBRemitoDetMovStock.OID_ESTADO_STOCK),getSesion()));
    remitodetmovstock.setActivo(db.getBoolean(DBRemitoDetMovStock.ACTIVO));
    remitodetmovstock.setAfectaStkFisico(db.getBoolean(DBRemitoDetMovStock.AFECTA_STK_FISICO));
  }
}
