package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;
import com.srn.erp.ctasAPagar.bm.ComproProveedorImpu;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproProveedorImpu extends DBObjetoPersistente {

  public static final String OID_COMPRO_PROV_IMP = "oid_compro_prov_imp";
  public static final String OID_CCO_PROV_DET = "oid_cco_prov_det";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_CONC_PROV_DET = 100;

  public DBComproProveedorImpu() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPRO_PROV_IMP = 1;
    final int OID_CCO_PROV_DET = 2;
    final int OID_CONC_IMPU = 3;
    final int ACTIVO = 4;

    ComproProveedorImpu pers = (ComproProveedorImpu) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpComproProvImp "+
                     " ( "+
                      "OID_COMPRO_PROV_IMP,"+
                      "OID_CCO_PROV_DET,"+
                      "OID_CONC_IMPU,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPRO_PROV_IMP,pers.getOID());
    qInsert.setInt(OID_CCO_PROV_DET,pers.getComproProveedorDet().getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConceptoImpuesto().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_PROV_DET = 1;
    final int OID_CONC_IMPU = 2;
    final int ACTIVO = 3;
    final int OID_COMPRO_PROV_IMP = 4;

    ComproProveedorImpu pers = (ComproProveedorImpu) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpComproProvImp set "+
              "oid_cco_prov_det=?"+
              ",oid_conc_prov_imp=?"+
              ",activo=?"+
                 " where " +
                 " oid_compro_prov_imp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_PROV_IMP,pers.getOID());
    qUpdate.setInt(OID_CCO_PROV_DET,pers.getComproProveedorDet().getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConceptoImpuesto().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_PROV_IMP = 1;
    ComproProveedorImpu pers = (ComproProveedorImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvImp "+
                     " set activo=0 " +
                     " where " +
                     " oid_compro_prov_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_PROV_IMP, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_PROV_IMP = 1;
    ComproProveedorImpu pers = (ComproProveedorImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvImp "+
                     " set activo=1 " +
                     " where " +
                     " oid_compro_prov_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_PROV_IMP, pers.getOID());
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
      case SELECT_BY_CONC_PROV_DET: {
        ps = this.selectByConcProvDet(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPRO_PROV_IMP = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvImp ");
    textSQL.append(" WHERE oid_compro_prov_imp = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPRO_PROV_IMP, oid);
    return querySelect;
  }

  private PreparedStatement selectByConcProvDet(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvImp ");
    textSQL.append(" WHERE oid_cco_prov_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ComproProveedorDet comproProvDet =  (ComproProveedorDet) aCondiciones;
    querySelect.setInt(1, comproProvDet.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvImp ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compro_prov_imp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpComproProvImp");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getImpuestosByConcepto(ComproProveedorDet comproProvDet,
                                            ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ComproProveedorImpu.NICKNAME,
                                          DBComproProveedorImpu.SELECT_BY_CONC_PROV_DET,
                                          comproProvDet,
                                          new ListObserver(),
                                          aSesion);
  }


}
