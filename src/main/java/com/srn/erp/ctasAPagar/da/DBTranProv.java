package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctasAPagar.bm.TranProv;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBTranProv extends DBObjetoPersistente {

  public static final String OID_TRAN_PROV = "oid_tran_prov";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_TIPO_CTA_PROV = "oid_tipo_cta_prov";
  public static final String IMPORTE = "importe";
  public static final String SALDO = "saldo";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String PENDIENTE = "pendiente";
  public static final String IMPUTAC = "imputac";
  public static final String EMISION = "emision";
  public static final String BASE = "base";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COTIZ_MON_ORI = "cotiz_mon_ori";
  public static final String COTIZ_MON_EXT1 = "cotiz_mon_ext1";
  public static final String COTIZ_MON_EXT2 = "cotiz_mon_ext2";
  public static final String COTIZ_MON_ORI_CO = "cotiz_mon_ori_co";
  public static final String COTIZ_MON_EXT1_CO = "cotiz_mon_ext1_co";
  public static final String COTIZ_MON_EXT2_CO = "cotiz_mon_ext2_co";

  public DBTranProv() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TRAN_PROV = 1;
    final int OID_CCO = 2;
    final int OID_TIPO_CTA_PROV = 3;
    final int IMPORTE = 4;
    final int SALDO = 5;
    final int OID_PROVEEDOR = 6;
    final int PENDIENTE = 7;
    final int IMPUTAC = 8;
    final int EMISION = 9;
    final int BASE = 10;
    final int OID_MONEDA = 11;
    final int COTIZ_MON_ORI = 12;
    final int COTIZ_MON_EXT1 = 13;
    final int COTIZ_MON_EXT2 = 14;
    final int COTIZ_MON_ORI_CO = 15;
    final int COTIZ_MON_EXT1_CO = 16;
    final int COTIZ_MON_EXT2_CO = 17;

    TranProv pers = (TranProv) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpTranProv "+
                     " ( "+
                      "OID_TRAN_PROV,"+
                      "OID_CCO,"+
                      "OID_TIPO_CTA_PROV,"+
                      "IMPORTE,"+
                      "SALDO,"+
                      "OID_PROVEEDOR,"+
                      "PENDIENTE,"+
                      "IMPUTAC,"+
                      "EMISION,"+
                      "BASE,"+
                      "OID_MONEDA,"+
                      "COTIZ_MON_ORI,"+
                      "COTIZ_MON_EXT1,"+
                      "COTIZ_MON_EXT2,"+
                      "COTIZ_MON_ORI_CO,"+
                      "COTIZ_MON_EXT1_CO,"+
                      "COTIZ_MON_EXT2_CO)"+
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_TRAN_PROV,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(OID_TIPO_CTA_PROV,pers.getTipocuenta().getOID());
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qInsert.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    qInsert.setDate(IMPUTAC,new java.sql.Date(pers.getImputac().getTime()));
    qInsert.setDate(EMISION,new java.sql.Date(pers.getEmision().getTime()));
    qInsert.setDate(BASE,new java.sql.Date(pers.getBase().getTime()));
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(COTIZ_MON_ORI,pers.getCotizmonedaori().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT1,pers.getCotizmonedaext1().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT2,pers.getCotizmonedaext2().doubleValue());
    qInsert.setDouble(COTIZ_MON_ORI_CO,pers.getCotizmonedaoricon().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT1_CO,pers.getCotizmonedaext1con().doubleValue());
    qInsert.setDouble(COTIZ_MON_EXT2_CO,pers.getCotizmonedaext2con().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_TIPO_CTA_PROV = 2;
    final int IMPORTE = 3;
    final int SALDO = 4;
    final int OID_PROVEEDOR = 5;
    final int PENDIENTE = 6;
    final int IMPUTAC = 7;
    final int EMISION = 8;
    final int BASE = 9;
    final int OID_MONEDA = 10;
    final int COTIZ_MON_ORI = 11;
    final int COTIZ_MON_EXT1 = 12;
    final int COTIZ_MON_EXT2 = 13;
    final int COTIZ_MON_ORI_CO = 14;
    final int COTIZ_MON_EXT1_CO = 15;
    final int COTIZ_MON_EXT2_CO = 16;
    final int OID_TRAN_PROV = 17;

    TranProv pers = (TranProv) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpTranProv set "+
              "oid_cco=?"+
              ",oid_tipo_cta_prov=?"+
              ",importe=?"+
              ",saldo=?"+
              ",oid_proveedor=?"+
              ",pendiente=?"+
              ",imputac=?"+
              ",emision=?"+
              ",base=?"+
              ",oid_moneda=?"+
              ",cotiz_mon_ori=?"+
              ",cotiz_mon_ext1=?"+
              ",cotiz_mon_ext2=?"+
              ",cotiz_mon_ori_co=?"+
              ",cotiz_mon_ext1_co=?"+
              ",cotiz_mon_ext2_co=?"+
                 " where " +
                 " oid_tran_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TRAN_PROV,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(OID_TIPO_CTA_PROV,pers.getTipocuenta().getOID());
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qUpdate.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    qUpdate.setDate(IMPUTAC,new java.sql.Date(pers.getImputac().getTime()));
    qUpdate.setDate(EMISION,new java.sql.Date(pers.getEmision().getTime()));
    qUpdate.setDate(BASE,new java.sql.Date(pers.getBase().getTime()));
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(COTIZ_MON_ORI,pers.getCotizmonedaori().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT1,pers.getCotizmonedaext1().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT2,pers.getCotizmonedaext2().doubleValue());
    qUpdate.setDouble(COTIZ_MON_ORI_CO,pers.getCotizmonedaoricon().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT1_CO,pers.getCotizmonedaext1con().doubleValue());
    qUpdate.setDouble(COTIZ_MON_EXT2_CO,pers.getCotizmonedaext2con().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TRAN_PROV = 1;
    TranProv pers = (TranProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpTranProv "+
                     " set activo=0 " +
                     " where " +
                     " oid_tran_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TRAN_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TRAN_PROV = 1;
    TranProv pers = (TranProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpTranProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_tran_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TRAN_PROV, pers.getOID());
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

    final int OID_TRAN_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpTranProv ");
    textSQL.append(" WHERE oid_tran_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TRAN_PROV, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpTranProv ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tran_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpTranProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
