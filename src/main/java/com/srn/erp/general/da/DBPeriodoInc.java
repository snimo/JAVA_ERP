package com.srn.erp.general.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.PeriodoInc;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.MapDatos;

public class DBPeriodoInc extends DBObjetoPersistente {

  public static final String OID_PERI_INC_CAB = "oid_peri_inc_cab";
  public static final String OID_PERI = "oid_peri";
  public static final String TIPO = "tipo";
  public static final String CODIGO = "codigo";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_PERI_ANUAL_MENSUAL = 100;

  public DBPeriodoInc() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI_INC_CAB = 1;
    final int OID_PERI = 2;
    final int TIPO = 3;
    final int CODIGO = 4;
    final int ACTIVO = 5;

    PeriodoInc pers = (PeriodoInc) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into GePeriIncCab "+
                     " ( "+
                      "OID_PERI_INC_CAB,"+
                      "OID_PERI,"+
                      "TIPO,"+
                      "CODIGO,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_PERI_INC_CAB,pers.getOID());
    qInsert.setInt(OID_PERI,pers.getPeriodo().getOID());
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI = 1;
    final int TIPO = 2;
    final int CODIGO = 3;
    final int ACTIVO = 4;
    final int OID_PERI_INC_CAB = 5;

    PeriodoInc pers = (PeriodoInc) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update GePeriIncCab set "+
              "oid_peri=?"+
              ",tipo=?"+
              ",codigo=?"+
              ",activo=?"+
                 " where " +
                 " oid_peri_inc_cab=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_INC_CAB,pers.getOID());
    qUpdate.setInt(OID_PERI,pers.getPeriodo().getOID());
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_INC_CAB = 1;
    PeriodoInc pers = (PeriodoInc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update GePeriIncCab "+
                     " set activo=0 " +
                     " where " +
                     " oid_peri_inc_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_INC_CAB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_INC_CAB = 1;
    PeriodoInc pers = (PeriodoInc) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update GePeriIncCab "+
                     " set activo=1 " +
                     " where " +
                     " oid_peri_inc_cab=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_INC_CAB, pers.getOID());
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
      case SELECT_BY_PERI_ANUAL_MENSUAL: {
        ps = this.selectByPeriAnualMensual(aCondiciones);
        break;
      }


    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PERI_INC_CAB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  GePeriIncCab ");
    textSQL.append(" WHERE oid_peri_inc_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PERI_INC_CAB, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  GePeriIncCab ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByPeriAnualMensual(Object aCondiciones) throws BaseException, SQLException {
    MapDatos mapaDatos = (MapDatos) aCondiciones;
    final int CODIGO = 1;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  GePeriIncCab ");
    textSQL.append(" WHERE tipo = 'ANUAL_MENSUAL' and activo = 1 and codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) mapaDatos.getString("codigo");
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peri_inc_cab oid,codigo codigo,  codigo descripcion ,activo ");
    textSQL.append(" from GePeriIncCab");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
