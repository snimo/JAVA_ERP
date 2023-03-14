package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.pagos.bm.PeriRetIVA;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBPeriRetIVA extends DBObjetoPersistente {

  public static final String OID_PERI_RET_IVA = "oid_peri_ret_iva";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String DESCRIPCION = "descripcion";
  public static final String CODIGO_INTERNO = "codigo_interno";
  public static final String ACTIVO = "activo";

  public DBPeriRetIVA() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI_RET_IVA = 1;
    final int FEC_DESDE = 2;
    final int FEC_HASTA = 3;
    final int DESCRIPCION = 4;
    final int CODIGO_INTERNO = 5;
    final int ACTIVO = 6;

    PeriRetIVA pers = (PeriRetIVA) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opPeriRetIVA "+
                     " ( "+
                      "OID_PERI_RET_IVA,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "DESCRIPCION,"+
                      "CODIGO_INTERNO,"+
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
    qInsert.setInt(OID_PERI_RET_IVA,pers.getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date (pers.getFecdesde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date (pers.getFechasta().getTime()));
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setString(CODIGO_INTERNO,pers.getCodinterno());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int FEC_DESDE = 1;
    final int FEC_HASTA = 2;
    final int DESCRIPCION = 3;
    final int CODIGO_INTERNO = 4;
    final int ACTIVO = 5;
    final int OID_PERI_RET_IVA = 6;

    PeriRetIVA pers = (PeriRetIVA) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opPeriRetIVA set "+
              "fec_desde=?"+
              ",fec_hasta=?"+
              ",descripcion=?"+
              ",codigo_interno=?"+
              ",activo=?"+
                 " where " +
                 " oid_peri_ret_iva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_RET_IVA,pers.getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFecdesde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFechasta().getTime()));
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(CODIGO_INTERNO,pers.getCodinterno());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_RET_IVA = 1;
    PeriRetIVA pers = (PeriRetIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opPeriRetIVA "+
                     " set activo=0 " +
                     " where " +
                     " oid_peri_ret_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_RET_IVA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_RET_IVA = 1;
    PeriRetIVA pers = (PeriRetIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opPeriRetIVA "+
                     " set activo=1 " +
                     " where " +
                     " oid_peri_ret_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_RET_IVA, pers.getOID());
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

    final int OID_PERI_RET_IVA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opPeriRetIVA ");
    textSQL.append(" WHERE oid_peri_ret_iva = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PERI_RET_IVA, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opPeriRetIVA ");
    textSQL.append(" WHERE  codigo_interno = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peri_ret_iva oid, codigo_interno codigo,  descripcion ,activo ");
    textSQL.append(" from opPeriRetIVA");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
