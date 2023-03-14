package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.da.DBPais;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPais extends FactoryObjetoLogico {

  public FactoryPais() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Pais pais = (Pais) objLog;
    pais.setOID(db.getInteger(DBPais.OID_PAIS));
    pais.setCodigo(db.getString(DBPais.CODIGO));
    pais.setDescripcion(db.getString(DBPais.DESCRIPCION));
    pais.setActivo(db.getBoolean(DBPais.ACTIVO));

  }
}
