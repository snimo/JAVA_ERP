package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Leyenda;
import com.srn.erp.contabilidad.da.DBLeyenda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLeyenda extends FactoryObjetoLogico {

  public FactoryLeyenda() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Leyenda leyenda = (Leyenda) objLog;
    leyenda.setOID(db.getInteger(DBLeyenda.OID_LEYENDA));
    leyenda.setCodigo(db.getString(DBLeyenda.CODIGO));
    leyenda.setDescripcion(db.getString(DBLeyenda.DESCRIPCION));
    leyenda.setActivo(db.getBoolean(DBLeyenda.ACTIVO));

  }
}
