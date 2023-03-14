package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.Rubro;
import com.srn.erp.ventas.da.DBRubro;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRubro extends FactoryObjetoLogico {

  public FactoryRubro() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Rubro rubro = (Rubro) objLog;
    rubro.setOID(db.getInteger(DBRubro.OID_RUBRO));
    rubro.setCodigo(db.getString(DBRubro.CODIGO));
    rubro.setDescripcion(db.getString(DBRubro.DESCRIPCION));
    rubro.setActivo(db.getBoolean(DBRubro.ACTIVO));
  }
}
