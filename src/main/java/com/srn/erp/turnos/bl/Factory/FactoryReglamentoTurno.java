package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.ReglamentoTurno;
import com.srn.erp.turnos.da.DBReglamentoTurno;

public class FactoryReglamentoTurno extends FactoryObjetoLogico { 

  public FactoryReglamentoTurno() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ReglamentoTurno reglamentoturno = (ReglamentoTurno) objLog;
    reglamentoturno.setOID(db.getInteger(DBReglamentoTurno.OID_REGLA_CAB));
    reglamentoturno.setCodigo(db.getString(DBReglamentoTurno.CODIGO));
    reglamentoturno.setDescripcion(db.getString(DBReglamentoTurno.DESCRIPCION));
    reglamentoturno.setComportamiento(db.getString(DBReglamentoTurno.COMPORTAMIENTO));
    reglamentoturno.setActivo(db.getBoolean(DBReglamentoTurno.ACTIVO));
    reglamentoturno.setUsar(db.getBoolean(DBReglamentoTurno.USAR));
    reglamentoturno.setReglaJugadorInactivo(db.getBoolean(DBReglamentoTurno.REGLA_JUGADOR_INACTIVO));
    reglamentoturno.setReglaJugadorSuspension(db.getBoolean(DBReglamentoTurno.REGLA_JUGADOR_SUSPENSION));
    reglamentoturno.setReglaUnTurnoActivo(db.getBoolean(DBReglamentoTurno.REGLA_JUGADOR_1_TURNO_ACT));
    
    reglamentoturno.setReglaDeudaCategoria(db.getBoolean(DBReglamentoTurno.REGLA_DEUDA_CATEG));
    reglamentoturno.setReglaDeudaGeneral(db.getBoolean(DBReglamentoTurno.REGLA_DEUDA_GRAL));
    reglamentoturno.setMontoDeudaGral(db.getMoney(DBReglamentoTurno.REGLA_MONTO_DEUDA_GRAL));
    reglamentoturno.setReglaAntiguedadDeuda(db.getBoolean(DBReglamentoTurno.REGLA_ANT_DEUDA));;
    reglamentoturno.setDiasAntiguedadDeuda(db.getInteger(DBReglamentoTurno.DIAS_ANT_DEUDA));
    
    reglamentoturno.setReglaTurnoSegunRelacion(db.getBoolean(DBReglamentoTurno.REGLA_TURNO_SEGUN_RELA));;
    reglamentoturno.setReglaTurnoSegunCategoria(db.getBoolean(DBReglamentoTurno.REGLA_TURNO_SEGUN_CATEG));;
    reglamentoturno.setReglaDeudaConcepto(db.getBoolean(DBReglamentoTurno.REGLA_DEUDA_CONCEPTO));;
    reglamentoturno.setReglaConcSufCateg(db.getBoolean(DBReglamentoTurno.REGLA_CONC_SUF_CATEG));;
    
    
    
    
    
  }
}
