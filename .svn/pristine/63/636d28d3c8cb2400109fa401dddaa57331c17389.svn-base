package com.srn.erp.cip.op;

import java.util.Iterator;

import com.srn.erp.cip.bm.Cacheo;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerTipoCacheoEntSal extends Operation { 

  public TraerTipoCacheoEntSal() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet dsCacheoEntrada = getDataSetCacheoEntrada();
	  IDataSet dsCacheoSalida = getDataSetCacheoSalida();
	  
	  
	  HashTableDatos tiposCacheos = Cacheo.getTiposCacheoEgresos();
	  
	  Iterator iterTiposCacheos = 
		  Cacheo.getTiposCacheoEgresos().keySet().iterator();
	  while (iterTiposCacheos.hasNext()) {
		  String codigo = (String) iterTiposCacheos.next();
		  String descripcion = (String) tiposCacheos.get(codigo);
		  cargarRegistroCacheoSalida(dsCacheoSalida,codigo,descripcion);
	  }
	  
	  tiposCacheos = Cacheo.getTiposCacheoIngresos();
	  
	  iterTiposCacheos = 
		  Cacheo.getTiposCacheoIngresos().keySet().iterator();
	  while (iterTiposCacheos.hasNext()) {
		  String codigo = (String) iterTiposCacheos.next();
		  String descripcion = (String) tiposCacheos.get(codigo);
		  cargarRegistroCacheoEntrada(dsCacheoEntrada,codigo,descripcion);
	  }	  
	  
	  writeCliente(dsCacheoEntrada);
	  writeCliente(dsCacheoSalida);
	  
  }

  private IDataSet getDataSetCacheoEntrada() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TTipoCacheoEntrada");
    dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
    return dataset;
  }
  
  private IDataSet getDataSetCacheoSalida() { 
	IDataSet dataset = new TDataSet(); 
	dataset.create("TTipoCacheoSalida");
	dataset.fieldDef(new Field("codigo", Field.STRING, 20)); 
	dataset.fieldDef(new Field("descripcion", Field.STRING, 50)); 
	return dataset;
  }  
  
  private void cargarRegistroCacheoEntrada
  	(IDataSet dataset, 
     String codigo,
     String descripcion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
  
  private void cargarRegistroCacheoSalida
	(IDataSet dataset, 
   String codigo,
   String descripcion) throws BaseException {
	  dataset.append(); 
	  dataset.fieldValue("codigo", codigo);
	  dataset.fieldValue("descripcion", descripcion);
  }  
  
}
