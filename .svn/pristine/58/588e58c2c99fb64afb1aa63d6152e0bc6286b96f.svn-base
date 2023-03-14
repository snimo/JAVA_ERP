package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.SectorCompra;
import com.srn.erp.ctasAPagar.bm.ComproProveedorInterno;
import com.srn.erp.ctasAPagar.da.DBComproProveedor;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproProveedorInterno extends FactoryObjetoLogico {

  public FactoryComproProveedorInterno() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproProveedorInterno comproproveedor = (ComproProveedorInterno) objLog;
    comproproveedor.setOID(db.getInteger(DBComproProveedor.OID_CCO));
    comproproveedor.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBComproProveedor.PROVEEDOR),getSesion()));
    comproproveedor.setTotMonedaOri(db.getMoney(DBComproProveedor.TOT_MON_ORI));
    comproproveedor.setTotMonedaLoc(db.getMoney(DBComproProveedor.TOT_MON_LOC));
    comproproveedor.setMoneda(Moneda.findByOidProxy(db.getInteger(DBComproProveedor.OID_MONEDA),getSesion()));
    comproproveedor.setFecbase(db.getDate(DBComproProveedor.FEC_BASE));
    comproproveedor.setMaxMontoAutOri(db.getMoney(DBComproProveedor.MAX_MONTO_AUT_ORI));
    comproproveedor.setAutorizada(db.getBoolean(DBComproProveedor.AUTORIZADA));
    comproproveedor.setCondpagoAlt2(CondicionCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_COND_PAGO_CC),getSesion()));
    comproproveedor.setCondPagoAlt1(CondicionCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_COND_PAGO_AL1),getSesion()));
    comproproveedor.setCondpagoAlt2(CondicionCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_CONC_PAGO_AL2),getSesion()));
    comproproveedor.setDescCondPagoCC(db.getMoney(DBComproProveedor.DESC_CP_CC));
    comproproveedor.setDescCondPagoAlt1(db.getMoney(DBComproProveedor.DESC_CP_AL1));
    comproproveedor.setDescCondPagoAlt2(db.getMoney(DBComproProveedor.DESC_CP_AL2));
    comproproveedor.setNetoGravadoMonOri(db.getMoney(DBComproProveedor.NETO_GRAVADO_MON_ORI));
    comproproveedor.setNetoNoGravadoMonOri(db.getMoney(DBComproProveedor.NETO_NO_GRAVADO_MON_ORI));
    comproproveedor.setNetoGravadoMonLoc(db.getMoney(DBComproProveedor.NETO_GRAVADO_MON_LOC));
    comproproveedor.setNetoNoGravadoMonLoc(db.getMoney(DBComproProveedor.NETO_NO_GRAVADO_MON_LOC));    
    comproproveedor.setSectorCompra(SectorCompra.findByOidProxy(db.getInteger(DBComproProveedor.OID_SECTOR_COMPRA),getSesion()));
    comproproveedor.setCotizacion(db.getValorCotizacion(DBComproProveedor.COTIZACION));
  }
}
