package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.CondPagoCheque;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.da.DBCondPagoCheque;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondPagoCheque extends FactoryObjetoLogico {

  public FactoryCondPagoCheque() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondPagoCheque condpagocheque = (CondPagoCheque) objLog;
    condpagocheque.setOID(db.getInteger(DBCondPagoCheque.OID_CP_CHEQUE));
    condpagocheque.setCondicion_pago(CondicionPago.findByOidProxy(db.getInteger(DBCondPagoCheque.OID_COND_PAGO),getSesion()));
    condpagocheque.setDia_desde(db.getInteger(DBCondPagoCheque.DIA_DESDE));
    condpagocheque.setDia_hasta(db.getInteger(DBCondPagoCheque.DIA_HASTA));
    condpagocheque.setPorc_dto(db.getPorcentaje(DBCondPagoCheque.PORC_DTO));
    condpagocheque.setPorc_recar(db.getPorcentaje(DBCondPagoCheque.PORC_RECAR));
  }
}
