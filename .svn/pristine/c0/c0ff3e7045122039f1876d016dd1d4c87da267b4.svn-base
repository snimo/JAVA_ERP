package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.PeligrosidadExcluido;
import com.srn.erp.excluidos.bm.SeguExcPeligrosidad;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.da.DBSeguExcPeligrosidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeguExcPeligrosidad extends FactoryObjetoLogico { 

  public FactorySeguExcPeligrosidad() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguExcPeligrosidad seguexcpeligrosidad = (SeguExcPeligrosidad) objLog;
    seguexcpeligrosidad.setOID(db.getInteger(DBSeguExcPeligrosidad.OID_SEGU_PELIGRO));
    seguexcpeligrosidad.setPerfil(SeguPerfilExcluido.findByOidProxy(db.getInteger(DBSeguExcPeligrosidad.OID_SEGU_PERFIL),getSesion()));
    seguexcpeligrosidad.setPeligrosidad(PeligrosidadExcluido.findByOidProxy(db.getInteger(DBSeguExcPeligrosidad.OID_PELIGROSIDAD),getSesion()));
    seguexcpeligrosidad.setVisualiza(db.getBoolean(DBSeguExcPeligrosidad.VISUALIZA));
    seguexcpeligrosidad.setAlta(db.getBoolean(DBSeguExcPeligrosidad.ALTA));
    seguexcpeligrosidad.setBaja(db.getBoolean(DBSeguExcPeligrosidad.BAJA));
    seguexcpeligrosidad.setModifica(db.getBoolean(DBSeguExcPeligrosidad.MODIFICA));
    seguexcpeligrosidad.setActivo(db.getBoolean(DBSeguExcPeligrosidad.ACTIVO));

  }
}
