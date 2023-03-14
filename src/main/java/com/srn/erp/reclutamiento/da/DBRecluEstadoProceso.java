package com.srn.erp.reclutamiento.da;

import java.sql.*;
import com.srn.erp.reclutamiento.bm.*;
import framework.applicarionServer.bl.Persistencia.*;
import framework.request.bl.Utils.*;

public class DBRecluEstadoProceso extends DBObjetoPersistente {

  public static final String OID_EST_PROC_SEL = "oid_est_proc_sel";
  public static final String CODIGO = "codigo";
  public static final String DESCRIPCION = "descripcion";
  public static final String INICIAR_PROX_PROC = "iniciar_prox_proc";
  public static final String FEC_PLANIF_OBLIG = "fec_planif_oblig";
  public static final String ACTIVO = "activo";

  public DBRecluEstadoProceso() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EST_PROC_SEL = 1;
    final int CODIGO = 2;
    final int DESCRIPCION = 3;
    final int INICIAR_PROX_PROC = 4;
    final int ACTIVO = 5;
    final int FEC_PLANIF_OBLIG = 6;

    RecluEstadoProceso pers = (RecluEstadoProceso) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsEstadoProcSelec "+
                     " ( "+
                      "OID_EST_PROC_SEL,"+
                      "CODIGO,"+
                      "DESCRIPCION,"+
                      "INICIAR_PROX_PROC,"+
                      "ACTIVO,"
                      + "FEC_PLANIF_OBLIG)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EST_PROC_SEL,pers.getOID());
    qInsert.setString(CODIGO,pers.getCodigo());
    qInsert.setString(DESCRIPCION,pers.getDescripcion());
    qInsert.setBoolean(INICIAR_PROX_PROC,pers.isIniciar_prox_proc().booleanValue());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isFecPlanifOblig()!=null)
    	qInsert.setBoolean(FEC_PLANIF_OBLIG,pers.isFecPlanifOblig());
    else
    	qInsert.setBoolean(FEC_PLANIF_OBLIG,false);
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int CODIGO = 1;
    final int DESCRIPCION = 2;
    final int INICIAR_PROX_PROC = 3;
    final int ACTIVO = 4;
    final int FEC_PLANIF_OBLIG = 5;
    final int OID_EST_PROC_SEL = 6;

    RecluEstadoProceso pers = (RecluEstadoProceso) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsEstadoProcSelec set "+
              "codigo=?"+ 
              ",descripcion=?"+ 
              ",iniciar_prox_proc=?"+ 
              ",activo=?"+ 
              ",fec_planif_oblig=?"+
                 " where " +
                 " oid_est_proc_sel=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_PROC_SEL,pers.getOID());
    qUpdate.setString(CODIGO,pers.getCodigo());
    qUpdate.setString(DESCRIPCION,pers.getDescripcion());
    qUpdate.setBoolean(INICIAR_PROX_PROC,pers.isIniciar_prox_proc().booleanValue());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    if (pers.isFecPlanifOblig()!=null)
    	qUpdate.setBoolean(FEC_PLANIF_OBLIG,pers.isFecPlanifOblig());
    else
    	qUpdate.setBoolean(FEC_PLANIF_OBLIG,false);    
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_PROC_SEL = 1; 
    RecluEstadoProceso pers = (RecluEstadoProceso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsEstadoProcSelec "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_est_proc_sel=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_PROC_SEL, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EST_PROC_SEL = 1; 
    RecluEstadoProceso pers = (RecluEstadoProceso) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsEstadoProcSelec "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_est_proc_sel=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EST_PROC_SEL, pers.getOID()); 
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

    final int OID_EST_PROC_SEL = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsEstadoProcSelec "); 
    textSQL.append(" WHERE oid_est_proc_sel = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EST_PROC_SEL, oid); 
    return querySelect; 
  }
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsEstadoProcSelec "); 
    textSQL.append(" WHERE codigo = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_est_proc_sel oid,codigo codigo, descripcion descripcion ,activo ");
    textSQL.append(" from rsEstadoProcSelec");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
} 
