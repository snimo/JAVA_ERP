package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.contabilidad.bm.ComproAperturaEjercicio;
import com.srn.erp.contabilidad.bm.ComproCierreEjercicio;
import com.srn.erp.contabilidad.bm.Ejercicio;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBComproAperturaEjercicio extends DBObjetoPersistente {

  public static final String OID_APERTURA_EJERCICIO = "oid_aper_ejer";
  public static final String OID_EJERCICIO = "oid_ejercicio";
  
  public static final int SELECT_BY_EJERCICIO = 100;

  public DBComproAperturaEjercicio() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_APERTURA_EJERCICIO = 1;
    final int OID_EJERCICIO = 2;

    ComproAperturaEjercicio pers = (ComproAperturaEjercicio) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgAperEjercicio "+
                     " ( "+
                      "OID_APER_EJER,"+
                      "OID_EJERCICIO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_APERTURA_EJERCICIO,pers.getOID());
    qInsert.setInt(OID_EJERCICIO,pers.getEjercicio().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EJERCICIO = 1;
    final int OID_APERTURA_EJERCICIO = 2;

    ComproAperturaEjercicio pers = (ComproAperturaEjercicio) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgAperEjercicio set "+
              "oid_ejercicio=? "+ 
                 " where " +
                 " oid_aper_ejer=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_APERTURA_EJERCICIO,pers.getOID());
    qUpdate.setInt(OID_EJERCICIO,pers.getEjercicio().getOID());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    ComproAperturaEjercicio pers = (ComproAperturaEjercicio) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update geComproCab " + " set activo=0 " + " where " + " oid_cco=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(1, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAperEjercicio a,  geComproCab b "); 
    textSQL.append(" WHERE a.oid_aper_ejer = b.oid_cco and a.oid_aper_ejer = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
    
  }
  
  private PreparedStatement selectByEjercicio(Object aCondiciones) throws BaseException, SQLException { 

	  	HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  	Ejercicio ejercicio = null;
	  	if (condiciones.containsKey(Ejercicio.NICKNAME))
	  		ejercicio = (Ejercicio) condiciones.get(Ejercicio.NICKNAME);
	  
		StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cgAperEjercicio a,  geComproCab b "); 
	    textSQL.append(" WHERE a.oid_aper_ejer = b.oid_cco ");
	    if (ejercicio!=null)
	    	textSQL.append(" and a.oid_ejercicio = "+ejercicio.getOID()); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAperturaEjercicio "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_aper_ejer oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgAperEjercicio");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getComprobantesAperturaEjercicio(Ejercicio ejercicio,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  if (ejercicio!=null)
		  condiciones.put(Ejercicio.NICKNAME, ejercicio);
	  
	  return (List) ObjetoLogico.getObjects(ComproAperturaEjercicio.NICKNAME,
             DBComproAperturaEjercicio.SELECT_BY_EJERCICIO,
             condiciones,
             new ListObserver(),
             aSesion);
  }
  
  
} 
