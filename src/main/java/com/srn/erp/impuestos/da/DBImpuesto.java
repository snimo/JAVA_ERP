package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.impuestos.bm.Impuesto;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBImpuesto extends DBObjetoPersistente {

  public static final String OID_IMPUESTO = "oid_impuesto";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String COMPO = "compo";
  public static final String ACTIVO = "activo";
  public static final String VENTAS = "ventas";
  public static final String COMPRAS = "compras";

  public DBImpuesto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_IMPUESTO = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int COMPO = 4;
    final int ACTIVO = 5;
    final int VENTAS = 6;
    final int COMPRAS = 7;

    Impuesto pers = (Impuesto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imImpuestos "+
                     " ( "+
                      "OID_IMPUESTO,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "COMPO,"+
                      "ACTIVO,VENTAS,COMPRAS)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_IMPUESTO,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(COMPO,pers.getCompo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setBoolean(VENTAS,pers.isVentas().booleanValue());
    qInsert.setBoolean(COMPRAS,pers.isCompras().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int COMPO = 3;
    final int ACTIVO = 4;
    final int VENTAS = 5;
    final int COMPRAS = 6;
    final int OID_IMPUESTO = 7;

    Impuesto pers = (Impuesto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imImpuestos set "+
              "codigo=?"+
              ",descripcion=?"+
              ",compo=?"+
              ",activo=?"+
              ",ventas=?"+
              ",compras=?"+
                 " where " +
                 " oid_impuesto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_IMPUESTO,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(COMPO,pers.getCompo());
    qUpdate.setBoolean(VENTAS,pers.isVentas().booleanValue());
    qUpdate.setBoolean(COMPRAS,pers.isCompras().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_IMPUESTO = 1;
    Impuesto pers = (Impuesto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imImpuestos "+
                     " set activo=0 " +
                     " where " +
                     " oid_impuesto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_IMPUESTO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_IMPUESTO = 1;
    Impuesto pers = (Impuesto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imImpuestos "+
                     " set activo=1 " +
                     " where " +
                     " oid_impuesto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_IMPUESTO, pers.getOID());
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

    final int OID_IMPUESTO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imImpuestos ");
    textSQL.append(" WHERE oid_impuesto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_IMPUESTO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imImpuestos ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_impuesto oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from imImpuestos");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }


}
