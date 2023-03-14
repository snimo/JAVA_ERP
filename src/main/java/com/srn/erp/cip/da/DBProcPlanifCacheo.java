package com.srn.erp.cip.da;

import java.sql.*;
import com.srn.erp.cip.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBProcPlanifCacheo extends DBObjetoPersistente {

  public static final String OID_PROC_PLANIF = "oid_proc_planif";
  public static final String FEC_PROCESO = "fec_proceso";
  public static final String TIPO = "tipo";
  public static final String OID_USU = "oid_usu";
  public static final String FEC_DESDE = "fec_desde";
  public static final String FEC_HASTA = "fec_hasta";
  public static final String ACTIVO = "activo";

  public DBProcPlanifCacheo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROC_PLANIF = 1;
    final int FEC_PROCESO = 2;
    final int TIPO = 3;
    final int OID_USU = 4;
    final int FEC_DESDE = 5;
    final int FEC_HASTA = 6;
    final int ACTIVO = 7;

    ProcPlanifCacheo pers = (ProcPlanifCacheo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipProcPlanifCach "+
                     " ( "+
                      "OID_PROC_PLANIF,"+
                      "FEC_PROCESO,"+
                      "TIPO,"+
                      "OID_USU,"+
                      "FEC_DESDE,"+
                      "FEC_HASTA,"+
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
    qInsert.setInt(OID_PROC_PLANIF,pers.getOID());
    qInsert.setDate(FEC_PROCESO,new java.sql.Date(pers.getFec_proceso().getTime()));
    qInsert.setString(TIPO,pers.getTipo());
    qInsert.setInt(OID_USU,pers.getUsuario().getOID());
    qInsert.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qInsert.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int FEC_PROCESO = 1;
    final int TIPO = 2;
    final int OID_USU = 3;
    final int FEC_DESDE = 4;
    final int FEC_HASTA = 5;
    final int ACTIVO = 6;
    final int OID_PROC_PLANIF = 7;

    ProcPlanifCacheo pers = (ProcPlanifCacheo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipProcPlanifCach set "+
              "fec_proceso=?"+ 
              ",tipo=?"+ 
              ",oid_usu=?"+ 
              ",fec_desde=?"+ 
              ",fec_hasta=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_proc_planif=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_PLANIF,pers.getOID());
    qUpdate.setDate(FEC_PROCESO,new java.sql.Date(pers.getFec_proceso().getTime()));
    qUpdate.setString(TIPO,pers.getTipo());
    qUpdate.setInt(OID_USU,pers.getUsuario().getOID());
    qUpdate.setDate(FEC_DESDE,new java.sql.Date(pers.getFec_desde().getTime()));
    qUpdate.setDate(FEC_HASTA,new java.sql.Date(pers.getFec_hasta().getTime()));
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROC_PLANIF = 1; 
    ProcPlanifCacheo pers = (ProcPlanifCacheo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipProcPlanifCach "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_proc_planif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_PLANIF, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROC_PLANIF = 1; 
    ProcPlanifCacheo pers = (ProcPlanifCacheo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipProcPlanifCach "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_proc_planif=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROC_PLANIF, pers.getOID()); 
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
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROC_PLANIF = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipProcPlanifCach "); 
    textSQL.append(" WHERE oid_proc_planif = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROC_PLANIF, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipProcPlanifCach "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_proc_planif oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipProcPlanifCach");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
