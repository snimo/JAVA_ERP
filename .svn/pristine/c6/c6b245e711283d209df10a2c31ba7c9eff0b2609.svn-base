package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CotizacionProveedorCab;
import com.srn.erp.compras.bm.CotizacionProveedorDet;
import com.srn.erp.compras.bm.SolicitudCotizDetPorProv;
import com.srn.erp.compras.da.DBCotizacionProveedorDet;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacionProveedorDet extends FactoryObjetoLogico { 

  public FactoryCotizacionProveedorDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CotizacionProveedorDet cotizacionproveedordet = (CotizacionProveedorDet) objLog;
    cotizacionproveedordet.setOID(db.getInteger(DBCotizacionProveedorDet.OID_COTIZ_PROV_DET));
    cotizacionproveedordet.setCotizacion_proveedor(CotizacionProveedorCab.findByOidProxy(db.getInteger(DBCotizacionProveedorDet.OID_COTIZ_PROV_CAB),getSesion()));
    cotizacionproveedordet.setCotizacion_det_prov(SolicitudCotizDetPorProv.findByOidProxy(db.getInteger(DBCotizacionProveedorDet.OID_COTIZ_DET_PROV),getSesion()));
    cotizacionproveedordet.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBCotizacionProveedorDet.OID_UM),getSesion()));
    cotizacionproveedordet.setCant_presu(db.getDouble(DBCotizacionProveedorDet.CANT_PRESU));
    cotizacionproveedordet.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCotizacionProveedorDet.OID_MONEDA),getSesion()));
    cotizacionproveedordet.setPrecio(db.getMoney(DBCotizacionProveedorDet.PRECIO));
    cotizacionproveedordet.setFec_ent(db.getDate(DBCotizacionProveedorDet.FEC_ENT));
    cotizacionproveedordet.setComentario(db.getString(DBCotizacionProveedorDet.COMENTARIO));
    cotizacionproveedordet.setCond_pago_1(CondicionCompra.findByOidProxy(db.getInteger(DBCotizacionProveedorDet.OID_COND_PAGO_1),getSesion()));
    cotizacionproveedordet.setDto_cond_pago_1(db.getDouble(DBCotizacionProveedorDet.DTO_COND_PAGO_1));
    cotizacionproveedordet.setCond_pago_2(CondicionCompra.findByOidProxy(db.getInteger(DBCotizacionProveedorDet.OID_COND_PAGO_2),getSesion()));
    cotizacionproveedordet.setDto_cond_pago_2(db.getDouble(DBCotizacionProveedorDet.DTO_COND_PAGO_2));
    cotizacionproveedordet.setAnulado(db.getBoolean(DBCotizacionProveedorDet.ANULADO));
    cotizacionproveedordet.setProducto(Producto.findByOidProxy(db.getInteger(DBCotizacionProveedorDet.OID_PRODUCTO),getSesion()));
    cotizacionproveedordet.setNroItem(db.getInteger(DBCotizacionProveedorDet.NRO_ITEM));
  }
}
