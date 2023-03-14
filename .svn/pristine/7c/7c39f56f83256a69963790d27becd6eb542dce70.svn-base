package com.srn.erp.cashflow.da;

import java.sql.*;
import com.srn.erp.cashflow.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBProgFechasCF extends DBObjetoPersistente {

  public static final String OID_PROG_CF = "oid_prog_cf";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String ACTIVO = "activo";
  public static final String OID_ESCENARIO = "oid_escenario";

  public DBProgFechasCF() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROG_CF = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int FEC_DESDE = 4;
    final int FEC_HASTA = 5;
    final int ACTIVO = 6;
    final int OID_ESCENARIO = 7;

    ProgFechasCF pers = (ProgFechasCF) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cfProgCashFlow "+
                     " ( "+
                      "OID_PROG_CF,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "ACTIVO,"+
                      "OID_ESCENARIO)"+ 
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
    qInsert.setInt(OID_PROG_CF,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int FEC_DESDE = 3;
    final int FEC_HASTA = 4;
    final int ACTIVO = 5;
    final int OID_ESCENARIO = 6;
    final int OID_PROG_CF = 7;

    ProgFechasCF pers = (ProgFechasCF) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cfProgCashFlow set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
              ",activo=?"+ 
              ",oid_escenario=?"+ 
                 " where " +
                 " oid_prog_cf=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROG_CF,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_ESCENARIO,pers.getEscenario().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROG_CF = 1; 
    ProgFechasCF pers = (ProgFechasCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfProgCashFlow "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_prog_cf=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROG_CF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROG_CF = 1; 
    ProgFechasCF pers = (ProgFechasCF) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cfProgCashFlow "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_prog_cf=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROG_CF, pers.getOID()); 
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

    final int OID_PROG_CF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfProgCashFlow "); 
    textSQL.append(" WHERE oid_prog_cf = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROG_CF, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cfProgCashFlow "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_prog_cf oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from cfProgCashFlow");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
