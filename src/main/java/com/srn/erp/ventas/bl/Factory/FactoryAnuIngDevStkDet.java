package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AnuIngDevStkCab;
import com.srn.erp.ventas.bm.AnuIngDevStkDet;
import com.srn.erp.ventas.bm.IngStockDevVtasDet;
import com.srn.erp.ventas.da.DBAnuIngDevStkDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnuIngDevStkDet extends FactoryObjetoLogico { 

  public FactoryAnuIngDevStkDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnuIngDevStkDet anulacioningresodevolucionstockdet = (AnuIngDevStkDet) objLog;
    anulacioningresodevolucionstockdet.setOID(db.getInteger(DBAnuIngDevStkDet.OID_ANU_DEV_DET));
    anulacioningresodevolucionstockdet.setAnulacion_ing_dev_stk(AnuIngDevStkCab.findByOidProxy(db.getInteger(DBAnuIngDevStkDet.OID_ANU_ING_DEV),getSesion()));
    anulacioningresodevolucionstockdet.setIngreso_dev_stk_det(IngStockDevVtasDet.findByOidProxy(db.getInteger(DBAnuIngDevStkDet.OID_ING_STK_DET),getSesion()));

  }
}
