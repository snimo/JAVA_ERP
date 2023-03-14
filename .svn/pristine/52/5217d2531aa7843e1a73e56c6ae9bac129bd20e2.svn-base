package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.CondPagoCheque;
import com.srn.erp.ventas.bm.CondicionPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCondPagoCheque extends DBObjetoPersistente {

  public static final String OID_CP_CHEQUE = "oid_cp_cheque";
  public static final String OID_COND_PAGO = "oid_cond_pago";
  public static final String DIA_DESDE = "dia_desde";
  public static final String DIA_HASTA = "dia_hasta";
  public static final String PORC_DTO = "porc_dto";
  public static final String PORC_RECAR = "porc_reca";

  public static final int SELECT_BY_COND_PAGO_CHEQUE = 100;

  public DBCondPagoCheque() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CP_CHEQUE = 1;
    final int OID_COND_PAGO = 2;
    final int DIA_DESDE = 3;
    final int DIA_HASTA = 4;
    final int PORC_DTO = 5;
    final int PORC_RECAR = 6;

    CondPagoCheque pers = (CondPagoCheque) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCondPagoCheque "+
                     " ( "+
                      "OID_CP_CHEQUE,"+
                      "OID_COND_PAGO,"+
                      "DIA_DESDE,"+
                      "DIA_HASTA,"+
                      "PORC_DTO,"+
                      "PORC_RECA)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CP_CHEQUE,pers.getOID());
    qInsert.setInt(OID_COND_PAGO,pers.getCondicion_pago().getOID());
    qInsert.setInt(DIA_DESDE,pers.getDia_desde().intValue());
    qInsert.setInt(DIA_HASTA,pers.getDia_hasta().intValue());
    qInsert.setDouble(PORC_DTO,pers.getPorc_dto().doubleValue());
    qInsert.setDouble(PORC_RECAR,pers.getPorc_recar().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_PAGO = 1;
    final int DIA_DESDE = 2;
    final int DIA_HASTA = 3;
    final int PORC_DTO = 4;
    final int PORC_RECAR = 5;
    final int OID_CP_CHEQUE = 6;

    CondPagoCheque pers = (CondPagoCheque) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCondPagoCheque set "+
              "oid_cond_pago=?"+
              ",dia_desde=?"+
              ",dia_hasta=?"+
              ",porc_dto=?"+
              ",porc_reca=?"+
                 " where " +
                 " oid_cp_cheque=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CP_CHEQUE,pers.getOID());
    qUpdate.setInt(OID_COND_PAGO,pers.getCondicion_pago().getOID());
    qUpdate.setInt(DIA_DESDE,pers.getDia_desde().intValue());
    qUpdate.setInt(DIA_HASTA,pers.getDia_hasta().intValue());
    qUpdate.setDouble(PORC_DTO,pers.getPorc_dto().doubleValue());
    qUpdate.setDouble(PORC_RECAR,pers.getPorc_recar().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CP_CHEQUE = 1;
    CondPagoCheque pers = (CondPagoCheque) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veCondPagoCheque "+
                     " where " +
                     " oid_cp_cheque=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CP_CHEQUE, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CP_CHEQUE = 1;
    CondPagoCheque pers = (CondPagoCheque) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCondPagoCheque "+
                     " set activo=1 " +
                     " where " +
                     " oid_cp_cheque=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CP_CHEQUE, pers.getOID());
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
      case SELECT_BY_COND_PAGO_CHEQUE: {
        ps = this.selectByCondPagoCheque(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CP_CHEQUE = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoCheque ");
    textSQL.append(" WHERE oid_cp_cheque = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CP_CHEQUE, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoCheque ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCondPagoCheque(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondPagoCheque ");
    textSQL.append(" WHERE oid_cond_pago = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    CondicionPago condPago = (CondicionPago) aCondiciones;
    querySelect.setInt(1, condPago.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cp_cheque oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veCondPagoCheque");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getChequesCondPago(CondicionPago condPago,
                                        ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CondPagoCheque.NICKNAME,
                                          DBCondPagoCheque.SELECT_BY_COND_PAGO_CHEQUE,
                                          condPago,
                                          new ListObserver(),
                                          aSesion);
  }


}
