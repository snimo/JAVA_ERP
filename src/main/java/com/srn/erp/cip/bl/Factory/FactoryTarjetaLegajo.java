package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.TarjetaLegajo;
import com.srn.erp.cip.da.DBTarjetaLegajo;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTarjetaLegajo extends FactoryObjetoLogico { 

  public FactoryTarjetaLegajo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TarjetaLegajo tarjetalegajo = (TarjetaLegajo) objLog;
    tarjetalegajo.setOID(db.getInteger(DBTarjetaLegajo.OID_TAR_LEG));
    tarjetalegajo.setTipo_tarjeta(db.getString(DBTarjetaLegajo.TIPO_TARJETA));
    tarjetalegajo.setNro_tarjeta(db.getString(DBTarjetaLegajo.NRO_TARJETA));
    tarjetalegajo.setLegajo(Legajo.findByOidProxy(db.getInteger(DBTarjetaLegajo.OID_LEGAJO),getSesion()));
    tarjetalegajo.setActivo(db.getBoolean(DBTarjetaLegajo.ACTIVO));
    tarjetalegajo.setOrden(db.getInteger(DBTarjetaLegajo.ORDEN));
  }
}
