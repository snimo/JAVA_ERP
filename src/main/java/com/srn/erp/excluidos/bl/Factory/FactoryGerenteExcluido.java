package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.GerenteExcluido;
import com.srn.erp.excluidos.da.DBGerenteExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGerenteExcluido extends FactoryObjetoLogico { 

  public FactoryGerenteExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GerenteExcluido gerenteexcluido = (GerenteExcluido) objLog;
    gerenteexcluido.setOID(db.getInteger(DBGerenteExcluido.OID_GERENTE));
    gerenteexcluido.setCodigo(db.getString(DBGerenteExcluido.CODIGO));
    gerenteexcluido.setDescripcion(db.getString(DBGerenteExcluido.DESCRIPCION));
    gerenteexcluido.setActivo(db.getBoolean(DBGerenteExcluido.ACTIVO));

  }
}
