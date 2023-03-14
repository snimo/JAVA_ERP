package com.srn.erp.contabilidad.bl.Factory;

import com.srn.erp.contabilidad.bm.Subdiario;
import com.srn.erp.contabilidad.da.DBSubdiario;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactorySubdiario extends FactoryObjetoLogico { 

  public FactorySubdiario() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Subdiario subdiario = (Subdiario) objLog;
    subdiario.setOID(db.getInteger(DBSubdiario.OID_SUBDIARIO));
    subdiario.setCodigo(db.getString(DBSubdiario.CODIGO));
    subdiario.setDescripcion(db.getString(DBSubdiario.DESCRIPCION));
    subdiario.setActivo(db.getBoolean(DBSubdiario.ACTIVO));

  }
}
