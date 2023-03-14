package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondCompraProv;
import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.da.DBCondCompraProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondCompraProv extends FactoryObjetoLogico {

  public FactoryCondCompraProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondCompraProv condcompraprov = (CondCompraProv) objLog;
    condcompraprov.setOID(db.getInteger(DBCondCompraProv.OID_COND_CP_PROV));
    condcompraprov.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBCondCompraProv.OID_PROVEEDOR),getSesion()));
    condcompraprov.setCondcompra(CondicionCompra.findByOidProxy(db.getInteger(DBCondCompraProv.OID_COND_COMPRA),getSesion()));
    condcompraprov.setDescuento(db.getDouble(DBCondCompraProv.DESCUENTO));
    condcompraprov.setRecargo(db.getDouble(DBCondCompraProv.RECARGO));
    condcompraprov.setPorDefecto(db.getBoolean(DBCondCompraProv.POR_DEFECTO));
    condcompraprov.setActivo(new Boolean(true));
  }
}
