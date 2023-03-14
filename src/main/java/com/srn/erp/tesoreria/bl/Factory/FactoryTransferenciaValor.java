package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.TransferenciaValor;
import com.srn.erp.tesoreria.bm.TransferenciaValores;
import com.srn.erp.tesoreria.bm.Valor;
import com.srn.erp.tesoreria.da.DBTransferenciaValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTransferenciaValor extends FactoryObjetoLogico { 

  public FactoryTransferenciaValor() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TransferenciaValor transferenciavalor = (TransferenciaValor) objLog;
    transferenciavalor.setOID(db.getInteger(DBTransferenciaValor.OID_VAL_TRANSF));
    transferenciavalor.setValor(Valor.findByOidProxy(db.getInteger(DBTransferenciaValor.OID_VALOR),getSesion()));
    transferenciavalor.setImporte(db.getMoney(DBTransferenciaValor.IMPORTE));
    transferenciavalor.setTransferencia_valores(TransferenciaValores.findByOidProxy(db.getInteger(DBTransferenciaValor.OID_TRANSF_VAL),getSesion()));
    transferenciavalor.setTransferido(db.getMoney(DBTransferenciaValor.TRANSFERIDO));
  }
}
