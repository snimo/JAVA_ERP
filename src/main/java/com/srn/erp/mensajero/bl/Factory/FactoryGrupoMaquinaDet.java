package com.srn.erp.mensajero.bl.Factory;

import com.srn.erp.mensajero.bm.GrupoMaquina;
import com.srn.erp.mensajero.bm.GrupoMaquinaDet;
import com.srn.erp.mensajero.bm.Maquina;
import com.srn.erp.mensajero.da.DBGrupoMaquinaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoMaquinaDet extends FactoryObjetoLogico { 

  public FactoryGrupoMaquinaDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoMaquinaDet grupomaquinadet = (GrupoMaquinaDet) objLog;
    grupomaquinadet.setOID(db.getInteger(DBGrupoMaquinaDet.OID_GRUPO_MAQ_DET));
    grupomaquinadet.setGrupo_maquina(GrupoMaquina.findByOidProxy(db.getInteger(DBGrupoMaquinaDet.OID_GRUPO_MAQ),getSesion()));
    grupomaquinadet.setMaquina(Maquina.findByOidProxy(db.getInteger(DBGrupoMaquinaDet.OID_MAQUINA),getSesion()));
    grupomaquinadet.setActivo(db.getBoolean(DBGrupoMaquinaDet.ACTIVO));

  }
}
