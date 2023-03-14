package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.general.bm.UnidadOrganizativa;
import com.srn.erp.pagos.bm.ConceptoOPVarias;
import com.srn.erp.pagos.bm.ConceptoOPVariasHab;
import com.srn.erp.pagos.da.DBConceptoOPVariasHab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConceptoOPVariasHab extends FactoryObjetoLogico { 

  public FactoryConceptoOPVariasHab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConceptoOPVariasHab conceptoopvariashab = (ConceptoOPVariasHab) objLog;
    conceptoopvariashab.setOID(db.getInteger(DBConceptoOPVariasHab.OID_CONC_PV_HAB));
    conceptoopvariashab.setConcepto_pv(ConceptoOPVarias.findByOidProxy(db.getInteger(DBConceptoOPVariasHab.OID_CONC_PV),getSesion()));
    conceptoopvariashab.setUnidad_organizativa(UnidadOrganizativa.findByOidProxy(db.getInteger(DBConceptoOPVariasHab.OID_UNI_ORG),getSesion()));
    conceptoopvariashab.setActivo(db.getBoolean(DBConceptoOPVariasHab.ACTIVO));

  }
}
