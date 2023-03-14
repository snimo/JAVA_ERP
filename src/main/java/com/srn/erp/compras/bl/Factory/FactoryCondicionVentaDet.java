package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondicionVenta;
import com.srn.erp.compras.bm.CondicionVentaDet;
import com.srn.erp.compras.da.DBCondicionVenta;
import com.srn.erp.compras.da.DBCondicionVentaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCondicionVentaDet extends FactoryObjetoLogico {

  public FactoryCondicionVentaDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CondicionVentaDet condicionVentadet = (CondicionVentaDet) objLog;
    condicionVentadet.setOID(db.getInteger(DBCondicionVentaDet.OID_COND_VTA_DET));
    condicionVentadet.setCondicionVenta(CondicionVenta.findByOidProxy(db.getInteger(DBCondicionVenta.OID_COND_VENTA),getSesion()));
    condicionVentadet.setUnidadvenc(db.getString(DBCondicionVentaDet.UNIDAD_CUOTA_VENC));
    condicionVentadet.setCantidad(db.getInteger(DBCondicionVentaDet.CANTIDAD));
    condicionVentadet.setNrocuota(db.getInteger(DBCondicionVentaDet.NRO_CUOTA));
    condicionVentadet.setPorcentaje(db.getDouble(DBCondicionVentaDet.PORC));
    condicionVentadet.setActivo(db.getBoolean(DBCondicionVentaDet.ACTIVO));

  }
}
