package com.srn.erp.ctasAPagar.da;

import java.sql.*;
import com.srn.erp.ctasAPagar.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuladorComproProvAplic extends DBObjetoPersistente {

  public static final String OID_CCO_ANU_APL = "oid_cco_anu_apl";
  public static final String OID_CCO_APL_PROV = "oid_cco_apl_prov";

  public DBAnuladorComproProvAplic() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_ANU_APL = 1;
    final int OID_CCO_APL_PROV = 2;

    AnuladorComproProvAplic pers = (AnuladorComproProvAplic) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAnuComproProvApl "+
                     " ( "+
                      "OID_CCO_ANU_APL,"+
                      "OID_CCO_APL_PROV)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CCO_ANU_APL,pers.getOID());
    qInsert.setInt(OID_CCO_APL_PROV,pers.getCompro_apl_prov().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_APL_PROV = 1;
    final int OID_CCO_ANU_APL = 2;

    AnuladorComproProvAplic pers = (AnuladorComproProvAplic) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAnuComproProvApl set "+
              "oid_cco_apl_prov=?"+ 
                 " where " +
                 " oid_cco_anu_apl=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_ANU_APL,pers.getOID());
    qUpdate.setInt(OID_CCO_APL_PROV,pers.getCompro_apl_prov().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_ANU_APL = 1; 
    AnuladorComproProvAplic pers = (AnuladorComproProvAplic) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAnuComproProvApl "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cco_anu_apl=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_ANU_APL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO_ANU_APL = 1; 
    AnuladorComproProvAplic pers = (AnuladorComproProvAplic) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAnuComproProvApl "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco_anu_apl=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO_ANU_APL, pers.getOID()); 
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

    final int OID_CCO_ANU_APL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAnuComproProvApl "); 
    textSQL.append(" WHERE oid_cco_anu_apl = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CCO_ANU_APL, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAnuComproProvApl "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_anu_apl oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAnuComproProvApl");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
