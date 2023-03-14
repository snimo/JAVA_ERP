package com.srn.erp.legales.bl.Factory;


import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.legales.bm.ResultadoJuicio;
import com.srn.erp.legales.da.DBResultadoJuicio;

public class FactoryResultadoJuicio extends FactoryObjetoLogico { 

  public FactoryResultadoJuicio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ResultadoJuicio resultadojuicio = (ResultadoJuicio) objLog;
    resultadojuicio.setOID(db.getInteger(DBResultadoJuicio.OID_RESUL_JUICIO));
    resultadojuicio.setCodigo(db.getString(DBResultadoJuicio.CODIGO));
    resultadojuicio.setDescripcion(db.getString(DBResultadoJuicio.DESCRIPCION));
    resultadojuicio.setActivo(db.getBoolean(DBResultadoJuicio.ACTIVO));
  }
}
