package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.EsqCuentaConcFactProv;
import com.srn.erp.ctasAPagar.da.DBEsqCuentaConcFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryEsqCuentaConcFactProv extends FactoryObjetoLogico { 

  public FactoryEsqCuentaConcFactProv() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    EsqCuentaConcFactProv esqcuentaconcfactprov = (EsqCuentaConcFactProv) objLog;
    esqcuentaconcfactprov.setOID(db.getInteger(DBEsqCuentaConcFactProv.OID_CTA_CONC_FP));
    esqcuentaconcfactprov.setConc_fact_prov(ConcFactProv.findByOidProxy(db.getInteger(DBEsqCuentaConcFactProv.OID_CONC_FACT_PROV),getSesion()));
    esqcuentaconcfactprov.setCuenta_contable(Cuenta.findByOidProxy(db.getInteger(DBEsqCuentaConcFactProv.OID_ANA_CON),getSesion()));
  }
}
