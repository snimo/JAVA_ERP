package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.ComproAjusteStk;
import com.srn.erp.stock.bm.ComproAjusteStkDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproAjusteStkDet extends DBObjetoPersistente {

  public static final String OID_AJU_STK_DET = "oid_aju_stk_det";
  public static final String OID_AJU_STK_CAB = "oid_aju_stk_cab";
  public static final String OID_PRODUCTO = "oid_producto";
  public static final String OID_TIPO_CONF_MOV = "oid_tipo_conf_mov";
  public static final String CANTIDAD = "cantidad";
  public static final String OID_UM_CARGA = "oid_um_carga";
  public static final String OID_CONF_MOV_STK = "oid_conf_mov_stk";
  public static final String OID_COMPO_STK_AJU = "oid_compo_stk_aju";
  public static final String OBSERVACIONES = "observaciones";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_COMPRO_AJU_STK_CAB = 100;

  public DBComproAjusteStkDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_DET = 1;
    final int OID_AJU_STK_CAB = 2;
    final int OID_PRODUCTO = 3;
    final int OID_TIPO_CONF_MOV = 4;
    final int CANTIDAD = 5;
    final int OID_UM_CARGA = 6;
    final int OID_CONF_MOV_STK = 7;
    final int OID_COMPO_STK_AJU = 8;
    final int OBSERVACIONES = 9;
    final int ACTIVO = 10;

    ComproAjusteStkDet pers = (ComproAjusteStkDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skAjusteStkDet "+
                     " ( "+
                      "OID_AJU_STK_DET,"+
                      "OID_AJU_STK_CAB,"+
                      "OID_PRODUCTO,"+
                      "OID_TIPO_CONF_MOV,"+
                      "CANTIDAD,"+
                      "OID_UM_CARGA,"+
                      "OID_CONF_MOV_STK,"+
                      "OID_COMPO_STK_AJU,"+
                      "OBSERVACIONES,"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_AJU_STK_DET,pers.getOID());
    qInsert.setInt(OID_AJU_STK_CAB,pers.getAjuste_stock_cab().getOID());
    qInsert.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    if (pers.getTipo_conf_mov()!=null)
      qInsert.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    else
      qInsert.setNull(OID_TIPO_CONF_MOV,java.sql.Types.INTEGER);
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setInt(OID_UM_CARGA,pers.getUm_carga().getOID());
    if (pers.getConf_mov_stk()!=null)
      qInsert.setInt(OID_CONF_MOV_STK,pers.getConf_mov_stk().getOID());
    else
      qInsert.setNull(OID_CONF_MOV_STK,java.sql.Types.INTEGER);
    if (pers.getCompo_stk_aju()!=null)
      qInsert.setInt(OID_COMPO_STK_AJU,pers.getCompo_stk_aju().getOID());
    else
      qInsert.setNull(OID_COMPO_STK_AJU,java.sql.Types.INTEGER);
    qInsert.setString(OBSERVACIONES,pers.getObservaciones());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_CAB = 1;
    final int OID_PRODUCTO = 2;
    final int OID_TIPO_CONF_MOV = 3;
    final int CANTIDAD = 4;
    final int OID_UM_CARGA = 5;
    final int OID_CONF_MOV_STK = 6;
    final int OID_COMPO_STK_AJU = 7;
    final int OBSERVACIONES = 8;
    final int ACTIVO = 9;
    final int OID_AJU_STK_DET = 10;

    ComproAjusteStkDet pers = (ComproAjusteStkDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skAjusteStkDet set "+
              "oid_aju_stk_cab=?"+
              ",oid_producto=?"+
              ",oid_tipo_conf_mov=?"+
              ",cantidad=?"+
              ",oid_um_carga=?"+
              ",oid_conf_mov_stk=?"+
              ",oid_compo_stk_aju=?"+
              ",observaciones=?"+
              ",activo=?"+
                 " where " +
                 " oid_aju_stk_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_DET,pers.getOID());
    qUpdate.setInt(OID_AJU_STK_CAB,pers.getAjuste_stock_cab().getOID());
    qUpdate.setInt(OID_PRODUCTO,pers.getProducto().getOID());
    qUpdate.setInt(OID_TIPO_CONF_MOV,pers.getTipo_conf_mov().getOID());
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setInt(OID_UM_CARGA,pers.getUm_carga().getOID());
    qUpdate.setInt(OID_CONF_MOV_STK,pers.getConf_mov_stk().getOID());
    qUpdate.setInt(OID_COMPO_STK_AJU,pers.getCompo_stk_aju().getOID());
    qUpdate.setString(OBSERVACIONES,pers.getObservaciones());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_DET = 1;
    ComproAjusteStkDet pers = (ComproAjusteStkDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjusteStkDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_aju_stk_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_DET = 1;
    ComproAjusteStkDet pers = (ComproAjusteStkDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjusteStkDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_aju_stk_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_DET, pers.getOID());
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
      case SELECT_BY_COMPRO_AJU_STK_CAB : {
        ps = this.selectByComproAjuStkCab(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_AJU_STK_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjusteStkDet ");
    textSQL.append(" WHERE oid_aju_stk_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_AJU_STK_DET, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjusteStkDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByComproAjuStkCab(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjusteStkDet ");
    textSQL.append(" WHERE  oid_aju_stk_cab = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ComproAjusteStk comproAjusteStk = (ComproAjusteStk) aCondiciones;
    querySelect.setInt(1,comproAjusteStk.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aju_stk_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skAjusteStkDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getDetallesComproAjuStk(ComproAjusteStk comproAjuStk,
                                             ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ComproAjusteStkDet.NICKNAME,
                                          DBComproAjusteStkDet.SELECT_BY_COMPRO_AJU_STK_CAB,
                                          comproAjuStk,
                                          new ListObserver(),
                                          aSesion);
  }


}
