package com.srn.erp.ventas.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.Sucursal;
import com.srn.erp.ventas.bm.FechaFacturacionSucursal;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBFechaFacturacionSucursal extends DBObjetoPersistente {

  public static final String OID_FEC_FACT_SUC = "oid_fec_fact_suc";
  public static final String OID_SUCURSAL = "oid_sucursal";
  public static final String FEC_ANT = "fec_ant";
  public static final String NUE_FEC = "nue_fec";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_SUCURSAL = 100;

  public DBFechaFacturacionSucursal() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_FEC_FACT_SUC = 1;
    final int OID_SUCURSAL = 2;
    final int FEC_ANT = 3;
    final int NUE_FEC = 4;
    final int ACTIVO = 5;

    FechaFacturacionSucursal pers = (FechaFacturacionSucursal) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veFecFactSuc "+
                     " ( "+
                      "OID_FEC_FACT_SUC,"+
                      "OID_SUCURSAL,"+
                      "FEC_ANT,"+
                      "NUE_FEC,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_FEC_FACT_SUC,pers.getOID());
    qInsert.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    if (pers.getFecha_anterior()!=null)
      qInsert.setDate(FEC_ANT,new java.sql.Date(pers.getFecha_anterior().getTime()));
    else
      qInsert.setNull(FEC_ANT,java.sql.Types.DATE);
    qInsert.setDate(NUE_FEC,new java.sql.Date(pers.getFecha_actual().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUCURSAL = 1;
    final int FEC_ANT = 2;
    final int NUE_FEC = 3;
    final int ACTIVO = 4;
    final int OID_FEC_FACT_SUC = 5;

    FechaFacturacionSucursal pers = (FechaFacturacionSucursal) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veFecFactSuc set "+
              "oid_sucursal=?"+
              ",fec_ant=?"+
              ",nue_fec=?"+
              ",activo=?"+
                 " where " +
                 " oid_fec_fact_suc=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FEC_FACT_SUC,pers.getOID());
    qUpdate.setInt(OID_SUCURSAL,pers.getSucursal().getOID());
    if (pers.getFecha_anterior()!=null)
      qUpdate.setDate(FEC_ANT,new java.sql.Date(pers.getFecha_anterior().getTime()));
    else
      qUpdate.setNull(FEC_ANT,java.sql.Types.DATE);
    qUpdate.setDate(NUE_FEC,new java.sql.Date(pers.getFecha_actual().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_FEC_FACT_SUC = 1;
    FechaFacturacionSucursal pers = (FechaFacturacionSucursal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veFecFactSuc "+
                     " set activo=0 " +
                     " where " +
                     " oid_fec_fact_suc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FEC_FACT_SUC, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_FEC_FACT_SUC = 1;
    FechaFacturacionSucursal pers = (FechaFacturacionSucursal) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update veFecFactSuc "+
                     " set activo=1 " +
                     " where " +
                     " oid_fec_fact_suc=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_FEC_FACT_SUC, pers.getOID());
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
      case SELECT_BY_SUCURSAL : {
        ps = this.selectBySucursal(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_FEC_FACT_SUC = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veFecFactSuc ");
    textSQL.append(" WHERE oid_fec_fact_suc = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_FEC_FACT_SUC, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veFecFactSuc ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectBySucursal(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  veFecFactSuc ");
    textSQL.append(" WHERE oid_sucursal = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Sucursal sucursal = (Sucursal) aCondiciones;
    querySelect.setInt(1,sucursal.getOID());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_fec_fact_suc oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veFecFactSuc");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static FechaFacturacionSucursal getFechaFacturacion(Sucursal aSucursal,
                                                             ISesion aSesion)
                                                      throws BaseException {
    return (FechaFacturacionSucursal) ObjetoLogico.getObjects(FechaFacturacionSucursal.NICKNAME,
                                             DBFechaFacturacionSucursal.SELECT_BY_SUCURSAL,
                                             aSucursal,
                                             new ObjetoObservado(),
                                             aSesion);

  }


}
