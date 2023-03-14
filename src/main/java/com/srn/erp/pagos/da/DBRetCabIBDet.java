package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.RetCabIB;
import com.srn.erp.pagos.bm.RetCabIBDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRetCabIBDet extends DBObjetoPersistente {

  public static final String OID_RET_DET_IB = "oid_ret_det_ib";
  public static final String OID_RET_CAB_IB = "oid_ret_cab_ib";
  public static final String MONTO_DESDE = "monto_desde";
  public static final String MONTO_HASTA = "monto_hasta";
  public static final String PORC = "porc";
  public static final String MONTO_FIJO = "monto_fijo";

  public static final int SELECT_BY_RET_IB = 100;

  public DBRetCabIBDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_DET_IB = 1;
    final int OID_RET_CAB_IB = 2;
    final int MONTO_DESDE = 3;
    final int MONTO_HASTA = 4;
    final int PORC = 5;
    final int MONTO_FIJO = 6;

    RetCabIBDet pers = (RetCabIBDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRetCabIBDet "+
                     " ( "+
                      "OID_RET_DET_IB,"+
                      "OID_RET_CAB_IB,"+
                      "MONTO_DESDE,"+
                      "MONTO_HASTA,"+
                      "PORC,"+
                      "MONTO_FIJO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_RET_DET_IB,pers.getOID());
    qInsert.setInt(OID_RET_CAB_IB,pers.getRetcabib().getOID());
    qInsert.setDouble(MONTO_DESDE,pers.getMontodesde().doubleValue());
    qInsert.setDouble(MONTO_HASTA,pers.getMontohasta().doubleValue());
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    qInsert.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_CAB_IB = 1;
    final int MONTO_DESDE = 2;
    final int MONTO_HASTA = 3;
    final int PORC = 4;
    final int MONTO_FIJO = 5;
    final int OID_RET_DET_IB = 6;

    RetCabIBDet pers = (RetCabIBDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRetCabIBDet set "+
              "oid_ret_cab_ib=?"+
              ",monto_desde=?"+
              ",monto_hasta=?"+
              ",porc=?"+
              ",monto_fijo=?"+
                 " where " +
                 " oid_ret_det_ib=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_IB,pers.getOID());
    qUpdate.setInt(OID_RET_CAB_IB,pers.getRetcabib().getOID());
    qUpdate.setDouble(MONTO_DESDE,pers.getMontodesde().doubleValue());
    qUpdate.setDouble(MONTO_HASTA,pers.getMontohasta().doubleValue());
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    qUpdate.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_DET_IB = 1;
    RetCabIBDet pers = (RetCabIBDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabIBDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_ret_det_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_IB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_DET_IB = 1;
    RetCabIBDet pers = (RetCabIBDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabIBDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_ret_det_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_IB, pers.getOID());
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
      case SELECT_BY_RET_IB: {
        ps = this.selectByRetCabID(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_RET_DET_IB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIBDet ");
    textSQL.append(" WHERE oid_ret_det_ib = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RET_DET_IB, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIBDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByRetCabID(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIBDet ");
    textSQL.append(" WHERE  oid_ret_cab_ib = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    RetCabIB retCabIB = (RetCabIB) aCondiciones;
    querySelect.setInt(1, retCabIB.getOID());
    return querySelect;
  }



  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ret_det_ib oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRetCabIBDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getRetIBDetByRetIBCab(RetCabIB retIBCab,
                                             ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RetCabIBDet.NICKNAME,
                                          DBRetCabIBDet.SELECT_BY_RET_IB,
                                          retIBCab,
                                          new ListObserver(),
                                          aSesion);
  }


}
