package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.compras.bm.CondCompraProv;
import com.srn.erp.compras.bm.Proveedor;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCondCompraProv extends DBObjetoPersistente {

  public static final String OID_COND_CP_PROV = "oid_cond_cp_prov";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String OID_COND_COMPRA = "oid_cond_compra";
  public static final String DESCUENTO = "descuento";
  public static final String RECARGO = "recargo";
  public static final String POR_DEFECTO = "por_defecto";

  public static final int SELECT_BY_PROVEEDOR = 100;

  public DBCondCompraProv() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_CP_PROV = 1;
    final int OID_PROVEEDOR = 2;
    final int OID_COND_COMPRA = 3;
    final int DESCUENTO = 4;
    final int RECARGO = 5;
    final int POR_DEFECTO = 6;

    CondCompraProv pers = (CondCompraProv) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpCondCompraProv "+
                     " ( "+
                      "OID_COND_CP_PROV,"+
                      "OID_PROVEEDOR,"+
                      "OID_COND_COMPRA,"+
                      "DESCUENTO,"+
                      "RECARGO,"+
                      "POR_DEFECTO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COND_CP_PROV,pers.getOID());
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qInsert.setInt(OID_COND_COMPRA,pers.getCondcompra().getOID());
    qInsert.setDouble(DESCUENTO,pers.getDescuento().doubleValue());
    qInsert.setDouble(RECARGO,pers.getRecargo().doubleValue());
    qInsert.setBoolean(POR_DEFECTO,pers.isPorDefecto().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PROVEEDOR = 1;
    final int OID_COND_COMPRA = 2;
    final int DESCUENTO = 3;
    final int RECARGO = 4;
    final int POR_DEFECTO = 5;
    final int OID_COND_CP_PROV = 6;


    CondCompraProv pers = (CondCompraProv) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpCondCompraProv set "+
              "oid_proveedor=?"+
              ",oid_cond_compra=?"+
              ",descuento=?"+
              ",recargo=?"+
              ",por_defecto=?"+
                 " where " +
                 " oid_cond_cp_prov=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_CP_PROV,pers.getOID());
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qUpdate.setInt(OID_COND_COMPRA,pers.getCondcompra().getOID());
    qUpdate.setDouble(DESCUENTO,pers.getDescuento().doubleValue());
    qUpdate.setDouble(RECARGO,pers.getRecargo().doubleValue());
    qUpdate.setBoolean(POR_DEFECTO,pers.isPorDefecto().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_CP_PROV = 1;
    CondCompraProv pers = (CondCompraProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("delete from cpCondCompraProv "+
                     " where " +
                     " oid_cond_cp_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_CP_PROV, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_CP_PROV = 1;
    CondCompraProv pers = (CondCompraProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpCondCompraProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_cond_cp_prov=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_CP_PROV, pers.getOID());
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
      case SELECT_BY_PROVEEDOR: {
        ps = this.selectByProveedor(aCondiciones);
        break;
      }

    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COND_CP_PROV = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpCondCompraProv ");
    textSQL.append(" WHERE oid_cond_cp_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COND_CP_PROV, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpCondCompraProv ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByProveedor(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpCondCompraProv ");
    textSQL.append(" WHERE oid_proveedor = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Proveedor proveedor = (Proveedor) aCondiciones;
    querySelect.setInt(1, proveedor.getOID());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cond_cp_prov oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpCondCompraProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getCondCompraByProveedor(Proveedor proveedor,
                                              ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CondCompraProv.NICKNAME,
                                          SELECT_BY_PROVEEDOR,
                                          proveedor,
                                          new ListObserver(),
                                          aSesion);
  }


}
