package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.Indice;
import com.srn.erp.general.bm.IndiceValor;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBIndiceValor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryIndiceValor extends FactoryObjetoLogico {

  public FactoryIndiceValor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    IndiceValor indicevalor = (IndiceValor) objLog;
    indicevalor.setOID(db.getInteger(DBIndiceValor.OID_INDICE_VAL));
    indicevalor.setPeri(Periodo.findByOidProxy(db.getInteger(DBIndiceValor.OID_PERI),getSesion()));
    indicevalor.setValor(db.getDouble(DBIndiceValor.INDICE));
    indicevalor.setIndice(Indice.findByOidProxy(db.getInteger(DBIndiceValor.OID_INDICE),getSesion()));
    indicevalor.setActivo(db.getBoolean(DBIndiceValor.ACTIVO));

  }
}
