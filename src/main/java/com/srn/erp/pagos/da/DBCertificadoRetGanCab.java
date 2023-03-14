package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.pagos.bm.CertificadoRetGanCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBCertificadoRetGanCab extends DBObjetoPersistente {

  public static final String OID_CCO_CERT = "oid_cco_cert";
  public static final String OID_CCO_OP = "oid_cco_op";
  public static final String OID_PROVEEDOR = "oid_proveedor";
  public static final String OID_PERI_RET_GAN = "oid_peri_ret_gan";
  public static final String OID_CAT_RET_GAN = "oid_cat_ret_gan";
  public static final String PORC_LIB = "porc_lib";
  public static final String DECRETO = "decreto";
  
  public static final int SELECT_BY_OID_CCO_OP = 100;

  public DBCertificadoRetGanCab() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_CERT = 1;
    final int OID_CCO_OP = 2;
    final int OID_PROVEEDOR = 3;
    final int OID_PERI_RET_GAN = 4;
    final int OID_CAT_RET_GAN = 5;
    final int PORC_LIB = 6;
    final int DECRETO = 7;

    CertificadoRetGanCab pers = (CertificadoRetGanCab) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opComproRetGan "+
                     " ( "+
                      "OID_CCO_CERT,"+
                      "OID_CCO_OP,"+
                      "OID_PROVEEDOR,"+
                      "OID_PERI_RET_GAN,"+
                      "OID_CAT_RET_GAN,"+
                      "PORC_LIB,"+
                      "DECRETO)"+
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
    qInsert.setInt(OID_CCO_CERT,pers.getOID());
    qInsert.setInt(OID_CCO_OP,pers.getOrdendepago().getOID());
    qInsert.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qInsert.setInt(OID_PERI_RET_GAN,pers.getPeriretgan().getOID());
    qInsert.setInt(OID_CAT_RET_GAN,pers.getCatretgan().getOID());
    qInsert.setDouble(PORC_LIB,pers.getPorclib().doubleValue());
    qInsert.setString(DECRETO,pers.getDecreto());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_OP = 1;
    final int OID_PROVEEDOR = 2;
    final int OID_PERI_RET_GAN = 3;
    final int OID_CAT_RET_GAN = 4;
    final int PORC_LIB = 5;
    final int DECRETO = 6;
    final int OID_CCO_CERT = 7;

    CertificadoRetGanCab pers = (CertificadoRetGanCab) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opComproRetGan set "+
              "oid_cco_op=?"+
              ",oid_proveedor=?"+
              ",oid_peri_ret_gan=?"+
              ",oid_cat_ret_gan=?"+
              ",porc_lib=?"+
              ",decreto=?"+
                 " where " +
                 " oid_cco_cert=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_CERT,pers.getOID());
    qUpdate.setInt(OID_CCO_OP,pers.getOrdendepago().getOID());
    qUpdate.setInt(OID_PROVEEDOR,pers.getProveedor().getOID());
    qUpdate.setInt(OID_PERI_RET_GAN,pers.getPeriretgan().getOID());
    qUpdate.setInt(OID_CAT_RET_GAN,pers.getCatretgan().getOID());
    qUpdate.setDouble(PORC_LIB,pers.getPorclib().doubleValue());
    qUpdate.setString(DECRETO,pers.getDecreto());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_CERT = 1;
    CertificadoRetGanCab pers = (CertificadoRetGanCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproRetGan "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco_cert=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_CERT, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_CERT = 1;
    CertificadoRetGanCab pers = (CertificadoRetGanCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproRetGan "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco_cert=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_CERT, pers.getOID());
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
      case SELECT_BY_OID_CCO_OP: {
          ps = this.selectByOP(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO_CERT = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproRetGan a, geComproCab b");
    textSQL.append(" WHERE b.oid_cco = a.oid_cco_cert and a.oid_cco_cert = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO_CERT, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByOP(Object aCondiciones) throws BaseException, SQLException {

	StringBuffer textSQL = new StringBuffer();
	textSQL.append("SELECT * FROM  opComproRetGan a, geComproCab b ");
	textSQL.append(" WHERE b.oid_cco = a.oid_cco_cert and oid_cco_op  = ? ");
	PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	ComproOrdenPagoCab op = (ComproOrdenPagoCab) aCondiciones;
	querySelect.setInt(1, op.getOID());
	return querySelect;
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproRetGan ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_cert oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opComproRetGan");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static CertificadoRetGanCab getCertificadoRetGan(ComproOrdenPagoCab op,
          ISesion aSesion)
          throws BaseException {
	  return (CertificadoRetGanCab) ObjetoLogico.getObjects(CertificadoRetGanCab.NICKNAME,
			  				DBCertificadoRetGanCab.SELECT_BY_OID_CCO_OP,
			  				op,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  

}
