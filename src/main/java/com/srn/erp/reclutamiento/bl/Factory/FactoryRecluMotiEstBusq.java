package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluMotiEstBusq;
import com.srn.erp.reclutamiento.da.DBRecluMotiEstBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluMotiEstBusq extends FactoryObjetoLogico { 

  public FactoryRecluMotiEstBusq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluMotiEstBusq reclumotiestbusq = (RecluMotiEstBusq) objLog;
    reclumotiestbusq.setOID(db.getInteger(DBRecluMotiEstBusq.OID_MOT_EST_BUSQ));
    reclumotiestbusq.setCodigo(db.getString(DBRecluMotiEstBusq.CODIGO));
    reclumotiestbusq.setDescripcion(db.getString(DBRecluMotiEstBusq.DESCRIPCION));
    reclumotiestbusq.setActivo(db.getBoolean(DBRecluMotiEstBusq.ACTIVO));

  }
}
