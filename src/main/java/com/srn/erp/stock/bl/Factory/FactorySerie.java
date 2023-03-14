package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Serie;
import com.srn.erp.stock.da.DBSerie;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySerie extends FactoryObjetoLogico {

  public FactorySerie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Serie serie = (Serie) objLog;
    serie.setOID(db.getInteger(DBSerie.OID_SERIE));
    serie.setCodigo(db.getString(DBSerie.CODIGO));
    serie.setDescripcion(db.getString(DBSerie.DESCRIPCION));
    serie.setNro(db.getInteger(DBSerie.NRO));
    serie.setFec_inicio(db.getDate(DBSerie.FEC_INICIO));
    serie.setFec_vto(db.getDate(DBSerie.FEC_VTO));
    serie.setActivo(db.getBoolean(DBSerie.ACTIVO));

  }
}
