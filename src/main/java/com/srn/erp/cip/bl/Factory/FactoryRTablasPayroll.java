package com.srn.erp.cip.bl.Factory;

import com.srn.erp.cip.bm.RTablasPayroll;
import com.srn.erp.cip.da.DBRTablasPayroll;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRTablasPayroll extends FactoryObjetoLogico { 

  public FactoryRTablasPayroll() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RTablasPayroll rtablaspayroll = (RTablasPayroll) objLog;
    rtablaspayroll.setOID(db.getInteger(DBRTablasPayroll.OID_TABLA));
    rtablaspayroll.setCotab(db.getInteger(DBRTablasPayroll.COTAB));
    rtablaspayroll.setCodigortabla(db.getInteger(DBRTablasPayroll.CODIGO));
    rtablaspayroll.setDescrip(db.getString(DBRTablasPayroll.DESCRIP));
    rtablaspayroll.setActivo(db.getBoolean(DBRTablasPayroll.ACTIVO));

  }
}
