package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import com.srn.erp.tesoreria.bm.CuentaBancaria;
import com.srn.erp.tesoreria.bm.SaldoCtaBancoDia;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBSaldoCtaBancoDia extends DBObjetoPersistente {

  public static final String OID_MOV_BCO_SFEC = "oid_mov_bco_sfec";
  public static final String FECHA = "fecha";
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

  public static final int SELECT_BY_CUENTA_Y_FECHA = 100;

  public DBSaldoCtaBancoDia() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_MOV_BCO_SFEC = 1;
    final int FECHA = 2;
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

    SaldoCtaBancoDia pers = (SaldoCtaBancoDia) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaMovimBcoSFec "+
                     " ( "+
                      "OID_MOV_BCO_SFEC,"+
                      "FECHA,"+
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
    qInsert.setInt(OID_MOV_BCO_SFEC,pers.getOID());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
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

    final int FECHA = 1;
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
    final int OID_MOV_BCO_SFEC = 13;

    SaldoCtaBancoDia pers = (SaldoCtaBancoDia) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaMovimBcoSFec set "+
              "fecha=?"+
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
                 " oid_mov_bco_sfec=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_BCO_SFEC,pers.getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
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
    final int OID_MOV_BCO_SFEC = 1;
    SaldoCtaBancoDia pers = (SaldoCtaBancoDia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaMovimBcoSFec "+
                     " set activo=0 " +
                     " where " +
                     " oid_mov_bco_sfec=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_BCO_SFEC, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MOV_BCO_SFEC = 1;
    SaldoCtaBancoDia pers = (SaldoCtaBancoDia) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaMovimBcoSFec "+
                     " set activo=1 " +
                     " where " +
                     " oid_mov_bco_sfec=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MOV_BCO_SFEC, pers.getOID());
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
      case SELECT_BY_CUENTA_Y_FECHA: {
        ps = this.selectByCuentayFecha(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_MOV_BCO_SFEC = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaMovimBcoSFec ");
    textSQL.append(" WHERE oid_mov_bco_sfec = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_MOV_BCO_SFEC, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaMovimBcoSFec ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCuentayFecha(Object aCondiciones) throws BaseException, SQLException {

    Hashtable condiciones = (Hashtable) aCondiciones;
    CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
    java.util.Date fecha = (java.util.Date) condiciones.get(DBSaldoCtaBancoDia.FECHA);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaMovimBcoSFec ");
    textSQL.append(" WHERE  oid_cta_bancaria = ? and fecha=? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1, cuentaBancaria.getOID());
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_mov_bco_sfec oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaMovimBcoSFec");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static SaldoCtaBancoDia getSaldoByCuentayFecha(CuentaBancaria cuentaBancaria,
                                                       java.util.Date fecha,
                                                       ISesion aSesion)
                                                      throws BaseException {

    Hashtable condiciones = new Hashtable();
    condiciones.put(CuentaBancaria.NICKNAME,cuentaBancaria);
    condiciones.put(DBSaldoCtaBancoDia.FECHA,fecha);

    return (SaldoCtaBancoDia) ObjetoLogico.getObjects(SaldoCtaBancoDia.NICKNAME,
                                                      DBSaldoCtaBancoDia.SELECT_BY_CUENTA_Y_FECHA,
                                                      condiciones,
                                                      new ObjetoObservado(),
                                                      aSesion);
  }



}
