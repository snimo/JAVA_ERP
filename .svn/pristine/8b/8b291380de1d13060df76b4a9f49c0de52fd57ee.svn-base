package com.srn.erp.ctasACobrar.bl.Factory;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;
import com.srn.erp.ctasACobrar.bm.AplicClieVto;
import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.ctasACobrar.da.DBAplicClieVto;
import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicClieVto extends FactoryObjetoLogico { 

  public FactoryAplicClieVto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicClieVto aplicclievto = (AplicClieVto) objLog;
    aplicclievto.setOID(db.getInteger(DBAplicClieVto.OID_APL_CLIE));
    aplicclievto.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBAplicClieVto.OID_CCO),getSesion()));
    aplicclievto.setSujeto(Sujeto.findByOidProxy(db.getInteger(DBAplicClieVto.OID_SUJETO),getSesion()));
    aplicclievto.setMoneda(Moneda.findByOidProxy(db.getInteger(DBAplicClieVto.OID_MONEDA),getSesion()));
    aplicclievto.setImporte(db.getMoney(DBAplicClieVto.IMPORTE));
    aplicclievto.setImputac(db.getDate(DBAplicClieVto.IMPUTAC));
    aplicclievto.setEmision(db.getDate(DBAplicClieVto.EMISION));
    aplicclievto.setDias_base(db.getInteger(DBAplicClieVto.DIAS_BASE));
    aplicclievto.setDias_vto(db.getInteger(DBAplicClieVto.DIAS_VTO));
    aplicclievto.setTran_vto(TranClieVto.findByOidProxy(db.getInteger(DBAplicClieVto.OID_TRAN_VTO),getSesion()));
    aplicclievto.setCompro_ori(ComproCab.findByOidProxyCompro(db.getInteger(DBAplicClieVto.OID_CCO_ORI),getSesion()));
    aplicclievto.setTran_vto_ori(TranClieVto.findByOidProxy(db.getInteger(DBAplicClieVto.OID_TRAN_VTO_ORI),getSesion()));
    aplicclievto.setCotiz_mon_ori(db.getValorCotizacion(DBAplicClieVto.COTIZ_MON_ORI));
    aplicclievto.setCotiz_mon_ext1(db.getValorCotizacion(DBAplicClieVto.COTIZ_MON_EXT1));
    aplicclievto.setCotiz_mon_ext2(db.getValorCotizacion(DBAplicClieVto.COTIZ_MON_EXT2));
    aplicclievto.setTipo_cta_cte(TipoCtaCteClie.findByOidProxy(db.getInteger(DBAplicClieVto.OID_TIPO_CTA_CTE),getSesion()));
  }
}
