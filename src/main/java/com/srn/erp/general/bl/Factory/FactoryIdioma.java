package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Idioma;
import com.srn.erp.general.da.DBIdioma;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryIdioma extends FactoryObjetoLogico {

  public FactoryIdioma() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Idioma idioma = (Idioma) objLog;
    idioma.setOID(db.getInteger(DBIdioma.OID_IDIOMA));
    idioma.setCodigo(db.getString(DBIdioma.CODIGO));
    idioma.setDescripcion(db.getString(DBIdioma.DESCRIPCION));
    idioma.setActivo(db.getBoolean(DBIdioma.ACTIVO));
  }
}
