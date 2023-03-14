package com.srn.erp.ctasAPagar.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctasAPagar.bm.TranProvVto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTranProvVto extends DBObjetoPersistente {

  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String OID_TRAN_PROV = "oid_tran_prov";
  public static final String VTO = "vto";
  public static final String IMPORTE = "importe";
  public static final String SALDO = "saldo";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String PENDIENTE = "pendiente";
  public static final String NRO_CUOTA = "nro_cuota";
  public static final String FEC_CONF_PAGO = "fec_conf_pago";
  
  public static final int UPDATE_FEC_CONF_PAGO = 100;
  
  
  public DBTranProvVto() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TRAN_VTO = 1;
    final int OID_TRAN_PROV = 2;
    final int VTO = 3;
    final int IMPORTE = 4;
    final int SALDO = 5;
    final int OID_MONEDA = 6;
    final int PENDIENTE = 7;
    final int NRO_CUOTA = 8;
    final int FEC_CONF_PAGO = 9;

    TranProvVto pers = (TranProvVto) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cpTranProvVto "+
                     " ( "+
                      "OID_TRAN_VTO,"+
                      "OID_TRAN_PROV,"+
                      "VTO,"+
                      "IMPORTE,"+
                      "SALDO,"+
                      "OID_MONEDA,"+
                      "PENDIENTE,NRO_CUOTA,FEC_CONF_PAGO)"+
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
    qInsert.setInt(OID_TRAN_VTO,pers.getOID());
    qInsert.setInt(OID_TRAN_PROV,pers.getTranprov().getOID());
    qInsert.setDate(VTO,new java.sql.Date(pers.getVencimiento().getTime()));
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    if (pers.getNroCuota()!=null)
    	qInsert.setInt(NRO_CUOTA, pers.getNroCuota().intValue());
    else
    	qInsert.setInt(NRO_CUOTA, 1);
    if (pers.getFecConfPago()!=null)
    	qInsert.setDate(FEC_CONF_PAGO, new java.sql.Date(pers.getFecConfPago().getTime()));
    else
    	qInsert.setNull(FEC_CONF_PAGO, java.sql.Types.DATE);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_TRAN_PROV = 1;
    final int VTO = 2;
    final int IMPORTE = 3;
    final int SALDO = 4;
    final int OID_MONEDA = 5;
    final int PENDIENTE = 6;
    final int NRO_CUOTA = 7;
    final int FEC_CONF_PAGO = 8;
    final int OID_TRAN_VTO = 9;

    TranProvVto pers = (TranProvVto) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cpTranProvVto set "+
              "oid_tran_prov=?"+
              ",vto=?"+
              ",importe=?"+
              ",saldo=?"+
              ",oid_moneda=?"+
              ",pendiente=?"+
              ",nro_cuota=?"+
              ",fec_conf_pago=?"+
                 " where " +
                 " oid_tran_vto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TRAN_VTO,pers.getOID());
    qUpdate.setInt(OID_TRAN_PROV,pers.getTranprov().getOID());
    qUpdate.setDate(VTO,new java.sql.Date(pers.getVencimiento().getTime()));
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    if (pers.getNroCuota()!=null)
    	qUpdate.setInt(NRO_CUOTA, pers.getNroCuota().intValue());
    else
    	qUpdate.setInt(NRO_CUOTA, 1);
    if (pers.getFecConfPago()!=null)
    	qUpdate.setDate(FEC_CONF_PAGO, new java.sql.Date(pers.getFecConfPago().getTime()));
    else
    	qUpdate.setNull(FEC_CONF_PAGO, java.sql.Types.DATE);
    
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TRAN_VTO = 1;
    TranProvVto pers = (TranProvVto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpTranProvVto "+
                     " set activo=0 " +
                     " where " +
                     " oid_tran_vto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TRAN_VTO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_TRAN_VTO = 1;
    TranProvVto pers = (TranProvVto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cpTranProvVto "+
                     " set activo=1 " +
                     " where " +
                     " oid_tran_vto=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_TRAN_VTO, pers.getOID());
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
      case UPDATE_FEC_CONF_PAGO: {
          ps = this.updateFecConfPago(aCondiciones);
          break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_TRAN_VTO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpTranProvVto ");
    textSQL.append(" WHERE oid_tran_vto = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_TRAN_VTO, oid);
    return querySelect;
  }

  private PreparedStatement updateFecConfPago(Object aCondiciones) throws BaseException, SQLException {
	    StringBuffer textSQL = new StringBuffer();
	    textSQL.append("update cpTranProvVto ");
	    textSQL.append(" set fec_conf_pago = ? where oid_tran_vto = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    TranProvVto tranProvVto = (TranProvVto) condiciones.get(TranProvVto.NICKNAME);
	    querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
	    querySelect.setInt(2, tranProvVto.getOID());
	    querySelect.execute();
	    querySelect.close();
	    return null;
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT * FROM  cpTranProvVto ");
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tran_vto oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cpTranProvVto");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
	public static void cambiarFechaConfirmacionPago(TranProvVto tranProvVto, java.util.Date fecha, ISesion aSesion) throws BaseException {
		HashTableDatos condiciones = new HashTableDatos();
		condiciones.put(TranProvVto.NICKNAME, tranProvVto);
		condiciones.put("FECHA", fecha);
		ObjetoLogico.getObjects(TranProvVto.NICKNAME, DBTranProvVto.UPDATE_FEC_CONF_PAGO, condiciones, new ObjetoObservado(), aSesion);
	}
  

}
