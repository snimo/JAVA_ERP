package com.srn.erp.reclutamiento.bl.Factory;

import com.srn.erp.reclutamiento.bm.RecluConceptoProceso;
import com.srn.erp.reclutamiento.bm.RecluProceso;
import com.srn.erp.reclutamiento.da.DBRecluConceptoProceso;
import com.srn.erp.reclutamiento.da.DBRecluProceso;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecluConceptoProceso extends FactoryObjetoLogico { 

  public FactoryRecluConceptoProceso() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecluConceptoProceso recluconceptoproceso = (RecluConceptoProceso) objLog;
    recluconceptoproceso.setOID(db.getInteger(DBRecluConceptoProceso.OID_CONC_PROCESO));
    recluconceptoproceso.setProceso(RecluProceso.findByOidProxy(db.getInteger(DBRecluConceptoProceso.OID_PROCESO),getSesion()));
    recluconceptoproceso.setDescripcion(db.getString(DBRecluConceptoProceso.DESCRIPCION));
    recluconceptoproceso.setCosto(db.getDouble(DBRecluConceptoProceso.COSTO));
    recluconceptoproceso.setActivo(db.getBoolean(DBRecluConceptoProceso.ACTIVO));
    recluconceptoproceso.setAltaEnBusqueda(db.getBoolean(DBRecluProceso.ALTA_EN_BUSQUEDA));

  }
}
