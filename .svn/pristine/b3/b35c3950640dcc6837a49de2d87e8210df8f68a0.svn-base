package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.pagos.bm.PeriRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPeriRetGan extends DBObjetoPersistente {

  public static final String OID_PERI_RET_GAN = "oid_peri_ret_gan";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String DESCRIPCION = "descripcion";
  public static final String CODIGO_INTERNO = "codigo_interno";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_FECHA = 100;

  public DBPeriRetGan() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PERI_RET_GAN = 1;
    final int FEC_DESDE = 2;
    final int FEC_HASTA = 3;
    final int DESCRIPCION = 4;
    final int CODIGO_INTERNO = 5;
    final int ACTIVO = 6;

    PeriRetGan pers = (PeriRetGan) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opPeriRetGan "+
                     " ( "+
                      "OID_PERI_RET_GAN,"+
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
    qInsert.setInt(OID_PERI_RET_GAN,pers.getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFecdesde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFechasta().getTime()));
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
    final int OID_PERI_RET_GAN = 6;

    PeriRetGan pers = (PeriRetGan) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opPeriRetGan set "+
              "fec_desde=?"+
              ",fec_hasta=?"+
              ",descripcion=?"+
              ",codigo_interno=?"+
              ",activo=?"+
                 " where " +
                 " oid_peri_ret_gan=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_RET_GAN,pers.getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFecdesde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFechasta().getTime()));
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setString(CODIGO_INTERNO,pers.getCodinterno());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_RET_GAN = 1;
    PeriRetGan pers = (PeriRetGan) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opPeriRetGan "+
                     " set activo=0 " +
                     " where " +
                     " oid_peri_ret_gan=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_RET_GAN, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PERI_RET_GAN = 1;
    PeriRetGan pers = (PeriRetGan) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opPeriRetGan "+
                     " set activo=1 " +
                     " where " +
                     " oid_peri_ret_gan=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PERI_RET_GAN, pers.getOID());
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
      case SELECT_BY_FECHA: {
        ps = this.selectByFecha(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PERI_RET_GAN = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opPeriRetGan ");
    textSQL.append(" WHERE oid_peri_ret_gan = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PERI_RET_GAN, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
    final int CODIGO = 1;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opPeriRetGan ");
    textSQL.append(" WHERE  codigo_interno = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_peri_ret_gan oid, codigo_interno codigo,  descripcion ,activo ");
    textSQL.append(" from opPeriRetGan");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByFecha(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opPeriRetGan ");
    textSQL.append(" WHERE  fec_desde <= ? and fec_hasta>=? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    java.util.Date fecha = (java.util.Date) aCondiciones;
    querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
    return querySelect;

  }

  public static PeriRetGan getPeriRetGan(java.util.Date fecha,
                                        ISesion aSesion) throws BaseException {
    return (PeriRetGan) ObjetoLogico.getObjects(PeriRetGan.NICKNAME,
                                          DBPeriRetGan.SELECT_BY_FECHA,
                                          fecha,
                                          new ObjetoObservado(),
                                          aSesion);
  }





}
