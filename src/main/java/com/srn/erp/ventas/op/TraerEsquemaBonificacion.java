package com.srn.erp.ventas.op;

import java.util.Iterator;

import com.srn.erp.ventas.bm.EsquemaBonifProdDet;
import com.srn.erp.ventas.bm.EsquemaBonificacion;
import com.srn.erp.ventas.bm.EsquemaBonificacionClasifProd;
import com.srn.erp.ventas.bm.EsquemaBonificacionProducto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerEsquemaBonificacion extends Operation {

  public TraerEsquemaBonificacion() {
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet dsEsquemaBonificacion = getDataSetEsquemaBonificacion();
	  IDataSet dsEsquemaBonifClasifProd = getDataSetEsquemaBonifClasif();
	  IDataSet dsEsquemaBonifProd = getDataSetEsquemaBonifProd();
	  IDataSet dsEsquemaBonifProdDet = getDataSetEsquemaBonifProdDet();
	  
	  EsquemaBonificacion esquemaBonificacion = EsquemaBonificacion.findByOid(mapaDatos.getInteger("oid"),getSesion());
	  cargarRegistroEsquemaBonif(dsEsquemaBonificacion,esquemaBonificacion,dsEsquemaBonifClasifProd,dsEsquemaBonifProd,dsEsquemaBonifProdDet);
	  
	  writeCliente(dsEsquemaBonificacion);
	  writeCliente(dsEsquemaBonifClasifProd);
	  writeCliente(dsEsquemaBonifProd);
	  writeCliente(dsEsquemaBonifProdDet);
	  
  }

  private IDataSet getDataSetEsquemaBonificacion() {
    IDataSet dataset = new TDataSet();
    dataset.create("TEsquemaBonificacion");
    dataset.fieldDef(new Field("oid_esq_bonif", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo",Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("fec_vig_desde",Field.DATE, 0));
    dataset.fieldDef(new Field("fec_vig_hasta",Field.DATE, 0));
    dataset.fieldDef(new Field("oid_clasif_ent",Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_clasif_ent",Field.STRING, 50));
    dataset.fieldDef(new Field("desc_clasif_ent",Field.STRING, 100));
    dataset.fieldDef(new Field("activo",Field.BOOLEAN,0));
    return dataset;
  }

  private void cargarRegistroEsquemaBonif(IDataSet dataset,
		  						   		  EsquemaBonificacion esquemaBonificacion,
		  						   		  IDataSet dsEsquemaBonifClasifProd,
  										  IDataSet dsEsquemaBonifProd,
  										  IDataSet dsEsquemaBonifProdDet) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_esq_bonif", esquemaBonificacion.getOIDInteger());
    dataset.fieldValue("codigo",esquemaBonificacion.getCodigo());
    dataset.fieldValue("descripcion", esquemaBonificacion.getDescripcion());
    dataset.fieldValue("fec_vig_desde",esquemaBonificacion.getFec_vig_desde());
    dataset.fieldValue("fec_vig_hasta",esquemaBonificacion.getFec_vig_hasta());
    dataset.fieldValue("oid_clasif_ent",esquemaBonificacion.getClasificador_entidad().getOIDInteger());
    dataset.fieldValue("cod_clasif_ent",esquemaBonificacion.getClasificador_entidad().getCodigo());
    dataset.fieldValue("desc_clasif_ent",esquemaBonificacion.getClasificador_entidad().getDescripcion());
    dataset.fieldValue("activo",esquemaBonificacion.isActivo());
    
    Iterator iterBonifClasifProd = esquemaBonificacion.getEsquemasBonifClasifProd().iterator();
    while (iterBonifClasifProd.hasNext()) {
    	EsquemaBonificacionClasifProd esqBonifClasifProd = (EsquemaBonificacionClasifProd) iterBonifClasifProd.next();
    	cargarRegistroEsquemaBonifClasif(dsEsquemaBonifClasifProd,esqBonifClasifProd);
    }
    
    Iterator iterEsquemaBonifProd = esquemaBonificacion.getEsquemasBonifProducto().iterator();
    while (iterEsquemaBonifProd.hasNext()) {
    	EsquemaBonificacionProducto esqBonifProd = (EsquemaBonificacionProducto) iterEsquemaBonifProd.next();
    	cargarRegistroEsquemaBonifProd(dsEsquemaBonifProd,esqBonifProd,dsEsquemaBonifProdDet);
    }
    
  }
  
  private IDataSet getDataSetEsquemaBonifClasif() {
	 IDataSet dataset = new TDataSet();
	 dataset.create("TEsquemaBonifClasif");
	 dataset.fieldDef(new Field("oid_esq_bon_clasif", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("oid_esq_bonif",Field.INTEGER, 0));
	 dataset.fieldDef(new Field("oid_val_clasif_ent", Field.INTEGER, 0));
	 dataset.fieldDef(new Field("fec_desde",Field.DATE, 0));
	 dataset.fieldDef(new Field("fec_hasta",Field.DATE, 0));
	 dataset.fieldDef(new Field("porc_bonif_1", Field.CURRENCY, 0));
	 dataset.fieldDef(new Field("porc_bonif_2", Field.CURRENCY, 0));
	 dataset.fieldDef(new Field("porc_bonif_3", Field.CURRENCY, 0));
	 dataset.fieldDef(new Field("porc_bonif_4", Field.CURRENCY, 0));
	 dataset.fieldDef(new Field("porc_bonif_5", Field.CURRENCY, 0));
	 dataset.fieldDef(new Field("en_cascada", Field.BOOLEAN, 0));
	 dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	 return dataset;
  }
  
  private void cargarRegistroEsquemaBonifClasif(IDataSet dataset,
			   								    EsquemaBonificacionClasifProd esquemaBonifClasifProd) 
			   throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_esq_bon_clasif", esquemaBonifClasifProd.getOIDInteger());
	  dataset.fieldValue("oid_esq_bonif", esquemaBonifClasifProd.getEsquema_bonificacion().getOIDInteger());
	  dataset.fieldValue("oid_val_clasif_ent", esquemaBonifClasifProd.getValor_clasif_entidad().getOIDInteger());
	  dataset.fieldValue("fec_desde", esquemaBonifClasifProd.getFec_desde());
	  dataset.fieldValue("fec_hasta", esquemaBonifClasifProd.getFec_hasta());
	  dataset.fieldValue("porc_bonif_1", esquemaBonifClasifProd.getPorc_bonif_1());
	  dataset.fieldValue("porc_bonif_2", esquemaBonifClasifProd.getPorc_bonif_2());
	  dataset.fieldValue("porc_bonif_3", esquemaBonifClasifProd.getPorc_bonif_3());
	  dataset.fieldValue("porc_bonif_4", esquemaBonifClasifProd.getPorc_bonif_4());
	  dataset.fieldValue("porc_bonif_5", esquemaBonifClasifProd.getPorc_bonif_5());
	  dataset.fieldValue("en_cascada", esquemaBonifClasifProd.isEn_cascada());
	  dataset.fieldValue("activo", esquemaBonifClasifProd.isActivo());
  }
  
  private IDataSet getDataSetEsquemaBonifProd() {
	IDataSet dataset = new TDataSet();
	dataset.create("TEsquemaBonifProd");
	dataset.fieldDef(new Field("oid_esq_bonif_prod", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_esq_bonif",Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_producto",Field.INTEGER, 0));
	dataset.fieldDef(new Field("cod_producto",Field.STRING, 50));
	dataset.fieldDef(new Field("desc_producto",Field.STRING, 100));
	dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	return dataset;
  }
  
  private void cargarRegistroEsquemaBonifProd(IDataSet dataset,
			    EsquemaBonificacionProducto esquemaBonifProd,
			    IDataSet deEsquemaBonifProdDet
			    ) 
  	throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_esq_bonif_prod", esquemaBonifProd.getOIDInteger());
	  dataset.fieldValue("oid_esq_bonif", esquemaBonifProd.getEsquema_bonificacion().getOIDInteger());
	  dataset.fieldValue("oid_producto", esquemaBonifProd.getProducto().getOIDInteger());
	  dataset.fieldValue("cod_producto", esquemaBonifProd.getProducto().getCodigo());
	  dataset.fieldValue("desc_producto", esquemaBonifProd.getProducto().getDescripcion());
	  dataset.fieldValue("activo", esquemaBonifProd.isActivo());
	  
	  Iterator iterEsqBonifProdDet = esquemaBonifProd.getEsquemasBonifProdDet().iterator();
	  while (iterEsqBonifProdDet.hasNext()) {
		  EsquemaBonifProdDet esqBonifProdDet = (EsquemaBonifProdDet) iterEsqBonifProdDet.next();
		  cargarRegistroEsquemaBonifProdDet(deEsquemaBonifProdDet,esqBonifProdDet);
	  }
	  
 }  
  
  private IDataSet getDataSetEsquemaBonifProdDet() {
		IDataSet dataset = new TDataSet();
	dataset.create("TEsqBonifProdDet");
	dataset.fieldDef(new Field("oid_esq_bon_det", Field.INTEGER, 0));
	dataset.fieldDef(new Field("oid_esq_bonif_prod", Field.INTEGER, 0));
	dataset.fieldDef(new Field("fec_desde",Field.DATE, 0));
	dataset.fieldDef(new Field("fec_hasta",Field.DATE, 0));
	dataset.fieldDef(new Field("porc_bonif_1",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("porc_bonif_2",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("porc_bonif_3",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("porc_bonif_4",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("porc_bonif_5",Field.CURRENCY, 0));
	dataset.fieldDef(new Field("en_cascada",Field.BOOLEAN, 0));
	dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	return dataset;
  }
	  
  private void cargarRegistroEsquemaBonifProdDet(IDataSet dataset,
				    EsquemaBonifProdDet esquemaBonifProdDet) 
	  	throws BaseException {
	  dataset.append();
	  dataset.fieldValue("oid_esq_bon_det", esquemaBonifProdDet.getOIDInteger());
	  dataset.fieldValue("oid_esq_bonif_prod", esquemaBonifProdDet.getEsquema_bonif_producto().getOIDInteger());
	  dataset.fieldValue("fec_desde", esquemaBonifProdDet.getFec_desde());
	  dataset.fieldValue("fec_hasta", esquemaBonifProdDet.getFec_hasta());
	  dataset.fieldValue("porc_bonif_1", esquemaBonifProdDet.getPorc_bonif_1());
	  dataset.fieldValue("porc_bonif_2", esquemaBonifProdDet.getPorc_bonif_2());
	  dataset.fieldValue("porc_bonif_3", esquemaBonifProdDet.getPorc_bonif_3());
	  dataset.fieldValue("porc_bonif_4", esquemaBonifProdDet.getPorc_bonif_4());
	  dataset.fieldValue("porc_bonif_5", esquemaBonifProdDet.getPorc_bonif_5());
	  dataset.fieldValue("en_cascada", esquemaBonifProdDet.isEn_cascada());
	  dataset.fieldValue("activo", esquemaBonifProdDet.isActivo());
  }  
	    
  
  
}
