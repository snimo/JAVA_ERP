package com.srn.erp.produccion.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.produccion.bm.Planta;
import com.srn.erp.produccion.da.DBPlanta;

public class FactoryPlanta extends FactoryObjetoLogico { 

  public FactoryPlanta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Planta planta = (Planta) objLog;
    planta.setOID(db.getInteger(DBPlanta.OID_PLANTA));
    planta.setCodigo(db.getString(DBPlanta.CODIGO));
    planta.setDescripcion(db.getString(DBPlanta.DESCRIPCION));
    planta.setActivo(db.getBoolean(DBPlanta.ACTIVO));

  }
}
