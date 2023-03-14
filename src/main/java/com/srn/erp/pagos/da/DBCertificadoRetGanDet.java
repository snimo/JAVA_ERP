package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.CertificadoRetGanCab;
import com.srn.erp.pagos.bm.CertificadoRetGanDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCertificadoRetGanDet extends DBObjetoPersistente {

  public static final String OID_CCO_CERT_DET = "oid_cco_cert_det";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String MONTO_NO_IMPO = "monto_no_impo";
  public static final String OID_CCO_CERT = "oid_cco_cert";
  public static final String MONTO_GRAVADO = "monto_gravado";
  public static final String PAGO_NETO = "pago_neto";
  public static final String PORC_RET = "porc_ret";
  public static final String MONTO_RET_MIN = "monto_ret_min";
  public static final String BASE_PARA_RETENER = "base_para_retener";
  public static final String PAGO_ACUM = "pago_acum";
  public static final String RET_ACUM = "ret_acum";
  public static final String IMPUESTO_RETENIDO = "impuesto_retenido";
  public static final String MONTO_FIJO = "monto_fijo";

  public static final int SELECT_BY_CERT_RET_GAN = 100;

  public DBCertificadoRetGanDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO_CERT_DET = 1;
    final int OID_CONC_IMPU = 2;
    final int MONTO_NO_IMPO = 3;
    final int OID_CCO_CERT = 4;
    final int MONTO_GRAVADO = 5;
    final int PAGO_NETO = 6;
    final int PORC_RET = 7;
    final int MONTO_RET_MIN = 8;
    final int BASE_PARA_RETENER = 9;
    final int PAGO_ACUM = 10;
    final int RET_ACUM = 11;
    final int IMPUESTO_RETENIDO = 12;
    final int MONTO_FIJO = 13;

    CertificadoRetGanDet pers = (CertificadoRetGanDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opComproRetGanDet "+
                     " ( "+
                      "OID_CCO_CERT_DET,"+
                      "OID_CONC_IMPU,"+
                      "MONTO_NO_IMPO,"+
                      "OID_CCO_CERT,"+
                      "MONTO_GRAVADO,"+
                      "PAGO_NETO,"+
                      "PORC_RET,"+
                      "MONTO_RET_MIN,"+
                      "BASE_PARA_RETENER,"+
                      "PAGO_ACUM,"+
                      "RET_ACUM,"+
                      "IMPUESTO_RETENIDO,"+
                      "MONTO_FIJO)"+
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
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CCO_CERT_DET,pers.getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConceptoimpuesto().getOID());
    qInsert.setDouble(MONTO_NO_IMPO,pers.getMontonoimponible().doubleValue());
    qInsert.setInt(OID_CCO_CERT,pers.getCertificado().getOID());
    qInsert.setDouble(MONTO_GRAVADO,pers.getMontogravado().doubleValue());
    qInsert.setDouble(PAGO_NETO,pers.getPagoneto().doubleValue());
    qInsert.setDouble(PORC_RET,pers.getPorcentaje().doubleValue());
    qInsert.setDouble(MONTO_RET_MIN,pers.getMontoretminima().doubleValue());
    qInsert.setDouble(BASE_PARA_RETENER,pers.getBasepararetener().doubleValue());
    qInsert.setDouble(PAGO_ACUM,pers.getPagoacum().doubleValue());
    qInsert.setDouble(RET_ACUM,pers.getRetacum().doubleValue());
    qInsert.setDouble(IMPUESTO_RETENIDO,pers.getImpuestoretenido().doubleValue());
    qInsert.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONC_IMPU = 1;
    final int MONTO_NO_IMPO = 2;
    final int OID_CCO_CERT = 3;
    final int MONTO_GRAVADO = 4;
    final int PAGO_NETO = 5;
    final int PORC_RET = 6;
    final int MONTO_RET_MIN = 7;
    final int BASE_PARA_RETENER = 8;
    final int PAGO_ACUM = 9;
    final int RET_ACUM = 10;
    final int IMPUESTO_RETENIDO = 11;
    final int MONTO_FIJO = 12;
    final int OID_CCO_CERT_DET = 13;

    CertificadoRetGanDet pers = (CertificadoRetGanDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opComproRetGanDet set "+
              "oid_conc_impu=?"+
              ",monto_no_impo=?"+
              ",oid_cco_cert=?"+
              ",monto_gravado=?"+
              ",pago_neto=?"+
              ",porc_ret=?"+
              ",monto_ret_min=?"+
              ",base_para_retener=?"+
              ",pago_acum=?"+
              ",ret_acum=?"+
              ",impuesto_retenido=?"+
              ",monto_fijo=?"+
                 " where " +
                 " oid_cco_cert_det=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_CERT_DET,pers.getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConceptoimpuesto().getOID());
    qUpdate.setDouble(MONTO_NO_IMPO,pers.getMontonoimponible().doubleValue());
    qUpdate.setInt(OID_CCO_CERT,pers.getCertificado().getOID());
    qUpdate.setDouble(MONTO_GRAVADO,pers.getMontogravado().doubleValue());
    qUpdate.setDouble(PAGO_NETO,pers.getPagoneto().doubleValue());
    qUpdate.setDouble(PORC_RET,pers.getPorcentaje().doubleValue());
    qUpdate.setDouble(MONTO_RET_MIN,pers.getMontoretminima().doubleValue());
    qUpdate.setDouble(BASE_PARA_RETENER,pers.getBasepararetener().doubleValue());
    qUpdate.setDouble(PAGO_ACUM,pers.getPagoacum().doubleValue());
    qUpdate.setDouble(RET_ACUM,pers.getRetacum().doubleValue());
    qUpdate.setDouble(IMPUESTO_RETENIDO,pers.getImpuestoretenido().doubleValue());
    qUpdate.setDouble(MONTO_FIJO,pers.getMontofijo().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_CERT_DET = 1;
    CertificadoRetGanDet pers = (CertificadoRetGanDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproRetGanDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco_cert_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_CERT_DET, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO_CERT_DET = 1;
    CertificadoRetGanDet pers = (CertificadoRetGanDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproRetGanDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_cco_cert_det=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO_CERT_DET, pers.getOID());
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
      case SELECT_BY_CERT_RET_GAN: {
        ps = this.selectByCertRetGan(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO_CERT_DET = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproRetGanDet ");
    textSQL.append(" WHERE oid_cco_cert_det = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO_CERT_DET, oid);
    return querySelect;
  }

  private PreparedStatement selectByCertRetGan(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproRetGanDet ");
    textSQL.append(" WHERE oid_cco_cert  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    CertificadoRetGanCab certRetGanCab = (CertificadoRetGanCab) aCondiciones;
    querySelect.setInt(1,certRetGanCab.getOID());
    return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproRetGanDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco_cert_det oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opComproRetGanDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getDetallesCertificado(CertificadoRetGanCab certRetGanCab,
                                            ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(CertificadoRetGanDet.NICKNAME,
                                          DBCertificadoRetGanDet.SELECT_BY_CERT_RET_GAN,
                                          certRetGanCab,
                                          new ListObserver(),
                                          aSesion);
  }


}
