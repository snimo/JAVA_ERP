package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.SeguExcEstAlgunaVez;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.da.DBSeguExcEstAlgunaVez;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeguExcEstAlgunaVez extends FactoryObjetoLogico { 

  public FactorySeguExcEstAlgunaVez() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguExcEstAlgunaVez seguexcestalgunavez = (SeguExcEstAlgunaVez) objLog;
   seguexcestalgunavez.setOID(db.getInteger(DBSeguExcEstAlgunaVez.OID_SEGU_EXCLUIR));
    seguexcestalgunavez.setPerfil(SeguPerfilExcluido.findByOidProxy(db.getInteger(DBSeguExcEstAlgunaVez.OID_SEGU_PERFIL),getSesion()));
    seguexcestalgunavez.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBSeguExcEstAlgunaVez.OID_ESTADO),getSesion()));
    seguexcestalgunavez.setVisualiza(db.getBoolean(DBSeguExcEstAlgunaVez.VISUALIZA));
    seguexcestalgunavez.setAlta(db.getBoolean(DBSeguExcEstAlgunaVez.ALTA));
    seguexcestalgunavez.setBaja(db.getBoolean(DBSeguExcEstAlgunaVez.BAJA));
    seguexcestalgunavez.setModifica(db.getBoolean(DBSeguExcEstAlgunaVez.MODIFICA));
    seguexcestalgunavez.setActivo(db.getBoolean(DBSeguExcEstAlgunaVez.ACTIVO));

  }
}
