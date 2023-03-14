package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.Transporte;
import com.srn.erp.stock.da.DBTransporte;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTransporte extends FactoryObjetoLogico {

  public FactoryTransporte() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    Transporte transporte = (Transporte) objLog;
    transporte.setOID(db.getInteger(DBTransporte.OID_TRANSPORTE));
    transporte.setCodigo(db.getString(DBTransporte.CODIGO));
    transporte.setDescripcion(db.getString(DBTransporte.DESCRIPCION));
    transporte.setActivo(db.getBoolean(DBTransporte.ACTIVO));
  }
}
