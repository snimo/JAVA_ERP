package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.RazaExcluido;
import com.srn.erp.excluidos.da.DBRazaExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRazaExcluido extends FactoryObjetoLogico { 

  public FactoryRazaExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RazaExcluido razaexcluido = (RazaExcluido) objLog;
    razaexcluido.setOID(db.getInteger(DBRazaExcluido.OID_RAZA));
    razaexcluido.setCodigo(db.getString(DBRazaExcluido.CODIGO));
    razaexcluido.setDescripcion(db.getString(DBRazaExcluido.DESCRIPCION));
    razaexcluido.setActivo(db.getBoolean(DBRazaExcluido.ACTIVO));

  }
}
