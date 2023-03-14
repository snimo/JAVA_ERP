package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.TarjetaCredito;
import com.srn.erp.tesoreria.da.DBTarjetaCredito;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTarjetaCredito extends FactoryObjetoLogico {

  public FactoryTarjetaCredito() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TarjetaCredito tarjetacredito = (TarjetaCredito) objLog;
    tarjetacredito.setOID(db.getInteger(DBTarjetaCredito.OID_TAR_CREDITO));
    tarjetacredito.setCodigo(db.getString(DBTarjetaCredito.CODIGO));
    tarjetacredito.setDescripcion(db.getString(DBTarjetaCredito.DESCRIPCION));
    tarjetacredito.setActivo(db.getBoolean(DBTarjetaCredito.ACTIVO));
  }
}
