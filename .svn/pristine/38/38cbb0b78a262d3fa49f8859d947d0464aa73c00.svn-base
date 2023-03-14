package com.srn.erp.pagos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.pagos.bm.ComproOrdenPagoCab;
import com.srn.erp.pagos.bm.ComproOrdenPagoMediosPago;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBComproOrdenPagoMediosPago extends DBObjetoPersistente {

  public static final String OID_OP_MEDIO_PAGO = "oid_op_medio_pago";
  public static final String OID_CCO = "oid_cco";
  public static final String OID_VALOR = "oid_valor";
  public static final String OID_TIPO_VALOR = "oid_tipo_valor";
  public static final String IMPO_MON_VALOR = "impo_mon_valor";
  public static final String IMPO_MON_PAGO = "impo_mon_pago";
  public static final String COTIZACION = "cotizacion";
  public static final String IMPO_MON_LOCAL = "impo_mon_loc";
  public static final String OID_CAJA = "oid_caja";
  
  public static final int SELECT_BY_OP = 100;

  public DBComproOrdenPagoMediosPago() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_OP_MEDIO_PAGO = 1;
    final int OID_CCO = 2;
    final int OID_VALOR = 3;
    final int OID_TIPO_VALOR = 4;
    final int IMPO_MON_VALOR = 5;
    final int IMPO_MON_PAGO = 6;
    final int COTIZACION = 7;
    final int IMPO_MON_LOC = 8;
    final int OID_CAJA = 9;

    ComproOrdenPagoMediosPago pers = (ComproOrdenPagoMediosPago) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into opComproOPMedPago "+
                     " ( "+
                      "OID_OP_MEDIO_PAGO,"+
                      "OID_CCO,"+
                      "OID_VALOR,"+
                      "OID_TIPO_VALOR,"+
                      "IMPO_MON_VALOR,"+
                      "IMPO_MON_PAGO,"+
                      "COTIZACION,"+
                      "IMPO_MON_LOC,OID_CAJA"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_OP_MEDIO_PAGO,pers.getOID());
    qInsert.setInt(OID_CCO,pers.getComprobante().getOID());
    if (pers.getValor()==null)
       qInsert.setNull(OID_VALOR,java.sql.Types.INTEGER);
    else
       qInsert.setInt(OID_VALOR,pers.getValor().getOID());
    qInsert.setInt(OID_TIPO_VALOR,pers.getTipovalor().getOID());
    qInsert.setDouble(IMPO_MON_VALOR,pers.getImpomonvalor().doubleValue());
    qInsert.setDouble(IMPO_MON_PAGO,pers.getImpomonpago().doubleValue());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setDouble(IMPO_MON_LOC,pers.getImpoMonLocal().doubleValue());
    if (pers.getCaja()!=null)
    	qInsert.setInt(OID_CAJA, pers.getCaja().getOID());
    else
    	qInsert.setNull(OID_CAJA, java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int OID_VALOR = 2;
    final int OID_TIPO_VALOR = 3;
    final int IMPO_MON_VALOR = 4;
    final int IMPO_MON_PAGO = 5;
    final int COTIZACION = 6;
    final int OID_CAJA = 7;
    final int OID_OP_MEDIO_PAGO = 8;
    

    ComproOrdenPagoMediosPago pers = (ComproOrdenPagoMediosPago) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update opComproOPMedPago set "+
              "oid_cco=?"+
              ",oid_valor=?"+
              ",oid_tipo_valor=?"+
              ",impo_mon_valor=?"+
              ",impo_mon_pago=?"+
              ",cotizacion=?"+
              ",oid_caja=?"+
                 " where " +
                 " oid_op_medio_pago=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OP_MEDIO_PAGO,pers.getOID());
    qUpdate.setInt(OID_CCO,pers.getComprobante().getOID());
    qUpdate.setInt(OID_VALOR,pers.getValor().getOID());
    qUpdate.setInt(OID_TIPO_VALOR,pers.getTipovalor().getOID());
    qUpdate.setDouble(IMPO_MON_VALOR,pers.getImpomonvalor().doubleValue());
    qUpdate.setDouble(IMPO_MON_PAGO,pers.getImpomonpago().doubleValue());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    if (pers.getCaja()!=null)
    	qUpdate.setInt(OID_CAJA, pers.getCaja().getOID());
    else
    	qUpdate.setNull(OID_CAJA, java.sql.Types.INTEGER);    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OP_MEDIO_PAGO = 1;
    ComproOrdenPagoMediosPago pers = (ComproOrdenPagoMediosPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproOPMedPago "+
                     " set activo=0 " +
                     " where " +
                     " oid_op_medio_pago=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OP_MEDIO_PAGO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_OP_MEDIO_PAGO = 1;
    ComproOrdenPagoMediosPago pers = (ComproOrdenPagoMediosPago) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update opComproOPMedPago "+
                     " set activo=1 " +
                     " where " +
                     " oid_op_medio_pago=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_OP_MEDIO_PAGO, pers.getOID());
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
      case SELECT_BY_OP: {
        ps = this.selectByOP(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_OP_MEDIO_PAGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproOPMedPago ");
    textSQL.append(" WHERE oid_op_medio_pago = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_OP_MEDIO_PAGO, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByOP(Object aCondiciones) throws BaseException, SQLException {
    
  	StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproOPMedPago ");
    textSQL.append(" WHERE oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    ComproOrdenPagoCab comproOrdenPagoCab = ( (ComproOrdenPagoCab) aCondiciones);
    querySelect.setInt(1, comproOrdenPagoCab.getOID());
    return querySelect;
    
  }
    
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  opComproOPMedPago ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_op_medio_pago oid, codigo,  descripcion ,activo ");
    textSQL.append(" from opComproOPMedPago");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getMediosPago(ComproOrdenPagoCab comproOrdenPagoCab,
      ISesion aSesion) throws BaseException {
  	return (List) ObjetoLogico.getObjects(ComproOrdenPagoMediosPago.NICKNAME,
         DBComproOrdenPagoMediosPago.SELECT_BY_OP,
         comproOrdenPagoCab,
         new ListObserver(),
         aSesion);
  }
  

}
