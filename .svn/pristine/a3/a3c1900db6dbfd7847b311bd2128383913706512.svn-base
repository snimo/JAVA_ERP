package com.srn.erp.stock.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.CostoProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBCostoProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCostoProducto extends FactoryObjetoLogico { 

  public FactoryCostoProducto() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CostoProducto costoproducto = (CostoProducto) objLog;
    costoproducto.setOID(db.getInteger(DBCostoProducto.OID_COSTO_PRODUCTO));
    costoproducto.setFec_ult_costo(db.getDate(DBCostoProducto.FEC_ULT_COSTO));
    costoproducto.setProducto(Producto.findByOidProxy(db.getInteger(DBCostoProducto.OID_PRODUCTO),getSesion()));
    costoproducto.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCostoProducto.OID_MONEDA),getSesion()));
    costoproducto.setCantidad(db.getDouble(DBCostoProducto.CANTIDAD));
    costoproducto.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBCostoProducto.OID_UM),getSesion()));
    costoproducto.setCosto(db.getMoney(DBCostoProducto.COSTO));
    costoproducto.setActivo(db.getBoolean(DBCostoProducto.ACTIVO));

  }
}
