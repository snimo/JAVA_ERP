package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EdadExcluido;
import com.srn.erp.excluidos.da.DBEdadExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEdadExcluido extends FactoryObjetoLogico { 

  public FactoryEdadExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EdadExcluido edadexcluido = (EdadExcluido) objLog;
    edadexcluido.setOID(db.getInteger(DBEdadExcluido.OID_EDAD));
    edadexcluido.setCodigo(db.getString(DBEdadExcluido.CODIGO));
    edadexcluido.setDescripcion(db.getString(DBEdadExcluido.DESCRIPCION));
    edadexcluido.setActivo(db.getBoolean(DBEdadExcluido.ACTIVO));

  }
}
