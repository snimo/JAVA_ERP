package com.srn.erp.compras.bl.Factory;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.compras.bm.RequisicionDet;
import com.srn.erp.compras.da.DBOrdenDeCompraDet;
import com.srn.erp.general.bm.Moneda;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryOrdenDeCompraDet extends FactoryObjetoLogico { 

  public FactoryOrdenDeCompraDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    OrdenDeCompraDet ordendecompradet = (OrdenDeCompraDet) objLog;
    ordendecompradet.setOID(db.getInteger(DBOrdenDeCompraDet.OID_OC_DET));
    ordendecompradet.setOrden_de_compra(OrdenDeCompraCab.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_CCO_CPRA),getSesion()));
    ordendecompradet.setNro_item(db.getInteger(DBOrdenDeCompraDet.NRO_ITEM));
    ordendecompradet.setUnidad_compra(UnidadMedida.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_UM_CPRA),getSesion()));
    ordendecompradet.setProducto(Producto.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_PRODUCTO),getSesion()));
    ordendecompradet.setDesc_adic_sku(db.getString(DBOrdenDeCompraDet.DESC_ADIC_SKU));
    ordendecompradet.setUm_stock(UnidadMedida.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_UM_STOCK),getSesion()));
    ordendecompradet.setCant_comprada_uc(db.getDouble(DBOrdenDeCompraDet.CANT_CPRA_UC));
    ordendecompradet.setCant_comprada_us(db.getDouble(DBOrdenDeCompraDet.CANT_CPRA_US));
    ordendecompradet.setMoneda(Moneda.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_MONEDA),getSesion()));
    ordendecompradet.setFuente_precio_sug(db.getString(DBOrdenDeCompraDet.FUENTE_PRECIO_SUG));
    ordendecompradet.setPrecio_sugerido(db.getDouble(DBOrdenDeCompraDet.PRECIO_SUGERIDO));
    ordendecompradet.setAnulado(db.getBoolean(DBOrdenDeCompraDet.ANULADO));
    ordendecompradet.setPrecio_neto_bonif(db.getDouble(DBOrdenDeCompraDet.PRECIO_NETO_BONIF));
    ordendecompradet.setPrecio(db.getDouble(DBOrdenDeCompraDet.PRECIO));
    ordendecompradet.setComentario(db.getString(DBOrdenDeCompraDet.COMENTARIO));
    ordendecompradet.setTotal(db.getDouble(DBOrdenDeCompraDet.TOTAL));
    ordendecompradet.setDto1(db.getDouble(DBOrdenDeCompraDet.DTO_1));
    ordendecompradet.setDto2(db.getDouble(DBOrdenDeCompraDet.DTO_2));
    ordendecompradet.setDto3(db.getDouble(DBOrdenDeCompraDet.DTO_3));
    ordendecompradet.setEnCascada(db.getBoolean(DBOrdenDeCompraDet.EN_CASCADA));
    ordendecompradet.setPorcRecar(db.getPorcentaje(DBOrdenDeCompraDet.PORC_RECAR));
    ordendecompradet.setTipoRecarDto(db.getString(DBOrdenDeCompraDet.TIPO_RECAR_DTO));
    ordendecompradet.setPorcDtoRecar(db.getPorcentaje(DBOrdenDeCompraDet.PORC_DTO_RECAR));
    ordendecompradet.setFecRequerida(db.getDate(DBOrdenDeCompraDet.FEC_REQUERIDA));
    ordendecompradet.setCantRecepUC(db.getDouble(DBOrdenDeCompraDet.CANT_RECEP_UC));
    ordendecompradet.setCantRecepUS(db.getDouble(DBOrdenDeCompraDet.CANT_RECEP_US));
    ordendecompradet.setPendienteRecepcion(db.getBoolean(DBOrdenDeCompraDet.PEND_RECEP));
    ordendecompradet.setPedidoDet(PedidoDet.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_PED_DET),getSesion()));
    ordendecompradet.setPedidoCab(PedidoCab.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_PED_CAB),getSesion()));
    ordendecompradet.setCantFactUC(db.getDouble(DBOrdenDeCompraDet.CANT_FACT_UC));
    ordendecompradet.setCantFactUS(db.getDouble(DBOrdenDeCompraDet.CANT_FACT_US));
    ordendecompradet.setPendFact(db.getBoolean(DBOrdenDeCompraDet.PEND_FACT));
    ordendecompradet.setRequisicionDet(RequisicionDet.findByOidProxy(db.getInteger(DBOrdenDeCompraDet.OID_REQUI_DET),getSesion()));
    ordendecompradet.setCantDevueltaUC(db.getDouble(DBOrdenDeCompraDet.CANT_DEVUELTA_UC));
    ordendecompradet.setCantDevueltaUS(db.getDouble(DBOrdenDeCompraDet.CANT_DEVUELTA_US));
  }
}
