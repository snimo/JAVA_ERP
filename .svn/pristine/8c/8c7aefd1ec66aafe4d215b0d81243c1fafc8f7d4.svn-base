package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoCategAcceso;
import com.srn.erp.cip.bm.SubGrupoCategAcceso;
import com.srn.erp.cip.da.DBSubGrupoCategAcceso;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySubGrupoCategAcceso extends FactoryObjetoLogico { 

  public FactorySubGrupoCategAcceso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SubGrupoCategAcceso subgrupocategacceso = (SubGrupoCategAcceso) objLog;
    subgrupocategacceso.setOID(db.getInteger(DBSubGrupoCategAcceso.OID_SUB_GRUPO));
    subgrupocategacceso.setCodigo(db.getString(DBSubGrupoCategAcceso.CODIGO));
    subgrupocategacceso.setDescripcion(db.getString(DBSubGrupoCategAcceso.DESCRIPCION));
    subgrupocategacceso.setActivo(db.getBoolean(DBSubGrupoCategAcceso.ACTIVO));
    subgrupocategacceso.setOrden(db.getInteger(DBSubGrupoCategAcceso.ORDEN));
    subgrupocategacceso.setGrupo_categoria(GrupoCategAcceso.findByOidProxy(db.getInteger(DBSubGrupoCategAcceso.OID_GRUPO_CATEG),getSesion()));

  }
}
