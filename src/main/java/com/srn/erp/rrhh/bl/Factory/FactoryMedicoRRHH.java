package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.MedicoRRHH;
import com.srn.erp.rrhh.da.DBMedicoRRHH;

public class FactoryMedicoRRHH extends FactoryObjetoLogico { 

  public FactoryMedicoRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MedicoRRHH medicorrhh = (MedicoRRHH) objLog;
    medicorrhh.setOID(db.getInteger(DBMedicoRRHH.OID_MEDICO));
    medicorrhh.setCodigo(db.getString(DBMedicoRRHH.CODIGO));
    medicorrhh.setDescripcion(db.getString(DBMedicoRRHH.DESCRIPCION));
    medicorrhh.setActivo(db.getBoolean(DBMedicoRRHH.ACTIVO));

  }
}
