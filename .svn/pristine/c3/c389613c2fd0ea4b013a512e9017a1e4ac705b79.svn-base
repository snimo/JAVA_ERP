package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.compras.da.DBCondicionVenta;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondicionVenta extends FactoryObjetoLogico {

  public FactoryCondicionVenta() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondicionVenta condicionVenta = (CondicionVenta) objLog;
    condicionVenta.setOID(db.getInteger(DBCondicionVenta.OID_COND_VENTA));
    condicionVenta.setCodigo(db.getString(DBCondicionVenta.CODIGO));
    condicionVenta.setDescripcion(db.getString(DBCondicionVenta.DESCRIPCION));
    condicionVenta.setVtofijo(db.getBoolean(DBCondicionVenta.VTO_FIJO));
    condicionVenta.setActivo(db.getBoolean(DBCondicionVenta.ACTIVO));
    condicionVenta.setPorcDto(db.getPorcentaje(DBCondicionVenta.PORC_DTO));
    condicionVenta.setPorcRecar(db.getPorcentaje(DBCondicionVenta.PORC_RECAR));
  }
}
