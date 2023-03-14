package com.srn.erp.ventas.bl.Factory;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;
import com.srn.erp.ventas.bm.FacturaCab;
import com.srn.erp.ventas.bm.FacturaDet;
import com.srn.erp.ventas.bm.PedidoCab;
import com.srn.erp.ventas.bm.PedidoDet;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.da.DBFacturaDet;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFacturaDet extends FactoryObjetoLogico { 

  public FactoryFacturaDet() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FacturaDet facturadet = (FacturaDet) objLog;
    facturadet.setOID(db.getInteger(DBFacturaDet.OID_FACT_DET));
    facturadet.setComprocab(FacturaCab.findByOidProxy(db.getInteger(DBFacturaDet.OID_CCO_FACT),getSesion()));
    facturadet.setProducto(Producto.findByOidProxy(db.getInteger(DBFacturaDet.OID_PRODUCTO),getSesion()));
    facturadet.setCantidad(db.getDouble(DBFacturaDet.CANTIDAD));
    facturadet.setUnidad_medida(UnidadMedida.findByOidProxy(db.getInteger(DBFacturaDet.OID_UM),getSesion()));
    facturadet.setPrecio_lista(db.getMoney(DBFacturaDet.PRECIO_LISTA));
    facturadet.setPrecio_ingresado(db.getMoney(DBFacturaDet.PRECIO_INGRESADO));
    facturadet.setPrecio_sugerido(db.getMoney(DBFacturaDet.PRECIO_SUGERIDO));
    facturadet.setPorc_bonif_1(db.getPorcentaje(DBFacturaDet.PORC_BONIF_1));
    facturadet.setPorc_bonif_2(db.getPorcentaje(DBFacturaDet.PORC_BONIF_2));
    facturadet.setPorc_bonif_3(db.getPorcentaje(DBFacturaDet.PORC_BONIF_3));
    facturadet.setPrecio_bonificado(db.getMoney(DBFacturaDet.PRECIO_BONIFICADO));
    facturadet.setImporte(db.getMoney(DBFacturaDet.IMPORTE));
    facturadet.setComentario(db.getString(DBFacturaDet.COMENTARIO));
    facturadet.setDto_recar(db.getMoney(DBFacturaDet.DTO_RECAR));
    facturadet.setAnulado(db.getBoolean(DBFacturaDet.ANULADO));
    facturadet.setImpre_precio(db.getMoney(DBFacturaDet.IMPRE_PRECIO));
    facturadet.setImpre_bonif(db.getMoney(DBFacturaDet.IMPRE_BONIF));
    facturadet.setImpre_recar(db.getMoney(DBFacturaDet.IMPRE_RECAR));
    facturadet.setImpre_precio_bonif(db.getMoney(DBFacturaDet.IMPRE_PRECIO_BONIF));
    facturadet.setImpre_importe(db.getMoney(DBFacturaDet.IMPRE_IMPORTE));
    facturadet.setConcImpuIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaDet.OID_CONC_IMP_IVA),getSesion()));
    facturadet.setConcImpuPercIVA(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaDet.OID_CONC_IMP_PIVA),getSesion()));
    facturadet.setConcImpuPercIB(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaDet.OID_CONC_IMP_PIB),getSesion()));
    facturadet.setConcImpuInt(ConceptoImpuesto.findByOidProxy(db.getInteger(DBFacturaDet.OID_CONC_IMP_INT),getSesion()));
    facturadet.setNetoGravado(db.getMoney(DBFacturaDet.NETO_GRAVADO));
    facturadet.setNetoNoGravado(db.getMoney(DBFacturaDet.NETO_NO_GRAVADO));
    facturadet.setPedidoDet(PedidoDet.findByOidProxy(db.getInteger(DBFacturaDet.OID_CCO_PED_DET),getSesion()));
    facturadet.setPedidoCab(PedidoCab.findByOidProxy(db.getInteger(DBFacturaDet.OID_CCO_PED),getSesion()));
    facturadet.setRemitoCab(RemitoCab.findByOidProxy(db.getInteger(DBFacturaDet.OID_CCO_REM),getSesion()));
    facturadet.setRemitoDet(RemitoDet.findByOidProxy(db.getInteger(DBFacturaDet.OID_CCO_REM_DET),getSesion()));
    facturadet.setFacturaAplicada(FacturaCab.findByOidProxy(db.getInteger(DBFacturaDet.OID_CCO_FACT_APLIC),getSesion()));
    facturadet.setFacturaDetAplicada(FacturaDet.findByOidProxy(db.getInteger(DBFacturaDet.OID_DET_FACT_APLIC),getSesion()));
    facturadet.setTasaIVA(db.getPorcentaje(DBFacturaDet.TASA_IVA));
    facturadet.setIVA(db.getMoney(DBFacturaDet.IVA));
    
    
    
    

  }
}
