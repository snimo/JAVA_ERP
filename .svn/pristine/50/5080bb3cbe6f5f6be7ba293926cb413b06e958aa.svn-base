package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Zona;
import com.srn.erp.general.da.DBZona;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryZona extends FactoryObjetoLogico {

  public FactoryZona() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Zona zona = (Zona) objLog;
    zona.setOID(db.getInteger(DBZona.OID_ZONA));
    zona.setCodigo(db.getString(DBZona.CODIGO));
    zona.setDescripcion(db.getString(DBZona.DESCRIPCION));
    zona.setActivo(db.getBoolean(DBZona.ACTIVO));

  }
}
