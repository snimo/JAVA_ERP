package com.srn.erp.excelReport.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.FuncionReporteExcel;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBFuncionReporteExcel extends DBObjetoPersistente {

  public static final String OID_FUNC_REPO = "oid_func_repo";
  public static final String OID_REPORTE = "oid_reporte";
  public static final String ORDEN = "orden";
  public static final String TOKEN_FUNCION = "token_funcion";
  public static final String COMENTARIO = "comentario";
  public static final String CELDA_DESTINO = "celda_destino";
  public static final String ACTIVO = "activo";
  public static final String FUNCION = "funcion";
  
  public static final int SELECT_BY_REPORTE = 100;

  public DBFuncionReporteExcel() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FUNC_REPO = 1;
    final int OID_REPORTE = 2;
    final int ORDEN = 3;
    final int TOKEN_FUNCION = 4;
    final int COMENTARIO = 5;
    final int CELDA_DESTINO = 6;
    final int ACTIVO = 7;
    final int FUNCION = 8;

    FuncionReporteExcel pers = (FuncionReporteExcel) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into exFuncRepo "+
                     " ( "+
                      "OID_FUNC_REPO,"+
                      "OID_REPORTE,"+
                      "ORDEN,"+
                      "TOKEN_FUNCION,"+
                      "COMENTARIO,"+
                      "CELDA_DESTINO,"+
                      "ACTIVO,FUNCION)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_FUNC_REPO,pers.getOID());
    qInsert.setInt(OID_REPORTE,pers.getReporte().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setString(TOKEN_FUNCION,pers.getToken_funcion());
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.setString(CELDA_DESTINO,pers.getCelda_destino());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(FUNCION,pers.getFuncion());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REPORTE = 1;
    final int ORDEN = 2;
    final int TOKEN_FUNCION = 3;
    final int COMENTARIO = 4;
    final int CELDA_DESTINO = 5;
    final int ACTIVO = 6;
    final int FUNCION = 7;
    final int OID_FUNC_REPO = 8;

    FuncionReporteExcel pers = (FuncionReporteExcel) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update exFuncRepo set "+
              "oid_reporte=?"+ 
              ",orden=?"+ 
              ",token_funcion=?"+ 
              ",comentario=?"+ 
              ",celda_destino=?"+ 
              ",activo=?"+ 
              ",funcion=?"+
                 " where " +
                 " oid_func_repo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FUNC_REPO,pers.getOID());
    qUpdate.setInt(OID_REPORTE,pers.getReporte().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setString(TOKEN_FUNCION,pers.getToken_funcion());
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.setString(CELDA_DESTINO,pers.getCelda_destino());
    qUpdate.setString(FUNCION,pers.getFuncion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FUNC_REPO = 1; 
    FuncionReporteExcel pers = (FuncionReporteExcel) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from exFuncRepo "+
                     " where " + 
                     " oid_func_repo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FUNC_REPO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FUNC_REPO = 1; 
    FuncionReporteExcel pers = (FuncionReporteExcel) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update exFuncRepo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_func_repo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FUNC_REPO, pers.getOID()); 
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
      case SELECT_BY_REPORTE: {
          ps = this.selectByReporte(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_FUNC_REPO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exFuncRepo "); 
    textSQL.append(" WHERE oid_func_repo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FUNC_REPO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exFuncRepo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByReporte(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  exFuncRepo "); 
	    textSQL.append(" WHERE oid_reporte = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ExcelReport reporte = (ExcelReport) aCondiciones; 
	    querySelect.setInt(1, reporte.getOID()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_func_repo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from exFuncRepo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getFuncionesReporte(ExcelReport reporte,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(FuncionReporteExcel.NICKNAME,
             DBFuncionReporteExcel.SELECT_BY_REPORTE,
             reporte,
             new ListObserver(),
             aSesion);
  }
  
  
} 
