package com.srn.erp.produccion.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.produccion.bm.TipoRecurso;
import com.srn.erp.produccion.da.DBTipoRecurso;

public class FactoryTipoRecurso extends FactoryObjetoLogico { 

  public FactoryTipoRecurso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoRecurso tiporecurso = (TipoRecurso) objLog;
    tiporecurso.setOID(db.getInteger(DBTipoRecurso.OID_TIPO_RECURSO));
    tiporecurso.setCodigo(db.getString(DBTipoRecurso.CODIGO));
    tiporecurso.setDescripcion(db.getString(DBTipoRecurso.DESCRIPCION));
    tiporecurso.setActivo(db.getBoolean(DBTipoRecurso.ACTIVO));
  }
}
