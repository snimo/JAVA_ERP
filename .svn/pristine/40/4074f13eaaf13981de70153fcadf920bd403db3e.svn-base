package com.srn.erp.turnos.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.turnos.bm.ParteTablero;
import com.srn.erp.turnos.da.DBParteTablero;

public class FactoryParteTablero extends FactoryObjetoLogico { 

  public FactoryParteTablero() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ParteTablero partetablero = (ParteTablero) objLog;
    partetablero.setOID(db.getInteger(DBParteTablero.OID_PARTE_TABLERO));
    partetablero.setDescripcion(db.getString(DBParteTablero.DESCRIPCION));
    partetablero.setLunes(db.getBoolean(DBParteTablero.LUNES));
    partetablero.setMartes(db.getBoolean(DBParteTablero.MARTES));
    partetablero.setMiercoles(db.getBoolean(DBParteTablero.MIERCOLES));
    partetablero.setJueves(db.getBoolean(DBParteTablero.JUEVES));
    partetablero.setViernes(db.getBoolean(DBParteTablero.VIERNES));
    partetablero.setSabado(db.getBoolean(DBParteTablero.SABADO));
    partetablero.setDomingo(db.getBoolean(DBParteTablero.DOMINGO));
    partetablero.setActivo(db.getBoolean(DBParteTablero.ACTIVO));
  }
}
