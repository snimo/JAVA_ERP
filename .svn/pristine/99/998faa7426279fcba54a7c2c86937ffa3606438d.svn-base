package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.EjercicioPeri;
import com.srn.erp.contabilidad.da.DBEjercicioPeri;
import com.srn.erp.general.bm.Periodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEjercicioPeri extends FactoryObjetoLogico {

  public FactoryEjercicioPeri() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EjercicioPeri ejercicioperi = (EjercicioPeri) objLog;
  ejercicioperi.setOID(db.getInteger(DBEjercicioPeri.OID_EJER_PERI));
    ejercicioperi.setEjercicio(Ejercicio.findByOidProxy(db.getInteger(DBEjercicioPeri.OID_EJERCICIO),getSesion()));
    ejercicioperi.setSecu(db.getInteger(DBEjercicioPeri.SECU));
    ejercicioperi.setPeriodo(Periodo.findByOidProxy(db.getInteger(DBEjercicioPeri.OID_PERI),getSesion()));
    ejercicioperi.setCerrado(db.getBoolean(DBEjercicioPeri.CERRADO));
    ejercicioperi.setActivo(db.getBoolean(DBEjercicioPeri.ACTIVO));

  }
}
