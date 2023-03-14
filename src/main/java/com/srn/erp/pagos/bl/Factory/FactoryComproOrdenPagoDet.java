package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ComproAnticipoProveedor;
import com.srn.erp.ctasAPagar.bm.TranProvVto;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoDet;
import com.srn.erp.pagos.bm.ConceptoOPVarias;
import com.srn.erp.pagos.da.DBComproOrdenPagoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproOrdenPagoDet extends FactoryObjetoLogico {

  public FactoryComproOrdenPagoDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproOrdenPagoDet comproordenpagodet = (ComproOrdenPagoDet) objLog;
    comproordenpagodet.setOID(db.getInteger(DBComproOrdenPagoDet.OID_COMPRO_DET_OP));
    comproordenpagodet.setComprobante(ComproOrdenPagoCab.findByOidProxy(db.getInteger(DBComproOrdenPagoDet.OID_CCO),getSesion()));
    comproordenpagodet.setMoneda(Moneda.findByOidProxy(db.getInteger(DBComproOrdenPagoDet.OID_MON_TRAN_PROV),getSesion()));
    comproordenpagodet.setImpofactmonori(db.getMoney(DBComproOrdenPagoDet.IMPO_FACT_MON_ORI));
    comproordenpagodet.setDtomonori(db.getMoney(DBComproOrdenPagoDet.DTO_MON_ORI));
    comproordenpagodet.setNetopagomonori(db.getMoney(DBComproOrdenPagoDet.NETO_PAGO_MON_ORI));
    comproordenpagodet.setImpofactmonpago(db.getMoney(DBComproOrdenPagoDet.IMPO_FACT_MON_PAGO));
    comproordenpagodet.setDtomonpago(db.getMoney(DBComproOrdenPagoDet.DTO_MON_PAGO));
    comproordenpagodet.setTranprovvto(TranProvVto.findByOidProxy(db.getInteger(DBComproOrdenPagoDet.OID_TRAN_VTO),getSesion()));
    comproordenpagodet.setImpoautorizmonori(db.getMoney(DBComproOrdenPagoDet.IMPO_AUTO_MON_ORI));
    comproordenpagodet.setNetopagomonpago(db.getMoney(DBComproOrdenPagoDet.NETO_PAGO_MON_PAGO));
    comproordenpagodet.setImpomaxautorizori(db.getMoney(DBComproOrdenPagoDet.IMPO_MAX_AUTO_ORI));
    comproordenpagodet.setImpoautorizmonpago(db.getMoney(DBComproOrdenPagoDet.IMPO_AUTO_MON_PAGO));
    comproordenpagodet.setImpomaxautorizpago(db.getMoney(DBComproOrdenPagoDet.IMPO_MAX_AUTO_PAGO));
    comproordenpagodet.setImpoMaxAutoLoc(db.getMoney(DBComproOrdenPagoDet.IMPO_MAX_AUTO_LOC));
    comproordenpagodet.setImpoAutoMonLoc(db.getMoney(DBComproOrdenPagoDet.IMPO_AUTO_MON_LOC));
    comproordenpagodet.setImpoFactMonLoc(db.getMoney(DBComproOrdenPagoDet.IMPO_FAC_MON_LOC));
    comproordenpagodet.setDtoMonLoc(db.getMoney(DBComproOrdenPagoDet.DTO_MON_LOC));
    comproordenpagodet.setNetoPagoMonLoc(db.getMoney(DBComproOrdenPagoDet.NETO_PAGO_MON_LOC));
    comproordenpagodet.setComproAntProv((ComproAnticipoProveedor)ComproAnticipoProveedor.findByOidProxy(db.getInteger(DBComproOrdenPagoDet.OID_CCO_ANT_PROV),getSesion()));
    comproordenpagodet.setConceptoOPVarias(ConceptoOPVarias.findByOidProxy(db.getInteger(DBComproOrdenPagoDet.OID_CONC_PV),getSesion()));
    comproordenpagodet.setComentario(db.getString(DBComproOrdenPagoDet.COMENTARIO));
    comproordenpagodet.setImporteCuota(db.getMoney(DBComproOrdenPagoDet.IMPORTE_CUOTA));
    comproordenpagodet.setSaldoCuota(db.getMoney(DBComproOrdenPagoDet.SALDO_CUOTA));
    comproordenpagodet.setAutorizado(db.getMoney(DBComproOrdenPagoDet.AUTORIZADO));
    comproordenpagodet.setPagar(db.getMoney(DBComproOrdenPagoDet.PAGAR));
    comproordenpagodet.setCotizacion(db.getValorCotizacion(DBComproOrdenPagoDet.COTIZACION));
    
  }
}
