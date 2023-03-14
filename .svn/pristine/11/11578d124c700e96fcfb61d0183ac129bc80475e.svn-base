package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.Deposito;
import com.srn.erp.stock.bm.MovStockTalonarioDeposito;
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

public class DBMovStockTalonarioDeposito extends DBObjetoPersistente {

  public static final String OID_MOV_STK_TAL = "oid_mov_stk_tal";
  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String SECU = "secu";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String TIPO_MOVIMIENTO = "tipo_movimiento";
  public static final String ACTIVO = "activo";
  public static final String AFECTA_STOCK_FISICO = "afecta_stk_fisico";

  public static final int SELECT_BY_TIPO_CONF_MOV        = 100;
  public static final int SELECT_BY_TIPO_CONF_MOV_Y_DEPO = 101;

  public DBMovStockTalonarioDeposito() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_MOV_STK_TAL = 1;
    final int OID_TIPO_CONF_MOV = 2;
    final int SECU = 3;
    final int OID_DEPOSITO = 4;
    final int OID_ESTADO_STOCK = 5;
    final int TIPO_MOVIMIENTO = 6;
    final int ACTIVO = 7;
    final int AFECTA_STOCK_FISICO = 8;

    MovStockTalonarioDeposito pers = (MovStockTalonarioDeposito) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skMovStkTal "+
                     " ( "+
                      "OID_MOV_STK_TAL,"+
                      "OID_TIPO_CONF_MOV,"+
                      "SECU,"+
                      "OID_DEPOSITO,"+
                      "OID_ESTADO_STOCK,"+
                      "TIPO_MOVIMIENTO,"+
                      "ACTIVO,"+
                      "AFECTA_STK_FISICO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_MOV_STK_TAL,pers.getOID());
    qInsert.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qInsert.setString(TIPO_MOVIMIENTO,pers.getTipo_movimiento());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(AFECTA_STOCK_FISICO,pers.isAfectaStockFisico().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TIPO_CONF_MOV = 1;
    final int SECU = 2;
    final int OID_DEPOSITO = 3;
    final int OID_ESTADO_STOCK = 4;
    final int TIPO_MOVIMIENTO = 5;
    final int ACTIVO = 6;
    final int AFECTA_STK_FISICO = 7;
    final int OID_MOV_STK_TAL = 8;

    MovStockTalonarioDeposito pers = (MovStockTalonarioDeposito) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skMovStkTal set "+
              "oid_tipo_conf_mov=?"+
              ",secu=?"+
              ",oid_deposito=?"+
              ",oid_estado_stock=?"+
              ",tipo_movimiento=?"+
              ",activo=?"+
              ",afecta_stk_fisico=?"+
                 " where " +
                 " oid_mov_stk_tal=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_STK_TAL,pers.getOID());
    qUpdate.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qUpdate.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qUpdate.setString(TIPO_MOVIMIENTO,pers.getTipo_movimiento());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(AFECTA_STK_FISICO,pers.isAfectaStockFisico().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MOV_STK_TAL = 1;
    MovStockTalonarioDeposito pers = (MovStockTalonarioDeposito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from skMovStkTal "+
                     " where " +
                     " oid_mov_stk_tal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_STK_TAL, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MOV_STK_TAL = 1;
    MovStockTalonarioDeposito pers = (MovStockTalonarioDeposito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skMovStkTal "+
                     " set activo=1 " +
                     " where " +
                     " oid_mov_stk_tal=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_STK_TAL, pers.getOID());
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
      case SELECT_BY_TIPO_CONF_MOV: {
        ps = this.selectByTipoConfMov(aCondiciones);
        break;
      }
      case SELECT_BY_TIPO_CONF_MOV_Y_DEPO: {
        ps = this.selectByTipoConfMovyDepo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_MOV_STK_TAL = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skMovStkTal ");
    textSQL.append(" WHERE oid_mov_stk_tal = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_MOV_STK_TAL, oid);
    return querySelect;
  }

  private PreparedStatement selectByTipoConfMovyDepo(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skMovStkTal ");
    textSQL.append(" WHERE oid_tipo_conf_mov = ? and oid_deposito=? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    TipoConfMovStkTalonario tipoConfMovStkTal = (TipoConfMovStkTalonario)condiciones.get(TipoConfMovStkTalonario.NICKNAME);
    Deposito deposito = (Deposito) condiciones.get(Deposito.NICKNAME);
    querySelect.setInt(1, tipoConfMovStkTal.getOID());
    querySelect.setInt(2, deposito.getOID());
    return querySelect;
  }


  private PreparedStatement selectByTipoConfMov(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skMovStkTal ");
    textSQL.append(" WHERE oid_tipo_conf_mov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    TipoConfMovStkTalonario tipoConfMovStkTal = (TipoConfMovStkTalonario) aCondiciones;
    querySelect.setInt(1, tipoConfMovStkTal.getOID());
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skMovStkTal ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mov_stk_tal oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skMovStkTal");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getMovStockByTipo(TipoConfMovStkTalonario tipoConfMovStkTalonario,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(MovStockTalonarioDeposito.NICKNAME,
                                          DBMovStockTalonarioDeposito.SELECT_BY_TIPO_CONF_MOV,
                                          tipoConfMovStkTalonario,
                                          new ListObserver(),
                                          aSesion);
  }


  public static MovStockTalonarioDeposito getMovStockTalonarioDeposito(
                                                TipoConfMovStkTalonario tipoConfMovStkTalonario,
                                                Deposito deposito,
                                                ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(TipoConfMovStkTalonario.NICKNAME,tipoConfMovStkTalonario);
    condiciones.put(Deposito.NICKNAME,deposito);
    return (MovStockTalonarioDeposito) ObjetoLogico.getObjects(MovStockTalonarioDeposito.NICKNAME,
                                             DBMovStockTalonarioDeposito.SELECT_BY_TIPO_CONF_MOV_Y_DEPO,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }



}
