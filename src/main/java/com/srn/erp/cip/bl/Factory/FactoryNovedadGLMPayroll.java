package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.NovedadGLMPayroll;
import com.srn.erp.cip.da.DBNovedadGLMPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryNovedadGLMPayroll extends FactoryObjetoLogico { 

  public FactoryNovedadGLMPayroll() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    NovedadGLMPayroll novedadglmpayroll = (NovedadGLMPayroll) objLog;
    novedadglmpayroll.setOID(db.getInteger(DBNovedadGLMPayroll.OID_TBGL_NOV));
    novedadglmpayroll.setCodigo(db.getString(DBNovedadGLMPayroll.CODIGO));
    novedadglmpayroll.setFechaini(db.getDate(DBNovedadGLMPayroll.FECHAINI));
    novedadglmpayroll.setFechafin(db.getDate(DBNovedadGLMPayroll.FECHAFIN));
    novedadglmpayroll.setProconpe(db.getDate(DBNovedadGLMPayroll.PROCONPE));
    novedadglmpayroll.setActivo(db.getBoolean(DBNovedadGLMPayroll.ACTIVO));
  }
}
