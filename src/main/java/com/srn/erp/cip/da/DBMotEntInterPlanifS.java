package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.MotEntInterPlanifS;
import com.srn.erp.cip.bm.MotivoEntIntermedias;
import com.srn.erp.cip.bm.PermisoSemanalCIP;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBMotEntInterPlanifS extends DBObjetoPersistente {

  public static final String OID_PSEM_ENT_INT = "oid_psem_ent_int";
  public static final String OID_PERM_SEMANAL = "oid_perm_semanal";
  public static final String OID_MOTIVO = "oid_motivo";
  public static final String DIA = "dia";
  public static final String ACTIVO = "activo";
  public static final String HORARIO_DESDE = "horario_desde";
  public static final String HORARIO_HASTA = "horario_hasta";
  public static final String ASIGNACION = "asignacion";
  
  public static final int SELECT_BY_PERMISO_SEMANAL = 100;
  public static final int SELECT_BY_PERMISO_MOTIVO_DIA = 101;
  public static final int SELECT_BY_PERM_SEMANAL_DIA = 102;

  public DBMotEntInterPlanifS() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PSEM_ENT_INT = 1;
    final int OID_PERM_SEMANAL = 2;
    final int OID_MOTIVO = 3;
    final int DIA = 4;
    final int ACTIVO = 5;
    final int HORARIO_DESDE = 6;
    final int HORARIO_HASTA = 7;
    final int ASIGNACION = 8;

    MotEntInterPlanifS pers = (MotEntInterPlanifS) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipMotEntInterPSem "+
                     " ( "+
                      "OID_PSEM_ENT_INT,"+
                      "OID_PERM_SEMANAL,"+
                      "OID_MOTIVO,"+
                      "DIA,"+
                      "ACTIVO,"+
                      "HORARIO_DESDE,"+
                      "HORARIO_HASTA,"+
                      "ASIGNACION)"+ 
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
    qInsert.setInt(OID_PSEM_ENT_INT,pers.getOID());
    qInsert.setInt(OID_PERM_SEMANAL,pers.getPermiso_semanal().getOID());
    qInsert.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qInsert.setString(DIA,pers.getDia());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.setString(HORARIO_DESDE,pers.getHorario_desde());
    qInsert.setString(HORARIO_HASTA,pers.getHorario_hasta());
    qInsert.setString(ASIGNACION,pers.getAsignacion());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PERM_SEMANAL = 1;
    final int OID_MOTIVO = 2;
    final int DIA = 3;
    final int ACTIVO = 4;
    final int HORARIO_DESDE = 5;
    final int HORARIO_HASTA = 6;
    final int ASIGNACION = 7;
    final int OID_PSEM_ENT_INT = 8;

    MotEntInterPlanifS pers = (MotEntInterPlanifS) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipMotEntInterPSem set "+
              "oid_perm_semanal=?"+ 
              ",oid_motivo=?"+ 
              ",dia=?"+ 
              ",activo=?"+ 
              ",horario_desde=?"+ 
              ",horario_hasta=?"+ 
              ",asignacion=?"+ 
                 " where " +
                 " oid_psem_ent_int=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PSEM_ENT_INT,pers.getOID());
    qUpdate.setInt(OID_PERM_SEMANAL,pers.getPermiso_semanal().getOID());
    qUpdate.setInt(OID_MOTIVO,pers.getMotivo().getOID());
    qUpdate.setString(DIA,pers.getDia());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.setString(HORARIO_DESDE,pers.getHorario_desde());
    qUpdate.setString(HORARIO_HASTA,pers.getHorario_hasta());
    qUpdate.setString(ASIGNACION,pers.getAsignacion());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PSEM_ENT_INT = 1; 
    MotEntInterPlanifS pers = (MotEntInterPlanifS) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntInterPSem "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_psem_ent_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PSEM_ENT_INT, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PSEM_ENT_INT = 1; 
    MotEntInterPlanifS pers = (MotEntInterPlanifS) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipMotEntInterPSem "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_psem_ent_int=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PSEM_ENT_INT, pers.getOID()); 
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
      case SELECT_BY_PERMISO_SEMANAL: {
          ps = this.selectByPermisoSemanal(aCondiciones); 
          break; 
      }
      case SELECT_BY_PERMISO_MOTIVO_DIA: {
          ps = this.selectByPermisoMotivoDia(aCondiciones); 
          break; 
      }
      case SELECT_BY_PERM_SEMANAL_DIA: {
          ps = this.selectByPermisoSemanalDia(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PSEM_ENT_INT = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntInterPSem "); 
    textSQL.append(" WHERE oid_psem_ent_int = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PSEM_ENT_INT, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByPermisoSemanalDia(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntInterPSem "); 
	    textSQL.append(" WHERE oid_perm_semanal = ? and dia = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    PermisoSemanalCIP permisoSemanalCIP = (PermisoSemanalCIP) condiciones.get(PermisoSemanalCIP.NICKNAME);
	    String dia = (String) condiciones.get("DIA");
	    querySelect.setInt(1, permisoSemanalCIP.getOID());
	    querySelect.setString(2, dia);
	    return querySelect; 
}	
  
  
  

  
  
  private PreparedStatement selectByPermisoMotivoDia(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntInterPSem "); 
	    textSQL.append(" WHERE oid_perm_semanal = ? and oid_motivo = ? and dia = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    PermisoSemanalCIP permisoSemanalCIP = (PermisoSemanalCIP) condiciones.get(PermisoSemanalCIP.NICKNAME);
	    MotivoEntIntermedias motivo = (MotivoEntIntermedias) condiciones.get(MotivoEntIntermedias.NICKNAME);
	    String dia = (String) condiciones.get("DIA");
	    querySelect.setInt(1, permisoSemanalCIP.getOID());
	    querySelect.setInt(2, motivo.getOID());
	    querySelect.setString(3, dia);
	    return querySelect; 
  }	

  private PreparedStatement selectByPermisoSemanal(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipMotEntInterPSem "); 
	    textSQL.append(" WHERE oid_perm_semanal = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    PermisoSemanalCIP permiso = (PermisoSemanalCIP) aCondiciones; 
	    querySelect.setInt(1, permiso.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipMotEntInterPSem "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_psem_ent_int oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipMotEntInterPSem");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static MotEntInterPlanifS getMotEntInterPlanifS(
		  PermisoSemanalCIP permiso,
		  MotivoEntIntermedias motivo,
		  String diaSemana,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(PermisoSemanalCIP.NICKNAME, permiso);
	  condiciones.put(MotivoEntIntermedias.NICKNAME, motivo);
	  condiciones.put("DIA", diaSemana);
	  
	  return (MotEntInterPlanifS) ObjetoLogico.getObjects(MotEntInterPlanifS.NICKNAME,
			  				DBMotEntInterPlanifS.SELECT_BY_PERMISO_MOTIVO_DIA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  public static List getMotEntInterPlanifS(
		  PermisoSemanalCIP permiso,
		  String diaSemana,
          ISesion aSesion) throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(PermisoSemanalCIP.NICKNAME, permiso);
	  condiciones.put("DIA", diaSemana);
	  return (List) ObjetoLogico.getObjects(MotEntInterPlanifS.NICKNAME,
             DBMotEntInterPlanifS.SELECT_BY_PERM_SEMANAL_DIA,
             condiciones,
             new ListObserver(),
             aSesion);
  }

  
  public static List getMotEntInterPlanifS(
		  PermisoSemanalCIP permiso,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(MotEntInterPlanifS.NICKNAME,
             DBMotEntInterPlanifS.SELECT_BY_PERMISO_SEMANAL,
             permiso,
             new ListObserver(),
             aSesion);
  }
  
  
} 
