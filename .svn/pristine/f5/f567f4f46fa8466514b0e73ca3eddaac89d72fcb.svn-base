package com.srn.erp.cip.da;

import java.sql.*;
import com.srn.erp.cip.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBLogMensajeCIP extends DBObjetoPersistente {

  public static final String OID_LOG_MENS = "oid_log_mens";
  public static final String FEC_HOR = "fec_hor";
  public static final String ID_EQUIPO = "id_equipo";
  public static final String MENSAJE = "mensaje";
  public static final String ACTIVO = "activo";

  public DBLogMensajeCIP() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LOG_MENS = 1;
    final int FEC_HOR = 2;
    final int ID_EQUIPO = 3;
    final int MENSAJE = 4;
    final int ACTIVO = 5;

    LogMensajeCIP pers = (LogMensajeCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipLogsMens "+
                     " ( "+
                      "OID_LOG_MENS,"+
                      "FEC_HOR,"+
                      "ID_EQUIPO,"+
                      "MENSAJE,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LOG_MENS,pers.getOID());
    qInsert.setTimestamp(FEC_HOR,new java.sql.Timestamp(pers.getFec_hor().getTime()));
    qInsert.setInt(ID_EQUIPO,pers.getId_equipo().intValue());
    qInsert.setString(MENSAJE,pers.getMensaje());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_HOR = 1;
    final int ID_EQUIPO = 2;
    final int MENSAJE = 3;
    final int ACTIVO = 4;
    final int OID_LOG_MENS = 5;

    LogMensajeCIP pers = (LogMensajeCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipLogsMens set "+
              "fec_hor=?"+ 
              ",id_equipo=?"+ 
              ",mensaje=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_log_mens=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_MENS,pers.getOID());
    qUpdate.setTimestamp(FEC_HOR,new java.sql.Timestamp(pers.getFec_hor().getTime()));
    qUpdate.setInt(ID_EQUIPO,pers.getId_equipo().intValue());
    qUpdate.setString(MENSAJE,pers.getMensaje());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_MENS = 1; 
    LogMensajeCIP pers = (LogMensajeCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipLogsMens "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_log_mens=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_MENS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_MENS = 1; 
    LogMensajeCIP pers = (LogMensajeCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipLogsMens "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_log_mens=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_MENS, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LOG_MENS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipLogsMens "); 
    textSQL.append(" WHERE oid_log_mens = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LOG_MENS, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipLogsMens "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_log_mens oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipLogsMens");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
