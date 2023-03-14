package com.srn.erp.ctasAPagar.da;

import java.sql.*;
import com.srn.erp.ctasAPagar.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBComproProveedorAnulador extends DBObjetoPersistente {

  public static final String OID_COMPRO_PROV_A = "oid_compro_prov_a";
  public static final String OID_CCO = "oid_cco";

  public DBComproProveedorAnulador() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COMPRO_PROV_A = 1;
    final int OID_CCO = 2;

    ComproProveedorAnulador pers = (ComproProveedorAnulador) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpComproProvAnu "+
                     " ( "+
                      "OID_COMPRO_PROV_A,"+
                      "OID_CCO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COMPRO_PROV_A,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobanteBase().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO = 1;
    final int OID_COMPRO_PROV_A = 2;

    ComproProveedorAnulador pers = (ComproProveedorAnulador) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpComproProvAnu set "+
              "oid_cco=?"+ 
                 " where " +
                 " oid_compro_prov_a=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPRO_PROV_A,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPRO_PROV_A = 1; 
    ComproProveedorAnulador pers = (ComproProveedorAnulador) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpComproProvAnu "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_compro_prov_a=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPRO_PROV_A, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COMPRO_PROV_A = 1; 
    ComproProveedorAnulador pers = (ComproProveedorAnulador) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpComproProvAnu "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_compro_prov_a=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COMPRO_PROV_A, pers.getOID()); 
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

    final int OID_COMPRO_PROV_A = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpComproProvAnu "); 
    textSQL.append(" WHERE oid_compro_prov_a = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COMPRO_PROV_A, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpComproProvAnu "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compro_prov_a oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpComproProvAnu");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
