package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.bm.ValoresRecibo;
import com.srn.erp.tesoreria.da.DBValoresRecibo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValoresRecibo extends FactoryObjetoLogico { 

  public FactoryValoresRecibo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValoresRecibo valoresrecibo = (ValoresRecibo) objLog;
    valoresrecibo.setOID(db.getInteger(DBValoresRecibo.OID_VAL_EN_RECIBO));
    valoresrecibo.setRecibo(Recibo.findByOidProxy(db.getInteger(DBValoresRecibo.OID_RECIBO),getSesion()));
    valoresrecibo.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBValoresRecibo.OID_TIPO_VALOR),getSesion()));
    valoresrecibo.setValor(Valor.findByOidProxy(db.getInteger(DBValoresRecibo.OID_VALOR),getSesion()));
    valoresrecibo.setImpo_mon_ori(db.getMoney(DBValoresRecibo.IMPO_MON_ORI));
    valoresrecibo.setImpo_mon_loc(db.getMoney(DBValoresRecibo.IMPO_MON_LOC));
    valoresrecibo.setCotizacion(db.getValorCotizacion(DBValoresRecibo.COTIZACION));
    valoresrecibo.setImpoMonRec(db.getMoney(DBValoresRecibo.IMPO_MON_REC));
  }
}
