package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AutorizacionMontoCompra;
import com.srn.erp.compras.bm.RolAutorizadorCompras;
import com.srn.erp.compras.bm.RolAutorizadorOC;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.compras.da.DBRolAutorizadorOC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRolAutorizadorOC extends FactoryObjetoLogico { 

  public FactoryRolAutorizadorOC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RolAutorizadorOC rolautorizadoroc = (RolAutorizadorOC) objLog;
    rolautorizadoroc.setOID(db.getInteger(DBRolAutorizadorOC.OID_ROL_AUT_CPRAS));
    rolautorizadoroc.setAutorizacion_monto(AutorizacionMontoCompra.findByOidProxy(db.getInteger(DBRolAutorizadorOC.OID_AUTORIZ_MONTO),getSesion()));
    rolautorizadoroc.setRol_autorizador(RolAutorizadorCompras.findByOidProxy(db.getInteger(DBRolAutorizadorOC.OID_ROL_AUTORIZ),getSesion()));
    rolautorizadoroc.setTipo_autoriz(db.getString(DBRolAutorizadorOC.TIPO_AUTORIZ));
    rolautorizadoroc.setSector_emisor(SectorCompra.findByOidProxy(db.getInteger(DBRolAutorizadorOC.OID_SECTOR_EMISOR),getSesion()));

  }
}
