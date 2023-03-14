package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.FamiliarRRHH;
import com.srn.erp.rrhh.da.DBFamiliarRRHH;

public class FactoryFamiliarRRHH extends FactoryObjetoLogico { 

  public FactoryFamiliarRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FamiliarRRHH familiarrrhh = (FamiliarRRHH) objLog;
    familiarrrhh.setOID(db.getInteger(DBFamiliarRRHH.OID_FAMILIAR));
    familiarrrhh.setCodigo(db.getString(DBFamiliarRRHH.CODIGO));
    familiarrrhh.setDescripcion(db.getString(DBFamiliarRRHH.DESCRIPCION));
    familiarrrhh.setActivo(db.getBoolean(DBFamiliarRRHH.ACTIVO));

  }
}
