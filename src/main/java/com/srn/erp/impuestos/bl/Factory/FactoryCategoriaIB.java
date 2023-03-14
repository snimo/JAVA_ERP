package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.da.DBCategoriaIB;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategoriaIB extends FactoryObjetoLogico {

  public FactoryCategoriaIB() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategoriaIB categoriaib = (CategoriaIB) objLog;
    categoriaib.setOID(db.getInteger(DBCategoriaIB.OID_CAT_IB));
    categoriaib.setCodigo(db.getString(DBCategoriaIB.CODIGO));
    categoriaib.setDescripcion(db.getString(DBCategoriaIB.DESCRIPCION));
    categoriaib.setComportamiento(db.getString(DBCategoriaIB.COMPO_CAT_IB));
    categoriaib.setActivo(db.getBoolean(DBCategoriaIB.ACTIVO));
    categoriaib.setCalcPercIBBsAs(db.getBoolean(DBCategoriaIB.CALC_PERC_IB_BA).booleanValue());
    categoriaib.setCalcPercIBCapFed(db.getBoolean(DBCategoriaIB.CALC_PERC_IB_CF).booleanValue());

  }
}
