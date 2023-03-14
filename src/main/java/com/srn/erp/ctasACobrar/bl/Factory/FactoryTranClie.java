package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.TranClie;
import com.srn.erp.ctasACobrar.da.DBTranClie;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTranClie extends FactoryObjetoLogico { 

  public FactoryTranClie() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TranClie tranclie = (TranClie) objLog;
   tranclie.setOID(db.getInteger(DBTranClie.OID_TRAN_CLIE));
    tranclie.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBTranClie.OID_CCO),getSesion()));
    tranclie.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBTranClie.OID_SUJETO),getSesion()));
    tranclie.setMoneda(Moneda.findByOidProxy(db.getInteger(DBTranClie.OID_MONEDA),getSesion()));
    tranclie.setImporte(db.getMoney(DBTranClie.IMPORTE));
    tranclie.setSaldo(db.getMoney(DBTranClie.SALDO));
    tranclie.setPendiente(db.getBoolean(DBTranClie.PENDIENTE));
    tranclie.setImputac(db.getDate(DBTranClie.IMPUTAC));
    tranclie.setEmision(db.getDate(DBTranClie.EMISION));
    tranclie.setBase(db.getDate(DBTranClie.BASE));
    tranclie.setCotiz_mon_ori(db.getValorCotizacion(DBTranClie.COTIZ_MON_ORI));
    tranclie.setCotiz_mon_ext1(db.getValorCotizacion(DBTranClie.COTIZ_MON_EXT1));
    tranclie.setCotiz_mon_ext2(db.getValorCotizacion(DBTranClie.COTIZ_MON_EXT2));
    tranclie.setCotiz_mon_ori_co(db.getValorCotizacion(DBTranClie.COTIZ_MON_ORI_CO));
    tranclie.setCotiz_mon_ext1_co(db.getValorCotizacion(DBTranClie.COTIZ_MON_EXT1_CO));
    tranclie.setCotiz_mon_ext2_co(db.getValorCotizacion(DBTranClie.COTIZ_MON_EXT2_CO));
    tranclie.setTipo_cta_cte(TipoCtaCteClie.findByOidProxy(db.getInteger(DBTranClie.OID_TIPO_CTA_CLIE),getSesion()));

  }
}
