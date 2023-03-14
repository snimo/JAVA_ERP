package com.srn.erp.schedule.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.schedule.bm.ProgramarJobSchedule;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBProgramarJobSchedule extends DBObjetoPersistente {

  public static final String OID_PROG_JOB = "oid_prog_job";
  public static final String ORDEN = "orden";
  public static final String OID_JOB = "oid_job";
  public static final String OID_TRIGGER = "oid_trigger";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PROG_ACTIVA_ORDENADA = 100;

  public DBProgramarJobSchedule() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROG_JOB = 1;
    final int ORDEN = 2;
    final int OID_JOB = 3;
    final int OID_TRIGGER = 4;
    final int ACTIVO = 5;

    ProgramarJobSchedule pers = (ProgramarJobSchedule) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into scProgramarJob "+
                     " ( "+
                      "OID_PROG_JOB,"+
                      "ORDEN,"+
                      "OID_JOB,"+
                      "OID_TRIGGER,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PROG_JOB,pers.getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setInt(OID_JOB,pers.getJob().getOID());
    qInsert.setInt(OID_TRIGGER,pers.getTrigger().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int ORDEN = 1;
    final int OID_JOB = 2;
    final int OID_TRIGGER = 3;
    final int ACTIVO = 4;
    final int OID_PROG_JOB = 5;

    ProgramarJobSchedule pers = (ProgramarJobSchedule) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update scProgramarJob set "+
              "orden=?"+ 
              ",oid_job=?"+ 
              ",oid_trigger=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_prog_job=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROG_JOB,pers.getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setInt(OID_JOB,pers.getJob().getOID());
    qUpdate.setInt(OID_TRIGGER,pers.getTrigger().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROG_JOB = 1; 
    ProgramarJobSchedule pers = (ProgramarJobSchedule) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update scProgramarJob "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_prog_job=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROG_JOB, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROG_JOB = 1; 
    ProgramarJobSchedule pers = (ProgramarJobSchedule) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update scProgramarJob "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_prog_job=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROG_JOB, pers.getOID()); 
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
      case SELECT_BY_PROG_ACTIVA_ORDENADA: {
          ps = this.selectByProgActivaOrdenada(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROG_JOB = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  scProgramarJob "); 
    textSQL.append(" WHERE oid_prog_job = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROG_JOB, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByProgActivaOrdenada(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  scProgramarJob "); 
	    textSQL.append(" WHERE activo=1 order by orden ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  scProgramarJob "); 
    textSQL.append(" WHERE orden = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT a.oid_prog_job oid,b.descripcion codigo, c.descripcion descripcion ,a.activo ");
    textSQL.append(" from scProgramarJob a , scTrigger b , scJob c where a.oid_job=c.oid_job and a.oid_trigger=b.oid_trigger ");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getProgramacionActivo(ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ProgramarJobSchedule.NICKNAME,
             DBProgramarJobSchedule.SELECT_BY_PROG_ACTIVA_ORDENADA,
             null,
             new ListObserver(),
             aSesion);
  }
  
  
} 
