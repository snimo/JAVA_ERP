package com.srn.erp.presupuesto.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.presupuesto.bm.MonedaPresu;
import com.srn.erp.presupuesto.da.DBMonedaPresu;

public class FactoryMonedaPresu extends FactoryObjetoLogico { 

  public FactoryMonedaPresu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MonedaPresu monedapresu = (MonedaPresu) objLog;
    monedapresu.setOID(db.getInteger(DBMonedaPresu.OID_MONEDA));
    monedapresu.setCodigo(db.getString(DBMonedaPresu.CODIGO));
    monedapresu.setDescripcion(db.getString(DBMonedaPresu.DESCRIPCION));
    monedapresu.setSimbolo(db.getString(DBMonedaPresu.SIMBOL));
    monedapresu.setActivo(db.getBoolean(DBMonedaPresu.ACTIVO));

  }
}
