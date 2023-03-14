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

public class TraerReceta extends Operation { 

  private int secu = 0;	
  Producto producto = null;
  public TraerReceta() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    
	Integer oid = mapaDatos.getInteger("oid");
    producto = Producto.findByOidProxy(oid, this.getSesion());
    
    IDataSet datasetRecetaCab = getDataSetRecetaCab();
    IDataSet datasetAlterRecec = this.getDataSetAlterReceta();
    IDataSet datasetRecetaDet = getDataSetRecetaDet();

    cargarRegistroRecetaCab(datasetRecetaCab,producto);
    
    Iterator iterRecetas = 
    	RecetaCab.getRecetasByProducto(producto, this.getSesion()).iterator();
    while (iterRecetas.hasNext()) {
    	RecetaCab recetaCab = 
    		(RecetaCab) iterRecetas.next();
    	
    	cargarRegistroAlterReceta(datasetAlterRecec,recetaCab);
    	
    	Iterator iterRecetasDet =
    		recetaCab.getRecetasDet().iterator();
    	while (iterRecetasDet.hasNext()) {
    		RecetaDet recetaDet = (RecetaDet) iterRecetasDet.next();
    		cargarRegistroRecetaDet(datasetRecetaDet, recetaDet);
    	}
    	
    	
    }
    
    writeCliente(datasetRecetaCab);
    writeCliente(datasetAlterRecec);
    writeCliente(datasetRecetaDet);
    
  }

  private IDataSet getDataSetRecetaCab() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecetaCab");
    dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroRecetaCab(IDataSet dataset,
		  							   Producto producto) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_rec_cab", producto.getOIDInteger());
    dataset.fieldValue("oid_producto", producto.getOIDInteger());
    dataset.fieldValue("cod_producto", producto.getCodigo());
    dataset.fieldValue("desc_producto", producto.getDescripcion());
    dataset.fieldValue("activo", new Boolean(true));
  }
  
  private IDataSet getDataSetRecetaDet() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TRecetaDet");
    dataset.fieldDef(new Field("oid_rec_det", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_alternativa_det", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50)); 
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
    return dataset;
  }
  
  private IDataSet getDataSetAlterReceta() { 
	    IDataSet dataset = new TDataSet(); 
	    dataset.create("TAlternativas");
	    dataset.fieldDef(new Field("oid_alternativa_det", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("orden", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("oid_rec_cab", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("alternativa", Field.STRING, 20));
	    dataset.fieldDef(new Field("oid_rec_cab_ori", Field.INTEGER, 0));
	    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0));
	    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
	    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
	    return dataset;
  }
  
  private void cargarRegistroAlterReceta(IDataSet dataset, 
          								 RecetaCab receta) throws BaseException  {
	  dataset.append();
	  dataset.fieldValue("oid_alternativa_det", receta.getOIDInteger());
	  dataset.fieldValue("orden", new Integer(++secu)); 
	  dataset.fieldValue("oid_rec_cab", receta.getProduco().getOIDInteger());
	  dataset.fieldValue("alternativa", receta.getAlternativa());
	  dataset.fieldValue("oid_rec_cab_ori", receta.getOIDInteger());
	  dataset.fieldValue("activo", receta.isActivo());
	  dataset.fieldValue("cantidad", receta.getBase_calculo());
	  dataset.fieldValue("oid_um", receta.getOid_um().getOIDInteger());

  }
  
  

  private void cargarRegistroRecetaDet(IDataSet dataset, 
                         RecetaDet recetaDet) throws BaseException  {
    dataset.append();
    dataset.fieldValue("oid_rec_det", recetaDet.getOIDInteger()); 
    dataset.fieldValue("oid_alternativa_det", recetaDet.getReceta_cab().getOIDInteger());
    dataset.fieldValue("oid_producto", recetaDet.getProducto().getOIDInteger());
    dataset.fieldValue("cod_producto", recetaDet.getProducto().getCodigo());
    dataset.fieldValue("desc_producto", recetaDet.getProducto().getDescripcion());
    dataset.fieldValue("oid_um", recetaDet.getOid_um().getOIDInteger());
    dataset.fieldValue("cantidad", recetaDet.getCantidad());
    dataset.fieldValue("activo", recetaDet.isActivo());
    dataset.fieldValue("orden", recetaDet.getOrden());
    		
  }

  
}
