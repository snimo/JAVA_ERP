package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBCuentaBancaria extends DBObjetoPersistente {

  public static final String CODIGO = "codigo";
  public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";
  public static final String OID_BANCO = "oid_banco";
  public static final String NRO_CUENTA = "nro_cuenta";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  public static final String COMPO = "compo";
  public static final String OID_AI = "oid_ai";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String OID_AI_REAL = "oid_ai_real";
  public static final String CLEARING_EN_DIAS = "clearing_en_dias";

  public static final int SELECT_ALL_CTACTE = 100;
  public static final int SELECT_BY_CODIGO_CTACTE = 101;

  public DBCuentaBancaria() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CTA_BANCARIA = 1;
    final int OID_BANCO = 2;
    final int NRO_CUENTA = 3;
    final int DESCRIPCION = 4;
    final int ACTIVO = 5;
    final int COMPO = 6;
    final int CODIGO = 7;
    final int OID_AI = 8;
    final int OID_MONEDA = 9;
    final int OID_AI_REAL = 10;
    final int CLEARING_EN_DIAS = 11;

    CuentaBancaria pers = (CuentaBancaria) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaCuentaBancaria "+
                     " ( "+
                      "OID_CTA_BANCARIA,"+
                      "OID_BANCO,"+
                      "NRO_CUENTA,"+
                      "DESCRIPCION,"+
                      "ACTIVO,"+
                      "COMPO,"+
                      "CODIGO,"+
                      "OID_AI,OID_MONEDA,OID_AI_REAL,CLEARING_EN_DIAS)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CTA_BANCARIA,pers.getOID());
    qInsert.setInt(OID_BANCO,pers.getBanco().getOID());
    qInsert.setString(NRO_CUENTA,pers.getNrocuenta());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(COMPO,pers.getCompo());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setInt(OID_AI,pers.getCuentaimputableAConciliar().getOID());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    if (pers.getCuentaMovRealesBco()!=null)
    	qInsert.setInt(OID_AI_REAL,pers.getCuentaMovRealesBco().getOIDInteger());
    else
    	qInsert.setNull(OID_AI_REAL,java.sql.Types.INTEGER);
    if (pers.getClearingEnDias()!=null)
    	qInsert.setInt(CLEARING_EN_DIAS,pers.getClearingEnDias().intValue());
    else
    	qInsert.setInt(CLEARING_EN_DIAS,0);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_BANCO = 1;
    final int NRO_CUENTA = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;
    final int COMPO = 5;
    final int CODIGO = 6;
    final int OID_AI = 7;
    final int OID_MONEDA = 8;
    final int OID_AI_REAL = 9;
    final int CLEARING_EN_DIAS = 10;
    final int OID_CTA_BANCARIA = 11;

    CuentaBancaria pers = (CuentaBancaria) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaCuentaBancaria set "+
              "oid_banco=?"+
              ",nro_cuenta=?"+
              ",descripcion=?"+
              ",activo=?"+
              ",compo=?"+
              ",codigo=?"+
              ",oid_ai=?"+
              ",oid_moneda=?"+
              ",oid_ai_real=?"+
              ",clearing_en_dias=?"+
                 " where " +
                 " oid_cta_bancaria=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CTA_BANCARIA,pers.getOID());
    qUpdate.setInt(OID_BANCO,pers.getBanco().getOID());
    qUpdate.setString(NRO_CUENTA,pers.getNrocuenta());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(COMPO,pers.getCompo());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setInt(OID_AI,pers.getCuentaimputableAConciliar().getOID());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    if (pers.getCuentaMovRealesBco()!=null)
    	qUpdate.setInt(OID_AI_REAL,pers.getCuentaMovRealesBco().getOIDInteger());
    else
    	qUpdate.setNull(OID_AI_REAL,java.sql.Types.INTEGER);
    if (pers.getClearingEnDias()!=null)
    	qUpdate.setInt(CLEARING_EN_DIAS,pers.getClearingEnDias().intValue());
    else
    	qUpdate.setInt(CLEARING_EN_DIAS,0);    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CTA_BANCARIA = 1;
    CuentaBancaria pers = (CuentaBancaria) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaCuentaBancaria "+
                     " set activo=0 " +
                     " where " +
                     " oid_cta_bancaria=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CTA_BANCARIA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CTA_BANCARIA = 1;
    CuentaBancaria pers = (CuentaBancaria) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaCuentaBancaria "+
                     " set activo=1 " +
                     " where " +
                     " oid_cta_bancaria=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CTA_BANCARIA, pers.getOID());
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
      case SELECT_ALL_CTACTE: {
        ps = this.selectAllHelpCtaCte(aCondiciones);
        break;
      }
      case SELECT_BY_CODIGO_CTACTE: {
        ps = this.selectByCodigoCtaCte(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CTA_BANCARIA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCuentaBancaria ");
    textSQL.append(" WHERE oid_cta_bancaria = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CTA_BANCARIA, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCuentaBancaria ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCodigoCtaCte(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCuentaBancaria ");
    textSQL.append(" WHERE codigo = ? and compo='CC' ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Hashtable condiciones = (Hashtable) aCondiciones;

    String codigo = (String) condiciones.get("codigo");
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cta_bancaria oid,codigo codigo,  descripcion ,activo ");
    textSQL.append(" from vaCuentaBancaria");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectAllHelpCtaCte(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cta_bancaria oid,codigo codigo,  descripcion ,activo ");
    textSQL.append(" from vaCuentaBancaria where compo='CC' ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }


}

