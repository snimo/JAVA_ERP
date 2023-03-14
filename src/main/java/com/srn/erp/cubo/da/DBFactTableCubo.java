package com.srn.erp.cubo.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.cubo.bm.FactTableCubo;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBFactTableCubo extends DBObjetoPersistente {

  public static final String OID_FACT_TABLE = "oid_fact_table";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_SELECT = "oid_select";
  public static final String TIPO_FACT_TABLE = "tipo_fact_table";
  public static final String NOMBRE_OPER = "nombre_oper";
  public static final String ACTIVO = "activo";

  public DBFactTableCubo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_FACT_TABLE = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_SELECT = 4;
    final int TIPO_FACT_TABLE = 5;
    final int NOMBRE_OPER = 6;
    final int ACTIVO = 7;

    FactTableCubo pers = (FactTableCubo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cuFactTable "+
                     " ( "+
                      "OID_FACT_TABLE,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_SELECT,"+
                      "TIPO_FACT_TABLE,"+
                      "NOMBRE_OPER,"+
                      "ACTIVO)"+ 
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
    qInsert.setInt(OID_FACT_TABLE,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_SELECT,pers.getSelect().getOID());
    qInsert.setString(TIPO_FACT_TABLE,pers.getTipo_fact_table());
    qInsert.setString(NOMBRE_OPER,pers.getNombre_oper());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_SELECT = 3;
    final int TIPO_FACT_TABLE = 4;
    final int NOMBRE_OPER = 5;
    final int ACTIVO = 6;
    final int OID_FACT_TABLE = 7;

    FactTableCubo pers = (FactTableCubo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cuFactTable set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",oid_select=?"+ 
              ",tipo_fact_table=?"+ 
              ",nombre_oper=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_fact_table=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_TABLE,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_SELECT,pers.getSelect().getOID());
    qUpdate.setString(TIPO_FACT_TABLE,pers.getTipo_fact_table());
    qUpdate.setString(NOMBRE_OPER,pers.getNombre_oper());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_TABLE = 1; 
    FactTableCubo pers = (FactTableCubo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cuFactTable "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_fact_table=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_TABLE, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_FACT_TABLE = 1; 
    FactTableCubo pers = (FactTableCubo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cuFactTable "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_fact_table=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_FACT_TABLE, pers.getOID()); 
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

    final int OID_FACT_TABLE = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cuFactTable "); 
    textSQL.append(" WHERE oid_fact_table = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_FACT_TABLE, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cuFactTable "); 
    textSQL.append(" WHERE  codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fact_table oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cuFactTable");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
