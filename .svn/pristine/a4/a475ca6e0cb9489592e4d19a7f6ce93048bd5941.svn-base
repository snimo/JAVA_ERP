package com.srn.erp.contabilidad.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.srn.erp.contabilidad.bm.AnuladorComproCierreEjercicio;

import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.request.bl.Utils.BaseException;

public class DBAnuladorComproCierreEjercicio extends DBObjetoPersistente {

  public static final String OID_ANU_COMPRO_CIERRE_EJER = "oid_anu_cierre";
  public static final String OID_CIERRE_EJERCICIO = "oid_cierre_ejercicio";

  public DBAnuladorComproCierreEjercicio() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ANU_COMPRO_CIERRE_EJER = 1;
    final int OID_CIERRE_EJERCICIO = 2;

    AnuladorComproCierreEjercicio pers = (AnuladorComproCierreEjercicio) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cgAnuCierreEjer "+
                     " ( "+
                      "oid_anu_cierre,"+
                      "oid_cierre_ejercicio)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_ANU_COMPRO_CIERRE_EJER,pers.getOID());
    qInsert.setInt(OID_CIERRE_EJERCICIO,pers.getComproCierreEjericicio().getOID());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

	
	final int OID_CIERRE_EJERCICIO = 1;
	final int OID_ANU_COMPRO_CIERRE_EJER = 2;
	    

	AnuladorComproCierreEjercicio pers = (AnuladorComproCierreEjercicio) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cgAnuCierreEjer set "+
              "oid_cierre_ejercicio=?"+ 
                 " where " +
                 " oid_anu_cierre=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_ANU_COMPRO_CIERRE_EJER,pers.getOID());
    qUpdate.setInt(OID_CIERRE_EJERCICIO,pers.getComproCierreEjericicio().getOID());
    qUpdate.executeUpdate();
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("delete from cgAnuCierreEjer "+
                     " where 1=2");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAnuCierreEjer "); 
    textSQL.append(" WHERE oid_anu_cierre = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(1, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cgAnuCierreEjer "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_anu_cierre oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cgAnuCierreEjer ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
