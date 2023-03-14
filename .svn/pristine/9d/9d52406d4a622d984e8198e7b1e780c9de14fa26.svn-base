package com.srn.erp.bienUso.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.bienUso.bm.ComproBienUsoCab;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBComproBienUsoCab extends DBObjetoPersistente {

  public static final String OID_CCO_BU = "oid_cco_bu";
  public static final String OID_BIEN_ALTA = "oid_bien_alta";
  public static final String TIPO_MOV = "tipo_mov";
  public static final String OID_PERI = "oid_peri";
  public static final String OID_SIST_VAL = "oid_sist_val";

  public DBComproBienUsoCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_BU = 1;
    final int OID_BIEN_ALTA = 2;
    final int TIPO_MOV = 3;
    final int OID_PERI = 4;
    final int OID_SIST_VAL = 5;

    ComproBienUsoCab pers = (ComproBienUsoCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into buComproCab "+
                     " ( "+
                      "OID_CCO_BU,"+
                      "OID_BIEN_ALTA,"+
                      "TIPO_MOV,"+
                      "OID_PERI,"+
                      "OID_SIST_VAL)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CCO_BU,pers.getOID());
    qInsert.setInt(OID_BIEN_ALTA,pers.getSub_bien().getOID());
    qInsert.setString(TIPO_MOV,pers.getTipo_mov());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    qInsert.setInt(OID_SIST_VAL,pers.getSistema_valuacion().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BIEN_ALTA = 1;
    final int TIPO_MOV = 2;
    final int OID_PERI = 3;
    final int OID_SIST_VAL = 4;
    final int OID_CCO_BU = 5;

    ComproBienUsoCab pers = (ComproBienUsoCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update buComproCab set "+
              "oid_bien_alta=?"+ 
              ",tipo_mov=?"+ 
              ",oid_peri=?"+ 
              ",oid_sist_val=?"+ 
                 " where " +
                 " oid_cco_bu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_BU,pers.getOID());
    qUpdate.setInt(OID_BIEN_ALTA,pers.getSub_bien().getOID());
    qUpdate.setString(TIPO_MOV,pers.getTipo_mov());
    qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    qUpdate.setInt(OID_SIST_VAL,pers.getSistema_valuacion().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_BU = 1; 
    ComproBienUsoCab pers = (ComproBienUsoCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buComproCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco_bu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_BU, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_BU = 1; 
    ComproBienUsoCab pers = (ComproBienUsoCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update buComproCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco_bu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_BU, pers.getOID()); 
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

    final int OID_CCO_BU = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buComproCab "); 
    textSQL.append(" WHERE oid_cco_bu = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO_BU, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  buComproCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_bu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from buComproCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
