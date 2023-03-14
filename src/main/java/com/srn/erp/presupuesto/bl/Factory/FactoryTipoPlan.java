package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.TipoPlan;
import com.srn.erp.presupuesto.da.DBTipoPlan;

public class FactoryTipoPlan extends FactoryObjetoLogico { 

  public FactoryTipoPlan() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoPlan tipoplan = (TipoPlan) objLog;
    tipoplan.setOID(db.getInteger(DBTipoPlan.OID_TIPO_PLAN));
    tipoplan.setCodigo(db.getString(DBTipoPlan.CODIGO));
    tipoplan.setDescripcion(db.getString(DBTipoPlan.DESCRIPCION));
    tipoplan.setActivo(db.getBoolean(DBTipoPlan.ACTIVO));
  }
}
