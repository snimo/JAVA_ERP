package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.RetCabIB;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRetCabIB extends DBObjetoPersistente {

  public static final String OID_RET_CAB_IB = "oid_ret_cab_ib";
  public static final String OID_CAT_RET_IB = "oid_cat_ret_ib";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String MONTO_NO_IMPO = "monto_no_impo";
  public static final String MONTO_RET_MIN = "monto_ret_min";
  public static final String FEC_VIG_DESDE = "fec_vig_desde";
  public static final String ACTIVO = "activo";

  public DBRetCabIB() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_CAB_IB = 1;
    final int OID_CAT_RET_IB = 2;
    final int OID_CONC_IMPU = 3;
    final int MONTO_NO_IMPO = 4;
    final int MONTO_RET_MIN = 5;
    final int FEC_VIG_DESDE = 6;
    final int ACTIVO = 7;

    RetCabIB pers = (RetCabIB) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRetCabIB "+
                     " ( "+
                      "OID_RET_CAB_IB,"+
                      "OID_CAT_RET_IB,"+
                      "OID_CONC_IMPU,"+
                      "MONTO_NO_IMPO,"+
                      "MONTO_RET_MIN,"+
                      "FEC_VIG_DESDE,"+
                      "ACTIVO)"+
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
    qInsert.setInt(OID_RET_CAB_IB,pers.getOID());
    qInsert.setInt(OID_CAT_RET_IB,pers.getCatretIB().getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConcimpu().getOID());
    qInsert.setDouble(MONTO_NO_IMPO,pers.getMontonoimpo().doubleValue());
    qInsert.setDouble(MONTO_RET_MIN,pers.getMontoretmin().doubleValue());
    qInsert.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFecvigdesde().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CAT_RET_IB = 1;
    final int OID_CONC_IMPU = 2;
    final int MONTO_NO_IMPO = 3;
    final int MONTO_RET_MIN = 4;
    final int FEC_VIG_DESDE = 5;
    final int ACTIVO = 6;
    final int OID_RET_CAB_IB = 7;

    RetCabIB pers = (RetCabIB) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRetCabIB set "+
              "oid_cat_ret_ib=?"+
              ",oid_conc_impu=?"+
              ",monto_no_impo=?"+
              ",monto_ret_min=?"+
              ",fec_vig_desde=?"+
              ",activo=?"+
                 " where " +
                 " oid_ret_cab_ib=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_CAB_IB,pers.getOID());
    qUpdate.setInt(OID_CAT_RET_IB,pers.getCatretIB().getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConcimpu().getOID());
    qUpdate.setDouble(MONTO_NO_IMPO,pers.getMontonoimpo().doubleValue());
    qUpdate.setDouble(MONTO_RET_MIN,pers.getMontoretmin().doubleValue());
    qUpdate.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFecvigdesde().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_CAB_IB = 1;
    RetCabIB pers = (RetCabIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabIB "+
                     " set activo=0 " +
                     " where " +
                     " oid_ret_cab_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_CAB_IB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_CAB_IB = 1;
    RetCabIB pers = (RetCabIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabIB "+
                     " set activo=1 " +
                     " where " +
                     " oid_ret_cab_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_CAB_IB, pers.getOID());
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
      case IDBObjetoPersistente.SELECT_ALL: {
        ps = this.selectAll(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_RET_CAB_IB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIB ");
    textSQL.append(" WHERE oid_ret_cab_ib = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RET_CAB_IB, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIB ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIB ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ret_cab_ib oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRetCabIB");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getAllRetIBCab(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RetCabIB.NICKNAME,
                                          DBRetCabIB.SELECT_ALL,
                                          null,
                                          new ListObserver(),
                                          aSesion);
  }


}
