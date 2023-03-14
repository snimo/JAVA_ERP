package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.MotivoPago;
import com.srn.erp.pagos.da.DBMotivoPago;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoPago extends FactoryObjetoLogico {

  public FactoryMotivoPago() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoPago motivopago = (MotivoPago) objLog;
    motivopago.setOID(db.getInteger(DBMotivoPago.OID_MOTIVO_PAGO));
    motivopago.setCodigo(db.getString(DBMotivoPago.CODIGO));
    motivopago.setDescripcion(db.getString(DBMotivoPago.DESCRIPCION));
    motivopago.setCompo(db.getString(DBMotivoPago.COMPO));
    motivopago.setActivo(db.getBoolean(DBMotivoPago.ACTIVO));

  }
}
