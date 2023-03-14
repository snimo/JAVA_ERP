package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.PorcLibRetIB;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBPorcLibRetIB extends DBObjetoPersistente {

  public static final String OID_LIB_RET_IB = "oid_lib_ret_ib";
  public static final String OID_SUJ_IMP = "oid_suj_imp";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String PORC = "porc";
  public static final String ACTIVO = "activo";
  public static final String DECRETO = "decreto";

  public static final int SELECT_BY_SUJETO_IMPOSITIVO = 100;

  public DBPorcLibRetIB() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_LIB_RET_IB = 1;
    final int OID_SUJ_IMP = 2;
    final int FEC_DESDE = 3;
    final int FEC_HASTA = 4;
    final int PORC = 5;
    final int ACTIVO = 6;
    final int DECRETO = 7;

    PorcLibRetIB pers = (PorcLibRetIB) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imPorcLibRetIB "+
                     " ( "+
                      "OID_LIB_RET_IB,"+
                      "OID_SUJ_IMP,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
                      "PORC,"+
                      "ACTIVO,"+
                      "DECRETO)"+
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
    qInsert.setInt(OID_LIB_RET_IB,pers.getOID());
    qInsert.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qInsert.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(DECRETO,pers.getDecreto());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUJ_IMP = 1;
    final int FEC_DESDE = 2;
    final int FEC_HASTA = 3;
    final int PORC = 4;
    final int ACTIVO = 5;
    final int DECRETO = 6;
    final int OID_LIB_RET_IB = 7;

    PorcLibRetIB pers = (PorcLibRetIB) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imPorcLibRetIB set "+
              "oid_suj_imp=?"+
              ",fec_desde=?"+
              ",fec_hasta=?"+
              ",porc=?"+
              ",activo=?"+
              ",decreto=?"+
                 " where " +
                 " oid_lib_ret_ib=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LIB_RET_IB,pers.getOID());
    qUpdate.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFechadesde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFechahasta().getTime()));
    qUpdate.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(DECRETO,pers.getDecreto());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_LIB_RET_IB = 1;
    PorcLibRetIB pers = (PorcLibRetIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imPorcLibRetIB "+
                     " set activo=0 " +
                     " where " +
                     " oid_lib_ret_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LIB_RET_IB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_LIB_RET_IB = 1;
    PorcLibRetIB pers = (PorcLibRetIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imPorcLibRetIB "+
                     " set activo=1 " +
                     " where " +
                     " oid_lib_ret_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_LIB_RET_IB, pers.getOID());
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
      case SELECT_BY_SUJETO_IMPOSITIVO: {
        ps = this.selectBySujetoImpositivo(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_LIB_RET_IB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imPorcLibRetIB ");
    textSQL.append(" WHERE oid_lib_ret_ib = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_LIB_RET_IB, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imPorcLibRetIB ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_lib_ret_ib oid, codigo,  descripcion ,activo ");
    textSQL.append(" from imPorcLibRetIB ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectBySujetoImpositivo(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imPorcLibRetIB ");
    textSQL.append(" WHERE  oid_suj_imp = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    SujetoImpositivo sujetoImpositivo = (SujetoImpositivo) aCondiciones;
    querySelect.setInt(1, sujetoImpositivo.getOID());
    return querySelect;
  }

  public static List getPorcentajesLibRetIB(SujetoImpositivo sujetoImpositivo,
                                            ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(PorcLibRetIB.NICKNAME,
                                          DBPorcLibRetIB.SELECT_BY_SUJETO_IMPOSITIVO,
                                          sujetoImpositivo,
                                          new ListObserver(),
                                          aSesion);
  }



}
