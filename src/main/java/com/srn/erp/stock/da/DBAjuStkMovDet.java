package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.AjuStkMovDet;
import com.srn.erp.stock.bm.ComproAjusteStkDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAjuStkMovDet extends DBObjetoPersistente {

  public static final String OID_AJU_STK_MOV = "oid_aju_stk_mov";
  public static final String OID_AJU_STK_DET = "oid_aju_stk_det";
  public static final String OID_DEPOSITO = "oid_deposito";
  public static final String TIPO_MOVI = "tipo_mov";
  public static final String OID_ESTADO_STOCK = "oid_estado_stock";
  public static final String OID_UBI_DEPO = "oid_ubi_depo";
  public static final String AFECTA_STK_FISICO = "afecta_stk_fisico";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_AJU_STK_DET = 100;

  public DBAjuStkMovDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_MOV = 1;
    final int OID_AJU_STK_DET = 2;
    final int OID_DEPOSITO = 3;
    final int TIPO_MOVI = 4;
    final int OID_ESTADO_STOCK = 5;
    final int OID_UBI_DEPO = 6;
    final int AFECTA_STK_FISICO = 7;
    final int ACTIVO = 8;

    AjuStkMovDet pers = (AjuStkMovDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skAjuStkDetMov "+
                     " ( "+
                      "OID_AJU_STK_MOV,"+
                      "OID_AJU_STK_DET,"+
                      "OID_DEPOSITO,"+
                      "TIPO_MOV,"+
                      "OID_ESTADO_STOCK,"+
                      "OID_UBI_DEPO,"+
                      "AFECTA_STK_FISICO,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_AJU_STK_MOV,pers.getOID());
    qInsert.setInt(OID_AJU_STK_DET,pers.getDet_compro_aju_stk().getOID());
    qInsert.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qInsert.setString(TIPO_MOVI,pers.getTipo_movi());
    qInsert.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qInsert.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qInsert.setBoolean(AFECTA_STK_FISICO,pers.isAfecta_stk_fisico().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_DET = 1;
    final int OID_DEPOSITO = 2;
    final int TIPO_MOVI = 3;
    final int OID_ESTADO_STOCK = 4;
    final int OID_UBI_DEPO = 5;
    final int AFECTA_STK_FISICO = 6;
    final int ACTIVO = 7;
    final int OID_AJU_STK_MOV = 8;

    AjuStkMovDet pers = (AjuStkMovDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skAjuStkDetMov set "+
              "oid_aju_stk_det=?"+
              ",oid_deposito=?"+
              ",tipo_mov=?"+
              ",oid_estado_stock=?"+
              ",oid_ubi_depo=?"+
              ",afecta_stk_fisico=?"+
              ",activo=?"+
                 " where " +
                 " oid_aju_stk_mov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_MOV,pers.getOID());
    qUpdate.setInt(OID_AJU_STK_DET,pers.getDet_compro_aju_stk().getOID());
    qUpdate.setInt(OID_DEPOSITO,pers.getDeposito().getOID());
    qUpdate.setString(TIPO_MOVI,pers.getTipo_movi());
    qUpdate.setInt(OID_ESTADO_STOCK,pers.getEstado_stock().getOID());
    qUpdate.setInt(OID_UBI_DEPO,pers.getUbicacion_deposito().getOID());
    qUpdate.setBoolean(AFECTA_STK_FISICO,pers.isAfecta_stk_fisico().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_MOV = 1;
    AjuStkMovDet pers = (AjuStkMovDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjuStkDetMov "+
                     " set activo=0 " +
                     " where " +
                     " oid_aju_stk_mov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_MOV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_MOV = 1;
    AjuStkMovDet pers = (AjuStkMovDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjuStkDetMov "+
                     " set activo=1 " +
                     " where " +
                     " oid_aju_stk_mov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_MOV, pers.getOID());
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
      case SELECT_BY_AJU_STK_DET: {
        ps = this.selectByAjuStkDet(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_AJU_STK_MOV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkDetMov ");
    textSQL.append(" WHERE oid_aju_stk_mov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_AJU_STK_MOV, oid);
    return querySelect;
  }

  private PreparedStatement selectByAjuStkDet(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkDetMov ");
    textSQL.append(" WHERE oid_aju_stk_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ComproAjusteStkDet comproAjuStkDet = (ComproAjusteStkDet) aCondiciones;
    querySelect.setInt(1,comproAjuStkDet.getOID());
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkDetMov ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aju_stk_mov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skAjuStkDetMov");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getAjustesStkMovDet(ComproAjusteStkDet comproAjuStkDet,
                                         ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(AjuStkMovDet.NICKNAME,
                                          DBAjuStkMovDet.SELECT_BY_AJU_STK_DET,
                                          comproAjuStkDet,
                                          new ListObserver(),
                                          aSesion);
  }


}
