package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.AjuStkPartSerie;
import com.srn.erp.stock.bm.ComproAjusteStkDet;
import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.stock.da.DBAjuStkPartSerie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAjuStkPartSerie extends FactoryObjetoLogico {

  public FactoryAjuStkPartSerie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AjuStkPartSerie ajustkpartserie = (AjuStkPartSerie) objLog;
    ajustkpartserie.setOID(db.getInteger(DBAjuStkPartSerie.OID_AJU_STK_P_S));
    ajustkpartserie.setAju_stk_det(ComproAjusteStkDet.findByOidProxy(db.getInteger(DBAjuStkPartSerie.OID_AJU_STK_DET),getSesion()));
    ajustkpartserie.setPartida(Partida.findByOidProxy(db.getInteger(DBAjuStkPartSerie.OID_PARTIDA),getSesion()));
    ajustkpartserie.setSerie(Serie.findByOidProxy(db.getInteger(DBAjuStkPartSerie.OID_SERIE),getSesion()));
    ajustkpartserie.setCantidad(db.getDouble(DBAjuStkPartSerie.CANTIDAD));
    ajustkpartserie.setActivo(db.getBoolean(DBAjuStkPartSerie.ACTIVO));
  }
}
