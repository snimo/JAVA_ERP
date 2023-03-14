package com.srn.erp.excelReport.op;


import java.util.Iterator;

import com.srn.erp.excelReport.bm.ExcelReport;

import framework.request.bl.Operaciones.Operation;
import framework.request.bl.Tablas.Field;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;
import framework.request.bl.XML.IDataSet;
import framework.request.bl.XML.TDataSet;

public class TraerRepExcelUsuario extends Operation { 

  public TraerRepExcelUsuario() { 
  }

  public void execute(MapDatos mapaDatos) throws BaseException {
	  
	  IDataSet ds = this.getDataSetExcelReport();
	  Iterator iterReportes = 
		  ExcelReport.getReportesUsuario(this.getSesion()).iterator();
	  while (iterReportes.hasNext()) {
		  ExcelReport excel = (ExcelReport) iterReportes.next();
		  cargarReporte(ds, excel);
	  }
	  writeCliente(ds);

      
  }

  private IDataSet getDataSetExcelReport() { 
    IDataSet dataset = new TDataSet(); 
    dataset.create("TInformes");
    dataset.fieldDef(new Field("orden_titulo", Field.INTEGER, 0));
    dataset.fieldDef(new Field("orden_reporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("titulo", Field.STRING, 100));
    dataset.fieldDef(new Field("oid_reporte", Field.INTEGER, 0));
    dataset.fieldDef(new Field("reporte", Field.STRING, 100));
    return dataset;
  }
  
  private void cargarReporte(IDataSet ds,ExcelReport reporte) throws BaseException {
	 ds.append();
	 ds.fieldValue("orden_titulo", reporte.getGrupoReporteExcel().getOrden());
	 ds.fieldValue("orden_reporte", reporte.getOrden());
	 ds.fieldValue("titulo", reporte.getGrupoReporteExcel().getDescripcion());
	 ds.fieldValue("oid_reporte", reporte.getOIDInteger());
	 ds.fieldValue("reporte", reporte.getDescripcion());
  }
  

}
