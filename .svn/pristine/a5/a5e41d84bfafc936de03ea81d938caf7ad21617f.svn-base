package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoMedioPago;
import com.srn.erp.pagos.da.DBRendicionFondoFijoMedioPago;
import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.TipoValor;
import com.srn.erp.tesoreria.bm.Valor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFondoFijoMedioPago extends FactoryObjetoLogico { 

  public FactoryRendicionFondoFijoMedioPago() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFondoFijoMedioPago rendicionfondofijomediopago = (RendicionFondoFijoMedioPago) objLog;
    rendicionfondofijomediopago.setOID(db.getInteger(DBRendicionFondoFijoMedioPago.OID_REND_MED_PAGO));
    rendicionfondofijomediopago.setRendicion_fondo((RendicionFondoFijo)RendicionFondoFijo.findByOidProxy(db.getInteger(DBRendicionFondoFijoMedioPago.OID_REND_FONDO),getSesion()));
    rendicionfondofijomediopago.setValor(Valor.findByOidProxy(db.getInteger(DBRendicionFondoFijoMedioPago.OID_VALOR),getSesion()));
    rendicionfondofijomediopago.setTipo_valor(TipoValor.findByOidProxy(db.getInteger(DBRendicionFondoFijoMedioPago.OID_TIPO_VALOR),getSesion()));
    rendicionfondofijomediopago.setCotizacion(db.getDouble(DBRendicionFondoFijoMedioPago.COTIZACION));
    rendicionfondofijomediopago.setImporte(db.getDouble(DBRendicionFondoFijoMedioPago.IMPORTE));
    rendicionfondofijomediopago.setImpo_mon_rend_ff(db.getDouble(DBRendicionFondoFijoMedioPago.IMPO_MON_REND_FF));
    rendicionfondofijomediopago.setImpo_mon_loc(db.getDouble(DBRendicionFondoFijoMedioPago.IMPO_MON_LOC));
    rendicionfondofijomediopago.setIngresoEgreso(db.getString(DBRendicionFondoFijoMedioPago.INGRESO_EGRESO));
    rendicionfondofijomediopago.setCaja(Caja.findByOidProxy(db.getInteger(DBRendicionFondoFijoMedioPago.OID_CAJA),getSesion()));
  }
}
