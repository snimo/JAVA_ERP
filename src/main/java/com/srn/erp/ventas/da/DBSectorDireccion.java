package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ventas.bm.SectorDireccion;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBSectorDireccion extends DBObjetoPersistente {

  public static final String OID_SECTOR_DIR = "oid_sector_dir";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String ACTIVO = "activo";

  public DBSectorDireccion() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SECTOR_DIR = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int ACTIVO = 4;

    SectorDireccion pers = (SectorDireccion) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veSectorDireccion "+
                     " ( "+
                      "OID_SECTOR_DIR,"+
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
    qInsert.setInt(OID_SECTOR_DIR,pers.getOID());
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
    final int OID_SECTOR_DIR = 4;

    SectorDireccion pers = (SectorDireccion) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veSectorDireccion set "+
              "codigo=?"+
              ",descripcion=?"+
              ",activo=?"+
                 " where " +
                 " oid_sector_dir=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SECTOR_DIR,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SECTOR_DIR = 1;
    SectorDireccion pers = (SectorDireccion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veSectorDireccion "+
                     " set activo=0 " +
                     " where " +
                     " oid_sector_dir=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SECTOR_DIR, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SECTOR_DIR = 1;
    SectorDireccion pers = (SectorDireccion) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veSectorDireccion "+
                     " set activo=1 " +
                     " where " +
                     " oid_sector_dir=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SECTOR_DIR, pers.getOID());
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

    final int OID_SECTOR_DIR = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSectorDireccion ");
    textSQL.append(" WHERE oid_sector_dir = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SECTOR_DIR, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veSectorDireccion ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_sector_dir oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from veSectorDireccion");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}