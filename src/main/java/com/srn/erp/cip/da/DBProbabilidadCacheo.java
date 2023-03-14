package com.srn.erp.cip.da;

import java.sql.*;
import java.util.List;

import com.srn.erp.cip.bm.*;
import com.srn.erp.general.bm.Periodo;
import com.srn.erp.general.bm.PeriodoInc;
import com.srn.erp.general.bm.PeriodoIncDet;
import com.srn.erp.general.da.DBPeriodo;
import com.srn.erp.general.da.DBPeriodoIncDet;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.*;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.*;

public class DBProbabilidadCacheo extends DBObjetoPersistente {

  public static final String OID_PROB_CACHEO = "oid_prob_cacheo";
  public static final String OID_ALGO_CACHEO = "oid_algo_cacheo";
  public static final String OID_ROTA = "oid_rota";
  public static final String PORC_ENT = "porc_ent";
  public static final String PROB_CACH_ENT = "prob_cach_ent";
  public static final String PORC_SAL = "porc_sal";
  public static final String PROB_CACH_SAL = "prob_cach_sal";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_PROB_CACHEO = 100;
  public static final int SELECT_BY_PROB_CACHEO_ROTA = 101;
  

  public DBProbabilidadCacheo() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_PROB_CACHEO = 1;
    final int OID_ALGO_CACHEO = 2;
    final int OID_ROTA = 3;
    final int PORC_ENT = 4;
    final int PROB_CACH_ENT = 5;
    final int PORC_SAL = 6;
    final int PROB_CACH_SAL = 7;
    final int ACTIVO = 8;

    ProbabilidadCacheo pers = (ProbabilidadCacheo) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into cipProbCacheo "+
                     " ( "+
                      "OID_PROB_CACHEO,"+
                      "OID_ALGO_CACHEO,"+
                      "OID_ROTA,"+
                      "PORC_ENT,"+
                      "PROB_CACH_ENT,"+
                      "PORC_SAL,"+
                      "PROB_CACH_SAL,"+
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
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_PROB_CACHEO,pers.getOID());
    qInsert.setInt(OID_ALGO_CACHEO,pers.getAlgoritmo_cacheo().getOID());
    qInsert.setInt(OID_ROTA,pers.getRota().getOID());
    if (pers.getPorc_ent()!=null)
    	qInsert.setDouble(PORC_ENT,pers.getPorc_ent().doubleValue());
    else
    	qInsert.setDouble(PORC_ENT,0);
    if (pers.getProb_cacheo_ent()!=null)
    	qInsert.setDouble(PROB_CACH_ENT,pers.getProb_cacheo_ent().doubleValue());
    else
    	qInsert.setDouble(PROB_CACH_ENT,0);
    if (pers.getPorc_sal()!=null)
    	qInsert.setDouble(PORC_SAL,pers.getPorc_sal().doubleValue());
    else
    	qInsert.setDouble(PORC_SAL,0);
    if (pers.getProb_cacheo_sal()!=null)
    	qInsert.setDouble(PROB_CACH_SAL,pers.getProb_cacheo_sal().doubleValue());
    else
    	qInsert.setDouble(PROB_CACH_SAL,0);
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_ALGO_CACHEO = 1;
    final int OID_ROTA = 2;
    final int PORC_ENT = 3;
    final int PROB_CACH_ENT = 4;
    final int PORC_SAL = 5;
    final int PROB_CACH_SAL = 6;
    final int ACTIVO = 7;
    final int OID_PROB_CACHEO = 8;

    ProbabilidadCacheo pers = (ProbabilidadCacheo) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update cipProbCacheo set "+
              "oid_algo_cacheo=?"+ 
              ",oid_rota=?"+ 
              ",porc_ent=?"+ 
              ",prob_cach_ent=?"+ 
              ",porc_sal=?"+ 
              ",prob_cach_sal=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_prob_cacheo=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROB_CACHEO,pers.getOID());
    qUpdate.setInt(OID_ALGO_CACHEO,pers.getAlgoritmo_cacheo().getOID());
    qUpdate.setInt(OID_ROTA,pers.getRota().getOID());
    if (pers.getPorc_ent()!= null)
    	qUpdate.setDouble(PORC_ENT,pers.getPorc_ent().doubleValue());
    else
    	qUpdate.setDouble(PORC_ENT,0);
    if (pers.getProb_cacheo_ent()!=null)
    	qUpdate.setDouble(PROB_CACH_ENT,pers.getProb_cacheo_ent().doubleValue());
    else
    	qUpdate.setDouble(PROB_CACH_ENT,0);
    if (pers.getPorc_sal()!=null)
    	qUpdate.setDouble(PORC_SAL,pers.getPorc_sal().doubleValue());
    else
    	qUpdate.setDouble(PORC_SAL,0);
    if (pers.getProb_cacheo_sal()!=null)
    	qUpdate.setDouble(PROB_CACH_SAL,pers.getProb_cacheo_sal().doubleValue());
    else
    	qUpdate.setDouble(PROB_CACH_SAL,0);
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROB_CACHEO = 1; 
    ProbabilidadCacheo pers = (ProbabilidadCacheo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipProbCacheo "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_prob_cacheo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROB_CACHEO, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_PROB_CACHEO = 1; 
    ProbabilidadCacheo pers = (ProbabilidadCacheo) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update cipProbCacheo "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_prob_cacheo=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_PROB_CACHEO, pers.getOID()); 
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
      case SELECT_BY_PROB_CACHEO: {
          ps = this.selectByProbCacheo(aCondiciones); 
          break; 
      }
      case SELECT_BY_PROB_CACHEO_ROTA: {
          ps = this.selectByCacheoRota(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_PROB_CACHEO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipProbCacheo "); 
    textSQL.append(" WHERE oid_prob_cacheo = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_PROB_CACHEO, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByProbCacheo(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  cipProbCacheo "); 
	    textSQL.append(" WHERE oid_algo_cacheo = ? and activo=1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    AlgoritmoCacheo algoritmoCacheo = (AlgoritmoCacheo) aCondiciones; 
	    querySelect.setInt(1, algoritmoCacheo.getOID()); 
	    return querySelect; 
  }
  

  private PreparedStatement selectByCacheoRota(Object aCondiciones) throws BaseException, SQLException { 

	  StringBuffer textSQL = new StringBuffer(); 
	  textSQL.append("SELECT * FROM  cipProbCacheo "); 
	  textSQL.append(" WHERE oid_algo_cacheo = ? and oid_rota = ? and activo=1 ");
	  PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    
	  HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	  AlgoritmoCacheo algoritmoCacheo = (AlgoritmoCacheo) condiciones.get(AlgoritmoCacheo.NICKNAME);
	  Rota rota = (Rota) condiciones.get(Rota.NICKNAME);
	  querySelect.setInt(1, algoritmoCacheo.getOID()); 
	  querySelect.setInt(2, rota.getOID());
	  return querySelect; 
	    
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  cipProbCacheo "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_prob_cacheo oid, codigo,  descripcion ,activo ");
    textSQL.append(" from cipProbCacheo");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getProbabilidadesCacheos(AlgoritmoCacheo algoritmo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(ProbabilidadCacheo.NICKNAME,
             DBProbabilidadCacheo.SELECT_BY_PROB_CACHEO,
             algoritmo,
             new ListObserver(),
             aSesion);
  }
  
  public static ProbabilidadCacheo getProbabilidadCacheo(
		  AlgoritmoCacheo algoritmo,
		  Rota rota,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(AlgoritmoCacheo.NICKNAME, algoritmo);
	  condiciones.put(Rota.NICKNAME, rota);
	  return (ProbabilidadCacheo) ObjetoLogico.getObjects(ProbabilidadCacheo.NICKNAME,
			  				DBProbabilidadCacheo.SELECT_BY_PROB_CACHEO_ROTA,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
