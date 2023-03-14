package com.srn.erp.stock.da;

import java.sql.*;
import com.srn.erp.stock.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBStockValorizado extends DBObjetoPersistente {

  public static final String OID_STOCK_VAL = "oid_Stock_val";
  public static final String OID_CCO_MOV_STOCK = "oid_cco_mov_stock";
  public static final String FECHA = "fecha";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM = "oid_um";
  public static final String SIGNO = "signo";
  public static final String COSTO_TOTAL = "costo_total";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COSTO_UNITARIO = "costo_unitario";
  public static final String OID_CCO_VALORIZ = "oid_cco_valoriz";
  public static final String ACTIVO = "activo";
  public static final String OID_DEPO  = "oid_depo";

  public DBStockValorizado() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_STOCK_VAL = 1;
    final int OID_CCO_MOV_STOCK = 2;
    final int FECHA = 3;
    final int OID_PRODUCTO = 4;
    final int CANTIDAD = 5;
    final int OID_UM = 6;
    final int SIGNO = 7;
    final int COSTO_TOTAL = 8;
    final int OID_MONEDA = 9;
    final int COSTO_UNITARIO = 10;
    final int OID_CCO_VALORIZ = 11;
    final int ACTIVO = 12;
    final int OID_DEPO = 13;

    StockValorizado pers = (StockValorizado) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skStockValorizado "+
                     " ( "+
                      "OID_STOCK_VAL,"+
                      "OID_CCO_MOV_STOCK,"+
                      "FECHA,"+
                      "OID_PRODUCTO,"+
                      "CANTIDAD,"+
                      "OID_UM,"+
                      "SIGNO,"+
                      "COSTO_TOTAL,"+
                      "OID_MONEDA,"+
                      "COSTO_UNITARIO,"+
                      "OID_CCO_VALORIZ,"+
                      "ACTIVO,OID_DEPO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_STOCK_VAL,pers.getOID());
    qInsert.setInt(OID_CCO_MOV_STOCK,pers.getCompro_mov_stk().getOID());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.setDouble(COSTO_TOTAL,pers.getCosto_total().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(COSTO_UNITARIO,pers.getCosto_unitario().doubleValue());
    if (pers.getCompro_valorizador()!=null) 
      qInsert.setInt(OID_CCO_VALORIZ,pers.getCompro_valorizador().getOID());
    else
      qInsert.setNull(OID_CCO_VALORIZ,java.sql.Types.INTEGER);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_DEPO, pers.getDeposito().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CCO_MOV_STOCK = 1;
    final int FECHA = 2;
    final int OID_PRODUCTO = 3;
    final int CANTIDAD = 4;
    final int OID_UM = 5;
    final int SIGNO = 6;
    final int COSTO_TOTAL = 7;
    final int OID_MONEDA = 8;
    final int COSTO_UNITARIO = 9;
    final int OID_CCO_VALORIZ = 10;
    final int ACTIVO = 11;
    final int OID_DEPO = 12;
    final int OID_STOCK_VAL = 13;

    StockValorizado pers = (StockValorizado) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skStockValorizado set "+
              "oid_cco_mov_stock=?"+ 
              ",fecha=?"+ 
              ",oid_producto=?"+ 
              ",cantidad=?"+ 
              ",oid_um=?"+ 
              ",signo=?"+ 
              ",costo_total=?"+ 
              ",oid_moneda=?"+ 
              ",costo_unitario=?"+ 
              ",oid_cco_valoriz=?"+ 
              ",activo=? , oid_depo = ? "+ 
                 " where " +
                 " oid_stock_val=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_STOCK_VAL,pers.getOID());
    qUpdate.setInt(OID_CCO_MOV_STOCK,pers.getCompro_mov_stk().getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_UM,pers.getUnidad_medida().getOID());
    qUpdate.setInt(SIGNO,pers.getSigno().intValue());
    qUpdate.setDouble(COSTO_TOTAL,pers.getCosto_total().doubleValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(COSTO_UNITARIO,pers.getCosto_unitario().doubleValue());
    if (pers.getCompro_valorizador()!=null) 
      qUpdate.setInt(OID_CCO_VALORIZ,pers.getCompro_valorizador().getOID());
    else
      qUpdate.setNull(OID_CCO_VALORIZ,java.sql.Types.INTEGER);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_DEPO, pers.getDeposito().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_STOCK_VAL = 1; 
    StockValorizado pers = (StockValorizado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skStockValorizado "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_stock_val=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_STOCK_VAL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_STOCK_VAL = 1; 
    StockValorizado pers = (StockValorizado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update skStockValorizado "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_stock_val=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_STOCK_VAL, pers.getOID()); 
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

    final int OID_STOCK_VAL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skStockValorizado "); 
    textSQL.append(" WHERE oid_stock_val = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_STOCK_VAL, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  skStockValorizado "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_Stock_val oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skStockValorizado");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
