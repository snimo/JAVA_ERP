package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.ImpoDeudaSujetoTurnos;
import com.srn.erp.turnos.da.DBImpoDeudaSujetoTurnos;

public class FactoryImpoDeudaSujetoTurnos extends FactoryObjetoLogico { 

  public FactoryImpoDeudaSujetoTurnos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ImpoDeudaSujetoTurnos impodeudasujetoturnos = (ImpoDeudaSujetoTurnos) objLog;
    impodeudasujetoturnos.setOID(db.getInteger(DBImpoDeudaSujetoTurnos.OID_DEUDA_SOCIO));
    impodeudasujetoturnos.setNro_socio(db.getInteger(DBImpoDeudaSujetoTurnos.NRO_SOCIO));
    impodeudasujetoturnos.setFecha(db.getDate(DBImpoDeudaSujetoTurnos.FECHA));
    impodeudasujetoturnos.setCod_mov(db.getString(DBImpoDeudaSujetoTurnos.COD_MOV));
    impodeudasujetoturnos.setNro(db.getInteger(DBImpoDeudaSujetoTurnos.NRO));
    impodeudasujetoturnos.setSaldo(db.getDouble(DBImpoDeudaSujetoTurnos.SALDO));
    impodeudasujetoturnos.setConcepto(db.getString(DBImpoDeudaSujetoTurnos.CONCEPTO));

  }
}
