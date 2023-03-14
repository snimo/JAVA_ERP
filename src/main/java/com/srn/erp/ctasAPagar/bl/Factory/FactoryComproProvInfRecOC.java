package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.ctasAPagar.bm.ComproProvInfRecOC;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.da.DBComproProvInfRecOC;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProvInfRecOC extends FactoryObjetoLogico { 

  public FactoryComproProvInfRecOC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProvInfRecOC comproprovinfrecoc = (ComproProvInfRecOC) objLog;
    comproprovinfrecoc.setOID(db.getInteger(DBComproProvInfRecOC.OID_DET_IR_OC));
    comproprovinfrecoc.setComprobante_proveedorBase(ComproProveedorBase.findByOidProxy(db.getInteger(DBComproProvInfRecOC.OID_CCO),getSesion()));
    comproprovinfrecoc.setProducto(Producto.findByOidProxy(db.getInteger(DBComproProvInfRecOC.OID_PRODUCTO),getSesion()));
    comproprovinfrecoc.setInforme_rec_det(InformeRecepcionDet.findByOidProxy(db.getInteger(DBComproProvInfRecOC.OID_INF_REC_DET),getSesion()));
    comproprovinfrecoc.setCant_facturada(db.getDouble(DBComproProvInfRecOC.CANT_FACTURADA));
    comproprovinfrecoc.setPrecio_factura(db.getDouble(DBComproProvInfRecOC.PRECIO_FACTURA));
    comproprovinfrecoc.setPrecio_oc(db.getDouble(DBComproProvInfRecOC.PRECIO_OC));
    comproprovinfrecoc.setMoneda_oc(Moneda.findByOidProxy(db.getInteger(DBComproProvInfRecOC.OID_MON_OC),getSesion()));
    comproprovinfrecoc.setImpo_det_factura(db.getDouble(DBComproProvInfRecOC.IMPO_DET_FACTURA));
    comproprovinfrecoc.setActivo(db.getBoolean(DBComproProvInfRecOC.ACTIVO));
    comproprovinfrecoc.setOrdenDeCompraDet(OrdenDeCompraDet.findByOidProxy(db.getInteger(DBComproProvInfRecOC.OID_OC_DET),getSesion()));
  }
}
