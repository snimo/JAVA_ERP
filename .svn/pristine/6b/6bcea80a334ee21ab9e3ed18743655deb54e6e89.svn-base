package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.MotVisFalRRHH;
import com.srn.erp.rrhh.da.DBMotVisFalRRHH;

public class FactoryMotVisFalRRHH extends FactoryObjetoLogico { 

  public FactoryMotVisFalRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotVisFalRRHH motvisfalrrhh = (MotVisFalRRHH) objLog;
    motvisfalrrhh.setOID(db.getInteger(DBMotVisFalRRHH.OID_MOT_VIS_FALL));
    motvisfalrrhh.setCodigo(db.getString(DBMotVisFalRRHH.CODIGO));
    motvisfalrrhh.setDescripcion(db.getString(DBMotVisFalRRHH.DESCRIPCION));
    motvisfalrrhh.setActivo(db.getBoolean(DBMotVisFalRRHH.ACTIVO));

  }
}
