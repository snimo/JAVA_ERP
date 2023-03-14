package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.stock.da.DBMovStockTalonarioDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMovStockTalonarioDeposito extends FactoryObjetoLogico {

  public FactoryMovStockTalonarioDeposito() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MovStockTalonarioDeposito movstocktalonariodeposito = (MovStockTalonarioDeposito) objLog;
    movstocktalonariodeposito.setOID(db.getInteger(DBMovStockTalonarioDeposito.OID_MOV_STK_TAL));
    movstocktalonariodeposito.setTipo_conf_mov(TipoConfMovStkTalonario.findByOidProxy(db.getInteger(DBMovStockTalonarioDeposito.OID_TIPO_CONF_MOV),getSesion()));
    movstocktalonariodeposito.setSecu(db.getInteger(DBMovStockTalonarioDeposito.SECU));
    movstocktalonariodeposito.setDeposito(Deposito.findByOidProxy(db.getInteger(DBMovStockTalonarioDeposito.OID_DEPOSITO),getSesion()));
    movstocktalonariodeposito.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBMovStockTalonarioDeposito.OID_ESTADO_STOCK),getSesion()));
    movstocktalonariodeposito.setTipo_movimiento(db.getString(DBMovStockTalonarioDeposito.TIPO_MOVIMIENTO));
    movstocktalonariodeposito.setActivo(db.getBoolean(DBMovStockTalonarioDeposito.ACTIVO));
    movstocktalonariodeposito.setAfectaStockFisico(db.getBoolean(DBMovStockTalonarioDeposito.AFECTA_STOCK_FISICO));
  }
}
