package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AlgoCacheoEstado;
import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.da.DBAlgoCacheoEstado;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAlgoCacheoEstado extends FactoryObjetoLogico { 

  public FactoryAlgoCacheoEstado() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AlgoCacheoEstado algocacheoestado = (AlgoCacheoEstado) objLog;
    algocacheoestado.setOID(db.getInteger(DBAlgoCacheoEstado.OID_ALGO_EST));
    algocacheoestado.setAlgoritmo_cacheo(AlgoritmoCacheo.findByOidProxy(db.getInteger(DBAlgoCacheoEstado.OID_ALGO_CACHEO),getSesion()));
    algocacheoestado.setEstado(EstadoCIP.findByOidProxy(db.getInteger(DBAlgoCacheoEstado.OID_ESTADO_CIP),getSesion()));
    algocacheoestado.setActivo(db.getBoolean(DBAlgoCacheoEstado.ACTIVO));

  }
}
