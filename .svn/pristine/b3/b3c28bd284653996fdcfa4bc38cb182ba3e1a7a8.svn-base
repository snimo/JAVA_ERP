package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.LugarEmision;
import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.general.da.DBLugarEmision;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryLugarEmision extends FactoryObjetoLogico {

  public FactoryLugarEmision() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LugarEmision lugaremision = (LugarEmision) objLog;
    lugaremision.setOID(db.getInteger(DBLugarEmision.OID_LUG_EMI));
    lugaremision.setLugemi(db.getInteger(DBLugarEmision.LUG_EMI));
    lugaremision.setDescripcion(db.getString(DBLugarEmision.DESCRIPCION));
    lugaremision.setUnidadorganizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBLugarEmision.OID_UNI_ORG),getSesion()));
    lugaremision.setActivo(db.getBoolean(DBLugarEmision.ACTIVO));

  }
}
