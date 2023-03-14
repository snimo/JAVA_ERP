package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.MarcaExcluido;
import com.srn.erp.excluidos.da.DBMarcaExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMarcaExcluido extends FactoryObjetoLogico { 

  public FactoryMarcaExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MarcaExcluido marcaexcluido = (MarcaExcluido) objLog;
    marcaexcluido.setOID(db.getInteger(DBMarcaExcluido.OID_MARCA));
    marcaexcluido.setCodigo(db.getString(DBMarcaExcluido.CODIGO));
    marcaexcluido.setDescripcion(db.getString(DBMarcaExcluido.DESCRIPCION));
    marcaexcluido.setActivo(db.getBoolean(DBMarcaExcluido.ACTIVO));

  }
}
