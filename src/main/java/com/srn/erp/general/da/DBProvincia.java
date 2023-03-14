package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.Provincia;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBProvincia extends DBObjetoPersistente {

  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String ES_CAP_FED = "es_cap_fed";
  public static final String ES_BS_AS = "es_bs_as";
  public static final String CALC_PERC_IB_BA = "calc_perc_ib_ba";

  public DBProvincia() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PROVINCIA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int ES_BS_AS = 5;
    final int ES_CAP_FED = 6;
    final int CALC_PERC_IB_BA = 7;

    Provincia pers = (Provincia) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geProvincias "+
                     " ( "+
                      "OID_PROVINCIA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "ES_BS_AS,"+
                      "ES_CAP_FED,CALC_PERC_IB_BA"+
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
    qInsert.setInt(OID_PROVINCIA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(ES_BS_AS, pers.esBuenosAires());
    qInsert.setBoolean(ES_CAP_FED, pers.esCapitalFederal());
    qInsert.setBoolean(CALC_PERC_IB_BA,pers.isCalcPercIBBA());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int ES_BS_AS = 4;
    final int ES_CAP_FED = 5;
    final int CALC_PERC_IB_BA = 6;
    final int OID_PROVINCIA = 7;

    Provincia pers = (Provincia) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geProvincias set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
              ",es_bs_as=?"+
              ",es_cap_fed=?"+
              ",calc_perc_ib_ba=?"+
                 " where " +
                 " oid_provincia=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROVINCIA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(ES_BS_AS, pers.esBuenosAires());
    qUpdate.setBoolean(ES_CAP_FED, pers.esCapitalFederal());
    qUpdate.setBoolean(CALC_PERC_IB_BA,pers.isCalcPercIBBA());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PROVINCIA = 1;
    Provincia pers = (Provincia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geProvincias "+
                     " set activo=0 " +
                     " where " +
                     " oid_provincia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROVINCIA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PROVINCIA = 1;
    Provincia pers = (Provincia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geProvincias "+
                     " set activo=1 " +
                     " where " +
                     " oid_provincia=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PROVINCIA, pers.getOID());
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

    final int OID_PROVINCIA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geProvincias ");
    textSQL.append(" WHERE oid_provincia = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PROVINCIA, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geProvincias ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_provincia oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from geProvincias");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
