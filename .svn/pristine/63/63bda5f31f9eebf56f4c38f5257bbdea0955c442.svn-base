package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.ConfigTalonarioRto;
import com.srn.erp.ventas.bm.OperHabiTalonarioRto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBOperHabiTalonarioRto extends DBObjetoPersistente {

  public static final String OID_OPER_TAL_RTO = "oid_oper_tal_rto";
  public static final String OID_CONF_TAL_RTO = "oid_conf_tal_rto";
  public static final String TIPO_RTO         = "tipo_rto";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";

  public static final int SELECT_BY_CONF_TAL_RTO = 100;
  public static final int SELECT_BY_TIPO_RTO = 101;

  public DBOperHabiTalonarioRto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OPER_TAL_RTO = 1;
    final int OID_CONF_TAL_RTO = 2;
    final int TIPO_RTO = 3;
    final int USAR_POR_DEFECTO = 4;

    OperHabiTalonarioRto pers = (OperHabiTalonarioRto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veOperHabTalRto "+
                     " ( "+
                      "OID_OPER_TAL_RTO,"+
                      "OID_CONF_TAL_RTO,"+
                      "TIPO_RTO,"+
                      "USAR_POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_OPER_TAL_RTO,pers.getOID());
    qInsert.setInt(OID_CONF_TAL_RTO,pers.getConfig_talonario_rto().getOID());
    qInsert.setString(TIPO_RTO,pers.getTipo_rto());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsarPorDefecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONF_TAL_RTO = 1;
    final int TIPO_RTO = 2;
    final int USAR_POR_DEFECTO = 3;
    final int OID_OPER_TAL_RTO = 4;

    OperHabiTalonarioRto pers = (OperHabiTalonarioRto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veOperHabTalRto set "+
              "oid_conf_tal_rto=?"+
              ",tipo_rto=?"+
              ",usar_por_defecto=?"+
                 " where " +
                 " oid_oper_tal_rto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_TAL_RTO,pers.getOID());
    qUpdate.setInt(OID_CONF_TAL_RTO,pers.getConfig_talonario_rto().getOID());
    qUpdate.setString(TIPO_RTO,pers.getTipo_rto());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsarPorDefecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OPER_TAL_RTO = 1;
    OperHabiTalonarioRto pers = (OperHabiTalonarioRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veOperHabTalRto "+
                     " where " +
                     " oid_oper_tal_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_TAL_RTO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OPER_TAL_RTO = 1;
    OperHabiTalonarioRto pers = (OperHabiTalonarioRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veOperHabTalRto "+
                     " set activo=1 " +
                     " where " +
                     " oid_oper_tal_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_TAL_RTO, pers.getOID());
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
      case SELECT_BY_CONF_TAL_RTO: {
        ps = this.selectByConfTalRto(aCondiciones);
        break;
      }
      case SELECT_BY_TIPO_RTO: {
        ps = this.selectByTipoRemito(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_OPER_TAL_RTO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalRto ");
    textSQL.append(" WHERE oid_oper_tal_rto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_OPER_TAL_RTO, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalRto ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByConfTalRto(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalRto ");
    textSQL.append(" WHERE  oid_conf_tal_rto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConfigTalonarioRto configTalonarioRto = (ConfigTalonarioRto) aCondiciones;
    querySelect.setInt(1, configTalonarioRto.getOID());
    return querySelect;
  }

  private PreparedStatement selectByTipoRemito(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalRto ");
    textSQL.append(" WHERE  tipo_rto = ? and oid_conf_tal_rto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    String tipoRemito = (String) condiciones.get("tipo_remito");
    ConfigTalonarioRto configTalRto = (ConfigTalonarioRto) condiciones.get(ConfigTalonarioRto.NICKNAME);
    querySelect.setString(1, tipoRemito);
    querySelect.setInt(2, configTalRto.getOID());

    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_oper_tal_rto oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veOperHabTalRto");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static OperHabiTalonarioRto getOperHabilitada(ConfigTalonarioRto configTalRto,
                                                       String tipoRemito,
                                                       ISesion aSesion)
                                                       throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put("tipo_remito",tipoRemito);
    condiciones.put(ConfigTalonarioRto.NICKNAME,configTalRto);
    return (OperHabiTalonarioRto) ObjetoLogico.getObjects(OperHabiTalonarioRto.NICKNAME,
                                             DBOperHabiTalonarioRto.SELECT_BY_TIPO_RTO,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }

  public static List getOperacionesHabilitadas(ConfigTalonarioRto configTalonarioRto,
                                               ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(OperHabiTalonarioRto.NICKNAME,
                                          DBOperHabiTalonarioRto.SELECT_BY_CONF_TAL_RTO,
                                          configTalonarioRto,
                                          new ListObserver(),
                                          aSesion);
  }





}
