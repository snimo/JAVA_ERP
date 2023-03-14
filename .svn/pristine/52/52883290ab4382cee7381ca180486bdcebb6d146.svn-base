package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.SeguExcTipoIndi;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.da.DBSeguExcTipoIndi;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeguExcTipoIndi extends FactoryObjetoLogico { 

  public FactorySeguExcTipoIndi() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguExcTipoIndi seguexctipoindi = (SeguExcTipoIndi) objLog;
    seguexctipoindi.setOID(db.getInteger(DBSeguExcTipoIndi.OID_SEGU_TIPO_IND));
    seguexctipoindi.setOid_segu_perfil(SeguPerfilExcluido.findByOidProxy(db.getInteger(DBSeguExcTipoIndi.OID_SEGU_PERFIL),getSesion()));
    seguexctipoindi.setTipo_individuo(db.getString(DBSeguExcTipoIndi.TIPO_INDIVIDUO));
    seguexctipoindi.setVisualiza(db.getBoolean(DBSeguExcTipoIndi.VISUALIZA));
    seguexctipoindi.setAlta(db.getBoolean(DBSeguExcTipoIndi.ALTA));
    seguexctipoindi.setBaja(db.getBoolean(DBSeguExcTipoIndi.BAJA));
    seguexctipoindi.setModifica(db.getBoolean(DBSeguExcTipoIndi.MODIFICA));
    seguexctipoindi.setActivo(db.getBoolean(DBSeguExcTipoIndi.ACTIVO));

  }
}
