package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.pagos.bm.RetencionConcImpuOP;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBRetencionConcImpuOP extends DBObjetoPersistente {

  public static final String OID_OP_RET_CIMP = "oid_op_ret_cimp";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String IMPO_MON_PAGO = "impo_mon_pago";
  public static final String IMPO_MON_LOC = "impo_mon_loc";

  public DBRetencionConcImpuOP() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OP_RET_CIMP = 1;
    final int OID_CCO = 2;
    final int OID_CONC_IMPU = 3;
    final int IMPO_MON_PAGO = 4;
    final int IMPO_MON_LOC = 5;

    RetencionConcImpuOP pers = (RetencionConcImpuOP) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opComproOPRetCImp "+
                     " ( "+
                      "OID_OP_RET_CIMP,"+
                      "OID_CCO,"+
                      "OID_CONC_IMPU,"+
                      "IMPO_MON_PAGO,"+
                      "IMPO_MON_LOC)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_OP_RET_CIMP,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConcimpuesto().getOID());
    qInsert.setDouble(IMPO_MON_PAGO,pers.getImpomonpago().doubleValue());
    qInsert.setDouble(IMPO_MON_LOC,pers.getImpomonlocal().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_CONC_IMPU = 2;
    final int IMPO_MON_PAGO = 3;
    final int IMPO_MON_LOC = 4;
    final int OID_OP_RET_CIMP = 5;

    RetencionConcImpuOP pers = (RetencionConcImpuOP) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opComproOPRetCImp set "+
              "oid_cco=?"+
              ",oid_conc_impu=?"+
              ",impo_mon_pago=?"+
              ",impo_mon_loc=?"+
                 " where " +
                 " oid_op_ret_cimp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OP_RET_CIMP,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConcimpuesto().getOID());
    qUpdate.setDouble(IMPO_MON_PAGO,pers.getImpomonpago().doubleValue());
    qUpdate.setDouble(IMPO_MON_LOC,pers.getImpomonlocal().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OP_RET_CIMP = 1;
    RetencionConcImpuOP pers = (RetencionConcImpuOP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproOPRetCImp "+
                     " set activo=0 " +
                     " where " +
                     " oid_op_ret_cimp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OP_RET_CIMP, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OP_RET_CIMP = 1;
    RetencionConcImpuOP pers = (RetencionConcImpuOP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproOPRetCImp "+
                     " set activo=1 " +
                     " where " +
                     " oid_op_ret_cimp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OP_RET_CIMP, pers.getOID());
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

    final int OID_OP_RET_CIMP = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproOPRetCImp ");
    textSQL.append(" WHERE oid_op_ret_cimp = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_OP_RET_CIMP, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproOPRetCImp ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_op_ret_cimp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opComproOPRetCImp");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
