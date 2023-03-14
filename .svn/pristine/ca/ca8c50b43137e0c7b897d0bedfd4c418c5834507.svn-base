package com.srn.erp.stock.bl.Factory;

import com.srn.erp.stock.bm.FactorConversionProveedor;
import com.srn.erp.stock.bm.ProductoProveedor;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.stock.da.DBFactorConversionProveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFactorConversionProveedor extends FactoryObjetoLogico { 

  public FactoryFactorConversionProveedor() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FactorConversionProveedor factorconversionproveedor = (FactorConversionProveedor) objLog;
    factorconversionproveedor.setOID(db.getInteger(DBFactorConversionProveedor.OID_FACT_CONV_PROV));
    factorconversionproveedor.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBFactorConversionProveedor.OID_UM),getSesion()));
    factorconversionproveedor.setProducto_proveedor(ProductoProveedor.findByOidProxy(db.getInteger(DBFactorConversionProveedor.OID_PROD_PROV),getSesion()));
    factorconversionproveedor.setFactor_conversion(db.getDouble(DBFactorConversionProveedor.FACT_CONV));

  }
}
