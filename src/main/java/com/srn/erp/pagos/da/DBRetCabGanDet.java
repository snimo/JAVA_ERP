package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.pagos.bm.RetCabGan;
import com.srn.erp.pagos.bm.RetCabGanDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.applicarionServer.bm.Varios.Money;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBRetCabGanDet extends DBObjetoPersistente {

  public static final String OID_RET_DET_GAN = "oid_ret_det_gan";
  public static final String OID_RET_CAB_GAN = "oid_ret_cab_gan";
  public static final String MONTO_DESDE = "monto_desde";
  public static final String MONTO_HASTA = "monto_hasta";
  public static final String PORC = "porc";
  public static final String MONTO_FIJO = "monto_fijo";

  public static final int SELECT_BY_RET_IVA = 100;
  public static final int SELECT_BY_MONTO_DESDE_HASTA = 101;

  public DBRetCabGanDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_DET_GAN = 1;
    final int OID_RET_CAB_GAN = 2;
    final int MONTO_DESDE = 3;
    final int MONTO_HASTA = 4;
    final int PORC = 5;
    final int MONTO_FIJO = 6;

    RetCabGanDet pers = (RetCabGanDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRetCabGanDet "+
                     " ( "+
                      "OID_RET_DET_GAN,"+
                      "OID_RET_CAB_GAN,"+
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
    qInsert.setInt(OID_RET_DET_GAN,pers.getOID());
    qInsert.setInt(OID_RET_CAB_GAN,pers.getRetcabgan().getOID());
    qInsert.setDouble(MONTO_DESDE,pers.getMontodesde().doubleValue());
    qInsert.setDouble(MONTO_HASTA,pers.getMontohasta().doubleValue());
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    qInsert.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RET_CAB_GAN = 1;
    final int MONTO_DESDE = 2;
    final int MONTO_HASTA = 3;
    final int PORC = 4;
    final int MONTO_FIJO = 5;
    final int OID_RET_DET_GAN = 6;

    RetCabGanDet pers = (RetCabGanDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRetCabGanDet set "+
              "oid_ret_cab_gan=?"+
              ",monto_desde=?"+
              ",monto_hasta=?"+
              ",porc=?"+
              ",monto_fijo=?"+
                 " where " +
                 " oid_ret_det_gan=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_GAN,pers.getOID());
    qUpdate.setInt(OID_RET_CAB_GAN,pers.getRetcabgan().getOID());
    qUpdate.setDouble(MONTO_DESDE,pers.getMontodesde().doubleValue());
    qUpdate.setDouble(MONTO_HASTA,pers.getMontohasta().doubleValue());
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    qUpdate.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_DET_GAN = 1;
    RetCabGanDet pers = (RetCabGanDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabGanDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_ret_det_gan=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_GAN, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RET_DET_GAN = 1;
    RetCabGanDet pers = (RetCabGanDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetCabGanDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_ret_det_gan=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RET_DET_GAN, pers.getOID());
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
        ps = this.selectByRetIVA(aCondiciones);
        break;
      }
      case SELECT_BY_MONTO_DESDE_HASTA: {
        ps = this.selectByMontoDesdeHasta(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_RET_DET_GAN = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabGanDet ");
    textSQL.append(" WHERE oid_ret_det_gan = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RET_DET_GAN, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabGanDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByRetIVA(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabGanDet ");
    textSQL.append(" WHERE oid_ret_cab_gan = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    RetCabGan retCabGan = (RetCabGan) aCondiciones;
    querySelect.setInt(1, retCabGan.getOID());
    return querySelect;
  }

  private PreparedStatement selectByMontoDesdeHasta(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetCabGanDet ");
    textSQL.append(" WHERE monto_desde <= ? and monto_hasta >= ? and oid_ret_cab_gan = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Hashtable condiciones = (Hashtable) aCondiciones;
    RetCabGan retCabGan = (RetCabGan) condiciones.get(RetCabGan.NICKNAME);
    Money monto = (Money) condiciones.get("monto");
    querySelect.setDouble(1,monto.doubleValue());
    querySelect.setDouble(2,monto.doubleValue());
    querySelect.setInt(3,retCabGan.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_ret_det_gan oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRetCabGanDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getRetGanDetByRetGanCab(RetCabGan retGanCab,
                                             ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RetCabGanDet.NICKNAME,
                                          DBRetCabGanDet.SELECT_BY_RET_IVA,
                                          retGanCab,
                                          new ListObserver(),
                                          aSesion);
  }

  public static RetCabGanDet getRetGanDetByRetGanCabyMonto(RetCabGan retGanCab,
                                                   Money monto,
                                                   ISesion aSesion) throws BaseException {
    Hashtable condiciones = new Hashtable();
    condiciones.put(RetCabGan.NICKNAME,retGanCab);
    condiciones.put("monto",monto);

    return (RetCabGanDet) ObjetoLogico.getObjects(RetCabGanDet.NICKNAME,
                                          DBRetCabGanDet.SELECT_BY_MONTO_DESDE_HASTA,
                                          condiciones,
                                          new ObjetoObservado(),
                                          aSesion);
  }



}
