package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.CategoriaSujetoTurno;
import com.srn.erp.turnos.da.DBCategoriaSujetoTurno;

public class FactoryCategoriaSujetoTurno extends FactoryObjetoLogico { 

  public FactoryCategoriaSujetoTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategoriaSujetoTurno categoriasujetoturno = (CategoriaSujetoTurno) objLog;
    categoriasujetoturno.setOID(db.getInteger(DBCategoriaSujetoTurno.OID_CATEGORIA));
    categoriasujetoturno.setCodigo(db.getString(DBCategoriaSujetoTurno.CODIGO));
    categoriasujetoturno.setDescripcion(db.getString(DBCategoriaSujetoTurno.DESCRIPCION));
    categoriasujetoturno.setComportamiento(db.getString(DBCategoriaSujetoTurno.COMPORTAMIENTO));
    categoriasujetoturno.setActivo(db.getBoolean(DBCategoriaSujetoTurno.ACTIVO));
    categoriasujetoturno.setNoPermitirTurno(db.getBoolean(DBCategoriaSujetoTurno.NO_PERMITIR_TURNO));
    categoriasujetoturno.setMontoMaxDeuda(db.getMoney(DBCategoriaSujetoTurno.MONTO_MAX_DEUDA));

  }
}
