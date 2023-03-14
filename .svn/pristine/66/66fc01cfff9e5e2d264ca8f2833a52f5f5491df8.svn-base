package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.da.DBPartida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPartida extends FactoryObjetoLogico {

  public FactoryPartida() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Partida partida = (Partida) objLog;
    partida.setOID(db.getInteger(DBPartida.OID_PARTIDA));
    partida.setCodigo(db.getString(DBPartida.CODIGO));
    partida.setDescripcion(db.getString(DBPartida.DESCRIPCION));
    partida.setNro(db.getInteger(DBPartida.NRO));
    partida.setFec_inicio(db.getDate(DBPartida.FEC_INICIO));
    partida.setFec_vto(db.getDate(DBPartida.FEC_VTO));
    partida.setActivo(db.getBoolean(DBPartida.ACTIVO));
  }
}
