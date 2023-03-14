package com.srn.erp.presupuesto.bl.Factory;

import com.srn.erp.presupuesto.bm.TipoHabilitadoUPC;
import com.srn.erp.presupuesto.bm.TipoUPC;
import com.srn.erp.presupuesto.bm.UPC;
import com.srn.erp.presupuesto.da.DBTipoHabilitadoUPC;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryTipoHabilitadoUPC extends FactoryObjetoLogico { 

  public FactoryTipoHabilitadoUPC() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    TipoHabilitadoUPC tipohabilitadoupc = (TipoHabilitadoUPC) objLog;
    tipohabilitadoupc.setOID(db.getInteger(DBTipoHabilitadoUPC.OID_TIPO_HAB_UPC));
    tipohabilitadoupc.setUpc(UPC.findByOidProxy(db.getInteger(DBTipoHabilitadoUPC.OID_UPC),getSesion()));
    tipohabilitadoupc.setTipoupc(TipoUPC.findByOidProxy(db.getInteger(DBTipoHabilitadoUPC.OID_TIPO_UPC),getSesion()));
    tipohabilitadoupc.setHabilitado(db.getBoolean(DBTipoHabilitadoUPC.HABILITADO));

  }
}
