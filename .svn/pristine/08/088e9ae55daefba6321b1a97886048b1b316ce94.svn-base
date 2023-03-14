package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.InventarioCab;
import com.srn.erp.stock.bm.InventarioDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.da.DBInventarioDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryInventarioDet extends FactoryObjetoLogico { 

  public FactoryInventarioDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    InventarioDet inventariodet = (InventarioDet) objLog;
   inventariodet.setOID(db.getInteger(DBInventarioDet.OID_INVENTARIO_DET));
    inventariodet.setInventario_cab(InventarioCab.findByOidProxy(db.getInteger(DBInventarioDet.OID_INVENTARIO_CAB),getSesion()));
    inventariodet.setProducto(Producto.findByOidProxy(db.getInteger(DBInventarioDet.OID_PRODUCTO),getSesion()));
    inventariodet.setFisico(db.getDouble(DBInventarioDet.FISICO));
    inventariodet.setConteo(db.getDouble(DBInventarioDet.CONTEO));
    inventariodet.setSin_stock(db.getBoolean(DBInventarioDet.SIN_STOCK));
    inventariodet.setAju_stock(db.getDouble(DBInventarioDet.AJU_STOCK));
    inventariodet.setObservacion(db.getString(DBInventarioDet.OBSERVACION));

  }
}
