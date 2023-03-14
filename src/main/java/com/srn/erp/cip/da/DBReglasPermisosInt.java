package com.srn.erp.cip.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBReglasPermisosInt extends DBObjetoPersistente {

  public static final String OID_REGLA_PERMISO = "oid_regla_permiso";
  public static final String OID_PERMISO_INT = "oid_permiso_int";
  public static final String PRIORIDAD = "prioridad";
  public static final String DESCRIPCION = "descripcion";
  public static final String ES_UNA_VISTA = "es_una_vista";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PERMISO_INT = 100;

  public DBReglasPermisosInt() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REGLA_PERMISO = 1;
    final int OID_PERMISO_INT = 2;
    final int PRIORIDAD = 3;
    final int DESCRIPCION = 4;
    final int ES_UNA_VISTA = 5;
    final int ACTIVO = 6;

    ReglasPermisosInt pers = (ReglasPermisosInt) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipReglasPermisos "+
                     " ( "+
                      "OID_REGLA_PERMISO,"+
                      "OID_PERMISO_INT,"+
                      "PRIORIDAD,"+
                      "DESCRIPCION,"+
                      "ES_UNA_VISTA,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_REGLA_PERMISO,pers.getOID());
    qInsert.setInt(OID_PERMISO_INT,pers.getPermisosinternos().getOID());
    qInsert.setInt(PRIORIDAD,pers.getPrioridad().intValue());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(ES_UNA_VISTA,pers.isEs_una_vista().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERMISO_INT = 1;
    final int PRIORIDAD = 2;
    final int DESCRIPCION = 3;
    final int ES_UNA_VISTA = 4;
    final int ACTIVO = 5;
    final int OID_REGLA_PERMISO = 6;

    ReglasPermisosInt pers = (ReglasPermisosInt) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipReglasPermisos set "+
              "oid_permiso_int=?"+ 
              ",prioridad=?"+ 
              ",descripcion=?"+ 
              ",es_una_vista=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_regla_permiso=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REGLA_PERMISO,pers.getOID());
    qUpdate.setInt(OID_PERMISO_INT,pers.getPermisosinternos().getOID());
    qUpdate.setInt(PRIORIDAD,pers.getPrioridad().intValue());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(ES_UNA_VISTA,pers.isEs_una_vista().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REGLA_PERMISO = 1; 
    ReglasPermisosInt pers = (ReglasPermisosInt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipReglasPermisos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_regla_permiso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REGLA_PERMISO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_REGLA_PERMISO = 1; 
    ReglasPermisosInt pers = (ReglasPermisosInt) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipReglasPermisos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_regla_permiso=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_REGLA_PERMISO, pers.getOID()); 
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
      case SELECT_BY_PERMISO_INT: {
          ps = this.selectByPermisoInt(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_REGLA_PERMISO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipReglasPermisos "); 
    textSQL.append(" WHERE oid_regla_permiso = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_REGLA_PERMISO, oid); 
    return querySelect; 
  }
  
  
  private PreparedStatement selectByPermisoInt(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipReglasPermisos "); 
	    textSQL.append(" WHERE oid_permiso_int = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    PermisosInternos permisosInternos = (PermisosInternos) aCondiciones; 
	    querySelect.setInt(1, permisosInternos.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipReglasPermisos "); 
    textSQL.append(" WHERE oid_permiso_int = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_regla_permiso oid,oid_permiso_int codigo,  descripcion ,activo ");
    textSQL.append(" from cipReglasPermisos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getReglasPermisosInt(
		  PermisosInternos permisos,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ReglasPermisosInt.NICKNAME,
             DBReglasPermisosInt.SELECT_BY_PERMISO_INT,
             permisos,
             new ListObserver(),
             aSesion);
  }  
  
} 
