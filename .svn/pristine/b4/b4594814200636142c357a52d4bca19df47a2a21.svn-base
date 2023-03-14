package com.srn.erp.rrhh.da;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.srn.erp.general.bm.ClasificadorEntidad;
import com.srn.erp.rrhh.bm.EvalValClasifLeg;
import com.srn.erp.rrhh.bm.EvaluacionLegajoCab;

import framework.applicarionServer.bl.ObjetosAplicacion.ObjetoLogico;
import framework.applicarionServer.bl.Persistencia.DBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IDBObjetoPersistente;
import framework.applicarionServer.bl.Persistencia.IObjetoPersistente;
import framework.applicarionServer.bl.Sesion.ISesion;
import framework.applicarionServer.bl.Utils.ListObserver;
import framework.request.bl.Utils.BaseException;
import framework.request.bl.Utils.HashTableDatos;
import framework.request.bl.Utils.ObjetoObservado;

public class DBEvalValClasifLeg extends DBObjetoPersistente {

  public static final String OID_EVAL_VAL_CLA = "oid_eval_val_cla";
  public static final String OID_EVAL_CAB = "oid_eval_cab";
  public static final String OID_CLASIFICADOR = "oid_clasificador";
  public static final String OID_VAL_CLASIF = "oid_val_clasif";
  public static final String ACTIVO = "activo";
  
  public static final int SELECT_BY_EVALUACION = 100;
  public static final int SELECT_BY_EVAL_CLASIF = 101;

  public DBEvalValClasifLeg() { 
  }

  protected void insert(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_VAL_CLA = 1;
    final int OID_EVAL_CAB = 2;
    final int OID_CLASIFICADOR = 3;
    final int OID_VAL_CLASIF = 4;
    final int ACTIVO = 5;

    EvalValClasifLeg pers = (EvalValClasifLeg) objetoPersistente;
    
    StringBuffer sqlInsert = new StringBuffer();
    sqlInsert.append(" insert into rhEvalValClasif "+
                     " ( "+
                      "OID_EVAL_VAL_CLA,"+
                      "OID_EVAL_CAB,"+
                      "OID_CLASIFICADOR,"+
                      "OID_VAL_CLASIF,"+
                      "ACTIVO)"+ 
                      " values "+ 
                      "("+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?,"+
                      "?) ");

    PreparedStatement qInsert = getSesion().getConexionBD().prepareStatement(sqlInsert.toString()); 
    qInsert.setInt(OID_EVAL_VAL_CLA,pers.getOID());
    qInsert.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qInsert.setInt(OID_CLASIFICADOR,pers.getClasificador().getOID());
    qInsert.setInt(OID_VAL_CLASIF,pers.getValor_clasificador().getOID());
    qInsert.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qInsert.executeUpdate();
    qInsert.close();
  }


  protected void update(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 

    final int OID_EVAL_CAB = 1;
    final int OID_CLASIFICADOR = 2;
    final int OID_VAL_CLASIF = 3;
    final int ACTIVO = 4;
    final int OID_EVAL_VAL_CLA = 5;

    EvalValClasifLeg pers = (EvalValClasifLeg) objetoPersistente;
    
    StringBuffer sqlUpdate= new StringBuffer();
    sqlUpdate.append(" update rhEvalValClasif set "+
              "oid_eval_cab=?"+ 
              ",oid_clasificador=?"+ 
              ",oid_val_clasif=?"+ 
              ",activo=?"+ 
                 " where " +
                 " oid_eval_val_cla=? ");

    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_VAL_CLA,pers.getOID());
    qUpdate.setInt(OID_EVAL_CAB,pers.getEvaluacion().getOID());
    qUpdate.setInt(OID_CLASIFICADOR,pers.getClasificador().getOID());
    qUpdate.setInt(OID_VAL_CLASIF,pers.getValor_clasificador().getOID());
    qUpdate.setBoolean(ACTIVO,pers.isActivo().booleanValue());
    qUpdate.executeUpdate(); 
    qUpdate.close();
  }

  protected void delete(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_VAL_CLA = 1; 
    EvalValClasifLeg pers = (EvalValClasifLeg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalValClasif "+
                     " set activo=0 " + 
                     " where " + 
                     " oid_eval_val_cla=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_VAL_CLA, pers.getOID()); 
    qUpdate.executeUpdate();
    qUpdate.close();
  } 

  protected void rehabilitar(IObjetoPersistente objetoPersistente) throws BaseException, SQLException { 
    final int OID_EVAL_VAL_CLA = 1; 
    EvalValClasifLeg pers = (EvalValClasifLeg) objetoPersistente;
    StringBuffer sqlUpdate = new StringBuffer(); 
    sqlUpdate.append("update rhEvalValClasif "+
                     " set activo=1 " + 
                     " where " + 
                     " oid_eval_val_cla=? ");
    PreparedStatement qUpdate = getSesion().getConexionBD().prepareStatement(sqlUpdate.toString()); 
    qUpdate.setInt(OID_EVAL_VAL_CLA, pers.getOID()); 
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
      case SELECT_BY_EVALUACION: {
          ps = this.selectByEvaluacion(aCondiciones); 
          break; 
      }
      case SELECT_BY_EVAL_CLASIF: {
          ps = this.selectByEvalClasif(aCondiciones); 
          break; 
      }
    } 
    return ps;
  } 

  private PreparedStatement selectByOID(Object aCondiciones) throws BaseException, SQLException { 

    final int OID_EVAL_VAL_CLA = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalValClasif "); 
    textSQL.append(" WHERE oid_eval_val_cla = ? "); 
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    int oid = ( (Integer) aCondiciones).intValue(); 
    querySelect.setInt(OID_EVAL_VAL_CLA, oid); 
    return querySelect; 
  }

  private PreparedStatement selectByEvalClasif(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM rhEvalValClasif "); 
	    textSQL.append(" WHERE oid_eval_cab = ? and activo = 1 and oid_clasificador = ? ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString());
	    HashTableDatos condiciones = (HashTableDatos) aCondiciones;
	    EvaluacionLegajoCab evaluacion = (EvaluacionLegajoCab) condiciones.get(EvaluacionLegajoCab.NICKNAME);
	    ClasificadorEntidad clasifEnt = (ClasificadorEntidad) condiciones.get(ClasificadorEntidad.NICKNAME);
	    querySelect.setInt(1, evaluacion.getOID()); 
	    querySelect.setInt(2, clasifEnt.getOID());
	    return querySelect; 
  }

  private PreparedStatement selectByEvaluacion(Object aCondiciones) throws BaseException, SQLException { 
	    StringBuffer textSQL = new StringBuffer(); 
	    textSQL.append("SELECT * FROM  rhEvalValClasif "); 
	    textSQL.append(" WHERE oid_eval_cab = ? and activo = 1 ");
	    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
	    EvaluacionLegajoCab evaluacion = (EvaluacionLegajoCab) aCondiciones; 
	    querySelect.setInt(1, evaluacion.getOID()); 
	    return querySelect; 
  }
  
  private PreparedStatement selectByCodigo(Object aCondiciones) throws BaseException, SQLException { 

    final int CODIGO = 1; 

    StringBuffer textSQL = new StringBuffer(); 
    textSQL.append("SELECT * FROM  rhEvalValClasif "); 
    textSQL.append(" WHERE  = ? ");
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    String codigo = (String) aCondiciones; 
    querySelect.setString(CODIGO, codigo); 
    return querySelect; 
  }

  private PreparedStatement selectAllHelp(Object aCondiciones) throws BaseException, SQLException {

    StringBuffer textSQL = new StringBuffer();

    textSQL.append("SELECT oid_eval_val_cla oid, codigo,  descripcion ,activo ");
    textSQL.append(" from rhEvalValClasif");
    
    PreparedStatement querySelect = getSesion().getConexionBD().prepareStatement(textSQL.toString()); 
    return querySelect; 
  }
  
  public static List getEvalValoresClasif(EvaluacionLegajoCab evaluacion,
          ISesion aSesion) throws BaseException {
	  return (List) ObjetoLogico.getObjects(EvalValClasifLeg.NICKNAME,
             DBEvalValClasifLeg.SELECT_BY_EVALUACION,
             evaluacion,
             new ListObserver(),
             aSesion);
  }
  
  public static EvalValClasifLeg getEvalValClasifLeg(
		  EvaluacionLegajoCab evaluacion,
		  ClasificadorEntidad clasificador,
          ISesion aSesion)
          throws BaseException {
	  HashTableDatos condiciones = new HashTableDatos();
	  condiciones.put(EvaluacionLegajoCab.NICKNAME, evaluacion);
	  condiciones.put(ClasificadorEntidad.NICKNAME, clasificador);
	  return (EvalValClasifLeg) ObjetoLogico.getObjects(EvalValClasifLeg.NICKNAME,
			  				DBEvalValClasifLeg.SELECT_BY_EVAL_CLASIF,
			  				condiciones,
			  				new ObjetoObservado(),
			  				aSesion);
  }
  
  
  
} 
