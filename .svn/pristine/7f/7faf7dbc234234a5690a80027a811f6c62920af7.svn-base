package com.srn.erp.excluidos.bl.Factory;

import com.srn.erp.excluidos.bm.ColorExcluido;
import com.srn.erp.excluidos.da.DBColorExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryColorExcluido extends FactoryObjetoLogico { 

  public FactoryColorExcluido() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ColorExcluido colorexcluido = (ColorExcluido) objLog;
    colorexcluido.setOID(db.getInteger(DBColorExcluido.OID_COLOR));
    colorexcluido.setCodigo(db.getString(DBColorExcluido.CODIGO));
    colorexcluido.setDescripcion(db.getString(DBColorExcluido.DESCRIPCION));
    colorexcluido.setActivo(db.getBoolean(DBColorExcluido.ACTIVO));

  }
}
