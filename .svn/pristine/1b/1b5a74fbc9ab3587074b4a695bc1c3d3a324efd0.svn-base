package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.ConcFactProvImp;
import com.srn.erp.ctasAPagar.da.DBConcFactProvImp;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConcFactProvImp extends FactoryObjetoLogico {

  public FactoryConcFactProvImp() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConcFactProvImp concfactprovimp = (ConcFactProvImp) objLog;
    concfactprovimp.setOID(db.getInteger(DBConcFactProvImp.OID_CONC_PROV_IMP));
    concfactprovimp.setConcFactProv(ConcFactProv.findByOidProxy(db.getInteger(DBConcFactProvImp.OID_CONC_FACT_PROV),getSesion()));
    concfactprovimp.setConcImpuesto(ConceptoImpuesto.findByOidProxy(db.getInteger(DBConcFactProvImp.OID_CONC_IMPU),getSesion()));
    concfactprovimp.setCalculaEnFact(db.getBoolean(DBConcFactProvImp.CALCULA_EN_FACT));
    concfactprovimp.setCalculaEnOP(db.getBoolean(DBConcFactProvImp.CALCULA_EN_OP));
    concfactprovimp.setActivo(db.getBoolean(DBConcFactProvImp.ACTIVO));

  }
}
