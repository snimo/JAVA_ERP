package com.srn.erp.excluidos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.excluidos.bm.TurnoExcluido;
import com.srn.erp.excluidos.da.DBTurnoExcluido;

public class FactoryTurnoExcluido extends FactoryObjetoLogico { 

  public FactoryTurnoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TurnoExcluido turnoexcluido = (TurnoExcluido) objLog;
    turnoexcluido.setOID(db.getInteger(DBTurnoExcluido.OID_TURNO));
    turnoexcluido.setCodigo(db.getString(DBTurnoExcluido.CODIGO));
    turnoexcluido.setDescripcion(db.getString(DBTurnoExcluido.DESCRIPCION));
    turnoexcluido.setActivo(db.getBoolean(DBTurnoExcluido.ACTIVO));
  }
}
