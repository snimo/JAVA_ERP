package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.CondPagoCuotas;
import com.srn.erp.ventas.bm.CondicionPago;
import com.srn.erp.ventas.da.DBCondPagoCuotas;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondPagoCuotas extends FactoryObjetoLogico {

  public FactoryCondPagoCuotas() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondPagoCuotas condpagocuotas = (CondPagoCuotas) objLog;
    condpagocuotas.setOID(db.getInteger(DBCondPagoCuotas.OID_CP_CUOTAS));
    condpagocuotas.setCondicion_pago(CondicionPago.findByOidProxy(db.getInteger(DBCondPagoCuotas.OID_COND_PAGO),getSesion()));
    condpagocuotas.setCuota_desde(db.getInteger(DBCondPagoCuotas.CUOTA_DESDE));
    condpagocuotas.setCuota_hasta(db.getInteger(DBCondPagoCuotas.CUOTA_HASTA));
    condpagocuotas.setPorc_dto(db.getPorcentaje(DBCondPagoCuotas.PORC_DTO));
    condpagocuotas.setPorc_recar(db.getPorcentaje(DBCondPagoCuotas.PORC_RECAR));
  }
}
