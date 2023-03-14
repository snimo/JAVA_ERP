package com.srn.erp.rrhh.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.rrhh.bm.GradoLegajo;
import com.srn.erp.rrhh.da.DBGradoLegajo;

public class FactoryGradoLegajo extends FactoryObjetoLogico { 

  public FactoryGradoLegajo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GradoLegajo gradolegajo = (GradoLegajo) objLog;
    gradolegajo.setOID(db.getInteger(DBGradoLegajo.OID_GRADO_LEG));
    gradolegajo.setCodigo(db.getString(DBGradoLegajo.CODIGO));
    gradolegajo.setDescripcion(db.getString(DBGradoLegajo.DESCRIPCION));
    gradolegajo.setActivo(db.getBoolean(DBGradoLegajo.ACTIVO));
    gradolegajo.setCantJuegosA(db.getInteger(DBGradoLegajo.CANT_JUEGOS_A));
    gradolegajo.setCantJuegosB(db.getInteger(DBGradoLegajo.CANT_JUEGOS_B));
  }
}
