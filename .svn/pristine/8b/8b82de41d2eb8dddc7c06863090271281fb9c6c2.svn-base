package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.CacheoPersona;
import com.srn.erp.cip.bm.PersonalSeguridad;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.sueldos.bm.Legajo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;

public class DBCacheoPersona extends DBObjetoPersistente {

  public static final String OID_CACHEO_PERS = "oid_cacheo_pers";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String FECHA = "fecha";
  public static final String HORA = "hora";
  public static final String OBSERVACION = "observacion";
  public static final String ACTIVO = "activo";
  public static final String OID_PERS_SEGU = "oid_pers_segu";
  public static final String OID_EST_RES_CACHEO = "oid_est_res_cacheo";
  
  public static final int SELECT_BY_CONDICIONES = 100;

  public DBCacheoPersona() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CACHEO_PERS = 1;
    final int OID_LEGAJO = 2;
    final int FECHA = 3;
    final int HORA = 4;
    final int OBSERVACION = 5;
    final int ACTIVO = 6;
    final int OID_PERS_SEGU = 7;
    final int OID_EST_RES_CACHEO = 8;

    CacheoPersona pers = (CacheoPersona) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipCacheoPers "+
                     " ( "+
                      "OID_CACHEO_PERS,"+
                      "OID_LEGAJO,"+
                      "FECHA,"+
                      "HORA,"+
                      "OBSERVACION,"+
                      "ACTIVO,OID_PERS_SEGU,oid_est_res_cacheo)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CACHEO_PERS,pers.getOID());
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(HORA,pers.getHora());
    qInsert.setString(OBSERVACION,pers.getObservacion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setInt(OID_PERS_SEGU, pers.getPersonalSeguridad().getOID());
    if (pers.getResultadoCacheo()!=null)
    	qInsert.setInt(OID_EST_RES_CACHEO, pers.getResultadoCacheo().getOID());
    else
    	qInsert.setNull(OID_EST_RES_CACHEO, java.sql.Types.INTEGER);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LEGAJO = 1;
    final int FECHA = 2;
    final int HORA = 3;
    final int OBSERVACION = 4;
    final int ACTIVO = 5;
    final int OID_PERS_SEGU = 6;
    final int OID_EST_RES_CACHEO = 7;
    final int OID_CACHEO_PERS = 8;

    CacheoPersona pers = (CacheoPersona) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipCacheoPers set "+
              "oid_legajo=?"+ 
              ",fecha=?"+ 
              ",hora=?"+ 
              ",observacion=?"+ 
              ",activo=? , oid_pers_segu=? , oid_est_res_cacheo = ? "+ 
                 " where " +
                 " oid_cacheo_pers=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CACHEO_PERS,pers.getOID());
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(HORA,pers.getHora());
    qUpdate.setString(OBSERVACION,pers.getObservacion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setInt(OID_PERS_SEGU, pers.getPersonalSeguridad().getOID());
    if (pers.getResultadoCacheo()!=null)
    	qUpdate.setInt(OID_EST_RES_CACHEO, pers.getResultadoCacheo().getOID());
    else
    	qUpdate.setNull(OID_EST_RES_CACHEO, java.sql.Types.INTEGER);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CACHEO_PERS = 1; 
    CacheoPersona pers = (CacheoPersona) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCacheoPers "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cacheo_pers=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CACHEO_PERS, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CACHEO_PERS = 1; 
    CacheoPersona pers = (CacheoPersona) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipCacheoPers "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cacheo_pers=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CACHEO_PERS, pers.getOID()); 
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
      case SELECT_BY_CONDICIONES: {
          ps = this.selectByCondiciones(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CACHEO_PERS = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCacheoPers "); 
    textSQL.append(" WHERE oid_cacheo_pers = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CACHEO_PERS, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByCondiciones(Object aCondiciones) throws BaseException, SQLException { 
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones; 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipCacheoPers "); 
	    textSQL.append(" WHERE  activo = 1 and fecha>=? and fecha<=? ");
	     
	    java.util.Date fecDesde = (java.util.Date) condiciones.get("fec_desde");
	    java.util.Date fecHasta = (java.util.Date) condiciones.get("fec_hasta");
	    Legajo legajo = (Legajo) condiciones.get(Legajo.NICKNAME);
	    PersonalSeguridad personalSeguridad =
	    	(PersonalSeguridad) condiciones.get(PersonalSeguridad.NICKNAME);
	    if (legajo!=null)
	    	textSQL.append(" and oid_legajo="+legajo.getOIDInteger());
	    if (personalSeguridad!=null)
	    	textSQL.append(" and oid_pers_segu="+personalSeguridad.getOIDInteger());
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setDate(2, new java.sql.Date(fecHasta.getTime()));
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipCacheoPers "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cacheo_pers oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipCacheoPers");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getCacheosPersonas(
		  java.util.Date fechaDesde,
		  java.util.Date fechaHasta,
		  Legajo legajo,
		  PersonalSeguridad personalSeguridad,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put("fec_desde", fechaDesde);
	  condiciones.put("fec_hasta", fechaHasta);
	  if (legajo!=null)
		  condiciones.put(Legajo.NICKNAME, legajo);
	  if (personalSeguridad!=null)
		  condiciones.put(PersonalSeguridad.NICKNAME, personalSeguridad);
	  return (List) ObjetoLogico.getObjects(CacheoPersona.NICKNAME,
             DBCacheoPersona.SELECT_BY_CONDICIONES,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
} 
