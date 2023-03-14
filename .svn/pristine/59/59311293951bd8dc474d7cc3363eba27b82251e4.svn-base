package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.CompoStkTalonarioAjuStk;
import com.srn.erp.stock.bm.OperHabiTalonarioAjuStk;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCompoStkTalonarioAjuStk extends DBObjetoPersistente {

  public static final String OID_COMPO_STK_AJU = "oid_compo_stk_aju";
  public static final String OID_OPER_AJU_STK = "oid_oper_aju_stk";
  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";

  public static final int SELECT_BY_OPER_AJU_STK    = 100;
  public static final int SELECT_BY_OPER_Y_CONF     = 101;
  public static final int SELECT_BY_TIPO_AJUSTE_STK = 102;

  public DBCompoStkTalonarioAjuStk() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPO_STK_AJU = 1;
    final int OID_OPER_AJU_STK = 2;
    final int TIPOCONFMOVSTKTALONARIO = 3;
    final int USAR_POR_DEFECTO = 4;

    CompoStkTalonarioAjuStk pers = (CompoStkTalonarioAjuStk) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skCompoTalAjuStk "+
                     " ( "+
                      "OID_COMPO_STK_AJU,"+
                      "OID_OPER_AJU_STK,"+
                      "OID_TIPO_CONF_MOV,"+
                      "USAR_POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPO_STK_AJU,pers.getOID());
    qInsert.setInt(OID_OPER_AJU_STK,pers.getOper_habi_tal_ajustk().getOID());
    qInsert.setInt(TIPOCONFMOVSTKTALONARIO,pers.getTipo_conf_mov_tal().getOID());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OPER_AJU_STK = 1;
    final int TIPOCONFMOVSTKTALONARIO = 2;
    final int USAR_POR_DEFECTO = 3;
    final int OID_COMPO_STK_AJU = 4;

    CompoStkTalonarioAjuStk pers = (CompoStkTalonarioAjuStk) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skCompoTalAjuStk set "+
              "oid_oper_aju_stk=?"+
              ",oid_tipo_conf_mov=?"+
              ",usar_por_defecto=?"+
                 " where " +
                 " oid_compo_stk_aju=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_AJU,pers.getOID());
    qUpdate.setInt(OID_OPER_AJU_STK,pers.getOper_habi_tal_ajustk().getOID());
    qUpdate.setInt(TIPOCONFMOVSTKTALONARIO,pers.getTipo_conf_mov_tal().getOID());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_STK_AJU = 1;
    CompoStkTalonarioAjuStk pers = (CompoStkTalonarioAjuStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from  skCompoTalAjuStk "+
                     " where " +
                     " oid_compo_stk_aju=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_AJU, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPO_STK_AJU = 1;
    CompoStkTalonarioAjuStk pers = (CompoStkTalonarioAjuStk) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skCompoTalAjuStk "+
                     " set activo=1 " +
                     " where " +
                     " oid_compo_stk_aju=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPO_STK_AJU, pers.getOID());
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
      case SELECT_BY_OPER_AJU_STK: {
        ps = this.selectByOperAjuStk(aCondiciones);
        break;
      }
      case SELECT_BY_OPER_Y_CONF: {
        ps = this.selectByOpeHabConfStock(aCondiciones);
        break;
      }
      case SELECT_BY_TIPO_AJUSTE_STK: {
        ps = this.selectByTipoAjusteStk(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPO_STK_AJU = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skCompoTalAjuStk ");
    textSQL.append(" WHERE oid_compo_stk_aju = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPO_STK_AJU, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skCompoTalAjuStk ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByOperAjuStk(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skCompoTalAjuStk ");
    textSQL.append(" WHERE oid_oper_aju_stk = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    OperHabiTalonarioAjuStk operHab = (OperHabiTalonarioAjuStk) aCondiciones;
    querySelect.setInt(1, operHab.getOID());
    return querySelect;
  }
  
  
  private PreparedStatement selectByTipoAjusteStk(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skCompoTalAjuStk ");
    textSQL.append(" WHERE oid_oper_aju_stk in (select oid_oper_aju_stk from skOperHabTalAjuStk where tipo_aju_stk = ? ) ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String tipoAjusteStock = (String) aCondiciones;
    querySelect.setString(1, tipoAjusteStock);
    return querySelect;
  }
  

  private PreparedStatement selectByOpeHabConfStock(Object aCondiciones) throws BaseException, SQLException {
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    OperHabiTalonarioAjuStk operHabTalAju = (OperHabiTalonarioAjuStk)
          condiciones.get(OperHabiTalonarioAjuStk.NICKNAME);
    TipoConfMovStkTalonario tipoConfMov = (TipoConfMovStkTalonario)
        condiciones.get(TipoConfMovStkTalonario.NICKNAME);
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skCompoTalAjuStk ");
    textSQL.append(" WHERE oid_oper_aju_stk = ? and oid_tipo_conf_mov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1, operHabTalAju.getOID());
    querySelect.setInt(2, tipoConfMov.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compo_stk_aju oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skCompoTalAjuStk");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getCompoStkTalonarioAjuStk(OperHabiTalonarioAjuStk operHab,
                                                                   ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CompoStkTalonarioAjuStk.NICKNAME,
                                          DBCompoStkTalonarioAjuStk.SELECT_BY_OPER_AJU_STK,
                                          operHab,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getCompoStkTalonarioAjuStkByTipoAjuste(String aTipoAjuste,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(CompoStkTalonarioAjuStk.NICKNAME,
  			DBCompoStkTalonarioAjuStk.SELECT_BY_TIPO_AJUSTE_STK,
  			aTipoAjuste,
  			new ListObserver(),
  			aSesion);
  }
  

  public static CompoStkTalonarioAjuStk getCompoStkTalonarioAjuStk(OperHabiTalonarioAjuStk operHabTalAju,
                                                                   TipoConfMovStkTalonario tipoConfMov,
                                                                   ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(OperHabiTalonarioAjuStk.NICKNAME,operHabTalAju);
    condiciones.put(TipoConfMovStkTalonario.NICKNAME,tipoConfMov);
    return (CompoStkTalonarioAjuStk) ObjetoLogico.getObjects(CompoStkTalonarioAjuStk.NICKNAME,
                                             DBCompoStkTalonarioAjuStk.SELECT_BY_OPER_Y_CONF,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }





}
