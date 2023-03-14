package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.ContactoProveedor;
import com.srn.erp.compras.bm.Proveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBContactoProveedor extends DBObjetoPersistente {

  public static final String OID_CONTAC_PROV = "oid_contac_prov";
  public static final String APELLIDO = "apellido";
  public static final String NOMBRE = "nombre";
  public static final String TELEFONOS = "telefonos";
  public static final String FAX = "fax";
  public static final String DIRECCION = "direccion";
  public static final String LOCALIDAD = "localidad";
  public static final String CODIGO_POSTAL = "codigo_postal";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String OID_PAIS = "oid_pais";
  public static final String MAIL = "mail";
  public static final String ENVIO_OC = "envio_oc";
  public static final String ENVIO_PED_COTIZ = "envio_ped_cotiz";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String SECTOR = "sector";
  public static final String CARGO = "cargo";

  public static final int SELECT_BY_PROVEEDOR = 100;

  public DBContactoProveedor() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONTAC_PROV = 1;
    final int APELLIDO = 2;
    final int NOMBRE = 3;
    final int TELEFONOS = 4;
    final int FAX = 5;
    final int DIRECCION = 6;
    final int LOCALIDAD = 7;
    final int CODIGO_POSTAL = 8;
    final int OID_PROVINCIA = 9;
    final int OID_PAIS = 10;
    final int MAIL = 11;
    final int ENVIO_OC = 12;
    final int ENVIO_PED_COTIZ = 13;
    final int OID_PROVEEDOR = 14;
    final int SECTOR = 15;
    final int CARGO = 16;

    ContactoProveedor pers = (ContactoProveedor) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpContacProv "+
                     " ( "+
                      "OID_CONTAC_PROV,"+
                      "APELLIDO,"+
                      "NOMBRE,"+
                      "TELEFONOS,"+
                      "FAX,"+
                      "DIRECCION,"+
                      "LOCALIDAD,"+
                      "CODIGO_POSTAL,"+
                      "OID_PROVINCIA,"+
                      "OID_PAIS,"+
                      "MAIL,"+
                      "ENVIO_OC,"+
                      "ENVIO_PED_COTIZ,"+
                      "OID_PROVEEDOR,"+
                      "SECTOR,"+
                      "CARGO)"+
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
    qInsert.setInt(OID_CONTAC_PROV,pers.getOID());
    qInsert.setString(APELLIDO,pers.getApellido());
    qInsert.setString(NOMBRE,pers.getNombre());
    qInsert.setString(TELEFONOS,pers.getTelefonos());
    qInsert.setString(FAX,pers.getFax());
    qInsert.setString(DIRECCION,pers.getDireccion());
    qInsert.setString(LOCALIDAD,pers.getLocalidad());
    qInsert.setString(CODIGO_POSTAL,pers.getCodigopostal());
    if (pers.getProvincia()!=null)
      qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qInsert.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);
    if (pers.getPais()!=null)
      qInsert.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qInsert.setNull(OID_PAIS,java.sql.Types.INTEGER);
    qInsert.setString(MAIL,pers.getMail());
    qInsert.setBoolean(ENVIO_OC,pers.isEnviooc().booleanValue());
    qInsert.setBoolean(ENVIO_PED_COTIZ,pers.isEnviopedcotiz().booleanValue());
    if (pers.getProveedor()!=null)
      qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    else
      qInsert.setNull(OID_PROVEEDOR,java.sql.Types.INTEGER);
    qInsert.setString(SECTOR,pers.getSector());
    qInsert.setString(CARGO,pers.getCargo());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int APELLIDO = 1;
    final int NOMBRE = 2;
    final int TELEFONOS = 3;
    final int FAX = 4;
    final int DIRECCION = 5;
    final int LOCALIDAD = 6;
    final int CODIGO_POSTAL = 7;
    final int OID_PROVINCIA = 8;
    final int OID_PAIS = 9;
    final int MAIL = 10;
    final int ENVIO_OC = 11;
    final int ENVIO_PED_COTIZ = 12;
    final int OID_PROVEEDOR = 13;
    final int SECTOR = 14;
    final int CARGO = 15;
    final int OID_CONTAC_PROV = 16;

    ContactoProveedor pers = (ContactoProveedor) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpContacProv set "+
              "apellido=?"+
              ",nombre=?"+
              ",telefonos=?"+
              ",fax=?"+
              ",direccion=?"+
              ",localidad=?"+
              ",codigo_postal=?"+
              ",oid_provincia=?"+
              ",oid_pais=?"+
              ",mail=?"+
              ",envio_oc=?"+
              ",envio_ped_cotiz=?"+
              ",oid_proveedor=?"+
              ",sector=?"+
              ",cargo=?"+
                 " where " +
                 " oid_contac_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONTAC_PROV,pers.getOID());
    qUpdate.setString(APELLIDO,pers.getApellido());
    qUpdate.setString(NOMBRE,pers.getNombre());
    qUpdate.setString(TELEFONOS,pers.getTelefonos());
    qUpdate.setString(FAX,pers.getFax());
    qUpdate.setString(DIRECCION,pers.getDireccion());
    qUpdate.setString(LOCALIDAD,pers.getLocalidad());
    qUpdate.setString(CODIGO_POSTAL,pers.getCodigopostal());
    if (pers.getProvincia()!=null)
      qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    else
      qUpdate.setNull(OID_PROVINCIA,java.sql.Types.INTEGER);
    if (pers.getPais()!=null)
      qUpdate.setInt(OID_PAIS,pers.getPais().getOID());
    else
      qUpdate.setNull(OID_PAIS,java.sql.Types.INTEGER);
    qUpdate.setString(MAIL,pers.getMail());
    qUpdate.setBoolean(ENVIO_OC,pers.isEnviooc().booleanValue());
    qUpdate.setBoolean(ENVIO_PED_COTIZ,pers.isEnviopedcotiz().booleanValue());
    if (pers.getProveedor()!=null)
      qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    else
      qUpdate.setNull(OID_PROVEEDOR,java.sql.Types.INTEGER);
    qUpdate.setString(SECTOR,pers.getSector());
    qUpdate.setString(CARGO,pers.getCargo());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONTAC_PROV = 1;
    ContactoProveedor pers = (ContactoProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cpContacProv "+
                     " where " +
                     " oid_contac_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONTAC_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CONTAC_PROV = 1;
    ContactoProveedor pers = (ContactoProveedor) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpContacProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_contac_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CONTAC_PROV, pers.getOID());
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
      case SELECT_BY_PROVEEDOR: {
        ps = this.selectByProveedor(aCondiciones);
        break;
      }


    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CONTAC_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpContacProv ");
    textSQL.append(" WHERE oid_contac_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CONTAC_PROV, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpContacProv ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByProveedor(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpContacProv ");
    textSQL.append(" WHERE  oid_proveedor = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Proveedor proveedor = (Proveedor) aCondiciones;
    querySelect.setInt(1, proveedor.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_contac_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpContacProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getContactosByProveedor(Proveedor proveedor,
                                             ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ContactoProveedor.NICKNAME,
                                          SELECT_BY_PROVEEDOR,
                                          proveedor,
                                          new ListObserver(),
                                          aSesion);
  }



}
