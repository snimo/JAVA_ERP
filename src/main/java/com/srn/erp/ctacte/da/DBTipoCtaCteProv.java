package com.srn.erp.ctacte.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctacte.bm.TipoCtaCteProv;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBTipoCtaCteProv extends DBObjetoPersistente {

  public static final String OID_TIPO_CTA_PROV = "oid_tipo_cta_prov";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";
  
  public DBTipoCtaCteProv() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TIPO_CTA_PROV = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;

    TipoCtaCteProv pers = (TipoCtaCteProv) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into ccTipoCtaProv "+
                     " ( "+
                      "OID_TIPO_CTA_PROV,"+
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
    qInsert.setInt(OID_TIPO_CTA_PROV,pers.getOID());
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
    final int OID_TIPO_CTA_PROV = 4;

    TipoCtaCteProv pers = (TipoCtaCteProv) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update ccTipoCtaProv set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
                 " where " +
                 " oid_tipo_cta_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CTA_PROV,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TIPO_CTA_PROV = 1;
    TipoCtaCteProv pers = (TipoCtaCteProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update ccTipoCtaProv "+
                     " set activo=0 " +
                     " where " +
                     " oid_tipo_cta_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CTA_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TIPO_CTA_PROV = 1;
    TipoCtaCteProv pers = (TipoCtaCteProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update ccTipoCtaProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_tipo_cta_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TIPO_CTA_PROV, pers.getOID());
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
      case SELECT_ALL: {
          ps = this.getselectAll(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_TIPO_CTA_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  ccTipoCtaProv ");
    textSQL.append(" WHERE oid_tipo_cta_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TIPO_CTA_PROV, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  ccTipoCtaProv ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }
  
  private PreparedStatement getselectAll(Object aCondiciones) throws BaseException, SQLException {

	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("SELECT * FROM  ccTipoCtaProv ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    return querySelect;
  }
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tipo_cta_prov oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from ccTipoCtaProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getTipoCtaCteProv(
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(TipoCtaCteProv.NICKNAME,
             DBTipoCtaCteProv.SELECT_ALL,
             null,
             new ListObserver(),
             aSesion);
  }
  

}
