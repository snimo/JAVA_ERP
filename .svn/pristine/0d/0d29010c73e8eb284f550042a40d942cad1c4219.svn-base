package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.ConversionUMProducto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBConversionUMProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryConversionUMProducto extends FactoryObjetoLogico {

  public FactoryConversionUMProducto() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ConversionUMProducto conversionumproducto = (ConversionUMProducto) objLog;
    conversionumproducto.setOID(db.getInteger(DBConversionUMProducto.OID_EQUIV_PROD));
    conversionumproducto.setProducto(Producto.findByOidProxy(db.getInteger(DBConversionUMProducto.OID_PRODUCTO),getSesion()));
    conversionumproducto.setUnidad_medida_origen(UnidadMedida.findByOidProxy(db.getInteger(DBConversionUMProducto.OID_UM_ORIGEN),getSesion()));
    conversionumproducto.setUnidad_medida_dest(UnidadMedida.findByOidProxy(db.getInteger(DBConversionUMProducto.OID_UM_DESTINO),getSesion()));
    conversionumproducto.setFact_conv(db.getDouble(DBConversionUMProducto.FACT_CONV));
  }
}
