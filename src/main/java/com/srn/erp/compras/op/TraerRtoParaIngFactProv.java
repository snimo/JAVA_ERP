package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.InformeRecepcion;
import com.srn.erp.compras.bm.InformeRecepcionDet;
import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.Proveedor;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;

import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ExceptionValidation;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRtoParaIngFactProv extends Operation { 

  public TraerRtoParaIngFactProv() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	Proveedor proveedor = Proveedor.findByOidProxy(mapaDatos.getInteger("oid_proveedor"), this.getSesion());
	InformeRecepcion infRec = 
		InformeRecepcion.findByOid(mapaDatos.getInteger("oid_inf_rec"), this.getSesion());
	if (infRec == null)
		throw new ExceptionValidation(null,"Remito de Proveedor Inexistente");
	  
	Integer oidCCO = mapaDatos.getInteger("oid_cco");
	IDataSet ds = this.getDataSetDetOC();
	
	Iterator iterDetalles = infRec.getDetallesInfRec().iterator();
	while (iterDetalles.hasNext()) {
		InformeRecepcionDet infRecDet = (InformeRecepcionDet) iterDetalles.next();
		if (infRecDet.isAnulado()) continue;
		if (infRecDet.getInforme_recepcion().isActivo().booleanValue()==false) continue;
		if (infRecDet.isPendFacturar().booleanValue()==false) continue;
		cargarRegistro(ds, oidCCO, infRecDet);
	}
	
	writeCliente(ds);
  }

  private IDataSet getDataSetDetOC() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TComproProvOC");
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("desc_adic", Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_oc",Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_oc_det",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cant_comprada_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_recibida_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_fact_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("cant_pend_fact_uc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("precio_oc",Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_mon_oc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_mon_oc", Field.STRING, 50));
    dataset.fieldDef(new Field("compro_oc", Field.STRING, 100));
    dataset.fieldDef(new Field("codigo_moneda_oc", Field.STRING, 50));
    dataset.fieldDef(new Field("oid_cco", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_conc_fact_prov", Field.INTEGER, 0));
    dataset.fieldDef(new Field("desc_conc_fact_prov", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_inf_rec", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_inf_rec_det", Field.INTEGER, 0));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		                      Integer oidCCO,
		                      InformeRecepcionDet infRecDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_producto", infRecDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", infRecDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", infRecDet.getProducto().getDescripcion());
    dataset.fieldValue("desc_adic", infRecDet.getComentario());
    
    OrdenDeCompraCab oc = null;
    if (infRecDet.getOrdenDeCompraDet()!=null)
    	oc = infRecDet.getOrdenDeCompraDet().getOrden_de_compra();
    
    if (infRecDet.getOrdenDeCompraDet()!=null) {
      dataset.fieldValue("oid_oc",infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getOIDInteger());
      dataset.fieldValue("oid_oc_det", infRecDet.getOrdenDeCompraDet().getOIDInteger());
      dataset.fieldValue("cant_comprada_uc", infRecDet.getOrdenDeCompraDet().getCant_comprada_uc());
      dataset.fieldValue("cant_recibida_uc", infRecDet.getCant_rec_en_uc());
      
    } else {
      dataset.fieldValue("oid_oc",new Integer(0));
      dataset.fieldValue("oid_oc_det", new Integer(0));
      dataset.fieldValue("cant_comprada_uc", new Integer(0));
      dataset.fieldValue("cant_recibida_uc", infRecDet.getCant_rec_en_uc());
    }
    dataset.fieldValue("cant_fact_uc", infRecDet.getCantFactUC());
    dataset.fieldValue("cant_pend_fact_uc", infRecDet.getCantPendFactUC());
    
    if (infRecDet.getOrdenDeCompraDet()!=null) {
        dataset.fieldValue("precio_oc", infRecDet.getOrdenDeCompraDet().getPrecio());
        dataset.fieldValue("oid_mon_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getMoneda().getOIDInteger());
        dataset.fieldValue("cod_mon_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getMoneda().getSimbolo());
        dataset.fieldValue("compro_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getCodigo()+" / "+infRecDet.getInforme_recepcion().getCodigo());
        dataset.fieldValue("codigo_moneda_oc", infRecDet.getOrdenDeCompraDet().getOrden_de_compra().getMoneda().getCodigo());
    } else {
        dataset.fieldValue("precio_oc", new Money(0));
        dataset.fieldValue("oid_mon_oc", new Integer(0));
        dataset.fieldValue("cod_mon_oc", "");
        dataset.fieldValue("compro_oc", infRecDet.getCodigo());
        dataset.fieldValue("codigo_moneda_oc", "");
    }
    dataset.fieldValue("oid_cco", oidCCO);
    
    ConcFactProv concepto = infRecDet.getProducto().getConcFactProvCorrespondiente();
    if (concepto!=null) {
    	dataset.fieldValue("oid_conc_fact_prov", concepto.getOIDInteger());
    	dataset.fieldValue("desc_conc_fact_prov", concepto.getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_conc_fact_prov", 0);
    	dataset.fieldValue("desc_conc_fact_prov", "");
    }
    dataset.fieldValue("oid_inf_rec",infRecDet.getInforme_recepcion().getOIDInteger());
    dataset.fieldValue("oid_inf_rec_det",infRecDet.getOIDInteger());
    
  }
}
