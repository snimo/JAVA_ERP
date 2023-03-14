package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.SaldoCtaBancoPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoCtaBancoPeriodo extends DBObjetoPersistente {

  public static final String OID_MOV_BCO_SPERI = "oid_mov_bco_speri";
  public static final String OID_PERI = "oid_peri";
  public static final String DEBITOS = "debitos";
  public static final String CREDITOS = "creditos";
  public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";
  public static final String DEBITOS_HIST = "Debitos_hist";
  public static final String CREDITOS_HIST = "Creditos_hist";
  public static final String DEBITOS_AJU = "Debitos_Aju";
  public static final String CREDITOS_AJU = "Creditos_Aju";
  public static final String DEBITOS_EXT1 = "Debitos_Ext1";
  public static final String CREDITOS_EXT1 = "Creditos_Ext1";
  public static final String DEBITOS_EXT2 = "Debitos_Ext2";
  public static final String CREDITOS_EXT2 = "Creditos_Ext2";

  public static final int SELECT_BY_CUENTA_Y_PERIODO = 100;

  public DBSaldoCtaBancoPeriodo() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_MOV_BCO_SPERI = 1;
    final int OID_PERI = 2;
    final int DEBITOS = 3;
    final int CREDITOS = 4;
    final int OID_CTA_BANCARIA = 5;
    final int DEBITOS_HIST = 6;
    final int CREDITOS_HIST = 7;
    final int DEBITOS_AJU = 8;
    final int CREDITOS_AJU = 9;
    final int DEBITOS_EXT1 = 10;
    final int CREDITOS_EXT1 = 11;
    final int DEBITOS_EXT2 = 12;
    final int CREDITOS_EXT2 = 13;

    SaldoCtaBancoPeriodo pers = (SaldoCtaBancoPeriodo) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaMovimBcoSPeri "+
                     " ( "+
                      "OID_MOV_BCO_SPERI,"+
                      "OID_PERI,"+
                      "DEBITOS,"+
                      "CREDITOS,"+
                      "OID_CTA_BANCARIA,"+
                      "DEBITOS_HIST,"+
                      "CREDITOS_HIST,"+
                      "DEBITOS_AJU,"+
                      "CREDITOS_AJU,"+
                      "DEBITOS_EXT1,"+
                      "CREDITOS_EXT1,"+
                      "DEBITOS_EXT2,"+
                      "CREDITOS_EXT2)"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_MOV_BCO_SPERI,pers.getOID());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    qInsert.setDouble(DEBITOS,pers.getDebitos().doubleValue());
    qInsert.setDouble(CREDITOS,pers.getCreditos().doubleValue());
    qInsert.setInt(OID_CTA_BANCARIA,pers.getCuentabancaria().getOID());
    qInsert.setDouble(DEBITOS_HIST,pers.getDebitoshist().doubleValue());
    qInsert.setDouble(CREDITOS_HIST,pers.getCreditoshist().doubleValue());
    qInsert.setDouble(DEBITOS_AJU,pers.getDebitosaju().doubleValue());
    qInsert.setDouble(CREDITOS_AJU,pers.getCreditosaju().doubleValue());
    qInsert.setDouble(DEBITOS_EXT1,pers.getDebitosext1().doubleValue());
    qInsert.setDouble(CREDITOS_EXT1,pers.getCreditosext1().doubleValue());
    qInsert.setDouble(DEBITOS_EXT2,pers.getDebitosext2().doubleValue());
    qInsert.setDouble(CREDITOS_EXT2,pers.getCreditosext2().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI = 1;
    final int DEBITOS = 2;
    final int CREDITOS = 3;
    final int OID_CTA_BANCARIA = 4;
    final int DEBITOS_HIST = 5;
    final int CREDITOS_HIST = 6;
    final int DEBITOS_AJU = 7;
    final int CREDITOS_AJU = 8;
    final int DEBITOS_EXT1 = 9;
    final int CREDITOS_EXT1 = 10;
    final int DEBITOS_EXT2 = 11;
    final int CREDITOS_EXT2 = 12;
    final int OID_MOV_BCO_SPERI = 13;

    SaldoCtaBancoPeriodo pers = (SaldoCtaBancoPeriodo) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaMovimBcoSPeri set "+
              "oid_peri=?"+
              ",debitos=debitos+?"+
              ",creditos=creditos+?"+
              ",oid_cta_bancaria=?"+
              ",Debitos_hist=Debitos_hist+?"+
              ",Creditos_hist=Creditos_hist+?"+
              ",Debitos_Aju=Debitos_Aju+?"+
              ",Creditos_Aju=Creditos_Aju+?"+
              ",Debitos_Ext1=Debitos_Ext1+?"+
              ",Creditos_Ext1=Creditos_Ext1+?"+
              ",Debitos_Ext2=Debitos_Ext2+?"+
              ",Creditos_Ext2=Creditos_Ext2+?"+
                 " where " +
                 " oid_mov_bco_speri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_BCO_SPERI,pers.getOID());
    qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    qUpdate.setDouble(DEBITOS,pers.getDebitos().doubleValue());
    qUpdate.setDouble(CREDITOS,pers.getCreditos().doubleValue());
    qUpdate.setInt(OID_CTA_BANCARIA,pers.getCuentabancaria().getOID());
    qUpdate.setDouble(DEBITOS_HIST,pers.getDebitoshist().doubleValue());
    qUpdate.setDouble(CREDITOS_HIST,pers.getCreditoshist().doubleValue());
    qUpdate.setDouble(DEBITOS_AJU,pers.getDebitosaju().doubleValue());
    qUpdate.setDouble(CREDITOS_AJU,pers.getCreditosaju().doubleValue());
    qUpdate.setDouble(DEBITOS_EXT1,pers.getDebitosext1().doubleValue());
    qUpdate.setDouble(CREDITOS_EXT1,pers.getCreditosext1().doubleValue());
    qUpdate.setDouble(DEBITOS_EXT2,pers.getDebitosext2().doubleValue());
    qUpdate.setDouble(CREDITOS_EXT2,pers.getCreditosext2().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MOV_BCO_SPERI = 1;
    SaldoCtaBancoPeriodo pers = (SaldoCtaBancoPeriodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaMovimBcoSPeri "+
                     " set activo=0 " +
                     " where " +
                     " oid_mov_bco_speri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_BCO_SPERI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MOV_BCO_SPERI = 1;
    SaldoCtaBancoPeriodo pers = (SaldoCtaBancoPeriodo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaMovimBcoSPeri "+
                     " set activo=1 " +
                     " where " +
                     " oid_mov_bco_speri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_BCO_SPERI, pers.getOID());
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
      case SELECT_BY_CUENTA_Y_PERIODO: {
        ps = this.selectByCuentayPeriodo(aCondiciones);
        break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_MOV_BCO_SPERI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaMovimBcoSPeri ");
    textSQL.append(" WHERE oid_mov_bco_speri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_MOV_BCO_SPERI, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaMovimBcoSPeri ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mov_bco_speri oid, codigo, Debitos_Aju descripcion ,activo ");
    textSQL.append(" from vaMovimBcoSPeri");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByCuentayPeriodo(Object aCondiciones) throws BaseException, SQLException {

    Hashtable condiciones = (Hashtable) aCondiciones;
    CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
    Periodo periodo = (Periodo) condiciones.get(Periodo.NICKNAME);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaMovimBcoSPeri ");
    textSQL.append(" WHERE  oid_cta_bancaria = ? and oid_peri=? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1, cuentaBancaria.getOID());
    querySelect.setInt(2,periodo.getOID());
    return querySelect;
  }

  public static SaldoCtaBancoPeriodo getSaldoByCuentayFecha(CuentaBancaria cuentaBancaria,
                                                       Periodo periodo,
                                                       ISesion aSesion)
                                                      throws BaseException {

    Hashtable condiciones = new Hashtable();
    condiciones.put(CuentaBancaria.NICKNAME,cuentaBancaria);
    condiciones.put(Periodo.NICKNAME,periodo);

    return (SaldoCtaBancoPeriodo) ObjetoLogico.getObjects(SaldoCtaBancoPeriodo.NICKNAME,
                                                      DBSaldoCtaBancoPeriodo.SELECT_BY_CUENTA_Y_PERIODO,
                                                      condiciones,
                                                      new ObjetoObservado(),
                                                      aSesion);
  }



}
