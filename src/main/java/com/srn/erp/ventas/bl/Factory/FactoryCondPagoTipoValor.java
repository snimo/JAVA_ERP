package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.ventas.bm.CondPagoTipoValor;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.da.DBCondPagoTipoValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondPagoTipoValor extends FactoryObjetoLogico {

  public FactoryCondPagoTipoValor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondPagoTipoValor condpagotipovalor = (CondPagoTipoValor) objLog;
    condpagotipovalor.setOID(db.getInteger(DBCondPagoTipoValor.OID_COND_PAGO_TV));
    condpagotipovalor.setCondicion_pago(CondicionPago.findByOidProxy(db.getInteger(DBCondPagoTipoValor.OID_COND_PAGO),getSesion()));
    condpagotipovalor.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBCondPagoTipoValor.OID_TIPO_VALOR),getSesion()));
    condpagotipovalor.setSugerir(db.getBoolean(DBCondPagoTipoValor.SUGERIR).booleanValue());
  }
}
