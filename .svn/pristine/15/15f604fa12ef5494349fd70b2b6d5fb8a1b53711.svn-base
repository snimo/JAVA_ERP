package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.TipoConfMovStkTalonario;
import com.srn.erp.ventas.bm.CompoStkTalonarioRto;
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

public class DBCompoStkTalonarioRto extends DBObjetoPersistente {

  public static final String OID_COMPO_STK_RTO = "oid_compo_stk_rto";
  public static final String OID_OPER_TAL_RTO = "oid_oper_tal_rto";
  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";

  public static final int SELECT_BY_OPERACION_TAL_RTO = 100;
  public static final int SELECT_BY_OPERACION_Y_TIPO = 101;

  public DBCompoStkTalonarioRto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPO_STK_RTO = 1;
    final int OID_OPER_TAL_RTO = 2;
    final int OID_TIPO_CONF_MOV = 3;
    final int USAR_POR_DEFECTO = 4;

    CompoStkTalonarioRto pers = (CompoStkTalonarioRto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCompoStkTalRto "+
                     " ( "+
                      "OID_COMPO_STK_RTO,"+
                      "OID_OPER_TAL_RTO,"+
                      "OID_TIPO_CONF_MOV,"+
                      "USAR_POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPO_STK_RTO,pers.getOID());
    qInsert.setInt(OID_OPER_TAL_RTO,pers.getOper_tal_rto().getOID());
    qInsert.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsarPorDefecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OPER_TAL_RTO  = 1;
    final int OID_TIPO_CONF_MOV = 2;
    final int USAR_POR_DEFECTO  = 3;
    final int OID_COMPO_STK_RTO = 4;

    CompoStkTalonarioRto pers = (CompoStkTalonarioRto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCompoStkTalRto set "+
              "oid_oper_tal_rto=?"+
              ",oid_tipo_conf_mov=?"+
              ",usar_por_defecto=?"+
                 " where " +
                 " oid_compo_stk_rto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_RTO,pers.getOID());
    qUpdate.setInt(OID_OPER_TAL_RTO,pers.getOper_tal_rto().getOID());
    qUpdate.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsarPorDefecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_STK_RTO = 1;
    CompoStkTalonarioRto pers = (CompoStkTalonarioRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veCompoStkTalRto "+
                     " where " +
                     " oid_compo_stk_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_RTO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_STK_RTO = 1;
    CompoStkTalonarioRto pers = (CompoStkTalonarioRto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCompoStkTalRto "+
                     " set activo=1 " +
                     " where " +
                     " oid_compo_stk_rto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_RTO, pers.getOID());
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
      case SELECT_BY_OPERACION_TAL_RTO: {
        ps = this.selectByOperacion(aCondiciones);
        break;
      }
      case SELECT_BY_OPERACION_Y_TIPO: {
        ps = this.selectByOperacionyTipo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPO_STK_RTO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalRto ");
    textSQL.append(" WHERE oid_compo_stk_rto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPO_STK_RTO, oid);
    return querySelect;
  }

  private PreparedStatement selectByOperacion(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalRto ");
    textSQL.append(" WHERE oid_oper_tal_rto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    OperHabiTalonarioRto operHabiTalRto = (OperHabiTalonarioRto) aCondiciones;
    querySelect.setInt(1, operHabiTalRto.getOID());
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalRto ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByOperacionyTipo(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCompoStkTalRto ");
    textSQL.append(" WHERE  oid_oper_tal_rto = ? and oid_tipo_conf_mov = ?");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos)aCondiciones;
    OperHabiTalonarioRto operHabiTalRto = (OperHabiTalonarioRto) condiciones.get(OperHabiTalonarioRto.NICKNAME);
    TipoConfMovStkTalonario tipo = (TipoConfMovStkTalonario) condiciones.get(TipoConfMovStkTalonario.NICKNAME);
    querySelect.setInt(1, operHabiTalRto.getOID());
    querySelect.setInt(2, tipo.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_stk_rto oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veCompoStkTalRto");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getComportamientosStock(OperHabiTalonarioRto operHabiTalRto,
                                             ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CompoStkTalonarioRto.NICKNAME,
                                          DBCompoStkTalonarioRto.SELECT_BY_OPERACION_TAL_RTO,
                                          operHabiTalRto,
                                          new ListObserver(),
                                          aSesion);
  }

  public static CompoStkTalonarioRto getComportamientoStkTalonarioRto(
                                                      OperHabiTalonarioRto operHabiTalRto,
                                                      TipoConfMovStkTalonario tipo,
                                                      ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(OperHabiTalonarioRto.NICKNAME,operHabiTalRto);
    condiciones.put(TipoConfMovStkTalonario.NICKNAME,tipo);
    return (CompoStkTalonarioRto) ObjetoLogico.getObjects(CompoStkTalonarioRto.NICKNAME,
                                             DBCompoStkTalonarioRto.SELECT_BY_OPERACION_Y_TIPO,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }

}
