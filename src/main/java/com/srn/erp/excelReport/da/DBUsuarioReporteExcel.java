package com.srn.erp.excelReport.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.excelReport.bm.ExcelReport;
import com.srn.erp.excelReport.bm.UsuarioReporteExcel;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBUsuarioReporteExcel extends DBObjetoPersistente {

  public static final String OID_ROL_REPORTE = "oid_rol_reporte";
  public static final String OID_REPORTE = "oid_reporte";
  public static final String LECTURA = "lectura";
  public static final String MODIF = "modif";
  public static final String GRABACION = "grabacion";
  public static final String ACTIVO = "activo";
  public static final String OID_USUARIO = "oid_usuario";
  
  public static final int SELECT_BY_REPORTE_USUARIO = 100;
  public static final int SELECT_BY_REPORTE = 101;

  public DBUsuarioReporteExcel() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ROL_REPORTE = 1;
    final int OID_REPORTE = 2;
    final int LECTURA = 3;
    final int MODIF = 4;
    final int GRABACION = 5;
    final int ACTIVO = 6;
    final int OID_USUARIO = 7;

    UsuarioReporteExcel pers = (UsuarioReporteExcel) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into exUsuariosReporte "+
                     " ( "+
                      "OID_ROL_REPORTE,"+
                      "OID_REPORTE,"+
                      "LECTURA,"+
                      "MODIF,"+
                      "GRABACION,"+
                      "ACTIVO,"+
                      "OID_USUARIO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ROL_REPORTE,pers.getOID());
    qInsert.setInt(OID_REPORTE,pers.getReporte().getOID());
    qInsert.setBoolean(LECTURA,pers.isLectura().booleanValue());
    qInsert.setBoolean(MODIF,pers.isModificacion().booleanValue());
    qInsert.setBoolean(GRABACION,pers.isGrabacion().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REPORTE = 1;
    final int LECTURA = 2;
    final int MODIF = 3;
    final int GRABACION = 4;
    final int ACTIVO = 5;
    final int OID_USUARIO = 6;
    final int OID_ROL_REPORTE = 7;

    UsuarioReporteExcel pers = (UsuarioReporteExcel) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update exUsuariosReporte set "+
              "oid_reporte=?"+ 
              ",lectura=?"+ 
              ",modif=?"+ 
              ",grabacion=?"+ 
              ",activo=?"+ 
              ",oid_usuario=?"+ 
                 " where " +
                 " oid_rol_reporte=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROL_REPORTE,pers.getOID());
    qUpdate.setInt(OID_REPORTE,pers.getReporte().getOID());
    qUpdate.setBoolean(LECTURA,pers.isLectura().booleanValue());
    qUpdate.setBoolean(MODIF,pers.isModificacion().booleanValue());
    qUpdate.setBoolean(GRABACION,pers.isGrabacion().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROL_REPORTE = 1; 
    UsuarioReporteExcel pers = (UsuarioReporteExcel) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from exUsuariosReporte "+
                     " where " + 
                     " oid_rol_reporte=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROL_REPORTE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ROL_REPORTE = 1; 
    UsuarioReporteExcel pers = (UsuarioReporteExcel) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update exUsuariosReporte "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rol_reporte=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ROL_REPORTE, pers.getOID()); 
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
      case SELECT_BY_REPORTE_USUARIO: {
          ps = this.selectByReporteUsuario(aCondiciones); 
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

    final int OID_ROL_REPORTE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exUsuariosReporte "); 
    textSQL.append(" WHERE oid_rol_reporte = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ROL_REPORTE, oid); 
    return querySelect; 

  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  exUsuariosReporte "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByReporteUsuario(Object aCondiciones) throws BaseException, SQLException { 

	    final int CODIGO = 1; 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  exUsuariosReporte "); 
	    textSQL.append(" WHERE oid_reporte = ? and oid_usuario = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	   
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ExcelReport excel = (ExcelReport) condiciones.get(ExcelReport.NICKNAME);
	    Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
	    
	    querySelect.setInt(1, excel.getOID());
	    querySelect.setInt(2, usuario.getOID());
	    
	    return querySelect; 
	  }
  
  private PreparedStatement selectByReporte(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  exUsuariosReporte "); 
	    textSQL.append(" WHERE oid_reporte = ?  ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	   
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ExcelReport excel = (ExcelReport) condiciones.get(ExcelReport.NICKNAME);
	    
	    querySelect.setInt(1, excel.getOID());
	    
	    return querySelect; 
	  }
  
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rol_reporte oid, codigo,  descripcion ,activo ");
    textSQL.append(" from exUsuariosReporte");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static UsuarioReporteExcel getUsuarioReporteExcel(ExcelReport excel,
		  Usuario usuario,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ExcelReport.NICKNAME, excel);
	  condiciones.put(Usuario.NICKNAME, usuario);
	  
	  return (UsuarioReporteExcel) ObjetoLogico.getObjects(UsuarioReporteExcel.NICKNAME,
			  				DBUsuarioReporteExcel.SELECT_BY_REPORTE_USUARIO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getUsuariosReporte(ExcelReport excel,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ExcelReport.NICKNAME, excel);
	  
	  return (List) ObjetoLogico.getObjects(UsuarioReporteExcel.NICKNAME,
			  				DBUsuarioReporteExcel.SELECT_BY_REPORTE,
			  				condiciones,
			  				new ListObserver(),
			  				aSesion);
  }
  
  
  
  
} 
