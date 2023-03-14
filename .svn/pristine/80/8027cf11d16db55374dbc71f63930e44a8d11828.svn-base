package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluGrupoCompe;
import com.srn.erp.reclutamiento.da.DBRecluGrupoCompe;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluGrupoCompe extends FactoryObjetoLogico { 

  public FactoryRecluGrupoCompe() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluGrupoCompe reclugrupocompe = (RecluGrupoCompe) objLog;
   reclugrupocompe.setOID(db.getInteger(DBRecluGrupoCompe.OID_GRUPO_COMPE));
    reclugrupocompe.setCodigo(db.getString(DBRecluGrupoCompe.CODIGO));
    reclugrupocompe.setDescripcion(db.getString(DBRecluGrupoCompe.DESCRIPCION));
    reclugrupocompe.setActivo(db.getBoolean(DBRecluGrupoCompe.ACTIVO));

  }
}
