package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import com.srn.erp.ventas.bm.BonifRecarSujeto;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBBonifRecarSujeto extends DBObjetoPersistente {

  public static final String OID_BONIF_RECAR = "oid_bonif_recar";
  public static final String FEC_VIG_DESDE = "fec_vig_desde";
  public static final String FEC_VIG_HASTA = "fec_vig_hasta";
  public static final String BONIF1 = "bonif1";
  public static final String BONIF2 = "bonif2";
  public static final String BONIF3 = "bonif3";
  public static final String BONIF4 = "bonif4";
  public static final String BONIF5 = "bonif5";
  public static final String EN_CASCADA_BONIF = "en_cascada_bonif";
  public static final String RECA1 = "reca1";
  public static final String RECA2 = "reca2";
  public static final String RECA3 = "reca3";
  public static final String RECA4 = "reca4";
  public static final String RECA5 = "reca5";
  public static final String EN_CASCADA_RECA = "en_cascada_reca";
  public static final String OID_SUJETO = "oid_sujeto";

  public static final int SELECT_BY_SUJETO = 100;
  public static final int SELECT_BY_SUJETO_FECHA = 101;

  public DBBonifRecarSujeto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_BONIF_RECAR = 1;
    final int FEC_VIG_DESDE = 2;
    final int BONIF1 = 3;
    final int BONIF2 = 4;
    final int BONIF3 = 5;
    final int BONIF4 = 6;
    final int BONIF5 = 7;
    final int EN_CASCADA_BONIF = 8;
    final int RECA1 = 9;
    final int RECA2 = 10;
    final int RECA3 = 11;
    final int RECA4 = 12;
    final int RECA5 = 13;
    final int EN_CASCADA_RECA = 14;
    final int OID_SUJETO = 15;
    final int FEC_VIG_HASTA = 16;

    BonifRecarSujeto pers = (BonifRecarSujeto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veSujBonifRecar "+
                     " ( "+
                      "OID_BONIF_RECAR,"+
                      "FEC_VIG_DESDE,"+
                      "BONIF1,"+
                      "BONIF2,"+
                      "BONIF3,"+
                      "BONIF4,"+
                      "BONIF5,"+
                      "EN_CASCADA_BONIF,"+
                      "RECA1,"+
                      "RECA2,"+
                      "RECA3,"+
                      "RECA4,"+
                      "RECA5,"+
                      "EN_CASCADA_RECA,"+
                      "OID_SUJETO,FEC_VIG_HASTA)"+
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_BONIF_RECAR,pers.getOID());
    qInsert.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFec_vig_desde().getTime()));
    if (pers.getBonif1()!=null)
      qInsert.setDouble(BONIF1,pers.getBonif1().doubleValue());
    else
      qInsert.setNull(BONIF1,java.sql.Types.DOUBLE);
    if (pers.getBonif2()!=null)
      qInsert.setDouble(BONIF2,pers.getBonif2().doubleValue());
    else
      qInsert.setNull(BONIF2,java.sql.Types.DOUBLE);
    if (pers.getBonif3()!=null)
      qInsert.setDouble(BONIF3,pers.getBonif3().doubleValue());
    else
      qInsert.setNull(BONIF3,java.sql.Types.DOUBLE);
    if (pers.getBonif4()!=null)
      qInsert.setDouble(BONIF4,pers.getBonif4().doubleValue());
    else
      qInsert.setNull(BONIF4,java.sql.Types.DOUBLE);
    if (pers.getBonif5()!=null)
      qInsert.setDouble(BONIF5,pers.getBonif5().doubleValue());
    else
      qInsert.setNull(BONIF5,java.sql.Types.DOUBLE);
    qInsert.setBoolean(EN_CASCADA_BONIF,pers.isEn_cascada_bonif().booleanValue());
    if (pers.getReca1()!=null)
      qInsert.setDouble(RECA1,pers.getReca1().doubleValue());
    else
      qInsert.setNull(RECA1,java.sql.Types.DOUBLE);
    if (pers.getReca2()!=null)
      qInsert.setDouble(RECA2,pers.getReca2().doubleValue());
    else
      qInsert.setNull(RECA2,java.sql.Types.DOUBLE);
    if (pers.getReca3()!=null)
      qInsert.setDouble(RECA3,pers.getReca3().doubleValue());
    else
      qInsert.setNull(RECA3,java.sql.Types.DOUBLE);
    if (pers.getReca4()!=null)
      qInsert.setDouble(RECA4,pers.getReca4().doubleValue());
    else
      qInsert.setNull(RECA4,java.sql.Types.DOUBLE);
    if (pers.getReca5()!=null)
      qInsert.setDouble(RECA5,pers.getReca5().doubleValue());
    else
      qInsert.setNull(RECA5,java.sql.Types.DOUBLE);
    qInsert.setBoolean(EN_CASCADA_RECA,pers.isEn_cascada_reca().booleanValue());
    qInsert.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qInsert.setDate(FEC_VIG_HASTA,new java.sql.Date(pers.getFec_vig_hasta().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int FEC_VIG_DESDE = 1;
    final int BONIF1 = 2;
    final int BONIF2 = 3;
    final int BONIF3 = 4;
    final int BONIF4 = 5;
    final int BONIF5 = 6;
    final int EN_CASCADA_BONIF = 7;
    final int RECA1 = 8;
    final int RECA2 = 9;
    final int RECA3 = 10;
    final int RECA4 = 11;
    final int RECA5 = 12;
    final int EN_CASCADA_RECA = 13;
    final int OID_SUJETO = 14;
    final int FEC_VIG_HASTA = 15;
    final int OID_BONIF_RECAR = 16;

    BonifRecarSujeto pers = (BonifRecarSujeto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veSujBonifRecar set "+
              "fec_vig_desde=?"+
              ",bonif1=?"+
              ",bonif2=?"+
              ",bonif3=?"+
              ",bonif4=?"+
              ",bonif5=?"+
              ",en_cascada_bonif=?"+
              ",reca1=?"+
              ",reca2=?"+
              ",reca3=?"+
              ",reca4=?"+
              ",reca5=?"+
              ",en_cascada_reca=?"+
              ",oid_sujeto=?"+
              ",fec_vig_hasta=?"+
                 " where " +
                 " oid_bonif_recar=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_BONIF_RECAR,pers.getOID());
    qUpdate.setDate(FEC_VIG_DESDE,new java.sql.Date(pers.getFec_vig_desde().getTime()));
    qUpdate.setDate(FEC_VIG_HASTA,new java.sql.Date(pers.getFec_vig_hasta().getTime()));
    if (pers.getBonif1()!=null)
      qUpdate.setDouble(BONIF1,pers.getBonif1().doubleValue());
    else
      qUpdate.setNull(BONIF1,java.sql.Types.DOUBLE);
    if (pers.getBonif2()!=null)
      qUpdate.setDouble(BONIF2,pers.getBonif2().doubleValue());
    else
      qUpdate.setNull(BONIF2,java.sql.Types.DOUBLE);
    if (pers.getBonif3()!=null)
      qUpdate.setDouble(BONIF3,pers.getBonif3().doubleValue());
    else
      qUpdate.setNull(BONIF3,java.sql.Types.DOUBLE);
    if (pers.getBonif4()!=null)
      qUpdate.setDouble(BONIF4,pers.getBonif4().doubleValue());
    else
      qUpdate.setNull(BONIF4,java.sql.Types.DOUBLE);
    if (pers.getBonif5()!=null)
      qUpdate.setDouble(BONIF5,pers.getBonif5().doubleValue());
    else
      qUpdate.setNull(BONIF5,java.sql.Types.DOUBLE);
    qUpdate.setBoolean(EN_CASCADA_BONIF,pers.isEn_cascada_bonif().booleanValue());
    if (pers.getReca1()!=null)
      qUpdate.setDouble(RECA1,pers.getReca1().doubleValue());
    else
      qUpdate.setNull(RECA1,java.sql.Types.DOUBLE);
    if (pers.getReca2()!=null)
      qUpdate.setDouble(RECA2,pers.getReca2().doubleValue());
    else
      qUpdate.setNull(RECA2,java.sql.Types.DOUBLE);
    if (pers.getReca3()!=null)
      qUpdate.setDouble(RECA3,pers.getReca3().doubleValue());
    else
      qUpdate.setNull(RECA3,java.sql.Types.DOUBLE);
    if (pers.getReca4()!=null)
      qUpdate.setDouble(RECA4,pers.getReca4().doubleValue());
    else
      qUpdate.setNull(RECA4,java.sql.Types.DOUBLE);
    if (pers.getReca5()!=null)
      qUpdate.setDouble(RECA5,pers.getReca5().doubleValue());
    else
      qUpdate.setNull(RECA5,java.sql.Types.DOUBLE);
    qUpdate.setBoolean(EN_CASCADA_RECA,pers.isEn_cascada_reca().booleanValue());
    qUpdate.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_BONIF_RECAR = 1;
    BonifRecarSujeto pers = (BonifRecarSujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veSujBonifRecar "+
                     " set activo=0 " +
                     " where " +
                     " oid_bonif_recar=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_BONIF_RECAR, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_BONIF_RECAR = 1;
    BonifRecarSujeto pers = (BonifRecarSujeto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veSujBonifRecar "+
                     " set activo=1 " +
                     " where " +
                     " oid_bonif_recar=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_BONIF_RECAR, pers.getOID());
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
      case SELECT_BY_SUJETO: {
        ps = this.selectBySujeto(aCondiciones);
        break;
      }
      case SELECT_BY_SUJETO_FECHA: {
        ps = this.selectBySujetoFecha(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_BONIF_RECAR = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSujBonifRecar ");
    textSQL.append(" WHERE oid_bonif_recar = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_BONIF_RECAR, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSujBonifRecar ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_bonif_recar oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veSujBonifRecar");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectBySujeto(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    Sujeto sujeto = (Sujeto) aCondiciones;
    textSQL.append("SELECT * ");
    textSQL.append(" from veSujBonifRecar where oid_sujeto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,sujeto.getOID());
    return querySelect;
  }

  private PreparedStatement selectBySujetoFecha(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
    java.util.Date fecha = (java.util.Date) condiciones.get("fecha");
    textSQL.append("SELECT * ");
    textSQL.append(" from veSujBonifRecar where oid_sujeto = ? and fec_vig_desde <= ? and fec_vig_hasta>=?  ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1,sujeto.getOID());
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    querySelect.setDate(3,new java.sql.Date(fecha.getTime()));
    return querySelect;
  }


  public static List getBonifRecar(Sujeto sujeto,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(BonifRecarSujeto.NICKNAME,
                                          DBBonifRecarSujeto.SELECT_BY_SUJETO,
                                          sujeto,
                                          new ListObserver(),
                                          aSesion);
  }

  public static BonifRecarSujeto getBonifRecarVigente(Sujeto sujeto,
                                                      java.util.Date fecha,
                                                      ISesion aSesion) throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Sujeto.NICKNAME,sujeto);
    condiciones.put("fecha",fecha);
    return (BonifRecarSujeto) ObjetoLogico.getObjects(BonifRecarSujeto.NICKNAME,
                                          DBBonifRecarSujeto.SELECT_BY_SUJETO_FECHA,
                                          condiciones,
                                          new ObjetoObservado(),
                                          aSesion);
  }




}
