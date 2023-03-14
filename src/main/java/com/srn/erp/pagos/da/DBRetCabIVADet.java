package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.RetCabIVA;
import com.srn.erp.pagos.bm.RetCabIVADet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRetCabIVADet extends DBObjetoPersistente {

  public static final String OID_RET_DET_IVA = "oid_ret_det_iva";
  public static final String OID_RET_CAB_IVA = "oid_ret_cab_iva";
  public static final String MONTO_DESDE = "monto_desde";
  public static final String MONTO_HASTA = "monto_hasta";
  public static final String PORC = "porc";
  public static final String MONTO_FIJO = "monto_fijo";

  public final static int SELECT_BY_RET_IVA = 100;

  public DBRetCabIVADet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_DET_IVA = 1;
    final int OID_RET_CAB_IVA = 2;
    final int MONTO_DESDE = 3;
    final int MONTO_HASTA = 4;
    final int PORC = 5;
    final int MONTO_FIJO = 6;

    RetCabIVADet pers = (RetCabIVADet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRetCabIVADet "+
                     " ( "+
                      "OID_RET_DET_IVA,"+
                      "OID_RET_CAB_IVA,"+
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
    qInsert.setInt(OID_RET_DET_IVA,pers.getOID());
    qInsert.setInt(OID_RET_CAB_IVA,pers.getRetcabiva().getOID());
    qInsert.setDouble(MONTO_DESDE,pers.getMontodesde().doubleValue());
    qInsert.setDouble(MONTO_HASTA,pers.getMontohasta().doubleValue());
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    qInsert.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_CAB_IVA = 1;
    final int MONTO_DESDE = 2;
    final int MONTO_HASTA = 3;
    final int PORC = 4;
    final int MONTO_FIJO = 5;
    final int OID_RET_DET_IVA = 6;

    RetCabIVADet pers = (RetCabIVADet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRetCabIVADet set "+
              "oid_ret_cab_iva=?"+
              ",monto_desde=?"+
              ",monto_hasta=?"+
              ",porc=?"+
              ",monto_fijo=?"+
                 " where " +
                 " oid_ret_det_iva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_IVA,pers.getOID());
    qUpdate.setInt(OID_RET_CAB_IVA,pers.getRetcabiva().getOID());
    qUpdate.setDouble(MONTO_DESDE,pers.getMontodesde().doubleValue());
    qUpdate.setDouble(MONTO_HASTA,pers.getMontohasta().doubleValue());
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    qUpdate.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_DET_IVA = 1;
    RetCabIVADet pers = (RetCabIVADet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabIVADet "+
                     " set activo=0 " +
                     " where " +
                     " oid_ret_det_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_IVA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_DET_IVA = 1;
    RetCabIVADet pers = (RetCabIVADet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabIVADet "+
                     " set activo=1 " +
                     " where " +
                     " oid_ret_det_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_IVA, pers.getOID());
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
      case SELECT_BY_RET_IVA: {
        ps = this.selectByRetencionIVA(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_RET_DET_IVA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIVADet ");
    textSQL.append(" WHERE oid_ret_det_iva = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RET_DET_IVA, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIVADet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByRetencionIVA(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabIVADet ");
    textSQL.append(" WHERE oid_ret_cab_iva  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    RetCabIVA retCabIVA = (RetCabIVA) aCondiciones;
    querySelect.setInt(1, retCabIVA.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ret_det_iva oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRetCabIVADet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getRetIVADetByRetIVACab(RetCabIVA retIVACab,
                                             ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RetCabIVADet.NICKNAME,
                                          DBRetCabIVADet.SELECT_BY_RET_IVA,
                                          retIVACab,
                                          new ListObserver(),
                                          aSesion);
  }


}
