package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.Ejercicio;
import com.srn.erp.contabilidad.bm.EjercicioPeri;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBEjercicioPeri extends DBObjetoPersistente {

  public static final String OID_EJER_PERI = "oid_ejer_peri";
  public static final String OID_EJERCICIO = "oid_ejercicio";
  public static final String SECU = "secu";
  public static final String OID_PERI = "oid_peri";
  public static final String CERRADO = "cerrado";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_EJERCICIO = 100;

  public DBEjercicioPeri() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_EJER_PERI = 1;
    final int OID_EJERCICIO = 2;
    final int SECU = 3;
    final int OID_PERI = 4;
    final int CERRADO = 5;
    final int ACTIVO = 6;

    EjercicioPeri pers = (EjercicioPeri) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgEjercicioPeri "+
                     " ( "+
                      "OID_EJER_PERI,"+
                      "OID_EJERCICIO,"+
                      "SECU,"+
                      "OID_PERI,"+
                      "CERRADO,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_EJER_PERI,pers.getOID());
    qInsert.setInt(OID_EJERCICIO,pers.getEjercicio().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    qInsert.setBoolean(CERRADO,pers.isCerrado().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_EJERCICIO = 1;
    final int SECU = 2;
    final int OID_PERI = 3;
    final int CERRADO = 4;
    final int ACTIVO = 5;
    final int OID_EJER_PERI = 6;

    EjercicioPeri pers = (EjercicioPeri) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgEjercicioPeri set "+
              "oid_ejercicio=?"+
              ",secu=?"+
              ",oid_peri=?"+
              ",cerrado=?"+
              ",activo=?"+
                 " where " +
                 " oid_ejer_peri=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EJER_PERI,pers.getOID());
    qUpdate.setInt(OID_EJERCICIO,pers.getEjercicio().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    qUpdate.setBoolean(CERRADO,pers.isCerrado().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EJER_PERI = 1;
    EjercicioPeri pers = (EjercicioPeri) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgEjercicioPeri "+
                     " set activo=0 " +
                     " where " +
                     " oid_ejer_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EJER_PERI, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_EJER_PERI = 1;
    EjercicioPeri pers = (EjercicioPeri) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgEjercicioPeri "+
                     " set activo=1 " +
                     " where " +
                     " oid_ejer_peri=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_EJER_PERI, pers.getOID());
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
      case DBEjercicioPeri.SELECT_BY_EJERCICIO: {
        ps = this.selectByEjercicio(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_EJER_PERI = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgEjercicioPeri ");
    textSQL.append(" WHERE oid_ejer_peri = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_EJER_PERI, oid);
    return querySelect;
  }

  private PreparedStatement selectByEjercicio(Object aCondiciones) throws BaseException, SQLException {
    final int OID_EJERCICIO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgEjercicioPeri ");
    textSQL.append(" WHERE oid_ejercicio = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Ejercicio ejercicio = ( (Ejercicio) aCondiciones);
    querySelect.setInt(OID_EJERCICIO, ejercicio.getOID());
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgEjercicioPeri ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ejer_peri oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgEjercicioPeri");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getPeriodosEjercicios(Ejercicio ejercicio,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(EjercicioPeri.NICKNAME,
                                          DBEjercicioPeri.SELECT_BY_EJERCICIO,
                                          ejercicio,
                                          new ListObserver(),
                                          aSesion);
  }


}
