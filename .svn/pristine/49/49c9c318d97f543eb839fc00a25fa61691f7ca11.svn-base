package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.PeriodoStockReal;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.StockPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBStockPeriodo extends DBObjetoPersistente {

  public static final String OID_STOCK_PERI = "oid_stock_peri";
  public static final String OID_PERI_STK_REAL = "oid_peri_stk_real";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String OID_UM_STK = "oid_um_stk";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String ENTRADAS = "entradas";
  public static final String SALIDAS = "salidas";

  public static final int SELECT_BY_DEPOSITO_PRODUCTO_PEDIODO = 100;

  public DBStockPeriodo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_STOCK_PERI = 1;
    final int OID_PERI_STK_REAL = 2;
    final int OID_DEPOSITO = 3;
    final int OID_UM_STK = 4;
    final int OID_PRODUCTO = 5;
    final int ENTRADAS = 6;
    final int SALIDAS = 7;

    StockPeriodo pers = (StockPeriodo) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skStockPeri "+
                     " ( "+
                      "OID_STOCK_PERI,"+
                      "OID_PERI_STK_REAL,"+
                      "OID_DEPOSITO,"+
                      "OID_UM_STK,"+
                      "OID_PRODUCTO,"+
                      "ENTRADAS,"+
                      "SALIDAS)"+
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
    qInsert.setInt(OID_STOCK_PERI,pers.getOID());
    qInsert.setInt(OID_PERI_STK_REAL,pers.getPeri_stock_real().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setInt(OID_UM_STK,pers.getUnidad_medida().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setDouble(ENTRADAS,pers.getEntradas().doubleValue());
    qInsert.setDouble(SALIDAS,pers.getSalidas().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    StockPeriodo pers = (StockPeriodo) objetoPersistente;
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skStockPeri set "+
              "entradas=entradas+?"+
              ",salidas=salidas+?"+
                 " where " +
                 " oid_stock_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setDouble(1,pers.getMovEntrada().doubleValue());
    qUpdate.setDouble(2,pers.getMovSalida().doubleValue());
    qUpdate.setInt(3,pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_STOCK_PERI = 1;
    StockPeriodo pers = (StockPeriodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockPeri "+
                     " set activo=0 " +
                     " where " +
                     " oid_stock_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_STOCK_PERI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_STOCK_PERI = 1;
    StockPeriodo pers = (StockPeriodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockPeri "+
                     " set activo=1 " +
                     " where " +
                     " oid_stock_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_STOCK_PERI, pers.getOID());
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
      case SELECT_BY_DEPOSITO_PRODUCTO_PEDIODO: {
        ps = this.selectByDepositoProductoPeriodo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_STOCK_PERI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockPeri ");
    textSQL.append(" WHERE oid_stock_peri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_STOCK_PERI, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
    final int CODIGO = 1;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockPeri ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_stock_peri oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skStockPeri");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByDepositoProductoPeriodo(Object aCondiciones) throws BaseException, SQLException {
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
    Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
    PeriodoStockReal periodoStockReal = (PeriodoStockReal) condiciones.get(PeriodoStockReal.NICKNAME);
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockPeri ");
    textSQL.append(" WHERE oid_producto = ? and oid_deposito = ? and oid_peri_stk_real = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,producto.getOID());
    querySelect.setInt(2,deposito.getOID());
    querySelect.setInt(3,periodoStockReal.getOID());
    return querySelect;
  }

  public static StockPeriodo getStockPeriodo(Producto producto,
                                             Deposito deposito,
                                             PeriodoStockReal periodoStockReal,
                                             ISesion aSesion)
                                             throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Producto.NICKNAME,producto);
    condiciones.put(Deposito.NICKNAME,deposito);
    condiciones.put(PeriodoStockReal.NICKNAME,periodoStockReal);
    return (StockPeriodo) ObjetoLogico.getObjects(StockPeriodo.NICKNAME,
                                                  DBStockPeriodo.SELECT_BY_DEPOSITO_PRODUCTO_PEDIODO,
                                                  condiciones,
                                                  new ObjetoObservado(),
                                                  aSesion);
  }


}
