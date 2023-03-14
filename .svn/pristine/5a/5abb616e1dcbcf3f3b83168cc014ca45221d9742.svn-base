package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.EstadoStock;
import com.srn.erp.stock.bm.Partida;
import com.srn.erp.stock.bm.Producto;
import com.srn.erp.stock.bm.SaldoStockPartidaSerie;
import com.srn.erp.stock.bm.Serie;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoStockPartidaSerie extends DBObjetoPersistente {

  public static final String OID_STK_SAL_P_S = "oid_stk_sal_p_s";
  public static final String OID_PARTIDA = "oid_partida";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_UM_STK = "oid_um_stk";
  public static final String SALDO_CERO = "saldo_Cero";
  public static final String OID_SERIE = "oid_serie";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String SALDO = "saldo";

  public static final int SELECT_DEPO_PROD_EST_UBI_PART_SER = 100;

  public DBSaldoStockPartidaSerie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_STK_SAL_P_S = 1;
    final int OID_PARTIDA = 2;
    final int OID_PRODUCTO = 3;
    final int OID_UM_STK = 4;
    final int SALDO_CERO = 5;
    final int OID_SERIE = 6;
    final int OID_UBI_DEPO = 7;
    final int OID_ESTADO_STOCK = 8;
    final int OID_DEPOSITO = 9;
    final int SALDO = 10;

    SaldoStockPartidaSerie pers = (SaldoStockPartidaSerie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skStockSalPartSer "+
                     " ( "+
                      "OID_STK_SAL_P_S,"+
                      "OID_PARTIDA,"+
                      "OID_PRODUCTO,"+
                      "OID_UM_STK,"+
                      "SALDO_CERO,"+
                      "OID_SERIE,"+
                      "OID_UBI_DEPO,"+
                      "OID_ESTADO_STOCK,"+
                      "OID_DEPOSITO,"+
                      "SALDO)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_STK_SAL_P_S,pers.getOID());
    if (pers.getPartida()!=null)
      qInsert.setInt(OID_PARTIDA,pers.getPartida().getOID());
    else
      qInsert.setInt(OID_PARTIDA,0);
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_UM_STK,pers.getUnidad_medida().getOID());
    qInsert.setBoolean(SALDO_CERO,pers.isSaldo_cero().booleanValue());
    if (pers.getSerie()!=null)
      qInsert.setInt(OID_SERIE,pers.getSerie().getOID());
    else
      qInsert.setInt(OID_SERIE,0);
    qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    SaldoStockPartidaSerie pers = (SaldoStockPartidaSerie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skStockSalPartSer set "+
              "saldo=saldo+?,"+
              "saldo_Cero=?"+
                 " where " +
                 " oid_stk_sal_p_s=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setDouble(1,pers.getMovimiento().doubleValue());
    qUpdate.setBoolean(2,pers.isSaldo_cero().booleanValue());
    qUpdate.setInt(3,pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_STK_SAL_P_S = 1;
    SaldoStockPartidaSerie pers = (SaldoStockPartidaSerie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSalPartSer "+
                     " set activo=0 " +
                     " where " +
                     " oid_stk_sal_p_s=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_STK_SAL_P_S, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_STK_SAL_P_S = 1;
    SaldoStockPartidaSerie pers = (SaldoStockPartidaSerie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skStockSalPartSer "+
                     " set activo=1 " +
                     " where " +
                     " oid_stk_sal_p_s=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_STK_SAL_P_S, pers.getOID());
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
      case SELECT_DEPO_PROD_EST_UBI_PART_SER: {
        ps = this.selectByDepoProdUbiEstPartSer(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_STK_SAL_P_S = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSalPartSer ");
    textSQL.append(" WHERE oid_stk_sal_p_s = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_STK_SAL_P_S, oid);
    return querySelect;
  }

  private PreparedStatement selectByDepoProdUbiEstPartSer(Object aCondiciones) throws BaseException, SQLException {
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Producto producto = (Producto)condiciones.get(Producto.NICKNAME);
    Deposito deposito = (Deposito)condiciones.get(Deposito.NICKNAME);
    EstadoStock estadoStock = (EstadoStock)condiciones.get(EstadoStock.NICKNAME);
    UbicacionDeposito ubiDepo = (UbicacionDeposito)condiciones.get(UbicacionDeposito.NICKNAME);
    Partida partida = null;
    if (condiciones.containsKey(Partida.NICKNAME))
        partida = (Partida)condiciones.get(Partida.NICKNAME);
    Serie serie = null;
    if (condiciones.containsKey(Serie.NICKNAME))
       serie = (Serie)condiciones.get(Serie.NICKNAME);
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSalPartSer ");
    textSQL.append(" WHERE oid_producto = ? and oid_deposito = ? ");
    textSQL.append(" and oid_estado_stock = ? and oid_ubi_depo = ? ");
    textSQL.append(" and oid_partida = ? and oid_serie = ? ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,producto.getOID());
    querySelect.setInt(2,deposito.getOID());
    querySelect.setInt(3,estadoStock.getOID());
    querySelect.setInt(4,ubiDepo.getOID());
    if (partida!=null)
      querySelect.setInt(5,partida.getOID());
    else
      querySelect.setInt(5,0);
    if (serie!=null)
      querySelect.setInt(6,serie.getOID());
    else
      querySelect.setInt(6,0);
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skStockSalPartSer ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_stk_sal_p_s oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skStockSalPartSer");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static SaldoStockPartidaSerie getSaldoStockPartidaSerie(Deposito deposito,
                                                                 Producto producto,
                                                                 UbicacionDeposito ubiDepo,
                                                                 EstadoStock estadoStock,
                                                                 Partida partida,
                                                                 Serie serie,
                                                                 ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Deposito.NICKNAME,deposito);
    condiciones.put(Producto.NICKNAME,producto);
    condiciones.put(UbicacionDeposito.NICKNAME,ubiDepo);
    condiciones.put(EstadoStock.NICKNAME,estadoStock);
    if (partida!=null)
      condiciones.put(Partida.NICKNAME,partida);
    if (serie!=null)
       condiciones.put(Serie.NICKNAME,serie);
    return (SaldoStockPartidaSerie) ObjetoLogico.getObjects(SaldoStockPartidaSerie.NICKNAME,
                                             DBSaldoStockPartidaSerie.SELECT_DEPO_PROD_EST_UBI_PART_SER,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }


}
