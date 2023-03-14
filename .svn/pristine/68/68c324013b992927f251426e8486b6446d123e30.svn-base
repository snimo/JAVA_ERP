package com.srn.erp.excelReport.bl.Factory;

import com.srn.erp.excelReport.bm.GrupoReporteExcel;
import com.srn.erp.excelReport.da.DBGrupoReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryGrupoReporteExcel extends FactoryObjetoLogico { 

  public FactoryGrupoReporteExcel() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    GrupoReporteExcel gruporeporteexcel = (GrupoReporteExcel) objLog;
    gruporeporteexcel.setOID(db.getInteger(DBGrupoReporteExcel.OID_GRUPO_REPORTE));
    gruporeporteexcel.setCodigo(db.getString(DBGrupoReporteExcel.CODIGO));
    gruporeporteexcel.setDescripcion(db.getString(DBGrupoReporteExcel.DESCRIPCION));
    gruporeporteexcel.setOrden(db.getInteger(DBGrupoReporteExcel.ORDEN));
    gruporeporteexcel.setActivo(db.getBoolean(DBGrupoReporteExcel.ACTIVO));

  }
}
