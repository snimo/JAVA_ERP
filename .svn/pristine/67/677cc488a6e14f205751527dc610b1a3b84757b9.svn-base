package com.srn.erp.pagos.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.pagos.bm.RendicionFondoFijoCompro;
import com.srn.erp.pagos.bm.RendicionFondoFijoComproImpu;
import com.srn.erp.pagos.da.DBRendicionFondoFijoComproImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRendicionFondoFijoComproImpu extends FactoryObjetoLogico { 

  public FactoryRendicionFondoFijoComproImpu() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RendicionFondoFijoComproImpu rendicionfondofijocomproimpu = (RendicionFondoFijoComproImpu) objLog;
    rendicionfondofijocomproimpu.setOID(db.getInteger(DBRendicionFondoFijoComproImpu.OID_CCO_PROV_IMPU));
    rendicionfondofijocomproimpu.setRendicion_det(RendicionFondoFijoCompro.findByOidProxy(db.getInteger(DBRendicionFondoFijoComproImpu.OID_REND_FF_DET),getSesion()));
    rendicionfondofijocomproimpu.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBRendicionFondoFijoComproImpu.OID_AI),getSesion()));
    rendicionfondofijocomproimpu.setImporte(db.getDouble(DBRendicionFondoFijoComproImpu.IMPORTE));
    rendicionfondofijocomproimpu.setComentario(db.getString(DBRendicionFondoFijoComproImpu.COMENTARIO));

  }
}
