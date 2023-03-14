package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AvisoCIPUsuario;
import com.srn.erp.cip.da.DBAvisoCIPUsuario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryAvisoCIPUsuario extends FactoryObjetoLogico { 

  public FactoryAvisoCIPUsuario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AvisoCIPUsuario avisocipusuario = (AvisoCIPUsuario) objLog;
    avisocipusuario.setOID(db.getInteger(DBAvisoCIPUsuario.OID_AVI_CAC_USU));
    avisocipusuario.setUsuario(Usuario.findByOidProxy(db.getInteger(DBAvisoCIPUsuario.OID_USUARIO),getSesion()));
    avisocipusuario.setOid_obj_neg(db.getInteger(DBAvisoCIPUsuario.OID_OBJ_NEG));
    avisocipusuario.setCircuito(db.getString(DBAvisoCIPUsuario.CIRCUITO));

  }
}
