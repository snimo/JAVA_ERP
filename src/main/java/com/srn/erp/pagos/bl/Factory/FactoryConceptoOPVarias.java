package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.pagos.bm.ConceptoOPVarias;
import com.srn.erp.pagos.da.DBConceptoOPVarias;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConceptoOPVarias extends FactoryObjetoLogico { 

  public FactoryConceptoOPVarias() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConceptoOPVarias conceptoopvarias = (ConceptoOPVarias) objLog;
    conceptoopvarias.setOID(db.getInteger(DBConceptoOPVarias.OID_CONC_PV));
    conceptoopvarias.setCodigo(db.getString(DBConceptoOPVarias.CODIGO));
    conceptoopvarias.setDescripcion(db.getString(DBConceptoOPVarias.DESCRIPCION));
    conceptoopvarias.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBConceptoOPVarias.OID_AI),getSesion()));
    conceptoopvarias.setActivo(db.getBoolean(DBConceptoOPVarias.ACTIVO));
  }
}
