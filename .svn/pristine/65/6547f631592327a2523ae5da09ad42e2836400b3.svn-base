package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.ConfigTalonarioFactClie;
import com.srn.erp.ventas.bm.OperHabiTalonarioFactClie;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBOperHabiTalonarioFactClie extends DBObjetoPersistente {

  public static final String OID_OPER_TAL_FACT = "oid_oper_tal_fact";
  public static final String OID_CONF_TAL_FACT = "oid_conf_tal_fact";
  public static final String TIPO_FACTURACION = "tipo_facturacion";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";

  public static final int SELECT_BY_CONF_TAL_FACT = 100;
  public static final int SELECT_BY_CONF_TAL_FACT_TIPO = 101;

  public DBOperHabiTalonarioFactClie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OPER_TAL_FACT = 1;
    final int OID_CONF_TAL_FACT = 2;
    final int TIPO_FACTURACION = 3;
    final int USAR_POR_DEFECTO = 4;

    OperHabiTalonarioFactClie pers = (OperHabiTalonarioFactClie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veOperHabTalFact "+
                     " ( "+
                      "OID_OPER_TAL_FACT,"+
                      "OID_CONF_TAL_FACT,"+
                      "TIPO_FACTURACION,"+
                      "USAR_POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_OPER_TAL_FACT,pers.getOID());
    qInsert.setInt(OID_CONF_TAL_FACT,pers.getConf_tal_fact_clie().getOID());
    qInsert.setString(TIPO_FACTURACION,pers.getTipo_facturacion());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONF_TAL_FACT = 1;
    final int TIPO_FACTURACION = 2;
    final int USAR_POR_DEFECTO = 3;
    final int OID_OPER_TAL_FACT = 4;

    OperHabiTalonarioFactClie pers = (OperHabiTalonarioFactClie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veOperHabTalFact set "+
              "oid_conf_tal_fact=?"+
              ",tipo_facturacion=?"+
              ",usar_por_defecto=?"+
                 " where " +
                 " oid_oper_tal_fact=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_TAL_FACT,pers.getOID());
    qUpdate.setInt(OID_CONF_TAL_FACT,pers.getConf_tal_fact_clie().getOID());
    qUpdate.setString(TIPO_FACTURACION,pers.getTipo_facturacion());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OPER_TAL_FACT = 1;
    OperHabiTalonarioFactClie pers = (OperHabiTalonarioFactClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veOperHabTalFact "+
                     " where " +
                     " oid_oper_tal_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_TAL_FACT, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OPER_TAL_FACT = 1;
    OperHabiTalonarioFactClie pers = (OperHabiTalonarioFactClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veOperHabTalFact "+
                     " set activo=1 " +
                     " where " +
                     " oid_oper_tal_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OPER_TAL_FACT, pers.getOID());
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
      case SELECT_BY_CONF_TAL_FACT: {
        ps = this.selectByConfTalFact(aCondiciones);
        break;
      }
      case SELECT_BY_CONF_TAL_FACT_TIPO: {
        ps = this.selectByConfTalFact_Tipo(aCondiciones);
        break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_OPER_TAL_FACT = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalFact ");
    textSQL.append(" WHERE oid_oper_tal_fact = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_OPER_TAL_FACT, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalFact ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByConfTalFact(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalFact ");
    textSQL.append(" WHERE oid_conf_tal_fact = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConfigTalonarioFactClie configTal = (ConfigTalonarioFactClie) aCondiciones;
    querySelect.setInt(1, configTal.getOID());
    return querySelect;
  }

  private PreparedStatement selectByConfTalFact_Tipo(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veOperHabTalFact ");
    textSQL.append(" WHERE oid_conf_tal_fact = ? and tipo_facturacion = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    ConfigTalonarioFactClie configTal = (ConfigTalonarioFactClie) condiciones.get(ConfigTalonarioFactClie.NICKNAME);
    String tipoFacturacion = (String) condiciones.get("tipo_facturacion");
    querySelect.setInt(1, configTal.getOID());
    querySelect.setString(2, tipoFacturacion);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_oper_tal_fact oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veOperHabTalFact");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getOperHabiTalonarioFactClie(ConfigTalonarioFactClie configTalFactClie,
                                                  ISesion aSesion)
                                                  throws BaseException {
    return (List) ObjetoLogico.getObjects(OperHabiTalonarioFactClie.NICKNAME,
                                          DBOperHabiTalonarioFactClie.SELECT_BY_CONF_TAL_FACT,
                                          configTalFactClie,
                                          new ListObserver(),
                                          aSesion);
  }

  public static OperHabiTalonarioFactClie getOperHabiTalonarioFactClie(ConfigTalonarioFactClie configTalonarioFactClie,
                                                                       String tipoFacturacion,
                                                                       ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(ConfigTalonarioFactClie.NICKNAME,configTalonarioFactClie);
    condiciones.put("tipo_facturacion",tipoFacturacion);
    return (OperHabiTalonarioFactClie) ObjetoLogico.getObjects(OperHabiTalonarioFactClie.NICKNAME,
                                             DBOperHabiTalonarioFactClie.SELECT_BY_CONF_TAL_FACT_TIPO,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }



}
