package com.srn.erp.stock.da;

import java.sql.*;
import com.srn.erp.stock.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAplicInfRecRto extends DBObjetoPersistente {

  public static final String OID_APLIC_INF_RTO = "oid_aplic_inf_rto";
  public static final String OID_INF_REC_DET = "oid_inf_rec_det";
  public static final String OID_REMITO_DET = "oid_remito_det";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM = "oid_um";
  public static final String ACTIVO = "activo";

  public DBAplicInfRecRto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_APLIC_INF_RTO = 1;
    final int OID_INF_REC_DET = 2;
    final int OID_REMITO_DET = 3;
    final int CANTIDAD = 4;
    final int OID_UM = 5;
    final int ACTIVO = 6;

    AplicInfRecRto pers = (AplicInfRecRto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAplicInfRecRto "+
                     " ( "+
                      "OID_APLIC_INF_RTO,"+
                      "OID_INF_REC_DET,"+
                      "OID_REMITO_DET,"+
                      "CANTIDAD,"+
                      "OID_UM,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_APLIC_INF_RTO,pers.getOID());
    qInsert.setInt(OID_INF_REC_DET,pers.getInf_rec_det().getOID());
    qInsert.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_UM,pers.getUm().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_INF_REC_DET = 1;
    final int OID_REMITO_DET = 2;
    final int CANTIDAD = 3;
    final int OID_UM = 4;
    final int ACTIVO = 5;
    final int OID_APLIC_INF_RTO = 6;

    AplicInfRecRto pers = (AplicInfRecRto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAplicInfRecRto set "+
              "oid_inf_rec_det=?"+ 
              ",oid_remito_det=?"+ 
              ",cantidad=?"+ 
              ",oid_um=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_aplic_inf_rto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_INF_RTO,pers.getOID());
    qUpdate.setInt(OID_INF_REC_DET,pers.getInf_rec_det().getOID());
    qUpdate.setInt(OID_REMITO_DET,pers.getRemito_det().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_UM,pers.getUm().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC_INF_RTO = 1; 
    AplicInfRecRto pers = (AplicInfRecRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAplicInfRecRto "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_aplic_inf_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_INF_RTO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC_INF_RTO = 1; 
    AplicInfRecRto pers = (AplicInfRecRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAplicInfRecRto "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_aplic_inf_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC_INF_RTO, pers.getOID()); 
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

    final int OID_APLIC_INF_RTO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAplicInfRecRto "); 
    textSQL.append(" WHERE oid_aplic_inf_rto = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_APLIC_INF_RTO, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAplicInfRecRto "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aplic_inf_rto oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAplicInfRecRto");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
