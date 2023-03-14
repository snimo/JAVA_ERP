package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.PredioExcluido;
import com.srn.erp.excluidos.bm.SeguExcPredio;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.da.DBSeguExcPredio;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySeguExcPredio extends FactoryObjetoLogico { 

  public FactorySeguExcPredio() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    SeguExcPredio seguexcpredio = (SeguExcPredio) objLog;
    seguexcpredio.setOID(db.getInteger(DBSeguExcPredio.OID_SEGU_PREDIO));
    seguexcpredio.setPerfil(SeguPerfilExcluido.findByOidProxy(db.getInteger(DBSeguExcPredio.OID_SEGU_PERFIL),getSesion()));
    seguexcpredio.setPredio(PredioExcluido.findByOidProxy(db.getInteger(DBSeguExcPredio.OID_PREDIO),getSesion()));
    seguexcpredio.setVisualiza(db.getBoolean(DBSeguExcPredio.VISUALIZA));
    seguexcpredio.setAlta(db.getBoolean(DBSeguExcPredio.ALTA));
    seguexcpredio.setBaja(db.getBoolean(DBSeguExcPredio.BAJA));
    seguexcpredio.setModifica(db.getBoolean(DBSeguExcPredio.MODIFICA));
    seguexcpredio.setActivo(db.getBoolean(DBSeguExcPredio.ACTIVO));

  }
}
