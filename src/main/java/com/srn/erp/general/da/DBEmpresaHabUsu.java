package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Empresa;
import com.srn.erp.general.bm.EmpresaHabUsu;
import com.srn.erp.general.bm.Sucursal;

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

public class DBEmpresaHabUsu extends DBObjetoPersistente {

  public static final String OID_EMP_HAB_USU = "oid_emp_hab_usu";
  public static final String OID_USUARIO = "oid_usuario";
  public static final String OID_EMPRESA = "oid_empresa";
  public static final String OID_SUCURSAL = "oid_sucursal";
  public static final String USAR_POR_DEFECTO = "usar_por_defecto";


  public static final int SELECT_BY_USUARIO = 100;
  public static final int SELECT_BY_USU_EMP_SUC = 101;

  public DBEmpresaHabUsu() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_EMP_HAB_USU = 1;
    final int OID_USUARIO = 2;
    final int OID_EMPRESA = 3;
    final int OID_SUCURSAL = 4;
    final int USAR_POR_DEFECTO = 5;

    EmpresaHabUsu pers = (EmpresaHabUsu) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into seEmpHabUsu "+
                     " ( "+
                      "OID_EMP_HAB_USU,"+
                      "OID_USUARIO,"+
                      "OID_EMPRESA,"+
                      "OID_SUCURSAL,"+
                      "USAR_POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_EMP_HAB_USU,pers.getOID());
    qInsert.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qInsert.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qInsert.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    qInsert.setBoolean(USAR_POR_DEFECTO,pers.isUsarPorDefecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_USUARIO = 1;
    final int OID_EMPRESA = 2;
    final int OID_SUCURSAL = 3;
    final int USAR_POR_DEFECTO = 4;
    final int OID_EMP_HAB_USU = 5;

    EmpresaHabUsu pers = (EmpresaHabUsu) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update seEmpHabUsu set "+
              "oid_usuario=?"+
              ",oid_empresa=?"+
              ",oid_sucursal=?"+
              ",usar_por_defecto=?"+
                 " where " +
                 " oid_emp_hab_usu=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EMP_HAB_USU,pers.getOID());
    qUpdate.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qUpdate.setInt(OID_EMPRESA,pers.getEmpresa().getOID());
    qUpdate.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    qUpdate.setBoolean(USAR_POR_DEFECTO,pers.isUsarPorDefecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EMP_HAB_USU = 1;
    EmpresaHabUsu pers = (EmpresaHabUsu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from seEmpHabUsu "+
                     " where " +
                     " oid_emp_hab_usu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EMP_HAB_USU, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EMP_HAB_USU = 1;
    EmpresaHabUsu pers = (EmpresaHabUsu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update seEmpHabUsu "+
                     " set activo=1 " +
                     " where " +
                     " oid_emp_hab_usu=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EMP_HAB_USU, pers.getOID());
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
      case SELECT_BY_USUARIO: {
        ps = this.selectByUsuario(aCondiciones);
        break;
      }
      case IDBObjetoPersistente.SELECT_ALL_HELP: {
        ps = this.selectAllHelp(aCondiciones);
        break;
      }
      case SELECT_BY_USU_EMP_SUC: {
        ps = this.selectByEmpUsuSuc(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_EMP_HAB_USU = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seEmpHabUsu ");
    textSQL.append(" WHERE oid_emp_hab_usu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_EMP_HAB_USU, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
    final int CODIGO = 1;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seEmpHabUsu ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByUsuario(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seEmpHabUsu ");
    textSQL.append(" WHERE oid_usuario  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Usuario usuario = (Usuario) aCondiciones;
    querySelect.setInt(1, usuario.getOID());
    return querySelect;
  }

  private PreparedStatement selectByEmpUsuSuc(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  seEmpHabUsu ");
    textSQL.append(" WHERE oid_usuario  = ? and oid_empresa = ? and oid_sucursal = ? ");
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




  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_emp_hab_usu oid, codigo,  descripcion ,activo ");
    textSQL.append(" from seEmpHabUsu");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getEmpHabUsu(Usuario usuario,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(EmpresaHabUsu.NICKNAME,
                                          DBEmpresaHabUsu.SELECT_BY_USUARIO,
                                          usuario,
                                          new ListObserver(),
                                          aSesion);
  }

  public static EmpresaHabUsu getEmpresaHabUsu(Usuario usuario,
                                               Empresa empresa,
                                               Sucursal sucursal,
                                               ISesion aSesion)
                                                      throws BaseException {
    HashTableDatos condiciones = new HashTableDatos();
    condiciones.put(Empresa.NICKNAME,empresa);
    condiciones.put(Sucursal.NICKNAME,sucursal);
    condiciones.put(Usuario.NICKNAME,usuario);
    return (EmpresaHabUsu) ObjetoLogico.getObjects(EmpresaHabUsu.NICKNAME,
                                                DBEmpresaHabUsu.SELECT_BY_USU_EMP_SUC,
                                                condiciones,
                                                new ObjetoObservado(),
                                                aSesion);


  }



}
