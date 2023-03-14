package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.CaracterExcluido;
import com.srn.erp.excluidos.da.DBCaracterExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCaracterExcluido extends FactoryObjetoLogico { 

  public FactoryCaracterExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CaracterExcluido caracterexcluido = (CaracterExcluido) objLog;
    caracterexcluido.setOID(db.getInteger(DBCaracterExcluido.OID_CARACTER));
    caracterexcluido.setCodigo(db.getString(DBCaracterExcluido.CODIGO));
    caracterexcluido.setDescripcion(db.getString(DBCaracterExcluido.DESCRIPCION));
    caracterexcluido.setActivo(db.getBoolean(DBCaracterExcluido.ACTIVO));

  }
}
