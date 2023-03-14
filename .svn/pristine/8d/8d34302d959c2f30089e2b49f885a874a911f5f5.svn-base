package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.ventas.bm.AplicacionIngDevRto;
import com.srn.erp.ventas.bm.DevolucionVtasDet;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.da.DBAplicacionIngDevRto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAplicacionIngDevRto extends FactoryObjetoLogico { 

  public FactoryAplicacionIngDevRto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AplicacionIngDevRto aplicacioningdevrto = (AplicacionIngDevRto) objLog;
    aplicacioningdevrto.setOID(db.getInteger(DBAplicacionIngDevRto.OID_APLIC_ING_RTO));
    aplicacioningdevrto.setRemito_det(RemitoDet.findByOidProxy(db.getInteger(DBAplicacionIngDevRto.OID_REMITO_DET),getSesion()));
    aplicacioningdevrto.setDevolucion_det(DevolucionVtasDet.findByOidProxy(db.getInteger(DBAplicacionIngDevRto.OID_DEV_DET),getSesion()));
    aplicacioningdevrto.setCantidad(db.getDouble(DBAplicacionIngDevRto.CANTIDAD));
    aplicacioningdevrto.setActivo(db.getBoolean(DBAplicacionIngDevRto.ACTIVO));

  }
}
