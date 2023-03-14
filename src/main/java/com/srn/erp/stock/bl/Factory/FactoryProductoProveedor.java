package com.srn.erp.stock.bl.Factory;

import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.compras.bm.TipoAcuerdo;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.ValorClasificadorEntidad;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBProductoProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryProductoProveedor extends FactoryObjetoLogico {

  public FactoryProductoProveedor() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ProductoProveedor productoproveedor = (ProductoProveedor) objLog;
    productoproveedor.setOID(db.getInteger(DBProductoProveedor.OID_PROD_PROV));
    productoproveedor.setProducto(Producto.findByOidProxy(db.getInteger(DBProductoProveedor.OID_PRODUCTO),getSesion()));
    productoproveedor.setProveedor(Proveedor.findByOidProxy(db.getInteger(DBProductoProveedor.OID_PROVEEDOR),getSesion()));
    productoproveedor.setCod_prod_prov(db.getString(DBProductoProveedor.COD_PROD_PROV));
    productoproveedor.setUmcpra(UnidadMedida.findByOidProxy(db.getInteger(DBProductoProveedor.OID_UM_CPRA),getSesion()));
    productoproveedor.setLote_minimo(db.getMoney(DBProductoProveedor.LOTE_MINIMO));
    productoproveedor.setMultiplo(db.getMoney(DBProductoProveedor.MULTIPLO));
    productoproveedor.setLt_ent_dias(db.getInteger(DBProductoProveedor.LT_ENT_DIAS));
    productoproveedor.setPrioridadCompra(db.getInteger(DBProductoProveedor.PRIORIDAD));
    productoproveedor.setValClasifProdGeneral(ValorClasificadorEntidad.findByOidProxy(db.getInteger(DBProductoProveedor.OID_VAL_CLASIF),getSesion()));
    productoproveedor.setClasifProdGeneral(ClasificadorEntidad.findByOidProxy(db.getInteger(DBProductoProveedor.OID_CLASIF),getSesion()));
    productoproveedor.setTipoAcuerdo(TipoAcuerdo.findByOidProxy(db.getInteger(DBProductoProveedor.OID_TIPO_ACUERDO),getSesion()));
    productoproveedor.setActivo(true);
  }
}
