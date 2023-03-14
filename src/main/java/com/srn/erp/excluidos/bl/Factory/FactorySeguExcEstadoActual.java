package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.SeguExcEstadoActual;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.da.DBSeguExcEstadoActual;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeguExcEstadoActual extends FactoryObjetoLogico { 

  public FactorySeguExcEstadoActual() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguExcEstadoActual seguexcestadoactual = (SeguExcEstadoActual) objLog;
    seguexcestadoactual.setOID(db.getInteger(DBSeguExcEstadoActual.OID_SEGU_EST_ACT));
    seguexcestadoactual.setPerfil(SeguPerfilExcluido.findByOidProxy(db.getInteger(DBSeguExcEstadoActual.OID_SEGU_PERFIL),getSesion()));
    seguexcestadoactual.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBSeguExcEstadoActual.OID_ESTADO),getSesion()));
    seguexcestadoactual.setVisualiza(db.getBoolean(DBSeguExcEstadoActual.VISUALIZA));
    seguexcestadoactual.setAlta(db.getBoolean(DBSeguExcEstadoActual.ALTA));
    seguexcestadoactual.setBaja(db.getBoolean(DBSeguExcEstadoActual.BAJA));
    seguexcestadoactual.setModifica(db.getBoolean(DBSeguExcEstadoActual.MODIFICA));
    seguexcestadoactual.setActivo(db.getBoolean(DBSeguExcEstadoActual.ACTIVO));

  }
}
