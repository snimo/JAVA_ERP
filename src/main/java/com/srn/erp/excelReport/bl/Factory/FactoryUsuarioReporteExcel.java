package com.srn.erp.excelReport.bl.Factory;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.UsuarioReporteExcel;
import com.srn.erp.excelReport.da.DBUsuarioReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;

public class FactoryUsuarioReporteExcel extends FactoryObjetoLogico { 

  public FactoryUsuarioReporteExcel() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    UsuarioReporteExcel usuarioreporteexcel = (UsuarioReporteExcel) objLog;
    usuarioreporteexcel.setOID(db.getInteger(DBUsuarioReporteExcel.OID_ROL_REPORTE));
    usuarioreporteexcel.setReporte(ExcelReport.findByOidProxy(db.getInteger(DBUsuarioReporteExcel.OID_REPORTE),getSesion()));
    usuarioreporteexcel.setLectura(db.getBoolean(DBUsuarioReporteExcel.LECTURA));
    usuarioreporteexcel.setModificacion(db.getBoolean(DBUsuarioReporteExcel.MODIF));
    usuarioreporteexcel.setGrabacion(db.getBoolean(DBUsuarioReporteExcel.GRABACION));
    usuarioreporteexcel.setActivo(db.getBoolean(DBUsuarioReporteExcel.ACTIVO));
    usuarioreporteexcel.setUsuario(Usuario.findByOidProxy(db.getInteger(DBUsuarioReporteExcel.OID_USUARIO),getSesion()));

  }
}
