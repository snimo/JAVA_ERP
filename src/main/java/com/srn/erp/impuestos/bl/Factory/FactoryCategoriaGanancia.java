package com.srn.erp.impuestos.bl.Factory;

import com.srn.erp.impuestos.bm.CategoriaGanancia;
import com.srn.erp.impuestos.da.DBCategoriaGanancia;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCategoriaGanancia extends FactoryObjetoLogico {

  public FactoryCategoriaGanancia() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CategoriaGanancia categoriaganancia = (CategoriaGanancia) objLog;
    categoriaganancia.setOID(db.getInteger(DBCategoriaGanancia.OID_CAT_GAN));
    categoriaganancia.setCodigo(db.getString(DBCategoriaGanancia.CODIGO));
    categoriaganancia.setDescripcion(db.getString(DBCategoriaGanancia.DESCRIPCION));
    categoriaganancia.setCompo(db.getString(DBCategoriaGanancia.COMPO_CAT_GAN));
    categoriaganancia.setActivo(db.getBoolean(DBCategoriaGanancia.ACTIVO));
  }
}
