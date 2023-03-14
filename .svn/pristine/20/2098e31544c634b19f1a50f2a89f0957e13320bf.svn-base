package com.srn.erp.ventas.bl.Factory;

import framework.applicarionServer.bl.ObjetosAplicacion.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;
import com.srn.erp.ventas.bm.LogImpresoraFiscal;
import com.srn.erp.ventas.da.DBLogImpresoraFiscal;

public class FactoryLogImpresoraFiscal extends FactoryObjetoLogico { 

  public FactoryLogImpresoraFiscal() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    LogImpresoraFiscal logimpresorafiscal = (LogImpresoraFiscal) objLog;
    logimpresorafiscal.setOID(db.getInteger(DBLogImpresoraFiscal.OID_LOG_IMP_FIS));
    logimpresorafiscal.setOid_cco(db.getInteger(DBLogImpresoraFiscal.OID_CCO));
    logimpresorafiscal.setNro_impresion(db.getInteger(DBLogImpresoraFiscal.NRO_IMPRESION));
    logimpresorafiscal.setFecha(db.getDate(DBLogImpresoraFiscal.FECHA));
    logimpresorafiscal.setHora(db.getString(DBLogImpresoraFiscal.HORA));
    logimpresorafiscal.setOid_usuario(db.getInteger(DBLogImpresoraFiscal.OID_USUARIO));
    logimpresorafiscal.setLinea(db.getString(DBLogImpresoraFiscal.LINEA));
    logimpresorafiscal.setNro_error(db.getInteger(DBLogImpresoraFiscal.NRO_ERROR));
    logimpresorafiscal.setOid_sucursal(db.getInteger(DBLogImpresoraFiscal.OID_SUCURSAL));

  }
}
