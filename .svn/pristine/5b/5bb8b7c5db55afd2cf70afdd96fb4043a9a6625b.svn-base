package com.srn.erp.stock.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.stock.bm.AgrupadorDeposito;
import com.srn.erp.stock.da.DBAgrupadorDeposito;

public class FactoryAgrupadorDeposito extends FactoryObjetoLogico { 

  public FactoryAgrupadorDeposito() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AgrupadorDeposito agrupadordeposito = (AgrupadorDeposito) objLog;
    agrupadordeposito.setOID(db.getInteger(DBAgrupadorDeposito.OID_AGRUPADOR_DEPO));
    agrupadordeposito.setCodigo(db.getString(DBAgrupadorDeposito.CODIGO));
    agrupadordeposito.setDescripcion(db.getString(DBAgrupadorDeposito.DESCRIPCION));
    agrupadordeposito.setActivo(db.getBoolean(DBAgrupadorDeposito.ACTIVO));

  }
}
