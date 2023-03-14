package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.contabilidad.bm.AnuladorAsientoDet;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bm.Varios.Redondear;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorAsientoDet extends DBObjetoPersistente {

  public static final String OID_DET_ANU_INGASI = "oid_det_anu_ingasi";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_DCO_ASI_MAN = "oid_dco_asi_man";
  public static final String SECU = "secu";
  public static final String OID_AI = "oid_ai";
  public static final String SIGNO = "signo";
  public static final String IMPO_LOC_HIST = "impo_loc_his";
  public static final String IMPO_LOC_AJU = "impo_loc_aju";
  public static final String IMPOMONEXT1 = "impo_Mon_Ext_1";
  public static final String IMPOMONEXT2 = "impo_Mon_Ext_2";
  public static final String COMENTARIO = "comentario";

  public DBAnuladorAsientoDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_DET_ANU_INGASI = 1;
    final int OID_CCO = 2;
    final int SECU = 3;
    final int OID_AI = 4;
    final int SIGNO = 5;
    final int COMENTARIO = 6;
    final int IMPO_LOC_HIST = 7;
    final int IMPO_LOC_AJU = 8;
    final int IMPOMONEXT1 = 9;
    final int IMPOMONEXT2 = 10;


    AnuladorAsientoDet pers = (AnuladorAsientoDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproDetAnuAsi  "+
                     " ( "+
                      "OID_DET_ANU_INGASI,"+
                      "OID_CCO,"+
                      "SECU,"+
                      "OID_AI,"+
                      "SIGNO,"+
                      "COMENTARIO,"+
                      "IMPO_LOC_HIS,"+
                      "IMPO_LOC_AJU,"+
                      "IMPO_MON_EXT_1,"+
                      "IMPO_MON_EXT_2)"+
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
    qInsert.setInt(OID_DET_ANU_INGASI,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_AI,pers.getCuentaimputable().getOID());
    qInsert.setInt(SIGNO,pers.getSigno().intValue());
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.setDouble(IMPO_LOC_HIST,Redondear.round(pers.getImpoLocHist().doubleValue(),2).doubleValue());
    qInsert.setDouble(IMPO_LOC_AJU,Redondear.round(pers.getImpoLocAju().doubleValue(),2).doubleValue());
    qInsert.setDouble(IMPOMONEXT1,Redondear.round(pers.getImpoMonExt1().doubleValue(),2).doubleValue());
    qInsert.setDouble(IMPOMONEXT2,Redondear.round(pers.getImpoMonExt2().doubleValue(),2).doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DET_ANU_INGASI = 1;
    AnuladorAsientoDet pers = (AnuladorAsientoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproDetAnuAsi  "+
                     " set activo=0 " +
                     " where " +
                     " oid_det_anu_ingasi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DET_ANU_INGASI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DET_ANU_INGASI = 1;
    AnuladorAsientoDet pers = (AnuladorAsientoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproDetAnuAsi  "+
                     " set activo=1 " +
                     " where " +
                     " oid_det_anu_ingasi=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DET_ANU_INGASI, pers.getOID());
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

    final int OID_DET_ANU_INGASI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproDetAnuAsi  ");
    textSQL.append(" WHERE oid_det_anu_ingasi = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_DET_ANU_INGASI, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproDetAnuAsi  ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_det_anu_ingasi oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgComproDetAnuAsi ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
