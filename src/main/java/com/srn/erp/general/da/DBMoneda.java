package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.Moneda;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBMoneda extends DBObjetoPersistente {

  public static final String OID_MONEDA = "oid_moneda";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String BASE = "base";
  public static final String ACTIVO = "activo";
  public static final String SIMBOLO = "simbolo";
  

  public DBMoneda() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_MONEDA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int BASE = 4;
    final int ACTIVO = 5;
    final int SIMBOLO = 6;

    Moneda pers = (Moneda) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into geMonedas "+
                     " ( "+
                      "OID_MONEDA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "BASE,"+
                      "ACTIVO," +
                      "SIMBOLO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_MONEDA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setDouble(BASE,pers.getBase().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(SIMBOLO, pers.getSimbolo());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int BASE = 3;
    final int ACTIVO = 4;
    final int SIMBOLO = 5;
    final int OID_MONEDA = 6;

    Moneda pers = (Moneda) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update geMonedas set "+
              "codigo=?"+
              ",descripcion=?"+
              ",base=?"+
              ",activo=?"+
              ",simbolo=?"+
                 " where " +
                 " oid_moneda=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MONEDA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setDouble(BASE,pers.getBase().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(SIMBOLO,pers.getSimbolo());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MONEDA = 1;
    Moneda pers = (Moneda) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geMonedas "+
                     " set activo=0 " +
                     " where " +
                     " oid_moneda=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MONEDA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_MONEDA = 1;
    Moneda pers = (Moneda) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geMonedas "+
                     " set activo=1 " +
                     " where " +
                     " oid_moneda=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_MONEDA, pers.getOID());
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
        ps = this.selectAll(aCondiciones);
        break;
      }
      case SELECT_ALL_ACTIVOS: {
        ps = this.selectAllActivos(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_MONEDA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geMonedas ");
    textSQL.append(" WHERE oid_moneda = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_MONEDA, oid);
    return querySelect;
  }

  private PreparedStatement selectAllActivos(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geMonedas where activo = 1");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  		
  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geMonedas ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  		

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  geMonedas ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_moneda oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from geMonedas");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getAllActivos(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Moneda.NICKNAME,
                                          SELECT_ALL_ACTIVOS,
                                          null,
                                          new ListObserver(),
                                          aSesion);
  }
  
  public static List getAll(ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(Moneda.NICKNAME,
                                          SELECT_ALL,
                                          null,
                                          new ListObserver(),
                                          aSesion);
  }
  


}
