package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.pagos.bm.CertificadoRetIVACab;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBCertificadoRetIVACab extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String OID_CCO_OP = "oid_cco_op";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String OID_PERI_RET_IVA = "oid_peri_ret_iva";
  public static final String OID_CAT_RET_IVA = "oid_cat_ret_iva";
  public static final String PORC_LIB = "porc_lib";
  public static final String DECRETO = "decreto";

  public DBCertificadoRetIVACab() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_CCO_OP = 2;
    final int OID_PROVEEDOR = 3;
    final int OID_PERI_RET_IVA = 4;
    final int OID_CAT_RET_IVA = 5;
    final int PORC_LIB = 6;
    final int DECRETO = 7;

    CertificadoRetIVACab pers = (CertificadoRetIVACab) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opComproRetIVA "+
                     " ( "+
                      "OID_CCO,"+
                      "OID_CCO_OP,"+
                      "OID_PROVEEDOR,"+
                      "OID_PERI_RET_IVA,"+
                      "OID_CAT_RET_IVA,"+
                      "PORC_LIB,"+
                      "DECRETO)"+
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
    qInsert.setInt(OID_CCO,pers.getOID());
    qInsert.setInt(OID_CCO_OP,pers.getOrdenpago().getOID());
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qInsert.setInt(OID_PERI_RET_IVA,pers.getPeriretiva().getOID());
    qInsert.setInt(OID_CAT_RET_IVA,pers.getCatretiva().getOID());
    qInsert.setDouble(PORC_LIB,pers.getPorclib().doubleValue());
    qInsert.setString(DECRETO,pers.getDecreto());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_OP = 1;
    final int OID_PROVEEDOR = 2;
    final int OID_PERI_RET_IVA = 3;
    final int OID_CAT_RET_IVA = 4;
    final int PORC_LIB = 5;
    final int DECRETO = 6;
    final int OID_CCO = 7;

    CertificadoRetIVACab pers = (CertificadoRetIVACab) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opComproRetIVA set "+
              "oid_cco_op=?"+
              ",oid_proveedor=?"+
              ",oid_peri_ret_iva=?"+
              ",oid_cat_ret_iva=?"+
              ",porc_lib=?"+
              ",decreto=?"+
                 " where " +
                 " oid_cco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO,pers.getOID());
    qUpdate.setInt(OID_CCO_OP,pers.getOrdenpago().getOID());
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qUpdate.setInt(OID_PERI_RET_IVA,pers.getPeriretiva().getOID());
    qUpdate.setInt(OID_CAT_RET_IVA,pers.getCatretiva().getOID());
    qUpdate.setDouble(PORC_LIB,pers.getPorclib().doubleValue());
    qUpdate.setString(DECRETO,pers.getDecreto());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    CertificadoRetIVACab pers = (CertificadoRetIVACab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproRetIVA "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    CertificadoRetIVACab pers = (CertificadoRetIVACab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproRetIVA "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
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

    final int OID_CCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproRetIVA ");
    textSQL.append(" WHERE oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproRetIVA ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opComproRetIVA");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
