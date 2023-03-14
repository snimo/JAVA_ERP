package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.pagos.bm.DtoComproEnOP;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBDtoComproEnOP extends DBObjetoPersistente {

  public static final String OID_DTO_CPRO_PROV = "oid_dto_cpro_prov";
  public static final String OID_CCO_PROV = "oid_cco_prov";
  public static final String DTO_MON_ORI = "dto_mon_ori";
  public static final String DTO_MON_LOC = "dto_mon_loc";
  public static final String FECHA = "fecha";
  public static final String OID_CCO_OP = "oid_cco_op";
  public static final String ACTIVO = "activo";

  public DBDtoComproEnOP() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_DTO_CPRO_PROV = 1;
    final int OID_CCO_PROV = 2;
    final int DTO_MON_ORI = 3;
    final int DTO_MON_LOC = 4;
    final int FECHA = 5;
    final int OID_CCO_OP = 6;
    final int ACTIVO = 7;

    DtoComproEnOP pers = (DtoComproEnOP) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpDtosComproProv "+
                     " ( "+
                      "OID_DTO_CPRO_PROV,"+
                      "OID_CCO_PROV,"+
                      "DTO_MON_ORI,"+
                      "DTO_MON_LOC,"+
                      "FECHA,"+
                      "OID_CCO_OP,"+
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
    qInsert.setInt(OID_DTO_CPRO_PROV,pers.getOID());
    qInsert.setInt(OID_CCO_PROV,pers.getComproprov().getOID());
    qInsert.setDouble(DTO_MON_ORI,pers.getDtomonori().doubleValue());
    qInsert.setDouble(DTO_MON_LOC,pers.getDtomonloc().doubleValue());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setInt(OID_CCO_OP,pers.getComproop().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_PROV = 1;
    final int DTO_MON_ORI = 2;
    final int DTO_MON_LOC = 3;
    final int FECHA = 4;
    final int OID_CCO_OP = 5;
    final int ACTIVO = 6;
    final int OID_DTO_CPRO_PROV = 7;

    DtoComproEnOP pers = (DtoComproEnOP) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpDtosComproProv set "+
              "oid_cco_prov=?"+
              ",dto_mon_ori=?"+
              ",dto_mon_loc=?"+
              ",fecha=?"+
              ",oid_cco_op=?"+
              ",activo=?"+
                 " where " +
                 " oid_dto_cpro_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DTO_CPRO_PROV,pers.getOID());
    qUpdate.setInt(OID_CCO_PROV,pers.getComproprov().getOID());
    qUpdate.setDouble(DTO_MON_ORI,pers.getDtomonori().doubleValue());
    qUpdate.setDouble(DTO_MON_LOC,pers.getDtomonloc().doubleValue());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setInt(OID_CCO_OP,pers.getComproop().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DTO_CPRO_PROV = 1;
    DtoComproEnOP pers = (DtoComproEnOP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpDtosComproProv "+
                     " set activo=0 " +
                     " where " +
                     " oid_dto_cpro_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DTO_CPRO_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_DTO_CPRO_PROV = 1;
    DtoComproEnOP pers = (DtoComproEnOP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpDtosComproProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_dto_cpro_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_DTO_CPRO_PROV, pers.getOID());
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

    final int OID_DTO_CPRO_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpDtosComproProv ");
    textSQL.append(" WHERE oid_dto_cpro_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_DTO_CPRO_PROV, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpDtosComproProv ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_dto_cpro_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpDtosComproProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
