package com.srn.erp.conciTarjeta.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.conciTarjeta.bm.AgrupadorTarjConci;
import com.srn.erp.conciTarjeta.da.DBAgrupadorTarjConci;

public class FactoryAgrupadorTarjConci extends FactoryObjetoLogico { 

  public FactoryAgrupadorTarjConci() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AgrupadorTarjConci agrupadortarjconci = (AgrupadorTarjConci) objLog;
    agrupadortarjconci.setOID(db.getInteger(DBAgrupadorTarjConci.OID_AGRUP_TAR));
    agrupadortarjconci.setCodigo(db.getString(DBAgrupadorTarjConci.CODIGO));
    agrupadortarjconci.setDescripcion(db.getString(DBAgrupadorTarjConci.DESCRIPCION));
    agrupadortarjconci.setActivo(db.getBoolean(DBAgrupadorTarjConci.ACTIVO));

  }
}
