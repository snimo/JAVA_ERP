package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.LugarHechoExcluido;
import com.srn.erp.excluidos.da.DBLugarHechoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLugarHechoExcluido extends FactoryObjetoLogico { 

  public FactoryLugarHechoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LugarHechoExcluido lugarhechoexcluido = (LugarHechoExcluido) objLog;
    lugarhechoexcluido.setOID(db.getInteger(DBLugarHechoExcluido.OID_LUGAR_HECHO));
    lugarhechoexcluido.setCodigo(db.getString(DBLugarHechoExcluido.CODIGO));
    lugarhechoexcluido.setDescripcion(db.getString(DBLugarHechoExcluido.DESCRIPCION));
    lugarhechoexcluido.setActivo(db.getBoolean(DBLugarHechoExcluido.ACTIVO));

  }
}
