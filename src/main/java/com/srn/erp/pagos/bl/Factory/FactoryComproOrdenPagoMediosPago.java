package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoMediosPago;
import com.srn.erp.pagos.da.DBComproOrdenPagoMediosPago;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryComproOrdenPagoMediosPago extends FactoryObjetoLogico {

  public FactoryComproOrdenPagoMediosPago() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ComproOrdenPagoMediosPago comproordenpagomediospago = (ComproOrdenPagoMediosPago) objLog;
    comproordenpagomediospago.setOID(db.getInteger(DBComproOrdenPagoMediosPago.OID_OP_MEDIO_PAGO));
    comproordenpagomediospago.setComprobante(ComproCab.findByOidProxyCompro(db.getInteger(DBComproOrdenPagoMediosPago.OID_CCO),getSesion()));
    comproordenpagomediospago.setValor(Valor.findByOidProxy(db.getInteger(DBComproOrdenPagoMediosPago.OID_VALOR),getSesion()));
    comproordenpagomediospago.setTipovalor(TipoValor.findByOidProxy(db.getInteger(DBComproOrdenPagoMediosPago.OID_TIPO_VALOR),getSesion()));
    comproordenpagomediospago.setImpomonvalor(db.getMoney(DBComproOrdenPagoMediosPago.IMPO_MON_VALOR));
    comproordenpagomediospago.setImpomonpago(db.getMoney(DBComproOrdenPagoMediosPago.IMPO_MON_PAGO));
    comproordenpagomediospago.setCotizacion(db.getDouble(DBComproOrdenPagoMediosPago.COTIZACION));
    comproordenpagomediospago.setImpoMonLocal(db.getMoney(DBComproOrdenPagoMediosPago.IMPO_MON_LOCAL));
    comproordenpagomediospago.setCaja(Caja.findByOidProxy(db.getInteger(DBComproOrdenPagoMediosPago.OID_CAJA),getSesion()));
  }
}
