package com.srn.erp.general.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.general.bm.Entidad;
import com.srn.erp.general.da.DBEntidad;

public class FactoryEntidad extends FactoryObjetoLogico { 

  public FactoryEntidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Entidad entidad = (Entidad) objLog;
    entidad.setOID(db.getInteger(DBEntidad.OID_ENTIDAD));
    entidad.setCodigo(db.getString(DBEntidad.CODIGO));
    entidad.setDescripcion(db.getString(DBEntidad.DESCRIPCION));
    entidad.setNombre_nickname(db.getString(DBEntidad.NOMBRE_NICKNAME));
    entidad.setActivo(db.getBoolean(DBEntidad.ACTIVO));
    entidad.setIsComprobante(db.getBoolean(DBEntidad.ES_COMPROBANTE));

  }
}
