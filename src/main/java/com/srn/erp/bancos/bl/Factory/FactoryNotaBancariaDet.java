package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.NotaBancaria;
import com.srn.erp.bancos.bm.NotaBancariaDet;
import com.srn.erp.bancos.da.DBNotaBancariaDet;
import com.srn.erp.contabilidad.bm.CuentaImputable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNotaBancariaDet extends FactoryObjetoLogico { 

  public FactoryNotaBancariaDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NotaBancariaDet notabancariadet = (NotaBancariaDet) objLog;
    notabancariadet.setOID(db.getInteger(DBNotaBancariaDet.OID_ND_NC_DET));
    notabancariadet.setNota_bancaria(NotaBancaria.findByOidProxy(db.getInteger(DBNotaBancariaDet.OID_NC_ND),getSesion()));
    notabancariadet.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBNotaBancariaDet.OID_AI),getSesion()));
    notabancariadet.setDebe(db.getMoney(DBNotaBancariaDet.DEBE));
    notabancariadet.setHaber(db.getMoney(DBNotaBancariaDet.HABER));
    notabancariadet.setComentario(db.getString(DBNotaBancariaDet.COMENTARIO));

  }
}
