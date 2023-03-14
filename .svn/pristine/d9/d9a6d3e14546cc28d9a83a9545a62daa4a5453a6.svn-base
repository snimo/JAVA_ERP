package com.srn.erp.general.bl.Factory;

import com.srn.erp.general.bm.GrupoClasificadorEntidad;
import com.srn.erp.general.da.DBGrupoClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoClasificadorEntidad extends FactoryObjetoLogico {

  public FactoryGrupoClasificadorEntidad() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoClasificadorEntidad grupoclasificadorentidad = (GrupoClasificadorEntidad) objLog;
    grupoclasificadorentidad.setOID(db.getInteger(DBGrupoClasificadorEntidad.OID_GRUPO_CLASIF));
    grupoclasificadorentidad.setCodigo(db.getString(DBGrupoClasificadorEntidad.CODIGO));
    grupoclasificadorentidad.setDescripcion(db.getString(DBGrupoClasificadorEntidad.DESCRIPCION));
    grupoclasificadorentidad.setActivo(db.getBoolean(DBGrupoClasificadorEntidad.ACTIVO));
  }
}
