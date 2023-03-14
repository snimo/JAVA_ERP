package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.CondicionCompra;
import com.srn.erp.compras.bm.CondicionCompraDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCondicionCompraDet extends DBObjetoPersistente {

  public static final String OID_COND_CP_DET = "oid_cond_cp_det";
  public static final String OID_COND_COMPRA = "oid_cond_compra";
  public static final String UNIDAD_CUOTA_VENC = "unidad_cuota_venc";
  public static final String CANTIDAD = "cantidad";
  public static final String NRO_CUOTA = "nro_cuota";
  public static final String PORC = "porc";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_COND_COMPRA = 100;

  public DBCondicionCompraDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_CP_DET = 1;
    final int OID_COND_COMPRA = 2;
    final int UNIDAD_CUOTA_VENC = 3;
    final int CANTIDAD = 4;
    final int NRO_CUOTA = 5;
    final int PORC = 6;
    final int ACTIVO = 7;

    CondicionCompraDet pers = (CondicionCompraDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpCondCompraDet "+
                     " ( "+
                      "OID_COND_CP_DET,"+
                      "OID_COND_COMPRA,"+
                      "UNIDAD_CUOTA_VENC,"+
                      "CANTIDAD,"+
                      "NRO_CUOTA,"+
                      "PORC,"+
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
    qInsert.setInt(OID_COND_CP_DET,pers.getOID());
    qInsert.setInt(OID_COND_COMPRA,pers.getCondicioncompra().getOID());
    qInsert.setString(UNIDAD_CUOTA_VENC,pers.getUnidadvenc());
    qInsert.setInt(CANTIDAD,pers.getCantidad().intValue());
    qInsert.setInt(NRO_CUOTA,pers.getNrocuota().intValue());
    qInsert.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_COMPRA = 1;
    final int UNIDAD_CUOTA_VENC = 2;
    final int CANTIDAD = 3;
    final int NRO_CUOTA = 4;
    final int PORC = 5;
    final int ACTIVO = 6;
    final int OID_COND_CP_DET = 7;

    CondicionCompraDet pers = (CondicionCompraDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpCondCompraDet set "+
              "oid_cond_compra=?"+
              ",unidad_cuota_venc=?"+
              ",cantidad=?"+
              ",nro_cuota=?"+
              ",porc=?"+
              ",activo=?"+
                 " where " +
                 " oid_cond_cp_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_CP_DET,pers.getOID());
    qUpdate.setInt(OID_COND_COMPRA,pers.getCondicioncompra().getOID());
    qUpdate.setString(UNIDAD_CUOTA_VENC,pers.getUnidadvenc());
    qUpdate.setInt(CANTIDAD,pers.getCantidad().intValue());
    qUpdate.setInt(NRO_CUOTA,pers.getNrocuota().intValue());
    qUpdate.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_CP_DET = 1;
    CondicionCompraDet pers = (CondicionCompraDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpCondCompraDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_cond_cp_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_CP_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_CP_DET = 1;
    CondicionCompraDet pers = (CondicionCompraDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpCondCompraDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_cond_cp_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_CP_DET, pers.getOID());
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
      case SELECT_BY_COND_COMPRA: {
        ps = this.selectByCondCompra(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COND_CP_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpCondCompraDet ");
    textSQL.append(" WHERE oid_cond_cp_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COND_CP_DET, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpCondCompraDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByCondCompra(Object aCondiciones) throws BaseException, SQLException {

    CondicionCompra condicionCompra = (CondicionCompra) aCondiciones;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpCondCompraDet ");
    textSQL.append(" WHERE  oid_cond_compra = ? order by nro_cuota ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1, condicionCompra.getOID());
    return querySelect;

  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cond_cp_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpCondCompraDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getCondicionCompraDet(CondicionCompra condicionCompra,
                                           ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CondicionCompraDet.NICKNAME,
                                          DBCondicionCompraDet.SELECT_BY_COND_COMPRA,
                                          condicionCompra,
                                          new ListObserver(),
                                          aSesion);
  }


}
