package com.srn.erp.stock.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.stock.bm.AjuStkMovDet;
import com.srn.erp.stock.bm.AjuStkPartSerie;
import com.srn.erp.stock.bm.ComproAjusteStkDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBAjuStkPartSerie extends DBObjetoPersistente {

  public static final String OID_AJU_STK_P_S = "oid_aju_stk_p_s";
  public static final String OID_AJU_STK_DET = "oid_aju_stk_det";
  public static final String OID_PARTIDA = "oid_partida";
  public static final String OID_SERIE = "oid_serie";
  public static final String CANTIDAD = "cantidad";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_AJU_STK_DET = 100;

  public DBAjuStkPartSerie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_P_S = 1;
    final int OID_AJU_STK_DET = 2;
    final int OID_PARTIDA = 3;
    final int OID_SERIE = 4;
    final int CANTIDAD = 5;
    final int ACTIVO = 6;

    AjuStkPartSerie pers = (AjuStkPartSerie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into skAjuStkPartSerie "+
                     " ( "+
                      "OID_AJU_STK_P_S,"+
                      "OID_AJU_STK_DET,"+
                      "OID_PARTIDA,"+
                      "OID_SERIE,"+
                      "CANTIDAD,"+
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
    qInsert.setInt(OID_AJU_STK_P_S,pers.getOID());
    qInsert.setInt(OID_AJU_STK_DET,pers.getAju_stk_det().getOID());
    if (pers.getPartida()!=null)
      qInsert.setInt(OID_PARTIDA,pers.getPartida().getOID());
    else
      qInsert.setNull(OID_PARTIDA,java.sql.Types.INTEGER);
    if (pers.getSerie()!=null)
      qInsert.setInt(OID_SERIE,pers.getSerie().getOID());
    else
      qInsert.setNull(OID_SERIE,java.sql.Types.INTEGER);
    qInsert.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AJU_STK_DET = 1;
    final int OID_PARTIDA = 2;
    final int OID_SERIE = 3;
    final int CANTIDAD = 4;
    final int ACTIVO = 5;
    final int OID_AJU_STK_P_S = 6;

    AjuStkPartSerie pers = (AjuStkPartSerie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update skAjuStkPartSerie set "+
              "oid_aju_stk_det=?"+
              ",oid_partida=?"+
              ",oid_serie=?"+
              ",cantidad=?"+
              ",activo=?"+
                 " where " +
                 " oid_aju_stk_p_s=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_P_S,pers.getOID());
    qUpdate.setInt(OID_AJU_STK_DET,pers.getAju_stk_det().getOID());
    if (pers.getPartida()!=null)
      qUpdate.setInt(OID_PARTIDA,pers.getPartida().getOID());
    else
      qUpdate.setNull(OID_PARTIDA,java.sql.Types.INTEGER);
    if (pers.getSerie()!=null)
      qUpdate.setInt(OID_SERIE,pers.getSerie().getOID());
    else
      qUpdate.setNull(OID_SERIE,java.sql.Types.INTEGER);
    qUpdate.setDouble(CANTIDAD,pers.getCantidad().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_P_S = 1;
    AjuStkPartSerie pers = (AjuStkPartSerie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjuStkPartSerie "+
                     " set activo=0 " +
                     " where " +
                     " oid_aju_stk_p_s=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_P_S, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AJU_STK_P_S = 1;
    AjuStkPartSerie pers = (AjuStkPartSerie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update skAjuStkPartSerie "+
                     " set activo=1 " +
                     " where " +
                     " oid_aju_stk_p_s=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AJU_STK_P_S, pers.getOID());
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

    final int OID_AJU_STK_P_S = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkPartSerie ");
    textSQL.append(" WHERE oid_aju_stk_p_s = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_AJU_STK_P_S, oid);
    return querySelect;
  }

  private PreparedStatement selectByAjuStkDet(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkPartSerie ");
    textSQL.append(" WHERE oid_aju_stk_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ComproAjusteStkDet comproAjuStkDet = (ComproAjusteStkDet) aCondiciones;
    querySelect.setInt(1, comproAjuStkDet.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  skAjuStkPartSerie ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aju_stk_p_s oid, codigo,  descripcion ,activo ");
    textSQL.append(" from skAjuStkPartSerie");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getAjustesStkPartSerie(AjuStkMovDet ajuStkMovDet,
                                            ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(AjuStkMovDet.NICKNAME,
                                          DBAjuStkMovDet.SELECT_BY_AJU_STK_DET,
                                          ajuStkMovDet,
                                          new ListObserver(),
                                          aSesion);
  }


}
