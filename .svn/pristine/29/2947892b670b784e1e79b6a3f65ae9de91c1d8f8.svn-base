package com.srn.erp.general.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.general.bm.Nacionalidad;
import com.srn.erp.general.da.DBNacionalidad;

public class FactoryNacionalidad extends FactoryObjetoLogico { 

  public FactoryNacionalidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Nacionalidad nacionalidad = (Nacionalidad) objLog;
    nacionalidad.setOID(db.getInteger(DBNacionalidad.OID_NACIONALIDAD));
    nacionalidad.setCodigo(db.getString(DBNacionalidad.CODIGO));
    nacionalidad.setDescripcion(db.getString(DBNacionalidad.DESCRIPCION));
    nacionalidad.setActivo(db.getBoolean(DBNacionalidad.ACTIVO));

  }
}
