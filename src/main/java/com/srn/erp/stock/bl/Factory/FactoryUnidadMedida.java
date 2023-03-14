package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBUnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUnidadMedida extends FactoryObjetoLogico {

  public FactoryUnidadMedida() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UnidadMedida unidadmedida = (UnidadMedida) objLog;
    unidadmedida.setOID(db.getInteger(DBUnidadMedida.OID_UM));
    unidadmedida.setCodigo(db.getString(DBUnidadMedida.CODIGO));
    unidadmedida.setDescripcion(db.getString(DBUnidadMedida.DESCRIPCION));
    unidadmedida.setActivo(db.getBoolean(DBUnidadMedida.ACTIVO));
    unidadmedida.setLabelImpresion(db.getString(DBUnidadMedida.LABEL_IMPRESION));
  }
}
