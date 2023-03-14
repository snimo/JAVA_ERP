package com.srn.erp.bancos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.bancos.bm.BoletaDeposito;
import com.srn.erp.tesoreria.bm.CuentaBancaria;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBBoletaDeposito extends DBObjetoPersistente {

  public static final String OID_BOLETA_DEP = "oid_boleta_dep";
  public static final String FEC_DEPOSITO = "fec_deposito";
  public static final String CLEARING = "clearing";
  public static final String OID_CTA_BANCARIA = "oid_cta_bancaria";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COTIZACION = "cotizacion";
  public static final String MONTO_DEPOSITO = "monto_deposito";
  public static final String GASTOS = "gastos";
  public static final String NETO_DEPOSITO = "neto_deposito";
  public static final String OID_CAJA = "oid_caja";
  
  public static final int SELECT_BY_HELP_BOLETA_DEPOSITO = 100;

  public DBBoletaDeposito() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_BOLETA_DEP = 1;
    final int FEC_DEPOSITO = 2;
    final int CLEARING = 3;
    final int OID_CTA_BANCARIA = 4;
    final int OID_MONEDA = 5;
    final int COTIZACION = 6;
    final int MONTO_DEPOSITO = 7;
    final int GASTOS = 8;
    final int NETO_DEPOSITO = 9;
    final int OID_CAJA = 10;

    BoletaDeposito pers = (BoletaDeposito) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into vaBoletaDeposito "+
                     " ( "+
                      "OID_BOLETA_DEP,"+
                      "FEC_DEPOSITO,"+
                      "CLEARING,"+
                      "OID_CTA_BANCARIA,"+
                      "OID_MONEDA,"+
                      "COTIZACION,"+
                      "MONTO_DEPOSITO,"+
                      "GASTOS,"+
                      "NETO_DEPOSITO,OID_CAJA)"+ 
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_BOLETA_DEP,pers.getOID());
    qInsert.setDate(FEC_DEPOSITO,new java.sql.Date(pers.getFec_deposito().getTime()));
    qInsert.setInt(CLEARING,pers.getClearing().intValue());
    qInsert.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setDouble(MONTO_DEPOSITO,pers.getMontoDeposito().doubleValue());
    qInsert.setDouble(GASTOS,pers.getGastos().doubleValue());
    qInsert.setDouble(NETO_DEPOSITO,pers.getNetoDeposito().doubleValue());
    qInsert.setInt(OID_CAJA, pers.getCaja().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_DEPOSITO = 1;
    final int CLEARING = 2;
    final int OID_CTA_BANCARIA = 3;
    final int OID_MONEDA = 4;
    final int COTIZACION = 5;
    final int MONTO_DEPOSITO = 6;
    final int GASTOS = 7;
    final int NETO_DEPOSITO = 8;
    final int OID_BOLETA_DEP = 9;
    final int OID_CAJA = 10;

    BoletaDeposito pers = (BoletaDeposito) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update vaBoletaDeposito set "+
              "fec_deposito=?"+ 
              ",clearing=?"+ 
              ",oid_cta_bancaria=?"+ 
              ",oid_moneda=?"+ 
              ",cotizacion=?"+
              ",monto_deposito=?"+
              ",gastos=?"+
              ",neto_deposito=?"+
              ",oid_caja=?"+
                 " where " +
                 " oid_boleta_dep=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BOLETA_DEP,pers.getOID());
    qUpdate.setDate(FEC_DEPOSITO,new java.sql.Date(pers.getFec_deposito().getTime()));
    qUpdate.setInt(CLEARING,pers.getClearing().intValue());
    qUpdate.setInt(OID_CTA_BANCARIA,pers.getCuenta_bancaria().getOID());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.setDouble(MONTO_DEPOSITO,pers.getMontoDeposito().doubleValue());
    qUpdate.setDouble(GASTOS,pers.getGastos().doubleValue());
    qUpdate.setDouble(NETO_DEPOSITO,pers.getNetoDeposito().doubleValue());
    qUpdate.setInt(OID_CAJA, pers.getCaja().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BOLETA_DEP = 1; 
    BoletaDeposito pers = (BoletaDeposito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaBoletaDeposito "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_boleta_dep=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BOLETA_DEP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_BOLETA_DEP = 1; 
    BoletaDeposito pers = (BoletaDeposito) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update vaBoletaDeposito "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_boleta_dep=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_BOLETA_DEP, pers.getOID()); 
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
      case SELECT_BY_HELP_BOLETA_DEPOSITO: {
        ps = this.selectByHelpBoletaDeposito(aCondiciones); 
        break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByHelpBoletaDeposito(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT a.*,b.* FROM  vaBoletaDeposito a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_boleta_dep = b.oid_cco  "); 
    
    
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
  
  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 
    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaBoletaDeposito a, geComproCab b "); 
    textSQL.append(" WHERE a.oid_boleta_dep=b.oid_cco and a.oid_boleta_dep  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  vaBoletaDeposito "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_boleta_dep oid, codigo,  descripcion ,activo ");
    textSQL.append(" from vaBoletaDeposito");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getHelpBoletasDeposito(
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
  	
  	return (List) ObjetoLogico.getObjects(BoletaDeposito.NICKNAME,
         DBBoletaDeposito.SELECT_BY_HELP_BOLETA_DEPOSITO,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  
} 
