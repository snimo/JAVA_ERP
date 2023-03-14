package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.PrecioCompraPorClasifArt;
import com.srn.erp.compras.da.DBPrecioCompraPorClasifArt;
import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.general.bm.ValorClasifEntProdGen;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPrecioCompraPorClasifArt extends FactoryObjetoLogico { 

  public FactoryPrecioCompraPorClasifArt() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PrecioCompraPorClasifArt preciocompraporclasifart = (PrecioCompraPorClasifArt) objLog;
    preciocompraporclasifart.setOID(db.getInteger(DBPrecioCompraPorClasifArt.OID_PRECIO_CLASIF));
    preciocompraporclasifart.setAcuerdo_lp(AcuerdoLP.findByOidProxy(db.getInteger(DBPrecioCompraPorClasifArt.OID_ACUERDO_LP),getSesion()));
    preciocompraporclasifart.setValor_clasif_art(ValorClasifEntProdGen.findByOidProxy(db.getInteger(DBPrecioCompraPorClasifArt.OID_VAL_CLASIF_ART),getSesion()));
    preciocompraporclasifart.setClasificador(ClasificadorEntidad.findByOidProxy(db.getInteger(DBPrecioCompraPorClasifArt.OID_CLASIFICADOR),getSesion()));
    preciocompraporclasifart.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBPrecioCompraPorClasifArt.OID_UM),getSesion()));
    preciocompraporclasifart.setCantidad(db.getMoney(DBPrecioCompraPorClasifArt.CANTIDAD));
    preciocompraporclasifart.setPrecio(db.getMoney(DBPrecioCompraPorClasifArt.PRECIO));
    preciocompraporclasifart.setMoneda(Moneda.findByOidProxy(db.getInteger(DBPrecioCompraPorClasifArt.OID_MONEDA),getSesion()));
    preciocompraporclasifart.setActivo(db.getBoolean(DBPrecioCompraPorClasifArt.ACTIVO));
    preciocompraporclasifart.setFecVigencia(db.getDate(DBPrecioCompraPorClasifArt.FEC_VIGENCIA));
    preciocompraporclasifart.setProductoProveedor(ProductoProveedor.findByOidProxy(db.getInteger(DBPrecioCompraPorClasifArt.PRODUCTO_PROVEEDOR),getSesion()));
  }
}
