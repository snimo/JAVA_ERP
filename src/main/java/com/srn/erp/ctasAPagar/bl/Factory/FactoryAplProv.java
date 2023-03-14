package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.AplProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.ctasAPagar.da.DBAplProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplProv extends FactoryObjetoLogico {

  public FactoryAplProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplProv aplprov = (AplProv) objLog;
    aplprov.setOID(db.getInteger(DBAplProv.OID_APL_PROV));
    aplprov.setComprobanteapl(ComproCab.findByOidProxyCompro(db.getInteger(DBAplProv.OID_CCO),getSesion()));
    aplprov.setTipoctaprov(TipoCtaCteProv.findByOidProxy(db.getInteger(DBAplProv.OID_TIPO_CTA_PROV),getSesion()));
    aplprov.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBAplProv.OID_PROVEEDOR),getSesion()));
    aplprov.setMoneda(Moneda.findByOidProxy(db.getInteger(DBAplProv.OID_MONEDA),getSesion()));
    aplprov.setImporte(db.getMoney(DBAplProv.IMPORTE));
    aplprov.setFecimputac(db.getDate(DBAplProv.IMPUTAC));
    aplprov.setEmision(db.getDate(DBAplProv.EMISION));
    aplprov.setDiasbase(db.getInteger(DBAplProv.DIAS_BASE));
    aplprov.setDiasvto(db.getInteger(DBAplProv.DIAS_VTO));
    aplprov.setComprobanteori(ComproCab.findByOidProxyCompro(db.getInteger(DBAplProv.OID_CCO_ORI),getSesion()));
    aplprov.setTranprovvto(TranProvVto.findByOidProxy(db.getInteger(DBAplProv.OID_TRAN_VTO),getSesion()));
    aplprov.setTranprovvtoOri(TranProvVto.findByOidProxy(db.getInteger(DBAplProv.OID_TRAN_VTO_ORI),getSesion()));
    aplprov.setCotizMonOri(db.getCotizacion(DBAplProv.COTIZ_MON_ORI));
    aplprov.setCotizMonExt1(db.getCotizacion(DBAplProv.COTIZ_MON_EXT1));
    aplprov.setCotizMonExt2(db.getCotizacion(DBAplProv.COTIZ_MON_EXT2));
  }
}
