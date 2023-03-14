package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.ListaPrecios;
import com.srn.erp.ventas.bm.ListaPreciosDet;
import com.srn.erp.ventas.da.DBListaPreciosDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryListaPreciosDet extends FactoryObjetoLogico {

  public FactoryListaPreciosDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ListaPreciosDet listapreciosdet = (ListaPreciosDet) objLog;
    listapreciosdet.setOID(db.getInteger(DBListaPreciosDet.OID_PRECIO_DET));
    listapreciosdet.setLista_precio(ListaPrecios.findByOidProxy(db.getInteger(DBListaPreciosDet.OID_PRECIO_CAB),getSesion()));
    listapreciosdet.setProducto(Producto.findByOidProxy(db.getInteger(DBListaPreciosDet.OID_PRODUCTO),getSesion()));
    listapreciosdet.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBListaPreciosDet.OID_UM),getSesion()));
    listapreciosdet.setCantidad(db.getDouble(DBListaPreciosDet.CANTIDAD));
    listapreciosdet.setMoneda(Moneda.findByOidProxy(db.getInteger(DBListaPreciosDet.OID_MONEDA),getSesion()));
    listapreciosdet.setPrecio(db.getMoney(DBListaPreciosDet.PRECIO));
    listapreciosdet.setActivo(db.getBoolean(DBListaPreciosDet.ACTIVO));
    listapreciosdet.setFecUltAct(db.getDate(DBListaPreciosDet.FEC_ULT_ACT));
  }

}
