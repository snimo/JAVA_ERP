package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.MotivoEgresoEmp;
import com.srn.erp.rrhh.da.DBMotivoEgresoEmp;

public class FactoryMotivoEgresoEmp extends FactoryObjetoLogico { 

  public FactoryMotivoEgresoEmp() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoEgresoEmp motivoegresoemp = (MotivoEgresoEmp) objLog;
    motivoegresoemp.setOID(db.getInteger(DBMotivoEgresoEmp.OID));
    motivoegresoemp.setCodigo(db.getString(DBMotivoEgresoEmp.CODIGO));
    motivoegresoemp.setDescripcion(db.getString(DBMotivoEgresoEmp.DESCRIPCION));
    motivoegresoemp.setActivo(db.getBoolean(DBMotivoEgresoEmp.ACTIVO));

  }
}
