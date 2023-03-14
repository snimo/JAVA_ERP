package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.ConfigTalonarioAjuStk;
import com.srn.erp.stock.bm.OperHabiTalonarioAjuStk;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBOperHabiTalonarioAjuStk extends DBObjetoPersistente {

  public static final String OID_OPER_AJU_STK = "oid_oper_aju_stk";
  public static final String OID_CONF_TAL_STK = "oid_conf_tal_stk";
  public static final String TIPO_AJU_STK = "tipo_aju_stk";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";

  public static final int SELECT_BY_CONF_TAL_STK     = 100;
  public static final int SELECT_BY_CONF_TAL_AJU_STK = 101;

  public DBOperHabiTalonarioAjuStk() {

  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OPER_AJU_STK = 1;
    final int OID_CONF_TAL_STK = 2;
    final int TIPO_AJU_STK = 3;
    final int USAR_POR_DEFECTO = 4;

    OperHabiTalonarioAjuStk pers = (OperHabiTalonarioAjuStk) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skOperHabTalAjuStk "+
                     " ( "+
                      "OID_OPER_AJU_STK,"+
                      "OID_CONF_TAL_STK,"+
                      "TIPO_AJU_STK,"+
                      "USAR_POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_OPER_AJU_STK,pers.getOID());
    qInsert.setInt(OID_CONF_TAL_STK,pers.getConf_tal_aju_stk().getOID());
    qInsert.setString(TIPO_AJU_STK,pers.getTipo_aju_stk());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONF_TAL_STK = 1;
    final int TIPO_AJU_STK = 2;
    final int USAR_POR_DEFECTO = 3;
    final int OID_OPER_AJU_STK = 4;

    OperHabiTalonarioAjuStk pers = (OperHabiTalonarioAjuStk) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skOperHabTalAjuStk set "+
              "oid_conf_tal_stk=?"+
              ",tipo_aju_stk=?"+
              ",usar_por_defecto=?"+
                 " where " +
                 " oid_oper_aju_stk=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_AJU_STK,pers.getOID());
    qUpdate.setInt(OID_CONF_TAL_STK,pers.getConf_tal_aju_stk().getOID());
    qUpdate.setString(TIPO_AJU_STK,pers.getTipo_aju_stk());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OPER_AJU_STK = 1;
    OperHabiTalonarioAjuStk pers = (OperHabiTalonarioAjuStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from skOperHabTalAjuStk "+
                     " where " +
                     " oid_oper_aju_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_AJU_STK, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OPER_AJU_STK = 1;
    OperHabiTalonarioAjuStk pers = (OperHabiTalonarioAjuStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skOperHabTalAjuStk "+
                     " set activo=1 " +
                     " where " +
                     " oid_oper_aju_stk=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_AJU_STK, pers.getOID());
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
      case SELECT_BY_CONF_TAL_STK: {
        ps = this.selectByConfTalStk(aCondiciones);
        break;
      }
      case SELECT_BY_CONF_TAL_AJU_STK: {
        ps = this.selectByConfTalAjuStk(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_OPER_AJU_STK = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skOperHabTalAjuStk ");
    textSQL.append(" WHERE oid_oper_aju_stk = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_OPER_AJU_STK, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skOperHabTalAjuStk ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByConfTalStk(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skOperHabTalAjuStk ");
    textSQL.append(" WHERE oid_conf_tal_stk = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConfigTalonarioAjuStk confTalAjuStk = (ConfigTalonarioAjuStk) aCondiciones;
    querySelect.setInt(1, confTalAjuStk.getOID());
    return querySelect;
  }

  private PreparedStatement selectByConfTalAjuStk(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skOperHabTalAjuStk ");
    textSQL.append(" WHERE oid_conf_tal_stk = ? and tipo_aju_stk = ? ");
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConfigTalonarioAjuStk confTalAjuStk = (ConfigTalonarioAjuStk) condiciones.get(ConfigTalonarioAjuStk.NICKNAME);
    String tipoAjuStk = (String) condiciones.get("tipo_aju_stk");
    querySelect.setInt(1, confTalAjuStk.getOID());
    querySelect.setString(2, tipoAjuStk);
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_oper_aju_stk oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skOperHabTalAjuStk");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getOperHabiTalonarioAjuStk(ConfigTalonarioAjuStk configTalAjuStk,
                                                ISesion aSesion)
                                                      throws BaseException {
    return (List) ObjetoLogico.getObjects(OperHabiTalonarioAjuStk.NICKNAME,
                                          DBOperHabiTalonarioAjuStk.SELECT_BY_CONF_TAL_STK,
                                          configTalAjuStk,
                                          new ListObserver(),
                                          aSesion);
  }

  public static OperHabiTalonarioAjuStk getOperHabiTalonarioAjuStk(ConfigTalonarioAjuStk configTalonarioAjuStk,
                                                                   String tipoAjuSttk,
                                                                   ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(ConfigTalonarioAjuStk.NICKNAME,configTalonarioAjuStk);
    condiciones.put("tipo_aju_stk",tipoAjuSttk);
    return (OperHabiTalonarioAjuStk) ObjetoLogico.getObjects(OperHabiTalonarioAjuStk.NICKNAME,
                                             DBOperHabiTalonarioAjuStk.SELECT_BY_CONF_TAL_AJU_STK,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }



}
