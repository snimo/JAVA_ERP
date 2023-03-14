package com.srn.erp.contabilidad.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.contabilidad.bm.GrupoDeAtributos;
import com.srn.erp.contabilidad.da.DBGrupoDeAtributos;

public class FactoryGrupoDeAtributos extends FactoryObjetoLogico { 

  public FactoryGrupoDeAtributos() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoDeAtributos grupodeatributos = (GrupoDeAtributos) objLog;
    grupodeatributos.setOID(db.getInteger(DBGrupoDeAtributos.OID_GRUPOS_ATRI));
    grupodeatributos.setCodigo(db.getString(DBGrupoDeAtributos.CODIGO));
    grupodeatributos.setDescripcion(db.getString(DBGrupoDeAtributos.DESCRIPCION));
    grupodeatributos.setActivo(db.getBoolean(DBGrupoDeAtributos.ACTIVO));
  }
}
