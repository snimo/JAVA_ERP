package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.MotivoVisita;
import com.srn.erp.cip.da.DBMotivoVisita;

public class FactoryMotivoVisita extends FactoryObjetoLogico { 

  public FactoryMotivoVisita() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoVisita motivovisita = (MotivoVisita) objLog;
    motivovisita.setOID(db.getInteger(DBMotivoVisita.OID_MOT_VISITA));
    motivovisita.setCodigo(db.getString(DBMotivoVisita.CODIGO));
    motivovisita.setDescripcion(db.getString(DBMotivoVisita.DESCRIPCION));
    motivovisita.setActivo(db.getBoolean(DBMotivoVisita.ACTIVO));
    motivovisita.setHabEnIngPermiso(db.getBoolean(DBMotivoVisita.HAB_EN_ING_PERM));
  }
}
