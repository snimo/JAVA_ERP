package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluMotivoBusqueda;
import com.srn.erp.reclutamiento.da.DBRecluMotivoBusqueda;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluMotivoBusqueda extends FactoryObjetoLogico { 

  public FactoryRecluMotivoBusqueda() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluMotivoBusqueda reclumotivobusqueda = (RecluMotivoBusqueda) objLog;
    reclumotivobusqueda.setOID(db.getInteger(DBRecluMotivoBusqueda.OID_MOTIVO_BUSQ));
    reclumotivobusqueda.setCodigo(db.getString(DBRecluMotivoBusqueda.CODIGO));
    reclumotivobusqueda.setDescripcion(db.getString(DBRecluMotivoBusqueda.DESCRIPCION));
    reclumotivobusqueda.setActivo(db.getBoolean(DBRecluMotivoBusqueda.ACTIVO));

  }
}
