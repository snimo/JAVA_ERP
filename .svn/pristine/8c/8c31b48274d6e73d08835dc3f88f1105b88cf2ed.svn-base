package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.bm.TipoValorFormaPago;
import com.srn.erp.pagos.da.DBTipoValorFormaPago;
import com.srn.erp.tesoreria.bm.TipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoValorFormaPago extends FactoryObjetoLogico {

  public FactoryTipoValorFormaPago() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoValorFormaPago tipovalorformapago = (TipoValorFormaPago) objLog;
    tipovalorformapago.setOID(db.getInteger(DBTipoValorFormaPago.OID_FORMA_PAGO_TV));
    tipovalorformapago.setFormapago(FormaPago.findByOidProxy(db.getInteger(DBTipoValorFormaPago.OID_FORMA_PAGO),getSesion()));
    tipovalorformapago.setTipovalor(TipoValor.findByOidProxy(db.getInteger(DBTipoValorFormaPago.OID_TIPO_VALOR),getSesion()));
    tipovalorformapago.setActivo(db.getBoolean(DBTipoValorFormaPago.ACTIVO));

  }
}
