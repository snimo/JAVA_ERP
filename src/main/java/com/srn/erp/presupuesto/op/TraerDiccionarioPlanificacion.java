package com.srn.erp.presupuesto.op;

import java.util.Iterator;

import com.srn.erp.presupuesto.bm.AtributoDiccionario;
import com.srn.erp.presupuesto.bm.DiccionarioPlanificacion;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDiccionarioPlanificacion extends Operation { 

  public TraerDiccionarioPlanificacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
  	
  	IDataSet datasetDiccionarioPlanificacion = getDataSetDiccionarioPlanificacion();
  	IDataSet dsAtributo = getDataSetAtributo();
  	
  	Iterator iterDiccionario = 
  		DiccionarioPlanificacion.getAllActivos(this.getSesion()).iterator();
  	while (iterDiccionario.hasNext()) {
  		DiccionarioPlanificacion diccionario = (DiccionarioPlanificacion) iterDiccionario.next();
  		cargarRegistroDiccionarioPlanificacion(datasetDiccionarioPlanificacion,diccionario);
  		if ((diccionario.getAtributo_diccionario()!=null) &&
  		   (diccionario.getTipo_item().equals(AtributoDiccionario.TIPO_ATRI_DATO)))
  			  cargarRegistroAtributo(dsAtributo,diccionario.getAtributo_diccionario());
  	}
  	
    writeCliente(datasetDiccionarioPlanificacion);
    writeCliente(dsAtributo);
    
  }

  private IDataSet getDataSetDiccionarioPlanificacion() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TDiccionarioPlanificacion");
    dataset.fieldDef(new Field("oid_diccionario", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_relacion", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("nro_relacion_padre", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("tipo_item", Field.STRING, 20)); 
    dataset.fieldDef(new Field("titulo", Field.STRING, 100)); 
    dataset.fieldDef(new Field("oid_atri_dicc", Field.STRING, 0)); 
    dataset.fieldDef(new Field("orden", Field.INTEGER, 0)); 
    dataset.fieldDef(new Field("activo", Field.BOOLEAN, 0)); 
    return dataset;
  }

  private void cargarRegistroDiccionarioPlanificacion(IDataSet dataset, 
                         DiccionarioPlanificacion diccionario) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("oid_diccionario", diccionario.getOIDInteger());
    dataset.fieldValue("nro_relacion", diccionario.getNro_relacion());
    dataset.fieldValue("nro_relacion_padre", diccionario.getNro_relacion_padre());
    dataset.fieldValue("tipo_item", diccionario.getTipo_item());
    dataset.fieldValue("titulo", diccionario.getTitulo());
    if (diccionario.getAtributo_diccionario()!=null)
    	dataset.fieldValue("oid_atri_dicc", diccionario.getAtributo_diccionario().getOIDInteger());
    else
    	dataset.fieldValue("oid_atri_dicc", new Integer(0));
    dataset.fieldValue("orden", diccionario.getOrden());
    dataset.fieldValue("activo", diccionario.isActivo());
  }
  
  private IDataSet getDataSetAtributo() {
  	
    IDataSet dataset = new TDataSet(); 
    dataset.create("TAtributoDiccionario");
    dataset.fieldDef(new Field("oid_atri_dicc", Field.INTEGER, 0));
    dataset.fieldDef(new Field("codigo",Field.STRING, 50));
    dataset.fieldDef(new Field("descripcion", Field.STRING, 100));
    dataset.fieldDef(new Field("desc_adic",Field.STRING, 255));
    dataset.fieldDef(new Field("tipo_atributo",Field.STRING, 20));
    dataset.fieldDef(new Field("campo_fecha",Field.DATE,0));
    dataset.fieldDef(new Field("campo_integer",Field.INTEGER,0));
    dataset.fieldDef(new Field("campo_decimal",Field.CURRENCY,0));
    dataset.fieldDef(new Field("campo_string",Field.STRING,255));
    dataset.fieldDef(new Field("campo_boolean", Field.BOOLEAN,0));
    
    dataset.fieldDef(new Field("oid_compo_presu", Field.INTEGER,0));
    dataset.fieldDef(new Field("cod_compo_presu", Field.STRING,50));
    dataset.fieldDef(new Field("desc_compo_presu", Field.STRING,100));
    
    dataset.fieldDef(new Field("oid_valor_compo_presu", Field.INTEGER,0));
    dataset.fieldDef(new Field("cod_valor_compo_presu", Field.STRING,50));
    dataset.fieldDef(new Field("desc_valor_compo_presu", Field.STRING,100));
    dataset.fieldDef(new Field("activo", Field.BOOLEAN,0));
    
    return dataset;
  }
  
  private void cargarRegistroAtributo(IDataSet dataset, 
      AtributoDiccionario atributo) throws BaseException {
  	dataset.append();
  	dataset.fieldValue("oid_atri_dicc", atributo.getOIDInteger());
  	dataset.fieldValue("codigo", atributo.getCodigo());
  	dataset.fieldValue("descripcion", atributo.getDescripcion());
  	dataset.fieldValue("desc_adic", atributo.getDesc_adic());
  	dataset.fieldValue("tipo_atributo", atributo.getTipo_atributo());	
  	dataset.fieldValue("campo_fecha", atributo.getCampo_fecha());
  	dataset.fieldValue("campo_integer", atributo.getCampo_integer());
  	dataset.fieldValue("campo_decimal", atributo.getCampo_decimal());
  	dataset.fieldValue("campo_string", atributo.getCampo_string());
  	dataset.fieldValue("campo_boolean", atributo.getCampo_boolean());
  	
    if (atributo.getCompo_presu()!=null) {
  	  dataset.fieldValue("oid_compo_presu", atributo.getCompo_presu().getOIDInteger());
  	  dataset.fieldValue("cod_compo_presu", atributo.getCompo_presu().getCodigo());
  	  dataset.fieldValue("desc_compo_presu", atributo.getCompo_presu().getDescripcion());
    } else {
  	  dataset.fieldValue("oid_compo_presu", new Integer(0));
  	  dataset.fieldValue("cod_compo_presu", "");
  	  dataset.fieldValue("desc_compo_presu", "");
    }
    
    if (atributo.getValorCompoPresu()!=null) {
  	  dataset.fieldValue("oid_valor_compo_presu", atributo.getValorCompoPresu().getOIDInteger());
  	  dataset.fieldValue("cod_valor_compo_presu", atributo.getValorCompoPresu().getCodigo());
  	  dataset.fieldValue("desc_valor_compo_presu", atributo.getValorCompoPresu().getDescripcion());
    } else {
  	  dataset.fieldValue("oid_valor_compo_presu", new Integer(0));
  	  dataset.fieldValue("cod_valor_compo_presu", "");
  	  dataset.fieldValue("desc_valor_compo_presu", "");
    }
    dataset.fieldValue("activo", atributo.isActivo());
 }
  
  
  
}
