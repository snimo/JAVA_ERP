package com.srn.erp.excelReport.op;

import java.util.Iterator;

import com.srn.erp.excelReport.bm.CategFuncExcel;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerCategFuncExcel extends Operation { 

  public TraerCategFuncExcel() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException { 
	  
	HashTableDatos categorias =  
		CategFuncExcel.getCategoriasFunciones();
	
	IDataSet datasetCateg = this.getDataSetCategFuncExcel();
	Iterator iterCateg = 
		categorias.keySet().iterator();
	while (iterCateg.hasNext()) {
		String codigo = (String) iterCateg.next();
		String descripcion = (String) categorias.get(codigo);
		cargarRegistroCategFunc(datasetCateg, codigo, descripcion);
	}
	
    writeCliente(datasetCateg);
  }

  private IDataSet getDataSetCategFuncExcel() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TCategFuncExcel");
    dataset.fieldDef(new Field("codigo", Field.STRING, 50)); 
    dataset.fieldDef(new Field("descripcion", Field.STRING, 255));
    return dataset;
  }

  private void cargarRegistroCategFunc(IDataSet dataset, 
		  String codigo,
          String descripcion) throws BaseException {	  
    dataset.append(); 
    dataset.fieldValue("codigo", codigo);
    dataset.fieldValue("descripcion", descripcion);
  }
  
}
