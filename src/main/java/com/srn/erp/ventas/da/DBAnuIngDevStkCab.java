package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ventas.bm.AnuIngDevStkCab;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAnuIngDevStkCab extends DBObjetoPersistente {

  public static final String OID_ANU_ING_DEV = "oid_anu_ing_dev";
  public static final String OID_ING_DEV_STK = "oid_ing_dev_stk";

  public DBAnuIngDevStkCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_ING_DEV = 1;
    final int OID_ING_DEV_STK = 2;

    AnuIngDevStkCab pers = (AnuIngDevStkCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veAnuIngDevStk "+
                     " ( "+
                      "OID_ANU_ING_DEV,"+
                      "OID_ING_DEV_STK)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_ING_DEV,pers.getOID());
    qInsert.setInt(OID_ING_DEV_STK,pers.getIngreso_devolucion_stk_cab().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ING_DEV_STK = 1;
    final int OID_ANU_ING_DEV = 2;

    AnuIngDevStkCab pers = (AnuIngDevStkCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veAnuIngDevStk set "+
              "oid_ing_dev_stk=?"+ 
                 " where " +
                 " oid_anu_ing_dev=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_ING_DEV,pers.getOID());
    qUpdate.setInt(OID_ING_DEV_STK,pers.getIngreso_devolucion_stk_cab().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_ING_DEV = 1; 
    AnuIngDevStkCab pers = (AnuIngDevStkCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuIngDevStk "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_ing_dev=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_ING_DEV, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_ING_DEV = 1; 
    AnuIngDevStkCab pers = (AnuIngDevStkCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuIngDevStk "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_ing_dev=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_ING_DEV, pers.getOID()); 
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

    final int OID_ANU_ING_DEV = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuIngDevStk "); 
    textSQL.append(" WHERE oid_anu_ing_dev = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_ING_DEV, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuIngDevStk "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_ing_dev oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veAnuIngDevStk");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
