package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.da.DBPredioExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPredioExcluido extends FactoryObjetoLogico { 

  public FactoryPredioExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PredioExcluido predioexcluido = (PredioExcluido) objLog;
    predioexcluido.setOID(db.getInteger(DBPredioExcluido.ID_PREDIO));
    predioexcluido.setCodigo(db.getString(DBPredioExcluido.CODIGO));
    predioexcluido.setDescripcion(db.getString(DBPredioExcluido.DESCRIPCION));
    predioexcluido.setActivo(db.getBoolean(DBPredioExcluido.ACTIVO));

  }
}
