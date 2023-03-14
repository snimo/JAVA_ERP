package com.srn.erp.pagos.da;

import java.sql.*;
import com.srn.erp.pagos.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAnuladorRendFFValores extends DBObjetoPersistente {

  public static final String OID_ANU_FF_VALOR = "oid_anu_ff_valor";
  public static final String OID_ANU_REND_FF = "oid_anu_rend_ff";
  public static final String OID_REND_MED_PAGO = "oid_rend_med_pago";

  public DBAnuladorRendFFValores() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_FF_VALOR = 1;
    final int OID_ANU_REND_FF = 2;
    final int OID_REND_MED_PAGO = 3;

    AnuladorRendFFValores pers = (AnuladorRendFFValores) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opAnuFFValores "+
                     " ( "+
                      "OID_ANU_FF_VALOR,"+
                      "OID_ANU_REND_FF,"+
                      "OID_REND_MED_PAGO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_FF_VALOR,pers.getOID());
    qInsert.setInt(OID_ANU_REND_FF,pers.getAnulador_rend_ff().getOID());
    qInsert.setInt(OID_REND_MED_PAGO,pers.getRend_medio_pago().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_REND_FF = 1;
    final int OID_REND_MED_PAGO = 2;
    final int OID_ANU_FF_VALOR = 3;

    AnuladorRendFFValores pers = (AnuladorRendFFValores) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opAnuFFValores set "+
              "oid_anu_rend_ff=?"+ 
              ",oid_rend_med_pago=?"+ 
                 " where " +
                 " oid_anu_ff_valor=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FF_VALOR,pers.getOID());
    qUpdate.setInt(OID_ANU_REND_FF,pers.getAnulador_rend_ff().getOID());
    qUpdate.setInt(OID_REND_MED_PAGO,pers.getRend_medio_pago().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FF_VALOR = 1; 
    AnuladorRendFFValores pers = (AnuladorRendFFValores) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuFFValores "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_ff_valor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FF_VALOR, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_ANU_FF_VALOR = 1; 
    AnuladorRendFFValores pers = (AnuladorRendFFValores) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update opAnuFFValores "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_anu_ff_valor=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_FF_VALOR, pers.getOID()); 
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

    final int OID_ANU_FF_VALOR = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuFFValores "); 
    textSQL.append(" WHERE oid_anu_ff_valor = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_FF_VALOR, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  opAnuFFValores "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_ff_valor oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opAnuFFValores");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
