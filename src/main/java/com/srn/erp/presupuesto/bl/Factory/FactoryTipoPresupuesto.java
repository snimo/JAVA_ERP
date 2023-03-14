package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.TipoPresupuesto;
import com.srn.erp.presupuesto.da.DBTipoPresupuesto;

public class FactoryTipoPresupuesto extends FactoryObjetoLogico { 

  public FactoryTipoPresupuesto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoPresupuesto tipopresupuesto = (TipoPresupuesto) objLog;
    tipopresupuesto.setOID(db.getInteger(DBTipoPresupuesto.OID_TIPO_PRESU));
    tipopresupuesto.setCodigo(db.getString(DBTipoPresupuesto.CODIGO));
    tipopresupuesto.setDescripcion(db.getString(DBTipoPresupuesto.DESCRIPCION));
    tipopresupuesto.setActivo(db.getBoolean(DBTipoPresupuesto.ACTIVO));

  }
}
