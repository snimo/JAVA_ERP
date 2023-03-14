package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.TipoProducto;
import com.srn.erp.stock.da.DBTipoProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoProducto extends FactoryObjetoLogico {

  public FactoryTipoProducto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoProducto tipoproducto = (TipoProducto) objLog;
    tipoproducto.setOID(db.getInteger(DBTipoProducto.OID_TIPO_PROD));
    tipoproducto.setCodigo(db.getString(DBTipoProducto.CODIGO));
    tipoproducto.setDescripcion(db.getString(DBTipoProducto.DESCRIPCION));
    tipoproducto.setActivo(db.getBoolean(DBTipoProducto.ACTIVO));
    tipoproducto.setComportamiento(db.getString(DBTipoProducto.COMPORTAMIENTO));
  }

}
