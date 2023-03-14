package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.TransferenciaEfectivo;
import com.srn.erp.tesoreria.bm.TransferenciaValores;
import com.srn.erp.tesoreria.da.DBTransferenciaEfectivo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTransferenciaEfectivo extends FactoryObjetoLogico { 

  public FactoryTransferenciaEfectivo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TransferenciaEfectivo transferenciaefectivo = (TransferenciaEfectivo) objLog;
    transferenciaefectivo.setOID(db.getInteger(DBTransferenciaEfectivo.OID_TRANS_EFE));
    transferenciaefectivo.setTransferencia_valores(TransferenciaValores.findByOidProxy(db.getInteger(DBTransferenciaEfectivo.OID_TRANSF_VAL),getSesion()));
    transferenciaefectivo.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBTransferenciaEfectivo.OID_TIPO_VALOR),getSesion()));
    transferenciaefectivo.setSaldo(db.getMoney(DBTransferenciaEfectivo.SALDO));
    transferenciaefectivo.setTransferido(db.getMoney(DBTransferenciaEfectivo.TRANSFERIDO));
  }
}
