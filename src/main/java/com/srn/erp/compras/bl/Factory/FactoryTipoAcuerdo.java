package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.compras.da.DBTipoAcuerdo;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoAcuerdo extends FactoryObjetoLogico { 

  public FactoryTipoAcuerdo() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoAcuerdo tipoacuerdo = (TipoAcuerdo) objLog;
    tipoacuerdo.setOID(db.getInteger(DBTipoAcuerdo.OID_TIPO_ACUERDO));
    tipoacuerdo.setCodigo(db.getString(DBTipoAcuerdo.CODIGO));
    tipoacuerdo.setDescripcion(db.getString(DBTipoAcuerdo.DESCRIPCION));
    tipoacuerdo.setTipo_acuerdo(db.getString(DBTipoAcuerdo.TIPO_ACUERDO));
    tipoacuerdo.setActivo(db.getBoolean(DBTipoAcuerdo.ACTIVO));

  }
}
