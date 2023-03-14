package com.srn.erp.excelReport.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excelReport.bm.ExcelReport;
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

public class DBExcelReport extends DBObjetoPersistente {

  public static final String OID_REPORTE = "oid_reporte";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String OID_GRUPO_REPORTE = "oid_grupo_reporte";
  public static final String ORDEN = "orden";
  
  public static final int SELECT_REPORTES_BY_USUARIO = 100;

  public DBExcelReport() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REPORTE = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int OID_GRUPO_REPORTE = 5;
    final int ORDEN = 6;

    ExcelReport pers = (ExcelReport) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into exReporte "+
                     " ( "+
                      "OID_REPORTE,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,OID_GRUPO_REPORTE,ORDEN)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_REPORTE,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_GRUPO_REPORTE, pers.getGrupoReporteExcel().getOID());
    qInsert.setInt(ORDEN, pers.getOrden().intValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_GRUPO_REPORTE = 4;
    final int ORDEN = 5;
    final int OID_REPORTE = 6;

    ExcelReport pers = (ExcelReport) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update exReporte set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?"+ 
              ",oid_grupo_reporte=?"+
              ",orden=?"+
                 " where " +
                 " oid_reporte=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REPORTE,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_GRUPO_REPORTE, pers.getGrupoReporteExcel().getOID());
    qUpdate.setInt(ORDEN, pers.getOrden().intValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REPORTE = 1; 
    ExcelReport pers = (ExcelReport) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update exReporte "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_reporte=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REPORTE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REPORTE = 1; 
    ExcelReport pers = (ExcelReport) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update exReporte "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_reporte=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REPORTE, pers.getOID()); 
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
      case SELECT_REPORTES_BY_USUARIO: {
          ps = this.selectReportesByUsuario(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REPORTE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exReporte "); 
    textSQL.append(" WHERE oid_reporte = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REPORTE, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exReporte "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectReportesByUsuario(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append(" SELECT * ");
	    textSQL.append(" FROM  exReporte a, exUsuariosReporte b "); 
	    textSQL.append(" WHERE a.oid_reporte = b.oid_reporte and a.activo = 1 and b.activo=1 ");
	    textSQL.append(" and b.oid_usuario = ? and (b.lectura=1 or b.modif=1 or b.grabacion=1) ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setInt(1, this.getSesion().getLogin().getUsuario().getOID()); 
	    return querySelect; 
	  }
  
  
    

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_reporte oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from exReporte");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getReportesUsuario(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ExcelReport.NICKNAME,
             DBExcelReport.SELECT_REPORTES_BY_USUARIO,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
