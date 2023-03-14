package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.GrupoEstructuraPlanif;
import com.srn.erp.presupuesto.da.DBGrupoEstructuraPlanif;

public class FactoryGrupoEstructuraPlanif extends FactoryObjetoLogico { 

  public FactoryGrupoEstructuraPlanif() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoEstructuraPlanif grupoestructuraplanif = (GrupoEstructuraPlanif) objLog;
    grupoestructuraplanif.setOID(db.getInteger(DBGrupoEstructuraPlanif.OID_GRUPO_EST));
    grupoestructuraplanif.setCodigo(db.getString(DBGrupoEstructuraPlanif.CODIGO));
    grupoestructuraplanif.setDescripcion(db.getString(DBGrupoEstructuraPlanif.DESCRIPCION));
    grupoestructuraplanif.setActivo(db.getBoolean(DBGrupoEstructuraPlanif.ACTIVO));
    grupoestructuraplanif.setOrden(db.getInteger(DBGrupoEstructuraPlanif.ORDEN));

  }
}
