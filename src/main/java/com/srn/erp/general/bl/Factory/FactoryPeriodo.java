package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeriodo extends FactoryObjetoLogico {

  public FactoryPeriodo() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Periodo periodo = (Periodo) objLog;
    periodo.setOID(db.getInteger(DBPeriodo.OID_PERI));
    periodo.setCodigo(db.getString(DBPeriodo.CODIGO));
    periodo.setDescripcion(db.getString(DBPeriodo.DESCRIPCION));
    periodo.setFechadesde(db.getDate(DBPeriodo.FECHA_DESDE));
    periodo.setFechahasta(db.getDate(DBPeriodo.FECHA_HASTA));
    periodo.setTipo(db.getString(DBPeriodo.TIPO));
    periodo.setActivo(db.getBoolean(DBPeriodo.ACTIVO));

  }
}
