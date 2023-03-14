package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
import com.srn.erp.stock.bm.UbiDepoHabTalonario;
import com.srn.erp.stock.bm.UbicacionDeposito;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBUbiDepoHabTalonario extends DBObjetoPersistente {

  public static final String OID_UBI_DEPO_TAL = "oid_ubi_depo_tal";
  public static final String OID_MOV_STK_TAL = "oid_mov_stk_tal";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String HABILITADO = "habilitado";
  public static final String INCLUYE_HIJOS = "incluye_hijos";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_MOV_STOCK_TALONARIO      = 100;
  public static final int SELECT_BY_MOV_STOCK_TAL_Y_UBI_DEPO = 101;

  public DBUbiDepoHabTalonario() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_UBI_DEPO_TAL = 1;
    final int OID_MOV_STK_TAL = 2;
    final int OID_UBI_DEPO = 3;
    final int HABILITADO = 4;
    final int INCLUYE_HIJOS = 5;
    final int USAR_POR_DEFECTO = 6;
    final int ACTIVO = 7;

    UbiDepoHabTalonario pers = (UbiDepoHabTalonario) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skUbiDepoHabTal "+
                     " ( "+
                      "OID_UBI_DEPO_TAL,"+
                      "OID_MOV_STK_TAL,"+
                      "OID_UBI_DEPO,"+
                      "HABILITADO,"+
                      "INCLUYE_HIJOS,"+
                      "USAR_POR_DEFECTO,"+
                      "ACTIVO)"+
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
    qInsert.setInt(OID_UBI_DEPO_TAL,pers.getOID());
    qInsert.setInt(OID_MOV_STK_TAL,pers.getMov_stk_tal().getOID());
    qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qInsert.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qInsert.setBoolean(INCLUYE_HIJOS,pers.isIncluye_hijos().booleanValue());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_MOV_STK_TAL = 1;
    final int OID_UBI_DEPO = 2;
    final int HABILITADO = 3;
    final int INCLUYE_HIJOS = 4;
    final int USAR_POR_DEFECTO = 5;
    final int ACTIVO = 6;
    final int OID_UBI_DEPO_TAL = 7;

    UbiDepoHabTalonario pers = (UbiDepoHabTalonario) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skUbiDepoHabTal set "+
              "oid_mov_stk_tal=?"+
              ",oid_ubi_depo=?"+
              ",habilitado=?"+
              ",incluye_hijos=?"+
              ",usar_por_defecto=?"+
              ",activo=?"+
                 " where " +
                 " oid_ubi_depo_tal=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UBI_DEPO_TAL,pers.getOID());
    qUpdate.setInt(OID_MOV_STK_TAL,pers.getMov_stk_tal().getOID());
    qUpdate.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qUpdate.setBoolean(HABILITADO,pers.isHabilitado().booleanValue());
    qUpdate.setBoolean(INCLUYE_HIJOS,pers.isIncluye_hijos().booleanValue());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsar_por_defecto().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UBI_DEPO_TAL = 1;
    UbiDepoHabTalonario pers = (UbiDepoHabTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from skUbiDepoHabTal "+
                     " where " +
                     " oid_ubi_depo_tal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UBI_DEPO_TAL, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UBI_DEPO_TAL = 1;
    UbiDepoHabTalonario pers = (UbiDepoHabTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skUbiDepoHabTal "+
                     " set activo=1 " +
                     " where " +
                     " oid_ubi_depo_tal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UBI_DEPO_TAL, pers.getOID());
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
      case SELECT_BY_MOV_STOCK_TALONARIO: {
        ps = this.selectByMovStockTalonario(aCondiciones);
        break;
      }
      case SELECT_BY_MOV_STOCK_TAL_Y_UBI_DEPO: {
        ps = this.selectByMovStockTalonarioUbiDepo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_UBI_DEPO_TAL = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skUbiDepoHabTal ");
    textSQL.append(" WHERE oid_ubi_depo_tal = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_UBI_DEPO_TAL, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skUbiDepoHabTal ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByMovStockTalonario(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skUbiDepoHabTal ");
    textSQL.append(" WHERE oid_mov_stk_tal = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    MovStockTalonarioDeposito movStockTalDepo = (MovStockTalonarioDeposito) aCondiciones;
    querySelect.setInt(1, movStockTalDepo.getOID());
    return querySelect;
  }

  private PreparedStatement selectByMovStockTalonarioUbiDepo(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skUbiDepoHabTal ");
    textSQL.append(" WHERE oid_mov_stk_tal = ? and oid_ubi_depo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    MovStockTalonarioDeposito movStockTalDepo =
        (MovStockTalonarioDeposito) condiciones.get(MovStockTalonarioDeposito.NICKNAME);
    UbicacionDeposito ubicacionDeposito = (UbicacionDeposito) condiciones.get(UbicacionDeposito.NICKNAME);
    querySelect.setInt(1, movStockTalDepo.getOID());
    querySelect.setInt(2, ubicacionDeposito.getOID());
    return querySelect;
  }

    private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ubi_depo_tal oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skUbiDepoHabTal");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getUbicacionesHabilitadas(MovStockTalonarioDeposito movStockTalDepo,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(UbiDepoHabTalonario.NICKNAME,
                                          DBUbiDepoHabTalonario.SELECT_BY_MOV_STOCK_TALONARIO,
                                          movStockTalDepo,
                                          new ListObserver(),
                                          aSesion);
  }

  public static UbiDepoHabTalonario getUbiDepoHabTalonario(MovStockTalonarioDeposito movStockTalDepo,
                                                           UbicacionDeposito ubicacionDeposito,
                                                           ISesion aSesion)
                                                           throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(MovStockTalonarioDeposito.NICKNAME,movStockTalDepo);
    condiciones.put(UbicacionDeposito.NICKNAME,ubicacionDeposito);
    return (UbiDepoHabTalonario) ObjetoLogico.getObjects(UbiDepoHabTalonario.NICKNAME,
                                             DBUbiDepoHabTalonario.SELECT_BY_MOV_STOCK_TAL_Y_UBI_DEPO,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }



}
