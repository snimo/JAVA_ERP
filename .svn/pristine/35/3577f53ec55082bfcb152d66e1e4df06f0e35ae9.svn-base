package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.da.DBSeguPerfilExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeguPerfilExcluido extends FactoryObjetoLogico { 

  public FactorySeguPerfilExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguPerfilExcluido seguperfilexcluido = (SeguPerfilExcluido) objLog;
    seguperfilexcluido.setOID(db.getInteger(DBSeguPerfilExcluido.OID_SEGU_PERFIL));
    seguperfilexcluido.setCodigo(db.getString(DBSeguPerfilExcluido.CODIGO));
    seguperfilexcluido.setDescripcion(db.getString(DBSeguPerfilExcluido.DESCRIPCION));
    seguperfilexcluido.setActivo(db.getBoolean(DBSeguPerfilExcluido.ACTIVO));

  }
}
