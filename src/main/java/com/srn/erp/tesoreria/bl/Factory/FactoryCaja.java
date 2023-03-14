package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.da.DBCaja;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCaja extends FactoryObjetoLogico {

  public FactoryCaja() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Caja caja = (Caja) objLog;
    caja.setOID(db.getInteger(DBCaja.OID_CAJA));
    caja.setDescripcion(db.getString(DBCaja.DESCRIPCION));
    caja.setUnidadorganizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBCaja.OID_UNI_ORG),getSesion()));
    caja.setCompo(db.getString(DBCaja.COMPO));
    caja.setCodigo(db.getString(DBCaja.CODIGO));
    caja.setActivo(db.getBoolean(DBCaja.ACTIVO));
    caja.setTipoCierreApertura(db.getString(DBCaja.TIPO_CIERRE_CAJA));
  }
}
