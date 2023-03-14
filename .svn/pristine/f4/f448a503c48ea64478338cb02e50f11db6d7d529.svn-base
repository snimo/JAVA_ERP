package com.srn.erp.turnos.bl.Factory;

import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.bm.ConcHabCateg;
import com.srn.erp.turnos.da.DBConcHabCateg;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConcHabCateg extends FactoryObjetoLogico { 

  public FactoryConcHabCateg() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConcHabCateg conchabcateg = (ConcHabCateg) objLog;
    conchabcateg.setOID(db.getInteger(DBConcHabCateg.OID_CONC_HAB_CATEG));
    conchabcateg.setComportamiento(db.getString(DBConcHabCateg.COMPORTAMIENTO));
    conchabcateg.setConcepto(db.getString(DBConcHabCateg.CONCEPTO));
    conchabcateg.setOid_categoria(CategoriaSujetoTurno.findByOidProxy(db.getInteger(DBConcHabCateg.CATEGORIA),getSesion()));

  }
}
