package com.srn.erp.ventas.da;

import java.sql.*;
import com.srn.erp.ventas.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuladorFactCabDet extends DBObjetoPersistente {

  public static final String OID_ANU_FACT_DET = "oid_anu_fact_det";
  public static final String OID_ANU_FACT_CAB = "oid_anu_fact_cab";
  public static final String OID_FACT_DET = "oid_fact_det";

  public DBAnuladorFactCabDet() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_FACT_DET = 1;
    final int OID_ANU_FACT_CAB = 2;
    final int OID_FACT_DET = 3;

    AnuladorFactCabDet pers = (AnuladorFactCabDet) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veAnuFactDet "+
                     " ( "+
                      "OID_ANU_FACT_DET,"+
                      "OID_ANU_FACT_CAB,"+
                      "OID_FACT_DET)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_FACT_DET,pers.getOID());
    qInsert.setInt(OID_ANU_FACT_CAB,pers.getAnulador_factura_cab().getOID());
    qInsert.setInt(OID_FACT_DET,pers.getFactura_det().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_FACT_CAB = 1;
    final int OID_FACT_DET = 2;
    final int OID_ANU_FACT_DET = 3;

    AnuladorFactCabDet pers = (AnuladorFactCabDet) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veAnuFactDet set "+
              "oid_anu_fact_cab=?"+ 
              ",oid_fact_det=?"+ 
                 " where " +
                 " oid_anu_fact_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FACT_DET,pers.getOID());
    qUpdate.setInt(OID_ANU_FACT_CAB,pers.getAnulador_factura_cab().getOID());
    qUpdate.setInt(OID_FACT_DET,pers.getFactura_det().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FACT_DET = 1; 
    AnuladorFactCabDet pers = (AnuladorFactCabDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuFactDet "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_fact_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FACT_DET, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FACT_DET = 1; 
    AnuladorFactCabDet pers = (AnuladorFactCabDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veAnuFactDet "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_fact_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FACT_DET, pers.getOID()); 
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

    final int OID_ANU_FACT_DET = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuFactDet "); 
    textSQL.append(" WHERE oid_anu_fact_det = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_FACT_DET, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veAnuFactDet "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_fact_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veAnuFactCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
