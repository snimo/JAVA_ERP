package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.NodoEstructuraPlanificacion;
import com.srn.erp.presupuesto.bm.UPC;
import com.srn.erp.presupuesto.bm.UPCNodoEstructura;
import com.srn.erp.presupuesto.da.DBUPCNodoEstructura;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryUPCNodoEstructura extends FactoryObjetoLogico { 

  public FactoryUPCNodoEstructura() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UPCNodoEstructura upcnodoestructura = (UPCNodoEstructura) objLog;
    upcnodoestructura.setOID(db.getInteger(DBUPCNodoEstructura.OID_UPC_NODO));
    upcnodoestructura.setOrden(db.getInteger(DBUPCNodoEstructura.ORDEN));
    upcnodoestructura.setNodo_estructura(NodoEstructuraPlanificacion.findByOidProxy(db.getInteger(DBUPCNodoEstructura.OID_NODO_ESTRUC),getSesion()));
    upcnodoestructura.setUpc(UPC.findByOidProxy(db.getInteger(DBUPCNodoEstructura.OID_UPC),getSesion()));
    upcnodoestructura.setActivo(db.getBoolean(DBUPCNodoEstructura.ACTIVO));

  }
}
