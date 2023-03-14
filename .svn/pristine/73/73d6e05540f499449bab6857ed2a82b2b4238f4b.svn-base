package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.MotivoReservaTurno;
import com.srn.erp.turnos.da.DBMotivoReservaTurno;

public class FactoryMotivoReservaTurno extends FactoryObjetoLogico { 

  public FactoryMotivoReservaTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoReservaTurno motivoreservaturno = (MotivoReservaTurno) objLog;
    motivoreservaturno.setOID(db.getInteger(DBMotivoReservaTurno.OID_MOTIVO));
    motivoreservaturno.setCodigo(db.getString(DBMotivoReservaTurno.CODIGO));
    motivoreservaturno.setDescripcion(db.getString(DBMotivoReservaTurno.DESCRIPCION));
    motivoreservaturno.setActivo(db.getBoolean(DBMotivoReservaTurno.ACTIVO));
  }
}
