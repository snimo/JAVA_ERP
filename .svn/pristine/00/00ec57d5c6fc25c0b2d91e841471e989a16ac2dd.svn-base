package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.pagos.bm.RetPorcLib;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBRetPorcLib extends DBObjetoPersistente {

  public static final String OID_RET_PORC_LIB = "oid_ret_porc_lib";
  public static final String OID_SUJ_IMP = "oid_suj_imp";
  public static final String COMPO_IMPU = "compo_impu";
  public static final String DECRETO = "decreto";
  public static final String FEC_VIG_DESDE = "fec_vig_desde";
  public static final String FEC_VIG_HASTA = "fec_vig_hasta";
  public static final String PORC_LIB = "porc_lib";
  public static final String ACTIVO = "activo";

  public DBRetPorcLib() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_PORC_LIB = 1;
    final int OID_SUJ_IMP = 2;
    final int COMPO_IMPU = 3;
    final int DECRETO = 4;
    final int FEC_VIG_DESDE = 5;
    final int FEC_VIG_HASTA = 6;
    final int PORC_LIB = 7;
    final int ACTIVO = 8;

    RetPorcLib pers = (RetPorcLib) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imRetPorcLib "+
                     " ( "+
                      "OID_RET_PORC_LIB,"+
                      "OID_SUJ_IMP,"+
                      "COMPO_IMPU,"+
                      "DECRETO,"+
                      "FEC_VIG_DESDE,"+
                      "FEC_VIG_HASTA,"+
                      "PORC_LIB,"+
                      "ACTIVO)"+
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
    qInsert.setInt(OID_RET_PORC_LIB,pers.getOID());
    qInsert.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    qInsert.setString(COMPO_IMPU,pers.getCompoimpu());
    qInsert.setString(DECRETO,pers.getDecreto());
    qInsert.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFecvigdesde().getTime()));
    qInsert.setDate(FEC_VIG_HASTA,new java.sql.Date(pers.getFecvighasta().getTime()));
    qInsert.setDouble(PORC_LIB,pers.getPorclib().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUJ_IMP = 1;
    final int COMPO_IMPU = 2;
    final int DECRETO = 3;
    final int FEC_VIG_DESDE = 4;
    final int FEC_VIG_HASTA = 5;
    final int PORC_LIB = 6;
    final int ACTIVO = 7;
    final int OID_RET_PORC_LIB = 8;

    RetPorcLib pers = (RetPorcLib) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imRetPorcLib set "+
              "oid_suj_imp=?"+
              ",compo_impu=?"+
              ",decreto=?"+
              ",fec_vig_desde=?"+
              ",fec_vig_hasta=?"+
              ",porc_lib=?"+
              ",activo=?"+
                 " where " +
                 " oid_ret_porc_lib=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_PORC_LIB,pers.getOID());
    qUpdate.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    qUpdate.setString(COMPO_IMPU,pers.getCompoimpu());
    qUpdate.setString(DECRETO,pers.getDecreto());
    qUpdate.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFecvigdesde().getTime()));
    qUpdate.setDate(FEC_VIG_HASTA,new java.sql.Date(pers.getFecvighasta().getTime()));
    qUpdate.setDouble(PORC_LIB,pers.getPorclib().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_PORC_LIB = 1;
    RetPorcLib pers = (RetPorcLib) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imRetPorcLib "+
                     " set activo=0 " +
                     " where " +
                     " oid_ret_porc_lib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_PORC_LIB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_PORC_LIB = 1;
    RetPorcLib pers = (RetPorcLib) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imRetPorcLib "+
                     " set activo=1 " +
                     " where " +
                     " oid_ret_porc_lib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_PORC_LIB, pers.getOID());
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

    final int OID_RET_PORC_LIB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imRetPorcLib ");
    textSQL.append(" WHERE oid_ret_porc_lib = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RET_PORC_LIB, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imRetPorcLib ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ret_porc_lib oid, codigo,  descripcion ,activo ");
    textSQL.append(" from imRetPorcLib");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
