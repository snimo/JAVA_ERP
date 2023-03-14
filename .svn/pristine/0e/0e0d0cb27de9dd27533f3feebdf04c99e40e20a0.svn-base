package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ConcFactProv;
import com.srn.erp.ctasAPagar.bm.ConcFactProvImp;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBConcFactProvImp extends DBObjetoPersistente {

  public static final String OID_CONC_PROV_IMP = "oid_conc_prov_imp";
  public static final String OID_CONC_FACT_PROV = "oid_conc_fact_prov";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String CALCULA_EN_FACT = "calcula_en_fact";
  public static final String CALCULA_EN_OP = "calcula_en_op";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_CONC_FACT_PROV = 100;
  public static final int SELECT_BY_CONC_FACT_PROV_ACT = 101;

  public DBConcFactProvImp() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONC_PROV_IMP = 1;
    final int OID_CONC_FACT_PROV = 2;
    final int OID_CONC_IMPU = 3;
    final int CALCULA_EN_FACT = 4;
    final int CALCULA_EN_OP = 5;
    final int ACTIVO = 6;

    ConcFactProvImp pers = (ConcFactProvImp) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpConcFactProvImp "+
                     " ( "+
                      "OID_CONC_PROV_IMP,"+
                      "OID_CONC_FACT_PROV,"+
                      "OID_CONC_IMPU,"+
                      "CALCULA_EN_FACT,"+
                      "CALCULA_EN_OP,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CONC_PROV_IMP,pers.getOID());
    qInsert.setInt(OID_CONC_FACT_PROV,pers.getConcFactProv().getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConcImpuesto().getOID());
    qInsert.setBoolean(CALCULA_EN_FACT,pers.isCalculaEnFact().booleanValue());
    qInsert.setBoolean(CALCULA_EN_OP,pers.isCalculaEnOP().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONC_FACT_PROV = 1;
    final int OID_CONC_IMPU = 2;
    final int CALCULA_EN_FACT = 3;
    final int CALCULA_EN_OP = 4;
    final int ACTIVO = 5;
    final int OID_CONC_PROV_IMP = 6;

    ConcFactProvImp pers = (ConcFactProvImp) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpConcFactProvImp set "+
              "oid_conc_fact_prov=?"+
              ",oid_conc_impu=?"+
              ",calcula_en_fact=?"+
              ",calcula_en_op=?"+
              ",activo=?"+
                 " where " +
                 " oid_conc_prov_imp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONC_PROV_IMP,pers.getOID());
    qUpdate.setInt(OID_CONC_FACT_PROV,pers.getConcFactProv().getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConcImpuesto().getOID());
    qUpdate.setBoolean(CALCULA_EN_FACT,pers.isCalculaEnFact().booleanValue());
    qUpdate.setBoolean(CALCULA_EN_OP,pers.isCalculaEnOP().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONC_PROV_IMP = 1;
    ConcFactProvImp pers = (ConcFactProvImp) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpConcFactProvImp "+
                     " set activo=0 " +
                     " where " +
                     " oid_conc_prov_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONC_PROV_IMP, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONC_PROV_IMP = 1;
    ConcFactProvImp pers = (ConcFactProvImp) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpConcFactProvImp "+
                     " set activo=1 " +
                     " where " +
                     " oid_conc_prov_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONC_PROV_IMP, pers.getOID());
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
      case SELECT_BY_CONC_FACT_PROV: {
        ps = this.selectByConcFactProv(aCondiciones);
        break;
      }
      case SELECT_BY_CONC_FACT_PROV_ACT: {
        ps = this.selectByConcFactProvAct(aCondiciones);
        break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CONC_PROV_IMP = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpConcFactProvImp ");
    textSQL.append(" WHERE oid_conc_prov_imp = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CONC_PROV_IMP, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpConcFactProvImp ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByConcFactProv(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpConcFactProvImp ");
    textSQL.append(" WHERE  oid_conc_fact_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConcFactProv concFactProv = (ConcFactProv) aCondiciones;
    querySelect.setInt(1, concFactProv.getOID());
    return querySelect;
  }

  private PreparedStatement selectByConcFactProvAct(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpConcFactProvImp ");
    textSQL.append(" WHERE  oid_conc_fact_prov = ? and activo=1 ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConcFactProv concFactProv = (ConcFactProv) aCondiciones;
    querySelect.setInt(1, concFactProv.getOID());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_conc_prov_imp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpConcFactProvImp");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getConcFactProvImpByConcFactProv(ConcFactProv concFactProv,
      ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ConcFactProvImp.NICKNAME,
                                          SELECT_BY_CONC_FACT_PROV,
                                          concFactProv,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getConcFactProvImpByConcFactProvAct(ConcFactProv concFactProv,
      ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ConcFactProvImp.NICKNAME,
                                          SELECT_BY_CONC_FACT_PROV_ACT,
                                          concFactProv,
                                          new ListObserver(),
                                          aSesion);
  }



}
