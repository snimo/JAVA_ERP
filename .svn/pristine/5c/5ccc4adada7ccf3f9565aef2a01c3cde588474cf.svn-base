package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockUbi;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoStockUbi extends DBObjetoPersistente {

  public static final String OID_SAL_STK_UBI = "oid_Sal_stk_ubi";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String OID_UM_STK = "oid_um_stk";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String SALDO = "saldo";

  public static final int SELECT_BY_DEPO_PROD_UBI = 100;

  public DBSaldoStockUbi() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SAL_STK_UBI = 1;
    final int OID_DEPOSITO = 2;
    final int OID_UBI_DEPO = 3;
    final int OID_UM_STK = 4;
    final int OID_PRODUCTO = 5;
    final int SALDO = 6;

    SaldoStockUbi pers = (SaldoStockUbi) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skStockSaldoUbi "+
                     " ( "+
                      "OID_SAL_STK_UBI,"+
                      "OID_DEPOSITO,"+
                      "OID_UBI_DEPO,"+
                      "OID_UM_STK,"+
                      "OID_PRODUCTO,"+
                      "SALDO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_SAL_STK_UBI,pers.getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qInsert.setInt(OID_UM_STK,pers.getUnidad_medida().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    SaldoStockUbi pers = (SaldoStockUbi) objetoPersistente;
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skStockSaldoUbi set "+
              "saldo=saldo+?"+
                 " where " +
                 " oid_sal_stk_ubi=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setDouble(1,pers.getMovimiento().doubleValue());
    qUpdate.setInt(2,pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SAL_STK_UBI = 1;
    SaldoStockUbi pers = (SaldoStockUbi) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSaldoUbi "+
                     " set activo=0 " +
                     " where " +
                     " oid_sal_stk_ubi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SAL_STK_UBI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SAL_STK_UBI = 1;
    SaldoStockUbi pers = (SaldoStockUbi) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSaldoUbi "+
                     " set activo=1 " +
                     " where " +
                     " oid_sal_stk_ubi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SAL_STK_UBI, pers.getOID());
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
      case SELECT_BY_DEPO_PROD_UBI: {
        ps = this.selectByDepoProdUbi(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_SAL_STK_UBI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoUbi ");
    textSQL.append(" WHERE oid_sal_stk_ubi = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SAL_STK_UBI, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoUbi ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByDepoProdUbi(Object aCondiciones) throws BaseException, SQLException {
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
    Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
    UbicacionDeposito ubiDepo = (UbicacionDeposito) condiciones.get(UbicacionDeposito.NICKNAME);
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoUbi ");
    textSQL.append(" WHERE oid_producto = ? and oid_deposito = ? and oid_ubi_depo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,producto.getOID());
    querySelect.setInt(2,deposito.getOID());
    querySelect.setInt(3,ubiDepo.getOID());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_Sal_stk_ubi oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skStockSaldoUbi");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static SaldoStockUbi getSaldoStockUbi(Producto producto,
                                               Deposito deposito,
                                               UbicacionDeposito ubicacionDeposito,
                                               ISesion aSesion) throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Producto.NICKNAME,producto);
    condiciones.put(Deposito.NICKNAME,deposito);
    condiciones.put(UbicacionDeposito.NICKNAME,ubicacionDeposito);
    return (SaldoStockUbi) ObjetoLogico.getObjects(SaldoStockUbi.NICKNAME,
                                                   DBSaldoStockUbi.SELECT_BY_DEPO_PROD_UBI,
                                                   condiciones,
                                                   new ObjetoObservado(),
                                                   aSesion);
  }


}
