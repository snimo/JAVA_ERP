package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.List;

import com.srn.erp.general.bm.ComproCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproOrdenPagoDet extends DBObjetoPersistente {

  public static final String OID_COMPRO_DET_OP = "oid_compro_det_op";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_MON_TRAN_PROV = "oid_mon_tran_prov";
  public static final String IMPO_FACT_MON_ORI = "impo_fact_mon_ori";
  public static final String DTO_MON_ORI = "dto_mon_ori";
  public static final String NETO_PAGO_MON_ORI = "neto_pago_mon_ori";
  public static final String IMPO_FACT_MON_PAGO = "impo_fact_mon_pago";
  public static final String DTO_MON_PAGO = "dto_mon_pago";
  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String IMPO_AUTO_MON_ORI = "impo_auto_mon_ori";
  public static final String NETO_PAGO_MON_PAGO = "neto_pago_mon_pago";
  public static final String IMPO_MAX_AUTO_ORI = "impo_max_auto_ori";
  public static final String IMPO_AUTO_MON_PAGO = "impo_auto_mon_pago";
  public static final String IMPO_MAX_AUTO_PAGO = "impo_max_auto_pago";
  public static final String IMPO_MAX_AUTO_LOC = "impo_max_auto_loc";
  public static final String IMPO_AUTO_MON_LOC = "impo_auto_mon_loc";
  public static final String IMPO_FAC_MON_LOC = "impo_fac_mon_loc";
  public static final String DTO_MON_LOC = "dto_mon_loc";
  public static final String NETO_PAGO_MON_LOC = "neto_pago_mon_loc";
  public static final String OID_CCO_ANT_PROV = "oid_cco_ant_prov";
  public static final String OID_CONC_PV = "oid_conc_pv";
  public static final String COMENTARIO = "comentario";
  
  public static final String IMPORTE_CUOTA = "importe_cuota";
  public static final String SALDO_CUOTA = "saldo_cuota";
  public static final String AUTORIZADO = "autorizado";
  public static final String PAGAR = "pagar";
  public static final String COTIZACION = "cotizacion";
  

  public static final int SELECT_BY_ORDEN_PAGO = 100;

  public DBComproOrdenPagoDet() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_COMPRO_DET_OP = 1;
    final int OID_CCO = 2;
    final int OID_MON_TRAN_PROV = 3;
    final int IMPO_FACT_MON_ORI = 4;
    final int DTO_MON_ORI = 5;
    final int NETO_PAGO_MON_ORI = 6;
    final int IMPO_FACT_MON_PAGO = 7;
    final int DTO_MON_PAGO = 8;
    final int OID_TRAN_VTO = 9;
    final int IMPO_AUTO_MON_ORI = 10;
    final int NETO_PAGO_MON_PAGO = 11;
    final int IMPO_MAX_AUTO_ORI = 12;
    final int IMPO_AUTO_MON_PAGO = 13;
    final int IMPO_MAX_AUTO_PAGO = 14;
    final int IMPO_MAX_AUTO_LOC = 15;
    final int IMPO_AUTO_MON_LOC = 16;
    final int IMPO_FAC_MON_LOC = 17;
    final int DTO_MON_LOC = 18;
    final int NETO_PAGO_MON_LOC = 19;
    final int OID_CCO_ANT_PROV = 20;
    final int OID_CONC_PV = 21;
    final int COMENTARIO = 22;
    
    final int IMPORTE_CUOTA = 23;
    final int SALDO_CUOTA = 24;
    final int AUTORIZADO = 25;
    final int PAGAR = 26;
    final int COTIZACION = 27;


    ComproOrdenPagoDet pers = (ComproOrdenPagoDet) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opComproCabOPDet "+
                     " ( "+
                      "OID_COMPRO_DET_OP,"+
                      "OID_CCO,"+
                      "OID_MON_TRAN_PROV,"+
                      "IMPO_FACT_MON_ORI,"+
                      "DTO_MON_ORI,"+
                      "NETO_PAGO_MON_ORI,"+
                      "IMPO_FACT_MON_PAGO,"+
                      "DTO_MON_PAGO,"+
                      "OID_TRAN_VTO,"+
                      "IMPO_AUTO_MON_ORI,"+
                      "NETO_PAGO_MON_PAGO,"+
                      "IMPO_MAX_AUTO_ORI,"+
                      "IMPO_AUTO_MON_PAGO,"+
                      "IMPO_MAX_AUTO_PAGO,"+
                      "IMPO_MAX_AUTO_LOC,"+
                      "IMPO_AUTO_MON_LOC,"+
                      "IMPO_FAC_MON_LOC,"+
                      "DTO_MON_LOC,"+
                      "NETO_PAGO_MON_LOC,"+
                      "OID_CCO_ANT_PROV,"+
                      "OID_CONC_PV,COMENTARIO"+
                      ",IMPORTE_CUOTA"+
                      ",SALDO_CUOTA"+
                      ",AUTORIZADO"+
                      ",PAGAR"+
                      ",COTIZACION"+
                      ")"+
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
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_COMPRO_DET_OP,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    qInsert.setInt(OID_MON_TRAN_PROV,pers.getMoneda().getOID());
    if (pers.getImpofactmonori()!=null)
    	qInsert.setDouble(IMPO_FACT_MON_ORI,pers.getImpofactmonori().doubleValue());
    else
    	qInsert.setDouble(IMPO_FACT_MON_ORI,0);
    if (pers.getDtomonori()!=null)
    	qInsert.setDouble(DTO_MON_ORI,pers.getDtomonori().doubleValue());
    else
    	qInsert.setDouble(DTO_MON_ORI,0);
    qInsert.setDouble(NETO_PAGO_MON_ORI,pers.getNetopagomonori().doubleValue());
    if (pers.getImpofactmonpago()!=null)
    	qInsert.setDouble(IMPO_FACT_MON_PAGO,pers.getImpofactmonpago().doubleValue());
    else
    	qInsert.setDouble(IMPO_FACT_MON_PAGO,0);
    if (pers.getDtomonpago()!=null)
    	qInsert.setDouble(DTO_MON_PAGO,pers.getDtomonpago().doubleValue());
    else
    	qInsert.setDouble(DTO_MON_PAGO,0);
    if (pers.getTranprovvto()!=null)
    	qInsert.setInt(OID_TRAN_VTO,pers.getTranprovvto().getOID());
    else
    	qInsert.setNull(OID_TRAN_VTO,Types.INTEGER);
    if (pers.getImpoautorizmonori()!=null)
    	qInsert.setDouble(IMPO_AUTO_MON_ORI,pers.getImpoautorizmonori().doubleValue());
    else
    	qInsert.setDouble(IMPO_AUTO_MON_ORI,0);
    if (pers.getNetopagomonpago()!=null)
    	qInsert.setDouble(NETO_PAGO_MON_PAGO,pers.getNetopagomonpago().doubleValue());
    else
    	qInsert.setDouble(NETO_PAGO_MON_PAGO,0);
    if (pers.getImpomaxautorizori()!=null)
    	qInsert.setDouble(IMPO_MAX_AUTO_ORI,pers.getImpomaxautorizori().doubleValue());
    else
    	qInsert.setDouble(IMPO_MAX_AUTO_ORI,0);
    if (pers.getImpoautorizmonpago()!=null)
    	qInsert.setDouble(IMPO_AUTO_MON_PAGO,pers.getImpoautorizmonpago().doubleValue());
    else
    	qInsert.setDouble(IMPO_AUTO_MON_PAGO,0);
    if (pers.getImpomaxautorizpago()!=null)
    	qInsert.setDouble(IMPO_MAX_AUTO_PAGO,pers.getImpomaxautorizpago().doubleValue());
    else
    	qInsert.setDouble(IMPO_MAX_AUTO_PAGO,0);
    if (pers.getImpoMaxAutoLoc()!=null)
    	qInsert.setDouble(IMPO_MAX_AUTO_LOC,pers.getImpoMaxAutoLoc().doubleValue());
    else
    	qInsert.setDouble(IMPO_MAX_AUTO_LOC,0);
    if (pers.getImpoAutoMonLoc()!=null)
    	qInsert.setDouble(IMPO_AUTO_MON_LOC,pers.getImpoAutoMonLoc().doubleValue());
    else
    	qInsert.setDouble(IMPO_AUTO_MON_LOC,0);
    if (pers.getImpoFactMonloc()!=null)
    	qInsert.setDouble(IMPO_FAC_MON_LOC,pers.getImpoFactMonloc().doubleValue());
    else
    	qInsert.setDouble(IMPO_FAC_MON_LOC,0);
    if (pers.getDtoMonloc()!=null)
    	qInsert.setDouble(DTO_MON_LOC,pers.getDtoMonloc().doubleValue());
    else
    	qInsert.setDouble(DTO_MON_LOC,0);
    if (pers.getNetoPagoMonLoc()!=null)
    	qInsert.setDouble(NETO_PAGO_MON_LOC,pers.getNetoPagoMonLoc().doubleValue());
    else
    	qInsert.setDouble(NETO_PAGO_MON_LOC,0);
    if (pers.getComproAntProv()!=null)
    	qInsert.setInt(OID_CCO_ANT_PROV, pers.getComproAntProv().getOID());
    else
    	qInsert.setNull(OID_CCO_ANT_PROV, Types.INTEGER);
    if (pers.getConceptoOPVarias()!=null)
    	qInsert.setInt(OID_CONC_PV, pers.getConceptoOPVarias().getOID());
    else
    	qInsert.setNull(OID_CONC_PV, Types.INTEGER);
    
    if (pers.getComentario()!=null)
    	qInsert.setString(COMENTARIO,pers.getComentario());
    else
    	qInsert.setNull(COMENTARIO,Types.VARCHAR);
    
    if (pers.getImporteCuota()!=null)
    	qInsert.setDouble(IMPORTE_CUOTA,pers.getImporteCuota().doubleValue());
    else
    	qInsert.setNull(IMPORTE_CUOTA,Types.DOUBLE);
    
    if (pers.getSaldoCuota()!=null)
    	qInsert.setDouble(SALDO_CUOTA,pers.getSaldoCuota().doubleValue());
    else
    	qInsert.setNull(SALDO_CUOTA,Types.DOUBLE);
    
    if (pers.getAutorizado()!=null)
    	qInsert.setDouble(AUTORIZADO,pers.getAutorizado().doubleValue());
    else
    	qInsert.setNull(AUTORIZADO,Types.DOUBLE);
    
    if (pers.getPagar()!=null)
    	qInsert.setDouble(PAGAR,pers.getPagar().doubleValue());
    else
    	qInsert.setNull(PAGAR,Types.DOUBLE);
    
    if (pers.getCotizacion()!=null)
    	qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    else
    	qInsert.setNull(COTIZACION,Types.DOUBLE);
    
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_MON_TRAN_PROV = 2;
    final int IMPO_FACT_MON_ORI = 3;
    final int DTO_MON_ORI = 4;
    final int NETO_PAGO_MON_ORI = 5;
    final int IMPO_FACT_MON_PAGO = 6;
    final int DTO_MON_PAGO = 7;
    final int OID_TRAN_VTO = 8;
    final int IMPO_AUTO_MON_ORI = 9;
    final int NETO_PAGO_MON_PAGO = 10;
    final int IMPO_MAX_AUTO_ORI = 11;
    final int IMPO_AUTO_MON_PAGO = 12;
    final int IMPO_MAX_AUTO_PAGO = 13;
    final int OID_CONC_PV = 14;
    final int COMENTARIO = 15;
    final int COTIZACION = 16;
    final int OID_COMPRO_DET_OP = 17;

    ComproOrdenPagoDet pers = (ComproOrdenPagoDet) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opComproCabOPDet set "+
              "oid_cco=?"+
              ",oid_mon_tran_prov=?"+
              ",impo_fact_mon_ori=?"+
              ",dto_mon_ori=?"+
              ",neto_pago_mon_ori=?"+
              ",impo_fact_mon_pago=?"+
              ",dto_mon_pago=?"+
              ",oid_tran_vto=?"+
              ",impo_auto_mon_ori=?"+
              ",neto_pago_mon_pago=?"+
              ",impo_max_auto_ori=?"+
              ",impo_auto_mon_pago=?"+
              ",impo_max_auto_pago=?"+
              ",oid_conc_pv = ? "+
              ",comentario = ? "+
              ",cotizacion = ? "+
                 " where " +
                 " oid_compro_det_op=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_DET_OP,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(OID_MON_TRAN_PROV,pers.getMoneda().getOID());
    qUpdate.setDouble(IMPO_FACT_MON_ORI,pers.getImpofactmonori().doubleValue());
    qUpdate.setDouble(DTO_MON_ORI,pers.getDtomonori().doubleValue());
    qUpdate.setDouble(NETO_PAGO_MON_ORI,pers.getNetopagomonori().doubleValue());
    qUpdate.setDouble(IMPO_FACT_MON_PAGO,pers.getImpofactmonpago().doubleValue());
    qUpdate.setDouble(DTO_MON_PAGO,pers.getDtomonpago().doubleValue());
    qUpdate.setInt(OID_TRAN_VTO,pers.getTranprovvto().getOID());
    qUpdate.setDouble(IMPO_AUTO_MON_ORI,pers.getImpoautorizmonori().doubleValue());
    qUpdate.setDouble(NETO_PAGO_MON_PAGO,pers.getNetopagomonpago().doubleValue());
    qUpdate.setDouble(IMPO_MAX_AUTO_ORI,pers.getImpomaxautorizori().doubleValue());
    qUpdate.setDouble(IMPO_AUTO_MON_PAGO,pers.getImpoautorizmonpago().doubleValue());
    qUpdate.setDouble(IMPO_MAX_AUTO_PAGO,pers.getImpomaxautorizpago().doubleValue());
    
    if (pers.getConceptoOPVarias()!=null)
    	qUpdate.setInt(OID_CONC_PV, pers.getConceptoOPVarias().getOID());
    else
    	qUpdate.setNull(OID_CONC_PV, Types.INTEGER);
    
    if (pers.getComentario()!=null)
    	qUpdate.setString(COMENTARIO,pers.getComentario());
    else
    	qUpdate.setNull(COMENTARIO,Types.VARCHAR);
    
    if (pers.getCotizacion()!=null)
    	qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    else
    	qUpdate.setNull(COTIZACION,Types.DOUBLE);
    
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_DET_OP = 1;
    ComproOrdenPagoDet pers = (ComproOrdenPagoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproCabOPDet "+
                     " set activo=0 " +
                     " where " +
                     " oid_compro_det_op=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_DET_OP, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_COMPRO_DET_OP = 1;
    ComproOrdenPagoDet pers = (ComproOrdenPagoDet) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproCabOPDet "+
                     " set activo=1 " +
                     " where " +
                     " oid_compro_det_op=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_COMPRO_DET_OP, pers.getOID());
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
      case SELECT_BY_ORDEN_PAGO: {
        ps = this.selectByOrdenPago(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_COMPRO_DET_OP = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproCabOPDet ");
    textSQL.append(" WHERE oid_compro_det_op = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_COMPRO_DET_OP, oid);
    return querySelect;
  }

  private PreparedStatement selectByOrdenPago(Object aCondiciones) throws BaseException, SQLException {
      StringBuffer textSQL = new StringBuffer();
      textSQL.append("SELECT * FROM  opComproCabOPDet ");
      textSQL.append(" WHERE  oid_cco = ? ");
      PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
      ComproCab comproCab = (ComproCab) aCondiciones;
      querySelect.setInt(1, comproCab.getOID());
      return querySelect;
  }


  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproCabOPDet ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_compro_det_op oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opComproCabOPDet");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }

  public static List getOrdPagoDet(ComproCab comproCab,
                                       ISesion aSesion) throws BaseException {
    return (List) ObjetoLogico.getObjects(ComproOrdenPagoDet.NICKNAME,
                                          DBComproOrdenPagoDet.SELECT_BY_ORDEN_PAGO,
                                          comproCab,
                                          new ListObserver(),
                                          aSesion);
  }


}
