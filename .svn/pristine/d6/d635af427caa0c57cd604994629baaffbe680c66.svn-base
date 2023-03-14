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

public class DBPermisoInternoLegajo extends DBObjetoPersistente {

  public static final String OID_PERM_INT_LEG = "oid_perm_int_leg";
  public static final String OID_REGLA_PERMISO = "oid_regla_permiso";
  public static final String OID_LEGAJO = "oid_legajo";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_REGLA_PERMISO = 100;

  public DBPermisoInternoLegajo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERM_INT_LEG = 1;
    final int OID_REGLA_PERMISO = 2;
    final int OID_LEGAJO = 3;
    final int ACTIVO = 4;

    PermisoInternoLegajo pers = (PermisoInternoLegajo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipPermIntLeg "+
                     " ( "+
                      "OID_PERM_INT_LEG,"+
                      "OID_REGLA_PERMISO,"+
                      "OID_LEGAJO,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PERM_INT_LEG,pers.getOID());
    qInsert.setInt(OID_REGLA_PERMISO,pers.getRegla_permiso().getOID());
    qInsert.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REGLA_PERMISO = 1;
    final int OID_LEGAJO = 2;
    final int ACTIVO = 3;
    final int OID_PERM_INT_LEG = 4;

    PermisoInternoLegajo pers = (PermisoInternoLegajo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipPermIntLeg set "+
              "oid_regla_permiso=?"+ 
              ",oid_legajo=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_perm_int_leg=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_INT_LEG,pers.getOID());
    qUpdate.setInt(OID_REGLA_PERMISO,pers.getRegla_permiso().getOID());
    qUpdate.setInt(OID_LEGAJO,pers.getLegajo().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERM_INT_LEG = 1; 
    PermisoInternoLegajo pers = (PermisoInternoLegajo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPermIntLeg "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_perm_int_leg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_INT_LEG, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERM_INT_LEG = 1; 
    PermisoInternoLegajo pers = (PermisoInternoLegajo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPermIntLeg "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_perm_int_leg=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_INT_LEG, pers.getOID()); 
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
      case SELECT_BY_REGLA_PERMISO: {
          ps = this.selectByReglaPermiso(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PERM_INT_LEG = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPermIntLeg "); 
    textSQL.append(" WHERE oid_perm_int_leg = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PERM_INT_LEG, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByReglaPermiso(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPermIntLeg "); 
	    textSQL.append(" WHERE oid_regla_permiso = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    ReglasPermisosInt reglaPermiso = (ReglasPermisosInt) aCondiciones;
	    querySelect.setInt(1, reglaPermiso.getOID()); 
	    return querySelect;
  }  
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPermIntLeg "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_perm_int_leg oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipPermIntLeg");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPermisosInternosLegajos(
		  ReglasPermisosInt reglasPermisosInt,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(PermisoInternoLegajo.NICKNAME,
			  DBPermisoInternoLegajo.SELECT_BY_REGLA_PERMISO,
			  reglasPermisosInt,
			  new ListObserver(),
			  aSesion);
  }  
  
} 
