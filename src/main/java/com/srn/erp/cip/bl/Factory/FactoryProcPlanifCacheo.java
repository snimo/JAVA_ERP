package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.ProcPlanifCacheo;
import com.srn.erp.cip.da.DBProcPlanifCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryProcPlanifCacheo extends FactoryObjetoLogico { 

  public FactoryProcPlanifCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProcPlanifCacheo procplanifcacheo = (ProcPlanifCacheo) objLog;
    procplanifcacheo.setOID(db.getInteger(DBProcPlanifCacheo.OID_PROC_PLANIF));
    procplanifcacheo.setFec_proceso(db.getDate(DBProcPlanifCacheo.FEC_PROCESO));
    procplanifcacheo.setTipo(db.getString(DBProcPlanifCacheo.TIPO));
    procplanifcacheo.setUsuario(Usuario.findByOidProxy(db.getInteger(DBProcPlanifCacheo.OID_USU),getSesion()));
    procplanifcacheo.setFec_desde(db.getDate(DBProcPlanifCacheo.FEC_DESDE));
    procplanifcacheo.setFec_hasta(db.getDate(DBProcPlanifCacheo.FEC_HASTA));
    procplanifcacheo.setActivo(db.getBoolean(DBProcPlanifCacheo.ACTIVO));

  }
}
