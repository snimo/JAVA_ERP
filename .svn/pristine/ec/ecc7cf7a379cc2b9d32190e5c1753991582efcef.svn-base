package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioFactClie;
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

public class DBCompoStkTalonarioFactClie extends DBObjetoPersistente {

  public static final String OID_COMPO_STK_FACT = "oid_compo_stk_fact";
  public static final String OID_OPER_TAL_FACT = "oid_oper_tal_fact";
  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";

  public static final int SELECT_BY_OPER_FACT_CLIE = 100;
  public static final int SELECT_BY_OPER_Y_CONF = 101;

  public DBCompoStkTalonarioFactClie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPO_STK_FACT = 1;
    final int OID_OPER_TAL_FACT = 2;
    final int OID_TIPO_CONF_MOV = 3;
    final int USAR_POR_DEFECTO = 4;

    CompoStkTalonarioFactClie pers = (CompoStkTalonarioFactClie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCompoStkTalFact "+
                     " ( "+
                      "OID_COMPO_STK_FACT,"+
                      "OID_OPER_TAL_FACT,"+
                      "OID_TIPO_CONF_MOV,"+
                      "USAR_POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPO_STK_FACT,pers.getOID());
    qInsert.setInt(OID_OPER_TAL_FACT,pers.getOper_tal_fact_clie().getOID());
    qInsert.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OPER_TAL_FACT = 1;
    final int OID_TIPO_CONF_MOV = 2;
    final int USAR_POR_DEFECTO = 3;
    final int OID_COMPO_STK_FACT = 4;

    CompoStkTalonarioFactClie pers = (CompoStkTalonarioFactClie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCompoStkTalFact set "+
              "oid_oper_tal_fact=?"+
              ",oid_tipo_conf_mov=?"+
              ",usar_por_defecto=?"+
                 " where " +
                 " oid_compo_stk_fact=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_FACT,pers.getOID());
    qUpdate.setInt(OID_OPER_TAL_FACT,pers.getOper_tal_fact_clie().getOID());
    qUpdate.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_STK_FACT = 1;
    CompoStkTalonarioFactClie pers = (CompoStkTalonarioFactClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veCompoStkTalFact "+
                     " where " +
                     " oid_compo_stk_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_FACT, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_STK_FACT = 1;
    CompoStkTalonarioFactClie pers = (CompoStkTalonarioFactClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCompoStkTalFact "+
                     " set activo=1 " +
                     " where " +
                     " oid_compo_stk_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_FACT, pers.getOID());
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
      case SELECT_BY_OPER_FACT_CLIE: {
        ps = this.selectByOperFactClie(aCondiciones);
        break;
      }
      case SELECT_BY_OPER_Y_CONF: {
        ps = this.selectByOperConf(aCondiciones);
        break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPO_STK_FACT = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalFact ");
    textSQL.append(" WHERE oid_compo_stk_fact = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPO_STK_FACT, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalFact ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByOperFactClie(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalFact ");
    textSQL.append(" WHERE oid_oper_tal_fact = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    OperHabiTalonarioFactClie operHab = (OperHabiTalonarioFactClie) aCondiciones;
    querySelect.setInt(1, operHab.getOID());
    return querySelect;
  }

  private PreparedStatement selectByOperConf(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalFact ");
    textSQL.append(" WHERE oid_oper_tal_fact = ? and oid_tipo_conf_mov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    OperHabiTalonarioFactClie operHab = (OperHabiTalonarioFactClie) condiciones.get(OperHabiTalonarioFactClie.NICKNAME);
    TipoConfMovStkTalonario tipoConf = (TipoConfMovStkTalonario) condiciones.get(TipoConfMovStkTalonario.NICKNAME);
    querySelect.setInt(1, operHab.getOID());
    querySelect.setInt(2, tipoConf.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_stk_fact oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veCompoStkTalFact");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getCompoStkTalonarioFactClie(OperHabiTalonarioFactClie operHab,
                                                  ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CompoStkTalonarioFactClie.NICKNAME,
                                          DBCompoStkTalonarioFactClie.SELECT_BY_OPER_FACT_CLIE,
                                          operHab,
                                          new ListObserver(),
                                          aSesion);
  }

  public static CompoStkTalonarioFactClie getCompoStkTalonarioFactClie(OperHabiTalonarioFactClie operHabTalFactClie,
                                                                   TipoConfMovStkTalonario tipoConfMov,
                                                                   ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(OperHabiTalonarioFactClie.NICKNAME,operHabTalFactClie);
    condiciones.put(TipoConfMovStkTalonario.NICKNAME,tipoConfMov);
    return (CompoStkTalonarioFactClie) ObjetoLogico.getObjects(CompoStkTalonarioFactClie.NICKNAME,
                                             DBCompoStkTalonarioFactClie.SELECT_BY_OPER_Y_CONF,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }



}
