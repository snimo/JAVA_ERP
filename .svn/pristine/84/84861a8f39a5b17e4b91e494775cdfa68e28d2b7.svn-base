package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AnulacionDevolucionCab;
import com.srn.erp.ventas.bm.AnulacionDevolucionDet;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.da.DBAnulacionDevolucionDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAnulacionDevolucionDet extends FactoryObjetoLogico { 

  public FactoryAnulacionDevolucionDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AnulacionDevolucionDet anulaciondevoluciondet = (AnulacionDevolucionDet) objLog;
    anulaciondevoluciondet.setOID(db.getInteger(DBAnulacionDevolucionDet.OID_ANU_VTAS_DET));
    anulaciondevoluciondet.setAnulador_devolucion_cab(AnulacionDevolucionCab.findByOidProxy(db.getInteger(DBAnulacionDevolucionDet.OID_ANU_VTAS_CAB),getSesion()));
    anulaciondevoluciondet.setDevolucion_det(DevolucionVtasDet.findByOidProxy(db.getInteger(DBAnulacionDevolucionDet.OID_DEV_DET),getSesion()));

  }
}
