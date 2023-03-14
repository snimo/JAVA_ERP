package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.Banco;
import com.srn.erp.tesoreria.da.DBBanco;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryBanco extends FactoryObjetoLogico {

  public FactoryBanco() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Banco banco = (Banco) objLog;
    banco.setOID(db.getInteger(DBBanco.OID_BANCO));
    banco.setCodigo(db.getString(DBBanco.CODIGO));
    banco.setDescripcion(db.getString(DBBanco.DESCRIPCION));
    banco.setActivo(db.getBoolean(DBBanco.ACTIVO));

  }
}
