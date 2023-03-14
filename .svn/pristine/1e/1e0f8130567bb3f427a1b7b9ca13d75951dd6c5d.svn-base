package com.srn.erp.contabilidad.da;

import java.sql.*;
import com.srn.erp.contabilidad.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuladorAsientoManual extends DBObjetoPersistente {

  public static final String OID_CAB_ASI_MAN = "oid_cab_asi_man";
  public static final String OID_CCO = "oid_cco";

  public DBAnuladorAsientoManual() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAB_ASI_MAN = 1;
    final int OID_CCO = 2;

    AnuladorAsientoManual pers = (AnuladorAsientoManual) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgAnuCabAsiMan "+
                     " ( "+
                      "OID_CAB_ASI_MAN,"+
                      "OID_CCO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CAB_ASI_MAN,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getAsiento_manual().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO = 1;
    final int OID_CAB_ASI_MAN = 2;

    AnuladorAsientoManual pers = (AnuladorAsientoManual) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgAnuCabAsiMan set "+
              "oid_cco=?"+ 
                 " where " +
                 " oid_cab_asi_man=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_MAN,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getAsiento_manual().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAB_ASI_MAN = 1; 
    AnuladorAsientoManual pers = (AnuladorAsientoManual) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgAnuCabAsiMan "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cab_asi_man=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_MAN, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CAB_ASI_MAN = 1; 
    AnuladorAsientoManual pers = (AnuladorAsientoManual) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgAnuCabAsiMan "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cab_asi_man=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAB_ASI_MAN, pers.getOID()); 
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

    final int OID_CAB_ASI_MAN = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAnuCabAsiMan "); 
    textSQL.append(" WHERE oid_cab_asi_man = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CAB_ASI_MAN, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAnuCabAsiMan "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cab_asi_man oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgAnuCabAsiMan");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
