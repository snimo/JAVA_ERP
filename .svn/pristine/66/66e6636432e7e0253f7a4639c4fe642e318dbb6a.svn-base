package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.AcuerdoLP;
import com.srn.erp.compras.bm.AcuerdoLPDetalle;
import com.srn.erp.compras.da.DBAcuerdoLPDetalle;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryAcuerdoLPDetalle extends FactoryObjetoLogico { 

  public FactoryAcuerdoLPDetalle() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    AcuerdoLPDetalle acuerdolpdetalle = (AcuerdoLPDetalle) objLog;
    acuerdolpdetalle.setOID(db.getInteger(DBAcuerdoLPDetalle.OID_ACU_LP_DET));
    acuerdolpdetalle.setAcuerdo_lp(AcuerdoLP.findByOidProxy(db.getInteger(DBAcuerdoLPDetalle.OID_ACUERDO_LP),getSesion()));
    acuerdolpdetalle.setProducto(Producto.findByOidProxy(db.getInteger(DBAcuerdoLPDetalle.OID_PRODUCTO),getSesion()));
    acuerdolpdetalle.setCantidad(db.getDouble(DBAcuerdoLPDetalle.CANTIDAD));
    acuerdolpdetalle.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBAcuerdoLPDetalle.OID_UM),getSesion()));
    acuerdolpdetalle.setMoneda(Moneda.findByOidProxy(db.getInteger(DBAcuerdoLPDetalle.OID_MONEDA),getSesion()));
    acuerdolpdetalle.setPrecio(db.getMoney(DBAcuerdoLPDetalle.PRECIO));
    acuerdolpdetalle.setComentario(db.getString(DBAcuerdoLPDetalle.COMENTARIO));
    acuerdolpdetalle.setActivo(db.getBoolean(DBAcuerdoLPDetalle.ACTIVO));
    acuerdolpdetalle.setCodProdProv(db.getString(DBAcuerdoLPDetalle.COD_PROD_PROV));
    acuerdolpdetalle.setDescProdProv(db.getString(DBAcuerdoLPDetalle.DESC_PROD_PROV));
  }
}
