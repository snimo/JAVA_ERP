package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.RemitoDetPartidaSerie;
import com.srn.erp.ventas.da.DBRemitoDetPartidaSerie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRemitoDetPartidaSerie extends FactoryObjetoLogico {

  public FactoryRemitoDetPartidaSerie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RemitoDetPartidaSerie remitodetpartidaserie = (RemitoDetPartidaSerie) objLog;
    remitodetpartidaserie.setOID(db.getInteger(DBRemitoDetPartidaSerie.OID_RTO_DET_P_S));
    remitodetpartidaserie.setRemito_detalle(RemitoDet.findByOidProxy(db.getInteger(DBRemitoDetPartidaSerie.OID_REMITO_DET),getSesion()));
    remitodetpartidaserie.setPartida(Partida.findByOidProxy(db.getInteger(DBRemitoDetPartidaSerie.OID_PARTIDA),getSesion()));
    remitodetpartidaserie.setSerie(Serie.findByOidProxy(db.getInteger(DBRemitoDetPartidaSerie.OID_SERIE),getSesion()));
    remitodetpartidaserie.setCantidad(db.getDouble(DBRemitoDetPartidaSerie.CANTIDAD));
    remitodetpartidaserie.setActivo(db.getBoolean(DBRemitoDetPartidaSerie.ACTIVO));

  }
}
