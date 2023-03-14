package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctacte.bm.TipoCtaCteProv;
import com.srn.erp.ctasAPagar.bm.ConsultaCtaCteProv;
import com.srn.erp.ctasAPagar.bm.TranProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.ctasAPagar.da.DBConsultaCtaCteProv;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConsultaCtaCteProv extends FactoryObjetoLogico {

  public FactoryConsultaCtaCteProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConsultaCtaCteProv consultaCtaCteProv = (ConsultaCtaCteProv) objLog;
    consultaCtaCteProv.setOrden(db.getInteger(DBConsultaCtaCteProv.ORDEN));
    consultaCtaCteProv.setOID(db.getInteger(DBConsultaCtaCteProv.OID_TRAN_VTO));
    consultaCtaCteProv.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBConsultaCtaCteProv.OID_CCO),getSesion()));
    consultaCtaCteProv.setTc_ext(db.getString(DBConsultaCtaCteProv.TC_EXT));
    consultaCtaCteProv.setLetra(db.getString(DBConsultaCtaCteProv.LETRA));
    consultaCtaCteProv.setLugEmi(db.getInteger(DBConsultaCtaCteProv.LUG_EMI));
    consultaCtaCteProv.setNroExt(db.getInteger(DBConsultaCtaCteProv.NRO_EXT));
    consultaCtaCteProv.setFecEmision(db.getDate(DBConsultaCtaCteProv.FEC_EMISION));
    consultaCtaCteProv.setTranProv(TranProv.findByOidProxy(db.getInteger(DBConsultaCtaCteProv.OID_TRAN_PROV),getSesion()));
    consultaCtaCteProv.setTranProvVto(TranProvVto.findByOidProxy(db.getInteger(DBConsultaCtaCteProv.OID_TRAN_VTO),getSesion()));
    consultaCtaCteProv.setVto(db.getDate(DBConsultaCtaCteProv.VTO));
    consultaCtaCteProv.setImpoCuota(db.getMoney(DBConsultaCtaCteProv.IMPO_CUOTA));
    consultaCtaCteProv.setSaldoCuota(db.getMoney(DBConsultaCtaCteProv.SALDO_CUOTA));
    consultaCtaCteProv.setTipoCtaCteProv(TipoCtaCteProv.findByOidProxy(db.getInteger(DBConsultaCtaCteProv.OID_TIPO_CTA_PROV),getSesion()));
    consultaCtaCteProv.setDescTipoCtaCteProv(db.getString(DBConsultaCtaCteProv.TIPO_CTA_PROV));
    consultaCtaCteProv.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBConsultaCtaCteProv.OID_PROVEEDOR),getSesion()));
    consultaCtaCteProv.setRsProveedor(db.getString(DBConsultaCtaCteProv.RS_PROVEEDOR));
    consultaCtaCteProv.setTotMonOri(db.getMoney(DBConsultaCtaCteProv.TOT_MON_ORI));
    consultaCtaCteProv.setSaldoMonOri(db.getMoney(DBConsultaCtaCteProv.SALDO_MON_ORI));
    consultaCtaCteProv.setMoneda(Moneda.findByOidProxy(db.getInteger(DBConsultaCtaCteProv.OID_MONEDA),getSesion()));
    consultaCtaCteProv.setDescMoneda(db.getString(DBConsultaCtaCteProv.MONEDA));
    consultaCtaCteProv.setCotizMonOri(db.getValorCotizacion(DBConsultaCtaCteProv.COTIZ_MON_ORI));
    consultaCtaCteProv.setCotizMonExt1(db.getValorCotizacion(DBConsultaCtaCteProv.COTIZ_MON_EXT1));
    consultaCtaCteProv.setCotizMonExt2(db.getValorCotizacion(DBConsultaCtaCteProv.COTIZ_MON_EXT2));
    consultaCtaCteProv.setCotizMonOriCon(db.getValorCotizacion(DBConsultaCtaCteProv.COTIZ_MON_ORI_CO));
    consultaCtaCteProv.setCotizMonExt1Con(db.getValorCotizacion(DBConsultaCtaCteProv.COTIZ_MON_EXT1_CO));
    consultaCtaCteProv.setCotizMonExt2Con(db.getValorCotizacion(DBConsultaCtaCteProv.COTIZ_MON_EXT2_CO));
    consultaCtaCteProv.setFecImputac(db.getDate(DBConsultaCtaCteProv.IMPUTAC));
    consultaCtaCteProv.setFecConfPago(db.getDate(DBConsultaCtaCteProv.FEC_CONF_PAGO));
  }
}
