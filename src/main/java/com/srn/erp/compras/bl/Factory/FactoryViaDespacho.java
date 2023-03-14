package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.ViaDespacho;
import com.srn.erp.compras.da.DBViaDespacho;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryViaDespacho extends FactoryObjetoLogico { 

  public FactoryViaDespacho() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ViaDespacho viadespacho = (ViaDespacho) objLog;
    viadespacho.setOID(db.getInteger(DBViaDespacho.OID_VIA_DESPACHO));
    viadespacho.setCodigo(db.getString(DBViaDespacho.CODIGO));
    viadespacho.setDescripcion(db.getString(DBViaDespacho.DESCRIPCION));
    viadespacho.setActivo(db.getBoolean(DBViaDespacho.ACTIVO));

  }
}
