package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AutorizacionMontoCompra;
import com.srn.erp.compras.bm.AutorizadorCompra;
import com.srn.erp.compras.da.DBAutorizacionMontoCompra;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAutorizacionMontoCompra extends FactoryObjetoLogico { 

  public FactoryAutorizacionMontoCompra() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AutorizacionMontoCompra autorizacionmontocompra = (AutorizacionMontoCompra) objLog;
    autorizacionmontocompra.setOID(db.getInteger(DBAutorizacionMontoCompra.OID_AUTORIZ_MONTO));
    autorizacionmontocompra.setMonto_desde(db.getDouble(DBAutorizacionMontoCompra.MONTO_DESDE));
    autorizacionmontocompra.setMonto_hasta(db.getDouble(DBAutorizacionMontoCompra.MONTO_HASTA));
    autorizacionmontocompra.setSecu(db.getInteger(DBAutorizacionMontoCompra.SECU));
    autorizacionmontocompra.setAutorizacion_compra(AutorizadorCompra.findByOidProxy(db.getInteger(DBAutorizacionMontoCompra.OID_AUTORIZ_CPRA),getSesion()));
    autorizacionmontocompra.setCualquier_sector(db.getBoolean(DBAutorizacionMontoCompra.CUALQUIER_SECTOR));

  }
}
