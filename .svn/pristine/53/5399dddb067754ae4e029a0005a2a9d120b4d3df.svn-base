package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.RemitoCabMovStock;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRemitoCabMovStock extends DBObjetoPersistente {

  public static final String OID_RTO_CAB_STK = "oid_rto_cab_stk";
  public static final String OID_REMITO_CAB = "oid_remito_cab";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String TIPO_MOVI = "tipo_movi";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String ACTIVO = "activo";
  public static final String AFECTA_STK_FISICO = "afecta_stk_fisico";

  public static final int SELECT_BY_REMITO_CAB = 100;

  public DBRemitoCabMovStock() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RTO_CAB_STK = 1;
    final int OID_REMITO_CAB = 2;
    final int OID_DEPOSITO = 3;
    final int TIPO_MOVI = 4;
    final int OID_ESTADO_STOCK = 5;
    final int OID_UBI_DEPO = 6;
    final int ACTIVO = 7;
    final int AFECTA_STK_FISICO = 8;

    RemitoCabMovStock pers = (RemitoCabMovStock) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veRtoCabMovStk "+
                     " ( "+
                      "OID_RTO_CAB_STK,"+
                      "OID_REMITO_CAB,"+
                      "OID_DEPOSITO,"+
                      "TIPO_MOVI,"+
                      "OID_ESTADO_STOCK,"+
                      "OID_UBI_DEPO,"+
                      "ACTIVO,"+
                      "AFECTA_STK_FISICO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_RTO_CAB_STK,pers.getOID());
    qInsert.setInt(OID_REMITO_CAB,pers.getRemito_cabecera().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setString(TIPO_MOVI,pers.getTipo_movi());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(AFECTA_STK_FISICO,pers.isAfectaStkFisico().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_REMITO_CAB = 1;
    final int OID_DEPOSITO = 2;
    final int TIPO_MOVI = 3;
    final int OID_ESTADO_STOCK = 4;
    final int OID_UBI_DEPO = 5;
    final int ACTIVO = 6;
    final int AFECTA_STK_FISICO = 7;
    final int OID_RTO_CAB_STK = 8;


    RemitoCabMovStock pers = (RemitoCabMovStock) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veRtoCabMovStk set "+
              "oid_remito_cab=?"+
              ",oid_deposito=?"+
              ",tipo_movi=?"+
              ",oid_estado_stock=?"+
              ",oid_ubi_depo=?"+
              ",activo=?"+
              ",afecta_stk_fisico=?"+
                 " where " +
                 " oid_rto_cab_stk=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_CAB_STK,pers.getOID());
    qUpdate.setInt(OID_REMITO_CAB,pers.getRemito_cabecera().getOID());
    qUpdate.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qUpdate.setString(TIPO_MOVI,pers.getTipo_movi());
    qUpdate.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qUpdate.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(AFECTA_STK_FISICO,pers.isAfectaStkFisico().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RTO_CAB_STK = 1;
    RemitoCabMovStock pers = (RemitoCabMovStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veRtoCabMovStk "+
                     " where " +
                     " oid_rto_cab_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_CAB_STK, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RTO_CAB_STK = 1;
    RemitoCabMovStock pers = (RemitoCabMovStock) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veRtoCabMovStk "+
                     " set activo=1 " +
                     " where " +
                     " oid_rto_cab_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_CAB_STK, pers.getOID());
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
      case SELECT_BY_REMITO_CAB: {
        ps = this.selectByRemitoCab(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_RTO_CAB_STK = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoCabMovStk ");
    textSQL.append(" WHERE oid_rto_cab_stk = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RTO_CAB_STK, oid);
    return querySelect;
  }

  private PreparedStatement selectByRemitoCab(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoCabMovStk ");
    textSQL.append(" WHERE  oid_remito_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    RemitoCab remitoCab = (RemitoCab) aCondiciones;
    querySelect.setInt(1, remitoCab.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoCabMovStk ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rto_cab_stk oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veRtoCabMovStk");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getMovimientosStock(RemitoCab remitoCab,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RemitoCabMovStock.NICKNAME,
                                          DBRemitoCabMovStock.SELECT_BY_REMITO_CAB,
                                          remitoCab,
                                          new ListObserver(),
                                          aSesion);
  }


}
