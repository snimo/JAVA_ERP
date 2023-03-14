package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AvisoCIPGMaquina;
import com.srn.erp.cip.da.DBAvisoCIPGMaquina;
import com.srn.erp.mensajero.bm.GrupoMaquina;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAvisoCIPGMaquina extends FactoryObjetoLogico { 

  public FactoryAvisoCIPGMaquina() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AvisoCIPGMaquina avisocipgmaquina = (AvisoCIPGMaquina) objLog;
    avisocipgmaquina.setOID(db.getInteger(DBAvisoCIPGMaquina.OID_AVI_CAC_GMAQ));
    avisocipgmaquina.setGrupo_maquina(GrupoMaquina.findByOidProxy(db.getInteger(DBAvisoCIPGMaquina.OID_GRUPO_MAQUINA),getSesion()));
    avisocipgmaquina.setOid_obj_neg(db.getInteger(DBAvisoCIPGMaquina.OID_OBJ_NEG));
    avisocipgmaquina.setCircuito(db.getString(DBAvisoCIPGMaquina.CIRCUITO));

  }
}
