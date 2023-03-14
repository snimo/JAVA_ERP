package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.da.DBPeligrosidadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPeligrosidadExcluido extends FactoryObjetoLogico { 

  public FactoryPeligrosidadExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PeligrosidadExcluido peligrosidadexcluido = (PeligrosidadExcluido) objLog;
    peligrosidadexcluido.setOID(db.getInteger(DBPeligrosidadExcluido.OID_PELIGROSIDAD));
    peligrosidadexcluido.setCodigo(db.getString(DBPeligrosidadExcluido.CODIGO));
    peligrosidadexcluido.setDescripcion(db.getString(DBPeligrosidadExcluido.DESCRIPCION));
    peligrosidadexcluido.setGrado(db.getInteger(DBPeligrosidadExcluido.GRADO));
    peligrosidadexcluido.setActivo(db.getBoolean(DBPeligrosidadExcluido.ACTIVO));
    peligrosidadexcluido.setColor(db.getString(DBPeligrosidadExcluido.COLOR));
  }
}
