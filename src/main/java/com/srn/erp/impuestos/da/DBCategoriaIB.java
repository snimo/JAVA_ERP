package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.impuestos.bm.CategoriaIB;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBCategoriaIB extends DBObjetoPersistente {

  public static final String OID_CAT_IB = "oid_cat_ib";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPO_CAT_IB = "compo_cat_ib";
  public static final String ACTIVO = "activo";
  public static final String CALC_PERC_IB_BA = "calc_perc_ib_ba";
  public static final String CALC_PERC_IB_CF = "calc_perc_ib_cf";

  public DBCategoriaIB() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CAT_IB = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMPO_CAT_IB = 4;
    final int ACTIVO = 5;
    final int CALC_PERC_IB_BA = 6;
    final int CALC_PERC_IB_CF = 7;

    CategoriaIB pers = (CategoriaIB) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imCatIB "+
                     " ( "+
                      "OID_CAT_IB,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMPO_CAT_IB,"+
                      "ACTIVO,"+
                      "CALC_PERC_IB_BA,"+
                      "CALC_PERC_IB_CF"+
                      ")"+
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
    qInsert.setInt(OID_CAT_IB,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPO_CAT_IB,pers.getComportamiento());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(CALC_PERC_IB_BA, pers.isCalcPercIBBsAs());
    qInsert.setBoolean(CALC_PERC_IB_CF, pers.isCalcPercIBCapFed());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMPO_CAT_IB = 3;
    final int ACTIVO = 4;
    final int CALC_PERC_IB_BA = 5;
    final int CALC_PERC_IB_CF = 6;
    final int OID_CAT_IB = 7;

    CategoriaIB pers = (CategoriaIB) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imCatIB set "+
              "codigo=?"+
              ",descripcion=?"+
              ",compo_cat_ib=?"+
              ",activo=?"+
              ",calc_perc_ib_ba=?"+
              ",calc_perc_ib_cf=?"+
                 " where " +
                 " oid_cat_ib=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAT_IB,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPO_CAT_IB,pers.getComportamiento());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(CALC_PERC_IB_BA, pers.isCalcPercIBBsAs());
    qUpdate.setBoolean(CALC_PERC_IB_CF, pers.isCalcPercIBCapFed());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAT_IB = 1;
    CategoriaIB pers = (CategoriaIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imCatIB "+
                     " set activo=0 " +
                     " where " +
                     " oid_cat_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAT_IB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAT_IB = 1;
    CategoriaIB pers = (CategoriaIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imCatIB "+
                     " set activo=1 " +
                     " where " +
                     " oid_cat_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAT_IB, pers.getOID());
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

    final int OID_CAT_IB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imCatIB ");
    textSQL.append(" WHERE oid_cat_ib = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CAT_IB, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imCatIB ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cat_ib oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from imCatIB");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
