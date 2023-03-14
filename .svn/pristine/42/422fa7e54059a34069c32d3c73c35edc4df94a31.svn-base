package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Pais;
import com.srn.erp.general.bm.Provincia;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.da.DBSucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySucursal extends FactoryObjetoLogico {

  public FactorySucursal() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Sucursal sucursal = (Sucursal) objLog;
    sucursal.setOID(db.getInteger(DBSucursal.OID_SUCURSAL));
    sucursal.setCodigo(db.getString(DBSucursal.CODIGO));
    sucursal.setDescripcion(db.getString(DBSucursal.DESCRIPCION));
    sucursal.setCalle_y_nro(db.getString(DBSucursal.CALLE_Y_NRO));
    sucursal.setLocalidad(db.getString(DBSucursal.LOCALIDAD));
    sucursal.setCodigo_postal(db.getString(DBSucursal.CODIGO_POSTAL));
    sucursal.setProvincia(Provincia.findByOidProxy(db.getInteger(DBSucursal.OID_PROVINCIA),getSesion()));
    sucursal.setPais(Pais.findByOidProxy(db.getInteger(DBSucursal.OID_PAIS),getSesion()));
    sucursal.setActivo(db.getBoolean(DBSucursal.ACTIVO));
    sucursal.setTelefonos(db.getString(DBSucursal.TELEFONOS));
    sucursal.setPathLogo(db.getString(DBSucursal.PATH_LOGO));
    sucursal.setFax(db.getString(DBSucursal.FAX));
    sucursal.setAgentePercIBBsAs(db.getBoolean(DBSucursal.ES_AGE_PERC_IB_BA).booleanValue());
    sucursal.setAgentePercIBCapFed(db.getBoolean(DBSucursal.ES_AGE_PERC_IB_CF).booleanValue());
    sucursal.setAgentePercIVA(db.getBoolean(DBSucursal.ES_AGE_PERC_IVA).booleanValue());
  }
}
