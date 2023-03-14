package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.da.DBComproProveedorDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProveedorDet extends FactoryObjetoLogico {

  public FactoryComproProveedorDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProveedorDet comproproveedordet = (ComproProveedorDet) objLog;
    comproproveedordet.setOID(db.getInteger(DBComproProveedorDet.OID_CCO_PROV_DET));
    comproproveedordet.setComprobante(ComproProveedor.findByOidProxy(db.getInteger(DBComproProveedorDet.OID_CCO),getSesion()));
    comproproveedordet.setSecu(db.getInteger(DBComproProveedorDet.SECU));
    comproproveedordet.setConcFactProv(ConcFactProv.findByOidProxy(db.getInteger(DBComproProveedorDet.OID_CONC_FACT_PROV),getSesion()));
    comproproveedordet.setImpoMonedaOri(db.getMoney(DBComproProveedorDet.IMPO_MONEDA_ORI));
    comproproveedordet.setImpoMonedaLoc(db.getMoney(DBComproProveedorDet.IMPO_MONEDA_LOC));
  }
}
