package com.srn.erp.contabilidad.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.contabilidad.bm.*;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBComproCierreEjercicio extends DBObjetoPersistente {

  public static final String OID_CIERRE_EJERCICIO = "oid_cierre_ejercicio";
  public static final String OID_EJERCICIO = "oid_ejercicio";
  public static final String CIERRE_DE = "cierre_de";
  
  public static final int SELECT_BY_EJERCICIO = 100;
  public static final int SELECT_BY_EJERCICIO_PATRI = 101;

  public DBComproCierreEjercicio() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_CIERRE_EJERCICIO = 1;
    final int OID_EJERCICIO = 2;
    final int CIERRE_DE = 3;

    ComproCierreEjercicio pers = (ComproCierreEjercicio) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgCierreEjercicio "+
                     " ( "+
                      "OID_CIERRE_EJERCICIO,"+
                      "OID_EJERCICIO, CIERRE_DE)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_CIERRE_EJERCICIO,pers.getOID());
    qInsert.setInt(OID_EJERCICIO,pers.getEjercicio().getOID());
    qInsert.setString(CIERRE_DE,pers.getCierreDe());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EJERCICIO = 1;
    final int CIERRE_DE = 2;
    final int OID_CIERRE_EJERCICIO = 3;

    ComproCierreEjercicio pers = (ComproCierreEjercicio) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgCierreEjercicio set "+
              "oid_ejercicio=?,cierre_de=?"+ 
                 " where " +
                 " oid_cierre_ejercicio=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CIERRE_EJERCICIO,pers.getOID());
    qUpdate.setInt(OID_EJERCICIO,pers.getEjercicio().getOID());
    qUpdate.setString(CIERRE_DE,pers.getCierreDe());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CIERRE_EJERCICIO = 1; 
    ComproCierreEjercicio pers = (ComproCierreEjercicio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CIERRE_EJERCICIO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_CIERRE_EJERCICIO = 1; 
    ComproCierreEjercicio pers = (ComproCierreEjercicio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cgCierreEjercicio "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cierre_ejercicio=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_CIERRE_EJERCICIO, pers.getOID()); 
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
      case SELECT_BY_EJERCICIO: {
          ps = this.selectByEjercicio(aCondiciones); 
          break; 
      }
      case SELECT_BY_EJERCICIO_PATRI: {
          ps = this.selectByEjercicioPatrimonial(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_CIERRE_EJERCICIO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgCierreEjercicio a,  geComproCab b "); 
    textSQL.append(" WHERE a.oid_cierre_ejercicio = b.oid_cco and a.oid_cierre_ejercicio = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_CIERRE_EJERCICIO, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEjercicio(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	Ejercicio ejercicio = null;
	  	if (condiciones.containsKey(Ejercicio.NICKNAME)) 
	  		ejercicio = (Ejercicio) condiciones.get(Ejercicio.NICKNAME);
	  
		StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgCierreEjercicio a,  geComproCab b "); 
	    textSQL.append(" WHERE a.oid_cierre_ejercicio = b.oid_cco ");
	    if (ejercicio!=null)
	    	textSQL.append(" and a.oid_ejercicio = "+ejercicio.getOID()); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByEjercicioPatrimonial(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	Ejercicio ejercicio = (Ejercicio) condiciones.get(Ejercicio.NICKNAME);
		StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgCierreEjercicio a,  geComproCab b "); 
	    textSQL.append(" WHERE a.oid_cierre_ejercicio = b.oid_cco ");
	    textSQL.append(" and a.oid_ejercicio = "+ejercicio.getOID());
	    textSQL.append(" and b.activo=1 and a.cierre_de='PATRI' ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgCierreEjercicio "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cierre_ejercicio oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgCierreEjercicio");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getComprobantesCierreEjercicio(Ejercicio ejercicio,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (ejercicio!=null)
		  condiciones.put(Ejercicio.NICKNAME, ejercicio);
	  
	  return (List) ObjetoLogico.getObjects(ComproCierreEjercicio.NICKNAME,
             DBComproCierreEjercicio.SELECT_BY_EJERCICIO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  public static ComproCierreEjercicio getComproCierrePatrimonial(Ejercicio ejercicio,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(Ejercicio.NICKNAME, ejercicio);
	  return (ComproCierreEjercicio) ObjetoLogico.getObjects(ComproCierreEjercicio.NICKNAME,
			  				DBComproCierreEjercicio.SELECT_BY_EJERCICIO_PATRI,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
