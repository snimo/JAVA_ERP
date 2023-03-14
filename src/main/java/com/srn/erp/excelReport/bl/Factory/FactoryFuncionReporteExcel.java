package com.srn.erp.excelReport.bl.Factory;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.FuncionReporteExcel;
import com.srn.erp.excelReport.da.DBFuncionReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryFuncionReporteExcel extends FactoryObjetoLogico { 

  public FactoryFuncionReporteExcel() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    FuncionReporteExcel funcionreporteexcel = (FuncionReporteExcel) objLog;
    funcionreporteexcel.setOID(db.getInteger(DBFuncionReporteExcel.OID_FUNC_REPO));
    funcionreporteexcel.setReporte(ExcelReport.findByOidProxy(db.getInteger(DBFuncionReporteExcel.OID_REPORTE),getSesion()));
    funcionreporteexcel.setOrden(db.getInteger(DBFuncionReporteExcel.ORDEN));
    funcionreporteexcel.setToken_funcion(db.getString(DBFuncionReporteExcel.TOKEN_FUNCION));
    funcionreporteexcel.setComentario(db.getString(DBFuncionReporteExcel.COMENTARIO));
    funcionreporteexcel.setCelda_destino(db.getString(DBFuncionReporteExcel.CELDA_DESTINO));
    funcionreporteexcel.setActivo(db.getBoolean(DBFuncionReporteExcel.ACTIVO));
    funcionreporteexcel.setFuncion(db.getString(DBFuncionReporteExcel.FUNCION));

  }
}
