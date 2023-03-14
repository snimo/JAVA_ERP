package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaPercIVA;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBTasaPercIVA extends DBObjetoPersistente {

  public static final String OID_TASA_PERC_IVA = "oid_tasa_perc_iva";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String FEC_VIGENCIA = "fec_vigencia";
  public static final String PORC = "porc";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_CONCEPTO_IMPUESTO = 100;
  public static final int SELECT_BY_IMPUESTO_VIGENTE  = 101;

  public DBTasaPercIVA() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TASA_PERC_IVA = 1;
    final int OID_CONC_IMPU = 2;
    final int FEC_VIGENCIA = 3;
    final int PORC = 4;
    final int ACTIVO = 5;

    TasaPercIVA pers = (TasaPercIVA) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imTasaPercIVA "+
                     " ( "+
                      "OID_TASA_PERC_IVA,"+
                      "OID_CONC_IMPU,"+
                      "FEC_VIGENCIA,"+
                      "PORC,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_TASA_PERC_IVA,pers.getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConcimpuesto().getOID());
    qInsert.setDate(FEC_VIGENCIA,new java.sql.Date(pers.getFechavigencia().getTime()));
    qInsert.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONC_IMPU = 1;
    final int FEC_VIGENCIA = 2;
    final int PORC = 3;
    final int ACTIVO = 4;
    final int OID_TASA_PERC_IVA = 5;

    TasaPercIVA pers = (TasaPercIVA) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imTasaPercIVA set "+
              "oid_conc_impu=?"+
              ",fec_vigencia=?"+
              ",porc=?"+
              ",activo=?"+
                 " where " +
                 " oid_tasa_perc_iva=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TASA_PERC_IVA,pers.getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConcimpuesto().getOID());
    qUpdate.setDate(FEC_VIGENCIA,new java.sql.Date(pers.getFechavigencia().getTime()));
    qUpdate.setDouble(PORC,pers.getPorcentaje().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TASA_PERC_IVA = 1;
    TasaPercIVA pers = (TasaPercIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imTasaPercIVA "+
                     " set activo=0 " +
                     " where " +
                     " oid_tasa_perc_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TASA_PERC_IVA, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TASA_PERC_IVA = 1;
    TasaPercIVA pers = (TasaPercIVA) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imTasaPercIVA "+
                     " set activo=1 " +
                     " where " +
                     " oid_tasa_perc_iva=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TASA_PERC_IVA, pers.getOID());
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
      case SELECT_BY_CONCEPTO_IMPUESTO: {
        ps = this.selectByConceptoImpuesto(aCondiciones);
        break;
      }
      case SELECT_BY_IMPUESTO_VIGENTE: {
        ps = this.selectByImpuestoVigente(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_TASA_PERC_IVA = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIVA ");
    textSQL.append(" WHERE oid_tasa_perc_iva = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TASA_PERC_IVA, oid);
    return querySelect;
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIVA ");
    textSQL.append(" WHERE oid_conc_impu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tasa_perc_iva oid,oid_conc_impu codigo,  descripcion ,activo ");
    textSQL.append(" from imTasaPercIVA");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByConceptoImpuesto(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIVA ");
    textSQL.append(" WHERE oid_conc_impu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) aCondiciones;
    querySelect.setInt(1, conceptoImpuesto.getOID());
    return querySelect;
  }

  public static List getTasasIVAByConceptoImpu(ConceptoImpuesto conceptoImpuesto,
                                               ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(TasaPercIVA.NICKNAME,
                                          SELECT_BY_CONCEPTO_IMPUESTO,
                                          conceptoImpuesto,
                                          new ListObserver(),
                                          aSesion);
  }

  private PreparedStatement selectByImpuestoVigente(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIVA ");
    textSQL.append(" WHERE oid_conc_impu = ? and fec_vigencia<=? order by fec_vigencia desc ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Hashtable condiciones = (Hashtable) aCondiciones;
    ConceptoImpuesto conceptoImpuesto =
        (ConceptoImpuesto) condiciones.get(ConceptoImpuesto.NICKNAME);
    java.util.Date fecha = (java.util.Date)condiciones.get("fecha");
    querySelect.setInt(1, conceptoImpuesto.getOID());
    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
    return querySelect;
  }

  public static List getTasaVigenteByConcImpu(ConceptoImpuesto conceptoImpuesto,
                                              java.util.Date fecha,
                                              ISesion aSesion) throws BaseException {
    Hashtable condiciones = new Hashtable();
    condiciones.put(ConceptoImpuesto.NICKNAME,conceptoImpuesto);
    condiciones.put("fecha",fecha);

    return (List) ObjetoLogico.getObjects(TasaPercIVA.NICKNAME,
                                          SELECT_BY_IMPUESTO_VIGENTE,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }





}
