package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.general.bm.Moneda;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.CotizacionCab;
import com.srn.erp.ventas.bm.CotizacionDet;
import com.srn.erp.ventas.da.DBCotizacionDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryCotizacionDet extends FactoryObjetoLogico {

  public FactoryCotizacionDet() {
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    CotizacionDet cotizaciondet = (CotizacionDet) objLog;
    cotizaciondet.setOID(db.getInteger(DBCotizacionDet.OID_PRESU_DET));
    cotizaciondet.setCotizacion(CotizacionCab.findByOidProxy(db.getInteger(DBCotizacionDet.OID_CCO_PRESU),getSesion()));
    cotizaciondet.setProducto(Producto.findByOidProxy(db.getInteger(DBCotizacionDet.OID_PRODUCTO),getSesion()));
    cotizaciondet.setUni_med_ori(UnidadMedida.findByOidProxy(db.getInteger(DBCotizacionDet.OID_UM_ORI),getSesion()));
    cotizaciondet.setCant_um_ori(db.getDecimal(DBCotizacionDet.CANT_UM_ORI));    
    cotizaciondet.setCant_um_ori_res(db.getDecimal(DBCotizacionDet.CANT_UM_ORI_RES));    
    cotizaciondet.setCant_um_ori_sep(db.getDecimal(DBCotizacionDet.CANT_UM_ORI_SEP));    
    cotizaciondet.setCant_um_ori_desp(db.getDecimal(DBCotizacionDet.CANT_UM_ORI_DESP));    
    cotizaciondet.setCant_um_ori_ent(db.getDecimal(DBCotizacionDet.CANT_UM_ORI_ENT));    
    cotizaciondet.setCant_um_ori_fact(db.getDecimal(DBCotizacionDet.CANT_UM_ORI_FACT));    
    cotizaciondet.setPrecio(db.getMoney(DBCotizacionDet.PRECIO));
    cotizaciondet.setPrecio_bonif(db.getMoney(DBCotizacionDet.PRECIO_BONIF));
    cotizaciondet.setPrecio_lista(db.getMoney(DBCotizacionDet.PRECIO_LISTA));
    cotizaciondet.setMoneda(Moneda.findByOidProxy(db.getInteger(DBCotizacionDet.OID_MONEDA),getSesion()));
    cotizaciondet.setAnulado(db.getBoolean(DBCotizacionDet.ANULADO));
    cotizaciondet.setBonif1(db.getDecimal(DBCotizacionDet.BONIF1));
    cotizaciondet.setBonif2(db.getDecimal(DBCotizacionDet.BONIF2));
    cotizaciondet.setBonif3(db.getDecimal(DBCotizacionDet.BONIF3));
    cotizaciondet.setBonif4(db.getDecimal(DBCotizacionDet.BONIF4));
    cotizaciondet.setBonif5(db.getDecimal(DBCotizacionDet.BONIF5));
    cotizaciondet.setBonif6(db.getDecimal(DBCotizacionDet.BONIF6));
    cotizaciondet.setBonif7(db.getDecimal(DBCotizacionDet.BONIF7));
    cotizaciondet.setBonif8(db.getDecimal(DBCotizacionDet.BONIF8));
    cotizaciondet.setBonif9(db.getDecimal(DBCotizacionDet.BONIF9));
    cotizaciondet.setFecEntrega(db.getDate(DBCotizacionDet.FEC_ENTREGA));
    cotizaciondet.setComentario(db.getString(DBCotizacionDet.COMENTARIO));
    cotizaciondet.setPendEnt(db.getBoolean(DBCotizacionDet.PEND_ENT));
    cotizaciondet.setPendDesp(db.getBoolean(DBCotizacionDet.PEND_DESP));
    cotizaciondet.setPendFact(db.getBoolean(DBCotizacionDet.PEND_FACT));
    cotizaciondet.setNroRenglon(db.getInteger(DBCotizacionDet.NRO_RENGLON));
    cotizaciondet.setDiasEntrega(db.getInteger(DBCotizacionDet.DIAS_ENTREGA));
    
    cotizaciondet.setImporte(db.getMoney(DBCotizacionDet.IMPORTE));
    cotizaciondet.setDto_recar(db.getMoney(DBCotizacionDet.DTO_RECAR));
    cotizaciondet.setImpre_precio(db.getMoney(DBCotizacionDet.IMPRE_PRECIO));
    cotizaciondet.setImpre_bonif(db.getMoney(DBCotizacionDet.IMPRE_BONIF));
    cotizaciondet.setImpre_recar(db.getMoney(DBCotizacionDet.IMPRE_RECAR));
    cotizaciondet.setImpre_precio_bonif(db.getMoney(DBCotizacionDet.IMPRE_PRECIO_BONIF));
    cotizaciondet.setImpre_importe(db.getMoney(DBCotizacionDet.IMPRE_IMPORTE));
    cotizaciondet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionDet.OID_CONC_IMP_IVA),getSesion()));
    cotizaciondet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionDet.OID_CONC_IMP_PIVA),getSesion()));
    cotizaciondet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionDet.OID_CONC_IMP_PIB),getSesion()));
    cotizaciondet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(db.getInteger(DBCotizacionDet.OID_CONC_IMP_INT),getSesion()));
    cotizaciondet.setNetoGravado(db.getMoney(DBCotizacionDet.NETO_GRAVADO));
    cotizaciondet.setNetoNoGravado(db.getMoney(DBCotizacionDet.NETO_NO_GRAVADO));
    
    
    
  }
}
