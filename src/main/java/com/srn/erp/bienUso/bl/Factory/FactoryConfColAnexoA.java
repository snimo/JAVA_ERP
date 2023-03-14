package com.srn.erp.bienUso.bl.Factory;

import com.srn.erp.bienUso.bm.ConfColAnexoA;
import com.srn.erp.bienUso.da.DBConfColAnexoA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConfColAnexoA extends FactoryObjetoLogico { 

  public FactoryConfColAnexoA() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConfColAnexoA confcolanexoa = (ConfColAnexoA) objLog;
    confcolanexoa.setOID(db.getInteger(DBConfColAnexoA.OID_CONF_ANEXO_A));
    confcolanexoa.setCodigo(db.getString(DBConfColAnexoA.CODIGO));
    confcolanexoa.setDescripcion(db.getString(DBConfColAnexoA.DESCRIPCION));
    confcolanexoa.setNro_col(db.getInteger(DBConfColAnexoA.NRO_COL));
    confcolanexoa.setTipo_ejercicio(db.getString(DBConfColAnexoA.TIPO_EJERCICIO));
    confcolanexoa.setActivo(db.getBoolean(DBConfColAnexoA.ACTIVO));

  }
}
