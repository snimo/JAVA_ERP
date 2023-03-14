package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AnuIngDevStkCab;
import com.srn.erp.ventas.bm.IngresoDevolucionStockCab;
import com.srn.erp.ventas.da.DBAnuIngDevStkCab;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuIngDevStkCab extends FactoryObjetoLogico { 

  public FactoryAnuIngDevStkCab() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuIngDevStkCab anulacioningresodevolucionstockcab = (AnuIngDevStkCab) objLog;
    anulacioningresodevolucionstockcab.setOID(db.getInteger(DBAnuIngDevStkCab.OID_ANU_ING_DEV));
    anulacioningresodevolucionstockcab.setIngreso_devolucion_stk_cab(IngresoDevolucionStockCab.findByOidProxy(db.getInteger(DBAnuIngDevStkCab.OID_ING_DEV_STK),getSesion()));

  }
}
