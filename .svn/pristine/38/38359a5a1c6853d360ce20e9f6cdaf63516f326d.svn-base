package com.srn.erp.produccion.op;

import java.util.Iterator;

import com.srn.erp.produccion.bm.RecetaCab;
import com.srn.erp.produccion.bm.RecetaDet;
import com.srn.erp.stock.bm.Producto;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerHelpRecetaFabProd extends Operation { 

  public TraerHelpRecetaFabProd() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
     
	  Integer oidProducto = mapaDatos.getInteger("oid_producto");
	  Producto producto = Producto.findByOidProxy(oidProducto, this.getSesion());
	  
	  IDataSet dsRecetaCab = this.getDataSetRecFabProdCab();
	  IDataSet dsRecetaDet = this.getDataSetRecFabProdDet();
	  
	  Iterator iterRecetas = 
		  RecetaCab.getRecetasByProducto(producto, this.getSesion()).iterator();
	  while (iterRecetas.hasNext()) {
		  RecetaCab receta = (RecetaCab) iterRecetas.next();
		  cargarRegistroRecetaCab(dsRecetaCab, receta);
		  
		  Iterator iterRecetasDet = 
			  receta.getRecetasDet().iterator();
		  while (iterRecetasDet.hasNext()) {
			  RecetaDet recetaDet = (RecetaDet) iterRecetasDet.next();
			  if (!recetaDet.isActivo()) continue;
			  cargarRegistroRecetaDet(dsRecetaDet, recetaDet);
		  }
			  
	  }
	  
	  writeCliente(dsRecetaCab);
	  writeCliente(dsRecetaDet);
		  
  }

  private IDataSet getDataSetRecFabProdCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("THelpRecetaCab");
    dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0));
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("base_calculo", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_um", Field.STRING, 20));
    dataset.fieldDef(new Field("alternativa", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
    return dataset;
  }
  

  private void cargarRegistroRecetaCab(IDataSet dataset, 
                         			   RecetaCab receta) throws BaseException {
    dataset.append();
    dataset.fieldValue("oid_rec_cab", receta.getOIDInteger());
    dataset.fieldValue("oid_producto", receta.getProduco().getOIDInteger());
    dataset.fieldValue("cod_producto", receta.getProduco().getCodigo());
    dataset.fieldValue("desc_producto", receta.getProduco().getDescripcion());
    dataset.fieldValue("base_calculo", receta.getBase_calculo());
    dataset.fieldValue("oid_um", receta.getOid_um().getOIDInteger());
    dataset.fieldValue("cod_um", receta.getOid_um().getCodigo());
    dataset.fieldValue("alternativa", receta.getAlternativa());
    dataset.fieldValue("activo", receta.isActivo());
  }
  
  
  private IDataSet getDataSetRecFabProdDet() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("THelpRecetaDet");
	    dataset.fieldDef(new Field("oid_rec_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
	    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
	    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("cod_um", Field.STRING, 20));
	    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("activo",Field.BOOLEAN, 0));
	    return dataset;
	  }
  
  
  private void cargarRegistroRecetaDet(IDataSet dataset, 
		   RecetaDet recetaDet) throws BaseException {

	  dataset.append();
	  dataset.fieldValue("oid_rec_det", recetaDet.getOIDInteger());
	  dataset.fieldValue("orden", recetaDet.getOrden());
	  dataset.fieldValue("oid_rec_cab", recetaDet.getReceta_cab().getOIDInteger());
	  dataset.fieldValue("oid_producto", recetaDet.getProducto().getOIDInteger());
	  dataset.fieldValue("cod_producto", recetaDet.getProducto().getCodigo());
	  dataset.fieldValue("desc_producto", recetaDet.getProducto().getDescripcion());
	  dataset.fieldValue("oid_um", recetaDet.getOid_um().getOIDInteger());
	  dataset.fieldValue("cod_um", recetaDet.getOid_um().getCodigo());
	  dataset.fieldValue("cantidad", recetaDet.getCantidad());
	  dataset.fieldValue("activo", recetaDet.isActivo());
	  
  }
  
  
}
