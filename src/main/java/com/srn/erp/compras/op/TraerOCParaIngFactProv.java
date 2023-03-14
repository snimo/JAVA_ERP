package com.srn.erp.compras.op;

import java.util.Iterator;

import com.srn.erp.compras.bm.OrdenDeCompraCab;
import com.srn.erp.compras.bm.OrdenDeCompraDet;
import com.srn.erp.ctasAPagar.bm.ConcFactProv;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerOCParaIngFactProv extends Operation { 

  public TraerOCParaIngFactProv() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	OrdenDeCompraCab oc = OrdenDeCompraCab.findByOidProxy(mapaDatos.getInteger("oid_oc"), this.getSesion());
	Integer oidCCO = mapaDatos.getInteger("oid_cco");
	IDataSet ds = this.getDataSetDetOC();
	
	Iterator iterDetalles = oc.getDetallesOC().iterator();
	while (iterDetalles.hasNext()) {
		OrdenDeCompraDet ocDet = (OrdenDeCompraDet) iterDetalles.next();
		if (ocDet.isAnulado()) continue;
		if (ocDet.getOrden_de_compra().isActivo().booleanValue()==false) continue;
		if (ocDet.isPendFact().booleanValue()==false) continue;
		cargarRegistro(ds, oidCCO, ocDet);
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
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset,
		                      Integer oidCCO,
		                      OrdenDeCompraDet ocDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_producto", ocDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", ocDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", ocDet.getProducto().getDescripcion());
    dataset.fieldValue("desc_adic", ocDet.getDesc_adic_sku());
    dataset.fieldValue("oid_oc",ocDet.getOrden_de_compra().getOIDInteger());
    dataset.fieldValue("oid_oc_det", ocDet.getOIDInteger());
    dataset.fieldValue("cant_comprada_uc", ocDet.getCant_comprada_uc());
    dataset.fieldValue("cant_recibida_uc", ocDet.getCantRecepUC());
    dataset.fieldValue("cant_fact_uc", ocDet.getCantFactUC());
    dataset.fieldValue("cant_pend_fact_uc", ocDet.getCantPendFactUC()); 
    dataset.fieldValue("precio_oc", ocDet.getPrecio());
    dataset.fieldValue("oid_mon_oc", ocDet.getOrden_de_compra().getMoneda().getOIDInteger());
    dataset.fieldValue("cod_mon_oc", ocDet.getOrden_de_compra().getMoneda().getSimbolo());
    dataset.fieldValue("compro_oc", ocDet.getOrden_de_compra().getCodigo());
    dataset.fieldValue("codigo_moneda_oc", ocDet.getOrden_de_compra().getMoneda().getCodigo());
    dataset.fieldValue("oid_cco", oidCCO);
    
    ConcFactProv concepto = ocDet.getProducto().getConcFactProvCorrespondiente();
    if (concepto!=null) {
    	dataset.fieldValue("oid_conc_fact_prov", concepto.getOIDInteger());
    	dataset.fieldValue("desc_conc_fact_prov", concepto.getDescripcion());
    }
    else {
    	dataset.fieldValue("oid_conc_fact_prov", 0);
    	dataset.fieldValue("desc_conc_fact_prov", "");
    }
    
  }
}
