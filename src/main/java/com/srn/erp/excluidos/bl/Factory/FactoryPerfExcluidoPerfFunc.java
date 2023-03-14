package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.PerfExcluidoPerfFunc;
import com.srn.erp.excluidos.bm.SeguPerfilExcluido;
import com.srn.erp.excluidos.da.DBPerfExcluidoPerfFunc;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.PerfilFuncional;
import framework.request.bl.Utils.BaseException;

public class FactoryPerfExcluidoPerfFunc extends FactoryObjetoLogico { 

  public FactoryPerfExcluidoPerfFunc() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PerfExcluidoPerfFunc perfexcluidoperffunc = (PerfExcluidoPerfFunc) objLog;
    perfexcluidoperffunc.setOID(db.getInteger(DBPerfExcluidoPerfFunc.OID_EXC_PERF_FUNC));
    perfexcluidoperffunc.setPerfilfuncional(PerfilFuncional.findByOidProxy(db.getInteger(DBPerfExcluidoPerfFunc.OID_PERF_FUNC),getSesion()));
    perfexcluidoperffunc.setSeguridadperfil(SeguPerfilExcluido.findByOidProxy(db.getInteger(DBPerfExcluidoPerfFunc.OID_SEGU_PERFIL),getSesion()));
    perfexcluidoperffunc.setActivo(db.getBoolean(DBPerfExcluidoPerfFunc.ACTIVO));

  }
}
