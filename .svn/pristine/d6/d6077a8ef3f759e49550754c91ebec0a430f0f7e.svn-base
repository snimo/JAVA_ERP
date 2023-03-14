package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluPostulante;
import com.srn.erp.reclutamiento.bm.RecluPuesto;
import com.srn.erp.reclutamiento.bm.RecluPuestoAplica;
import com.srn.erp.reclutamiento.da.DBRecluPuestoAplica;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluPuestoAplica extends FactoryObjetoLogico { 

  public FactoryRecluPuestoAplica() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluPuestoAplica reclupuestoaplica = (RecluPuestoAplica) objLog;
    reclupuestoaplica.setOID(db.getInteger(DBRecluPuestoAplica.OID_PUESTO_APLICA));
    reclupuestoaplica.setPostulante(RecluPostulante.findByOidProxy(db.getInteger(DBRecluPuestoAplica.OID_POSTULANTE),getSesion()));
    reclupuestoaplica.setPuesto(RecluPuesto.findByOidProxy(db.getInteger(DBRecluPuestoAplica.OID_PUESTO_BUSQUEDA),getSesion()));
    reclupuestoaplica.setActivo(db.getBoolean(DBRecluPuestoAplica.ACTIVO));

  }
}
