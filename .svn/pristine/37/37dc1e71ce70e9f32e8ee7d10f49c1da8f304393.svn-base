package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBUnidadOrganizativa extends DBObjetoPersistente {

  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String OID_TIPO_UNI_ORG = "oid_tipo_uni_org";
  public static final String ACTIVO = "activo";
  public static final String OID_SUCURSAL = "oid_sucursal";

  public static final int SELECT_BY_SUCURSAL = 100;
  public static final int SELECT_BY_SIST_BANCO = 101;

  public DBUnidadOrganizativa() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_UNI_ORG = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int OID_TIPO_UNI_ORG = 4;
    final int ACTIVO = 5;
    final int OID_SUCURSAL = 6;


    UnidadOrganizativa pers = (UnidadOrganizativa) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geUnidadOrg "+
                     " ( "+
                      "OID_UNI_ORG,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "OID_TIPO_UNI_ORG,"+
                      "ACTIVO,"+
                      "OID_SUCURSAL)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_UNI_ORG,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(OID_TIPO_UNI_ORG,pers.getTipounidadorganizativa().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int OID_TIPO_UNI_ORG = 3;
    final int ACTIVO = 4;
    final int OID_SUCURSAL = 5;
    final int OID_UNI_ORG = 6;

    UnidadOrganizativa pers = (UnidadOrganizativa) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geUnidadOrg set "+
              "codigo=?"+
              ",descripcion=?"+
              ",oid_tipo_uni_org=?"+
              ",activo=?"+
              ",oid_sucursal=?"+
                 " where " +
                 " oid_uni_org=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_ORG,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(OID_TIPO_UNI_ORG,pers.getTipounidadorganizativa().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UNI_ORG = 1;
    UnidadOrganizativa pers = (UnidadOrganizativa) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geUnidadOrg "+
                     " set activo=0 " +
                     " where " +
                     " oid_uni_org=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_ORG, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UNI_ORG = 1;
    UnidadOrganizativa pers = (UnidadOrganizativa) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geUnidadOrg "+
                     " set activo=1 " +
                     " where " +
                     " oid_uni_org=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_ORG, pers.getOID());
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
      case SELECT_BY_SUCURSAL: {
        ps = this.selectBySucursal(aCondiciones);
        break;
      }
      case SELECT_BY_SIST_BANCO: {
        ps = this.selectBySistemaBanco(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_UNI_ORG = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geUnidadOrg ");
    textSQL.append(" WHERE oid_uni_org = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_UNI_ORG, oid);
    return querySelect;
  }
  
  private PreparedStatement selectBySistemaBanco(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geUnidadOrg ");
    textSQL.append(" WHERE oid_uni_org in (select oid_uni_org from vaCtasHabBancos where activo=1) ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
    
  }
  
  
  

  private PreparedStatement selectBySucursal(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geUnidadOrg ");
    textSQL.append(" WHERE oid_sucursal = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Sucursal sucursal = (Sucursal) aCondiciones;
    querySelect.setInt(1, sucursal.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geUnidadOrg ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_uni_org oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from geUnidadOrg");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getUnidadesOrganizativas(Sucursal sucursal,
                                              ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(UnidadOrganizativa.NICKNAME,
                                          DBUnidadOrganizativa.SELECT_BY_SUCURSAL,
                                          sucursal,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getUnidadesOrganizativasSistBancos(ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(UnidadOrganizativa.NICKNAME,
  			DBUnidadOrganizativa.SELECT_BY_SIST_BANCO,
  			null,
  			new ListObserver(),
  			aSesion);
  }
  


}
