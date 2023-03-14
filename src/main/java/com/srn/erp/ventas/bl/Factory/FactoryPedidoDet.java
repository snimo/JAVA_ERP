package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.da.DBPedidoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryPedidoDet extends FactoryObjetoLogico {

  public FactoryPedidoDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    PedidoDet pedidodet = (PedidoDet) objLog;
    pedidodet.setOID(db.getInteger(DBPedidoDet.OID_PED_DET));
    pedidodet.setPedido(PedidoCab.findByOidProxy(db.getInteger(DBPedidoDet.OID_CCO_PED),getSesion()));
    pedidodet.setProducto(Producto.findByOidProxy(db.getInteger(DBPedidoDet.OID_PRODUCTO),getSesion()));
    pedidodet.setUni_med_ori(UnidadMedida.findByOidProxy(db.getInteger(DBPedidoDet.OID_UM_ORI),getSesion()));
    pedidodet.setCant_um_ori(db.getDecimal(DBPedidoDet.CANT_UM_ORI));    
    pedidodet.setCant_um_ori_res(db.getDecimal(DBPedidoDet.CANT_UM_ORI_RES));    
    pedidodet.setCant_um_ori_sep(db.getDecimal(DBPedidoDet.CANT_UM_ORI_SEP));    
    pedidodet.setCant_um_ori_desp(db.getDecimal(DBPedidoDet.CANT_UM_ORI_DESP));    
    pedidodet.setCant_um_ori_ent(db.getDecimal(DBPedidoDet.CANT_UM_ORI_ENT));    
    pedidodet.setCant_um_ori_fact(db.getDecimal(DBPedidoDet.CANT_UM_ORI_FACT));    
    pedidodet.setCant_um_ori_nc(db.getDecimal(DBPedidoDet.CANT_UM_ORI_NC));
    pedidodet.setPrecio(db.getMoney(DBPedidoDet.PRECIO));
    pedidodet.setPrecio_bonif(db.getMoney(DBPedidoDet.PRECIO_BONIF));
    pedidodet.setPrecio_lista(db.getMoney(DBPedidoDet.PRECIO_LISTA));
    pedidodet.setMoneda(Moneda.findByOidProxy(db.getInteger(DBPedidoDet.OID_MONEDA),getSesion()));
    pedidodet.setAnulado(db.getBoolean(DBPedidoDet.ANULADO));
    pedidodet.setBonif1(db.getDecimal(DBPedidoDet.BONIF1));
    pedidodet.setBonif2(db.getDecimal(DBPedidoDet.BONIF2));
    pedidodet.setBonif3(db.getDecimal(DBPedidoDet.BONIF3));
    pedidodet.setBonif4(db.getDecimal(DBPedidoDet.BONIF4));
    pedidodet.setBonif5(db.getDecimal(DBPedidoDet.BONIF5));
    pedidodet.setBonif6(db.getDecimal(DBPedidoDet.BONIF6));
    pedidodet.setBonif7(db.getDecimal(DBPedidoDet.BONIF7));
    pedidodet.setBonif8(db.getDecimal(DBPedidoDet.BONIF8));
    pedidodet.setBonif9(db.getDecimal(DBPedidoDet.BONIF9));
    pedidodet.setFecEntrega(db.getDate(DBPedidoDet.FEC_ENTREGA));
    pedidodet.setComentario(db.getString(DBPedidoDet.COMENTARIO));
    pedidodet.setPendEnt(db.getBoolean(DBPedidoDet.PEND_ENT));
    pedidodet.setPendDesp(db.getBoolean(DBPedidoDet.PEND_DESP));
    pedidodet.setPendFact(db.getBoolean(DBPedidoDet.PEND_FACT));
    pedidodet.setNroRenglon(db.getInteger(DBPedidoDet.NRO_RENGLON));
    
    pedidodet.setImporte(db.getMoney(DBPedidoDet.IMPORTE));
    pedidodet.setDto_recar(db.getMoney(DBPedidoDet.DTO_RECAR));
    pedidodet.setImpre_precio(db.getMoney(DBPedidoDet.IMPRE_PRECIO));
    pedidodet.setImpre_bonif(db.getMoney(DBPedidoDet.IMPRE_BONIF));
    pedidodet.setImpre_recar(db.getMoney(DBPedidoDet.IMPRE_RECAR));
    pedidodet.setImpre_precio_bonif(db.getMoney(DBPedidoDet.IMPRE_PRECIO_BONIF));
    pedidodet.setImpre_importe(db.getMoney(DBPedidoDet.IMPRE_IMPORTE));
    pedidodet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoDet.OID_CONC_IMP_IVA),getSesion()));
    pedidodet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoDet.OID_CONC_IMP_PIVA),getSesion()));
    pedidodet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoDet.OID_CONC_IMP_PIB),getSesion()));
    pedidodet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(db.getInteger(DBPedidoDet.OID_CONC_IMP_INT),getSesion()));
    pedidodet.setNetoGravado(db.getMoney(DBPedidoDet.NETO_GRAVADO));
    pedidodet.setNetoNoGravado(db.getMoney(DBPedidoDet.NETO_NO_GRAVADO));
    pedidodet.setPrecioSugerido(db.getMoney(DBPedidoDet.PRECIO_SUGERIDO));
    pedidodet.setNoFacturar(db.getBoolean(DBPedidoDet.NO_FACTURAR));
    
    
  }
}
