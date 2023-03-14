package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondCompraImportacion;
import com.srn.erp.compras.da.DBCondCompraImportacion;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondCompraImportacion extends FactoryObjetoLogico { 

  public FactoryCondCompraImportacion() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondCompraImportacion condcompraimportacion = (CondCompraImportacion) objLog;
    condcompraimportacion.setOID(db.getInteger(DBCondCompraImportacion.OID_COND_CPRA_IMP));
    condcompraimportacion.setCodigo(db.getString(DBCondCompraImportacion.CODIGO));
    condcompraimportacion.setDescripcion(db.getString(DBCondCompraImportacion.DESCRIPCION));
    condcompraimportacion.setActivo(db.getBoolean(DBCondCompraImportacion.ACTIVO));
  }
}
