package com.srn.erp.ctasAPagar.bl.Factory;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.da.DBConcFactProv;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConcFactProv extends FactoryObjetoLogico {

  public FactoryConcFactProv() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConcFactProv concfactprov = (ConcFactProv) objLog;
    concfactprov.setOID(db.getInteger(DBConcFactProv.OID_CONC_FACT_PROV));
    concfactprov.setCodigo(db.getString(DBConcFactProv.CODIGO));
    concfactprov.setDescripcion(db.getString(DBConcFactProv.DESCRIPCION));
    concfactprov.setActivo(db.getBoolean(DBConcFactProv.ACTIVO));
    concfactprov.setOrden(db.getInteger(DBConcFactProv.ORDEN));
    concfactprov.setEsRendicionFondoFijo(db.getBoolean(DBConcFactProv.ES_REND_FF));
    concfactprov.setAddCtasRendFF(db.getBoolean(DBConcFactProv.ADD_CTAS_REND_FF));
  }
}
