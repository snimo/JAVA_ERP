package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.AgrupadorPlano;
import com.srn.erp.cip.da.DBAgrupadorPlano;

public class FactoryAgrupadorPlano extends FactoryObjetoLogico { 

  public FactoryAgrupadorPlano() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AgrupadorPlano agrupadorplano = (AgrupadorPlano) objLog;
    agrupadorplano.setOID(db.getInteger(DBAgrupadorPlano.OID_AGRUP_PLANO));
    agrupadorplano.setCodigo(db.getString(DBAgrupadorPlano.CODIGO));
    agrupadorplano.setDescripcion(db.getString(DBAgrupadorPlano.DESCRIPCION));
    agrupadorplano.setOrden(db.getInteger(DBAgrupadorPlano.ORDEN));
    agrupadorplano.setActivo(db.getBoolean(DBAgrupadorPlano.ACTIVO));

  }
}