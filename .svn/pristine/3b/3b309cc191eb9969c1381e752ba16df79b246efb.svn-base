package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.Metrica;
import com.srn.erp.presupuesto.da.DBMetrica;

public class FactoryMetrica extends FactoryObjetoLogico { 

  public FactoryMetrica() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Metrica metrica = (Metrica) objLog;
    metrica.setOID(db.getInteger(DBMetrica.OID_METRICA));
    metrica.setCodigo(db.getString(DBMetrica.CODIGO));
    metrica.setDescripcion(db.getString(DBMetrica.DESCRIPCION));
    metrica.setTipo(db.getString(DBMetrica.TIPO));
    metrica.setCant_decimales(db.getInteger(DBMetrica.CANT_DECIMALES));
    metrica.setMascara_display(db.getString(DBMetrica.MASCARA_DISPLAY));
    metrica.setActivo(db.getBoolean(DBMetrica.ACTIVO));
    metrica.setNroInterno(db.getInteger(DBMetrica.NRO_INTERNO));
  }
}
