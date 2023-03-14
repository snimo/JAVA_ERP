package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.AlgoCacheoClasif;
import com.srn.erp.cip.bm.AlgoritmoCacheo;
import com.srn.erp.cip.da.DBAlgoCacheoClasif;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAlgoCacheoClasif extends FactoryObjetoLogico { 

  public FactoryAlgoCacheoClasif() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AlgoCacheoClasif algocacheoclasif = (AlgoCacheoClasif) objLog;
    algocacheoclasif.setOID(db.getInteger(DBAlgoCacheoClasif.OID_CACHE_CLASIF));
    algocacheoclasif.setAlgoritmo_cacheo(AlgoritmoCacheo.findByOidProxy(db.getInteger(DBAlgoCacheoClasif.OID_ALGO_CACHEO),getSesion()));
    algocacheoclasif.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBAlgoCacheoClasif.OID_CLASIFICADOR),getSesion()));
    algocacheoclasif.setValor_clasif(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBAlgoCacheoClasif.OID_VAL_CLASIF),getSesion()));
    algocacheoclasif.setInc_exc(db.getString(DBAlgoCacheoClasif.INC_EXC));
    algocacheoclasif.setActivo(db.getBoolean(DBAlgoCacheoClasif.ACTIVO));

  }
}
