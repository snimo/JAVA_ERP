package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Estructura;
import com.srn.erp.contabilidad.da.DBEstructura;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEstructura extends FactoryObjetoLogico {

  public FactoryEstructura() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Estructura estructura = (Estructura) objLog;
    estructura.setOID(db.getInteger(DBEstructura.OID_ESTRUC));
    estructura.setCodigo(db.getString(DBEstructura.CODIGO));
    estructura.setDescripcion(db.getString(DBEstructura.DESCRIPCION));
    estructura.setActivo(db.getBoolean(DBEstructura.ACTIVO));

  }
}
