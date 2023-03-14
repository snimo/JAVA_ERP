package com.srn.erp.tesoreria.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.Date;
import java.util.List;

import com.srn.erp.tesoreria.bm.Recibo;
import com.srn.erp.ventas.bm.RemitoCab;
import com.srn.erp.ventas.bm.Sujeto;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBRecibo extends DBObjetoPersistente {

  public static final String OID_RECIBO = "oid_recibo";
  public static final String OID_COBRADOR = "oid_cobrador";
  public static final String OID_CAJA = "oid_caja";
  public static final String OID_SUJETO = "oid_sujeto";
  public static final String COTIZACION = "cotizacion";
  public static final String TOT_MON_ORI = "tot_mon_ori";
  public static final String TOT_MON_LOC = "tot_mon_loc";
  public static final String REEMPLAZA_RECIBO = "reemplaza_recibo";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String NRO_REC_ORI = "nro_rec_ori";
  public static final String TIPO_OPER = "tipo_oper";
  public static final String EN_CONCEPTO = "en_concepto";
  
  public static final int SELECT_BY_HELP = 100;

  public DBRecibo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_RECIBO = 1;
    final int OID_COBRADOR = 2;
    final int OID_CAJA = 3;
    final int OID_SUJETO = 4;
    final int COTIZACION = 5;
    final int TOT_MON_ORI = 6;
    final int TOT_MON_LOC = 7;
    final int REEMPLAZA_RECIBO = 8;
    final int OID_MONEDA = 9;
    final int NRO_REC_ORI = 10;
    final int TIPO_OPER = 11;
    final int EN_CONCEPTO = 12;

    Recibo pers = (Recibo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into teReciboCab "+
                     " ( "+
                      "OID_RECIBO,"+
                      "OID_COBRADOR,"+
                      "OID_CAJA,"+
                      "OID_SUJETO,"+
                      "COTIZACION,"+
                      "TOT_MON_ORI,"+
                      "TOT_MON_LOC,"+
                      "REEMPLAZA_RECIBO,"+
                      "OID_MONEDA,"+
                      "NRO_REC_ORI,TIPO_OPER,EN_CONCEPTO)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_RECIBO,pers.getOID());
    qInsert.setInt(OID_COBRADOR,pers.getCobrador().getOID());
    qInsert.setInt(OID_CAJA,pers.getCaja().getOID());
    if (pers.getSujeto()!=null)
    	qInsert.setInt(OID_SUJETO,pers.getSujeto().getOID());
    else
    	qInsert.setNull(OID_SUJETO,Types.INTEGER);
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setDouble(TOT_MON_ORI,pers.getTot_mon_ori().doubleValue());
    if (pers.getTot_mon_loc()!=null)
    	qInsert.setDouble(TOT_MON_LOC,pers.getTot_mon_loc().doubleValue());
    else
    	qInsert.setNull(TOT_MON_LOC,Types.DOUBLE );
    qInsert.setBoolean(REEMPLAZA_RECIBO,pers.isReemplaza_recibo().booleanValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setString(NRO_REC_ORI,pers.getNro_rec_ori());
    qInsert.setString(TIPO_OPER,pers.getTipoOper());
    if (pers.getEnConcepto()!=null)
    	qInsert.setString(EN_CONCEPTO, pers.getEnConcepto());
    else
    	qInsert.setNull(EN_CONCEPTO, java.sql.Types.VARCHAR);
    
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COBRADOR = 1;
    final int OID_CAJA = 2;
    final int OID_SUJETO = 3;
    final int COTIZACION = 4;
    final int TOT_MON_ORI = 5;
    final int TOT_MON_LOC = 6;
    final int REEMPLAZA_RECIBO = 7;
    final int OID_MONEDA = 8;
    final int NRO_REC_ORI = 9;
    final int EN_CONCEPTO = 10;
    final int OID_RECIBO = 11;

    Recibo pers = (Recibo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update teReciboCab set "+
              "oid_cobrador=?"+ 
              ",oid_caja=?"+ 
              ",oid_sujeto=?"+ 
              ",cotizacion=?"+ 
              ",tot_mon_ori=?"+ 
              ",tot_mon_loc=?"+ 
              ",reemplaza_recibo=?"+ 
              ",oid_moneda=?"+ 
              ",nro_rec_ori=?"+ 
              ",en_concepto=?"+
                 " where " +
                 " oid_recibo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RECIBO,pers.getOID());
    qUpdate.setInt(OID_COBRADOR,pers.getCobrador().getOID());
    qUpdate.setInt(OID_CAJA,pers.getCaja().getOID());
    qUpdate.setInt(OID_SUJETO,pers.getSujeto().getOID());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.setDouble(TOT_MON_ORI,pers.getTot_mon_ori().doubleValue());
    qUpdate.setDouble(TOT_MON_LOC,pers.getTot_mon_loc().doubleValue());
    qUpdate.setBoolean(REEMPLAZA_RECIBO,pers.isReemplaza_recibo().booleanValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setString(NRO_REC_ORI,pers.getNro_rec_ori());
    if (pers.getEnConcepto()!=null)
    	qUpdate.setString(EN_CONCEPTO, pers.getEnConcepto());
    else
    	qUpdate.setNull(EN_CONCEPTO, java.sql.Types.VARCHAR);

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
    final int OID_RECIBO = 1; 
    Recibo pers = (Recibo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update teReciboCab "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_recibo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_RECIBO, pers.getOID()); 
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
      case SELECT_BY_HELP : {
        ps = this.selectByHelp(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_RECIBO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.* , b.* FROM  teReciboCab a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_recibo = b.oid_cco and a.oid_recibo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_RECIBO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByHelp(Object aCondiciones) throws BaseException, SQLException { 

  	int nroParam = 0;
  	
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.*,b.* FROM  teReciboCab a, geComproCab b  "); 
    textSQL.append(" WHERE  a.oid_recibo = b.oid_cco ");
    
    if (condiciones.containsKey("NRO_EXT_DESDE")) 
    	textSQL.append(" and b.nro_ext >= "+condiciones.getInteger("NRO_EXT_DESDE").toString());
    
    if (condiciones.containsKey("NRO_EXT_HASTA")) 
    	textSQL.append(" and b.nro_ext <= "+condiciones.getInteger("NRO_EXT_HASTA").toString());
    
    if (condiciones.containsKey(Sujeto.NICKNAME)) {
			Sujeto sujeto = (Sujeto) condiciones.get(Sujeto.NICKNAME);
			textSQL.append(" and a.oid_sujeto = "
					+ sujeto.getOIDInteger().toString());
		}
    
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

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  teReciboCab "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_recibo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from teReciboCab");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
	public static List getHelpRecibos(Integer nroExtDesde,
			                              Integer nroExtHasta,
			                              Sujeto sujeto,
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
		if (sujeto!=null)
			condiciones.put(Sujeto.NICKNAME,sujeto);

		return (List) ObjetoLogico.getObjects(Recibo.NICKNAME,
				DBRecibo.SELECT_BY_HELP, condiciones,
				new ListObserver(), aSesion);
	}
  
  
} 
