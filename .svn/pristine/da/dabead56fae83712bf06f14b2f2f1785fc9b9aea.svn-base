package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.da.DBEjercicio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEjercicio extends FactoryObjetoLogico {

  public FactoryEjercicio() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Ejercicio ejercicio = (Ejercicio) objLog;
    ejercicio.setOID(db.getInteger(DBEjercicio.OID_EJERCICIO));
    ejercicio.setNroejer(db.getInteger(DBEjercicio.NRO_EJER));
    ejercicio.setFechadesde(db.getDate(DBEjercicio.FECHA_DESDE));
    ejercicio.setFechahasta(db.getDate(DBEjercicio.FECHA_HASTA));
    ejercicio.setActivo(db.getBoolean(DBEjercicio.ACTIVO));
    ejercicio.setLibroDiarioPorComprobante(db.getString(DBEjercicio.LIB_DIA_COMPRO));
    ejercicio.setFechaGenLibDiario(db.getDate(DBEjercicio.FEC_GEN_LIB_DIA));
    ejercicio.setUltimaPresentacionLibroDiario(db.getString(DBEjercicio.ULT_PRES_LIB_DIARIO));
  }
}
