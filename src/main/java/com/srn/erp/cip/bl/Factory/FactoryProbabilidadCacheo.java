package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.bm.ProbabilidadCacheo;
import com.srn.erp.cip.bm.Rota;
import com.srn.erp.cip.da.DBProbabilidadCacheo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProbabilidadCacheo extends FactoryObjetoLogico { 

  public FactoryProbabilidadCacheo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProbabilidadCacheo probabilidadcacheo = (ProbabilidadCacheo) objLog;
    probabilidadcacheo.setOID(db.getInteger(DBProbabilidadCacheo.OID_PROB_CACHEO));
    probabilidadcacheo.setAlgoritmo_cacheo(AlgoritmoCacheo.findByOidProxy(db.getInteger(DBProbabilidadCacheo.OID_ALGO_CACHEO),getSesion()));
    probabilidadcacheo.setRota(Rota.findByOidProxy(db.getInteger(DBProbabilidadCacheo.OID_ROTA),getSesion()));
    probabilidadcacheo.setPorc_ent(db.getDouble(DBProbabilidadCacheo.PORC_ENT));
    probabilidadcacheo.setProb_cacheo_ent(db.getDouble(DBProbabilidadCacheo.PROB_CACH_ENT));
    probabilidadcacheo.setPorc_sal(db.getDouble(DBProbabilidadCacheo.PORC_SAL));
    probabilidadcacheo.setProb_cacheo_sal(db.getDouble(DBProbabilidadCacheo.PROB_CACH_SAL));
    probabilidadcacheo.setActivo(db.getBoolean(DBProbabilidadCacheo.ACTIVO));

  }
}
