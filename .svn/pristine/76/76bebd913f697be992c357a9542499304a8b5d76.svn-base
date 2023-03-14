package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ComproConta;
import com.srn.erp.contabilidad.bm.ComproContaDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.contabilidad.bm.MayorDia;
import com.srn.erp.contabilidad.bm.MayorPeri;
import com.srn.erp.contabilidad.da.DBComproContaDet;
import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproContaDet extends FactoryObjetoLogico {

  public FactoryComproContaDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproContaDet comprocontadet = (ComproContaDet) objLog;
    comprocontadet.setOID(db.getInteger(DBComproContaDet.OID_DCO));
    comprocontadet.setComprobante(ComproConta.findByOidProxy(db.getInteger(DBComproContaDet.OID_CCO),getSesion()));
    comprocontadet.setSecu(db.getInteger(DBComproContaDet.SECU));
    comprocontadet.setSigno(db.getInteger(DBComproContaDet.SIGNO));
    comprocontadet.setCuentaImputable(CuentaImputable.findByOidProxy(db.getInteger(DBComproContaDet.OID_AI),getSesion()));
    comprocontadet.setMoneda(Moneda.findByOidProxy(db.getInteger(DBComproContaDet.OID_MONEDA_ORI),getSesion()));
    comprocontadet.setCantidad(db.getInteger(DBComproContaDet.CANTIDAD));
    comprocontadet.setImporteOriginal(db.getMoney(DBComproContaDet.IMPO_ORI));
    comprocontadet.setComentario(db.getString(DBComproContaDet.COMENTARIO));
    comprocontadet.setMayorDia(MayorDia.findByOidProxy(db.getInteger(DBComproContaDet.OID_MAY_DIA),getSesion()));
    comprocontadet.setMayorPeri(MayorPeri.findByOidProxy(db.getInteger(DBComproContaDet.OID_MAY_PERI),getSesion()));
    comprocontadet.setImpoLocHist(db.getMoney(DBComproContaDet.IMPO_LOC_HIST));
    comprocontadet.setImpoLocAju(db.getMoney(DBComproContaDet.IMPO_LOC_AJU));
    comprocontadet.setImpoMonExt1(db.getMoney(DBComproContaDet.IMPOMONEXT1));
    comprocontadet.setImpoMonExt2(db.getMoney(DBComproContaDet.IMPOMONEXT2));
    comprocontadet.setCotizMonOri(db.getValorCotizacion(DBComproContaDet.COTIZ_MON_ORI));
    comprocontadet.setCotizMonExt1(db.getValorCotizacion(DBComproContaDet.COTIZ_MON_EXT_1));
    comprocontadet.setCotizMonExt2(db.getValorCotizacion(DBComproContaDet.COTIZ_MON_EXT_2));
    comprocontadet.setNroAsiento(db.getInteger(DBComproContaDet.NRO_ASIENTO));
  }
}
