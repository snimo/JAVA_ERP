package com.srn.erp.cip.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.LogImpDatosCIP;
import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBLogImpDatosCIP extends DBObjetoPersistente {

  public static final String OID_LOG_IMP = "oid_log_imp";
  public static final String TIPO_IMP = "tipo_imp";
  public static final String FECHA = "fecha";
  public static final String HORA = "hora";
  public static final String SE_EJECUTO = "se_ejecuto";
  public static final String HUBO_ERROR = "hubo_error";
  public static final String MOT_NO_EJECUTO = "mot_no_ejecuto";
  public static final String OBSERVACION = "observacion";
  public static final String DESC_ERROR = "desc_error";
  public static final String ACTIVO = "activo";
  
  public static final int DELETE_LOGS_ANTIGUOS = 100;

  public DBLogImpDatosCIP() { 
  }
  
  public static void insLogs(
		  String tipoImportacion,
		  boolean seEjecuto,boolean huboError,
		  String motivoNoEjecuto,String observacion,String descError , ISesion aSesion) throws BaseException {
	  
	  LogImpDatosCIP logImpDatosCIP = (LogImpDatosCIP) LogImpDatosCIP.getNew(LogImpDatosCIP.NICKNAME, aSesion);
	  logImpDatosCIP.setTipo_imp(tipoImportacion);
	  
	  java.util.Date fechaHora = UtilCIP.getFechaHoraActual(aSesion);
	  
	  String horaMinSeg = Fecha.getFormatoHoraMinSeg(fechaHora);
	  java.util.Date fecTrunc = Fecha.getFechaTruncada(fechaHora);
	  
	  logImpDatosCIP.setFecha(fecTrunc);
	  logImpDatosCIP.setHora(horaMinSeg);
	  logImpDatosCIP.setSe_ejecuto(seEjecuto);
	  logImpDatosCIP.setHubo_error(huboError);
	  logImpDatosCIP.setMot_no_ejecuto(motivoNoEjecuto);
	  logImpDatosCIP.setObservacion(observacion);
	  logImpDatosCIP.setDesc_error(descError);
	  logImpDatosCIP.setActivo(true);
	  logImpDatosCIP.save();
	  
	  java.util.Date fecAntABorrar = Fecha.getFechaMasDias(fechaHora, -7);
	  
	  LogImpDatosCIP.borrarLogsAntiguos(fecAntABorrar, aSesion);
	  
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LOG_IMP = 1;
    final int TIPO_IMP = 2;
    final int FECHA = 3;
    final int HORA = 4;
    final int SE_EJECUTO = 5;
    final int HUBO_ERROR = 6;
    final int MOT_NO_EJECUTO = 7;
    final int OBSERVACION = 8;
    final int DESC_ERROR = 9;
    final int ACTIVO = 10;

    LogImpDatosCIP pers = (LogImpDatosCIP) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipLogImpDatos "+
                     " ( "+
                      "OID_LOG_IMP,"+
                      "TIPO_IMP,"+
                      "FECHA,"+
                      "HORA,"+
                      "SE_EJECUTO,"+
                      "HUBO_ERROR,"+
                      "MOT_NO_EJECUTO,"+
                      "OBSERVACION,"+
                      "DESC_ERROR,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LOG_IMP,pers.getOID());
    qInsert.setString(TIPO_IMP,pers.getTipo_imp());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(HORA,pers.getHora());
    qInsert.setBoolean(SE_EJECUTO,pers.isSe_ejecuto().booleanValue());
    qInsert.setBoolean(HUBO_ERROR,pers.isHubo_error().booleanValue());
    if (pers.getMot_no_ejecuto()!=null)
    	qInsert.setString(MOT_NO_EJECUTO,pers.getMot_no_ejecuto());
    else
    	qInsert.setString(MOT_NO_EJECUTO,"");
    if (pers.getObservacion()!=null)
    	qInsert.setString(OBSERVACION,pers.getObservacion());
    else
    	qInsert.setString(OBSERVACION,"");
    if (pers.getDesc_error()!=null)
    	qInsert.setString(DESC_ERROR,pers.getDesc_error());
    else
    	qInsert.setString(DESC_ERROR,"");
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int TIPO_IMP = 1;
    final int FECHA = 2;
    final int HORA = 3;
    final int SE_EJECUTO = 4;
    final int HUBO_ERROR = 5;
    final int MOT_NO_EJECUTO = 6;
    final int OBSERVACION = 7;
    final int DESC_ERROR = 8;
    final int ACTIVO = 9;
    final int OID_LOG_IMP = 10;

    LogImpDatosCIP pers = (LogImpDatosCIP) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipLogImpDatos set "+
              "tipo_imp=?"+ 
              ",fecha=?"+ 
              ",hora=?"+ 
              ",se_ejecuto=?"+ 
              ",hubo_error=?"+ 
              ",mot_no_ejecuto=?"+ 
              ",observacion=?"+ 
              ",desc_error=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_log_imp=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_IMP,pers.getOID());
    qUpdate.setString(TIPO_IMP,pers.getTipo_imp());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(HORA,pers.getHora());
    qUpdate.setBoolean(SE_EJECUTO,pers.isSe_ejecuto().booleanValue());
    qUpdate.setBoolean(HUBO_ERROR,pers.isHubo_error().booleanValue());
    if (pers.getMot_no_ejecuto()!=null)
    	qUpdate.setString(MOT_NO_EJECUTO,pers.getMot_no_ejecuto());
    else
    	qUpdate.setString(MOT_NO_EJECUTO,"");
    if (pers.getObservacion()!=null)
    	qUpdate.setString(OBSERVACION,pers.getObservacion());
    else
    	qUpdate.setString(OBSERVACION,"");
    if (pers.getDesc_error()!=null)
    	qUpdate.setString(DESC_ERROR,pers.getDesc_error());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_IMP = 1; 
    LogImpDatosCIP pers = (LogImpDatosCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipLogImpDatos "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_log_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_IMP, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_IMP = 1; 
    LogImpDatosCIP pers = (LogImpDatosCIP) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipLogImpDatos "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_log_imp=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_IMP, pers.getOID()); 
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
      case IDBObjetoPersistente.SELECT_ALL: { 
          ps = this.selectAll(aCondiciones); 
          break; 
        } 
      case DELETE_LOGS_ANTIGUOS : {
          ps = this.deleteLogsAntiguos(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LOG_IMP = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipLogImpDatos "); 
    textSQL.append(" WHERE oid_log_imp = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LOG_IMP, oid); 
    return querySelect; 
  }

  private PreparedStatement selectAll(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipLogImpDatos "); 
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipLogImpDatos "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_log_imp oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipLogImpDatos");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
	private PreparedStatement deleteLogsAntiguos(Object aCondiciones) throws BaseException, SQLException {
		java.util.Date fecha = (java.util.Date) aCondiciones;
		StringBuffer sqlUpdate = new StringBuffer();
		sqlUpdate.append("delete from cipLogImpDatos where " + " fecha <=? ");
		PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString());
		qUpdate.setDate(1, new java.sql.Date(fecha.getTime()));
		qUpdate.executeUpdate();
		qUpdate.close();
		return null;
		
	}
	
	public static void borrarLogsAntiguos(
			java.util.Date fecha,
		    ISesion aSesion)
		  throws BaseException {
		  	ObjetoLogico.getObjects(LogImpDatosCIP.NICKNAME,
			  				DBLogImpDatosCIP.DELETE_LOGS_ANTIGUOS,
			  				fecha,
			  				null,
			  				aSesion);
	}
  
	public static List getAll(ISesion aSesion) throws BaseException {
		  return (List) ObjetoLogico.getObjects(LogImpDatosCIP.NICKNAME,
                 DBLogImpDatosCIP.SELECT_ALL,
                 null,
                 new ListObserver(),
                 aSesion);
	}
	  
  
  
  
} 
