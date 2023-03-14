package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockProducto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoStockProducto extends DBObjetoPersistente {

  public static final String OID_SALDO_PROD = "oid_saldo_prod";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_UM_STK = "oid_um_stk";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String SALDO = "saldo";

  public static final int SELECT_BY_PRODUCTO_DEPOSITO = 100;

  public DBSaldoStockProducto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SALDO_PROD = 1;
    final int OID_PRODUCTO = 2;
    final int OID_UM_STK = 3;
    final int OID_DEPOSITO = 4;
    final int SALDO = 5;

    SaldoStockProducto pers = (SaldoStockProducto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skStockSaldoProd "+
                     " ( "+
                      "OID_SALDO_PROD,"+
                      "OID_PRODUCTO,"+
                      "OID_UM_STK,"+
                      "OID_DEPOSITO,"+
                      "SALDO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_SALDO_PROD,pers.getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_UM_STK,pers.getUnidad_medida().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    SaldoStockProducto pers = (SaldoStockProducto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skStockSaldoProd set "+
              " saldo=saldo+?"+
                 " where " +
                 " oid_saldo_prod=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setDouble(1,pers.getMovimiento().doubleValue() );
    qUpdate.setInt(2,pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SALDO_PROD = 1;
    SaldoStockProducto pers = (SaldoStockProducto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSaldoProd "+
                     " set activo=0 " +
                     " where " +
                     " oid_saldo_prod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SALDO_PROD, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SALDO_PROD = 1;
    SaldoStockProducto pers = (SaldoStockProducto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSaldoProd "+
                     " set activo=1 " +
                     " where " +
                     " oid_saldo_prod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SALDO_PROD, pers.getOID());
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
      case SELECT_BY_PRODUCTO_DEPOSITO : {
        ps = this.selectByProductoDeposito(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_SALDO_PROD = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoProd ");
    textSQL.append(" WHERE oid_saldo_prod = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SALDO_PROD, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoProd ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByProductoDeposito(Object aCondiciones) throws BaseException, SQLException {

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
    Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoProd ");
    textSQL.append(" WHERE oid_producto = ? and oid_deposito = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,producto.getOID());
    querySelect.setInt(2,deposito.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_saldo_prod oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skStockSaldoProd");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static SaldoStockProducto getSaldoStockProducto(Producto producto,
                                                         Deposito deposito,
                                                         ISesion aSesion)
                                                         throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Producto.NICKNAME,producto);
    condiciones.put(Deposito.NICKNAME,deposito);
    return (SaldoStockProducto) ObjetoLogico.getObjects(SaldoStockProducto.NICKNAME,
                                             DBSaldoStockProducto.SELECT_BY_PRODUCTO_DEPOSITO,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }


}
