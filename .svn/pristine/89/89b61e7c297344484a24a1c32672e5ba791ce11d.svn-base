package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.AnuladorRecibo;
import com.srn.erp.tesoreria.bm.ValoresRecibo;
import com.srn.erp.tesoreria.bm.ValoresReciboAnulado;
import com.srn.erp.tesoreria.da.DBValoresReciboAnulado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryValoresReciboAnulado extends FactoryObjetoLogico { 

  public FactoryValoresReciboAnulado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ValoresReciboAnulado valoresreciboanulado = (ValoresReciboAnulado) objLog;
    valoresreciboanulado.setOID(db.getInteger(DBValoresReciboAnulado.OID_ANU_REC_VAL));
    valoresreciboanulado.setAnulador_recibo(AnuladorRecibo.findByOidProxy(db.getInteger(DBValoresReciboAnulado.OID_ANU_REC_CAB),getSesion()));
    valoresreciboanulado.setValor_recibo(ValoresRecibo.findByOidProxy(db.getInteger(DBValoresReciboAnulado.OID_VAL_EN_RECIBO),getSesion()));

  }
}
