package com.srn.erp.ctacte.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctacte.bm.TipoCtaCteClie;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBTipoCtaCteClie extends DBObjetoPersistente {

  public static final String OID_TIPO_CTA_CLIE = "oid_tipo_cta_clie";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";

  public DBTipoCtaCteClie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TIPO_CTA_CLIE = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;

    TipoCtaCteClie pers = (TipoCtaCteClie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into ccTipoCtaClie "+
                     " ( "+
                      "OID_TIPO_CTA_CLIE,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_TIPO_CTA_CLIE,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int ACTIVO = 3;
    final int OID_TIPO_CTA_CLIE = 4;

    TipoCtaCteClie pers = (TipoCtaCteClie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update ccTipoCtaClie set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
                 " where " +
                 " oid_tipo_cta_clie=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CTA_CLIE,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TIPO_CTA_CLIE = 1;
    TipoCtaCteClie pers = (TipoCtaCteClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update ccTipoCtaClie "+
                     " set activo=0 " +
                     " where " +
                     " oid_tipo_cta_clie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CTA_CLIE, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TIPO_CTA_CLIE = 1;
    TipoCtaCteClie pers = (TipoCtaCteClie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update ccTipoCtaClie "+
                     " set activo=1 " +
                     " where " +
                     " oid_tipo_cta_clie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CTA_CLIE, pers.getOID());
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

    final int OID_TIPO_CTA_CLIE = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  ccTipoCtaClie ");
    textSQL.append(" WHERE oid_tipo_cta_clie = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TIPO_CTA_CLIE, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  ccTipoCtaClie ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_cta_clie oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from ccTipoCtaClie");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
