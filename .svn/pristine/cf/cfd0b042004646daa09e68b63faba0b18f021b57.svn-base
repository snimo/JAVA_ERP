package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

import com.srn.erp.ctasAPagar.bm.AutorizacionFactProv;
import com.srn.erp.ctasAPagar.bm.TranProvVto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBAutorizacionFactProv extends DBObjetoPersistente {

  public static final String OID_AUTORIZ_FACT = "oid_autoriz_fact";
  public static final String OID_TRAN_PROV_VTO = "oid_tran_vto";
  public static final String PORC_AUTORIZ = "porc_autoriz";
  public static final String MONTO_AUTORIZ = "monto_autoriz";
  public static final String OID_USUARIO = "oid_usuario";
  public static final String FEC_AUTORIZ = "fec_autoriz";
  public static final String ACTIVO = "activo";
  public static final String ESTADO = "estado";
  public static final String OID_CCO = "oid_cco";

  public static final int SELECT_BY_TRAN_PROV_VTO = 100;

  public DBAutorizacionFactProv() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AUTORIZ_FACT = 1;
    final int OID_TRAN_PROV_VTO = 2;
    final int PORC_AUTORIZ = 3;
    final int MONTO_AUTORIZ = 4;
    final int OID_USUARIO = 5;
    final int FEC_AUTORIZ = 6;
    final int ACTIVO = 7;
    final int ESTADO = 8;
    final int OID_CCO = 9;

    AutorizacionFactProv pers = (AutorizacionFactProv) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpAutorizFactProv "+
                     " ( "+
                      "OID_AUTORIZ_FACT,"+
                      "OID_TRAN_VTO,"+
                      "PORC_AUTORIZ,"+
                      "MONTO_AUTORIZ,"+
                      "OID_USUARIO,"+
                      "FEC_AUTORIZ,"+
                      "ACTIVO,ESTADO,OID_CCO)"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_AUTORIZ_FACT,pers.getOID());
    if (pers.getTranprovVto()!=null)
    	qInsert.setInt(OID_TRAN_PROV_VTO,pers.getTranprovVto().getOID());
    else
    	qInsert.setNull(OID_TRAN_PROV_VTO,Types.INTEGER);
    qInsert.setDouble(PORC_AUTORIZ,pers.getPorcautoriz().doubleValue());
    qInsert.setDouble(MONTO_AUTORIZ,pers.getMontoautoriz().doubleValue());
    qInsert.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qInsert.setDate(FEC_AUTORIZ,new java.sql.Date(pers.getFecautoriz().getTime()));
    qInsert.setBoolean(ACTIVO,pers.getActivo().booleanValue());
    qInsert.setInt(ESTADO,pers.getEstado().intValue());
    if (pers.getComproCab()!=null)
    	qInsert.setInt(OID_CCO,pers.getComproCab().getOID());
    else
    	qInsert.setNull(OID_CCO,Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TRAN_VTO = 1;
    final int PORC_AUTORIZ = 2;
    final int MONTO_AUTORIZ = 3;
    final int OID_USUARIO = 4;
    final int FEC_AUTORIZ = 5;
    final int ACTIVO = 6;
    final int ESTADO = 7;
    final int OID_CCO = 8;
    final int OID_AUTORIZ_FACT = 9;

    AutorizacionFactProv pers = (AutorizacionFactProv) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpAutorizFactProv set "+
              "oid_tran_vto=?"+
              ",porc_autoriz=?"+
              ",monto_autoriz=?"+
              ",oid_usuario=?"+
              ",fec_autoriz=?"+
              ",activo=?"+
              ",estado=?"+
              ",oid_cco=?"+
                 " where " +
                 " oid_autoriz_fact=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AUTORIZ_FACT,pers.getOID());
    if (pers.getTranprovVto()!=null)
    	qUpdate.setInt(OID_TRAN_VTO,pers.getTranprovVto().getOID());
    else
    	qUpdate.setNull(OID_TRAN_VTO,Types.INTEGER);
    qUpdate.setDouble(PORC_AUTORIZ,pers.getPorcautoriz().doubleValue());
    qUpdate.setDouble(MONTO_AUTORIZ,pers.getMontoautoriz().doubleValue());
    qUpdate.setInt(OID_USUARIO,pers.getUsuario().getOID());
    qUpdate.setDate(FEC_AUTORIZ,new java.sql.Date(pers.getFecautoriz().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.getActivo().booleanValue());
    qUpdate.setInt(ESTADO, pers.getEstado().intValue());
    if (pers.getComproCab()!=null)
    	qUpdate.setInt(OID_CCO,pers.getComproCab().getOID());
    else
    	qUpdate.setNull(OID_CCO,Types.INTEGER);
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AUTORIZ_FACT = 1;
    AutorizacionFactProv pers = (AutorizacionFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpAutorizFactProv "+
                     " set activo=0 " +
                     " where " +
                     " oid_autoriz_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AUTORIZ_FACT, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_AUTORIZ_FACT = 1;
    AutorizacionFactProv pers = (AutorizacionFactProv) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpAutorizFactProv "+
                     " set activo=1 " +
                     " where " +
                     " oid_autoriz_fact=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_AUTORIZ_FACT, pers.getOID());
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
      case SELECT_BY_TRAN_PROV_VTO: {
        ps = this.selectByTranProvVto(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_AUTORIZ_FACT = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpAutorizFactProv ");
    textSQL.append(" WHERE oid_autoriz_fact = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_AUTORIZ_FACT, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpAutorizFactProv ");
    textSQL.append(" WHERE oid_tran_prov = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_autoriz_fact oid,oid_tran_prov codigo,  descripcion ,activo ");
    textSQL.append(" from cpAutorizFactProv");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByTranProvVto(Object aCondiciones) throws BaseException, SQLException {
    TranProvVto tranProvVto = (TranProvVto) aCondiciones;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpAutorizFactProv ");
    textSQL.append(" WHERE oid_tran_vto = ? and activo = 1 ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1, tranProvVto.getOID());
    return querySelect;
  }

  public static AutorizacionFactProv getAutorizFactProv(
                                           TranProvVto tranProvVto,
                                           ISesion aSesion)
                                           throws BaseException {
    return (AutorizacionFactProv) ObjetoLogico.getObjects(AutorizacionFactProv.NICKNAME,
                                            SELECT_BY_TRAN_PROV_VTO,
                                            tranProvVto,
                                            new ObjetoObservado(),
                                            aSesion);
  }



}
