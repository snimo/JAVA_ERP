package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.ConsultaCtaCteClie;
import com.srn.erp.ctasACobrar.bm.TranClie;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasACobrar.da.DBConsultaCtaCteClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConsultaCtaCteClie extends FactoryObjetoLogico {

  public FactoryConsultaCtaCteClie() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConsultaCtaCteClie consultaCtaCteClie = (ConsultaCtaCteClie) objLog;
    consultaCtaCteClie.setOrden(db.getInteger(DBConsultaCtaCteClie.ORDEN));
    consultaCtaCteClie.setOID(db.getInteger(DBConsultaCtaCteClie.OID_TRAN_VTO));
    consultaCtaCteClie.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBConsultaCtaCteClie.OID_CCO),getSesion()));
    consultaCtaCteClie.setTc_ext(db.getString(DBConsultaCtaCteClie.TC_EXT));
    consultaCtaCteClie.setLetra(db.getString(DBConsultaCtaCteClie.LETRA));
    consultaCtaCteClie.setLugEmi(db.getInteger(DBConsultaCtaCteClie.LUG_EMI));
    consultaCtaCteClie.setNroExt(db.getInteger(DBConsultaCtaCteClie.NRO_EXT));
    consultaCtaCteClie.setFecEmision(db.getDate(DBConsultaCtaCteClie.FEC_EMISION));
    consultaCtaCteClie.setTranClie(TranClie.findByOidProxy(db.getInteger(DBConsultaCtaCteClie.OID_TRAN_CLIE),getSesion()));
    consultaCtaCteClie.setTranClieVto(TranClieVto.findByOidProxy(db.getInteger(DBConsultaCtaCteClie.OID_TRAN_VTO),getSesion()));
    consultaCtaCteClie.setVto(db.getDate(DBConsultaCtaCteClie.VTO));
    consultaCtaCteClie.setImpoCuota(db.getMoney(DBConsultaCtaCteClie.IMPO_CUOTA));
    consultaCtaCteClie.setSaldoCuota(db.getMoney(DBConsultaCtaCteClie.SALDO_CUOTA));
    consultaCtaCteClie.setTipoCtaCteClie(TipoCtaCteClie.findByOidProxy(db.getInteger(DBConsultaCtaCteClie.OID_TIPO_CTA_CLIE),getSesion()));
    consultaCtaCteClie.setDescTipoCtaCteClie(db.getString(DBConsultaCtaCteClie.TIPO_CTA_CLIE));
    consultaCtaCteClie.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBConsultaCtaCteClie.OID_SUJETO),getSesion()));
    consultaCtaCteClie.setRsSujeto(db.getString(DBConsultaCtaCteClie.RS_SUJETO));
    consultaCtaCteClie.setTotMonOri(db.getMoney(DBConsultaCtaCteClie.TOT_MON_ORI));
    consultaCtaCteClie.setSaldoMonOri(db.getMoney(DBConsultaCtaCteClie.SALDO_MON_ORI));
    consultaCtaCteClie.setMoneda(Moneda.findByOidProxy(db.getInteger(DBConsultaCtaCteClie.OID_MONEDA),getSesion()));
    consultaCtaCteClie.setDescMoneda(db.getString(DBConsultaCtaCteClie.MONEDA));
    consultaCtaCteClie.setCotizMonOri(db.getValorCotizacion(DBConsultaCtaCteClie.COTIZ_MON_ORI));
    consultaCtaCteClie.setCotizMonExt1(db.getValorCotizacion(DBConsultaCtaCteClie.COTIZ_MON_EXT1));
    consultaCtaCteClie.setCotizMonExt2(db.getValorCotizacion(DBConsultaCtaCteClie.COTIZ_MON_EXT2));
    consultaCtaCteClie.setCotizMonOriCon(db.getValorCotizacion(DBConsultaCtaCteClie.COTIZ_MON_ORI_CO));
    consultaCtaCteClie.setCotizMonExt1Con(db.getValorCotizacion(DBConsultaCtaCteClie.COTIZ_MON_EXT1_CO));
    consultaCtaCteClie.setCotizMonExt2Con(db.getValorCotizacion(DBConsultaCtaCteClie.COTIZ_MON_EXT2_CO));
    consultaCtaCteClie.setFecImputac(db.getDate(DBConsultaCtaCteClie.IMPUTAC));
    consultaCtaCteClie.setFechaConfCobranza(db.getDate(DBConsultaCtaCteClie.FEC_CONF_COBRO));
  }
}
