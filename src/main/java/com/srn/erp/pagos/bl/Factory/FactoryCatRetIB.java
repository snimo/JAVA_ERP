package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.CatRetIB;
import com.srn.erp.pagos.da.DBCatRetIB;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCatRetIB extends FactoryObjetoLogico {

  public FactoryCatRetIB() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CatRetIB catretib = (CatRetIB) objLog;
    catretib.setOID(db.getInteger(DBCatRetIB.OID_CAT_RET_IB));
    catretib.setCodigo(db.getString(DBCatRetIB.CODIGO));
    catretib.setDescripcion(db.getString(DBCatRetIB.DESCRIPCION));
    catretib.setActivo(db.getBoolean(DBCatRetIB.ACTIVO));

  }
}
