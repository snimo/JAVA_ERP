package com.srn.erp.excluidos.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.cip.bm.UtilCIP;
import com.srn.erp.excluidos.bm.DispMovilExc;
import com.srn.erp.excluidos.bm.LogSincroExcluido;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.Fecha;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBLogSincroExcluido extends DBObjetoPersistente {

  public static final String OID_LOG_SINCRO = "oid_log_sincro";
  public static final String OID_DISP_MOVIL = "oid_disp_movil";
  public static final String FECHA = "fecha";
  public static final String HORA = "hora";
  public static final String OID_GRUPO_IMP_EXC = "oid_grupo_imp_exc";
  public static final String NRO_LOTE = "nro_lote";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_LOGS_ULT_30_DIAS = 100;

  public DBLogSincroExcluido() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_LOG_SINCRO = 1;
    final int OID_DISP_MOVIL = 2;
    final int FECHA = 3;
    final int HORA = 4;
    final int OID_GRUPO_IMP_EXC = 5;
    final int NRO_LOTE = 6;
    final int ACTIVO = 7;

    LogSincroExcluido pers = (LogSincroExcluido) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into excLogsSincro "+
                     " ( "+
                      "OID_LOG_SINCRO,"+
                      "OID_DISP_MOVIL,"+
                      "FECHA,"+
                      "HORA,"+
                      "OID_GRUPO_IMP_EXC,"+
                      "NRO_LOTE,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_LOG_SINCRO,pers.getOID());
    qInsert.setInt(OID_DISP_MOVIL,pers.getDisp_movil().getOID());
    qInsert.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qInsert.setString(HORA,pers.getHora());
    qInsert.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_exc().getOID());
    qInsert.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_DISP_MOVIL = 1;
    final int FECHA = 2;
    final int HORA = 3;
    final int OID_GRUPO_IMP_EXC = 4;
    final int NRO_LOTE = 5;
    final int ACTIVO = 6;
    final int OID_LOG_SINCRO = 7;

    LogSincroExcluido pers = (LogSincroExcluido) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update excLogsSincro set "+
              "oid_disp_movil=?"+ 
              ",fecha=?"+ 
              ",hora=?"+ 
              ",oid_grupo_imp_exc=?"+ 
              ",nro_lote=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_log_sincro=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_SINCRO,pers.getOID());
    qUpdate.setInt(OID_DISP_MOVIL,pers.getDisp_movil().getOID());
    qUpdate.setDate(FECHA,new java.sql.Date(pers.getFecha().getTime()));
    qUpdate.setString(HORA,pers.getHora());
    qUpdate.setInt(OID_GRUPO_IMP_EXC,pers.getGrupo_imp_exc().getOID());
    qUpdate.setInt(NRO_LOTE,pers.getNro_lote().intValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_SINCRO = 1; 
    LogSincroExcluido pers = (LogSincroExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excLogsSincro "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_log_sincro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_SINCRO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_LOG_SINCRO = 1; 
    LogSincroExcluido pers = (LogSincroExcluido) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update excLogsSincro "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_log_sincro=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_LOG_SINCRO, pers.getOID()); 
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
      case SELECT_LOGS_ULT_30_DIAS: {
          ps = this.selectAllUlt30Dias(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_LOG_SINCRO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excLogsSincro "); 
    textSQL.append(" WHERE oid_log_sincro = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_LOG_SINCRO, oid); 
    return querySelect; 
  }

  
  private PreparedStatement selectAllUlt30Dias(Object aCondiciones) throws BaseException, SQLException { 

	    java.util.Date fecDesde = UtilCIP.getFechaHoraActual(this.getSesion());
	    fecDesde = Fecha.getFechaMasDias(fecDesde, -30);
	    
	    DispMovilExc dispMovil = (DispMovilExc) aCondiciones;

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  excLogsSincro "); 
	    textSQL.append(" WHERE fecha >= ? and oid_disp_movil = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    querySelect.setDate(1, new java.sql.Date(fecDesde.getTime()));
	    querySelect.setInt(2, dispMovil.getOID());
	    
	    return querySelect; 
	  }
  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  excLogsSincro "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_log_sincro oid, codigo,  descripcion ,activo ");
    textSQL.append(" from excLogsSincro");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getLogsSincUlt30Dias(
		  DispMovilExc dispositivo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(LogSincroExcluido.NICKNAME,
             DBLogSincroExcluido.SELECT_LOGS_ULT_30_DIAS,
             dispositivo,
             new ListObserver(),
             aSesion);
  }
  
  
} 
