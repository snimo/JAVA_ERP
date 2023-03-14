package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.CatRetGan;
import com.srn.erp.pagos.da.DBCatRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCatRetGan extends FactoryObjetoLogico {

  public FactoryCatRetGan() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CatRetGan catretgan = (CatRetGan) objLog;
    catretgan.setOID(db.getInteger(DBCatRetGan.OID_CAT_RET_GAN));
    catretgan.setCodigo(db.getString(DBCatRetGan.CODIGO));
    catretgan.setDescripcion(db.getString(DBCatRetGan.DESCRIPCION));
    catretgan.setActivo(db.getBoolean(DBCatRetGan.ACTIVO));
  }
}
