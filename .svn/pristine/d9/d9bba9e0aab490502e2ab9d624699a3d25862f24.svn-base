package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproProvDetCtaImpu;
import com.srn.erp.ctasAPagar.bm.ComproProveedorDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproProvDetCtaImpu extends DBObjetoPersistente {

  public static final String OID_CCO_DET_CTA = "oid_cco_det_cta";
  public static final String OID_AI = "oid_ai";
  public static final String IMPO_MONEDA_ORI = "impo_moneda_ori";
  public static final String OID_CCO_PROV_DET = "oid_cco_prov_det";
  public static final String ACTIVO = "activo";
  public static final String COMENTARIO = "comentario";
  
  public static final int SELECT_BY_CONC_PROV = 100;

  public DBComproProvDetCtaImpu() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_DET_CTA = 1;
    final int OID_AI = 2;
    final int IMPO_MONEDA_ORI = 3;
    final int OID_CCO_PROV_DET = 4;
    final int ACTIVO = 5;
    final int COMENTARIO = 6;

    ComproProvDetCtaImpu pers = (ComproProvDetCtaImpu) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpComproProvCtaImp "+
                     " ( "+
                      "OID_CCO_DET_CTA,"+
                      "OID_AI,"+
                      "IMPO_MONEDA_ORI,"+
                      "OID_CCO_PROV_DET,"+
                      "ACTIVO,COMENTARIO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CCO_DET_CTA,pers.getOID());
    qInsert.setInt(OID_AI,pers.getCuentaimputable().getOID());
    qInsert.setDouble(IMPO_MONEDA_ORI,pers.getImporte().doubleValue());
    qInsert.setInt(OID_CCO_PROV_DET,pers.getComproprovdet().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getComentario()!=null)
    	qInsert.setString(COMENTARIO, pers.getComentario());
    else
    	qInsert.setString(COMENTARIO, "");
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_AI = 1;
    final int IMPO_MONEDA_ORI = 2;
    final int OID_CCO_PROV_DET = 3;
    final int ACTIVO = 4;
    final int OID_CCO_DET_CTA = 5;

    ComproProvDetCtaImpu pers = (ComproProvDetCtaImpu) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpComproProvCtaImp set "+
              "oid_ai=?"+
              ",impo_moneda_ori=?"+
              ",oid_cco_prov_det=?"+
              ",activo=?"+
                 " where " +
                 " oid_cco_det_cta=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_DET_CTA,pers.getOID());
    qUpdate.setInt(OID_AI,pers.getCuentaimputable().getOID());
    qUpdate.setDouble(IMPO_MONEDA_ORI,pers.getImporte().doubleValue());
    qUpdate.setInt(OID_CCO_PROV_DET,pers.getComproprovdet().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_DET_CTA = 1;
    ComproProvDetCtaImpu pers = (ComproProvDetCtaImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvCtaImp "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco_det_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_DET_CTA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_DET_CTA = 1;
    ComproProvDetCtaImpu pers = (ComproProvDetCtaImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvCtaImp "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco_det_cta=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_DET_CTA, pers.getOID());
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
      case SELECT_BY_CONC_PROV: {
        ps = this.selectByConcFactProv(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO_DET_CTA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvCtaImp ");
    textSQL.append(" WHERE oid_cco_det_cta = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO_DET_CTA, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByConcFactProv(Object aCondiciones) throws BaseException, SQLException {

  	ComproProveedorDet comproProvDet = (ComproProveedorDet) aCondiciones;
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvCtaImp ");
    textSQL.append(" WHERE oid_cco_prov_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1, comproProvDet.getOID());
    return querySelect;
  }
  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvCtaImp ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_det_cta oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpComproProvCtaImp");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getImputacionesContablesConcepto(ComproProveedorDet comproProvDet,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ComproProvDetCtaImpu.NICKNAME,
         DBComproProvDetCtaImpu.SELECT_BY_CONC_PROV,
         comproProvDet,
         new ListObserver(),
         aSesion);
  }
  

}
