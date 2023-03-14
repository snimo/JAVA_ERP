package com.srn.erp.bancos.bl.Factory;

import com.srn.erp.bancos.bm.ComproConciliacionBcoDia;
import com.srn.erp.bancos.bm.ConciliacionBancoDia;
import com.srn.erp.bancos.bm.ConciliacionCab;
import com.srn.erp.bancos.da.DBConciliacionBancoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConciliacionBancoDia extends FactoryObjetoLogico { 

  public FactoryConciliacionBancoDia() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConciliacionBancoDia conciliacionbancodia = (ConciliacionBancoDia) objLog;
    conciliacionbancodia.setOID(db.getInteger(DBConciliacionBancoDia.OID_CONCI_BCO_DIA));
    conciliacionbancodia.setConciliacion(ConciliacionCab.findByOidProxy(db.getInteger(DBConciliacionBancoDia.OID_CONCI_BCO),getSesion()));
    conciliacionbancodia.setCompro_conciliacion_dia(ComproConciliacionBcoDia.findByOidComproProxy(db.getInteger(DBConciliacionBancoDia.OID_CCO_CONC_DIA),getSesion()));
    conciliacionbancodia.setActivo(db.getBoolean(DBConciliacionBancoDia.ACTIVO));

  }
}
