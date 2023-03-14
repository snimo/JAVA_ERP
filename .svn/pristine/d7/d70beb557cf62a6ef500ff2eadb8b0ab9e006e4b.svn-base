package com.srn.erp.excelReport.bl.Factory;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.GrupoReporteExcel;
import com.srn.erp.excelReport.da.DBExcelReport;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryExcelReport extends FactoryObjetoLogico { 

  public FactoryExcelReport() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ExcelReport excelreport = (ExcelReport) objLog;
    excelreport.setOID(db.getInteger(DBExcelReport.OID_REPORTE));
    excelreport.setCodigo(db.getString(DBExcelReport.CODIGO));
    excelreport.setDescripcion(db.getString(DBExcelReport.DESCRIPCION));
    excelreport.setActivo(db.getBoolean(DBExcelReport.ACTIVO));
    excelreport.setGrupoReporteExcel(GrupoReporteExcel.findByOid(db.getInteger(DBExcelReport.OID_GRUPO_REPORTE), this.getSesion()));
    excelreport.setOrden(db.getInteger(DBExcelReport.ORDEN));
  }
}
