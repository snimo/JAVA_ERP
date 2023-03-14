package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.PrestMedidoRRHH;
import com.srn.erp.rrhh.da.DBPrestMedidoRRHH;

public class FactoryPrestMedidoRRHH extends FactoryObjetoLogico { 

  public FactoryPrestMedidoRRHH() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PrestMedidoRRHH prestmedidorrhh = (PrestMedidoRRHH) objLog;
    prestmedidorrhh.setOID(db.getInteger(DBPrestMedidoRRHH.OID_PREST_MED));
    prestmedidorrhh.setCodigo(db.getString(DBPrestMedidoRRHH.CODIGO));
    prestmedidorrhh.setDescripcion(db.getString(DBPrestMedidoRRHH.DESCRIPCION));
    prestmedidorrhh.setActivo(db.getBoolean(DBPrestMedidoRRHH.ACTIVO));

  }
}
