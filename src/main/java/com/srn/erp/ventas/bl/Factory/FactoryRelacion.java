package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.Relacion;
import com.srn.erp.ventas.da.DBRelacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRelacion extends FactoryObjetoLogico {

  public FactoryRelacion() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Relacion relacion = (Relacion) objLog;
    relacion.setOID(db.getInteger(DBRelacion.OID_RELACION));
    relacion.setCodigo(db.getString(DBRelacion.CODIGO));
    relacion.setDescripcion(db.getString(DBRelacion.DESCRIPCION));
    relacion.setActivo(db.getBoolean(DBRelacion.ACTIVO));

  }
}
