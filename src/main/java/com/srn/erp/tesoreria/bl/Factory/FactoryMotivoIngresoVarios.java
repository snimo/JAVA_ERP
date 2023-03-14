package com.srn.erp.tesoreria.bl.Factory;

import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.tesoreria.bm.MotivoIngresoVarios;
import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.da.DBMotivoIngresoVarios;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryMotivoIngresoVarios extends FactoryObjetoLogico { 

  public FactoryMotivoIngresoVarios() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    MotivoIngresoVarios motivoingresovarios = (MotivoIngresoVarios) objLog;
    motivoingresovarios.setOID(db.getInteger(DBMotivoIngresoVarios.OID));
    motivoingresovarios.setRecibo(Recibo.findByOidProxy(db.getInteger(DBMotivoIngresoVarios.OID_RECIBO),getSesion()));
    motivoingresovarios.setCuenta_imputable(CuentaImputable.findByOidProxy(db.getInteger(DBMotivoIngresoVarios.OID_AI),getSesion()));
    motivoingresovarios.setDebe(db.getMoney(DBMotivoIngresoVarios.DEBE));
    motivoingresovarios.setHaber(db.getMoney(DBMotivoIngresoVarios.HABER));
    motivoingresovarios.setComentario(db.getString(DBMotivoIngresoVarios.COMENTARIO));

  }
}
