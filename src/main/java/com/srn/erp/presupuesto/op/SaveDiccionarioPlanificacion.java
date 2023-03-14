package com.srn.erp.presupuesto.op;

import com.srn.erp.presupuesto.bm.AtributoDiccionario;
import com.srn.erp.presupuesto.bm.CompoPresupuestario;
import com.srn.erp.presupuesto.bm.DiccionarioPlanificacion;
import com.srn.erp.presupuesto.bm.ValorCompoPresu;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;

public class SaveDiccionarioPlanificacion extends Operation { 

  public SaveDiccionarioPlanificacion() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
    IDataSet dataset = mapaDatos.getDataSet("TDiccionarioPlanificacion"); 
    procesarRegistros(dataset); 
  } 

  private void procesarRegistros(IDataSet dataset) throws BaseException { 
    dataset.first(); 
      while (!dataset.EOF()) { 
        DiccionarioPlanificacion diccionarioplanificacion = DiccionarioPlanificacion.findByOid(dataset.getInteger("oid_diccionario"),getSesion());
        diccionarioplanificacion.setOID(dataset.getInteger("oid_diccionario"));
        diccionarioplanificacion.setNro_relacion(dataset.getInteger("nro_relacion"));
        diccionarioplanificacion.setNro_relacion_padre(dataset.getInteger("nro_relacion_padre"));
        diccionarioplanificacion.setTipo_item(dataset.getString("tipo_item"));
        diccionarioplanificacion.setTitulo(dataset.getString("titulo"));
        diccionarioplanificacion.setAtributo_diccionario(AtributoDiccionario.findByOidProxy(dataset.getInteger("oid_atri_dicc"),this.getSesion()));
        diccionarioplanificacion.setOrden(dataset.getInteger("orden"));
        diccionarioplanificacion.setActivo(dataset.getBoolean("activo"));
        
        IDataSet dsAtributos = dataset.getDataSet("TAtributoDiccionario");
        dsAtributos.first();
        while (!dsAtributos.EOF()) {
        	
        	AtributoDiccionario atributo = 
        		AtributoDiccionario.findByOid(dsAtributos.getInteger("oid_atri_dicc"),this.getSesion());
        	
        	atributo.setCodigo(dsAtributos.getString("codigo"));
        	atributo.setDescripcion(dsAtributos.getString("descripcion"));
        	atributo.setDesc_adic(dsAtributos.getString("desc_adic"));
        	atributo.setTipo_atributo(dsAtributos.getString("tipo_atributo"));
        	atributo.setCampo_fecha(dsAtributos.getDate("campo_fecha"));
        	atributo.setCampo_integer(dsAtributos.getInteger("campo_integer"));
        	atributo.setCampo_decimal(dsAtributos.getDouble("campo_decimal"));
        	atributo.setCampo_string(dsAtributos.getString("campo_string"));
        	atributo.setCampo_boolean(dsAtributos.getBoolean("campo_boolean"));
        	atributo.setCompo_presu(CompoPresupuestario.findByOidProxy(dsAtributos.getInteger("oid_compo_presu"),this.getSesion()));
        	atributo.setValorCompoPresu(ValorCompoPresu.findByOidProxy(dsAtributos.getInteger("oid_valor_compo_presu"),this.getSesion()));
        	atributo.setActivo(dsAtributos.getBoolean("activo"));
        	if (atributo.isActivo().booleanValue()==false) atributo.delete();
        	diccionarioplanificacion.setAtributo_diccionario(atributo);
        	
        	this.addTransaccion(atributo);
        	
        	dsAtributos.next();
        }
        
        addTransaccion(diccionarioplanificacion);
        dataset.next();
    }
  }
  
}
