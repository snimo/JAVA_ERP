package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.impuestos.bm.CategoriaIVA;
import com.srn.erp.impuestos.bm.TalonarioCategoriaIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBTalonarioCategoriaIVA extends DBObjetoPersistente {

  public static final String OID_TAL_CAT_IVA = "oid_tal_cat_iva";
  public static final String OID_CAT_IVA = "oid_cat_iva";
  public static final String OID_TALONARIO = "oid_tal_fact";

  public static final int SELECT_BY_CAT_IVA = 100;

  public DBTalonarioCategoriaIVA() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TAL_CAT_IVA = 1;
    final int OID_CAT_IVA = 2;
    final int OID_TALONARIO = 3;

    TalonarioCategoriaIVA pers = (TalonarioCategoriaIVA) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imTalHabCatIVA "+
                     " ( "+
                      "OID_TAL_CAT_IVA,"+
                      "OID_CAT_IVA,"+
                      "OID_TAL_FACT)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_TAL_CAT_IVA,pers.getOID());
    qInsert.setInt(OID_CAT_IVA,pers.getCategoria_iva().getOID());
    qInsert.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CAT_IVA = 1;
    final int OID_TALONARIO = 2;
    final int OID_TAL_CAT_IVA = 3;

    TalonarioCategoriaIVA pers = (TalonarioCategoriaIVA) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imTalHabCatIVA set "+
              "oid_cat_iva=?"+
              ",oid_tal_fact=?"+
                 " where " +
                 " oid_tal_cat_iva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TAL_CAT_IVA,pers.getOID());
    qUpdate.setInt(OID_CAT_IVA,pers.getCategoria_iva().getOID());
    qUpdate.setInt(OID_TALONARIO,pers.getTalonario().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TAL_CAT_IVA = 1;
    TalonarioCategoriaIVA pers = (TalonarioCategoriaIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from imTalHabCatIVA "+
                     " where " +
                     " oid_tal_cat_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TAL_CAT_IVA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TAL_CAT_IVA = 1;
    TalonarioCategoriaIVA pers = (TalonarioCategoriaIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imTalHabCatIVA "+
                     " set activo=1 " +
                     " where " +
                     " oid_tal_cat_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TAL_CAT_IVA, pers.getOID());
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
      case SELECT_BY_CAT_IVA: {
        ps = this.selectByCatIVA(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_TAL_CAT_IVA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTalHabCatIVA ");
    textSQL.append(" WHERE oid_tal_cat_iva = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TAL_CAT_IVA, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTalHabCatIVA ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCatIVA(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTalHabCatIVA ");
    textSQL.append(" WHERE oid_cat_iva = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    CategoriaIVA categoriaIVA = (CategoriaIVA) aCondiciones;
    querySelect.setInt(1, categoriaIVA.getOID());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tal_cat_iva oid, codigo,  descripcion ,activo ");
    textSQL.append(" from imTalHabCatIVA");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getTalonariosCatIVA(CategoriaIVA categoriaIVA,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(TalonarioCategoriaIVA.NICKNAME,
                                          DBTalonarioCategoriaIVA.SELECT_BY_CAT_IVA,
                                          categoriaIVA,
                                          new ListObserver(),
                                          aSesion);
  }


}
