package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.EstadoCIP;
import com.srn.erp.cip.bm.PermisoInternoEstado;
import com.srn.erp.cip.bm.ReglasPermisosInt;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.da.DBPeriodo;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBPermisoInternoEstado extends DBObjetoPersistente {

  public static final String OID_PERM_INT_EST = "oid_perm_int_est";
  public static final String OID_REGLA_PERMISO = "oid_regla_permiso";
  public static final String OID_ESTADO_CIP = "oid_estado_cip";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_REGLA = 100;
  public static final int SELECT_BY_REGLA_ESTADO_ACTIVO = 101;

  public DBPermisoInternoEstado() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERM_INT_EST = 1;
    final int OID_REGLA_PERMISO = 2;
    final int OID_ESTADO_CIP = 3;
    final int ACTIVO = 4;

    PermisoInternoEstado pers = (PermisoInternoEstado) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipPermIntEst "+
                     " ( "+
                      "OID_PERM_INT_EST,"+
                      "OID_REGLA_PERMISO,"+
                      "OID_ESTADO_CIP,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PERM_INT_EST,pers.getOID());
    qInsert.setInt(OID_REGLA_PERMISO,pers.getRegla_permiso().getOID());
    qInsert.setInt(OID_ESTADO_CIP,pers.getEstado_cip().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_REGLA_PERMISO = 1;
    final int OID_ESTADO_CIP = 2;
    final int ACTIVO = 3;
    final int OID_PERM_INT_EST = 4;

    PermisoInternoEstado pers = (PermisoInternoEstado) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipPermIntEst set "+
              "oid_regla_permiso=?"+ 
              ",oid_estado_cip=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_perm_int_est=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_INT_EST,pers.getOID());
    qUpdate.setInt(OID_REGLA_PERMISO,pers.getRegla_permiso().getOID());
    qUpdate.setInt(OID_ESTADO_CIP,pers.getEstado_cip().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERM_INT_EST = 1; 
    PermisoInternoEstado pers = (PermisoInternoEstado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPermIntEst "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_perm_int_est=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_INT_EST, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PERM_INT_EST = 1; 
    PermisoInternoEstado pers = (PermisoInternoEstado) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipPermIntEst "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_perm_int_est=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PERM_INT_EST, pers.getOID()); 
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
      case SELECT_BY_REGLA: {
    	  ps = this.selectByRegla(aCondiciones); 
          break;    	  
      }
      case SELECT_BY_REGLA_ESTADO_ACTIVO: {
    	  ps = this.selectByReglaEstadoActivo(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PERM_INT_EST = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPermIntEst "); 
    textSQL.append(" WHERE oid_perm_int_est = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PERM_INT_EST, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByReglaEstadoActivo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPermIntEst "); 
	    textSQL.append(" WHERE oid_regla_permiso = ? and oid_estado_cip = ?  and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    ReglasPermisosInt regla = (ReglasPermisosInt) condiciones.get(ReglasPermisosInt.NICKNAME);
	    EstadoCIP estadoCIP = (EstadoCIP) condiciones.get(EstadoCIP.NICKNAME);
	    querySelect.setInt(1, regla.getOID()); 
	    querySelect.setInt(2, estadoCIP.getOID());
	    return querySelect; 
}  
  
  private PreparedStatement selectByRegla(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipPermIntEst "); 
	    textSQL.append(" WHERE oid_regla_permiso = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    ReglasPermisosInt regla = (ReglasPermisosInt) aCondiciones;
	    querySelect.setInt(1, regla.getOID()); 
	    return querySelect; 
  }  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipPermIntEst "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_perm_int_est oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipPermIntEst");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getPermisoInternosEstado(
		  ReglasPermisosInt regla,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(PermisoInternoEstado.NICKNAME,
             DBPermisoInternoEstado.SELECT_BY_REGLA,
             regla,
             new ListObserver(),
             aSesion);
  }
  
  public static PermisoInternoEstado getPermisoInternoEstado(
		  ReglasPermisosInt regla,
		  EstadoCIP estado,
          ISesion aSesion)
          throws BaseException {
	  
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(ReglasPermisosInt.NICKNAME, regla);
	  condiciones.put(EstadoCIP.NICKNAME, estado);
	  return (PermisoInternoEstado) ObjetoLogico.getObjects(PermisoInternoEstado.NICKNAME,
			  				DBPermisoInternoEstado.SELECT_BY_REGLA_ESTADO_ACTIVO,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }  
  
} 
