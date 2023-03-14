package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.TipoPeriodo;
import com.srn.erp.presupuesto.bm.VarEscenarioCab;
import com.srn.erp.presupuesto.da.DBVarEscenarioCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryVarEscenarioCab extends FactoryObjetoLogico { 

  public FactoryVarEscenarioCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    VarEscenarioCab varescenariocab = (VarEscenarioCab) objLog;
    varescenariocab.setOID(db.getInteger(DBVarEscenarioCab.OID_VAR_ESC_CAB));
    varescenariocab.setCodigo(db.getString(DBVarEscenarioCab.CODIGO));
    varescenariocab.setDescripcion(db.getString(DBVarEscenarioCab.DESCRIPCION));
    varescenariocab.setTipo_periodo(TipoPeriodo.findByOidProxy(db.getInteger(DBVarEscenarioCab.OID_TIPO_PERI),getSesion()));
    varescenariocab.setActivo(db.getBoolean(DBVarEscenarioCab.ACTIVO));

  }
}
