package com.srn.erp.contabilidad.da;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.AsientoManual;
import com.srn.erp.contabilidad.bm.CuentaImputable;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBAsientoManual extends DBObjetoPersistente {

  public static final String OID_CCO = "oid_cco";
  public static final String NO_CONTA_OTRAS_MON = "no_conta_otras_mon";
  public static final String OID_MONEDA = "oid_moneda";
  public static final String COTIZACION = "cotizacion";
  public static final String OID_TIPO_CAMBIO = "oid_tipo_cambio";
  
  public static final int SELECT_BY_HELP_ASI_MAN = 100; 

  public DBAsientoManual() {
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int OID_CCO = 1;
    final int NO_CONTA_OTRAS_MON = 2;
    final int OID_MONEDA = 3;
    final int COTIZACION = 4;
    final int OID_TIPO_CAMBIO = 5;

    AsientoManual pers = (AsientoManual) objetoPersistente;

    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgComproCabAsiMan "+
                     " ( "+
                      "OID_CCO,"+
                      "NO_CONTA_OTRAS_MON,"+
                      "OID_MONEDA,"+
                      "COTIZACION,"+
                      "OID_TIPO_CAMBIO)"+
                      " values "+
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString());
    qInsert.setInt(OID_CCO,pers.getOID());
    qInsert.setBoolean(NO_CONTA_OTRAS_MON,pers.getNoContaOtrasMonedas().booleanValue());
    qInsert.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qInsert.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qInsert.setInt(OID_TIPO_CAMBIO,pers.getTipoCambio().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {

    final int NO_CONTA_OTRAS_MON = 1;
    final int OID_MONEDA = 2;
    final int COTIZACION = 3;
    final int OID_TIPO_CAMBIO = 4;
    final int OID_CCO = 5;

    AsientoManual pers = (AsientoManual) objetoPersistente;

    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgComproCabAsiMan set "+
              "no_conta_otras_mon=?"+
              ",oid_moneda=?"+
              ",cotizacion=?"+
              ",oid_tipo_cambio=?"+
                 " where " +
                 " oid_cco=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO,pers.getOID());
    qUpdate.setBoolean(NO_CONTA_OTRAS_MON,pers.getNoContaOtrasMonedas().booleanValue());
    qUpdate.setInt(OID_MONEDA,pers.getMoneda().getOID());
    qUpdate.setDouble(COTIZACION,pers.getCotizacion().doubleValue());
    qUpdate.setInt(OID_TIPO_CAMBIO,pers.getTipoCambio().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    AsientoManual pers = (AsientoManual) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update geComproCab "+
                     " set activo=0 " +
                     " where " +
                     " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
    qUpdate.setInt(OID_CCO, pers.getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException {
    final int OID_CCO = 1;
    AsientoManual pers = (AsientoManual) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer();
    sqlUpdate.append("update cgComproCabAsiMan "+
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
      case IDBObjetoPersistente.SELECT_ALL_HELP: {
        ps = this.selectAllHelp(aCondiciones);
        break;
      }
      case SELECT_BY_HELP_ASI_MAN: {
        ps = this.selectByHelpAsiMan(aCondiciones);
        break;
      }
    }
    return ps;
  }

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException {

    final int OID_CCO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT b.*,a.no_conta_otras_mon,a.oid_moneda,a.cotizacion,a.oid_tipo_cambio FROM  cgComproCabAsiMan a, geComproCab b ");
    textSQL.append(" WHERE a.oid_cco = b.oid_cco and a.oid_cco = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    int oid = ( (Integer) aCondiciones).intValue();
    querySelect.setInt(OID_CCO, oid);
    return querySelect;
  }
  
  private PreparedStatement selectByHelpAsiMan(Object aCondiciones) throws BaseException, SQLException {

  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
  	int nroParams = 0;
  	
  	StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT a.*,b.* FROM  cgComproCabAsiMan a, geComproCab b ");
    textSQL.append(" WHERE a.oid_cco = b.oid_cco ");
    
    if (condiciones.containsKey("NRO_DESDE")) {
    	Integer nroDesde = condiciones.getInteger("NRO_DESDE");
    	textSQL.append(" and b.nro_ext>="+nroDesde.toString()); 
    }
    
    if (condiciones.containsKey("NRO_HASTA")) {
    	Integer nroHasta = condiciones.getInteger("NRO_HASTA");
    	textSQL.append(" and b.nro_ext<="+nroHasta.toString()); 
    }
    
    if (condiciones.containsKey(CuentaImputable.NICKNAME)) {
    	CuentaImputable cuenta = (CuentaImputable) condiciones.get(CuentaImputable.NICKNAME);
    	textSQL.append(" and a.oid_cco in (select oid_cco from cgComproDetAsiMan where oid_ai="+cuenta.getOIDInteger()+") "); 
    }

    java.util.Date fecDesde = null;
    if (condiciones.containsKey("FEC_DESDE")) { 
    	fecDesde = (java.util.Date)condiciones.get("FEC_DESDE");
    	textSQL.append(" and b.emision>=? ");
    }
    
    java.util.Date fecHasta = null;
    if (condiciones.containsKey("FEC_HASTA")) {
    	fecHasta = (java.util.Date)condiciones.get("FEC_HASTA");
    	textSQL.append(" and b.emision<=? ");
    }
    
    
    java.util.Date fecImputacDesde = null;
    if (condiciones.containsKey("FEC_IMPUTAC_DESDE")) { 
    	fecImputacDesde = (java.util.Date)condiciones.get("FEC_IMPUTAC_DESDE");
    	textSQL.append(" and b.imputac>=? ");
    }
    
    java.util.Date fecImputacHasta = null;
    if (condiciones.containsKey("FEC_IMPUTAC_HASTA")) { 
    	fecImputacHasta = (java.util.Date)condiciones.get("FEC_IMPUTAC_HASTA");
    	textSQL.append(" and b.imputac<=? ");
    }    
    
    
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    
    if (condiciones.containsKey("FEC_DESDE")) {
    	++nroParams;
    	querySelect.setDate(nroParams, new Date(fecDesde.getTime()));
    }
    	
    if (condiciones.containsKey("FEC_HASTA")) {
    	++nroParams;
    	querySelect.setDate(nroParams, new Date(fecHasta.getTime()));
    }
    
    if (condiciones.containsKey("FEC_IMPUTAC_DESDE")) {
    	++nroParams;
    	querySelect.setDate(nroParams, new Date(fecImputacDesde.getTime()));
    }
    
    if (condiciones.containsKey("FEC_IMPUTAC_HASTA")) {
    	++nroParams;
    	querySelect.setDate(nroParams, new Date(fecImputacHasta.getTime()));
    }    
    	
    
    
    return querySelect;
  }

  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException {

    final int CODIGO = 1;

    StringBuffer textSQL = new StringBuffer();
    textSQL.append("SELECT a.*,b.no_conta_otras_mon,b.oid_moneda,b.cotizacion,b.oid_tipo_cambio FROM  cgComproCabAsiMan a, geComproCab b ");
    textSQL.append(" WHERE a.oid_cco = b.oid_cco and b.nro_ext = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    String codigo = (String) aCondiciones;
    querySelect.setString(CODIGO, codigo);
    return querySelect;
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cco oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgComproCabAsiMan");

    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
    return querySelect;
  }
  
  public static List getAsientosByHelp(
  		Integer nroDesde,
  		Integer nroHasta,
  		java.util.Date fecDesde,
  		java.util.Date fecHasta,
  		java.util.Date fecImputacDesde,
  		java.util.Date fecImputacHasta,  		
  		CuentaImputable cuenta,
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
  	
  	if (fecImputacDesde!=null)
  		condiciones.put("FEC_IMPUTAC_DESDE",fecImputacDesde);
  	if (fecImputacHasta!=null)
  		condiciones.put("FEC_IMPUTAC_HASTA",fecImputacHasta);  	
  	
  	if (cuenta!=null)
  		condiciones.put(CuentaImputable.NICKNAME,cuenta);
  	
  	return (List) ObjetoLogico.getObjects(AsientoManual.NICKNAME,
         DBAsientoManual.SELECT_BY_HELP_ASI_MAN,
         condiciones,
         new ListObserver(),
         aSesion);
  }
  
  

}
