package com.srn.erp.ventas.bl.Factory;


import com.srn.erp.ventas.bm.AnulacionDevolucionCab;
import com.srn.erp.ventas.da.DBAnulacionDevolucionCab;
import com.srn.erp.ventas.bm.DevolucionVtasCab;


import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnulacionDevolucionCab extends FactoryObjetoLogico { 

  public FactoryAnulacionDevolucionCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnulacionDevolucionCab anulaciondevolucioncab = (AnulacionDevolucionCab) objLog;
    anulaciondevolucioncab.setOID(db.getInteger(DBAnulacionDevolucionCab.OID_ANU_VTAS_CAB));
    anulaciondevolucioncab.setDevolucion_cab(DevolucionVtasCab.findByOidProxy(db.getInteger(DBAnulacionDevolucionCab.OID_DEV_CAB),getSesion()));

  }
}
