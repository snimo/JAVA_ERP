package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.compras.bm.AnuladorRequisicionCab;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorRequisicionCab extends DBObjetoPersistente {

  public static final String OID_ANU_REQ_CAB = "oid_anu_req_cab";
  public static final String OID_CCO_REQUI = "oid_cco_requi";

  public DBAnuladorRequisicionCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_REQ_CAB = 1;
    final int OID_CCO_REQUI = 2;

    AnuladorRequisicionCab pers = (AnuladorRequisicionCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAnuRequiCab "+
                     " ( "+
                      "OID_ANU_REQ_CAB,"+
                      "OID_CCO_REQUI)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_REQ_CAB,pers.getOID());
    qInsert.setInt(OID_CCO_REQUI,pers.getRequisicionCab().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_REQUI = 1;
    final int OID_ANU_REQ_CAB = 2;

    AnuladorRequisicionCab pers = (AnuladorRequisicionCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAnuRequiCab set "+
              "oid_cco_requi=?"+ 
                 " where " +
                 " oid_anu_req_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_REQ_CAB,pers.getOID());
    qUpdate.setInt(OID_CCO_REQUI,pers.getRequisicionCab().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    AnuladorRequisicionCab pers = (AnuladorRequisicionCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAnuRequiCab "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_anu_req_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
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

    final int OID_ANU_REQ_CAB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAnuRequiCab "); 
    textSQL.append(" WHERE oid_anu_req_cab = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_ANU_REQ_CAB, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 
	  return null;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {
	  return null;
  } 
  
} 
