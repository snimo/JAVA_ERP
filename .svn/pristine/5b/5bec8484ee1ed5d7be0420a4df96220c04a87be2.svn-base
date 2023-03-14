package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.GrupoTarjeta;
import com.srn.erp.cip.da.DBGrupoTarjeta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoTarjeta extends FactoryObjetoLogico { 

  public FactoryGrupoTarjeta() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoTarjeta grupotarjeta = (GrupoTarjeta) objLog;
    grupotarjeta.setOID(db.getInteger(DBGrupoTarjeta.OID_GRUPO_TAR));
    grupotarjeta.setCodigo(db.getString(DBGrupoTarjeta.CODIGO));
    grupotarjeta.setDescripcion(db.getString(DBGrupoTarjeta.DESCRIPCION));
    grupotarjeta.setActivo(db.getBoolean(DBGrupoTarjeta.ACTIVO));

  }
}
