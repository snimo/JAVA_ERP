package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.da.DBIndice;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryIndice extends FactoryObjetoLogico {

  public FactoryIndice() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Indice indice = (Indice) objLog;
    indice.setOID(db.getInteger(DBIndice.OID_INDICE));
    indice.setCodigo(db.getString(DBIndice.CODIGO));
    indice.setDescripcion(db.getString(DBIndice.DESCRIPCION));
    indice.setActivo(db.getBoolean(DBIndice.ACTIVO));

  }
}
