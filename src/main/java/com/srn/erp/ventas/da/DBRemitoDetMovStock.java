package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.RemitoDetMovStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRemitoDetMovStock extends DBObjetoPersistente {

  public static final String OID_RTO_MOV_STK = "oid_rto_mov_stk";
  public static final String OID_REMITO_DET = "oid_remito_det";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String TIPO_MOV = "tipo_movi";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String ACTIVO = "activo";
  public static final String AFECTA_STK_FISICO = "afecta_stk_fisico";

  public static final int SELECT_BY_REMITO = 100;

  public DBRemitoDetMovStock() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RTO_MOV_STK = 1;
    final int OID_REMITO_DET = 2;
    final int OID_UBI_DEPO = 3;
    final int OID_PRODUCTO = 4;
    final int OID_DEPOSITO = 5;
    final int TIPO_MOVI = 6;
    final int OID_ESTADO_STOCK = 7;
    final int ACTIVO = 8;
    final int AFECTA_STK_FISICO = 9;

    RemitoDetMovStock pers = (RemitoDetMovStock) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veRtoDetMovStock "+
                     " ( "+
                      "OID_RTO_MOV_STK,"+
                      "OID_REMITO_DET,"+
                      "OID_UBI_DEPO,"+
                      "OID_PRODUCTO,"+
                      "OID_DEPOSITO,"+
                      "TIPO_MOVI,"+
                      "OID_ESTADO_STOCK,"+
                      "ACTIVO,"+
                      "AFECTA_STK_FISICO"+
                      ")"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_RTO_MOV_STK,pers.getOID());
    qInsert.setInt(OID_REMITO_DET,pers.getRemito_detalle().getOID());
    qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setString(TIPO_MOVI,pers.getTipo_mov());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(AFECTA_STK_FISICO,pers.isAfectaStkFisico().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_REMITO_DET = 1;
    final int OID_UBI_DEPO = 2;
    final int OID_PRODUCTO = 3;
    final int OID_DEPOSITO = 4;
    final int TIPO_MOVI = 5;
    final int OID_ESTADO_STOCK = 6;
    final int ACTIVO = 7;
    final int AFECTA_STK_FISICO = 8;
    final int OID_RTO_MOV_STK = 9;

    RemitoDetMovStock pers = (RemitoDetMovStock) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veRtoDetMovStock set "+
              "oid_remito_det=?"+
              ",oid_ubi_depo=?"+
              ",oid_producto=?"+
              ",oid_deposito=?"+
              ",tipo_movi=?"+
              ",oid_estado_stock=?"+
              ",activo=?"+
              ",afecta_stk_fisico"+
                 " where " +
                 " oid_rto_mov_stk=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_MOV_STK,pers.getOID());
    qUpdate.setInt(OID_REMITO_DET,pers.getRemito_detalle().getOID());
    qUpdate.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qUpdate.setString(TIPO_MOVI,pers.getTipo_mov());
    qUpdate.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(AFECTA_STK_FISICO,pers.isAfectaStkFisico().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RTO_MOV_STK = 1;
    RemitoDetMovStock pers = (RemitoDetMovStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veRtoDetMovStock "+
                     " where " +
                     " oid_rto_mov_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_MOV_STK, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RTO_MOV_STK = 1;
    RemitoDetMovStock pers = (RemitoDetMovStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veRtoDetMovStock "+
                     " set activo=1 " +
                     " where " +
                     " oid_rto_mov_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_MOV_STK, pers.getOID());
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
      case SELECT_BY_REMITO: {
        ps = this.selectByRemito(aCondiciones);
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_RTO_MOV_STK = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoDetMovStock ");
    textSQL.append(" WHERE oid_rto_mov_stk = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RTO_MOV_STK, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoDetMovStock ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByRemito(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoDetMovStock ");
    textSQL.append(" WHERE oid_remito_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    RemitoDet remitoDet = (RemitoDet) aCondiciones;
    querySelect.setInt(1, remitoDet.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rto_mov_stk oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veRtoDetMovStock");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getRemitoDetMovStock(RemitoDet remitoDet,
                                          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RemitoDetMovStock.NICKNAME,
                                          DBRemitoDetMovStock.SELECT_BY_REMITO,
                                          remitoDet,
                                          new ListObserver(),
                                          aSesion);
  }


}
