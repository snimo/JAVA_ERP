package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.EnfermedadRRHH;
import com.srn.erp.rrhh.da.DBEnfermedadRRHH;

public class FactoryEnfermedadRRHH extends FactoryObjetoLogico { 

  public FactoryEnfermedadRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EnfermedadRRHH enfermedadrrhh = (EnfermedadRRHH) objLog;
    enfermedadrrhh.setOID(db.getInteger(DBEnfermedadRRHH.OID_ENFERMEDAD));
    enfermedadrrhh.setCodigo(db.getString(DBEnfermedadRRHH.CODIGO));
    enfermedadrrhh.setDescripcion(db.getString(DBEnfermedadRRHH.DESCRIPCION));
    enfermedadrrhh.setActivo(db.getBoolean(DBEnfermedadRRHH.ACTIVO));

  }
}
