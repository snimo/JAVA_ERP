package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.da.DBCategoriaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategoriaIVA extends FactoryObjetoLogico {

  public FactoryCategoriaIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategoriaIVA categoriaiva = (CategoriaIVA) objLog;
    categoriaiva.setOID(db.getInteger(DBCategoriaIVA.OID_CAT_IVA));
    categoriaiva.setCodigo(db.getString(DBCategoriaIVA.CODIGO));
    categoriaiva.setDescripcion(db.getString(DBCategoriaIVA.DESCRIPCION));
    categoriaiva.setComportamiento(db.getString(DBCategoriaIVA.COMPO_CAT_IVA));
    categoriaiva.setActivo(db.getBoolean(DBCategoriaIVA.ACTIVO));
    categoriaiva.setCalculaIVA(db.getBoolean(DBCategoriaIVA.CALC_IVA));
    categoriaiva.setDiscriminaIVA(db.getBoolean(DBCategoriaIVA.DISC_IVA));
    categoriaiva.setCalculaPercIVA(db.getBoolean(DBCategoriaIVA.CALC_PERC_IVA));
    categoriaiva.setConcImpuestoIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCategoriaIVA.OID_CONC_IMP_PIVA),getSesion()));
    categoriaiva.setAgentePercIBBsAs(db.getBoolean(DBCategoriaIVA.ES_AGE_PERC_IB_BA).booleanValue());
    categoriaiva.setAgentePercIBCapFed(db.getBoolean(DBCategoriaIVA.ES_AGE_PERC_IB_CF).booleanValue());
    
  }
}
