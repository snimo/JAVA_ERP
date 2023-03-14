package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.tesoreria.bm.Caja;
import com.srn.erp.tesoreria.bm.CajaCierreApertura;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCajaCierreApertura extends DBObjetoPersistente {

  public static final String OID_CAJA_APE_CIE = "oid_caja_ape_cie";
  public static final String OID_CAJA = "oid_caja";
  public static final String FEC_CIE_ANT = "fec_cie_ant";
  public static final String NUE_FEC_APER = "nue_fec_aper";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_CAJA = 100;

  public DBCajaCierreApertura() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CAJA_APE_CIE = 1;
    final int OID_CAJA = 2;
    final int FEC_CIE_ANT = 3;
    final int NUE_FEC_APER = 4;
    final int ACTIVO = 5;

    CajaCierreApertura pers = (CajaCierreApertura) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaCajaAperCierre "+
                     " ( "+
                      "OID_CAJA_APE_CIE,"+
                      "OID_CAJA,"+
                      "FEC_CIE_ANT,"+
                      "NUE_FEC_APER,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CAJA_APE_CIE,pers.getOID());
    qInsert.setInt(OID_CAJA,pers.getCaja().getOID());
    qInsert.setDate(FEC_CIE_ANT,new java.sql.Date(pers.getFeccierreant().getTime()));
    qInsert.setDate(NUE_FEC_APER,new java.sql.Date(pers.getNuefecaper().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CAJA = 1;
    final int FEC_CIE_ANT = 2;
    final int NUE_FEC_APER = 3;
    final int ACTIVO = 4;
    final int OID_CAJA_APE_CIE = 5;

    CajaCierreApertura pers = (CajaCierreApertura) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaCajaAperCierre set "+
              "oid_caja=?"+
              ",fec_cie_ant=?"+
              ",nue_fec_aper=?"+
              ",activo=?"+
                 " where " +
                 " oid_caja_ape_cie=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAJA_APE_CIE,pers.getOID());
    qUpdate.setInt(OID_CAJA,pers.getCaja().getOID());
    qUpdate.setDate(FEC_CIE_ANT,new java.sql.Date(pers.getFeccierreant().getTime()));
    qUpdate.setDate(NUE_FEC_APER,new java.sql.Date(pers.getNuefecaper().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAJA_APE_CIE = 1;
    CajaCierreApertura pers = (CajaCierreApertura) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaCajaAperCierre "+
                     " set activo=0 " +
                     " where " +
                     " oid_caja_ape_cie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAJA_APE_CIE, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CAJA_APE_CIE = 1;
    CajaCierreApertura pers = (CajaCierreApertura) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update vaCajaAperCierre "+
                     " set activo=1 " +
                     " where " +
                     " oid_caja_ape_cie=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CAJA_APE_CIE, pers.getOID());
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
      case SELECT_BY_CAJA: {
        ps = this.selectByCaja(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CAJA_APE_CIE = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCajaAperCierre ");
    textSQL.append(" WHERE oid_caja_ape_cie = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CAJA_APE_CIE, oid);
    return querySelect;
  }

  private PreparedStatement selectByCaja(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCajaAperCierre ");
    textSQL.append(" WHERE oid_caja = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Caja caja = (Caja) aCondiciones;
    querySelect.setInt(1,caja.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  vaCajaAperCierre ");
    textSQL.append(" WHERE oid_caja = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    Caja caja = Caja.findByCodigo(codigo,getSesion());
    querySelect.setInt(1,caja.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT a.oid_caja_ape_cie  oid, b.codigo,  b.descripcion , a.activo ");
    textSQL.append(" from vaCajaAperCierre a , vaCaja b where a.oid_caja = b.oid_caja ");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static CajaCierreApertura getAperturaCierreCaja(Caja caja,
                                                        ISesion aSesion)
                                                        throws BaseException {
    return (CajaCierreApertura) ObjetoLogico.getObjects(CajaCierreApertura.NICKNAME,
                                             DBCajaCierreApertura.SELECT_BY_CAJA,
                                             caja,
                                             new ObjetoObservado(),
                                             aSesion);
  }


}
