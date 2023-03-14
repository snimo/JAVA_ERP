package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SeguimientoStock;
import com.srn.erp.stock.da.DBSeguimientoStock;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeguimientoStock extends FactoryObjetoLogico { 

  public FactorySeguimientoStock() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguimientoStock seguimientostock = (SeguimientoStock) objLog;
    seguimientostock.setOID(db.getInteger(DBSeguimientoStock.OID_SEGUI_STOCK));
    seguimientostock.setProducto(Producto.findByOidProxy(db.getInteger(DBSeguimientoStock.OID_PRODUCTO),getSesion()));
    seguimientostock.setAgrupador_deposito(AgrupadorDeposito.findByOidProxy(db.getInteger(DBSeguimientoStock.OID_AGRUPADOR_DEPO),getSesion()));
    seguimientostock.setPunto_pedido(db.getMoney(DBSeguimientoStock.PUNTO_PEDIDO));
    seguimientostock.setStock_deseado(db.getMoney(DBSeguimientoStock.STOCK_DESEADO));
    seguimientostock.setValClasifEnt(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBSeguimientoStock.OID_VAL_CLASIF_ENT),getSesion()));
  }
}
