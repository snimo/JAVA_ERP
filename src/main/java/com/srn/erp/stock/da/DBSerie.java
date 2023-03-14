package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.stock.bm.Serie;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBSerie extends DBObjetoPersistente {

  public static final String OID_SERIE = "oid_serie";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String NRO = "nro";
  public static final String FEC_INICIO = "fec_inicio";
  public static final String FEC_VTO = "fec_vto";
  public static final String ACTIVO = "activo";

  public DBSerie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SERIE = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int NRO = 4;
    final int FEC_INICIO = 5;
    final int FEC_VTO = 6;
    final int ACTIVO = 7;

    Serie pers = (Serie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skSerie "+
                     " ( "+
                      "OID_SERIE,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "NRO,"+
                      "FEC_INICIO,"+
                      "FEC_VTO,"+
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
    qInsert.setInt(OID_SERIE,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setInt(NRO,pers.getNro().intValue());
    if (pers.getFec_inicio()!=null)
      qInsert.setDate(FEC_INICIO,new java.sql.Date(pers.getFec_inicio().getTime()));
    else
      qInsert.setNull(FEC_INICIO,java.sql.Types.DATE);
    if (pers.getFec_vto()!=null)
      qInsert.setDate(FEC_VTO,new java.sql.Date(pers.getFec_vto().getTime()));
    else
      qInsert.setNull(FEC_VTO,java.sql.Types.DATE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int NRO = 3;
    final int FEC_INICIO = 4;
    final int FEC_VTO = 5;
    final int ACTIVO = 6;
    final int OID_SERIE = 7;

    Serie pers = (Serie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skSerie set "+
              "codigo=?"+
              ",descripcion=?"+
              ",nro=?"+
              ",fec_inicio=?"+
              ",fec_vto=?"+
              ",activo=?"+
                 " where " +
                 " oid_serie=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SERIE,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setInt(NRO,pers.getNro().intValue());
    if (pers.getFec_inicio()!=null)
      qUpdate.setDate(FEC_INICIO,new java.sql.Date(pers.getFec_inicio().getTime()));
    else
      qUpdate.setNull(FEC_INICIO,java.sql.Types.DATE);
    if (pers.getFec_vto()!=null)
      qUpdate.setDate(FEC_VTO,new java.sql.Date(pers.getFec_vto().getTime()));
    else
      qUpdate.setNull(FEC_VTO,java.sql.Types.DATE);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SERIE = 1;
    Serie pers = (Serie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skSerie "+
                     " set activo=0 " +
                     " where " +
                     " oid_serie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SERIE, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_SERIE = 1;
    Serie pers = (Serie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skSerie "+
                     " set activo=1 " +
                     " where " +
                     " oid_serie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_SERIE, pers.getOID());
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

    final int OID_SERIE = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skSerie ");
    textSQL.append(" WHERE oid_serie = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_SERIE, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skSerie ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_serie oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from skSerie");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
