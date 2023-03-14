package com.srn.erp.contabilidad.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.contabilidad.bm.GrupoCuentas;
import com.srn.erp.contabilidad.da.DBGrupoCuentas;

public class FactoryGrupoCuentas extends FactoryObjetoLogico { 

  public FactoryGrupoCuentas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoCuentas grupocuentas = (GrupoCuentas) objLog;
    grupocuentas.setOID(db.getInteger(DBGrupoCuentas.OID_GRUPO_CTA));
    grupocuentas.setCodigo(db.getString(DBGrupoCuentas.CODIGO));
    grupocuentas.setDescripcion(db.getString(DBGrupoCuentas.DESCRIPCION));
    grupocuentas.setActivo(db.getBoolean(DBGrupoCuentas.ACTIVO));

  }
}
