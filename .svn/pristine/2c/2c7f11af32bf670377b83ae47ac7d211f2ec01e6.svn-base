package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.contabilidad.bm.Cuenta;
import com.srn.erp.pagos.bm.CtaHabMotivoPagosVarios;
import com.srn.erp.pagos.bm.MotivoPago;
import com.srn.erp.pagos.da.DBCtaHabMotivoPagosVarios;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCtaHabMotivoPagosVarios extends FactoryObjetoLogico { 

  public FactoryCtaHabMotivoPagosVarios() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CtaHabMotivoPagosVarios ctahabmotivopagosvarios = (CtaHabMotivoPagosVarios) objLog;
    ctahabmotivopagosvarios.setOID(db.getInteger(DBCtaHabMotivoPagosVarios.OID_CTA_HAB));
    ctahabmotivopagosvarios.setMotivo_pago(MotivoPago.findByOidProxy(db.getInteger(DBCtaHabMotivoPagosVarios.OID_MOTIVO_PAGO),getSesion()));
    ctahabmotivopagosvarios.setCuenta(Cuenta.findByOidProxy(db.getInteger(DBCtaHabMotivoPagosVarios.OID_ANA_CON),getSesion()));
    ctahabmotivopagosvarios.setActivo(db.getBoolean(DBCtaHabMotivoPagosVarios.ACTIVO));

  }
}
