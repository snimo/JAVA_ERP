package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.da.DBGrupoMaquina;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoMaquina extends FactoryObjetoLogico { 

  public FactoryGrupoMaquina() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoMaquina grupomaquina = (GrupoMaquina) objLog;
    grupomaquina.setOID(db.getInteger(DBGrupoMaquina.OID_GRUPO_MAQ));
    grupomaquina.setNombre(db.getString(DBGrupoMaquina.NOMBRE));
    grupomaquina.setActivo(db.getBoolean(DBGrupoMaquina.ACTIVO));

  }
}
