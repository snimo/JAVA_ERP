package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.SujetoImpositivo;
import com.srn.erp.pagos.bm.PagoAcumRetGan;
import com.srn.erp.pagos.bm.PeriRetGan;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPagoAcumRetGan extends DBObjetoPersistente {

  public static final String OID_PAGO_ACUM = "oid_pago_acum";
  public static final String OID_SUJ_IMP = "oid_suj_imp";
  public static final String OID_PERI_RET_GAN = "oid_peri_ret_gan";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String IMPO_PAGO_ACUM = "impo_pago_acum";
  public static final String IMPO_PAGO_RET = "impo_pago_ret";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_SUJETO_PERIODO_CONCEPTO = 100;

  public DBPagoAcumRetGan() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_PAGO_ACUM = 1;
    final int OID_SUJ_IMP = 2;
    final int OID_PERI_RET_GAN = 3;
    final int OID_CONC_IMPU = 4;
    final int IMPO_PAGO_ACUM = 5;
    final int IMPO_PAGO_RET = 6;
    final int ACTIVO = 7;

    PagoAcumRetGan pers = (PagoAcumRetGan) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opRetGanPagoAcum "+
                     " ( "+
                      "OID_PAGO_ACUM,"+
                      "OID_SUJ_IMP,"+
                      "OID_PERI_RET_GAN,"+
                      "OID_CONC_IMPU,"+
                      "IMPO_PAGO_ACUM,"+
                      "IMPO_PAGO_RET,"+
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
    qInsert.setInt(OID_PAGO_ACUM,pers.getOID());
    qInsert.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    qInsert.setInt(OID_PERI_RET_GAN,pers.getPeriretgan().getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConcimpuesto().getOID());
    qInsert.setDouble(IMPO_PAGO_ACUM,pers.getPagoacum().doubleValue());
    qInsert.setDouble(IMPO_PAGO_RET,pers.getPagoretenido().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_SUJ_IMP = 1;
    final int OID_PERI_RET_GAN = 2;
    final int OID_CONC_IMPU = 3;
    final int IMPO_PAGO_ACUM = 4;
    final int IMPO_PAGO_RET = 5;
    final int ACTIVO = 6;
    final int OID_PAGO_ACUM = 7;

    PagoAcumRetGan pers = (PagoAcumRetGan) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opRetGanPagoAcum set "+
              "oid_suj_imp=?"+
              ",oid_peri_ret_gan=?"+
              ",oid_conc_impu=?"+
              ",impo_pago_acum=?"+
              ",impo_pago_ret=?"+
              ",activo=?"+
                 " where " +
                 " oid_pago_acum=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PAGO_ACUM,pers.getOID());
    qUpdate.setInt(OID_SUJ_IMP,pers.getSujetoimpositivo().getOID());
    qUpdate.setInt(OID_PERI_RET_GAN,pers.getPeriretgan().getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConcimpuesto().getOID());
    qUpdate.setDouble(IMPO_PAGO_ACUM,pers.getPagoacum().doubleValue());
    qUpdate.setDouble(IMPO_PAGO_RET,pers.getPagoretenido().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PAGO_ACUM = 1;
    PagoAcumRetGan pers = (PagoAcumRetGan) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetGanPagoAcum "+
                     " set activo=0 " +
                     " where " +
                     " oid_pago_acum=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PAGO_ACUM, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_PAGO_ACUM = 1;
    PagoAcumRetGan pers = (PagoAcumRetGan) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opRetGanPagoAcum "+
                     " set activo=1 " +
                     " where " +
                     " oid_pago_acum=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_PAGO_ACUM, pers.getOID());
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
      case SELECT_BY_SUJETO_PERIODO_CONCEPTO: {
        ps = this.selectBySujetoPeriodoConcepto(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_PAGO_ACUM = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetGanPagoAcum ");
    textSQL.append(" WHERE oid_pago_acum = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_PAGO_ACUM, oid);
    return querySelect;
  }

  private PreparedStatement selectBySujetoPeriodoConcepto(Object aCondiciones) throws BaseException, SQLException {
    Hashtable condiciones = (Hashtable) aCondiciones;
    SujetoImpositivo sujetoImpositivo = (SujetoImpositivo) condiciones.get(SujetoImpositivo.NICKNAME);
    PeriRetGan periRetGan = (PeriRetGan) condiciones.get(PeriRetGan.NICKNAME);
    ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) condiciones.get(ConceptoImpuesto.NICKNAME);

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetGanPagoAcum ");
    textSQL.append(" WHERE oid_suj_imp = ? and oid_peri_ret_gan = ? and oid_conc_impu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    querySelect.setInt(1, sujetoImpositivo.getOID());
    querySelect.setInt(2, periRetGan.getOID());
    querySelect.setInt(3,conceptoImpuesto.getOID());
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opRetGanPagoAcum ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_pago_acum oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opRetGanPagoAcum");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static PagoAcumRetGan getPagoAcumRetGan(SujetoImpositivo sujetoImpositivo,
                                                 PeriRetGan periRetGan,
                                                 ConceptoImpuesto conceptoImpuesto,
                                                 ISesion aSesion) throws BaseException {
    Hashtable condiciones = new Hashtable();
    condiciones.put(SujetoImpositivo.NICKNAME,sujetoImpositivo);
    condiciones.put(PeriRetGan.NICKNAME,periRetGan);
    condiciones.put(ConceptoImpuesto.NICKNAME,conceptoImpuesto);
    return (PagoAcumRetGan) ObjetoLogico.getObjects(PagoAcumRetGan.NICKNAME,
                                          DBPagoAcumRetGan.SELECT_BY_SUJETO_PERIODO_CONCEPTO,
                                          condiciones,
                                          new ObjetoObservado(),
                                          aSesion);
  }


}
