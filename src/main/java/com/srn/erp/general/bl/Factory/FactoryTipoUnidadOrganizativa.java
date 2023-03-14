package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.TipoUnidadOrganizativa;
import com.srn.erp.general.da.DBTipoUnidadOrganizativa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoUnidadOrganizativa extends FactoryObjetoLogico {

  public FactoryTipoUnidadOrganizativa() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoUnidadOrganizativa tipounidadorganizativa = (TipoUnidadOrganizativa) objLog;
  tipounidadorganizativa.setOID(db.getInteger(DBTipoUnidadOrganizativa.OID_TIPO_UNI_ORG));
    tipounidadorganizativa.setCodigo(db.getString(DBTipoUnidadOrganizativa.CODIGO));
    tipounidadorganizativa.setDescripcion(db.getString(DBTipoUnidadOrganizativa.DESCRIPCION));
    tipounidadorganizativa.setActivo(db.getBoolean(DBTipoUnidadOrganizativa.ACTIVO));

  }
}
