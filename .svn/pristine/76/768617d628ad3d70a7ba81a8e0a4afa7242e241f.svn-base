package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproProveedor;
import com.srn.erp.ctasAPagar.bm.ComproProveedorBase;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproProveedorDet extends DBObjetoPersistente {

  public static final String OID_CCO_PROV_DET = "oid_cco_prov_det";
  public static final String OID_CCO = "oid_cco";
  public static final String SECU = "secu";
  public static final String OID_CONC_FACT_PROV = "oid_conc_fact_prov";
  public static final String IMPO_MONEDA_ORI = "impo_moneda_ori";
  public static final String IMPO_MONEDA_LOC = "impo_moneda_loc";

  public static final int SELECT_BY_COMPRO_PROV = 100;

  public DBComproProveedorDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_PROV_DET = 1;
    final int OID_CCO = 2;
    final int SECU = 3;
    final int OID_CONC_FACT_PROV = 4;
    final int IMPO_MONEDA_ORI = 5;
    final int IMPO_MONEDA_LOC = 6;

    ComproProveedorDet pers = (ComproProveedorDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpComproProvDet "+
                     " ( "+
                      "OID_CCO_PROV_DET,"+
                      "OID_CCO,"+
                      "SECU,"+
                      "OID_CONC_FACT_PROV,"+
                      "IMPO_MONEDA_ORI,"+
                      "IMPO_MONEDA_LOC)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CCO_PROV_DET,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobanteBase().getOID());
    qInsert.setInt(SECU,pers.getSecu().intValue());
    qInsert.setInt(OID_CONC_FACT_PROV,pers.getConcFactProv().getOID());
    qInsert.setDouble(IMPO_MONEDA_ORI,pers.getImpoMonedaOri().doubleValue());
    qInsert.setDouble(IMPO_MONEDA_LOC,pers.getImpoMonedaLoc().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int SECU = 2;
    final int OID_CONC_FACT_PROV = 3;
    final int IMPO_MONEDA_ORI = 4;
    final int IMPO_MONEDA_LOC = 5;
    final int OID_CCO_PROV_DET = 6;

    ComproProveedorDet pers = (ComproProveedorDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpComproProvDet set "+
              "oid_cco=?"+
              ",secu=?"+
              ",oid_conc_fact_prov=?"+
              ",impo_moneda_ori=?"+
              ",impo_moneda_loc=?"+
                 " where " +
                 " oid_cco_prov_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_PROV_DET,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobanteBase().getOID());
    qUpdate.setInt(SECU,pers.getSecu().intValue());
    qUpdate.setInt(OID_CONC_FACT_PROV,pers.getConcFactProv().getOID());
    qUpdate.setDouble(IMPO_MONEDA_ORI,pers.getImpoMonedaOri().doubleValue());
    qUpdate.setDouble(IMPO_MONEDA_LOC,pers.getImpoMonedaLoc().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_PROV_DET = 1;
    ComproProveedorDet pers = (ComproProveedorDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco_prov_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_PROV_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_PROV_DET = 1;
    ComproProveedorDet pers = (ComproProveedorDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco_prov_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_PROV_DET, pers.getOID());
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
      case SELECT_BY_COMPRO_PROV: {
        ps = this.selectByComproProv(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByComproProv(Object aCondiciones) throws BaseException, SQLException {
        StringBuffer textSQL = new StringBuffer();
        textSQL.append("SELECT * FROM  cpComproProvDet ");
        textSQL.append(" WHERE oid_cco = ? ");
        PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
        ComproProveedorBase comproProveedorBase = (ComproProveedorBase) aCondiciones;
        querySelect.setInt(1,comproProveedorBase.getOID());
        return querySelect;
  }


  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO_PROV_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvDet ");
    textSQL.append(" WHERE oid_cco_prov_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO_PROV_DET, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_prov_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpComproProvDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getDetallesByComproProv(ComproProveedorBase comproProveedorBase,
                                             ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ComproProveedorDet.NICKNAME,
                                          DBComproProveedorDet.SELECT_BY_COMPRO_PROV,
                                          comproProveedorBase,
                                          new ListObserver(),
                                          aSesion);
  }




}
