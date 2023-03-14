package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.TipoUnidadOrganizativa;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBUnidadOrganizativa;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUnidadOrganizativa extends FactoryObjetoLogico {

  public FactoryUnidadOrganizativa() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UnidadOrganizativa unidadorganizativa = (UnidadOrganizativa) objLog;
    unidadorganizativa.setOID(db.getInteger(DBUnidadOrganizativa.OID_UNI_ORG));
    unidadorganizativa.setCodigo(db.getString(DBUnidadOrganizativa.CODIGO));
    unidadorganizativa.setDescripcion(db.getString(DBUnidadOrganizativa.DESCRIPCION));
    unidadorganizativa.setTipounidadorganizativa(TipoUnidadOrganizativa.findByOidProxy(db.getInteger(DBUnidadOrganizativa.OID_TIPO_UNI_ORG),getSesion()));
    unidadorganizativa.setActivo(db.getBoolean(DBUnidadOrganizativa.ACTIVO));
    unidadorganizativa.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBUnidadOrganizativa.OID_SUCURSAL),getSesion()));
  }
}
