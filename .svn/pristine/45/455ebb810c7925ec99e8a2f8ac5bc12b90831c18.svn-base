package com.srn.erp.rrhh.bl.Factory;

import com.srn.erp.rrhh.bm.ClaseSindicato;
import com.srn.erp.rrhh.da.DBClaseSindicato;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryClaseSindicato extends FactoryObjetoLogico { 

  public FactoryClaseSindicato() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ClaseSindicato clasesindicato = (ClaseSindicato) objLog;
    clasesindicato.setOID(db.getInteger(DBClaseSindicato.OID));
    clasesindicato.setCodigo(db.getString(DBClaseSindicato.CODIGO));
    clasesindicato.setDescripcion(db.getString(DBClaseSindicato.DESCRIPCION));
    clasesindicato.setActivo(db.getBoolean(DBClaseSindicato.ACTIVO));

  }
}
