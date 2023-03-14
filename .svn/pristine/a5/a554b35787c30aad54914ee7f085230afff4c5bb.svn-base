package com.srn.erp.pagos.da;

import java.sql.*;
import com.srn.erp.pagos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuladorRendFF extends DBObjetoPersistente {

  public static final String OID_ANU_REND_FF = "oid_anu_rend_ff";
  public static final String OID_REND_FONDO = "oid_rend_fondo";

  public DBAnuladorRendFF() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_REND_FF = 1;
    final int OID_REND_FONDO = 2;

    AnuladorRendFF pers = (AnuladorRendFF) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opAnuRendFF "+
                     " ( "+
                      "OID_ANU_REND_FF,"+
                      "OID_REND_FONDO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_REND_FF,pers.getOID());
    qInsert.setInt(OID_REND_FONDO,pers.getRendicion_ff().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REND_FONDO = 1;
    final int OID_ANU_REND_FF = 2;

    AnuladorRendFF pers = (AnuladorRendFF) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opAnuRendFF set "+
              "oid_rend_fondo=?"+ 
                 " where " +
                 " oid_anu_rend_ff=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_REND_FF,pers.getOID());
    qUpdate.setInt(OID_REND_FONDO,pers.getRendicion_ff().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_REND_FF = 1; 
    AnuladorRendFF pers = (AnuladorRendFF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuRendFF "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_rend_ff=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_REND_FF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_REND_FF = 1; 
    AnuladorRendFF pers = (AnuladorRendFF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuRendFF "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_rend_ff=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_REND_FF, pers.getOID()); 
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

    final int OID_ANU_REND_FF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuRendFF "); 
    textSQL.append(" WHERE oid_anu_rend_ff = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_REND_FF, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuRendFF "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_rend_ff oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opAnuRendFF");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
