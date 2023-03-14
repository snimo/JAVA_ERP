package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.impuestos.bm.CategoriaIVA;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBCategoriaIVA extends DBObjetoPersistente {

  public static final String OID_CAT_IVA = "oid_cat_iva";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPO_CAT_IVA = "compo_cat_iva";
  public static final String ACTIVO = "activo";
  public static final String CALC_IVA = "calc_iva";
  public static final String DISC_IVA = "disc_iva";
  public static final String CALC_PERC_IVA = "calc_perc_iva";
  public static final String OID_CONC_IMP_PIVA = "oid_conc_imp_piva";
  public static final String ES_AGE_PERC_IB_BA = "es_age_perc_ib_ba";
  public static final String ES_AGE_PERC_IB_CF = "es_age_perc_ib_cf";

  public DBCategoriaIVA() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CAT_IVA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMPO_CAT_IVA = 4;
    final int ACTIVO = 5;
    final int CALC_IVA = 6;
    final int DISC_IVA = 7;
    final int CALC_PERC_IVA = 8;
    final int OID_CONC_IMP_PIVA = 9;
    final int ES_AGE_PERC_IB_BA = 10;
    final int ES_AGE_PERC_IB_CF = 11;

    CategoriaIVA pers = (CategoriaIVA) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imCatIVA "+
                     " ( "+
                      "OID_CAT_IVA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMPO_CAT_IVA,"+
                      "ACTIVO,"+
                      "CALC_IVA,"+
                      "DISC_IVA,"+
                      "CALC_PERC_IVA,"+
                      "OID_CONC_IMP_PIVA,"+
                      "ES_AGE_PERC_IB_BA,"+
                      "ES_AGE_PERC_IB_CF"+
                      ")"+
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
    qInsert.setInt(OID_CAT_IVA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPO_CAT_IVA,pers.getComportamiento());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(CALC_IVA,pers.isCalculaIVA().booleanValue());
    qInsert.setBoolean(DISC_IVA,pers.isDiscriminaIVA().booleanValue());
    qInsert.setBoolean(CALC_PERC_IVA, pers.isCalcPercIVA().booleanValue());
    if (pers.getConcImpuestoIVA()!=null)
    	qInsert.setInt(OID_CONC_IMP_PIVA,pers.getConcImpuestoIVA().getOID());
    else
    	qInsert.setNull(OID_CONC_IMP_PIVA,Types.INTEGER);
    qInsert.setBoolean(ES_AGE_PERC_IB_BA,pers.isAgentePercIBBsAs());
    qInsert.setBoolean(ES_AGE_PERC_IB_CF,pers.isAgentePercIBCapFed());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMPO_CAT_IVA = 3;
    final int ACTIVO = 4;
    final int CALC_IVA = 5;
    final int DISC_IVA = 6;
    final int CALC_PERC_IVA= 7;
    final int OID_CONC_IMP_PIVA = 8;
    final int ES_AGE_PERC_IB_BA = 9;
    final int ES_AGE_PERC_IB_CF = 10;
    final int OID_CAT_IVA = 11;

    CategoriaIVA pers = (CategoriaIVA) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imCatIVA set "+
              "codigo=?"+
              ",descripcion=?"+
              ",compo_cat_iva=?"+
              ",activo=?"+
              ",calc_iva=?"+
              ",disc_iva=?"+
              ",calc_perc_iva=?"+
              ",oid_conc_imp_piva=?"+
              ",es_age_perc_ib_ba=?"+
              ",es_age_perc_ib_cf=?"+
                 " where " +
                 " oid_cat_iva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAT_IVA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPO_CAT_IVA,pers.getComportamiento());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setBoolean(CALC_IVA,pers.isCalculaIVA().booleanValue());
    qUpdate.setBoolean(DISC_IVA,pers.isDiscriminaIVA().booleanValue());
    qUpdate.setBoolean(CALC_PERC_IVA, pers.isCalcPercIVA().booleanValue());
    if (pers.getConcImpuestoIVA()!=null)
    	qUpdate.setInt(OID_CONC_IMP_PIVA,pers.getConcImpuestoIVA().getOID());
    else
    	qUpdate.setNull(OID_CONC_IMP_PIVA,Types.INTEGER);
    qUpdate.setBoolean(ES_AGE_PERC_IB_BA,pers.isAgentePercIBBsAs());
    qUpdate.setBoolean(ES_AGE_PERC_IB_CF,pers.isAgentePercIBCapFed());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAT_IVA = 1;
    CategoriaIVA pers = (CategoriaIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imCatIVA "+
                     " set activo=0 " +
                     " where " +
                     " oid_cat_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAT_IVA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAT_IVA = 1;
    CategoriaIVA pers = (CategoriaIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imCatIVA "+
                     " set activo=1 " +
                     " where " +
                     " oid_cat_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAT_IVA, pers.getOID());
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
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CAT_IVA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imCatIVA ");
    textSQL.append(" WHERE oid_cat_iva = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CAT_IVA, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imCatIVA ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cat_iva oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from imCatIVA");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
