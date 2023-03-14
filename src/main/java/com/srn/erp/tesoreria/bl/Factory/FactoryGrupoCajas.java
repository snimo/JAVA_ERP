package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.tesoreria.bm.GrupoCajas;
import com.srn.erp.tesoreria.da.DBGrupoCajas;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoCajas extends FactoryObjetoLogico { 

  public FactoryGrupoCajas() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoCajas grupocajas = (GrupoCajas) objLog;
    grupocajas.setOID(db.getInteger(DBGrupoCajas.OID_GRUPO_CAJA));
    grupocajas.setCodigo(db.getString(DBGrupoCajas.CODIGO));
    grupocajas.setDescripcion(db.getString(DBGrupoCajas.DESCRIPCION));
    grupocajas.setActivo(db.getBoolean(DBGrupoCajas.ACTIVO));

  }
}
