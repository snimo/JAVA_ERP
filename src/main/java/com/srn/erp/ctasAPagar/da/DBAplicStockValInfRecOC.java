package com.srn.erp.ctasAPagar.da;

import java.sql.*;
import com.srn.erp.ctasAPagar.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBAplicStockValInfRecOC extends DBObjetoPersistente {

  public static final String OID_APLIC = "oid_aplic";
  public static final String OID_STOCK_VAL = "oid_stock_val";
  public static final String OID_DET_IR_OC = "oid_det_ir_oc";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM = "oid_um";
  public static final String ACTIVO = "activo";

  public DBAplicStockValInfRecOC() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_APLIC = 1;
    final int OID_STOCK_VAL = 2;
    final int OID_DET_IR_OC = 3;
    final int CANTIDAD = 4;
    final int OID_UM = 5;
    final int ACTIVO = 6;

    AplicStockValInfRecOC pers = (AplicStockValInfRecOC) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAplicStkValProv "+
                     " ( "+
                      "OID_APLIC,"+
                      "OID_STOCK_VAL,"+
                      "OID_DET_IR_OC,"+
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
    qInsert.setInt(OID_APLIC,pers.getOID());
    qInsert.setInt(OID_STOCK_VAL,pers.getStock_valorizado().getOID());
    qInsert.setInt(OID_DET_IR_OC,pers.getCompro_prov_infrec_oc().getOID());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_STOCK_VAL = 1;
    final int OID_DET_IR_OC = 2;
    final int CANTIDAD = 3;
    final int OID_UM = 4;
    final int ACTIVO = 5;
    final int OID_APLIC = 6;

    AplicStockValInfRecOC pers = (AplicStockValInfRecOC) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAplicStkValProv set "+
              "oid_stock_val=?"+ 
              ",oid_det_ir_oc=?"+ 
              ",cantidad=?"+ 
              ",oid_um=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_aplic=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC,pers.getOID());
    qUpdate.setInt(OID_STOCK_VAL,pers.getStock_valorizado().getOID());
    qUpdate.setInt(OID_DET_IR_OC,pers.getCompro_prov_infrec_oc().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC = 1; 
    AplicStockValInfRecOC pers = (AplicStockValInfRecOC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAplicStkValProv "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_aplic=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_APLIC = 1; 
    AplicStockValInfRecOC pers = (AplicStockValInfRecOC) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cpAplicStkValProv "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_aplic=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APLIC, pers.getOID()); 
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

    final int OID_APLIC = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAplicStkValProv "); 
    textSQL.append(" WHERE oid_aplic = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_APLIC, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cpAplicStkValProv "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aplic oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpAplicStkValProv");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
