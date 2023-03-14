package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.FormaEntrega;
import com.srn.erp.ventas.da.DBFormaEntrega;

public class FactoryFormaEntrega extends FactoryObjetoLogico { 

  public FactoryFormaEntrega() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FormaEntrega formaentrega = (FormaEntrega) objLog;
    formaentrega.setOID(db.getInteger(DBFormaEntrega.OID_FORMA_ENTREGA));
    formaentrega.setCodigo(db.getString(DBFormaEntrega.CODIGO));
    formaentrega.setDescripcion(db.getString(DBFormaEntrega.DESCRIPCION));
    formaentrega.setActivo(db.getBoolean(DBFormaEntrega.ACTIVO));

  }
}
