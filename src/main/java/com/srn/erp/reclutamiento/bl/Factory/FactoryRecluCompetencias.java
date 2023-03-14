package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluCompetencias;
import com.srn.erp.reclutamiento.bm.RecluGrupoCompe;
import com.srn.erp.reclutamiento.da.DBRecluCompetencias;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluCompetencias extends FactoryObjetoLogico { 

  public FactoryRecluCompetencias() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluCompetencias reclucompetencias = (RecluCompetencias) objLog;
    reclucompetencias.setOID(db.getInteger(DBRecluCompetencias.OID_COMPETENCIA));
    reclucompetencias.setCodigo(db.getString(DBRecluCompetencias.CODIGO));
    reclucompetencias.setDescripcion(db.getString(DBRecluCompetencias.DESCRIPCION));
    reclucompetencias.setOid_grupo_compe(RecluGrupoCompe.findByOidProxy(db.getInteger(DBRecluCompetencias.OID_GRUPO_COMPE),getSesion()));
    reclucompetencias.setActivo(db.getBoolean(DBRecluCompetencias.ACTIVO));

  }
}
