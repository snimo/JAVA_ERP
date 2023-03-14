package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AvisoCIPGUsuario;
import com.srn.erp.cip.da.DBAvisoCIPGUsuario;
import com.srn.erp.mensajero.bm.GrupoUsuMens;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAvisoCIPGUsuario extends FactoryObjetoLogico { 

  public FactoryAvisoCIPGUsuario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AvisoCIPGUsuario avisocipgusuario = (AvisoCIPGUsuario) objLog;
    avisocipgusuario.setOID(db.getInteger(DBAvisoCIPGUsuario.OID_AVI_CAC_GUSU));
    avisocipgusuario.setGrupo_usuario(GrupoUsuMens.findByOidProxy(db.getInteger(DBAvisoCIPGUsuario.OID_GRUPO_USU),getSesion()));
    avisocipgusuario.setOid_obj_neg(db.getInteger(DBAvisoCIPGUsuario.OID_OBJ_NEG));
    avisocipgusuario.setCircuito(db.getString(DBAvisoCIPGUsuario.CIRCUITO));

  }
}
