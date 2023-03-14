package com.srn.erp.produccion.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.produccion.bm.OperacionProductiva;
import com.srn.erp.produccion.da.DBOperacionProductiva;

public class FactoryOperacionProductiva extends FactoryObjetoLogico { 

  public FactoryOperacionProductiva() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OperacionProductiva operacionproductiva = (OperacionProductiva) objLog;
    operacionproductiva.setOID(db.getInteger(DBOperacionProductiva.OID_OPERACION));
    operacionproductiva.setCodigo(db.getString(DBOperacionProductiva.CODIGO));
    operacionproductiva.setDescripcion(db.getString(DBOperacionProductiva.DESCRIPCION));
    operacionproductiva.setActivo(db.getBoolean(DBOperacionProductiva.ACTIVO));

  }
}
