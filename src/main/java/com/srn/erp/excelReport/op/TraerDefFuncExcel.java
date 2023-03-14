package com.srn.erp.excelReport.op;


import java.util.Iterator;

import com.srn.erp.excelReport.bm.CategFuncExcel;
import com.srn.erp.excelReport.bm.DefFunExcel;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerDefFuncExcel extends Operation { 

  public TraerDefFuncExcel() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds = getDataSetDefFuncExcel();  
	  
	String categoria =   
		mapaDatos.getString("categoria");
	
	HashTableDatos funciones = null;
	
	if (categoria.equals(CategFuncExcel.TODAS)) 
		funciones = DefFunExcel.getAllFunciones();
	else
		funciones = DefFunExcel.getFuncionesByCategoria(categoria);
	
	Iterator iterDefFunc = 
		funciones.values().iterator();
	while (iterDefFunc.hasNext()) {
		DefFunExcel defFuncExcel = (DefFunExcel) iterDefFunc.next();
		cargarRegistro(ds, defFuncExcel);
	}
	
	writeCliente(ds);
	
  }
	
		
  private IDataSet getDataSetDefFuncExcel() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TFuncionesExcelReport");
    dataset.fieldDef(new Field("token_funcion", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_funcion", Field.STRING, 50));
    dataset.fieldDef(new Field("nombre_y_argumentos", Field.STRING, 1000));
    dataset.fieldDef(new Field("detalle", Field.MEMO, 0));
    dataset.fieldDef(new Field("nombre_formulario", Field.STRING, 100));
    
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
		  					  DefFunExcel defFuncion) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("token_funcion", defFuncion.getToken());
    dataset.fieldValue("nombre_funcion", defFuncion.getNombreFuncion());
    dataset.fieldValue("nombre_y_argumentos", defFuncion.getNombreFuncionyArgumentos());
    dataset.fieldValue("detalle", defFuncion.getDetalles());   
    dataset.fieldValue("nombre_formulario", defFuncion.getNombreFormulario());
  }
}
