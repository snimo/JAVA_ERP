package com.srn.erp.legales.bl.Factory;


import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.legales.bm.FormaExtincion;
import com.srn.erp.legales.da.DBFormaExtincion;

public class FactoryFormaExtincion extends FactoryObjetoLogico { 

  public FactoryFormaExtincion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FormaExtincion formaextincion = (FormaExtincion) objLog;
    formaextincion.setOID(db.getInteger(DBFormaExtincion.OID_FORMA_EXTI));
    formaextincion.setCodigo(db.getString(DBFormaExtincion.CODIGO));
    formaextincion.setDescripcion(db.getString(DBFormaExtincion.DESCRIPCION));
    formaextincion.setActivo(db.getBoolean(DBFormaExtincion.ACTIVO));

  }
}
