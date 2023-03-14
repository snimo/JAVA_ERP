package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.ctasAPagar.bm.ComproProvTotImpu;
import com.srn.erp.general.bm.ComproCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproProvTotImpu extends DBObjetoPersistente {

  public static final String OID_COMPRO_TOT_IMP = "oid_compro_tot_imp";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_CONC_IMP = "oid_conc_impu";
  public static final String IMPORTE_MONEDA_ORI = "importe_moneda_ori";
  public static final String IMPORTE_MONEDA_LOC = "importe_moneda_loc";

  public static final int SELECT_BY_COMPRO_PROV = 100;

  public DBComproProvTotImpu() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPRO_TOT_IMP = 1;
    final int OID_CCO = 2;
    final int OID_CONC_PROV_IMP = 3;
    final int IMPORTE_MONEDA_ORI = 4;
    final int IMPORTE_MONEDA_LOC = 5;

    ComproProvTotImpu pers = (ComproProvTotImpu) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpComproProvTotImp "+
                     " ( "+
                      "OID_COMPRO_TOT_IMP,"+
                      "OID_CCO,"+
                      "OID_CONC_IMPU,"+
                      "IMPORTE_MONEDA_ORI,"+
                      "IMPORTE_MONEDA_LOC)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPRO_TOT_IMP,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(OID_CONC_PROV_IMP,pers.getConceptoImpuesto().getOID());
    qInsert.setDouble(IMPORTE_MONEDA_ORI,pers.getImporteMonedaOri().doubleValue());
    qInsert.setDouble(IMPORTE_MONEDA_LOC,pers.getImporteMonedaLocal().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_CONC_PROV_IMP = 2;
    final int IMPORTE_MONEDA_ORI = 3;
    final int IMPORTE_MONEDA_LOC = 4;
    final int OID_COMPRO_TOT_IMP = 5;

    ComproProvTotImpu pers = (ComproProvTotImpu) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpComproProvTotImp set "+
              "oid_cco=?"+
              ",oid_conc_impu=?"+
              ",importe_moneda_ori=?"+
              ",importe_moneda_loc=?"+
                 " where " +
                 " oid_compro_tot_imp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_TOT_IMP,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(OID_CONC_PROV_IMP,pers.getConceptoImpuesto().getOID());
    qUpdate.setDouble(IMPORTE_MONEDA_ORI,pers.getImporteMonedaOri().doubleValue());
    qUpdate.setDouble(IMPORTE_MONEDA_LOC,pers.getImporteMonedaLocal().doubleValue());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_TOT_IMP = 1;
    ComproProvTotImpu pers = (ComproProvTotImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvTotImp "+
                     " set activo=0 " +
                     " where " +
                     " oid_compro_tot_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_TOT_IMP, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_TOT_IMP = 1;
    ComproProvTotImpu pers = (ComproProvTotImpu) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpComproProvTotImp "+
                     " set activo=1 " +
                     " where " +
                     " oid_compro_tot_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_TOT_IMP, pers.getOID());
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
      case SELECT_BY_COMPRO_PROV : {
        ps = this.selectByComproProv(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPRO_TOT_IMP = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvTotImp ");
    textSQL.append(" WHERE oid_compro_tot_imp = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPRO_TOT_IMP, oid);
    return querySelect;
  }

  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvTotImp ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectByComproProv(Object aCondiciones) throws BaseException, SQLException {
    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpComproProvTotImp ");
    textSQL.append(" WHERE oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ComproCab comproCab = (ComproCab) aCondiciones;
    querySelect.setInt(1, comproCab.getOID());
    return querySelect;
  }


  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compro_tot_imp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpComproProvTotImp");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getImpuestosByCompro(ComproCab comproCab,
                                          ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ComproProvTotImpu.NICKNAME,
                                          DBComproProvTotImpu.SELECT_BY_COMPRO_PROV,
                                          comproCab,
                                          new ListObserver(),
                                          aSesion);
  }


}
