package com.srn.erp.excelReport.bl.Factory;

import com.srn.erp.excelReport.bm.FuncionReporteExcel;
import com.srn.erp.excelReport.bm.ParamFuncionReporteExcel;
import com.srn.erp.excelReport.da.DBParamFuncionReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.FactoryObjetoLogico;
import framework.applicarionServer.bl.ObjetosAplicacion.IObjetoLogico;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class FactoryParamFuncionReporteExcel extends FactoryObjetoLogico { 

  public FactoryParamFuncionReporteExcel() { 
  }

  public void cargarObjeto(IObjetoLogico objLog, IDBObjetoPersistente db) throws BaseException {
    ParamFuncionReporteExcel paramfuncionreporteexcel = (ParamFuncionReporteExcel) objLog;
    paramfuncionreporteexcel.setOID(db.getInteger(DBParamFuncionReporteExcel.OID_PARAM_FUNC));
    paramfuncionreporteexcel.setFuncion(FuncionReporteExcel.findByOidProxy(db.getInteger(DBParamFuncionReporteExcel.OID_FUNC_REPO),getSesion()));
    paramfuncionreporteexcel.setOrden(db.getInteger(DBParamFuncionReporteExcel.ORDEN));
    paramfuncionreporteexcel.setTipo_param(db.getString(DBParamFuncionReporteExcel.TIPO_PARAM));
    paramfuncionreporteexcel.setNombre_param(db.getString(DBParamFuncionReporteExcel.NOMBRE_PARAM));
    paramfuncionreporteexcel.setNombre_nickname(db.getString(DBParamFuncionReporteExcel.NOMBRE_NICKNAME));
    paramfuncionreporteexcel.setValor_obj_neg(null);
    paramfuncionreporteexcel.setValor_entero(db.getInteger(DBParamFuncionReporteExcel.VALOR_ENTERO));
    paramfuncionreporteexcel.setValor_decimal(db.getDouble(DBParamFuncionReporteExcel.VALOR_DECIMAL));
    paramfuncionreporteexcel.setValor_string(db.getString(DBParamFuncionReporteExcel.VALOR_STRING));
    paramfuncionreporteexcel.setValor_fecha(db.getDate(DBParamFuncionReporteExcel.VALOR_FECHA));
    paramfuncionreporteexcel.setValor_boolean(db.getBoolean(DBParamFuncionReporteExcel.VALOR_BOOLEAN));
    paramfuncionreporteexcel.setCelda(db.getString(DBParamFuncionReporteExcel.CELDA));
    paramfuncionreporteexcel.setActivo(db.getBoolean(DBParamFuncionReporteExcel.ACTIVO));

  }
}
