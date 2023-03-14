package com.srn.erp.costos.da;

import java.sql.*;
import com.srn.erp.costos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBCentroCostos extends DBObjetoPersistente {

  public static final String OID_CENTRO = "oid_centro";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String OID_CLASIF_01 = "oid_clasif_01";
  public static final String OID_CLASIF_02 = "oid_clasif_02";
  public static final String OID_CLASIF_03 = "oid_clasif_03";
  public static final String OID_CLASIF_04 = "oid_clasif_04";
  public static final String OID_CLASIF_05 = "oid_clasif_05";
  public static final String OID_CLASIF_06 = "oid_clasif_06";
  public static final String OID_CLASIF_07 = "oid_clasif_07";
  public static final String OID_CLASIF_08 = "oid_clasif_08";
  public static final String OID_CLASIF_09 = "oid_clasif_09";
  public static final String OID_CLASIF_10 = "oid_clasif_10";
  public static final String OID_CLASIF_11 = "oid_clasif_11";
  public static final String OID_CLASIF_12 = "oid_clasif_12";
  public static final String OID_CLASIF_13 = "oid_clasif_13";
  public static final String OID_CLASIF_14 = "oid_clasif_14";
  public static final String OID_CLASIF_15 = "oid_clasif_15";
  public static final String OID_CLASIF_16 = "oid_clasif_16";
  public static final String OID_CLASIF_17 = "oid_clasif_17";
  public static final String OID_CLASIF_18 = "oid_clasif_18";
  public static final String OID_CLASIF_19 = "oid_clasif_19";
  public static final String OID_CLASIF_20 = "oid_clasif_20";
  

  public DBCentroCostos() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CENTRO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int OID_CLASIF_01 = 5;
    final int OID_CLASIF_02 = 6;
    final int OID_CLASIF_03 = 7;
    final int OID_CLASIF_04 = 8;
    final int OID_CLASIF_05 = 9;
    final int OID_CLASIF_06 = 10;
    final int OID_CLASIF_07 = 11;
    final int OID_CLASIF_08 = 12;
    final int OID_CLASIF_09 = 13;
    final int OID_CLASIF_10 = 14;
    final int OID_CLASIF_11 = 15;
    final int OID_CLASIF_12 = 16;
    final int OID_CLASIF_13 = 17;
    final int OID_CLASIF_14 = 18;
    final int OID_CLASIF_15 = 19;
    final int OID_CLASIF_16 = 20;
    final int OID_CLASIF_17 = 21;
    final int OID_CLASIF_18 = 22;
    final int OID_CLASIF_19 = 23;
    final int OID_CLASIF_20 = 24;
    

    CentroCostos pers = (CentroCostos) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into coCentroCostos "+
                     " ( "+
                      "OID_CENTRO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "OID_CLASIF_01,"+
                      "OID_CLASIF_02,"+
                      "OID_CLASIF_03,"+
                      "OID_CLASIF_04,"+
                      "OID_CLASIF_05,"+
                      "OID_CLASIF_06,"+
                      "OID_CLASIF_07,"+
                      "OID_CLASIF_08,"+
                      "OID_CLASIF_09,"+
                      "OID_CLASIF_10,"+
                      "OID_CLASIF_11,"+
                      "OID_CLASIF_12,"+
                      "OID_CLASIF_13,"+
                      "OID_CLASIF_14,"+
                      "OID_CLASIF_15,"+
                      "OID_CLASIF_16,"+
                      "OID_CLASIF_17,"+
                      "OID_CLASIF_18,"+
                      "OID_CLASIF_19,"+
                      "OID_CLASIF_20) "+
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CENTRO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());

    qInsert.setInt(OID_CLASIF_01,pers.getOidValorClasif(new Integer(1)).intValue());
    qInsert.setInt(OID_CLASIF_02,pers.getOidValorClasif(new Integer(2)).intValue());
    qInsert.setInt(OID_CLASIF_03,pers.getOidValorClasif(new Integer(3)).intValue());
    qInsert.setInt(OID_CLASIF_04,pers.getOidValorClasif(new Integer(4)).intValue());
    qInsert.setInt(OID_CLASIF_05,pers.getOidValorClasif(new Integer(5)).intValue());
    qInsert.setInt(OID_CLASIF_06,pers.getOidValorClasif(new Integer(6)).intValue());
    qInsert.setInt(OID_CLASIF_07,pers.getOidValorClasif(new Integer(7)).intValue());
    qInsert.setInt(OID_CLASIF_08,pers.getOidValorClasif(new Integer(8)).intValue());
    qInsert.setInt(OID_CLASIF_09,pers.getOidValorClasif(new Integer(9)).intValue());
    qInsert.setInt(OID_CLASIF_10,pers.getOidValorClasif(new Integer(10)).intValue());
    qInsert.setInt(OID_CLASIF_11,pers.getOidValorClasif(new Integer(11)).intValue());
    qInsert.setInt(OID_CLASIF_12,pers.getOidValorClasif(new Integer(12)).intValue());
    qInsert.setInt(OID_CLASIF_13,pers.getOidValorClasif(new Integer(13)).intValue());
    qInsert.setInt(OID_CLASIF_14,pers.getOidValorClasif(new Integer(14)).intValue());
    qInsert.setInt(OID_CLASIF_15,pers.getOidValorClasif(new Integer(15)).intValue());
    qInsert.setInt(OID_CLASIF_16,pers.getOidValorClasif(new Integer(16)).intValue());
    qInsert.setInt(OID_CLASIF_17,pers.getOidValorClasif(new Integer(17)).intValue());
    qInsert.setInt(OID_CLASIF_18,pers.getOidValorClasif(new Integer(18)).intValue());
    qInsert.setInt(OID_CLASIF_19,pers.getOidValorClasif(new Integer(19)).intValue());
    qInsert.setInt(OID_CLASIF_20,pers.getOidValorClasif(new Integer(20)).intValue());
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;

    final int OID_CLASIF_01 = 4;
    final int OID_CLASIF_02 = 5;
    final int OID_CLASIF_03 = 6;
    final int OID_CLASIF_04 = 7;
    final int OID_CLASIF_05 = 8;
    final int OID_CLASIF_06 = 9;
    final int OID_CLASIF_07 = 10;
    final int OID_CLASIF_08 = 11;
    final int OID_CLASIF_09 = 12;
    final int OID_CLASIF_10 = 13;
    final int OID_CLASIF_11 = 14;
    final int OID_CLASIF_12 = 15;
    final int OID_CLASIF_13 = 16;
    final int OID_CLASIF_14 = 17;
    final int OID_CLASIF_15 = 18;
    final int OID_CLASIF_16 = 19;
    final int OID_CLASIF_17 = 20;
    final int OID_CLASIF_18 = 21;
    final int OID_CLASIF_19 = 22;
    final int OID_CLASIF_20 = 23;
    final int OID_CENTRO = 24;

    CentroCostos pers = (CentroCostos) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update coCentroCostos set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",activo=?,"+ 
              "oid_clasif_01 = ?,"+
              "oid_clasif_02 = ?,"+
              "oid_clasif_03 = ?,"+
              "oid_clasif_04 = ?,"+
              "oid_clasif_05 = ?,"+
              "oid_clasif_06 = ?,"+
              "oid_clasif_07 = ?,"+
              "oid_clasif_08 = ?,"+
              "oid_clasif_09 = ?,"+
              "oid_clasif_10 = ?,"+
              "oid_clasif_11 = ?,"+
              "oid_clasif_12 = ?,"+
              "oid_clasif_13 = ?,"+
              "oid_clasif_14 = ?,"+
              "oid_clasif_15 = ?,"+
              "oid_clasif_16 = ?,"+
              "oid_clasif_17 = ?,"+
              "oid_clasif_18 = ?,"+
              "oid_clasif_19 = ?,"+
              "oid_clasif_20 = ? "+              
                 " where " +
                 " oid_centro=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CENTRO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_CLASIF_01,pers.getOidValorClasif(new Integer(1)).intValue());
    qUpdate.setInt(OID_CLASIF_02,pers.getOidValorClasif(new Integer(2)).intValue());
    qUpdate.setInt(OID_CLASIF_03,pers.getOidValorClasif(new Integer(3)).intValue());
    qUpdate.setInt(OID_CLASIF_04,pers.getOidValorClasif(new Integer(4)).intValue());
    qUpdate.setInt(OID_CLASIF_05,pers.getOidValorClasif(new Integer(5)).intValue());
    qUpdate.setInt(OID_CLASIF_06,pers.getOidValorClasif(new Integer(6)).intValue());
    qUpdate.setInt(OID_CLASIF_07,pers.getOidValorClasif(new Integer(7)).intValue());
    qUpdate.setInt(OID_CLASIF_08,pers.getOidValorClasif(new Integer(8)).intValue());
    qUpdate.setInt(OID_CLASIF_09,pers.getOidValorClasif(new Integer(9)).intValue());
    qUpdate.setInt(OID_CLASIF_10,pers.getOidValorClasif(new Integer(10)).intValue());
    qUpdate.setInt(OID_CLASIF_11,pers.getOidValorClasif(new Integer(11)).intValue());
    qUpdate.setInt(OID_CLASIF_12,pers.getOidValorClasif(new Integer(12)).intValue());
    qUpdate.setInt(OID_CLASIF_13,pers.getOidValorClasif(new Integer(13)).intValue());
    qUpdate.setInt(OID_CLASIF_14,pers.getOidValorClasif(new Integer(14)).intValue());
    qUpdate.setInt(OID_CLASIF_15,pers.getOidValorClasif(new Integer(15)).intValue());
    qUpdate.setInt(OID_CLASIF_16,pers.getOidValorClasif(new Integer(16)).intValue());
    qUpdate.setInt(OID_CLASIF_17,pers.getOidValorClasif(new Integer(17)).intValue());
    qUpdate.setInt(OID_CLASIF_18,pers.getOidValorClasif(new Integer(18)).intValue());
    qUpdate.setInt(OID_CLASIF_19,pers.getOidValorClasif(new Integer(19)).intValue());
    qUpdate.setInt(OID_CLASIF_20,pers.getOidValorClasif(new Integer(20)).intValue());
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CENTRO = 1; 
    CentroCostos pers = (CentroCostos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update coCentroCostos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_centro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CENTRO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CENTRO = 1; 
    CentroCostos pers = (CentroCostos) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update coCentroCostos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_centro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CENTRO, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
        }      
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CENTRO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  coCentroCostos "); 
    textSQL.append(" WHERE oid_centro = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CENTRO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  coCentroCostos "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  coCentroCostos "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_centro oid, codigo,  descripcion ,activo ");
    textSQL.append(" from coCentroCostos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
