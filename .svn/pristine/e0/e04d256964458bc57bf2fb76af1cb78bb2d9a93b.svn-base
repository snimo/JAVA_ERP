package com.srn.erp.reclutamiento.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodoIncDet;
import com.srn.erp.reclutamiento.bm.RecluEstCandidatoBusq;
import com.srn.erp.reclutamiento.bm.RecluWarnEstBusqCandi;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBRecluWarnEstBusqCandi extends DBObjetoPersistente {

  public static final String OID_WARN_EST_CAND = "oid_warn_est_cand";
  public static final String OID_EST_CAND_BUSQ = "oid_est_cand_busq";
  public static final String OID_EST_PROC_SEL = "oid_est_proc_sel";
  public static final String ACTIVO = "activo";
  
  private static final int SELECT_BY_EST_CAND_BUSQ = 100;

  public DBRecluWarnEstBusqCandi() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_WARN_EST_CAND = 1;
    final int OID_EST_CAND_BUSQ = 2;
    final int OID_EST_PROC_SEL = 3;
    final int ACTIVO = 4;

    RecluWarnEstBusqCandi pers = (RecluWarnEstBusqCandi) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rsWarnEstCand "+
                     " ( "+
                      "OID_WARN_EST_CAND,"+
                      "OID_EST_CAND_BUSQ,"+
                      "OID_EST_PROC_SEL,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_WARN_EST_CAND,pers.getOID());
    qInsert.setInt(OID_EST_CAND_BUSQ,pers.getEstado_busqueda().getOID());
    qInsert.setInt(OID_EST_PROC_SEL,pers.getEstado_proceso().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EST_CAND_BUSQ = 1;
    final int OID_EST_PROC_SEL = 2;
    final int ACTIVO = 3;
    final int OID_WARN_EST_CAND = 4;

    RecluWarnEstBusqCandi pers = (RecluWarnEstBusqCandi) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rsWarnEstCand set "+
              "oid_est_cand_busq=?"+ 
              ",oid_est_proc_sel=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_warn_est_cand=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_WARN_EST_CAND,pers.getOID());
    qUpdate.setInt(OID_EST_CAND_BUSQ,pers.getEstado_busqueda().getOID());
    qUpdate.setInt(OID_EST_PROC_SEL,pers.getEstado_proceso().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_WARN_EST_CAND = 1; 
    RecluWarnEstBusqCandi pers = (RecluWarnEstBusqCandi) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsWarnEstCand "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_warn_est_cand=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_WARN_EST_CAND, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_WARN_EST_CAND = 1; 
    RecluWarnEstBusqCandi pers = (RecluWarnEstBusqCandi) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rsWarnEstCand "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_warn_est_cand=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_WARN_EST_CAND, pers.getOID()); 
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
      case SELECT_BY_EST_CAND_BUSQ: {
          ps = this.selectByEstCandBusq(aCondiciones); 
          break;    	  
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_WARN_EST_CAND = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsWarnEstCand "); 
    textSQL.append(" WHERE oid_warn_est_cand = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_WARN_EST_CAND, oid); 
    return querySelect; 
  }
  
  private PreparedStatement selectByEstCandBusq(Object aCondiciones) throws BaseException, SQLException { 

	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rsWarnEstCand "); 
	    textSQL.append(" WHERE oid_est_cand_busq = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    RecluEstCandidatoBusq estadoCandidatoBusq = (RecluEstCandidatoBusq) aCondiciones; 
	    querySelect.setInt(1, estadoCandidatoBusq.getOID()); 
	    return querySelect; 
	  }  
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rsWarnEstCand "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_warn_est_cand oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rsWarnEstCand");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getWarnEstBusqCandi(RecluEstCandidatoBusq estadoBusqCandi,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(RecluWarnEstBusqCandi.NICKNAME,
             DBRecluWarnEstBusqCandi.SELECT_BY_EST_CAND_BUSQ,
             estadoBusqCandi,
             new ListObserver(),
             aSesion);
  }  
  
} 
