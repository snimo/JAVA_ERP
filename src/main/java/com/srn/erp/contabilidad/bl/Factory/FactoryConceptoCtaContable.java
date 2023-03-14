package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.ConceptoCtaContable;
import com.srn.erp.contabilidad.da.DBConceptoCtaContable;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConceptoCtaContable extends FactoryObjetoLogico { 

  public FactoryConceptoCtaContable() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConceptoCtaContable conceptoctacontable = (ConceptoCtaContable) objLog;
    conceptoctacontable.setOID(db.getInteger(DBConceptoCtaContable.OID_CONC_CTCA));
    conceptoctacontable.setCodigo(db.getString(DBConceptoCtaContable.CODIGO));
    conceptoctacontable.setDescripcion(db.getString(DBConceptoCtaContable.DESCRIPCION));
    conceptoctacontable.setNickname(db.getString(DBConceptoCtaContable.NICKNAME));
    conceptoctacontable.setActivo(db.getBoolean(DBConceptoCtaContable.ACTIVO));
  }
}
