package com.srn.erp.turnos.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.turnos.bm.*;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBLogImpSujTurno extends DBObjetoPersistente {

  public static final String OID = "oid";
  public static final String DESCRIPCION = "descripcion";
  public static final String FECHA = "fecha";
  
  public static final int SELECT_BY_FECHA = 100;
  public static final int DELETE_BY_FECHA = 101;
  public static final int SELECT_ULTIMA_FECHA = 102;
  

  public DBLogImpSujTurno() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID = 1;
    final int DESCRIPCION = 2;
    final int FECHA = 3;

    LogImpSujTurno pers = (LogImpSujTurno) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into veLogImpSuj "+
                     " ( "+
                      "OID,"+
                      "DESCRIPCION,"+
                      "FECHA)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID,pers.getOID());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int DESCRIPCION = 1;
    final int FECHA = 2;
    final int OID = 3;

    LogImpSujTurno pers = (LogImpSujTurno) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update veLogImpSuj set "+
              "descripcion=?"+ 
              ",fecha=?"+ 
                 " where " +
                 " oid=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID,pers.getOID());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  
  protected void deleteByFecha(Object aCondiciones) throws BaseException, SQLException { 
	java.util.Date fecha = (java.util.Date) aCondiciones;
	StringBuffer sqlUpdate = new StringBuffer(); 
	sqlUpdate.append("delete from veLogImpSuj "+
			                     " where " + 
			                     " fecha=? ");
	PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
	qUpdate.setDate(1, new java.sql.Date(fecha.getTime())); 
	qUpdate.executeUpdate();
	qUpdate.close();
  } 
		  
  
  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID = 1; 
    LogImpSujTurno pers = (LogImpSujTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veLogImpSuj "+
                     " set activo=0 " + 
                     " where " + 
                     " oid=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID = 1; 
    LogImpSujTurno pers = (LogImpSujTurno) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update veLogImpSuj "+
                     " set activo=1 " + 
                     " where " + 
                     " oid=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID, pers.getOID()); 
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
      case SELECT_BY_FECHA: {
          ps = this.selectByFecha(aCondiciones); 
          break; 
      }
      case DELETE_BY_FECHA: {
          this.deleteByFecha(aCondiciones); 
          break; 
      }
      case SELECT_ULTIMA_FECHA : {
          ps = this.selectByUltimaFecha(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veLogImpSuj "); 
    textSQL.append(" WHERE oid = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByFecha(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  veLogImpSuj "); 
	    textSQL.append(" WHERE fecha = ? order by oid ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    java.util.Date fecha = (java.util.Date) aCondiciones; 
	    querySelect.setDate(1, new java.sql.Date(fecha.getTime())); 
	    return querySelect; 
	  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  veLogImpSuj "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }
  
  private PreparedStatement selectByUltimaFecha(Object aCondiciones) throws BaseException, SQLException { 
	  StringBuffer textSQL = new StringBuffer(); 
	  textSQL.append("SELECT * FROM  veLogImpSuj "); 
	  textSQL.append(" WHERE fecha = (select max(fecha) from veLogImpSuj) ");
	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	  return querySelect; 
  }
  
  
  

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid oid, codigo,  descripcion ,activo ");
    textSQL.append(" from veLogImpSuj");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getLogs(java.util.Date aFecha,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(LogImpSujTurno.NICKNAME,
             DBLogImpSujTurno.SELECT_BY_FECHA,
             aFecha,
             new ListObserver(),
             aSesion);
  }
  
  public static List getLogsUltimaCorrida(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(LogImpSujTurno.NICKNAME,
             DBLogImpSujTurno.SELECT_ULTIMA_FECHA,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
  public static void borrarLogs(java.util.Date aFecha,
          ISesion aSesion) throws BaseException {
	  ObjetoLogico.getObjects(LogImpSujTurno.NICKNAME,
             DBLogImpSujTurno.DELETE_BY_FECHA,
             aFecha,
             new ListObserver(),
             aSesion);
  }
  
  
} 
