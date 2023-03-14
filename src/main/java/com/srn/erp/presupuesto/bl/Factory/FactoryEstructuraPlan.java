package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.EstructuraPlan;
import com.srn.erp.presupuesto.da.DBEstructuraPlan;

public class FactoryEstructuraPlan extends FactoryObjetoLogico { 

  public FactoryEstructuraPlan() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstructuraPlan estructuraplan = (EstructuraPlan) objLog;
    estructuraplan.setOID(db.getInteger(DBEstructuraPlan.OID_ESTRUC_PLAN));
    estructuraplan.setCodigo(db.getString(DBEstructuraPlan.CODIGO));
    estructuraplan.setDescripcion(db.getString(DBEstructuraPlan.DESCRIPCION));
    estructuraplan.setActivo(db.getBoolean(DBEstructuraPlan.ACTIVO));

  }
}
