package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.FechaFacturacionSucursal;
import com.srn.erp.ventas.da.DBFechaFacturacionSucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFechaFacturacionSucursal extends FactoryObjetoLogico {

  public FactoryFechaFacturacionSucursal() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FechaFacturacionSucursal fechafacturacionsucursal = (FechaFacturacionSucursal) objLog;
    fechafacturacionsucursal.setOID(db.getInteger(DBFechaFacturacionSucursal.OID_FEC_FACT_SUC));
    fechafacturacionsucursal.setSucursal(Sucursal.findByOidProxy(db.getInteger(DBFechaFacturacionSucursal.OID_SUCURSAL),getSesion()));
    fechafacturacionsucursal.setFecha_anterior(db.getDate(DBFechaFacturacionSucursal.FEC_ANT));
    fechafacturacionsucursal.setFecha_actual(db.getDate(DBFechaFacturacionSucursal.NUE_FEC));
    fechafacturacionsucursal.setActivo(db.getBoolean(DBFechaFacturacionSucursal.ACTIVO));
  }
}
