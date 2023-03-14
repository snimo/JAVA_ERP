package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.rrhh.bm.CondModEvalCab;
import com.srn.erp.rrhh.bm.ModeloEvalCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;

public class DBCondModEvalCab extends DBObjetoPersistente {

  public static final String OID_COND_MOD = "oid_cond_mod";
  public static final String OID_MOD_EVAL_CAB = "oid_mod_eval_cab";
  public static final String ORDEN = "orden";
  public static final String CONDICION = "condicion";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_MODELO_EVAL_CAB = 100;

  public DBCondModEvalCab() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_COND_MOD = 1;
    final int OID_MOD_EVAL_CAB = 2;
    final int ORDEN = 3;
    final int CONDICION = 4;
    final int ACTIVO = 5;

    CondModEvalCab pers = (CondModEvalCab) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhCondModEval "+
                     " ( "+
                      "OID_COND_MOD,"+
                      "OID_MOD_EVAL_CAB,"+
                      "ORDEN,"+
                      "CONDICION,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_COND_MOD,pers.getOID());
    qInsert.setInt(OID_MOD_EVAL_CAB,pers.getModelo_eval_cab().getOID());
    qInsert.setInt(ORDEN,pers.getOrden().intValue());
    qInsert.setString(CONDICION,pers.getCondicion());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_MOD_EVAL_CAB = 1;
    final int ORDEN = 2;
    final int CONDICION = 3;
    final int ACTIVO = 4;
    final int OID_COND_MOD = 5;

    CondModEvalCab pers = (CondModEvalCab) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhCondModEval set "+
              "oid_mod_eval_cab=?"+ 
              ",orden=?"+ 
              ",condicion=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_cond_mod=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COND_MOD,pers.getOID());
    qUpdate.setInt(OID_MOD_EVAL_CAB,pers.getModelo_eval_cab().getOID());
    qUpdate.setInt(ORDEN,pers.getOrden().intValue());
    qUpdate.setString(CONDICION,pers.getCondicion());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COND_MOD = 1; 
    CondModEvalCab pers = (CondModEvalCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhCondModEval "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_cond_mod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COND_MOD, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_COND_MOD = 1; 
    CondModEvalCab pers = (CondModEvalCab) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhCondModEval "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_cond_mod=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_COND_MOD, pers.getOID()); 
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
      case SELECT_BY_MODELO_EVAL_CAB: {
          ps = this.selectByModeloEval(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_COND_MOD = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhCondModEval "); 
    textSQL.append(" WHERE oid_cond_mod = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_COND_MOD, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByModeloEval(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhCondModEval "); 
	    textSQL.append(" WHERE oid_mod_eval_cab = ? and activo = 1 order by orden ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    ModeloEvalCab modelo = (ModeloEvalCab) aCondiciones; 
	    querySelect.setInt(1, modelo.getOID()); 
	    return querySelect; 
  }
  
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhCondModEval "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_cond_mod oid, codigo, oid_mod_eval_cab descripcion ,activo ");
    textSQL.append(" from rhCondModEval");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  } 
  
  public static List getCondiciones(ModeloEvalCab modelo,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(CondModEvalCab.NICKNAME,
             DBCondModEvalCab.SELECT_BY_MODELO_EVAL_CAB,
             modelo,
             new ListObserver(),
             aSesion);
  }
  
  
} 
