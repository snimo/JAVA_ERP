package com.srn.erp.excluidos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.excluidos.bm.SupervisorExcluido;
import com.srn.erp.excluidos.da.DBSupervisorExcluido;

public class FactorySupervisorExcluido extends FactoryObjetoLogico { 

  public FactorySupervisorExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SupervisorExcluido supervisorexcluido = (SupervisorExcluido) objLog;
    supervisorexcluido.setOID(db.getInteger(DBSupervisorExcluido.OID_SUPERVISOR));
    supervisorexcluido.setCodigo(db.getString(DBSupervisorExcluido.CODIGO));
    supervisorexcluido.setDescripcion(db.getString(DBSupervisorExcluido.DESCRIPCION));
    supervisorexcluido.setActivo(db.getBoolean(DBSupervisorExcluido.ACTIVO));

  }
}
