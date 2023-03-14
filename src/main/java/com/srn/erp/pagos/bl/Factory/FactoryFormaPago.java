package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.FormaPago;
import com.srn.erp.pagos.da.DBFormaPago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFormaPago extends FactoryObjetoLogico {

  public FactoryFormaPago() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FormaPago formapago = (FormaPago) objLog;
    formapago.setOID(db.getInteger(DBFormaPago.OID_FORMA_PAGO));
    formapago.setCodigo(db.getString(DBFormaPago.CODIGO));
    formapago.setDescripcion(db.getString(DBFormaPago.DESCRIPCION));
    formapago.setActivo(db.getBoolean(DBFormaPago.ACTIVO));
  }
}
