package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ventas.bm.RemitoDet;
import com.srn.erp.ventas.bm.RemitoDetPartidaSerie;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRemitoDetPartidaSerie extends DBObjetoPersistente {

  public static final String OID_RTO_DET_P_S = "oid_rto_det_p_s";
  public static final String OID_REMITO_DET = "oid_remito_det";
  public static final String OID_PARTIDA = "oid_partida";
  public static final String OID_SERIE = "oid_serie";
  public static final String CANTIDAD = "cantidad";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_REMITO_DET = 100;

  public DBRemitoDetPartidaSerie() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_RTO_DET_P_S = 1;
    final int OID_REMITO_DET = 2;
    final int OID_PARTIDA = 3;
    final int OID_SERIE = 4;
    final int CANTIDAD = 5;
    final int ACTIVO = 6;

    RemitoDetPartidaSerie pers = (RemitoDetPartidaSerie) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veRtoDetPartSerie "+
                     " ( "+
                      "OID_RTO_DET_P_S,"+
                      "OID_REMITO_DET,"+
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
    qInsert.setInt(OID_RTO_DET_P_S,pers.getOID());
    qInsert.setInt(OID_REMITO_DET,pers.getRemito_detalle().getOID());
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

    final int OID_REMITO_DET = 1;
    final int OID_PARTIDA = 2;
    final int OID_SERIE = 3;
    final int CANTIDAD = 4;
    final int ACTIVO = 5;
    final int OID_RTO_DET_P_S = 6;

    RemitoDetPartidaSerie pers = (RemitoDetPartidaSerie) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veRtoDetPartSerie set "+
              "oid_remito_det=?"+
              ",oid_partida=?"+
              ",oid_serie=?"+
              ",cantidad=?"+
              ",activo=?"+
                 " where " +
                 " oid_rto_det_p_s=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_DET_P_S,pers.getOID());
    qUpdate.setInt(OID_REMITO_DET,pers.getRemito_detalle().getOID());
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
    final int OID_RTO_DET_P_S = 1;
    RemitoDetPartidaSerie pers = (RemitoDetPartidaSerie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from veRtoDetPartSerie "+
                     " where " +
                     " oid_rto_det_p_s=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_DET_P_S, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_RTO_DET_P_S = 1;
    RemitoDetPartidaSerie pers = (RemitoDetPartidaSerie) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veRtoDetPartSerie "+
                     " set activo=1 " +
                     " where " +
                     " oid_rto_det_p_s=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_RTO_DET_P_S, pers.getOID());
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
      case SELECT_BY_REMITO_DET: {
        ps = this.selectByRemitoDet(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_RTO_DET_P_S = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoDetPartSerie ");
    textSQL.append(" WHERE oid_rto_det_p_s = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_RTO_DET_P_S, oid);
    return querySelect;
  }

  private PreparedStatement selectByRemitoDet(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoDetPartSerie ");
    textSQL.append(" WHERE  oid_remito_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    RemitoDet remitoDet = (RemitoDet) aCondiciones;
    querySelect.setInt(1, remitoDet.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veRtoDetPartSerie ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_rto_det_p_s oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veRtoDetPartSerie");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getRemitoDetPartidasSeries(RemitoDet remitoDet,
                                                ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(RemitoDetPartidaSerie.NICKNAME,
                                          DBRemitoDetPartidaSerie.SELECT_BY_REMITO_DET,
                                          remitoDet,
                                          new ListObserver(),
                                          aSesion);
  }


}
