package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.Categoria;
import com.srn.erp.ventas.da.DBCategoria;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategoria extends FactoryObjetoLogico {

  public FactoryCategoria() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Categoria categoria = (Categoria) objLog;
    categoria.setOID(db.getInteger(DBCategoria.OID_CATEGORIA));
    categoria.setCodigo(db.getString(DBCategoria.CODIGO));
    categoria.setDescripcion(db.getString(DBCategoria.DESCRIPCION));
    categoria.setActivo(db.getBoolean(DBCategoria.ACTIVO));
  }
}
