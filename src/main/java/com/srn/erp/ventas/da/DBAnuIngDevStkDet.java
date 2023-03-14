package com.srn.erp.ventas.da;

import java.sql.*;
import com.srn.erp.ventas.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuIngDevStkDet extends DBObjetoPersistente {

  public static final String OID_ANU_DEV_DET = "oid_anu_dev_det";
  public static final String OID_ANU_ING_DEV = "oid_anu_ing_dev";
  public static final String OID_ING_STK_DET = "oid_ing_stk_det";

  public DBAnuIngDevStkDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_DEV_DET = 1;
    final int OID_ANU_ING_DEV = 2;
    final int OID_ING_STK_DET = 3;

    AnuIngDevStkDet pers = (AnuIngDevStkDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veAnuDevDetStk "+
                     " ( "+
                      "OID_ANU_DEV_DET,"+
                      "OID_ANU_ING_DEV,"+
                      "OID_ING_STK_DET)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_DEV_DET,pers.getOID());
    qInsert.setInt(OID_ANU_ING_DEV,pers.getAnulacion_ing_dev_stk().getOID());
    qInsert.setInt(OID_ING_STK_DET,pers.getIngreso_dev_stk_det().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_ING_DEV = 1;
    final int OID_ING_STK_DET = 2;
    final int OID_ANU_DEV_DET = 3;

    AnuIngDevStkDet pers = (AnuIngDevStkDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veAnuDevDetStk set "+
              "oid_anu_ing_dev=?"+ 
              ",oid_ing_stk_det=?"+ 
                 " where " +
                 " oid_anu_dev_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_DEV_DET,pers.getOID());
    qUpdate.setInt(OID_ANU_ING_DEV,pers.getAnulacion_ing_dev_stk().getOID());
    qUpdate.setInt(OID_ING_STK_DET,pers.getIngreso_dev_stk_det().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_DEV_DET = 1; 
    AnuIngDevStkDet pers = (AnuIngDevStkDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuDevDetStk "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_dev_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_DEV_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_DEV_DET = 1; 
    AnuIngDevStkDet pers = (AnuIngDevStkDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuDevDetStk "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_dev_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_DEV_DET, pers.getOID()); 
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

    final int OID_ANU_DEV_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuDevDetStk "); 
    textSQL.append(" WHERE oid_anu_dev_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_DEV_DET, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuDevDetStk "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_dev_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veAnuIngDevStk");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
