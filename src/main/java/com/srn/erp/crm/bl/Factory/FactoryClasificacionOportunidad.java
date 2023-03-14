package com.srn.erp.crm.bl.Factory;

import com.srn.erp.crm.bm.ClasificacionOportunidad;
import com.srn.erp.crm.da.DBClasificacionOportunidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryClasificacionOportunidad extends FactoryObjetoLogico { 

  public FactoryClasificacionOportunidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ClasificacionOportunidad clasifOpor = (ClasificacionOportunidad) objLog;
    clasifOpor.setCodigo(db.getString(DBClasificacionOportunidad.CODIGO));
    clasifOpor.setDescripcion(db.getString(DBClasificacionOportunidad.DESCRIPCION));
    clasifOpor.setActivo(db.getBoolean(DBClasificacionOportunidad.ACTIVO));
    clasifOpor.setOID(db.getInteger(DBClasificacionOportunidad.OID_CLASIF_OPOR));

  }
}
