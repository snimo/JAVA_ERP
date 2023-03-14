package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.RelacionSujetoTurno;
import com.srn.erp.turnos.da.DBRelacionSujetoTurno;

public class FactoryRelacionSujetoTurno extends FactoryObjetoLogico { 

  public FactoryRelacionSujetoTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RelacionSujetoTurno relacionsujetoturno = (RelacionSujetoTurno) objLog;
    relacionsujetoturno.setOID(db.getInteger(DBRelacionSujetoTurno.OID_RELACION));
    relacionsujetoturno.setCodigo(db.getString(DBRelacionSujetoTurno.CODIGO));
    relacionsujetoturno.setDescripcion(db.getString(DBRelacionSujetoTurno.DESCRIPCION));
    relacionsujetoturno.setComportamiento(db.getString(DBRelacionSujetoTurno.COMPORTAMIENTO));
    relacionsujetoturno.setActivo(db.getBoolean(DBRelacionSujetoTurno.ACTIVO));
    relacionsujetoturno.setNoPermitirTurno(db.getBoolean(DBRelacionSujetoTurno.NO_PERMITIR_TURNO));
  }
}
