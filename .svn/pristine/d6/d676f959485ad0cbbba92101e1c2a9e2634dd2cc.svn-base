package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.PeriodoStockReal;
import com.srn.erp.stock.da.DBPeriodoStockReal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriodoStockReal extends FactoryObjetoLogico {

  public FactoryPeriodoStockReal() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeriodoStockReal periodoStockReal = (PeriodoStockReal) objLog;
    periodoStockReal.setOID(db.getInteger(DBPeriodoStockReal.OID_PERI));
    periodoStockReal.setCodigo(db.getString(DBPeriodoStockReal.CODIGO));
    periodoStockReal.setDescripcion(db.getString(DBPeriodoStockReal.DESCRIPCION));
    periodoStockReal.setFechadesde(db.getDate(DBPeriodoStockReal.FECHA_DESDE));
    periodoStockReal.setFechahasta(db.getDate(DBPeriodoStockReal.FECHA_HASTA));
    periodoStockReal.setTipo(db.getString(DBPeriodoStockReal.TIPO));
    periodoStockReal.setActivo(db.getBoolean(DBPeriodoStockReal.ACTIVO));
  }
}
