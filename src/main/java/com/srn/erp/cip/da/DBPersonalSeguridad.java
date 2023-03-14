package com.srn.erp.cip.da;

import java.sql.*;
import com.srn.erp.cip.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Servicios.ServicioPoolBD;
import framework.request.bl.PoolBD.IPoolBD;
import framework.request.bl.Utils.*;

public class DBPersonalSeguridad extends DBObjetoPersistente {

  public static final String OID_PERS_SECU = "oid_pers_secu";
  public static final String CODIGO = "codigo";
  public static final String ACTIVO = "activo";
  public static final String APELLIDO = "apellido";
  public static final String NOMBRE = "nombre";
  public static final String OID_TIPO_DOCU = "oid_tipo_docu";
  public static final String CACHEO_SEG = "cacheo_seg";
  public static final String NRO_DOCU = "nro_docu";
  
  public static final int SELECT_HELP_CACHEO = 100;

  public DBPersonalSeguridad() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERS_SECU = 1;
    final int CODIGO = 2;
    final int ACTIVO = 3;
    final int APELLIDO = 4;
    final int NOMBRE = 5;
    final int OID_TIPO_DOCU = 6;
    final int CACHEO_SEG = 7;
    final int NRO_DOCU = 8;

    PersonalSeguridad pers = (PersonalSeguridad) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipPersSegu "+
                     " ( "+
                      "OID_PERS_SECU,"+
                      "CODIGO,"+
                      "ACTIVO,"+
                      "APELLIDO,"+
                      "NOMBRE,"+
                      "OID_TIPO_DOCU,"+
                      "CACHEO_SEG,"+
                      "NRO_DOCU)"+ 
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
    qInsert.setInt(OID_PERS_SECU,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(APELLIDO,pers.getApellido());
    qInsert.setString(NOMBRE,pers.getNombre());
    qInsert.setInt(OID_TIPO_DOCU,pers.getTipo_documento().getOID());
    qInsert.setBoolean(CACHEO_SEG,pers.isCacheo_seg().booleanValue());
    qInsert.setString(NRO_DOCU,pers.getNro_docu());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int ACTIVO = 2;
    final int APELLIDO = 3;
    final int NOMBRE = 4;
    final int OID_TIPO_DOCU = 5;
    final int CACHEO_SEG = 6;
    final int NRO_DOCU = 7;
    final int OID_PERS_SECU = 8;

    PersonalSeguridad pers = (PersonalSeguridad) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipPersSegu set "+
              "codigo=?"+ 
              ",activo=?"+ 
              ",apellido=?"+ 
              ",nombre=?"+ 
              ",oid_tipo_docu=?"+ 
              ",cacheo_seg=?"+ 
              ",nro_docu=?"+ 
                 " where " +
                 " oid_pers_secu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERS_SECU,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(APELLIDO,pers.getApellido());
    qUpdate.setString(NOMBRE,pers.getNombre());
    qUpdate.setInt(OID_TIPO_DOCU,pers.getTipo_documento().getOID());
    qUpdate.setBoolean(CACHEO_SEG,pers.isCacheo_seg().booleanValue());
    qUpdate.setString(NRO_DOCU,pers.getNro_docu());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERS_SECU = 1; 
    PersonalSeguridad pers = (PersonalSeguridad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPersSegu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_pers_secu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERS_SECU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERS_SECU = 1; 
    PersonalSeguridad pers = (PersonalSeguridad) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPersSegu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_pers_secu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERS_SECU, pers.getOID()); 
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
      case SELECT_HELP_CACHEO: { 
          ps = this.selectHelpCacheo(aCondiciones); 
          break; 
        }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PERS_SECU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPersSegu "); 
    textSQL.append(" WHERE oid_pers_secu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PERS_SECU, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPersSegu "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectHelpCacheo(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();

		String caracter = "||";
		if (this.getSesion().getServicios().getServPoolBD(ServicioPoolBD.FILE_POOL_BD).getPoolBD().getTipoBD().equals(IPoolBD.MSSQLServer))
			caracter = "+";
	    
	    textSQL.append("SELECT oid_pers_secu oid,codigo codigo, apellido "+caracter+" ' ' "+caracter+" nombre  descripcion ,activo ");
	    textSQL.append(" from cipPersSegu where activo=1 and cacheo_seg=1 ");
	    
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	  } 
  
  
  
  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

	String caracter = "||";
	if (this.getSesion().getServicios().getServPoolBD(ServicioPoolBD.FILE_POOL_BD).getPoolBD().getTipoBD().equals(IPoolBD.MSSQLServer))
		caracter = "+";
    
    textSQL.append("SELECT oid_pers_secu oid,codigo codigo, apellido "+caracter+" ' ' "+caracter+" nombre  descripcion ,activo ");
    textSQL.append(" from cipPersSegu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
