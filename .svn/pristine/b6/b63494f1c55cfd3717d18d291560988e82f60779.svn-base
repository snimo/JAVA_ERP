package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.UbicacionDeposito;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoCabMovStock;
import com.srn.erp.ventas.da.DBRemitoCabMovStock;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRemitoCabMovStock extends FactoryObjetoLogico {

  public FactoryRemitoCabMovStock() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RemitoCabMovStock remitocabmovstock = (RemitoCabMovStock) objLog;
    remitocabmovstock.setOID(db.getInteger(DBRemitoCabMovStock.OID_RTO_CAB_STK));
    remitocabmovstock.setRemito_cabecera(RemitoCab.findByOidProxy(db.getInteger(DBRemitoCabMovStock.OID_REMITO_CAB),getSesion()));
    remitocabmovstock.setDeposito(Deposito.findByOidProxy(db.getInteger(DBRemitoCabMovStock.OID_DEPOSITO),getSesion()));
    remitocabmovstock.setTipo_movi(db.getString(DBRemitoCabMovStock.TIPO_MOVI));
    remitocabmovstock.setEstado_stock(EstadoStock.findByOidProxy(db.getInteger(DBRemitoCabMovStock.OID_ESTADO_STOCK),getSesion()));
    remitocabmovstock.setUbicacion_deposito(UbicacionDeposito.findByOidProxy(db.getInteger(DBRemitoCabMovStock.OID_UBI_DEPO),getSesion()));
    remitocabmovstock.setActivo(db.getBoolean(DBRemitoCabMovStock.ACTIVO));
    remitocabmovstock.setAfectaStockFisico(db.getBoolean(DBRemitoCabMovStock.AFECTA_STK_FISICO));
  }
}
