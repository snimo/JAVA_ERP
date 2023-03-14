package com.srn.erp.excelReport.op;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.ResultFuncExcel;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class ExecFuncExcel extends Operation { 

  public ExecFuncExcel() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	IDataSet ds = getDataSetExcelReport();
	String funcion = mapaDatos.getString("funcion");
	ResultFuncExcel resultado = ExcelReport.execFunc(funcion,this.getSesion());
	cargarRegistro(ds, resultado.getResult(),resultado.getTipo());
	writeCliente(ds);
	  
  }

  private IDataSet getDataSetExcelReport() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TResultadoFuncion");
    dataset.fieldDef(new Field("resultado", Field.MEMO, 0));
    dataset.fieldDef(new Field("tipo", Field.STRING, 50));
    return dataset;
  }

  private void cargarRegistro(IDataSet dataset, 
                         String resultado,
                         String tipo) throws BaseException {
    dataset.append(); 
    dataset.fieldValue("resultado", resultado);
    dataset.fieldValue("tipo", tipo);
    
  }
}
