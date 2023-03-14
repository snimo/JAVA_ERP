package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.AdmEstadoExcluido;
import com.srn.erp.excluidos.bm.EstadoExcluido;
import com.srn.erp.excluidos.bm.NovedadExcluido;
import com.srn.erp.excluidos.da.DBAdmEstadoExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAdmEstadoExcluido extends FactoryObjetoLogico { 

  public FactoryAdmEstadoExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AdmEstadoExcluido admestadoexcluido = (AdmEstadoExcluido) objLog;
    admestadoexcluido.setOID(db.getInteger(DBAdmEstadoExcluido.OID_INDIVIDUO));
    admestadoexcluido.setEstado(EstadoExcluido.findByOidProxy(db.getInteger(DBAdmEstadoExcluido.OID_ESTADO),getSesion()));
    admestadoexcluido.setEstado_anterior(EstadoExcluido.findByOidProxy(db.getInteger(DBAdmEstadoExcluido.OID_ESTADO_ANT),getSesion()));
    admestadoexcluido.setFec_estado(db.getDate(DBAdmEstadoExcluido.FEC_ESTADO));
    admestadoexcluido.setFec_estado_ant(db.getDate(DBAdmEstadoExcluido.FEC_ESTADO_ANT));
    admestadoexcluido.setNovedad(NovedadExcluido.findByOidProxy(db.getInteger(DBAdmEstadoExcluido.OID_NOVEDAD),getSesion()));
  }
}
