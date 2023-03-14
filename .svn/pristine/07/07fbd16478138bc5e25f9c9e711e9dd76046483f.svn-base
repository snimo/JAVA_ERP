package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.ConfMovStkTalonario;
import com.srn.erp.stock.bm.TipoConfMovStkTalonario;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBTipoConfMovStkTalonario extends DBObjetoPersistente {

  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String OID_CONF_MOV_STK = "oid_conf_mov_stk";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String TIPO_MOV = "tipo_mov";

  public static final int SELECT_BY_CONF_MOV_STOCK = 100;
  public static final int SELECT_BY_CONF_MOV_STOCK_Y_TIPO = 101;

  public DBTipoConfMovStkTalonario() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TIPO_CONF_MOV = 1;
    final int OID_CONF_MOV_STK = 2;
    final int CODIGO = 3;
    final int DESCRIPCION = 4;
    final int ACTIVO = 5;
    final int TIPO_MOV = 6;

    TipoConfMovStkTalonario pers = (TipoConfMovStkTalonario) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skTipoConfMovStk "+
                     " ( "+
                      "OID_TIPO_CONF_MOV,"+
                      "OID_CONF_MOV_STK,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "TIPO_MOV)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_TIPO_CONF_MOV,pers.getOID());
    qInsert.setInt(OID_CONF_MOV_STK,pers.getConf_mov_stk().getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(TIPO_MOV,pers.getTipoMovimiento());
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONF_MOV_STK = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int TIPO_MOV = 5;
    final int OID_TIPO_CONF_MOV = 6;

    TipoConfMovStkTalonario pers = (TipoConfMovStkTalonario) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skTipoConfMovStk set "+
              "oid_conf_mov_stk=?"+
              ",codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
              ",tipo_mov=?"+
                 " where " +
                 " oid_tipo_conf_mov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CONF_MOV,pers.getOID());
    qUpdate.setInt(OID_CONF_MOV_STK,pers.getConf_mov_stk().getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(TIPO_MOV,pers.getTipoMovimiento());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TIPO_CONF_MOV = 1;
    TipoConfMovStkTalonario pers = (TipoConfMovStkTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from skTipoConfMovStk "+
                     " where " +
                     " oid_tipo_conf_mov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CONF_MOV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TIPO_CONF_MOV = 1;
    TipoConfMovStkTalonario pers = (TipoConfMovStkTalonario) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skTipoConfMovStk "+
                     " set activo=1 " +
                     " where " +
                     " oid_tipo_conf_mov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CONF_MOV, pers.getOID());
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
      case SELECT_BY_CONF_MOV_STOCK: {
        ps = this.selectByConfMovStk(aCondiciones);
        break;
      }
      case SELECT_BY_CONF_MOV_STOCK_Y_TIPO: {
        ps = this.selectByConfMovStkyTipo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_TIPO_CONF_MOV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skTipoConfMovStk ");
    textSQL.append(" WHERE oid_tipo_conf_mov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TIPO_CONF_MOV, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skTipoConfMovStk ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByConfMovStk(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skTipoConfMovStk ");
    textSQL.append(" WHERE oid_conf_mov_stk = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConfMovStkTalonario confMovStkTal = (ConfMovStkTalonario) aCondiciones;
    querySelect.setInt(1, confMovStkTal.getOID());
    return querySelect;
  }
  
  private PreparedStatement selectByConfMovStkyTipo(Object aCondiciones) throws BaseException, SQLException {
	StringBuffer textSQL = new StringBuffer();
	textSQL.append("SELECT * FROM  skTipoConfMovStk ");
	textSQL.append(" WHERE oid_conf_mov_stk = ? and tipo_mov = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	ConfMovStkTalonario confMovStkTal = (ConfMovStkTalonario) condiciones.get(ConfMovStkTalonario.NICKNAME);
	String tipoMov = (String) condiciones.get("TIPO_MOV");
	querySelect.setInt(1, confMovStkTal.getOID());
	querySelect.setString(2, tipoMov);
	return querySelect;
  }  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_conf_mov oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from skTipoConfMovStk");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getTiposMovimientos(ConfMovStkTalonario confMovStkTalonario,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(TipoConfMovStkTalonario.NICKNAME,
                                          DBTipoConfMovStkTalonario.SELECT_BY_CONF_MOV_STOCK,
                                          confMovStkTalonario,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getTiposMovimientosByTipo(ConfMovStkTalonario confMovStkTalonario,
		  								 	   String tipoMov,	
		  								       ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ConfMovStkTalonario.NICKNAME,confMovStkTalonario);
	  condiciones.put("TIPO_MOV",tipoMov);
	  return (List) ObjetoLogico.getObjects(TipoConfMovStkTalonario.NICKNAME,
             DBTipoConfMovStkTalonario.SELECT_BY_CONF_MOV_STOCK_Y_TIPO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static List getTiposMovimientosByTipoCC(ConfMovStkTalonario confMovStkTalonario,
		  ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ConfMovStkTalonario.NICKNAME,confMovStkTalonario);
	  condiciones.put("TIPO_MOV",TipoConfMovStkTalonario.CONTROL_CALIDAD);
	  return (List) ObjetoLogico.getObjects(TipoConfMovStkTalonario.NICKNAME,
			  DBTipoConfMovStkTalonario.SELECT_BY_CONF_MOV_STOCK_Y_TIPO,
			  condiciones,
			  new ListObserver(),
			  aSesion);
  }
  
  public static List getTiposMovimientosByTipoCCOK(ConfMovStkTalonario confMovStkTalonario,
		  ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ConfMovStkTalonario.NICKNAME,confMovStkTalonario);
	  condiciones.put("TIPO_MOV",TipoConfMovStkTalonario.CONTROL_CALIDAD_OK);
	  return (List) ObjetoLogico.getObjects(TipoConfMovStkTalonario.NICKNAME,
			  DBTipoConfMovStkTalonario.SELECT_BY_CONF_MOV_STOCK_Y_TIPO,
			  condiciones,
			  new ListObserver(),
			  aSesion);
  }
  
  public static List getTiposMovimientosByTipoCCMal(ConfMovStkTalonario confMovStkTalonario,
		  ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ConfMovStkTalonario.NICKNAME,confMovStkTalonario);
	  condiciones.put("TIPO_MOV",TipoConfMovStkTalonario.CONTROL_CALIDAD_MAL);
	  return (List) ObjetoLogico.getObjects(TipoConfMovStkTalonario.NICKNAME,
			  DBTipoConfMovStkTalonario.SELECT_BY_CONF_MOV_STOCK_Y_TIPO,
			  condiciones,
			  new ListObserver(),
			  aSesion);
  }   
  
  public static List getTiposMovimientosByTipoInfRec(ConfMovStkTalonario confMovStkTalonario,
		  ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ConfMovStkTalonario.NICKNAME,confMovStkTalonario);
	  condiciones.put("TIPO_MOV",TipoConfMovStkTalonario.RECEPCION_MERC);
	  return (List) ObjetoLogico.getObjects(TipoConfMovStkTalonario.NICKNAME,
			  DBTipoConfMovStkTalonario.SELECT_BY_CONF_MOV_STOCK_Y_TIPO,
			  condiciones,
			  new ListObserver(),
			  aSesion);
  }   
  



}
