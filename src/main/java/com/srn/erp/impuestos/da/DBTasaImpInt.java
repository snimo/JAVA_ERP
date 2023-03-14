package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaImpInt;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBTasaImpInt extends DBObjetoPersistente {

  public static final String OID_IMP_INT = "oid_imp_int";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String FEC_VIGENCIA = "fec_vigencia";
  public static final String PORC = "porc";
  public static final String MONTO_MINIMO = "monto_minimo";
  public static final String ACTIVO = "activo";

  public static final int SELECT_BY_CONCEPTO_IMPUESTO = 100;
  public static final int SELECT_BY_IMPUESTO_VIGENTE  = 101;

  public DBTasaImpInt() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_IMP_INT = 1;
    final int OID_CONC_IMPU = 2;
    final int FEC_VIGENCIA = 3;
    final int PORC = 4;
    final int MONTO_MINIMO = 5;
    final int ACTIVO = 6;

    TasaImpInt pers = (TasaImpInt) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imImpInternos "+
                     " ( "+
                      "OID_IMP_INT,"+
                      "OID_CONC_IMPU,"+
                      "FEC_VIGENCIA,"+
                      "PORC,"+
                      "MONTO_MINIMO,"+
                      "ACTIVO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_IMP_INT,pers.getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConceptoimpuesto().getOID());
    qInsert.setDate(FEC_VIGENCIA,new java.sql.Date(pers.getFecvigencia().getTime()));
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    qInsert.setDouble(MONTO_MINIMO,pers.getMontominimo().doubleValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONC_IMPU = 1;
    final int FEC_VIGENCIA = 2;
    final int PORC = 3;
    final int MONTO_MINIMO = 4;
    final int ACTIVO = 5;
    final int OID_IMP_INT = 6;

    TasaImpInt pers = (TasaImpInt) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imImpInternos set "+
              "oid_conc_impu=?"+
              ",fec_vigencia=?"+
              ",porc=?"+
              ",monto_minimo=?"+
              ",activo=?"+
                 " where " +
                 " oid_imp_int=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_IMP_INT,pers.getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConceptoimpuesto().getOID());
    qUpdate.setDate(FEC_VIGENCIA,new java.sql.Date(pers.getFecvigencia().getTime()));
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    qUpdate.setDouble(MONTO_MINIMO,pers.getMontominimo().doubleValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_IMP_INT = 1;
    TasaImpInt pers = (TasaImpInt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imImpInternos "+
                     " set activo=0 " +
                     " where " +
                     " oid_imp_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_IMP_INT, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_IMP_INT = 1;
    TasaImpInt pers = (TasaImpInt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imImpInternos "+
                     " set activo=1 " +
                     " where " +
                     " oid_imp_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_IMP_INT, pers.getOID());
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
        ps = this.selectByConcImpu(aCondiciones);
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

    final int OID_IMP_INT = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imImpInternos ");
    textSQL.append(" WHERE oid_imp_int = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_IMP_INT, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imImpInternos ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_imp_int oid, codigo,  descripcion ,activo ");
    textSQL.append(" from imImpInternos");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  private PreparedStatement selectByConcImpu(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imImpInternos ");
    textSQL.append(" WHERE  oid_conc_impu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) aCondiciones;
    querySelect.setInt(1, conceptoImpuesto.getOID());
    return querySelect;
  }

  private PreparedStatement selectByImpuestoVigente(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imImpInternos ");
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


  public static List getTasasImpIntByConcImpu(ConceptoImpuesto conceptoImpuesto,
                                              ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(TasaImpInt.NICKNAME,
                                          SELECT_BY_CONCEPTO_IMPUESTO,
                                          conceptoImpuesto,
                                          new ListObserver(),
                                          aSesion);
  }

  public static List getTasaVigenteByConcImpu(ConceptoImpuesto conceptoImpuesto,
                                              java.util.Date fecha,
                                              ISesion aSesion) throws BaseException {
    Hashtable condiciones = new Hashtable();
    condiciones.put(ConceptoImpuesto.NICKNAME,conceptoImpuesto);
    condiciones.put("fecha",fecha);

    return (List) ObjetoLogico.getObjects(TasaImpInt.NICKNAME,
                                          SELECT_BY_IMPUESTO_VIGENTE,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }




}
