package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.TranProv;
import com.srn.erp.ctasAPagar.da.DBTranProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTranProv extends FactoryObjetoLogico {

  public FactoryTranProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TranProv tranprov = (TranProv) objLog;
    tranprov.setOID(db.getInteger(DBTranProv.OID_TRAN_PROV));
    tranprov.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBTranProv.OID_CCO),getSesion()));
    tranprov.setTipocuenta(TipoCtaCteProv.findByOidProxy(db.getInteger(DBTranProv.OID_TIPO_CTA_PROV),getSesion()));
    tranprov.setImporte(db.getMoney(DBTranProv.IMPORTE));
    tranprov.setSaldo(db.getMoney(DBTranProv.SALDO));
    tranprov.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBTranProv.OID_PROVEEDOR),getSesion()));
    tranprov.setPendiente(db.getBoolean(DBTranProv.PENDIENTE));
    tranprov.setImputac(db.getDate(DBTranProv.IMPUTAC));
    tranprov.setEmision(db.getDate(DBTranProv.EMISION));
    tranprov.setBase(db.getDate(DBTranProv.BASE));
    tranprov.setMoneda(Moneda.findByOidProxy(db.getInteger(DBTranProv.OID_MONEDA),getSesion()));
    tranprov.setCotizmonedaori(db.getValorCotizacion(DBTranProv.COTIZ_MON_ORI));
    tranprov.setCotizmonedaext1(db.getValorCotizacion(DBTranProv.COTIZ_MON_EXT1));
    tranprov.setCotizmonedaext2(db.getValorCotizacion(DBTranProv.COTIZ_MON_EXT2));
    tranprov.setCotizmonedaoricon(db.getValorCotizacion(DBTranProv.COTIZ_MON_ORI_CO));
    tranprov.setCotizmonedaext1con(db.getValorCotizacion(DBTranProv.COTIZ_MON_EXT1_CO));
    tranprov.setCotizmonedaext2con(db.getValorCotizacion(DBTranProv.COTIZ_MON_EXT2_CO));

  }
}
