package com.srn.erp.ventas.da;

import java.sql.*;
import com.srn.erp.ventas.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuladorFactCab extends DBObjetoPersistente {

  public static final String OID_ANU_FACT_CAB = "oid_anu_fact_cab";
  public static final String OID_CCO_FACT = "oid_cco_fact";

  public DBAnuladorFactCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_FACT_CAB = 1;
    final int OID_CCO_FACT = 2;

    AnuladorFactCab pers = (AnuladorFactCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veAnuFactCab "+
                     " ( "+
                      "OID_ANU_FACT_CAB,"+
                      "OID_CCO_FACT)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_FACT_CAB,pers.getOID());
    qInsert.setInt(OID_CCO_FACT,pers.getFactura_cab().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_FACT = 1;
    final int OID_ANU_FACT_CAB = 2;

    AnuladorFactCab pers = (AnuladorFactCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veAnuFactCab set "+
              "oid_cco_fact=?"+ 
                 " where " +
                 " oid_anu_fact_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FACT_CAB,pers.getOID());
    qUpdate.setInt(OID_CCO_FACT,pers.getFactura_cab().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FACT_CAB = 1; 
    AnuladorFactCab pers = (AnuladorFactCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuFactCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_fact_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FACT_CAB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FACT_CAB = 1; 
    AnuladorFactCab pers = (AnuladorFactCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuFactCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_fact_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FACT_CAB, pers.getOID()); 
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

    final int OID_ANU_FACT_CAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.*,b.* FROM  veAnuFactCab a  , geComproCab b "); 
    textSQL.append(" WHERE b.oid_cco_fact = a.oid_cco and a.oid_anu_fact_cab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_FACT_CAB, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuFactCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_fact_cab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veAnuFactCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
