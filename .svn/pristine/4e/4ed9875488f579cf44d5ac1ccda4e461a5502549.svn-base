package com.srn.erp.presupuesto.bl.Factory;


import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.da.DBTipoPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoPeriodo extends FactoryObjetoLogico { 

  public FactoryTipoPeriodo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoPeriodo tipoperiodo = (TipoPeriodo) objLog;
    tipoperiodo.setOID(db.getInteger(DBTipoPeriodo.OID_TIPO_PERI));
    tipoperiodo.setCodigo(db.getString(DBTipoPeriodo.CODIGO));
    tipoperiodo.setDescripcion(db.getString(DBTipoPeriodo.DESCRIPCION));
    tipoperiodo.setActivo(db.getBoolean(DBTipoPeriodo.ACTIVO));
    tipoperiodo.setNroInterno(db.getInteger(DBTipoPeriodo.NRO_INTERNO));
  }
}
