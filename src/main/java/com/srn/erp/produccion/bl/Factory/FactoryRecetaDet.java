package com.srn.erp.produccion.bl.Factory;

import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.bm.RecetaDet;
import com.srn.erp.produccion.da.DBRecetaDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryRecetaDet extends FactoryObjetoLogico { 

  public FactoryRecetaDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    RecetaDet recetadet = (RecetaDet) objLog;
    recetadet.setOID(db.getInteger(DBRecetaDet.OID_REC_DET));
    recetadet.setReceta_cab(RecetaCab.findByOidProxy(db.getInteger(DBRecetaDet.OID_REC_CAB),getSesion()));
    recetadet.setProducto(Producto.findByOidProxy(db.getInteger(DBRecetaDet.OID_PRODUCTO),getSesion()));
    recetadet.setOid_um(UnidadMedida.findByOidProxy(db.getInteger(DBRecetaDet.OID_UM),getSesion()));
    recetadet.setCantidad(db.getDouble(DBRecetaDet.CANTIDAD));
    recetadet.setDescarte(db.getDouble(DBRecetaDet.DESCARTE));
    recetadet.setActivo(db.getBoolean(DBRecetaDet.ACTIVO));
    recetadet.setOrden(db.getInteger(DBRecetaDet.ORDEN));
  }
}
