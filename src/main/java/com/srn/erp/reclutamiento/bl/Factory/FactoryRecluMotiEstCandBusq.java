package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluMotiEstCandBusq;
import com.srn.erp.reclutamiento.da.DBRecluMotiEstCandBusq;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluMotiEstCandBusq extends FactoryObjetoLogico { 

  public FactoryRecluMotiEstCandBusq() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluMotiEstCandBusq reclumotiestcandbusq = (RecluMotiEstCandBusq) objLog;
    reclumotiestcandbusq.setOID(db.getInteger(DBRecluMotiEstCandBusq.OID_MOT_EST_CAND));
    reclumotiestcandbusq.setCodigo(db.getString(DBRecluMotiEstCandBusq.CODIGO));
    reclumotiestcandbusq.setDescripcion(db.getString(DBRecluMotiEstCandBusq.DESCRIPCION));
    reclumotiestcandbusq.setActivo(db.getBoolean(DBRecluMotiEstCandBusq.ACTIVO));

  }
}
