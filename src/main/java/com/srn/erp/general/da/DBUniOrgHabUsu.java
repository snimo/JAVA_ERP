package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.general.bm.UniOrgHabUsu;
import com.srn.erp.general.bm.UnidadOrganizativa;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Seguridad.Usuario;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBUniOrgHabUsu extends DBObjetoPersistente {

  public static final String OID_UNI_ORG_HAB = "oid_uni_org_hab";
  public static final String OID_UNI_ORG = "oid_uni_org";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String OID_SUCURSAL = "oid_sucursal";
  public static final String OID_USUARIO = "oid_usuario";

  public static final int SELECT_BY_UO_EMP_SUC_USU = 100;
  public static final int SELECT_BY_UO_EMP_SUC     = 101;

  public DBUniOrgHabUsu() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_UNI_ORG_HAB = 1;
    final int OID_UNI_ORG = 2;
    final int OID_EMPRESA = 3;
    final int OID_SUCURSAL = 4;
    final int OID_USUARIO = 5;

    UniOrgHabUsu pers = (UniOrgHabUsu) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into seUniOrgHabUsu "+
                     " ( "+
                      "OID_UNI_ORG_HAB,"+
                      "OID_UNI_ORG,"+
                      "OID_EMPRESA,"+
                      "OID_SUCURSAL,"+
                      "OID_USUARIO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_UNI_ORG_HAB,pers.getOID());
    qInsert.setInt(OID_UNI_ORG,pers.getUnidad_organizacion().getOID());
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qInsert.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    qInsert.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_UNI_ORG = 1;
    final int OID_EMPRESA = 2;
    final int OID_SUCURSAL = 3;
    final int OID_USUARIO = 4;
    final int OID_UNI_ORG_HAB = 5;

    UniOrgHabUsu pers = (UniOrgHabUsu) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update seUniOrgHabUsu set "+
              "oid_uni_org=?"+
              ",oid_empresa=?"+
              ",oid_sucursal=?"+
              ",oid_usuario=?"+
                 " where " +
                 " oid_uni_org_hab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_ORG_HAB,pers.getOID());
    qUpdate.setInt(OID_UNI_ORG,pers.getUnidad_organizacion().getOID());
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qUpdate.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    qUpdate.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UNI_ORG_HAB = 1;
    UniOrgHabUsu pers = (UniOrgHabUsu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from seUniOrgHabUsu "+
                     " where " +
                     " oid_uni_org_hab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_ORG_HAB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_UNI_ORG_HAB = 1;
    UniOrgHabUsu pers = (UniOrgHabUsu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update seUniOrgHabUsu "+
                     " set activo=1 " +
                     " where " +
                     " oid_uni_org_hab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_UNI_ORG_HAB, pers.getOID());
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
      case SELECT_BY_UO_EMP_SUC_USU: {
        ps = this.selectByUniOrgEmpSucUsu(aCondiciones);
        break;
      }
      case SELECT_BY_UO_EMP_SUC: {
        ps = this.selectByUniOrgEmpSuc(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_UNI_ORG_HAB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seUniOrgHabUsu ");
    textSQL.append(" WHERE oid_uni_org_hab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_UNI_ORG_HAB, oid);
    return querySelect;
  }

  private PreparedStatement selectByUniOrgEmpSucUsu(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seUniOrgHabUsu ");
    textSQL.append(" WHERE  oid_uni_org = ? and oid_empresa = ? and oid_sucursal = ? and oid_usuario = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    UnidadOrganizativa uniOrg = (UnidadOrganizativa) condiciones.get(UnidadOrganizativa.NICKNAME);
    Empresa empresa = (Empresa) condiciones.get(Empresa.NICKNAME);
    Sucursal sucursal = (Sucursal) condiciones.get(Sucursal.NICKNAME);
    Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
    querySelect.setInt(1, uniOrg.getOID());
    querySelect.setInt(2, empresa.getOID());
    querySelect.setInt(3, sucursal.getOID());
    querySelect.setInt(4, usuario.getOID());

    return querySelect;
  }

  private PreparedStatement selectByUniOrgEmpSuc(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seUniOrgHabUsu ");
    textSQL.append(" WHERE  oid_usuario= ? and oid_empresa = ? and oid_sucursal = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    Usuario usuario = (Usuario) condiciones.get(Usuario.NICKNAME);
    Empresa empresa = (Empresa) condiciones.get(Empresa.NICKNAME);
    Sucursal sucursal = (Sucursal) condiciones.get(Sucursal.NICKNAME);
    querySelect.setInt(1, usuario.getOID());
    querySelect.setInt(2, empresa.getOID());
    querySelect.setInt(3, sucursal.getOID());
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seUniOrgHabUsu ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_uni_org_hab oid, codigo,  descripcion ,activo ");
    textSQL.append(" from seUniOrgHabUsu");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static UniOrgHabUsu getUniOrgHabUsu(UnidadOrganizativa unidadOrganitiva,
                                             Empresa empresa,
                                             Sucursal sucursal,
                                             Usuario usuario,
                                             ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(UnidadOrganizativa.NICKNAME,unidadOrganitiva);
    condiciones.put(Empresa.NICKNAME,empresa);
    condiciones.put(Sucursal.NICKNAME,sucursal);
    condiciones.put(Usuario.NICKNAME,usuario);

    return (UniOrgHabUsu) ObjetoLogico.getObjects(UniOrgHabUsu.NICKNAME,
                                             DBUniOrgHabUsu.SELECT_BY_UO_EMP_SUC_USU,
                                             condiciones,
                                             new ObjetoObservado(),
                                             aSesion);
  }

  public static List getUniOrgHabUsu(Empresa empresa,
                                             Sucursal sucursal,
                                             Usuario usuario,
                                             ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Usuario.NICKNAME,usuario);
    condiciones.put(Empresa.NICKNAME,empresa);
    condiciones.put(Sucursal.NICKNAME,sucursal);

    return (List) ObjetoLogico.getObjects(UniOrgHabUsu.NICKNAME,
                                             DBUniOrgHabUsu.SELECT_BY_UO_EMP_SUC,
                                             condiciones,
                                             new ListObserver(),
                                             aSesion);
  }



}
