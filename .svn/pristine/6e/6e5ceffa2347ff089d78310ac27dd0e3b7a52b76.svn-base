package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.Talonario;
import com.srn.erp.stock.bm.ConfigTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBConfigTalonarioAjuStk extends DBObjetoPersistente {

  public static final String OID_CONF_TAL_STK = "oid_conf_tal_stk";
  public static final String OID_TALONARIO = "oid_talonario";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_TALONARIO = 100;

  public DBConfigTalonarioAjuStk() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONF_TAL_STK = 1;
    final int OID_TALONARIO = 2;
    final int ACTIVO = 3;

    ConfigTalonarioAjuStk pers = (ConfigTalonarioAjuStk) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skConfTalAjuStk "+
                     " ( "+
                      "OID_CONF_TAL_STK,"+
                      "OID_TALONARIO,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CONF_TAL_STK,pers.getOID());
    qInsert.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TALONARIO = 1;
    final int ACTIVO = 2;
    final int OID_CONF_TAL_STK = 3;

    ConfigTalonarioAjuStk pers = (ConfigTalonarioAjuStk) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skConfTalAjuStk set "+
              "oid_talonario=?"+
              ",activo=?"+
                 " where " +
                 " oid_conf_tal_stk=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONF_TAL_STK,pers.getOID());
    qUpdate.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONF_TAL_STK = 1;
    ConfigTalonarioAjuStk pers = (ConfigTalonarioAjuStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skConfTalAjuStk "+
                     " set activo=0 " +
                     " where " +
                     " oid_conf_tal_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONF_TAL_STK, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONF_TAL_STK = 1;
    ConfigTalonarioAjuStk pers = (ConfigTalonarioAjuStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skConfTalAjuStk "+
                     " set activo=1 " +
                     " where " +
                     " oid_conf_tal_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONF_TAL_STK, pers.getOID());
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
      case SELECT_BY_TALONARIO: {
        ps = this.selectByTalonario(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CONF_TAL_STK = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skConfTalAjuStk ");
    textSQL.append(" WHERE oid_conf_tal_stk = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CONF_TAL_STK, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skConfTalAjuStk ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByTalonario(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skConfTalAjuStk ");
    textSQL.append(" WHERE  oid_talonario = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Talonario talonario = (Talonario) aCondiciones;
    querySelect.setInt(1,talonario.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conf_tal_stk oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skConfTalAjuStk");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static ConfigTalonarioAjuStk getConfigTalonarioAjuStk(Talonario talonario,
                                                               ISesion aSesion)
                                                      throws BaseException {
    return (ConfigTalonarioAjuStk) ObjetoLogico.getObjects(ConfigTalonarioAjuStk.NICKNAME,
                                             DBConfigTalonarioAjuStk.SELECT_BY_TALONARIO,
                                             talonario,
                                             new ObjetoObservado(),
                                             aSesion);
  }


}
