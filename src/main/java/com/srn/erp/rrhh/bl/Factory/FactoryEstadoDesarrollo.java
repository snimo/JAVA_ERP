package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.EstadoDesarrollo;
import com.srn.erp.rrhh.da.DBEstadoDesarrollo;

public class FactoryEstadoDesarrollo extends FactoryObjetoLogico { 

  public FactoryEstadoDesarrollo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EstadoDesarrollo estadodesarrollo = (EstadoDesarrollo) objLog;
    estadodesarrollo.setOID(db.getInteger(DBEstadoDesarrollo.OID_EST_DESA));
    estadodesarrollo.setCodigo(db.getString(DBEstadoDesarrollo.CODIGO));
    estadodesarrollo.setDescripcion(db.getString(DBEstadoDesarrollo.DESCRIPCION));
    estadodesarrollo.setNo_promocionar(db.getBoolean(DBEstadoDesarrollo.NO_PROMOCIONAR));
    estadodesarrollo.setActivo(db.getBoolean(DBEstadoDesarrollo.ACTIVO));

  }
}
