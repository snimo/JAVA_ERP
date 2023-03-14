package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockUbiEstado;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoStockUbiEstado extends DBObjetoPersistente {

  public static final String OID_SAL_STK_UBI_E = "oid_sal_stk_ubi_e";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String OID_UM_STK = "oid_um_stk";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String SALDO = "saldo";

  public static final int SELECT_BY_DEPO_PROD_UBI_EST = 100;

  public DBSaldoStockUbiEstado() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SAL_STK_UBI_E = 1;
    final int OID_DEPOSITO = 2;
    final int OID_UBI_DEPO = 3;
    final int OID_UM_STK = 4;
    final int OID_PRODUCTO = 5;
    final int OID_ESTADO_STOCK = 6;
    final int SALDO = 7;

    SaldoStockUbiEstado pers = (SaldoStockUbiEstado) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skStockSaldoUbiEst "+
                     " ( "+
                      "OID_SAL_STK_UBI_E,"+
                      "OID_DEPOSITO,"+
                      "OID_UBI_DEPO,"+
                      "OID_UM_STK,"+
                      "OID_PRODUCTO,"+
                      "OID_ESTADO_STOCK,"+
                      "SALDO)"+
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
    qInsert.setInt(OID_SAL_STK_UBI_E,pers.getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qInsert.setInt(OID_UM_STK,pers.getUnidad_medida().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    SaldoStockUbiEstado pers = (SaldoStockUbiEstado) objetoPersistente;
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skStockSaldoUbiEst set "+
              "saldo=saldo+?"+
                 " where " +
                 " oid_sal_stk_ubi_e=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setDouble(1,pers.getMovimiento().doubleValue());
    qUpdate.setInt(2,pers.getOID());

    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SAL_STK_UBI_E = 1;
    SaldoStockUbiEstado pers = (SaldoStockUbiEstado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSaldoUbiEst "+
                     " set activo=0 " +
                     " where " +
                     " oid_sal_stk_ubi_e=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SAL_STK_UBI_E, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SAL_STK_UBI_E = 1;
    SaldoStockUbiEstado pers = (SaldoStockUbiEstado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSaldoUbiEst "+
                     " set activo=1 " +
                     " where " +
                     " oid_sal_stk_ubi_e=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SAL_STK_UBI_E, pers.getOID());
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
      case SELECT_BY_DEPO_PROD_UBI_EST: {
        ps = this.selectByDepoProdUbiEst(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_SAL_STK_UBI_E = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoUbiEst ");
    textSQL.append(" WHERE oid_sal_stk_ubi_e = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SAL_STK_UBI_E, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoUbiEst ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByDepoProdUbiEst(Object aCondiciones) throws BaseException, SQLException {

    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Producto producto = (Producto) condiciones.get(Producto.NICKNAME);
    Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
    UbicacionDeposito ubiDepo = (UbicacionDeposito) condiciones.get(UbicacionDeposito.NICKNAME);
    EstadoStock estStock = (EstadoStock) condiciones.get(EstadoStock.NICKNAME);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSaldoUbiEst ");
    textSQL.append(" WHERE oid_producto = ? and oid_deposito = ? and oid_ubi_depo = ? and oid_estado_stock = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,producto.getOID());
    querySelect.setInt(2,deposito.getOID());
    querySelect.setInt(3,ubiDepo.getOID());
    querySelect.setInt(4,estStock.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sal_stk_ubi_e oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skStockSaldoUbiEst");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static SaldoStockUbiEstado getSaldoStockUbiEstado(Producto producto,
                                                           Deposito deposito,
                                                           UbicacionDeposito ubiDepo,
                                                           EstadoStock estStock,
                                                           ISesion aSesion)
                                                           throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Producto.NICKNAME,producto);
    condiciones.put(Deposito.NICKNAME,deposito);
    condiciones.put(UbicacionDeposito.NICKNAME,ubiDepo);
    condiciones.put(EstadoStock.NICKNAME,estStock);
    return (SaldoStockUbiEstado) ObjetoLogico.getObjects(SaldoStockUbiEstado.NICKNAME,
                                                         DBSaldoStockUbiEstado.SELECT_BY_DEPO_PROD_UBI_EST,
                                                         condiciones,
                                                         new ObjetoObservado(),
                                                         aSesion);
  }


}
