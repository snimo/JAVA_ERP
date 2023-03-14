package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.contabilidad.bm.AnuladorAsientoCab;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorAsientoCab extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String OID_CCO_ANULADO = "oid_cco_anulado";
  public static final String FEC_IMPUTAC = "fec_imputac";
  public static final String FEC_REAL = "fec_real";
  public static final String OID_USU = "oid_usu";
  public static final String COMENTARIO = "comentario";

  public DBAnuladorAsientoCab() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_CCO_ANULADO = 2;
    final int FEC_IMPUTAC = 3;
    final int OID_USU = 4;
    final int COMENTARIO = 5;
    final int FEC_REAL = 6;


    AnuladorAsientoCab pers = (AnuladorAsientoCab) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproCabAnuAsi "+
                     " ( "+
                      "OID_CCO,"+
                      "OID_CCO_ANULADO,"+
                      "FEC_IMPUTAC,"+
                      "OID_USU,"+
                      "COMENTARIO,"+
                      "FEC_REAL)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CCO,pers.getOID());
    qInsert.setInt(OID_CCO_ANULADO,pers.getComprobanteAnulado().getOID());
    qInsert.setDate(FEC_IMPUTAC,new java.sql.Date(pers.getFecImputacion().getTime()));
    qInsert.setInt(OID_USU,pers.getUsuario().getOID());
    qInsert.setString(COMENTARIO,pers.getComentario());
    qInsert.setDate(FEC_REAL,new java.sql.Date(pers.getFecReal().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_ANULADO = 1;
    final int FEC_IMPUTAC = 2;
    final int OID_USU = 3;
    final int COMENTARIO = 4;
    final int FEC_REAL = 5;
    final int OID_CCO = 6;

    AnuladorAsientoCab pers = (AnuladorAsientoCab) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgComproCabAnuAsi set "+
              "oid_cco_anulado=?"+
              ",fec_imputac=?"+
              ",oid_usu=?"+
              ",comentario=?"+
              ",fec_real=?"+
                 " where " +
                 " oid_cco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO,pers.getOID());
    qUpdate.setInt(OID_CCO_ANULADO,pers.getComprobanteAnulado().getOID());
    qUpdate.setDate(FEC_IMPUTAC,new java.sql.Date(pers.getFecImputacion().getTime()));
    qUpdate.setInt(OID_USU,pers.getUsuario().getOID());
    qUpdate.setDate(FEC_REAL,new java.sql.Date(pers.getFecReal().getTime()));
    qUpdate.setString(COMENTARIO,pers.getComentario());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    AnuladorAsientoCab pers = (AnuladorAsientoCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproCabAnuAsi "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    AnuladorAsientoCab pers = (AnuladorAsientoCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproCabAnuAsi "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
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

    final int OID_CCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproCabAnuAsi ");
    textSQL.append(" WHERE oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cgComproCabAnuAsi ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgComproCabAnuAsi");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
