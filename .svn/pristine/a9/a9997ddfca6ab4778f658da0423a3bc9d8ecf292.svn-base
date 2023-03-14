package com.srn.erp.impuestos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Hashtable;
import java.util.List;

import com.srn.erp.general.bm.Provincia;
import com.srn.erp.impuestos.bm.CategoriaIB;
import com.srn.erp.impuestos.bm.ConceptoImpuesto;
import com.srn.erp.impuestos.bm.TasaPercIB;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBTasaPercIB extends DBObjetoPersistente {

  public static final String OID_TASA_PERC_IB = "oid_tasa_perc_ib";
  public static final String OID_CONC_IMPU = "oid_conc_impu";
  public static final String FEC_VIGENCIA = "fec_vigencia";
  public static final String PORC = "porc";
  public static final String OID_PROVINCIA = "oid_provincia";
  public static final String MONTO_MINIMO = "monto_minimo";
  public static final String OID_CAT_IB = "oid_cat_ib";
  public static final String ACTIVO = "activo";
  public static final String OID_ANA_IMP = "oid_ai";

  public static final int SELECT_BY_CONCEPTO_IMPUESTO = 100;
  public static final int SELECT_BY_IMPUESTO_VIGENTE  = 101;

  public DBTasaPercIB() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TASA_PERC_IB = 1;
    final int OID_CONC_IMPU = 2;
    final int FEC_VIGENCIA = 3;
    final int PORC = 4;
    final int OID_PROVINCIA = 5;
    final int MONTO_MINIMO = 6;
    final int OID_CAT_IB = 7;
    final int ACTIVO = 8;
    final int OID_ANA_IMP = 9;

    TasaPercIB pers = (TasaPercIB) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into imTasaPercIB "+
                     " ( "+
                      "OID_TASA_PERC_IB,"+
                      "OID_CONC_IMPU,"+
                      "FEC_VIGENCIA,"+
                      "PORC,"+
                      "OID_PROVINCIA,"+
                      "MONTO_MINIMO,"+
                      "OID_CAT_IB,"+
                      "ACTIVO , OID_AI)"+
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
    qInsert.setInt(OID_TASA_PERC_IB,pers.getOID());
    qInsert.setInt(OID_CONC_IMPU,pers.getConceptoImpuesto().getOID());
    qInsert.setDate(FEC_VIGENCIA,new java.sql.Date(pers.getFecVigencia().getTime()));
    qInsert.setDouble(PORC,pers.getPorc().doubleValue());
    qInsert.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    qInsert.setDouble(MONTO_MINIMO,pers.getMontoMinimo().doubleValue());
    qInsert.setInt(OID_CAT_IB,pers.getCategIB().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCuentaImputable()!=null)
    	qInsert.setInt(OID_ANA_IMP,pers.getCuentaImputable().getOID());
    else
    	qInsert.setNull(OID_ANA_IMP,Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CONC_IMPU = 1;
    final int FEC_VIGENCIA = 2;
    final int PORC = 3;
    final int OID_PROVINCIA = 4;
    final int MONTO_MINIMO = 5;
    final int OID_CAT_IB = 6;
    final int ACTIVO = 7;
    final int OID_ANA_IMP = 8;
    final int OID_TASA_PERC_IB = 9;

    TasaPercIB pers = (TasaPercIB) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update imTasaPercIB set "+
              "oid_conc_impu=?"+
              ",fec_vigencia=?"+
              ",porc=?"+
              ",oid_provincia=?"+
              ",monto_minimo=?"+
              ",oid_cat_ib=?"+
              ",activo=?"+
              ",oid_ai=?"+
                 " where " +
                 " oid_tasa_perc_ib=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TASA_PERC_IB,pers.getOID());
    qUpdate.setInt(OID_CONC_IMPU,pers.getConceptoImpuesto().getOID());
    qUpdate.setDate(FEC_VIGENCIA,new java.sql.Date(pers.getFecVigencia().getTime()));
    qUpdate.setDouble(PORC,pers.getPorc().doubleValue());
    qUpdate.setInt(OID_PROVINCIA,pers.getProvincia().getOID());
    qUpdate.setDouble(MONTO_MINIMO,pers.getMontoMinimo().doubleValue());
    qUpdate.setInt(OID_CAT_IB,pers.getCategIB().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.getCuentaImputable()!=null)
    	qUpdate.setInt(OID_ANA_IMP,pers.getCuentaImputable().getOID());
    else
    	qUpdate.setNull(OID_ANA_IMP,Types.INTEGER);
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TASA_PERC_IB = 1;
    TasaPercIB pers = (TasaPercIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imTasaPercIB "+
                     " set activo=0 " +
                     " where " +
                     " oid_tasa_perc_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TASA_PERC_IB, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TASA_PERC_IB = 1;
    TasaPercIB pers = (TasaPercIB) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update imTasaPercIB "+
                     " set activo=1 " +
                     " where " +
                     " oid_tasa_perc_ib=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TASA_PERC_IB, pers.getOID());
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

    final int OID_TASA_PERC_IB = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIB ");
    textSQL.append(" WHERE oid_tasa_perc_ib = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TASA_PERC_IB, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIB ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByConcImpu(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIB ");
    textSQL.append(" WHERE  oid_conc_impu = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ConceptoImpuesto conceptoImpuesto = (ConceptoImpuesto) aCondiciones;
    querySelect.setInt(1, conceptoImpuesto.getOID());
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tasa_perc_ib oid, codigo,  descripcion ,activo ");
    textSQL.append(" from imTasaPercIB");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getTasasPercIBByConcImpu(ConceptoImpuesto conceptoImpuesto,
                                              ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(TasaPercIB.NICKNAME,
                                          SELECT_BY_CONCEPTO_IMPUESTO,
                                          conceptoImpuesto,
                                          new ListObserver(),
                                          aSesion);
  }

  private PreparedStatement selectByImpuestoVigente(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  imTasaPercIB ");
    textSQL.append(" WHERE oid_conc_impu = ? and fec_vigencia<=? ");
    textSQL.append(" and oid_provincia = ? and oid_cat_ib = ? ");
    textSQL.append(" order by fec_vigencia desc ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    Hashtable condiciones = (Hashtable) aCondiciones;
    ConceptoImpuesto conceptoImpuesto =
        (ConceptoImpuesto) condiciones.get(ConceptoImpuesto.NICKNAME);
    java.util.Date fecha = (java.util.Date)condiciones.get("fecha");
    Provincia provincia = (Provincia) condiciones.get(Provincia.NICKNAME);
    CategoriaIB categoriaIB = (CategoriaIB) condiciones.get(CategoriaIB.NICKNAME);

    querySelect.setInt(1, conceptoImpuesto.getOID());
    querySelect.setDate(2, new java.sql.Date(fecha.getTime()));
    querySelect.setInt(3, provincia.getOID());
    querySelect.setInt(4, categoriaIB.getOID());

    return querySelect;
  }

  public static List getTasaVigenteByConcImpu(ConceptoImpuesto conceptoImpuesto,
                                              Provincia provincia,
                                              CategoriaIB categoriaIB,
                                              java.util.Date fecha,
                                              ISesion aSesion) throws BaseException {
    Hashtable condiciones = new Hashtable();
    condiciones.put(ConceptoImpuesto.NICKNAME,conceptoImpuesto);
    condiciones.put("fecha",fecha);
    condiciones.put(Provincia.NICKNAME,provincia);
    condiciones.put(CategoriaIB.NICKNAME,categoriaIB);

    return (List) ObjetoLogico.getObjects(TasaPercIB.NICKNAME,
                                          SELECT_BY_IMPUESTO_VIGENTE,
                                          condiciones,
                                          new ListObserver(),
                                          aSesion);
  }




}
