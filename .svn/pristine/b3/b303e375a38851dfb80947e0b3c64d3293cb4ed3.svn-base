package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.CatRetIVA;
import com.srn.erp.pagos.da.DBCatRetIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCatRetIVA extends FactoryObjetoLogico {

  public FactoryCatRetIVA() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CatRetIVA catretiva = (CatRetIVA) objLog;
    catretiva.setOID(db.getInteger(DBCatRetIVA.OID_CAT_RET_IVA));
    catretiva.setCodigo(db.getString(DBCatRetIVA.CODIGO));
    catretiva.setDescripcion(db.getString(DBCatRetIVA.DESCRIPCION));
    catretiva.setActivo(db.getBoolean(DBCatRetIVA.ACTIVO));

  }
}
