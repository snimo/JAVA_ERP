package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.tesoreria.bm.TransferenciaValores;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBTransferenciaValores extends DBObjetoPersistente {

	public static final String OID_TRANSF_VAL = "oid_transf_val";
  public static final String OID_CAJA_ORIGEN = "oid_caja_origen";
  public static final String OID_CAJA_DESTINO = "oid_caja_destino";
  
  public static final int SELECT_BY_HELP = 100;
    
  public DBTransferenciaValores() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_TRANSF_VAL = 1;
    final int OID_CAJA_ORIGEN = 2;
    final int OID_CAJA_DESTINO = 3;

    TransferenciaValores transferencia = (TransferenciaValores) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teTransfValores "+
                     " ( "+
                      "OID_TRANSF_VAL,"+
                      "OID_CAJA_ORIGEN,"+
                      "OID_CAJA_DESTINO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_TRANSF_VAL,transferencia.getOID());
    qInsert.setInt(OID_CAJA_ORIGEN,transferencia.getCajaOrigen().getOID());
    qInsert.setInt(OID_CAJA_DESTINO,transferencia.getCajaDestino().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CAJA_ORIGEN = 1;
    final int OID_CAJA_DESTINO = 2;
    final int OID_TRANSF_VAL = 3;

    TransferenciaValores pers = (TransferenciaValores) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teTransfValores set "+
              "oid_caja_origen=?"+ 
              ",oid_caja_destino=?"+ 
                 " where " +
                 " oid_transf_val=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CAJA_ORIGEN,pers.getCajaOrigen().getOID());
    qUpdate.setInt(OID_CAJA_DESTINO,pers.getCajaDestino().getOID());
    qUpdate.setInt(OID_TRANSF_VAL,pers.getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
		final int OID_CCO = 1;
		Recibo recibo = (Recibo) objetoPersistente;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setInt(OID_CCO, recibo.getOID());
		qUpdate.executeUpdate();
		qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CCO = 1; 
    Recibo pers = (Recibo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CCO, pers.getOID()); 
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
      case SELECT_BY_HELP: { 
        ps = this.selectByHelp(aCondiciones); 
        break; 
      } 
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.* , b.* FROM  teTransfValores a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_transf_val = b.oid_cco and a.oid_transf_val = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByHelp(Object aCondiciones) throws BaseException, SQLException { 

  	int nroParam = 0;
  	
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.*,b.* FROM  teTransfValores a, geComproCab b  "); 
    textSQL.append(" WHERE  a.oid_transf_val = b.oid_cco ");
    
    if (condiciones.containsKey("NRO_EXT_DESDE")) 
    	textSQL.append(" and b.nro_ext >= "+condiciones.getInteger("NRO_EXT_DESDE").toString());
    
    if (condiciones.containsKey("NRO_EXT_HASTA")) 
    	textSQL.append(" and b.nro_ext <= "+condiciones.getInteger("NRO_EXT_HASTA").toString());
        
		if (condiciones.containsKey("FEC_DESDE"))
			textSQL.append(" and b.emision >= ? ");

		if (condiciones.containsKey("FEC_HASTA"))
			textSQL.append(" and b.emision <= ? ");
    
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
		if (condiciones.containsKey("FEC_DESDE")) {
			java.util.Date fecDesde = (java.util.Date) condiciones
					.get("FEC_DESDE");
			++nroParam;
			querySelect
					.setDate(nroParam, new java.sql.Date(fecDesde.getTime()));
		}
		if (condiciones.containsKey("FEC_HASTA")) {
			java.util.Date fecHasta = (java.util.Date) condiciones
					.get("FEC_HASTA");
			++nroParam;
			querySelect
					.setDate(nroParam, new java.sql.Date(fecHasta.getTime()));
		}
    
    
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 
  	return null;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

  	return null; 
  } 
  
	public static List getHelpTransferencias(Integer nroExtDesde,
			                              Integer nroExtHasta,
			                              Date fechaDesde,
			                              Date fechaHasta,
			                              ISesion aSesion) throws BaseException {
		
		HashTableDatos condiciones = new HashTableDatos();
		if (nroExtDesde!=null)
			condiciones.put("NRO_EXT_DESDE",nroExtDesde.toString());
		if (nroExtHasta!=null)
			condiciones.put("NRO_EXT_HASTA",nroExtHasta.toString());
		if (fechaDesde!=null)
			condiciones.put("FEC_DESDE",fechaDesde);
		if (fechaHasta!=null)
			condiciones.put("FEC_HASTA",fechaHasta);

		return (List) ObjetoLogico.getObjects(TransferenciaValores.NICKNAME,
				DBTransferenciaValores.SELECT_BY_HELP, condiciones,
				new ListObserver(), aSesion);
	}
  
  
} 
