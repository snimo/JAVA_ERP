package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.PeriodoStockReal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPeriodoStockReal extends DBObjetoPersistente {

  public static final String OID_PERI = "oid_peri";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String FECHA_DESDE = "fecha_desde";
  public static final String FECHA_HASTA = "fecha_hasta";
  public static final String TIPO = "tipo";
  public static final String ACTIVO = "activo";

  public final static int SELECT_BY_FECHA = 100;

  public DBPeriodoStockReal() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int FECHA_DESDE = 4;
    final int FECHA_HASTA = 5;
    final int TIPO = 6;
    final int ACTIVO = 7;

    PeriodoStockReal pers = (PeriodoStockReal) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into gePeriodos "+
                     " ( "+
                      "OID_PERI,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "FECHA_DESDE,"+
                      "FECHA_HASTA,"+
                      "TIPO,"+
                      "ACTIVO)"+
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
    qInsert.setInt(OID_PERI,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setDate(FECHA_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qInsert.setDate(FECHA_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int FECHA_DESDE = 3;
    final int FECHA_HASTA = 4;
    final int TIPO = 5;
    final int ACTIVO = 6;
    final int OID_PERI = 7;

    PeriodoStockReal pers = (PeriodoStockReal) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update gePeriodos set "+
              "codigo=?"+
              ",descripcion=?"+
              ",fecha_desde=?"+
              ",fecha_hasta=?"+
              ",tipo=?"+
              ",activo=?"+
                 " where " +
                 " oid_peri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setDate(FECHA_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qUpdate.setDate(FECHA_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI = 1;
    PeriodoStockReal pers = (PeriodoStockReal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update gePeriodos "+
                     " set activo=0 " +
                     " where " +
                     " oid_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI = 1;
    PeriodoStockReal pers = (PeriodoStockReal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update gePeriodos "+
                     " set activo=1 " +
                     " where " +
                     " oid_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI, pers.getOID());
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
      case SELECT_BY_FECHA : {
        ps = this.selectByFecha(aCondiciones);
        break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PERI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriodos ");
    textSQL.append(" WHERE oid_peri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PERI, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriodos ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peri oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from gePeriodos");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByFecha(Object aCondiciones) throws BaseException, SQLException {

    java.util.Date fecha = (java.util.Date) aCondiciones;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  gePeriodos ");
    textSQL.append(" WHERE  fecha_Desde<=? and fecha_hasta>=? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setDate(1,new java.sql.Date(fecha.getTime()));
    querySelect.setDate(2,new java.sql.Date(fecha.getTime()));
    return querySelect;

  }

  public static PeriodoStockReal getPeriodoStockReal(java.util.Date fecha,
                                                     ISesion aSesion)
                                                      throws BaseException {
    return (PeriodoStockReal) ObjetoLogico.getObjects(PeriodoStockReal.NICKNAME,
                                             DBPeriodoStockReal.SELECT_BY_FECHA,
                                             fecha,
                                             new ObjetoObservado(),
                                             aSesion);
  }



}
