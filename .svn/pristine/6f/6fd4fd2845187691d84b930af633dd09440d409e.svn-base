package com.srn.erp.compras.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.compras.bm.CondicionVenta;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBCondicionVenta extends DBObjetoPersistente {

  public static final String OID_COND_VENTA = "oid_cond_vta";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String VTO_FIJO = "vto_fijo";
  public static final String PORC_DTO = "porc_dto";
  public static final String PORC_RECAR = "porc_recar";
  public static final String ACTIVO = "activo";

  public DBCondicionVenta() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COND_VTA = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int VTO_FIJO = 4;
    final int PORC_DTO = 5;
    final int PORC_RECAR = 6;
    final int ACTIVO = 7;

    CondicionVenta pers = (CondicionVenta) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veCondVenta "+
                     " ( "+
                      "OID_COND_VTA,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "VTO_FIJO,"+
                      "PORC_DTO,"+
                      "PORC_RECAR,"+
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
    qInsert.setInt(OID_COND_VTA,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(VTO_FIJO,pers.isVtofijo().booleanValue());
    if (pers.getPorcDto()!=null)
      qInsert.setDouble(PORC_DTO,pers.getPorcDto().doubleValue());
    else
      qInsert.setNull(PORC_DTO,java.sql.Types.DOUBLE);
    if (pers.getPorcRecar()!=null)
      qInsert.setDouble(PORC_RECAR,pers.getPorcRecar().doubleValue());
    else
      qInsert.setNull(PORC_RECAR,java.sql.Types.DOUBLE);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int VTO_FIJO = 3;
    final int ACTIVO = 4;
    final int PORC_DTO = 5;
    final int PORC_RECAR = 6;
    final int OID_COND_VTA = 7;

    CondicionVenta pers = (CondicionVenta) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veCondVenta set "+
              "codigo=?"+
              ",descripcion=?"+
              ",vto_fijo=?"+
              ",activo=?"+
              ",porc_dto=?"+
              ",porc_recar=?"+
                 " where " +
                 " oid_cond_vta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_VTA,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(VTO_FIJO,pers.isVtofijo().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getPorcDto()!=null)
      qUpdate.setDouble(PORC_DTO,pers.getPorcDto().doubleValue());
    else
      qUpdate.setNull(PORC_DTO,java.sql.Types.DOUBLE);
    if (pers.getPorcRecar()!=null)
      qUpdate.setDouble(PORC_RECAR,pers.getPorcRecar().doubleValue());
    else
      qUpdate.setNull(PORC_RECAR,java.sql.Types.DOUBLE);

    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_VTA = 1;
    CondicionVenta pers = (CondicionVenta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCondVenta "+
                     " set activo=0 " +
                     " where " +
                     " oid_cond_vta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_VTA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COND_VTA = 1;
    CondicionVenta pers = (CondicionVenta) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veCondVenta "+
                     " set activo=1 " +
                     " where " +
                     " oid_cond_vta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COND_VTA, pers.getOID());
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
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COND_VTA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondVenta ");
    textSQL.append(" WHERE oid_cond_vta = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COND_VTA, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veCondVenta ");
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cond_vta oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from veCondVenta");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

}
