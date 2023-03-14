package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.TipoNariz;
import com.srn.erp.excluidos.da.DBTipoNariz;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoNariz extends FactoryObjetoLogico { 

  public FactoryTipoNariz() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoNariz tiponariz = (TipoNariz) objLog;
    tiponariz.setOID(db.getInteger(DBTipoNariz.OID_TIPO_NARIZ));
    tiponariz.setCodigo(db.getString(DBTipoNariz.CODIGO));
    tiponariz.setDescripcion(db.getString(DBTipoNariz.DESCRIPCION));
    tiponariz.setActivo(db.getBoolean(DBTipoNariz.ACTIVO));

  }
}
