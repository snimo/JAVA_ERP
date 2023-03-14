package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.da.DBInformeRecepcionDet;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.RemitoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryInformeRecepcionDet extends FactoryObjetoLogico { 

  public FactoryInformeRecepcionDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    InformeRecepcionDet informerecepciondet = (InformeRecepcionDet) objLog;
    informerecepciondet.setOID(db.getInteger(DBInformeRecepcionDet.OID_INF_REC_DET));
    informerecepciondet.setInforme_recepcion(InformeRecepcion.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_INF_REC),getSesion()));
    informerecepciondet.setNro_item(db.getInteger(DBInformeRecepcionDet.NRO_ITEM));
    informerecepciondet.setProducto(Producto.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_PRODUCTO),getSesion()));
    informerecepciondet.setCant_recibida(db.getDouble(DBInformeRecepcionDet.CANT_RECIBIDA));
    informerecepciondet.setUnidad_medida_recibido(UnidadMedida.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_UM_RECIBIDO),getSesion()));
    informerecepciondet.setCant_rec_en_uc(db.getDouble(DBInformeRecepcionDet.CANT_REC_UC));
    informerecepciondet.setCant_rec_en_us(db.getDouble(DBInformeRecepcionDet.CANT_REC_US));
    informerecepciondet.setControlar_calidad(db.getBoolean(DBInformeRecepcionDet.CONTROLAR_CALIDAD));
    informerecepciondet.setPendiente_cc(db.getBoolean(DBInformeRecepcionDet.PEND_CC));
    informerecepciondet.setCant_ok_us(db.getDouble(DBInformeRecepcionDet.CANT_OK_US));
    informerecepciondet.setCant_mal_us(db.getDouble(DBInformeRecepcionDet.CANT_MAL_US));
    informerecepciondet.setCant_ok_uc(db.getDouble(DBInformeRecepcionDet.CANT_OK_UC));
    informerecepciondet.setCant_mal_uc(db.getDouble(DBInformeRecepcionDet.CANT_MAL_UC));
    informerecepciondet.setComentario(db.getString(DBInformeRecepcionDet.COMENTARIO));
    informerecepciondet.setPrecio_ori(db.getMoney(DBInformeRecepcionDet.PRECIO_ORI));
    informerecepciondet.setMoneda_origen(Moneda.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_MONEDA_ORI),getSesion()));
    informerecepciondet.setPrecio_mon_local(db.getMoney(DBInformeRecepcionDet.PRECIO_MON_LOCAL));
    informerecepciondet.setPrecio_mon_ext1(db.getMoney(DBInformeRecepcionDet.PRECIO_MON_EXT1));
    informerecepciondet.setPrecio_mon_ext2(db.getMoney(DBInformeRecepcionDet.PRECIO_MON_EXT2));
    informerecepciondet.setValoriz_mon_ori(db.getMoney(DBInformeRecepcionDet.VALORIZ_MON_ORI));
    informerecepciondet.setValoriz_mon_local(db.getMoney(DBInformeRecepcionDet.VALORIZ_MON_LOCAL));
    informerecepciondet.setValoriz_mon_ext1(db.getMoney(DBInformeRecepcionDet.VALORIZ_MON_EXT1));
    informerecepciondet.setValoriz_mon_ext2(db.getMoney(DBInformeRecepcionDet.VALORIZ_MON_EXT2));
    informerecepciondet.setAnulado(db.getBoolean(DBInformeRecepcionDet.ANULADO));
    informerecepciondet.setUnidadMedidaCompra(UnidadMedida.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_UM_CPRA),getSesion()));
    informerecepciondet.setUnidadMedidaStock(UnidadMedida.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_UM_STOCK),getSesion()));
    informerecepciondet.setOrdenDeCompraDet(OrdenDeCompraDet.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_OC_DET),getSesion()));
    informerecepciondet.setValorCotizMonOri(db.getValorCotizacion(DBInformeRecepcionDet.COTIZ_MON_ORI));
    informerecepciondet.setValorCotizMonExt1(db.getValorCotizacion(DBInformeRecepcionDet.COTIZ_MON_EXT_1));
    informerecepciondet.setValorCotizMonExt2(db.getValorCotizacion(DBInformeRecepcionDet.COTIZ_MON_EXT_2));
    informerecepciondet.setCantFactUC(db.getDouble(DBInformeRecepcionDet.CANT_FACT_UC));
    informerecepciondet.setCantFactUS(db.getDouble(DBInformeRecepcionDet.CANT_FACT_US));
    informerecepciondet.setPendFact(db.getBoolean(DBInformeRecepcionDet.PEND_FACT));
    informerecepciondet.setRemitoDet(RemitoDet.findByOidProxy(db.getInteger(DBInformeRecepcionDet.OID_REMITO_DET),getSesion()));
  }
}
