package com.srn.erp.ctasACobrar.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.ctasACobrar.bm.TranClieVto;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBTranClieVto extends DBObjetoPersistente {

  public static final String OID_TRAN_VTO = "oid_tran_vto";
  public static final String OID_TRAN_CLIE = "oid_tran_clie";
  public static final String VTO = "vto";
  public static final String IMPORTE = "importe";
  public static final String SALDO = "saldo";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String PENDIENTE = "pendiente";
  public static final String NRO_CUOTA = "nro_cuota";
  public static final String FEC_CONF_COBRO = "fec_conf_cobro";
  
  public static final int UPDATE_FEC_CONF_COBRO = 100;

  public DBTranClieVto() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TRAN_VTO = 1;
    final int OID_TRAN_CLIE = 2;
    final int VTO = 3;
    final int IMPORTE = 4;
    final int SALDO = 5;
    final int OID_MONEDA = 6;
    final int PENDIENTE = 7;
    final int NRO_CUOTA = 8;
    final int FEC_CONF_COBRO = 9;

    TranClieVto pers = (TranClieVto) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veTranClieVto "+
                     " ( "+
                      "OID_TRAN_VTO,"+
                      "OID_TRAN_CLIE,"+
                      "VTO,"+
                      "IMPORTE,"+
                      "SALDO,"+
                      "OID_MONEDA,"+
                      "PENDIENTE,NRO_CUOTA,FEC_CONF_COBRO)"+ 
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
    qInsert.setInt(OID_TRAN_CLIE,pers.getTran_clie().getOID());
    qInsert.setDate(VTO,new java.sql.Date(pers.getVto().getTime()));
    qInsert.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qInsert.setDouble(SALDO,pers.getSaldo().doubleValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    if (pers.getNroCuota()!=null)
    	qInsert.setInt(NRO_CUOTA, pers.getNroCuota().intValue());
    else
    	qInsert.setInt(NRO_CUOTA, 1);
    if (pers.getFechaConfirmacionCobro()!=null)
    	qInsert.setDate(FEC_CONF_COBRO, new java.sql.Date(pers.getFechaConfirmacionCobro().getTime()));
    else
    	qInsert.setNull(FEC_CONF_COBRO, java.sql.Types.DATE);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TRAN_CLIE = 1;
    final int VTO = 2;
    final int IMPORTE = 3;
    final int SALDO = 4;
    final int OID_MONEDA = 5;
    final int PENDIENTE = 6;
    final int NRO_CUOTA = 7;
    final int FEC_CONF_COBRO = 8;
    final int OID_TRAN_VTO = 9;
    

    TranClieVto pers = (TranClieVto) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veTranClieVto set "+
              "oid_tran_clie=?"+ 
              ",vto=?"+ 
              ",importe=?"+ 
              ",saldo=?"+ 
              ",oid_moneda=?"+ 
              ",pendiente=?"+ 
              ",nro_cuota=?,fec_conf_cobro=? "+
                 " where " +
                 " oid_tran_vto=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_TRAN_VTO,pers.getOID());
    qUpdate.setInt(OID_TRAN_CLIE,pers.getTran_clie().getOID());
    qUpdate.setDate(VTO,new Date(pers.getVto().getTime()));
    qUpdate.setDouble(IMPORTE,pers.getImporte().doubleValue());
    qUpdate.setDouble(SALDO,pers.getSaldo().doubleValue());
    qUpdate.setDouble(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setBoolean(PENDIENTE,pers.isPendiente().booleanValue());
    if (pers.getNroCuota()!=null)
    	qUpdate.setInt(NRO_CUOTA, pers.getNroCuota().intValue());
    else
    	qUpdate.setInt(NRO_CUOTA, 1);
    if (pers.getFechaConfirmacionCobro()!=null)
    	qUpdate.setDate(FEC_CONF_COBRO, new java.sql.Date(pers.getFechaConfirmacionCobro().getTime()));
    else
    	qUpdate.setNull(FEC_CONF_COBRO, java.sql.Types.DATE);
    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_TRAN_VTO = 1; 
    TranClieVto pers = (TranClieVto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veTranClieVto "+
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
    TranClieVto pers = (TranClieVto) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veTranClieVto "+
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
      case UPDATE_FEC_CONF_COBRO: {
          ps = this.updateFecConfCobro(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_TRAN_VTO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veTranClieVto "); 
    textSQL.append(" WHERE oid_tran_vto = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_TRAN_VTO, oid); 
    return querySelect; 
  }

  private PreparedStatement updateFecConfCobro(Object aCondiciones) throws BaseException, SQLException { 
	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("update veTranClieVto set fec_conf_cobro = ? "); 
	    textSQL.append(" where oid_tran_vto = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    TranClieVto tranClieVto = (TranClieVto) condiciones.get(TranClieVto.NICKNAME);
	    java.util.Date fecha = (java.util.Date) condiciones.get("FECHA");
	    querySelect.setDate(1, new java.sql.Date(fecha.getTime()));
	    querySelect.setInt(2, tranClieVto.getOID());
	    
	    querySelect.executeUpdate();
	    querySelect.close();
	    return null; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veTranClieVto "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_tran_vto oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veTranClieVto");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static void cambiarFechaConfirmacionCobro(TranClieVto tranClieVto,java.util.Date fecha,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(TranClieVto.NICKNAME, tranClieVto);
	  condiciones.put("FECHA", fecha);
	  ObjetoLogico.getObjects(TranClieVto.NICKNAME,
			  				DBTranClieVto.UPDATE_FEC_CONF_COBRO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
} 
