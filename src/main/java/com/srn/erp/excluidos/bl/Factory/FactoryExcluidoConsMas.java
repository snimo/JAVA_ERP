package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.ExcluidoConsMas;
import com.srn.erp.excluidos.bm.IndividuoExcluido;
import com.srn.erp.excluidos.da.DBExcluidoConsMas;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryExcluidoConsMas extends FactoryObjetoLogico { 

  public FactoryExcluidoConsMas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ExcluidoConsMas excluidoconsmas = (ExcluidoConsMas) objLog;
    excluidoconsmas.setOID(db.getInteger(DBExcluidoConsMas.OID_CONS_MAS));
    excluidoconsmas.setIndividuo(IndividuoExcluido.findByOidProxy(db.getInteger(DBExcluidoConsMas.OID_INDIVIDUO),getSesion()));
    excluidoconsmas.setNro_lote(db.getInteger(DBExcluidoConsMas.NRO_LOTE));
    excluidoconsmas.setNro_orden(db.getInteger(DBExcluidoConsMas.NRO_ORDEN));
    excluidoconsmas.setFecha(db.getDate(DBExcluidoConsMas.FECHA));
    excluidoconsmas.setActivo(db.getBoolean(DBExcluidoConsMas.ACTIVO));

  }
}
