package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.DeudaPorConcTurno;
import com.srn.erp.turnos.da.DBDeudaPorConcTurno;

public class FactoryDeudaPorConcTurno extends FactoryObjetoLogico { 

  public FactoryDeudaPorConcTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    DeudaPorConcTurno deudaporconcturno = (DeudaPorConcTurno) objLog;
    deudaporconcturno.setOID(db.getInteger(DBDeudaPorConcTurno.OID_DEUDA_CONC));
    deudaporconcturno.setDescripcion(db.getString(DBDeudaPorConcTurno.DESCRIPCION));
    deudaporconcturno.setComportamiento(db.getString(DBDeudaPorConcTurno.COMPORTAMIENTO));
    deudaporconcturno.setMax_dias_atraso(db.getInteger(DBDeudaPorConcTurno.MAX_DIAS_ATRASO));
    deudaporconcturno.setMax_deuda(db.getDouble(DBDeudaPorConcTurno.MAX_DEUDA));
    deudaporconcturno.setActivo(db.getBoolean(DBDeudaPorConcTurno.ACTIVO));
    deudaporconcturno.setCantMaxPeriDeuda(db.getInteger(DBDeudaPorConcTurno.CANT_MAX_PERI_DEUDA));

  }
}
