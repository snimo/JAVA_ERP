package com.srn.erp.excelReport.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.excelReport.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBParamFuncionReporteExcel extends DBObjetoPersistente {

  public static final String OID_PARAM_FUNC = "oid_param_func";
  public static final String OID_FUNC_REPO = "oid_func_repo";
  public static final String ORDEN = "orden";
  public static final String TIPO_PARAM = "tipo_param";
  public static final String NOMBRE_PARAM = "nombre_param";
  public static final String NOMBRE_NICKNAME = "nombre_nickname";
  public static final String OID_VAL_ON = "oid_val_on";
  public static final String VALOR_ENTERO = "valor_entero";
  public static final String VALOR_DECIMAL = "valor_decimal";
  public static final String VALOR_STRING = "valor_string";
  public static final String VALOR_FECHA = "valor_fecha";
  public static final String VALOR_BOOLEAN = "valor_boolean";
  public static final String CELDA = "celda";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_FUNCION_REPORTE = 100;

  public DBParamFuncionReporteExcel() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PARAM_FUNC = 1;
    final int OID_FUNC_REPO = 2;
    final int ORDEN = 3;
    final int TIPO_PARAM = 4;
    final int NOMBRE_PARAM = 5;
    final int NOMBRE_NICKNAME = 6;
    final int OID_VAL_ON = 7;
    final int VALOR_ENTERO = 8;
    final int VALOR_DECIMAL = 9;
    final int VALOR_STRING = 10;
    final int VALOR_FECHA = 11;
    final int VALOR_BOOLEAN = 12;
    final int CELDA = 13;
    final int ACTIVO = 14;

    ParamFuncionReporteExcel pers = (ParamFuncionReporteExcel) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into exParamFuncRepo "+
                     " ( "+
                      "OID_PARAM_FUNC,"+
                      "OID_FUNC_REPO,"+
                      "ORDEN,"+
                      "TIPO_PARAM,"+
                      "NOMBRE_PARAM,"+
                      "NOMBRE_NICKNAME,"+
                      "OID_VAL_ON,"+
                      "VALOR_ENTERO,"+
                      "VALOR_DECIMAL,"+
                      "VALOR_STRING,"+
                      "VALOR_FECHA,"+
                      "VALOR_BOOLEAN,"+
                      "CELDA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PARAM_FUNC,pers.getOID());
    qInsert.setInt(OID_FUNC_REPO,pers.getFuncion().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setString(TIPO_PARAM,pers.getTipo_param());
    qInsert.setString(NOMBRE_PARAM,pers.getNombre_param());
    qInsert.setString(NOMBRE_NICKNAME,pers.getNombre_nickname());
    qInsert.setInt(OID_VAL_ON,pers.getValor_obj_neg().getOID());
    qInsert.setInt(VALOR_ENTERO,pers.getValor_entero().intValue());
    qInsert.setDouble(VALOR_DECIMAL,pers.getValor_decimal().doubleValue());
    qInsert.setString(VALOR_STRING,pers.getValor_string());
    if (pers.getValor_fecha()!=null) 
      qInsert.setDate(VALOR_FECHA,new java.sql.Date(pers.getValor_fecha().getTime()));
    else
      qInsert.setNull(VALOR_FECHA,java.sql.Types.DATE);
    qInsert.setBoolean(VALOR_BOOLEAN,pers.isValor_boolean().booleanValue());
    qInsert.setString(CELDA,pers.getCelda());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FUNC_REPO = 1;
    final int ORDEN = 2;
    final int TIPO_PARAM = 3;
    final int NOMBRE_PARAM = 4;
    final int NOMBRE_NICKNAME = 5;
    final int OID_VAL_ON = 6;
    final int VALOR_ENTERO = 7;
    final int VALOR_DECIMAL = 8;
    final int VALOR_STRING = 9;
    final int VALOR_FECHA = 10;
    final int VALOR_BOOLEAN = 11;
    final int CELDA = 12;
    final int ACTIVO = 13;
    final int OID_PARAM_FUNC = 14;

    ParamFuncionReporteExcel pers = (ParamFuncionReporteExcel) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update exParamFuncRepo set "+
              "oid_func_repo=?"+ 
              ",orden=?"+ 
              ",tipo_param=?"+ 
              ",nombre_param=?"+ 
              ",nombre_nickname=?"+ 
              ",oid_val_on=?"+ 
              ",valor_entero=?"+ 
              ",valor_decimal=?"+ 
              ",valor_string=?"+ 
              ",valor_fecha=?"+ 
              ",valor_boolean=?"+ 
              ",celda=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_param_func=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARAM_FUNC,pers.getOID());
    qUpdate.setInt(OID_FUNC_REPO,pers.getFuncion().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setString(TIPO_PARAM,pers.getTipo_param());
    qUpdate.setString(NOMBRE_PARAM,pers.getNombre_param());
    qUpdate.setString(NOMBRE_NICKNAME,pers.getNombre_nickname());
    qUpdate.setInt(OID_VAL_ON,pers.getValor_obj_neg().getOID());
    qUpdate.setInt(VALOR_ENTERO,pers.getValor_entero().intValue());
    qUpdate.setDouble(VALOR_DECIMAL,pers.getValor_decimal().doubleValue());
    qUpdate.setString(VALOR_STRING,pers.getValor_string());
    if (pers.getValor_fecha()!=null) 
      qUpdate.setDate(VALOR_FECHA,new java.sql.Date(pers.getValor_fecha().getTime()));
    else
      qUpdate.setNull(VALOR_FECHA,java.sql.Types.DATE);
    qUpdate.setBoolean(VALOR_BOOLEAN,pers.isValor_boolean().booleanValue());
    qUpdate.setString(CELDA,pers.getCelda());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARAM_FUNC = 1; 
    ParamFuncionReporteExcel pers = (ParamFuncionReporteExcel) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update exParamFuncRepo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_param_func=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARAM_FUNC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PARAM_FUNC = 1; 
    ParamFuncionReporteExcel pers = (ParamFuncionReporteExcel) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update exParamFuncRepo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_param_func=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PARAM_FUNC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  public PreparedStatement prepararSelect(int aSelect, Object aCondiciones) throws BaseException, SQLException {
    PreparedStatement ps = null; 
    switch (aSelect) { 
      case IDBObjetoPersistente.SELECT_BY_OID: { 
        ps = this.selectByOID(aCondiciones); 
        break; 
      } 
      case IDBObjetoPersistente.SELECT_BY_CODIGO: { 
        ps = this.selectByCodigo(aCondiciones); 
        break; 
      } 
      case IDBObjetoPersistente.SELECT_ALL_HELP: { 
        ps = this.selectAllHelp(aCondiciones); 
        break; 
      } 
      case SELECT_BY_FUNCION_REPORTE: {
          ps = this.selectByFuncionReporte(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PARAM_FUNC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exParamFuncRepo "); 
    textSQL.append(" WHERE oid_param_func = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PARAM_FUNC, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exParamFuncRepo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFuncionReporte(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  exParamFuncRepo "); 
	    textSQL.append(" WHERE oid_func_repo = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    FuncionReporteExcel funcion = (FuncionReporteExcel) aCondiciones; 
	    querySelect.setInt(1, funcion.getOID()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_param_func oid, codigo,  descripcion ,activo ");
    textSQL.append(" from exParamFuncRepo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getParametrosByFuncion(FuncionReporteExcel funcionReporte,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ParamFuncionReporteExcel.NICKNAME,
             DBParamFuncionReporteExcel.SELECT_BY_FUNCION_REPORTE,
             funcionReporte,
             new ListObserver(),
             aSesion);
  }
  
  
  
} 
