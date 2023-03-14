package com.srn.erp.bancos.da;


import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.bancos.bm.NotaBancaria;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBNotaBancaria extends DBObjetoPersistente {

  public static final String OID_NC_ND = "oid_nc_nd";
  public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";
  public static final String OID_MON_CTA = "oid_mon_cta";
  public static final String TOT_MON_CTA = "tot_mon_cta";
  public static final String COTIZACION = "cotizacion";
  
  public static final int SELECT_BY_HELP_NOTAS_BANCARIAS = 100;

  public DBNotaBancaria() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_NC_ND = 1;
    final int OID_CTA_BANCARIA = 2;
    final int OID_MON_CTA = 3;
    final int TOT_MON_CTA = 4;
    final int COTIZACION = 5;

    NotaBancaria pers = (NotaBancaria) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaNDNCBancaria "+
                     " ( "+
                      "OID_NC_ND,"+
                      "OID_CTA_BANCARIA,"+
                      "OID_MON_CTA,"+
                      "TOT_MON_CTA,"+
                      "COTIZACION)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_NC_ND,pers.getOID());
    qInsert.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qInsert.setInt(OID_MON_CTA,pers.getMoneda_cta().getOID());
    qInsert.setDouble(TOT_MON_CTA,pers.getTot_mon_cta().doubleValue());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CTA_BANCARIA = 1;
    final int OID_MON_CTA = 2;
    final int TOT_MON_CTA = 3;
    final int COTIZACION = 4;
    final int OID_NC_ND = 5;

    NotaBancaria pers = (NotaBancaria) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaNDNCBancaria set "+
              "oid_cta_bancaria=?"+ 
              ",oid_mon_cta=?"+ 
              ",tot_mon_cta=?"+ 
              ",cotizacion=?"+ 
                 " where " +
                 " oid_nc_nd=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NC_ND,pers.getOID());
    qUpdate.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qUpdate.setInt(OID_MON_CTA,pers.getMoneda_cta().getOID());
    qUpdate.setDouble(TOT_MON_CTA,pers.getTot_mon_cta().doubleValue());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NC_ND = 1; 
    NotaBancaria pers = (NotaBancaria) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaNDNCBancaria "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_nc_nd=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NC_ND, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_NC_ND = 1; 
    NotaBancaria pers = (NotaBancaria) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaNDNCBancaria "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_nc_nd=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_NC_ND, pers.getOID()); 
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
      case SELECT_BY_HELP_NOTAS_BANCARIAS: {
        ps = this.selectHelpNotasBancarias(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_NC_ND = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.*,b.* FROM  vaNDNCBancaria a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_nc_nd = b.oid_cco and oid_nc_nd = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_NC_ND, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectHelpNotasBancarias(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.*,b.* FROM  vaNDNCBancaria a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_nc_nd = b.oid_cco  "); 
    
    
    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
    
    if (condiciones.containsKey("NRO_DESDE")) 
    	textSQL.append(" and b.nro_ext>="+(Integer)condiciones.get("NRO_DESDE"));
    
    if (condiciones.containsKey("NRO_HASTA")) 
    	textSQL.append(" and b.nro_ext<="+(Integer)condiciones.get("NRO_HASTA"));
    
    if (condiciones.containsKey("FEC_DESDE")) 
    	textSQL.append(" and b.emision>=?");
    
    if (condiciones.containsKey("FEC_HASTA")) 
    	textSQL.append(" and b.emision<=?");
    
    if (condiciones.containsKey(CuentaBancaria.NICKNAME)) {
    	CuentaBancaria cuentaBancaria = (CuentaBancaria) condiciones.get(CuentaBancaria.NICKNAME);
    	textSQL.append(" and a.oid_cta_bancaria="+cuentaBancaria.getOIDInteger());
    }    

    int nroParam = 0;
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
    if (condiciones.containsKey("FEC_DESDE")) {
    	++nroParam;
    	querySelect.setDate(nroParam,new java.sql.Date(((java.util.Date)condiciones.get("FEC_DESDE")).getTime()));
    }
    
    
    if (condiciones.containsKey("FEC_HASTA")) {
    	++nroParam;
    	querySelect.setDate(nroParam,new java.sql.Date(((java.util.Date)condiciones.get("FEC_HASTA")).getTime()));
    }
    
    return querySelect; 
  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaNDNCBancaria "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_nc_nd oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaNDNCBancaria");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getHelpNotasBancarias(
  		Integer nroDesde,
  		Integer nroHasta,
  		java.util.Date fecDesde,
  		java.util.Date fecHasta,
  		CuentaBancaria cuentaBancaria,
  		ISesion aSesion) throws BaseException {
  	
  	HashTableDatos condiciones = new HashTableDatos();
  	
  	if (nroDesde!=null)
  		condiciones.put("NRO_DESDE",nroDesde);
  	
  	if (nroHasta!=null)
  		condiciones.put("NRO_HASTA",nroHasta);

  	if (fecDesde!=null)
  		condiciones.put("FEC_DESDE",fecDesde);
  	
  	if (fecHasta!=null)
  		condiciones.put("FEC_HASTA",fecHasta);
  	
  	if (cuentaBancaria!=null)
  		condiciones.put(CuentaBancaria.NICKNAME,cuentaBancaria);
  	
  	return (List) ObjetoLogico.getObjects(NotaBancaria.NICKNAME,
         DBNotaBancaria.SELECT_BY_HELP_NOTAS_BANCARIAS,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  
} 
