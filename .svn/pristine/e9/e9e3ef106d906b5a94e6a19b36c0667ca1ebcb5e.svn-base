package com.srn.erp.cip.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.cip.bm.GrupoCategAcceso;
import com.srn.erp.cip.da.DBGrupoCategAcceso;

public class FactoryGrupoCategAcceso extends FactoryObjetoLogico { 

  public FactoryGrupoCategAcceso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoCategAcceso grupocategacceso = (GrupoCategAcceso) objLog;
    grupocategacceso.setOID(db.getInteger(DBGrupoCategAcceso.OID_GRUPO_CATEG));
    grupocategacceso.setCodigo(db.getString(DBGrupoCategAcceso.CODIGO));
    grupocategacceso.setDescripcion(db.getString(DBGrupoCategAcceso.DESCRIPCION));
    grupocategacceso.setActivo(db.getBoolean(DBGrupoCategAcceso.ACTIVO));
    grupocategacceso.setOrden(db.getInteger(DBGrupoCategAcceso.ORDEN));
  }
}
