package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.pagos.bm.RendicionFondoFijo;
import com.srn.erp.pagos.bm.RendicionFondoFijoImpu;
import com.srn.erp.pagos.da.DBRendicionFondoFijoImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFondoFijoImpu extends FactoryObjetoLogico { 

  public FactoryRendicionFondoFijoImpu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFondoFijoImpu rendicionfondofijoimpu = (RendicionFondoFijoImpu) objLog;
    rendicionfondofijoimpu.setOID(db.getInteger(DBRendicionFondoFijoImpu.OID_REND_FF_IMPU));
    rendicionfondofijoimpu.setRendicion_fondo(RendicionFondoFijo.findByOidProxy(db.getInteger(DBRendicionFondoFijoImpu.OID_REND_FONDO),getSesion()));
    rendicionfondofijoimpu.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBRendicionFondoFijoImpu.OID_AI),getSesion()));
    rendicionfondofijoimpu.setImporte_debe(db.getDouble(DBRendicionFondoFijoImpu.IMPORTE_DEBE));
    rendicionfondofijoimpu.setImporte_haber(db.getDouble(DBRendicionFondoFijoImpu.IMPORTE_HABER));
    rendicionfondofijoimpu.setComentario(db.getString(DBRendicionFondoFijoImpu.COMENTARIO));

  }
}
