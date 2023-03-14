package com.srn.erp.stock.op;

import com.srn.erp.stock.bm.PedMercDepoDet;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.UnidadMedida;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerSeleccionProdPedPorDepo extends Operation { 

  public TraerSeleccionProdPedPorDepo() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  
  	IDataSet dsProdSeleccionados = this.getDSProductosSeleccionados();
  	
  	IDataSet ds = mapaDatos.getDataSet("TPedDepoPendEnv");
  	ds.first();
  	while (!ds.EOF()) {
  		
  		if (!ds.getBoolean("sel")) { 
  			ds.next();	
  			continue;
  		}
  		
  		Producto producto = Producto.findByOid(ds.getInteger("oid_producto"), this.getSesion());
  		String observacion = ds.getString("observacion");
  		UnidadMedida um = UnidadMedida.findByOid(ds.getInteger("oid_um"), this.getSesion());
  		Double cantidad = ds.getDouble("cant_pend_envio");
  		PedMercDepoDet pedMercDepoDet =
  			PedMercDepoDet.findByOidProxy(ds.getInteger("oid_ped_merc_det"), this.getSesion());
  		java.util.Date fecha = ds.getDate("fec_necesidad");
  		
  		cargarRegistro(dsProdSeleccionados, producto, observacion, um, cantidad, pedMercDepoDet,fecha);
  		
  		ds.next();	
  	}
  	
  	
  	writeCliente(dsProdSeleccionados);
  }

  private IDataSet getDSProductosSeleccionados() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TProductosSeleccionados");
    dataset.fieldDef(new Field("oid_producto", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cod_producto", Field.STRING, 50));
    dataset.fieldDef(new Field("desc_producto", Field.STRING, 255));
    dataset.fieldDef(new Field("observacion", Field.MEMO, 0));
    dataset.fieldDef(new Field("oid_um", Field.INTEGER, 0));
    dataset.fieldDef(new Field("cantidad", Field.CURRENCY, 0));
    dataset.fieldDef(new Field("oid_ped_depo_det", Field.INTEGER, 0));
    dataset.fieldDef(new Field("fec_necesidad", Field.DATE, 0));
    return dataset;
  }

  private void cargarRegistro(
		  IDataSet dataset,
		  Producto producto,
		  String observacion,
		  UnidadMedida um,
		  Double cantidad,
		  PedMercDepoDet pedMercDepoDet,
		  java.util.Date fecha) throws BaseException {
	  
	  dataset.append();
	  dataset.fieldValue("oid_producto", producto.getOIDInteger());
	  dataset.fieldValue("cod_producto", producto.getCodigo());
	  dataset.fieldValue("desc_producto", producto.getDescripcion());
	  dataset.fieldValue("observacion", observacion);
	  dataset.fieldValue("oid_um", um.getOIDInteger());
	  dataset.fieldValue("cantidad", cantidad);
	  dataset.fieldValue("oid_ped_depo_det", pedMercDepoDet.getOIDInteger());
	  dataset.fieldValue("fec_necesidad", fecha);
  }  
  
}
