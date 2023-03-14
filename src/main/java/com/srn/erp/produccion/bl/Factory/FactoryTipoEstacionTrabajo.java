package com.srn.erp.produccion.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.produccion.bm.TipoEstacionTrabajo;
import com.srn.erp.produccion.da.DBTipoEstacionTrabajo;

public class FactoryTipoEstacionTrabajo extends FactoryObjetoLogico { 

  public FactoryTipoEstacionTrabajo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoEstacionTrabajo tipoestaciontrabajo = (TipoEstacionTrabajo) objLog;
    tipoestaciontrabajo.setOID(db.getInteger(DBTipoEstacionTrabajo.OID_TIPO_ESTACION));
    tipoestaciontrabajo.setCodigo(db.getString(DBTipoEstacionTrabajo.CODIGO));
    tipoestaciontrabajo.setDescripcion(db.getString(DBTipoEstacionTrabajo.DESCRIPCION));
    tipoestaciontrabajo.setActivo(db.getBoolean(DBTipoEstacionTrabajo.ACTIVO));

  }
}
