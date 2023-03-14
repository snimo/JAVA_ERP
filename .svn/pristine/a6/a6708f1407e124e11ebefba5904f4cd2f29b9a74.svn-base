package com.srn.erp.general.da;

import java.sql.*;
import com.srn.erp.general.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBRTMTalonario extends DBObjetoPersistente {

  public static final String OID_RTM_TALONARIO = "oid_rtm_talonario";
  public static final String OID_TALONARIO = "oid_talonario";
  public static final String CONDICION_COMPRO = "condicion_compro";
  public static final String ARCHIVO_RTM = "archivo_rtm";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_TALONARIO = 100;

  public DBRTMTalonario() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_RTM_TALONARIO = 1;
    final int OID_TALONARIO = 2;
    final int CONDICION_COMPRO = 3;
    final int ARCHIVO_RTM = 4;
    final int ACTIVO = 5;

    RTMTalonario pers = (RTMTalonario) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geRTMTalonarios "+
                     " ( "+
                      "OID_RTM_TALONARIO,"+
                      "OID_TALONARIO,"+
                      "CONDICION_COMPRO,"+
                      "ARCHIVO_RTM,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_RTM_TALONARIO,pers.getOID());
    qInsert.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qInsert.setString(CONDICION_COMPRO,pers.getCondicion());
    qInsert.setString(ARCHIVO_RTM,pers.getArchivo_rtm());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TALONARIO = 1;
    final int CONDICION_COMPRO = 2;
    final int ARCHIVO_RTM = 3;
    final int ACTIVO = 4;
    final int OID_RTM_TALONARIO = 5;

    RTMTalonario pers = (RTMTalonario) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geRTMTalonarios set "+
              "oid_talonario=?"+ 
              ",condicion_compro=?"+ 
              ",archivo_rtm=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_rtm_talonario=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RTM_TALONARIO,pers.getOID());
    qUpdate.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qUpdate.setString(CONDICION_COMPRO,pers.getCondicion());
    qUpdate.setString(ARCHIVO_RTM,pers.getArchivo_rtm());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_RTM_TALONARIO = 1; 
    RTMTalonario pers = (RTMTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from geRTMTalonarios "+
                     " where " + 
                     " oid_rtm_talonario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RTM_TALONARIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_RTM_TALONARIO = 1; 
    RTMTalonario pers = (RTMTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geRTMTalonarios "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_rtm_talonario=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RTM_TALONARIO, pers.getOID()); 
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
      case SELECT_BY_TALONARIO: {
        ps = this.selectByTalonario(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_RTM_TALONARIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geRTMTalonarios "); 
    textSQL.append(" WHERE oid_rtm_talonario = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_RTM_TALONARIO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByTalonario(Object aCondiciones) throws BaseException, SQLException { 

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Talonario talonario = (Talonario)condiciones.get(Talonario.NICKNAME);
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geRTMTalonarios "); 
    textSQL.append(" WHERE oid_talonario = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    querySelect.setInt(1, talonario.getOID()); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  geRTMTalonarios "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rtm_talonario oid, codigo,  descripcion ,activo ");
    textSQL.append(" from geRTMTalonarios");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
